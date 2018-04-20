package travel.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import travel.dao.MarketCommentDAO;
import travel.dao.MarketDAO;
import travel.dto.MarketCommentDTO;
import travel.dto.MarketDTO;
import travel.dto.MarketImageDTO;

@WebServlet("/market.do")
public class MarketController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("market_read")){ //중고장터 전체 리스트 추출 메소드 호출
			market_read(request,response);
		}else if(cmd.equals("market_create_page")){ //중고장터 글쓰기 페이지로 이동
			request.setAttribute("menuNum","50");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_market/market_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}else if(cmd.equals("market_create")){ //중고장터 글쓰기 메소드 호출
			market_create(request, response);
		}else if(cmd.equals("market_detail") || cmd.equals("market_detail_to_update")){ //중고장터 상세 보기 메소드 호출
			market_detail(request, response, cmd);
		}else if(cmd.equals("market_search")){ //중고장터 검색 메소드 호출
			market_search(request, response);
		}else if(cmd.equals("market_update")){ //중고장터 수정 메소드 호출
			market_update(request, response);
		}else if(cmd.equals("market_delete")){ //중고장터 삭제 메소드 호출
			market_delete(request, response);
		}else if(cmd.equals("market_comment_create")){ //중고장터 코멘트 생성 메소드 호출
			market_comment_create(request, response);
		}else if(cmd.equals("market_comment_read")){ //중고장터 댓글 리스트 추출 메소드 호출
			market_comment_read(request,response);
		}
	}
	
	//중고장터 전체 리스트 추출
	protected void market_read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPageNum=request.getParameter("pageNum");
		String rowCountStr=request.getParameter("rowCount");
		int rowCount=0;
		
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
		
		MarketDAO dao=MarketDAO.getInstance();
		
		int pageCount=(int)Math.ceil(dao.getCountAll()/(double)rowCount);
		int startPage=1+(pageNum-1)/10*10;
		int endPage=startPage+9;
		if(endPage>pageCount)endPage=pageCount;
		
		ArrayList<MarketDTO> list=dao.market_read(startRow,endRow);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("menuNum","50");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_market/market_read.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	//중고장터 글쓰기
	protected void market_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		ServletContext application=request.getServletContext();
		
		String upload_path=application.getRealPath("/market_image");
		MultipartRequest mr=new MultipartRequest(
				request,
				upload_path,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		String market_sort=mr.getParameter("market_sort");
		String market_category=mr.getParameter("market_category");
		String market_title=mr.getParameter("market_title");
		String market_writer=mr.getParameter("market_writer");
		int market_price=Integer.parseInt(mr.getParameter("market_price"));
		String market_phone=mr.getParameter("market_phone");
		String market_content=mr.getParameter("market_content");
		
		HttpSession session=request.getSession();
		String customer_num=(String)session.getAttribute("customer_num");
		
		//파일 정보 가져오기
		String fileName=mr.getOriginalFileName("market_image");
		String saveFileName=mr.getFilesystemName("market_image");
		
		/*작성자 회원번호 세션에서 가져오기
		HttpSession session=request.getSession();
		String customer_num=(String)session.getAttribute("customer_num");
		
		null 되어 있는 거 바꿔야 됨
		*/
		
		//게시물 텍스트 정보 등록
		MarketDTO dto=new MarketDTO(0,customer_num,market_sort,market_category,market_title,
				market_content,market_price,market_phone,0,null,market_writer);
		MarketDAO dao=MarketDAO.getInstance();
		int market_num=dao.market_create_text(dto);
		
		MarketDAO dao_img=MarketDAO.getInstance();
		MarketImageDTO dto_img=new MarketImageDTO(0,market_num,fileName,saveFileName);
		int n=dao_img.market_create_image(dto_img);
		
		//등록 성공하면 중고장터 리스트 화면으로 이동
		//등록 실패 시 다시 글쓰기 페이지로 이동(입력 정보 유지)
		if(n>0){
			response.sendRedirect("/market.do?cmd=market_read");
		}else{
			request.setAttribute("market_sort",market_sort);
			request.setAttribute("market_category",market_category);
			request.setAttribute("market_title",market_title);
			request.setAttribute("market_writer",market_writer);
			request.setAttribute("market_price",market_price);
			request.setAttribute("market_phone",market_phone);
			request.setAttribute("market_content",market_content);
			request.setAttribute("menuNum","50");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_market/market_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
	}
			
	//중고장터 검색
	protected void market_search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String market_search_option=request.getParameter("market_search_option");
		String market_search_text=request.getParameter("market_search_text");
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
		
		MarketDAO dao=MarketDAO.getInstance();
		
		int pageCount=(int)Math.ceil(dao.getCountSearch(market_search_option,market_search_text)/(double)rowCount);
		int startPage=1+(pageNum-1)/10*10;
		int endPage=startPage+9;
		if(endPage>pageCount)endPage=pageCount;
		
		HashMap<String, String> map=new HashMap<>();
		map.put("market_search_option", market_search_option);
		map.put("market_search_text", market_search_text);
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));
		
		ArrayList<MarketDTO> list=dao.market_search(map);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("market_search_option",market_search_option);
		request.setAttribute("market_search_text",market_search_text);
		request.setAttribute("menuNum","50");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_market/market_search.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	//중고장터 상세 보기
	protected void market_detail(HttpServletRequest request, HttpServletResponse response, String cmd)
			throws ServletException, IOException {
		int market_num=Integer.parseInt(request.getParameter("market_num"));
		
		MarketDAO dao=MarketDAO.getInstance();
		
		//상세 텍스트 정보 얻어오기 + 조회수 1up
		MarketDTO dto_text=dao.market_detail_text(market_num);
		
		//상세 이미지 정보 얻어오기
		MarketImageDTO dto_image=dao.market_detail_image(market_num);
		
		if(cmd.equals("market_detail")){
			request.setAttribute("spage", "/board_market/market_detail.jsp");			
		}else{
			request.setAttribute("spage", "/board_market/market_update.jsp");
		}
		request.setAttribute("dto_text", dto_text);
		request.setAttribute("dto_image", dto_image);
		request.setAttribute("menuNum","50");
		request.setAttribute("cpage", "/layout/detail_login.jsp");	
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	//중고장터 게시물 수정
	protected void market_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//파일 저장 프로세스
		ServletContext application=request.getServletContext();		
		String uploadPath=application.getRealPath("/market_image");
		System.out.println(uploadPath);
		MultipartRequest mr=new MultipartRequest(
				request,
				uploadPath,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		int market_num=Integer.parseInt(mr.getParameter("market_num"));
		String customer_num=mr.getParameter("customer_num");
		String market_sort=mr.getParameter("market_sort");
		String market_category=mr.getParameter("market_category");
		String market_title=mr.getParameter("market_title");
		String market_writer=mr.getParameter("market_writer");
		int market_price=Integer.parseInt(mr.getParameter("market_price"));
		String market_phone=mr.getParameter("market_phone");
		int market_hit=Integer.parseInt(mr.getParameter("market_hit"));
		String market_content=mr.getParameter("market_content");
		String market_w_date=mr.getParameter("market_w_date");
		
		MarketDTO dto_text=new MarketDTO(market_num,customer_num,market_sort,market_category,market_title,
				market_content,market_price,market_phone,market_hit,market_w_date,market_writer);
		MarketDAO dao_text=MarketDAO.getInstance();
		int n=dao_text.market_update_text(dto_text);
		
		//텍스트 게시물 수정 여부에 따른 작업 진행
		MarketDAO dao_image=MarketDAO.getInstance();
		MarketImageDTO dto_image=dao_image.market_detail_image(market_num);		
		if(n>0){
			//수정된 파일 정보 가져오기
			String fileName=mr.getOriginalFileName("market_image");
			String saveFileName=mr.getFilesystemName("market_image");
			
			//수정된 파일 정보가 null이 아닌 경우에만 이미지 수정
			if(saveFileName!=null){
				File f=new File(uploadPath+"\\"+dto_image.getMarket_image_saveFileName());
				f.delete(); //기존 파일 삭제
				dto_image=new MarketImageDTO(dto_image.getMarket_image_num(),market_num,fileName,saveFileName);
				n=dao_image.market_update_image(dto_image);
				System.out.println(n);
				dto_image=dao_image.market_detail_image(market_num);
			}
			//수정한 게시물의 상세 페이지로 이동
			request.setAttribute("market_num",market_num);
			request.setAttribute("spage", "/board_market/market_detail.jsp");			
		}else{
			request.setAttribute("market_sort",market_sort);
			request.setAttribute("market_category",market_category);
			request.setAttribute("market_title",market_title);
			request.setAttribute("market_writer",market_writer);
			request.setAttribute("market_price",market_price);
			request.setAttribute("market_phone",market_phone);
			request.setAttribute("market_content",market_content);			
			//수정 페이지로 이동
			request.setAttribute("spage", "/board_market/market_update.jsp");			
		}
		request.setAttribute("dto_text", dto_text);
		request.setAttribute("dto_image", dto_image);
		request.setAttribute("menuNum","50");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	//중고장터 게시물 삭제(텍스트, 이미지)
	protected void market_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int market_num=Integer.parseInt(request.getParameter("market_num"));
		
		MarketDAO dao=MarketDAO.getInstance();
		
		//텍스트 데이터 삭제(on delete cascade로 텍스트 게시물만 삭제하면 됨)
		int n=dao.market_delete(market_num);
		
		response.sendRedirect("/market.do?cmd=market_read");
	}
	
	//중고장터 코멘트 게시물 생성
	protected void market_comment_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String market_comment_writer=request.getParameter("market_comment_writer");
		String market_comment_content=request.getParameter("market_comment_content");
		int market_num=Integer.parseInt(request.getParameter("market_num"));
		
		MarketCommentDAO dao=MarketCommentDAO.getInstance();
		MarketCommentDTO dto=new MarketCommentDTO(0, market_num, market_comment_writer, market_comment_content,null);
		int n=dao.market_comment_create(dto);
		//xml로 응답
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
	
	//중고장터 코멘트 리스트 추출
	protected void market_comment_read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int market_num=Integer.parseInt(request.getParameter("market_num"));
		MarketCommentDAO dao=MarketCommentDAO.getInstance();
		ArrayList<MarketCommentDTO> list=dao.market_comment_read(market_num);
		
		//xml로 응답
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<list>");
		for(MarketCommentDTO dto:list){
			pw.println("<data>");
			pw.println("<comment_writer>"+dto.getMarket_comment_writer()+"</comment_writer>");
			pw.println("<comment_content>"+dto.getMarket_comment_content()+"</comment_content>");
			pw.println("<comment_w_date>"+dto.getMarket_comment_w_date()+"</comment_w_date>");
			pw.println("</data>");
		}
		pw.println("</list>");
		pw.close();
	}
}