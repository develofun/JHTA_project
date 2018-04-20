package travel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.dao.MemberDAO;
import travel.dto.MemberDTO;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		if (cmd.equals("member_insert_page")) {
			// request.setAttribute("menuNum","30");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_member/member_Join.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		} else if (cmd.equals("member_insert")) {
			member_insert(request, response); // insert 메소드의 파라미터로 request와
												// response를 보내주었다.
		} else if (cmd.equals("member_login")) {
			member_login(request, response);
		} else if (cmd.equals("member_tab_login")) {
			member_tab_login(request, response);
		} else if (cmd.equals("member_find")) {
			member_find(request, response);
		} else if (cmd.equals("member_find_page")) {
			// request.setAttribute("menuNum","30");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_member/member_Find.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		} else if (cmd.equals("member_detail_to_update")) {
			member_detail_to_update(request, response);
		} else if (cmd.equals("member_update")) {
			member_update(request, response);
		}
	}

	protected void member_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String login_id = request.getParameter("login_id");
		String customer_num=(String)session.getAttribute("customer_num");
		String member_password = request.getParameter("member_password");
		String member_nickname = request.getParameter("member_nickname");
		String member_name = request.getParameter("member_name");
		String member_birthday = request.getParameter("member_birthday");
		String member_phone = request.getParameter("member_phone");
		String member_email = request.getParameter("member_email");
		System.out.println("컨트롤러 출력:" + member_password + member_nickname + member_name);
		MemberDTO dto = new MemberDTO(0, customer_num, login_id, member_password, member_nickname, member_name, member_birthday,
				Integer.parseInt(member_phone), member_email, null, null);
		MemberDAO dao = MemberDAO.getInstance();
		int n = dao.update(dto);
		if (n > 0) {
			session.setAttribute("member_nickname", member_nickname);
			response.sendRedirect("/move.do?cmd=main");
		} else {
			response.sendRedirect("/move.do?cmd=main");
		}
	}

	protected void member_detail_to_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customer_num = (String) session.getAttribute("customer_num");
		// System.out.println("멤버콘트롤러 출력:"+customer_num); 출력됨
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.detail(customer_num);
		request.setAttribute("spage", "/board_member/member_update.jsp");
		request.setAttribute("dto", dto);
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);

	}

	protected void member_login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login_id = request.getParameter("login_id");
		String member_password = request.getParameter("member_password");
		String id_save = request.getParameter("id_save");
		// System.out.println(login_id+","+member_password); 정상 출력
		HashMap<String, String> map = new HashMap<>();
		map.put("login_id", login_id);
		map.put("member_password", member_password);

		MemberDAO dao = MemberDAO.getInstance();

		HashMap<String, String> n = dao.login(map);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		if (n != null) {
			String customer_num = n.get("customer_num");
			String member_nickname = n.get("member_nickname");
			String member_power = n.get("member_power");

			HttpSession session = request.getSession();// 세션얻어오기
			session.setAttribute("member_nickname", member_nickname);// 세션에 담기
			session.setAttribute("customer_num", customer_num);
			session.setAttribute("member_power", member_power);
			pw.println("<login>");
			if (id_save.equals("true")) {
				Cookie cookId = new Cookie("input_id", login_id);
				cookId.setMaxAge(60 * 60);
				response.addCookie(cookId);

				Cookie cookCheck = new Cookie("check", "on");
				cookId.setMaxAge(60 * 60);
				response.addCookie(cookCheck);
			} else {
				Cookie cookId = new Cookie("input_id", null);
				cookId.setMaxAge(60 * 60);
				response.addCookie(cookId);

				Cookie cookCheck = new Cookie("check", null);
				cookId.setMaxAge(60 * 60);
				response.addCookie(cookCheck);
			}
			pw.println("<result>success</result>");
			pw.println("</login>");
		} else {
			pw.println("<login>");
			pw.println("<result>failed</result>");
			pw.println("<id>" + login_id + "</id>");
			pw.println("<password>" + member_password + "</password>");
			pw.println("</login>");
		}
	}

	protected void member_tab_login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login_id = request.getParameter("login_id");
		String member_password = request.getParameter("member_password");
		String id_save = request.getParameter("id_save");
		System.out.println(id_save);
		HashMap<String, String> map = new HashMap<>();
		map.put("login_id", login_id);
		map.put("member_password", member_password);

		MemberDAO dao = MemberDAO.getInstance();

		HashMap<String, String> n = dao.login(map);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		if (n != null) {
			if (id_save == "true") {
				Cookie cookId = new Cookie("input_id", login_id);
				cookId.setMaxAge(60 * 60);
				response.addCookie(cookId);

				Cookie cookCheck = new Cookie("check", "on");
				cookCheck.setMaxAge(60 * 60);
				response.addCookie(cookCheck);
			} else {
				Cookie cookId = new Cookie("input_id", null);
				cookId.setMaxAge(0);
				response.addCookie(cookId);

				Cookie cookCheck = new Cookie("check", null);
				cookCheck.setMaxAge(60 * 60);
				response.addCookie(cookCheck);
			}
			String customer_num = n.get("customer_num");
			String member_nickname = n.get("member_nickname");
			String member_power = n.get("member_power");
			HttpSession session = request.getSession();// 세션얻어오기
			session.setAttribute("member_nickname", member_nickname);// 세션에 닉네임
																		// 담기
			session.setAttribute("customer_num", customer_num);
			session.setAttribute("member_power", member_power);
			// System.out.println(login_id+","+member_password); 정상출력
			pw.println("<login>");
			pw.println("<result>success</result>");
			pw.println("<nickname>" + member_nickname + "</nickname>");
			pw.println("</login>");
		} else {
			pw.println("<login>");
			pw.println("<result>failed</result>");
			pw.println("<id>" + login_id + "</id>");
			pw.println("<password>" + member_password + "</password>");
			pw.println("</login>");
		}
	}

	protected void member_insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String login_id = request.getParameter("login_id");
		String member_password = request.getParameter("member_password");
		String member_nickname = request.getParameter("member_nickname");
		String member_name = request.getParameter("member_name");
		String member_birthday = request.getParameter("member_birthday");
		String member_phone = request.getParameter("member_phone");
		String member_email = request.getParameter("member_email");
		// System.out.println(login_id); 아이디 정상 출력
		MemberDTO dto = new MemberDTO(0, null, login_id, member_password, member_nickname, member_name, member_birthday,
				Integer.parseInt(member_phone), member_email, null, null);
		MemberDAO dao = MemberDAO.getInstance();
		int n = dao.insert(dto);
		if (n > 0) {
			// 가입완료 메세지 추가할 것
			response.sendRedirect("/move.do?cmd=main");
		} else {

			// 오류일때 경로 설정
			// response.sendRedirect("/move.do?cmd=main");

			request.setAttribute("login_id", login_id);
			request.setAttribute("member_nickname", member_nickname);
			request.setAttribute("member_name", member_name);
			request.setAttribute("member_phone", member_phone);
			request.setAttribute("member_email", member_email);
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_member/member_Join.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);

		}
	}

	protected void member_find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String id = "", password = "";

		HashMap<String, String> map = new HashMap<>();
		map.put("user_name", user_name);
		map.put("user_email", user_email);

		MemberDAO dao = MemberDAO.getInstance();

		if (user_id != null) {
			map.put("user_id", user_id);
			password = dao.find_password(map);
			request.setAttribute("find_what", "비밀번호");
			request.setAttribute("find_result", password);
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_member/find_result.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		} else {
			id = dao.find_id(map);
			request.setAttribute("find_what", "아이디");
			request.setAttribute("find_result", id);
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_member/find_result.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
	}
}
