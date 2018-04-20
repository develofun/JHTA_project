package travel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.dao.Notice_CommentsDAO;
import travel.dto.Notice_CommentsDTO;

@WebServlet("/notice_comments.do")
public class NoticeCommentsController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("notice_comments_create")){
			notice_comments_create(request,response);
		}else if(cmd.equals("notice_comments_read")){
			notice_comments_read(request,response);
		}else if(cmd.equals("notice_comments_delete")){
			notice_comments_delete(request,response);
		}
	}
	
	protected void notice_comments_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int notice_comments_num=Integer.parseInt(request.getParameter("notice_comments_num"));
		Notice_CommentsDAO dao=new Notice_CommentsDAO();
		int n=dao.notice_comments_delete(notice_comments_num);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<result>");
		if(n>0){
			pw.println("<code>success</code>");
		}else{
			pw.println("<code>fail</code>");
		}
		pw.println("</result>");
		pw.close();
	}
	
	protected void notice_comments_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String notice_comments_content=request.getParameter("notice_comments_content");
		int notice_num=Integer.parseInt(request.getParameter("notice_num"));
		
		HttpSession session=request.getSession();
		String notice_comments_writer=(String)session.getAttribute("member_nickname");
		
		Notice_CommentsDTO dto=new Notice_CommentsDTO(0,notice_num,notice_comments_content,null,notice_comments_writer);
		Notice_CommentsDAO dao=new Notice_CommentsDAO();
		int n=dao.notice_comments_create(dto,notice_num);
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<result>");
		if(n>0){
			pw.println("<code>success</code>");
		}else{
			pw.println("<code>fail</code>");
		}
		pw.println("</result>");
		pw.close();
	}
	protected void notice_comments_read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int notice_num=Integer.parseInt(request.getParameter("notice_num"));
		
		HttpSession session=request.getSession();
		String notice_comments_writer=(String)session.getAttribute("member_nickname");
		
		Notice_CommentsDAO dao=new Notice_CommentsDAO();
		ArrayList<Notice_CommentsDTO> list=dao.notice_comments_read(notice_num);
		
		
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<result>");
		for(int i=0;i<list.size();i++){
			Notice_CommentsDTO dto=list.get(i);
			pw.println("<data>");
			pw.println("<notice_comments_num>"+dto.getNotice_comments_num()+"</notice_comments_num>");
			pw.println("<notice_comments_content>"+dto.getNotice_comments_content()+"</notice_comments_content>");
			pw.println("<notice_comments_writer>"+dto.getNotice_comments_writer()+"</notice_comments_writer>");
			pw.println("<notice_comments_w_date>"+dto.getNotice_comments_w_date()+"</notice_comments_w_date>");
			pw.println("</data>");
		}
		pw.println("</result>");
		pw.close();
	}
}
