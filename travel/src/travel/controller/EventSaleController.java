package travel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.dao.EventSaleCommentDAO;
import travel.dao.EventSaleDAO;
import travel.dto.EventSaleCommentDTO;
import travel.dto.EventSaleDTO;

@WebServlet("/eventSale.do")
public class EventSaleController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("eventSale_read")){ //�̺�Ʈ,���� ��ü ����Ʈ ���� �޼ҵ� ȣ��
			eventSale_read(request,response);
		}else if(cmd.equals("eventSale_create_page")){ //�̺�Ʈ,���� �۾��� �������� �̵�
			request.setAttribute("menuNum","60");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_eventSale/eventSale_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}else if(cmd.equals("eventSale_create")){ //�̺�Ʈ,���� �۾��� �޼ҵ� ȣ��
			eventSale_create(request, response);
		}else if(cmd.equals("eventSale_detail") || cmd.equals("eventSale_detail_to_update")){ //�̺�Ʈ,���� �� ���� �޼ҵ� ȣ��
			eventSale_detail(request, response, cmd);
		}else if(cmd.equals("eventSale_search")){ //�̺�Ʈ,���� �˻� �޼ҵ� ȣ��
			eventSale_search(request, response);
		}else if(cmd.equals("eventSale_update")){ //�̺�Ʈ,���� ���� �޼ҵ� ȣ��
			eventSale_update(request, response);
		}else if(cmd.equals("eventSale_delete")){ //�̺�Ʈ,���� ���� �޼ҵ� ȣ��
			eventSale_delete(request, response);
		}else if(cmd.equals("eventSale_comment_create")){ //�̺�Ʈ,���� �ڸ�Ʈ ���� �޼ҵ� ȣ��
			eventSale_comment_create(request, response);
		}else if(cmd.equals("eventSale_comment_read")){ //�̺�Ʈ,���� ��� ����Ʈ ���� �޼ҵ� ȣ��
			eventSale_comment_read(request,response);
		}
	}
	protected void eventSale_read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPageNum=request.getParameter("pageNum");
		String rowCountStr=request.getParameter("rowCount");
		
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/DD");
		Date today=new Date();
		request.setAttribute("today", sdf.format(today));
		
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
		
		EventSaleDAO dao=EventSaleDAO.getInstance();
		
		int pageCount=(int)Math.ceil(dao.getCount()/(double)rowCount);
		int startPage=1+(pageNum-1)/10*10;
		int endPage=startPage+9;
		if(endPage>pageCount)endPage=pageCount;
		
		ArrayList<EventSaleDTO> list=dao.eventSale_read(startRow,endRow);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("menuNum","60");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_eventSale/eventSale_read.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	//�̺�Ʈ,���� �Խ��� �۾���
	protected void eventSale_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String eventSale_sort=request.getParameter("eventSale_sort");
		String eventSale_category=request.getParameter("eventSale_category");
		String eventSale_title=request.getParameter("eventSale_title");
		String eventSale_writer=request.getParameter("eventSale_writer");
		String eventSale_startDate=request.getParameter("eventSale_startDate");
		String eventSale_endDate=request.getParameter("eventSale_endDate");
		String eventSale_content=request.getParameter("eventSale_content");
		
		/*�ۼ��� ȸ����ȣ ���ǿ��� ��������
		HttpSession session=request.getSession();
		String customer_num=(String)session.getAttribute("customer_num");
		
		null �Ǿ� �ִ� �� �ٲ�� ��
		*/
		HttpSession session=request.getSession();
		String customer_num=(String)session.getAttribute("customer_num");
		//�Խù� �ؽ�Ʈ ���� ���
		EventSaleDTO dto=new EventSaleDTO(0,customer_num,eventSale_sort,eventSale_category,eventSale_title,
				eventSale_writer,eventSale_content,0,null,eventSale_startDate,eventSale_endDate);
		EventSaleDAO dao=EventSaleDAO.getInstance();
		int n=dao.eventSale_create(dto);
				
		//��� �����ϸ� �̺�Ʈ/���� ����Ʈ ȭ������ �̵�
		//��� ���� �� �ٽ� �۾��� �������� �̵�(�Է� ���� ����)
		if(n>0){
			response.sendRedirect("/eventSale.do?cmd=eventSale_read");
		}else{
			request.setAttribute("eventSale_sort",eventSale_sort);
			request.setAttribute("eventSale_category",eventSale_category);
			request.setAttribute("eventSale_title",eventSale_title);
			request.setAttribute("eventSale_writer",eventSale_writer);
			request.setAttribute("eventSale_startDate",eventSale_startDate);
			request.setAttribute("eventSale_endDate",eventSale_endDate);
			request.setAttribute("eventSale_content",eventSale_content);
			request.setAttribute("menuNum","60");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_eventSale/eventSale_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
	}

	// �̺�Ʈ/���� �˻�
	protected void eventSale_search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String eventSale_search_option = request.getParameter("eventSale_search_option");
		String eventSale_search_text = request.getParameter("eventSale_search_text");
		String rowCountStr = request.getParameter("rowCount");
		
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/DD");
		Date today=new Date();
		request.setAttribute("today", sdf.format(today));
		
		int rowCount = 0;

		String sPageNum = request.getParameter("pageNum");
		int pageNum = 1;
		if (sPageNum != null) {
			pageNum = Integer.parseInt(sPageNum);
		}

		if (rowCountStr == null) {
			rowCount = 10;
		} else {
			rowCount = Integer.parseInt(rowCountStr);
		}
		int startRow = 1 + (pageNum - 1) * rowCount;
		int endRow = pageNum * rowCount;

		EventSaleDAO dao = EventSaleDAO.getInstance();

		int pageCount = (int) Math
				.ceil(dao.getCountSearch(eventSale_search_option, eventSale_search_text) / (double) rowCount);
		int startPage = 1 + (pageNum - 1) / 10 * 10;
		int endPage = startPage + 9;
		if (endPage > pageCount)
			endPage = pageCount;

		HashMap<String, String> map = new HashMap<>();
		map.put("eventSale_search_option", eventSale_search_option);
		map.put("eventSale_search_text", eventSale_search_text);
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));

		ArrayList<EventSaleDTO> list = dao.eventSale_search(map);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("eventSale_search_option", eventSale_search_option);
		request.setAttribute("eventSale_search_text", eventSale_search_text);
		request.setAttribute("menuNum", "60");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_eventSale/eventSale_search.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	// �̺�Ʈ/���� �� ����
	protected void eventSale_detail(HttpServletRequest request, HttpServletResponse response, String cmd)
			throws ServletException, IOException {
		int eventSale_num = Integer.parseInt(request.getParameter("eventSale_num"));

		EventSaleDAO dao = EventSaleDAO.getInstance();

		// �� �ؽ�Ʈ ���� ������ + ��ȸ�� 1up
		EventSaleDTO dto = dao.eventSale_detail(eventSale_num);

		if (cmd.equals("eventSale_detail")) {
			request.setAttribute("spage", "/board_eventSale/eventSale_detail.jsp");
		} else {
			request.setAttribute("spage", "/board_eventSale/eventSale_update.jsp");
		}
		request.setAttribute("dto", dto);
		request.setAttribute("menuNum", "60");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	// �̺�Ʈ/���� �Խù� ����
	protected void eventSale_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int eventSale_num = Integer.parseInt(request.getParameter("eventSale_num"));
		String customer_num = request.getParameter("customer_num");
		String eventSale_sort = request.getParameter("eventSale_sort");
		String eventSale_category = request.getParameter("eventSale_category");
		String eventSale_title = request.getParameter("eventSale_title");
		String eventSale_writer = request.getParameter("eventSale_writer");
		int eventSale_hit = Integer.parseInt(request.getParameter("eventSale_hit"));
		String eventSale_content = request.getParameter("eventSale_content");
		String eventSale_w_date = request.getParameter("eventSale_w_date");
		String eventSale_startDate=request.getParameter("eventSale_startDate");
		String eventSale_endDate=request.getParameter("eventSale_endDate");

		EventSaleDTO dto = new EventSaleDTO(eventSale_num, customer_num, eventSale_sort, eventSale_category, eventSale_title,
				eventSale_writer,eventSale_content,eventSale_hit, eventSale_w_date, eventSale_startDate,eventSale_endDate);
		EventSaleDAO dao_text = EventSaleDAO.getInstance();
		int n = dao_text.eventSale_update(dto);

		if (n > 0) {
			request.setAttribute("eventSale_num", eventSale_num);
			request.setAttribute("spage", "/board_eventSale/eventSale_detail.jsp");
		} else {
			request.setAttribute("eventSale_sort",eventSale_sort);
			request.setAttribute("eventSale_category",eventSale_category);
			request.setAttribute("eventSale_title",eventSale_title);
			request.setAttribute("eventSale_writer",eventSale_writer);
			request.setAttribute("eventSale_startDate",eventSale_startDate);
			request.setAttribute("eventSale_endDate",eventSale_endDate);
			request.setAttribute("eventSale_content",eventSale_content);
			// ���� �������� �̵�
			request.setAttribute("spage", "/board_eventSale/eventSale_update.jsp");
		}
		request.setAttribute("dto", dto);
		request.setAttribute("menuNum", "60");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	// �̺�Ʈ/���� �Խù� ����
	protected void eventSale_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int eventSale_num = Integer.parseInt(request.getParameter("eventSale_num"));

		EventSaleDAO dao = EventSaleDAO.getInstance();

		// �ؽ�Ʈ ������ ����(on delete cascade�� �ؽ�Ʈ �Խù��� �����ϸ� ��)
		int n = dao.eventSale_delete(eventSale_num);

		response.sendRedirect("/eventSale.do?cmd=eventSale_read");
	}

	// �̺�Ʈ/���� �ڸ�Ʈ �Խù� ����
	protected void eventSale_comment_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eventSale_comment_writer = request.getParameter("eventSale_comment_writer");
		String eventSale_comment_content = request.getParameter("eventSale_comment_content");
		int eventSale_num = Integer.parseInt(request.getParameter("eventSale_num"));
		String customer_num = request.getParameter("customer_num");

		EventSaleCommentDAO dao = EventSaleCommentDAO.getInstance();
		EventSaleCommentDTO dto = new EventSaleCommentDTO(0, eventSale_num, customer_num, eventSale_comment_writer,
				eventSale_comment_content, null);
		int n = dao.eventSale_comment_create(dto);
		// xml�� ����
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<create>");
		if (n > 0) {
			pw.print("<result>success</result>");
		} else {
			pw.print("<result>failed</result>");
		}
		pw.println("</create>");
		pw.close();
	}

	// �̺�Ʈ/���� �ڸ�Ʈ ����Ʈ ����
	protected void eventSale_comment_read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int eventSale_num=Integer.parseInt(request.getParameter("eventSale_num"));
		EventSaleCommentDAO dao = EventSaleCommentDAO.getInstance();
		ArrayList<EventSaleCommentDTO> list = dao.eventSale_comment_read(eventSale_num);

		// xml�� ����
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<list>");
		for (EventSaleCommentDTO dto : list) {
			pw.println("<data>");
			pw.println("<comment_writer>" + dto.getEventSale_comment_writer() + "</comment_writer>");
			pw.println("<comment_content>" + dto.getEventSale_comment_content() + "</comment_content>");
			pw.println("<comment_w_date>" + dto.getEventSale_comment_w_date() + "</comment_w_date>");
			pw.println("</data>");
		}
		pw.println("</list>");
		pw.close();
	}
}