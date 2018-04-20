package travel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.dao.NoticeDAO;
import travel.dto.NoticeDTO;

@WebServlet("/notice.do")
public class NoticeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("notice_read")){
			notice_read(request,response);
		} else if (cmd.equals("notice_create_form")) {
			notice_create_form(request,response);
		} else if (cmd.equals("notice_create")) {
			notice_create(request,response);
		} else if (cmd.equals("notice_result")) {
			notice_result(request, response);
		} else if (cmd.equals("notice_detail")) {
			notice_detail(request, response);
		} else if (cmd.equals("notice_delete")) {
			notice_delete(request,response);
		} else if (cmd.equals("notice_update_form")) {
			notice_update_form(request,response);
		} else if (cmd.equals("notice_update")) {
			notice_update(request,response);
		} else if (cmd.equals("notice_update_result")) {
			notice_update_result(request, response);
		}
	}
	
	protected void notice_update_result(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("menuNum","80");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_notice/notice_update_result.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	protected void notice_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		notice_content = notice_content.replace("\r\n","<br>");
		NoticeDAO dao=new NoticeDAO();
		NoticeDTO dto=new NoticeDTO(notice_num,notice_title,notice_content,0,null);
		int n=dao.notice_update(dto);
		if(n>0){
			request.setAttribute("dto", dto);
			request.setAttribute("menuNum","80");
			request.setAttribute("result", "success");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_notice/notice_update_result.jsp");
		}else{
			request.setAttribute("dto", dto);
			request.setAttribute("menuNum","80");
			request.setAttribute("result", "fail");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_notice/notice_update_result.jsp");
		}
		request.getRequestDispatcher("/notice.do?cmd=notice_update_result").forward(request, response);
	}
	
	protected void notice_update_form(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = dao.detail(notice_num);
		request.setAttribute("dto", dto);
		request.setAttribute("menuNum","80");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_notice/notice_update.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	protected void notice_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int notice_num=Integer.parseInt(request.getParameter("notice_num"));
		NoticeDAO dao=new NoticeDAO();
		int n=dao.delete(notice_num);
		if(n>0){
			request.setAttribute("menuNum","80");
			request.setAttribute("result", "success");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_notice/notice_result.jsp");
		}else{
			request.setAttribute("menuNum","80");
			request.setAttribute("result", "fail");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_notice/notice_result.jsp");
		}
		request.getRequestDispatcher("/notice.do?cmd=notice_result").forward(request, response);
	}
	
	protected void notice_detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = dao.detail(notice_num);
		int n=dao.notice_hit_update(notice_num);
		request.setAttribute("dto", dto);
		request.setAttribute("menuNum","80");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_notice/notice_detail.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	protected void notice_result(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("menuNum","80");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_notice/notice_result.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	protected void notice_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String notice_title=request.getParameter("notice_title");
		String notice_content=request.getParameter("notice_content");
		notice_content = notice_content.replace("\r\n","<br>");
		NoticeDTO dto = new NoticeDTO(0, notice_title, notice_content, 0, null);
		NoticeDAO dao = new NoticeDAO();
		int n = dao.Notice_create(dto);
		if (n > 0) {
			request.setAttribute("menuNum","80");
			request.setAttribute("result", "success");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_notice/notice_result.jsp");
		} else {
			request.setAttribute("menuNum","80");
			request.setAttribute("result", "fail");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_notice/notice_result.jsp");
		}
		request.getRequestDispatcher("/notice.do?cmd=notice_result").forward(request, response);
		
	}
	
	protected void notice_create_form(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("menuNum","80");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_notice/notice_create.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void notice_read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPageNum=request.getParameter("pageNum");
		String notice_search_box=request.getParameter("notice_search_box");
		String notice_search=request.getParameter("notice_search");
		int pageNum=1;
		if(sPageNum!=null){
			pageNum=Integer.parseInt(sPageNum);
		}
		
		int startRow=(pageNum-1)*10+1;
		int endRow=pageNum*10;
		
		NoticeDAO dao = new NoticeDAO();
		ArrayList<NoticeDTO> list=dao.notice_read(startRow, endRow, notice_search_box, notice_search);
		
		int pageCount=(int)Math.ceil(dao.getCount(notice_search_box, notice_search)/10.0);
		int startPage=1+(pageNum-1)/10*10;
		int endPage=startPage+9;
		if(endPage>pageCount){
			endPage=pageCount;
		}
		
		request.setAttribute("list", list);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("notice_search_box", notice_search_box);
		request.setAttribute("notice_search", notice_search);
		request.setAttribute("menuNum","80");
		request.setAttribute("cmd",request.getParameter("cmd"));
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_notice/notice_read.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
}