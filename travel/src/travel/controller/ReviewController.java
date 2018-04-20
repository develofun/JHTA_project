package travel.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import travel.dao.MarketCommentDAO;
import travel.dao.ReviewDAO;
import travel.dto.MarketCommentDTO;
import travel.dto.ReviewDTO;
import travel.dto.Review_CommentDTO;
import travel.dto.Review_ImageDTO;

@WebServlet("/review.do")
public class ReviewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("review_read")){
			review_read(request,response);
		}else if(cmd.equals("detail") || cmd.equals("review_detail_to_update")){
			detail(request,response,cmd);
		}else if(cmd.equals("review_create_page")){
			request.setAttribute("menuNum","40");
			request.setAttribute("cpage", "/layout/detail_login.jsp");	
			request.setAttribute("spage", "/board_review/review_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}else if(cmd.equals("create")){
			create(request,response);
		}else if(cmd.equals("review_delete")){
			review_delete(request,response);
		}else if(cmd.equals("review_update")){
			review_update(request,response);
		}else if(cmd.equals("review_search")){
			review_search(request,response);
		}else if(cmd.equals("review_comment_create")){
			review_comment_create(request, response);
		}else if(cmd.equals("review_comment_read")){
			review_comment_read(request, response);
		}else if(cmd.equals("hit_top10")){
			hit_top10(request,response);
		}else if(cmd.endsWith("comment_top10")){
			comment_top10(request,response);
		}
	}
	//댓글 리스트 추출
	private void review_comment_read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int review_num=Integer.parseInt(request.getParameter("review_num"));
		ReviewDAO dao=ReviewDAO.getInstance();
		//System.out.println(review_num); //자유게시판 글번호
		ArrayList<Review_CommentDTO> list=dao.review_comment_read(review_num); //전체 목록을 받아오고
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<list>");
		for(Review_CommentDTO dto:list){
			pw.println("<data>");
			pw.println("<review_comment_writer>"+dto.getReview_comment_writer()+"</review_comment_writer>");
			pw.println("<review_comment_content>"+dto.getReview_comment_content()+"</review_comment_content>");
			pw.println("<review_comment_w_date>"+dto.getReview_comment_w_date()+"</review_comment_w_date>");
			pw.println("</data>");
		}
		pw.println("</list>");
		pw.close();
	}
	//댓글 작성
	private void review_comment_create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int review_num=Integer.parseInt(request.getParameter("review_num"));
		HttpSession session=request.getSession();
		String review_comment_writer=(String)session.getAttribute("member_nickname");
		String review_comment_content=request.getParameter("review_comment_content");
		/*게시판번호, 작성자, 내용 정상출력
		System.out.println(review_num);
		System.out.println(review_comment_writer);
		System.out.println(review_comment_content);
		*/
		int review_comment_num=0;
		int lev=0;
		int step=0;
		ReviewDAO dao=ReviewDAO.getInstance();
		Review_CommentDTO dto=new Review_CommentDTO(review_num, review_comment_num, review_comment_writer, review_comment_content, null, lev, step);
		int n=dao.review_comment_create(dto);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<create>");		
		if(n>0){
			pw.print("<result>success</result>");
		}else{
			pw.print("<result>failed</result>");
		}
		pw.println("</create>");
		pw.close();
	}
	//게시물 상세보기
	protected void detail(HttpServletRequest request, HttpServletResponse response, String cmd) throws ServletException, IOException {
		int review_num=Integer.parseInt(request.getParameter("review_num"));
		//System.out.println("게시글 번호:"+review_num);
		ReviewDAO dao=new ReviewDAO();
		ReviewDTO dto=dao.detail(review_num);
		Review_ImageDTO dto1=dao.image(review_num);
		if(cmd.equals("detail")){
			request.setAttribute("spage", "/board_review/review_detail.jsp");
		}else{
			request.setAttribute("spage", "/board_review/review_update.jsp");
		}
		request.setAttribute("dto", dto); //얻어온 텍스트 정보
		request.setAttribute("dto1", dto1); //얻어온 이미지 정보
		request.setAttribute("menuNum","40");
		request.setAttribute("cpage", "/layout/detail_login.jsp");	
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	// 게시판 리스트 불러오기
	private void review_read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spageNum=request.getParameter("pageNum"); 
		String rowCountStr=request.getParameter("rowCount");
		int rowCount=0;
		
		int pageNum=1; //1페이지 보여주기
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}
		
		if(rowCountStr==null){
			rowCount=10;
		}else{
			rowCount=Integer.parseInt(rowCountStr);
		}
		int startRow=1+(pageNum-1)*rowCount;
		int endRow=pageNum*rowCount;	
		
		ReviewDAO dao=ReviewDAO.getInstance();
		
		int pageCount=(int)Math.ceil(dao.getCountAll()/(double)rowCount); 
		int startPage=1+(pageNum-1)/10*10;
		int endPage=startPage+9;
		if(endPage>pageCount)endPage=pageCount;
		
		ArrayList<ReviewDTO> list=dao.review_read(startRow, endRow);
		//ArrayList<ReviewDTO> list1=dao.comment_top10();
		//request.setAttribute("list1", list1);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("menuNum","40");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_review/review_read.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);	
	}
	// 조회순 top 10개 불러오기
	private void hit_top10(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO dao=ReviewDAO.getInstance();
		ArrayList<ReviewDTO> list=dao.hit_top10();
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<list>");
		for(int i=0;i<list.size();i++){
			ReviewDTO dto=list.get(i);
			pw.println("<data>");
			pw.println("<review_num>" + dto.getReview_num() + "</review_num>");
			pw.println("<title>" + dto.getReview_title()+ "</title>");
			//System.out.println(dto.getReview_title()); 출력잘됨
			pw.println("</data>");
		}
		pw.println("</list>");
		pw.close();
	}
	// 댓글 top 10개 불러오기
	private void comment_top10(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO dao=ReviewDAO.getInstance();
		ArrayList<ReviewDTO> list=dao.comment_top10();
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<list>");
		for(int i=0;i<list.size();i++){
			ReviewDTO dto=list.get(i);
			pw.println("<data>");
			pw.println("<review_num>" + dto.getReview_num() + "</review_num>");
			pw.println("<title>" + dto.getReview_title()+ "</title>");
			pw.println("</data>");
			//System.out.println(dto.getReview_num()+"  "+dto.getReview_title());
		}
		pw.println("</list>");
		pw.close();
	}
	// 게시글 작성
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath=request.getServletContext().getRealPath("/review_image");
		//System.out.println(uploadPath); 실제저장 폴더
		
		MultipartRequest mr=new MultipartRequest(
				request, 
				uploadPath, 
				1024*1024*5,
				"utf-8", 
				new DefaultFileRenamePolicy()//동일한 파일명이 존재시 파일끝에 숫자붙이기
			);
		//세션얻어와서 작성자에 회원번호 보내기
		HttpSession session=request.getSession();
		
		String customer_num=(String)session.getAttribute("customer_num");
		String review_writer=(String)session.getAttribute("member_nickname");

		String review_category=mr.getParameter("review_category");
		String review_title=mr.getParameter("review_title");
		String review_content=mr.getParameter("review_content");
		ReviewDTO dto=new ReviewDTO(0, customer_num, review_category, review_title, review_content, 0, null, review_writer);
		ReviewDAO dao=ReviewDAO.getInstance();
		int n=dao.create(dto);
		if(n>0){
			String review_image_original_name=mr.getOriginalFileName("review_file1");
			String review_image_name=mr.getFilesystemName("review_file1");
			File f=new File(uploadPath +"\\" + review_image_name);
			Review_ImageDTO dto1=new Review_ImageDTO(0, n, review_image_original_name, review_image_name);	
			int b=dao.reviewimageinsert(dto1);
			if(b>0){//성공시
				response.sendRedirect("/review.do?cmd=review_read");
			}else{//실패시
				response.sendRedirect("/review.do?cmd=review_read");
			}
		}else{
			request.setAttribute("result", "fail");
		}
	}
	
	private void review_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int review_num=Integer.parseInt(request.getParameter("review_num"));
		ReviewDAO dao=ReviewDAO.getInstance();
		int n=dao.review_delete(review_num);
		response.sendRedirect("/review.do?cmd=review_read");
	
	}
	//게시글 수정
	private void review_update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath=request.getServletContext().getRealPath("/review_image");
		//System.out.println(uploadPath); 실제저장 폴더
		MultipartRequest mr=new MultipartRequest(
				request, 
				uploadPath, 
				1024*1024*5, 
				"utf-8", 
				new DefaultFileRenamePolicy()
			);
		HttpSession session=request.getSession();
		String customer_num=(String)session.getAttribute("customer_num");
		String review_writer=(String)session.getAttribute("member_nickname");
		int review_num=Integer.parseInt(mr.getParameter("review_num"));
		String review_category=mr.getParameter("review_category");
		String review_title=mr.getParameter("review_title");
		String review_content=mr.getParameter("review_content");
		/*
		System.out.println(customer_num);
		System.out.println(review_writer);
		System.out.println(review_num);
		System.out.println(review_category);
		System.out.println(review_title);
		System.out.println(review_content);
		*/
		ReviewDTO dto=new ReviewDTO(review_num, customer_num, review_category, review_title, review_content, review_writer);
		ReviewDAO dao=ReviewDAO.getInstance();
		int n=dao.update(dto);
		
		//text 수정까지 진행완료 이미지 수정으로 넘어감
		ReviewDAO dao_image=ReviewDAO.getInstance();
		Review_ImageDTO dto1=dao_image.review_detail_image(review_num);
		if(n>0){
			String review_image_original_name=mr.getOriginalFileName("review_file1");
			String review_image_name=mr.getFilesystemName("review_file1");

			if(review_image_name!=null){
				File f=new File(uploadPath +"\\" + dto1.getReview_image_name());
				f.delete();
				dto1=new Review_ImageDTO(dto1.getReview_image_num(), review_num, review_image_original_name, review_image_name);
				n=dao_image.review_update_image(dto1);
				dto1=dao_image.review_detail_image(review_num);
			}
			request.setAttribute("review_num",review_num);
			request.setAttribute("spage", "/board_review/review_detail.jsp");		
		}else{
			request.setAttribute("review_category",review_category);
			request.setAttribute("review_title",review_title);
			request.setAttribute("review_writer",review_writer);
			request.setAttribute("review_content",review_content);	
			request.setAttribute("spage", "/board_review/review_update.jsp");
		}
		request.setAttribute("dto", dto); //텍스트 부분
		request.setAttribute("dto1",dto1); //이미지 부분
		request.setAttribute("menuNum","40");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);	
	}		
	
	// 게시글 검색
	private void review_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String review_search_option=request.getParameter("review_search_option");
		String review_search_text=request.getParameter("review_search_text");
		String rowCountStr=request.getParameter("rowCount");
		int rowCount=0;
		
		String sPageNum=request.getParameter("pageNum");
		int pageNum=1;
		if(sPageNum!=null){
			pageNum=Integer.parseInt(sPageNum);
		}
		
		if(rowCountStr==null){
			rowCount=10;
		}else{
			rowCount=Integer.parseInt(rowCountStr);
		}
		int startRow=1+(pageNum-1)*rowCount;
		int endRow=pageNum*rowCount;
		
		ReviewDAO dao=ReviewDAO.getInstance();
		
		int pageCount=(int)Math.ceil(dao.getCountSearch(review_search_option,review_search_text)/(double)rowCount);
		int startPage=1+(pageNum-1)/10*10;
		int endPage=startPage+9;
		if(endPage>pageCount)endPage=pageCount;
		
		HashMap<String, String> map=new HashMap<>();
		map.put("review_search_option", review_search_option);
		map.put("review_search_text", review_search_text);
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));
		
		ArrayList<ReviewDTO> list=dao.review_search(map);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("review_search_option",review_search_option);
		request.setAttribute("review_search_text",review_search_text);
		request.setAttribute("menuNum","40");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_review/review_search.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
}
	


























