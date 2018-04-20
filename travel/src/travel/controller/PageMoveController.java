package travel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/move.do")
public class PageMoveController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		System.out.println("cmd");
		if(cmd==null || (cmd!=null && cmd.equals("main"))){
			response.sendRedirect("/main.do?cmd=main_page");
		}else if(cmd.equals("kboard")){
			response.sendRedirect("/kboard.do?cmd=kboard_read");
		}else if(cmd.equals("fboard")){
			response.sendRedirect("/fboard.do?cmd=fboard_read");
		}else if(cmd.equals("free")){
			response.sendRedirect("/free.do?cmd=free_read");
		}else if(cmd.equals("review")){
			response.sendRedirect("/review.do?cmd=review_read");
		}else if(cmd.equals("market")){
			response.sendRedirect("/market.do?cmd=market_read");
		}else if(cmd.equals("eventSale")){
			response.sendRedirect("/eventSale.do?cmd=eventSale_read");
		}else if(cmd.equals("qna")){
			response.sendRedirect("/qna.do?cmd=qna_read");
		}else if(cmd.equals("notice")){
			response.sendRedirect("/notice.do?cmd=notice_read");
		}
	}
}
