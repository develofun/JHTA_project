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

import travel.dao.FreeDAO;
import travel.dto.FreeDTO;
import travel.dto.Free_CommentDTO;
import travel.dto.Free_ImageDTO;

@WebServlet("/free.do")
public class FreeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("free_read")){
			free_read(request,response);
		}else if(cmd.equals("detail") || cmd.equals("free_detail_to_update")){
			detail(request,response,cmd);
		}else if(cmd.equals("free_create_page")){
			request.setAttribute("menuNum","30");
			request.setAttribute("cpage", "/layout/detail_login.jsp");	
			request.setAttribute("spage", "/board_free/free_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}else if(cmd.equals("create")){
			create(request,response);
		}else if(cmd.equals("free_delete")){
			free_delete(request,response);
		}else if(cmd.equals("free_update")){
			free_update(request,response);
		}else if(cmd.equals("free_search")){
			free_search(request,response);
		}else if(cmd.equals("free_comment_create")){
			free_comment_create(request, response);
		}else if(cmd.equals("free_comment_read")){
			free_comment_read(request, response);
		}else if(cmd.equals("hit_top10")){
			hit_top10(request,response);
		}else if(cmd.endsWith("comment_top10")){
			comment_top10(request,response);
		}
	}
	//댓글 리스트 추출
	private void free_comment_read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int free_num=Integer.parseInt(request.getParameter("free_num"));
		FreeDAO dao=FreeDAO.getInstance();
		//System.out.println(free_num); 자유게시판 글번호 출력됨
		ArrayList<Free_CommentDTO> list=dao.free_comment_read(free_num); //전체 목록을 받아오고
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<list>");
		for(Free_CommentDTO dto:list){
			pw.println("<data>");
			pw.println("<free_comment_writer>"+dto.getFree_comment_writer()+"</free_comment_writer>");
			pw.println("<free_comment_content>"+dto.getFree_comment_content()+"</free_comment_content>");
			pw.println("<free_comment_w_date>"+dto.getFree_comment_w_date()+"</free_comment_w_date>");
			pw.println("</data>");
		}
		pw.println("</list>");
		pw.close();
	}
	//댓글 작성
	private void free_comment_create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int free_num=Integer.parseInt(request.getParameter("free_num"));
		HttpSession session=request.getSession();
		String free_comment_writer=(String)session.getAttribute("member_nickname");
		String free_comment_content=request.getParameter("free_comment_content");
		/* 게시판번호, 작성자, 내용
		System.out.println(free_num);
		System.out.println(free_comment_writer);
		System.out.println(free_comment_content);
		*/
		int free_comment_num=0;
		int lev=0;
		int step=0;
		Free_CommentDTO dto=new Free_CommentDTO(free_num, free_comment_num, free_comment_writer, free_comment_content, null ,lev, step);
		FreeDAO dao=FreeDAO.getInstance();
		int n=dao.free_comment_create(dto);
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
		int free_num=Integer.parseInt(request.getParameter("free_num"));
		FreeDAO dao=new FreeDAO();
		FreeDTO dto=dao.detail(free_num);
		Free_ImageDTO dto1=dao.image(free_num);	
		if(cmd.equals("detail")){
			request.setAttribute("spage", "/board_free/free_detail.jsp");
		}else{
			request.setAttribute("spage", "/board_free/free_update.jsp");
		}
		request.setAttribute("dto", dto); //얻어온 텍스트 정보
		request.setAttribute("dto1", dto1); //얻어온 이미지 정보
		request.setAttribute("menuNum","30");
		request.setAttribute("cpage", "/layout/detail_login.jsp");	
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	// 게시판 리스트 불러오기
	private void free_read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		FreeDAO dao=FreeDAO.getInstance();
		
		int pageCount=(int)Math.ceil(dao.getCountAll()/(double)rowCount); 
		int startPage=1+(pageNum-1)/10*10;
		int endPage=startPage+9;
		if(endPage>pageCount)endPage=pageCount;
		
		ArrayList<FreeDTO> list=dao.free_read(startRow, endRow);
		//ArrayList<FreeDTO> list1=dao.comment_top10();
		//request.setAttribute("list1", list1);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		
		request.setAttribute("menuNum","30");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_free/free_read.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);	
	}
	// 조회순 top 10개 불러오기
	private void hit_top10(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeDAO dao=FreeDAO.getInstance();
		ArrayList<FreeDTO> list=dao.hit_top10();
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<list>");
		for(int i=0;i<list.size();i++){
			FreeDTO dto=list.get(i);
			pw.println("<data>");
			pw.println("<free_num>" + dto.getFree_num() + "</free_num>");
			pw.println("<title>" + dto.getFree_title()+ "</title>");
			//System.out.println(dto.getFree_title()); 출력잘됨
			pw.println("</data>");
		}
		pw.println("</list>");
		pw.close();
	}
	// 댓글 top 10개 불러오기
	private void comment_top10(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeDAO dao=FreeDAO.getInstance();
		ArrayList<FreeDTO> list=dao.comment_top10();
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<list>");
		for(int i=0;i<list.size();i++){
			FreeDTO dto=list.get(i);
			pw.println("<data>");
			pw.println("<free_num>" + dto.getFree_num() + "</free_num>");
			pw.println("<title>" + dto.getFree_title()+ "</title>");
			pw.println("</data>");
			//System.out.println(dto.getFree_num()+dto.getFree_title());
		}
		pw.println("</list>");
		pw.close();
	}
	// 게시글 작성
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath=request.getServletContext().getRealPath("/free_image");
		//System.out.println(uploadPath); 실제저장 폴더
		
		MultipartRequest mr=new MultipartRequest(
				request, //request객체
				uploadPath, //파일을 저장할 경로
				1024*1024*5, //최대 업로드 사이즈(byte단위 - 5mb)
				"utf-8", //인코딩타입
				new DefaultFileRenamePolicy()//동일한 파일명이 존재시 파일끝에 숫자붙이기
			);
		//세션얻어와서 작성자에 회원번호 보내기
		HttpSession session=request.getSession();
		String customer_num=(String)session.getAttribute("customer_num");
		String free_writer=(String)session.getAttribute("member_nickname");

		String free_title=mr.getParameter("free_title");
		String free_content=mr.getParameter("free_content");
		FreeDTO dto=new FreeDTO(customer_num, free_title, free_content, free_writer);
		FreeDAO dao=FreeDAO.getInstance();
		int n=dao.create(dto);
		if(n>0){
			String free_image_original_name=mr.getOriginalFileName("free_file1");
			String free_image_name=mr.getFilesystemName("free_file1");
			File f=new File(uploadPath +"\\" + free_image_name);
			//long free_image_size=f.length(); 이미지 사이즈 삭제함
			Free_ImageDTO dto1=new Free_ImageDTO(0, n, free_image_original_name, free_image_name);	
			int b=dao.freeimageinsert(dto1);
			if(b>0){//성공시
				response.sendRedirect("/free.do?cmd=free_read");
			}else{//실패시
				request.setAttribute("result", "fail");
			}
		}else{
			request.setAttribute("result", "fail");
		}
	}
	private void free_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int free_num=Integer.parseInt(request.getParameter("free_num"));
		FreeDAO dao=FreeDAO.getInstance();
		int n=dao.free_delete(free_num);
		response.sendRedirect("/free.do?cmd=free_read");
	
	}
	//게시글 수정
	private void free_update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");한글 안깨짐
		String uploadPath=request.getServletContext().getRealPath("/free_image");
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
		String free_writer=(String)session.getAttribute("member_nickname");
		int free_num=Integer.parseInt(mr.getParameter("free_num"));
		String free_title=mr.getParameter("free_title");
		String free_content=mr.getParameter("free_content");
		
		FreeDTO dto=new FreeDTO(free_num, customer_num, free_title, free_content, free_writer);
		FreeDAO dao=FreeDAO.getInstance();
		int n=dao.update(dto);
		
		//text 수정까지 진행완료 이미지 수정으로 넘어감
		FreeDAO dao_image=FreeDAO.getInstance();
		Free_ImageDTO dto1=dao_image.free_detail_image(free_num);
		if(n>0){
			String free_image_original_name=mr.getOriginalFileName("free_file1");
			String free_image_name=mr.getFilesystemName("free_file1");

			if(free_image_name!=null){
				File f=new File(uploadPath +"\\" + dto1.getFree_image_name());
				f.delete();
				dto1=new Free_ImageDTO(dto1.getFree_image_num(), free_num, free_image_original_name, free_image_name);
				n=dao_image.free_update_image(dto1);
				dto1=dao_image.free_detail_image(free_num);
			}
			request.setAttribute("free_num",free_num);
			request.setAttribute("spage", "/board_free/free_detail.jsp");	
		}else{
			request.setAttribute("free_title",free_title);
			request.setAttribute("free_writer",free_writer);
			request.setAttribute("free_content",free_content);	
			request.setAttribute("spage", "/board_free/free_update.jsp");
		}
		request.setAttribute("dto", dto); 
		request.setAttribute("dto1",dto1);
		request.setAttribute("menuNum","30");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);	
	}		
	// 게시글 검색
	private void free_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String free_search_option=request.getParameter("free_search_option");
		String free_search_text=request.getParameter("free_search_text");
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
		
		FreeDAO dao=FreeDAO.getInstance();
		
		int pageCount=(int)Math.ceil(dao.getCountSearch(free_search_option,free_search_text)/(double)rowCount);
		int startPage=1+(pageNum-1)/10*10;
		int endPage=startPage+9;
		if(endPage>pageCount)endPage=pageCount;
		
		HashMap<String, String> map=new HashMap<>();
		map.put("free_search_option", free_search_option);
		map.put("free_search_text", free_search_text);
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));
		
		ArrayList<FreeDTO> list=dao.free_search(map);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("free_search_option",free_search_option);
		request.setAttribute("free_search_text",free_search_text);
		request.setAttribute("menuNum","30");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_free/free_search.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
}
	


























