package travel.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import travel.dao.KboardDAO;
import travel.dto.KboardDTO;

@WebServlet("/kboard.do")
public class KboardController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		if (cmd.equals("kboard_read")) {
			kboard_read(request, response);
		} else if (cmd.equals("kboard_create")) {
			kboard_create(request, response);
		} else if (cmd.equals("kboard_detail")) {
			kboard_detail(request, response);
		} else if (cmd.equals("kboard_create_form")) {
			kboard_create_form(request, response);
		} else if (cmd.equals("kboard_delete")) {
			kboard_delete(request, response);
		} else if (cmd.equals("kboard_result")) {
			kboard_result(request, response);
		} else if (cmd.equals("kboard_update")) {
			kboard_update(request,response);
		} else if (cmd.equals("kboard_update_form")) {
			kboard_update_form(request,response);
		} else if (cmd.equals("kboard_update_result")) {
			kboard_update_result(request, response);
		}
	}
	
	protected void kboard_update_result(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_kboard/kboard_update_result.jsp");
		request.setAttribute("menuNum", "10");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	protected void kboard_update_form(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int kboard_num = Integer.parseInt(request.getParameter("kboard_num"));
		KboardDAO dao = new KboardDAO();
		KboardDTO dto = dao.detail(kboard_num);
		request.setAttribute("dto", dto);
		request.setAttribute("menuNum", "10");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_kboard/kboard_update.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	
	protected void kboard_update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath=getServletContext().getRealPath("/kimages");
		MultipartRequest mr=new MultipartRequest(
			request, //request객체
			uploadPath, //파일을 저장할 경로
			1024*1024*5, //최대 업로드 사이즈(byte단위 - 5mb)
			"utf-8", //인코딩타입
			new DefaultFileRenamePolicy()//동일한 파일명이 존재시 파일끝에 숫자붙이기
		);
		
		int kboard_num = Integer.parseInt(mr.getParameter("kboard_num"));
		String kboard_title = mr.getParameter("kboard_title");
		String kboard_imgname = mr.getOriginalFileName("kboard_imgname");
		String kboard_save_imgname = mr.getFilesystemName("kboard_imgname");
		String kboard_content = mr.getParameter("kboard_content");
		kboard_content = kboard_content.replace("\r\n","<br>");
		String kboard_plus_content = mr.getParameter("kboard_plus_content");
		kboard_plus_content = kboard_plus_content.replace("\r\n","<br>");
		String kboard_addr = mr.getParameter("kboard_addr");
		String kboard_x = mr.getParameter("kboard_x");
		String kboard_y = mr.getParameter("kboard_y");
		KboardDAO dao=new KboardDAO();
		
		KboardDTO dto=dao.detail(kboard_num);
		String orgFileName=dto.getKboard_imgname();
		String fileSystemName=dto.getKboard_save_imgname();
		int n=0;
		//KboardDTO dto=new KboardDTO(kboard_num, null, null, null, kboard_title, kboard_imgname, kboard_save_imgname, kboard_content, kboard_plus_content, kboard_addr, kboard_x, kboard_y);
		//int n=dao.update(dto);
		if(kboard_imgname==null){
			KboardDTO dto1=new KboardDTO(kboard_num, null, null, null, kboard_title, dto.getKboard_imgname(), dto.getKboard_save_imgname(), kboard_content, kboard_plus_content,
					kboard_addr, kboard_x, kboard_y);
			n=dao.update(dto1);
		}else{
			String delFile=uploadPath+"\\" + fileSystemName;
			File f=new File(delFile);
			f.delete();
			KboardDTO dto1=new KboardDTO(kboard_num, null, null, null, kboard_title, kboard_imgname, kboard_save_imgname, kboard_content, kboard_plus_content,
					kboard_addr, kboard_x, kboard_y);
			n=dao.update(dto1);
		}
		if(n>0){
			request.setAttribute("dto", dto);
			request.setAttribute("menuNum", "10");
			request.setAttribute("result", "success");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_kboard/kboard_update_result.jsp");
		}else{
			request.setAttribute("dto", dto);
			request.setAttribute("menuNum", "10");
			request.setAttribute("result", "fail");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_kboard/kboard_update_result.jsp");
		}
		request.getRequestDispatcher("/kboard.do?cmd=kboard_update_result").forward(request, response);
	}
	
	protected void kboard_delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int kboard_num = Integer.parseInt(request.getParameter("kboard_num"));
		KboardDAO dao = new KboardDAO();
		KboardDTO dto = dao.detail(kboard_num);
		String kboard_save_imgname=dto.getKboard_save_imgname();
		String ff=getServletContext().getRealPath("/kimages")+"//"+kboard_save_imgname;
		
		File f=new File(ff);
		f.delete();
		
		int n=dao.delete(kboard_num);
		if (n > 0) {
			request.setAttribute("menuNum", "10");
			request.setAttribute("result", "success");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_kboard/kboard_result.jsp");
		} else {
			request.setAttribute("menuNum", "10");
			request.setAttribute("result", "fail");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_kboard/kboard_result.jsp");
		}
		request.getRequestDispatcher("/kboard.do?cmd=kboard_result").forward(request, response);
	}
	

	protected void kboard_create_form(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("menuNum", "10");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_kboard/kboard_create.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	
	protected void kboard_result(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("menuNum", "10");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_kboard/kboard_result.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void kboard_detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int kboard_num = Integer.parseInt(request.getParameter("kboard_num"));
		KboardDAO dao = new KboardDAO();
		KboardDTO dto = dao.detail(kboard_num);
		request.setAttribute("dto", dto);
		request.setAttribute("menuNum", "10");
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_kboard/kboard_detail.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void kboard_read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPageNum = request.getParameter("pageNum");
		String kboard_area = request.getParameter("kboard_area");
		String kboard_city = request.getParameter("kboard_city");
		String kboard_category = request.getParameter("kboard_category");
		
		int pageNum = 1;
		if (sPageNum != null) {
			pageNum = Integer.parseInt(sPageNum);
		}

		int startRow = (pageNum - 1) * 9 + 1;
		int endRow = pageNum * 9;

		KboardDAO dao = new KboardDAO();
		ArrayList<KboardDTO> list = dao.kboard_read(startRow, endRow, kboard_area, kboard_city, kboard_category);

		int pageCount = (int) Math.ceil(dao.getCount(kboard_area, kboard_city, kboard_category) / 9.0);
		int startPage = 1 + (pageNum - 1) / 10 * 10;
		int endPage = startPage + 9;
		if (endPage > pageCount) {
			endPage = pageCount;
		}

		request.setAttribute("list", list);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("menuNum", "10");
		request.setAttribute("cmd", request.getParameter("cmd"));
		request.setAttribute("cpage", "/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_kboard/kboard_read.jsp");
		
		request.setAttribute("kboard_area", kboard_area);
		request.setAttribute("kboard_city", kboard_city);
		request.setAttribute("kboard_category",kboard_category);
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}

	protected void kboard_create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath=getServletContext().getRealPath("/kimages");
		MultipartRequest mr=new MultipartRequest(
				request,
				uploadPath,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
		);
		
		String kboard_area = mr.getParameter("kboard_area");
		String kboard_city = mr.getParameter("kboard_city");
		String kboard_category = mr.getParameter("kboard_category");
		String kboard_title = mr.getParameter("kboard_title");
		String kboard_imgname=mr.getOriginalFileName("kboard_imgname");
		String kboard_save_imgname = mr.getFilesystemName("kboard_imgname");
		String kboard_content = mr.getParameter("kboard_content");
		kboard_content = kboard_content.replace("\r\n","<br>");
		String kboard_plus_content = mr.getParameter("kboard_plus_content");
		kboard_plus_content = kboard_plus_content.replace("\r\n","<br>");
		String kboard_addr = mr.getParameter("kboard_addr");
		String kboard_x = mr.getParameter("kboard_x");
		String kboard_y = mr.getParameter("kboard_y");
		KboardDAO dao = new KboardDAO();
		System.out.println(uploadPath);
		File f=new File(uploadPath+"\\"+kboard_save_imgname);
		
		KboardDTO dto = new KboardDTO(0, kboard_area, kboard_city, kboard_category, kboard_title, kboard_imgname, kboard_save_imgname,
				kboard_content, kboard_plus_content, kboard_addr, kboard_x, kboard_y);
		
		int n = dao.Kboard_create(dto);
		if (n > 0) {
			request.setAttribute("menuNum", "10");
			request.setAttribute("result", "success");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_kboard/kboard_result.jsp");
		} else {
			request.setAttribute("menuNum", "10");
			request.setAttribute("result", "fail");
			request.setAttribute("cpage", "/layout/detail_login.jsp");
			request.setAttribute("spage", "/board_kboard/kboard_result.jsp");
		}
		request.getRequestDispatcher("/kboard.do?cmd=kboard_result").forward(request, response);
	}
}
