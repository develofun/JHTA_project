package travel.controller;

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

import travel.dao.QnaDAO;
import travel.dto.QnaDTO;

@WebServlet("/qna.do")
public class QnaController extends HttpServlet {	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		if (cmd.equals("qna_read")) { // �߰����� ��ü ����Ʈ ���� �޼ҵ� ȣ��
			qna_read(request, response);
		} else if (cmd.equals("qna_create_page")) { // �̺�Ʈ,���� �۾��� �������� �̵�
			request.setAttribute("menuNum", "70");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_qna/qna_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		} else if (cmd.equals("qna_create")) { // �̺�Ʈ,���� �۾��� �޼ҵ� ȣ��
			qna_create(request, response);
		} else if (cmd.equals("qna_compare")) { // �̺�Ʈ,���� �۾��� �޼ҵ� ȣ��
			qna_compare(request, response);
		}else if(cmd.equals("qna_detail") || cmd.equals("qna_detail_to_update")){ //�̺�Ʈ,���� �� ���� �޼ҵ� ȣ��
			qna_detail(request, response, cmd);
		} else if (cmd.equals("qna_update")) { // �̺�Ʈ,���� �۾��� �޼ҵ� ȣ��
			qna_update(request, response);
		}
	}

	protected void qna_read(HttpServletRequest request, HttpServletResponse response)
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

		QnaDAO dao = QnaDAO.getInstance();

		int pageCount = (int) Math.ceil(dao.getCount() / (double) rowCount);
		int startPage = 1 + (pageNum - 1) / 10 * 10;
		int endPage = startPage + 9;
		if (endPage > pageCount)
			endPage = pageCount;

		ArrayList<QnaDTO> list = dao.qna_read(startRow, endRow);
		request.setAttribute("list", list);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("menuNum", "70");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_qna/qna_read.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	// Q&A �Խ��� �۾���
	protected void qna_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String qna_title = request.getParameter("qna_title");
		String qna_writer = request.getParameter("qna_writer");
		String qna_content = request.getParameter("qna_content");
		String qna_password = request.getParameter("qna_password");
		/*
		 * �ۼ��� ȸ����ȣ ���ǿ��� �������� HttpSession session=request.getSession(); String
		 * customer_num=(String)session.getAttribute("customer_num");
		 * 
		 * null �Ǿ� �ִ� �� �ٲ�� ��
		 */
		HttpSession session=request.getSession();
		String customer_num=(String)session.getAttribute("customer_num");
		// �Խù� �ؽ�Ʈ ���� ���
		QnaDTO dto = new QnaDTO(0, customer_num, null, qna_title, qna_writer, qna_content, null, 0, qna_password, null);
		QnaDAO dao = QnaDAO.getInstance();
		int n = dao.qna_create(dto);

		// ��� �����ϸ� Q&A ����Ʈ ȭ������ �̵�
		// ��� ���� �� �ٽ� �۾��� �������� �̵�(�Է� ���� ����)
		if (n > 0) {
			response.sendRedirect("/qna.do?cmd=qna_read");
		} else {
			request.setAttribute("qna_writer", qna_writer);
			request.setAttribute("qna_title", qna_title);			
			request.setAttribute("qna_content", qna_content);
			request.setAttribute("menuNum", "70");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_qna/qna_create.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
	}

	// Q&A ��й�ȣ ��
	protected void qna_compare(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		String input_password = request.getParameter("input_password");
		QnaDAO dao = QnaDAO.getInstance();
		int n = dao.qna_compare(input_password, qna_num);

		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.println("<compare>");
		if (n > 0) {
			pw.println("<result>o</result>");
			pw.println("<num>" + qna_num + "</num>");
		} else {
			pw.println("<result>x</result>");
			pw.println("<num>-1</num>");
		}
		pw.println("</compare>");
		pw.close();
	}

	// Q&A �� ����
	protected void qna_detail(HttpServletRequest request, HttpServletResponse response,String cmd)
			throws ServletException, IOException {
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));

		QnaDAO dao = QnaDAO.getInstance();
		QnaDTO dto = dao.qna_detail(qna_num);
		
		if (cmd.equals("qna_detail")) {
			request.setAttribute("spage", "/board_qna/qna_detail.jsp");
		} else {
			request.setAttribute("spage", "/board_qna/qna_update.jsp");
		}
		
		request.setAttribute("dto", dto);
		request.setAttribute("menuNum", "70");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	// Q&A �Խù� ����
	protected void qna_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String qna_num = request.getParameter("qna_num");
		String qna_title = request.getParameter("qna_title");		
		String qna_content = request.getParameter("qna_content");
		
		HashMap<String,String> map=new HashMap<>();
		map.put("qna_num", qna_num);
		map.put("qna_title", qna_title);		
		map.put("qna_content", qna_content);
		
		QnaDAO dao_text = QnaDAO.getInstance();
		int n = dao_text.qna_update(map);

		if (n > 0) {
			request.setAttribute("qna_num", qna_num);
			request.getRequestDispatcher("/qna.do?cmd=qna_detail").forward(request, response);
		} else {
			request.setAttribute("qna_title", qna_title);			
			request.setAttribute("qna_content", qna_content);
			// ���� �������� �̵�			
			request.setAttribute("menuNum", "70");
			request.setAttribute("spage", "/board_qna/qna_update.jsp");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}		
	}

	// Q&A �Խù� ����
	protected void qna_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));

		QnaDAO dao = QnaDAO.getInstance();

		int n = dao.qna_delete(qna_num);

		response.sendRedirect("/qna.do?cmd=qna_read");
	}
}
