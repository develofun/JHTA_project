package travel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.dao.FaqDAO;
import travel.dto.FaqDTO;

@WebServlet("/faq.do")
public class FaqController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if (cmd.equals("faq_read")) { // �߰����� ��ü ����Ʈ ���� �޼ҵ� ȣ��
			faq_read(request, response);
		} else if (cmd.equals("faq_create_page")) { // �̺�Ʈ,���� �۾��� �������� �̵�
			request.setAttribute("menuNum", "70");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_faq/faq_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		} else if (cmd.equals("faq_create")) { // �̺�Ʈ,���� �۾��� �޼ҵ� ȣ��
			faq_create(request, response);
		} else if (cmd.equals("faq_delete")) { // �̺�Ʈ,���� �۾��� �޼ҵ� ȣ��
			faq_delete(request, response);
		} else if (cmd.equals("faq_update") || cmd.equals("faq_detail_to_update")) { // �̺�Ʈ,���� �۾��� �޼ҵ� ȣ��
			faq_update(request, response, cmd);
		}else if(cmd.equals("faq_search")){ //�̺�Ʈ,���� �˻� �޼ҵ� ȣ��
			faq_search(request, response);
		}
	}

	protected void faq_read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPageNum = request.getParameter("pageNum");
		String rowCountStr = request.getParameter("rowCount");
		int rowCount = 0;

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

		FaqDAO dao = FaqDAO.getInstance();

		int pageCount = (int) Math.ceil(dao.getCount() / (double) rowCount);
		int startPage = 1 + (pageNum - 1) / 10 * 10;
		int endPage = startPage + 9;
		if (endPage > pageCount)
			endPage = pageCount;

		ArrayList<FaqDTO> list = dao.faq_read(startRow, endRow);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("menuNum", "70");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_faq/faq_read.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	// FAQ �Խ��� �۾���
	protected void faq_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String faq_category = request.getParameter("faq_category");
		String faq_title = request.getParameter("faq_title");		
		String faq_content = request.getParameter("faq_content");
		/*
		 * �ۼ��� ȸ����ȣ ���ǿ��� �������� HttpSession session=request.getSession(); String
		 * customer_num=(String)session.getAttribute("customer_num");
		 * 
		 * null �Ǿ� �ִ� �� �ٲ�� ��
		 */
		HttpSession session=request.getSession();
		String customer_num=(String)session.getAttribute("customer_num");
		// �Խù� �ؽ�Ʈ ���� ���
		FaqDTO dto = new FaqDTO(0, faq_category, faq_title, faq_content);
		FaqDAO dao = FaqDAO.getInstance();
		int n = dao.faq_create(dto);

		// ��� �����ϸ� FAQ ����Ʈ ȭ������ �̵�
		// ��� ���� �� �ٽ� �۾��� �������� �̵�(�Է� ���� ����)
		if (n > 0) {
			response.sendRedirect("/faq.do?cmd=faq_read");
		} else {
			request.setAttribute("faq_title", faq_title);
			request.setAttribute("faq_category", faq_category);						
			request.setAttribute("faq_content", faq_content);
			request.setAttribute("menuNum", "70");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_faq/faq_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
	}
	
	protected void faq_search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String faq_search_option = request.getParameter("faq_search_option");
		String faq_search_text = request.getParameter("faq_search_text");
		String rowCountStr = request.getParameter("rowCount");
		
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

		FaqDAO dao = FaqDAO.getInstance();

		int pageCount = (int) Math.ceil(dao.getCountSearch(faq_search_option, faq_search_text) / (double) rowCount);
		int startPage = 1 + (pageNum - 1) / 10 * 10;
		int endPage = startPage + 9;
		if (endPage > pageCount)
			endPage = pageCount;

		HashMap<String, String> map = new HashMap<>();
		map.put("faq_search_option", faq_search_option);
		map.put("faq_search_text", faq_search_text);
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));

		ArrayList<FaqDTO> list = dao.faq_search(map);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("faq_search_option", faq_search_option);
		request.setAttribute("faq_search_text", faq_search_text);
		request.setAttribute("menuNum", "70");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_faq/faq_search.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
/*	
	// FAQ �� ����
	protected void faq_detail(HttpServletRequest request, HttpServletResponse response,String cmd)
			throws ServletException, IOException {
		int faq_num = Integer.parseInt(request.getParameter("faq_num"));

		faqDAO dao = faqDAO.getInstance();
		faqDTO dto = dao.faq_detail(faq_num);
		
		if (cmd.equals("faq_detail")) {
			request.setAttribute("spage", "/board_faq/faq_detail.jsp");
		} else {
			request.setAttribute("spage", "/board_faq/faq_update.jsp");
		}
		
		request.setAttribute("dto", dto);
		request.setAttribute("menuNum", "70");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
*/
	// FAQ �Խù� ����
	protected void faq_update(HttpServletRequest request, HttpServletResponse response, String cmd)
			throws ServletException, IOException {
		FaqDAO dao = FaqDAO.getInstance();
		
		String faq_num = request.getParameter("faq_num");
		
		//������������� ���� �������� �̵�
		if(cmd.equals("detail_to_update")){
			FaqDTO dto=dao.faq_detail(Integer.parseInt(faq_num));
			request.setAttribute("dto", dto);
			request.setAttribute("menuNum", "70");
			request.setAttribute("spage", "/board_faq/faq_update.jsp");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
		
		String faq_category = request.getParameter("faq_category");
		String faq_title = request.getParameter("faq_title");		
		String faq_content = request.getParameter("faq_content");
		
		HashMap<String,String> map=new HashMap<>();
		map.put("faq_num", faq_num);
		map.put("faq_category", faq_category);
		map.put("faq_title", faq_title);		
		map.put("faq_content", faq_content);
				
		int n = dao.faq_update(map);

		if (n > 0) {
			response.sendRedirect("/faq.do?cmd=faq_read");
		} else {
			request.setAttribute("faq_category", faq_category);
			request.setAttribute("faq_title", faq_title);			
			request.setAttribute("faq_content", faq_content);
			// ���� �������� �̵�			
			request.setAttribute("menuNum", "70");
			request.setAttribute("spage", "/board_faq/faq_update.jsp");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
	}

	// FAQ �Խù� ����
	protected void faq_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int faq_num = Integer.parseInt(request.getParameter("faq_num"));

		FaqDAO dao = FaqDAO.getInstance();

		int n = dao.faq_delete(faq_num);

		response.sendRedirect("/faq.do?cmd=faq_read");
	}
}
