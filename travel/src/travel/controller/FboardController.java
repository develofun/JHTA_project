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
import travel.dao.FboardDAO;
import travel.dto.FboardAttractionDTO;
import travel.dto.FboardAttractionImageDTO;
import travel.dto.FboardDTO;
import travel.dto.FboardFestivalDTO;
import travel.dto.FboardFestivalImageDTO;
import travel.dto.FboardReadAllDTO;
import travel.dto.FboardRestaurantDTO;
import travel.dto.FboardRestaurantImageDTO;
import travel.dto.FboardShoppingDTO;
import travel.dto.FboardShoppingImageDTO;

@WebServlet("/fboard.do")
public class FboardController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("fboard_read")){
			fboard_read(request,response);
		}else if(cmd.equals("fboard_read_search")){
			fboard_read_search(request,response);
		}else if(cmd.equals("fboard_create_form")){
			fboard_create_form(request,response);
		}else if(cmd.equals("fboard_create")){
			fboard_create(request,response);
		}else if(cmd.equals("fboard_detail")){
			fboard_detail(request,response);
		}else if(cmd.equals("fboard_update_form")){
			fboard_update_form(request,response);
		}else if(cmd.equals("fboard_update")){
			fboard_update(request,response);
		}else if(cmd.equals("fboard_delete")){
			fboard_delete(request,response);
		}
	}
	//�ؿܿ��� ������
	//��ü
	private void fboard_read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spageNum=request.getParameter("pageNum");//������ ���� Ŭ���óѾ���� ������ ��ȣ
		int pageNum=1;//��������ȣ
		boolean next_page=false;//����
		boolean preview_page=false;//����
		boolean next_page10=false;//+10
		boolean preview_page10=false;//-10
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*9+1;//������
		int endRow=startRow+8;//��������
		FboardDAO dao=new FboardDAO();
		//��ü ������ ����
		int pageCount=(int)Math.ceil(dao.getCount_read_all()/9.0);
		//����������
		int startPage=((pageNum-1)/10)*10+1;
		//������������
		int endPage=startPage+9;
		if(pageCount<endPage){endPage=pageCount;}
		//����/����
		if(pageCount>1){
			next_page=true;
			if(pageNum!=1){
				preview_page=true;
			}
			if(pageNum==endPage){
				next_page=false;
			}
		}
		//+10/-10
		if(startPage==1){
			if(pageCount>10){
				next_page10=true;
			}
		}
		if(startPage>10){
			preview_page10=true;
			next_page10=true;
			if(pageNum==endPage){
				next_page10=false;
			}
		}
		
		
		
		
		ArrayList<FboardReadAllDTO> list=dao.fboard_read_all(startRow, endRow);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("preview_page", preview_page);
		request.setAttribute("next_page", next_page);
		request.setAttribute("preview_page10", preview_page10);
		request.setAttribute("next_page10", next_page10);
		request.setAttribute("menuNum", "20");
		request.setAttribute("cpage","/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_fboard/fboard_read.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	//�˻�
	private void fboard_read_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spageNum=request.getParameter("pageNum");//������ ���� Ŭ���óѾ���� ������ ��ȣ
		String fboard_area=request.getParameter("fboard_area");
		String fboard_city=request.getParameter("fboard_city");
		String fboard_category=request.getParameter("fboard_category");
		ArrayList<FboardReadAllDTO> list=new ArrayList<>();
		FboardDAO dao=new FboardDAO();
		int read_num=0;
		int pageNum=1;//��������ȣ
		boolean next_page=false;
		boolean preview_page=false;
		boolean next_page10=false;
		boolean preview_page10=false;
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*9+1;//������
		int endRow=startRow+8;//��������
		//��������
		if(fboard_area==""){//��������x
			if(fboard_city!=null&&fboard_city!=""){
				if(fboard_category!=null&&fboard_category!=""){//����+ī�װ�
					read_num=dao.getCount_read_area(null,null,fboard_category);
					list=dao.fboard_read_search(startRow, endRow,null,fboard_city,fboard_category);
				}else{//����
					read_num=dao.getCount_read_area(null,null,fboard_category);
					list=dao.fboard_read_search(startRow, endRow,null,fboard_city,null);
				}
			}else{//ī�װ�
				read_num=dao.getCount_read_area(null,null,fboard_category);
				list=dao.fboard_read_search(startRow, endRow,null,null,fboard_category);
			}
		}else if(fboard_area.equals("������")){
			if(fboard_city!=null&&fboard_city!=""){
				if(fboard_category!=null&&fboard_category!=""){//����+����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,fboard_city,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city, fboard_category);
				}else{//����+����
					read_num=dao.getCount_read_area(fboard_area,fboard_city,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city,null);
				}	
			}else{
				if(fboard_category!=null&&fboard_category!=""){//����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,null,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,fboard_category);
				}else{//����
					read_num=dao.getCount_read_area(fboard_area,null,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,null);
				}
			}
		}else if(fboard_area.equals("�߱�")){
			if(fboard_city!=null&&fboard_city!=""){
				if(fboard_category!=null&&fboard_category!=""){//����+����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,fboard_city,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city, fboard_category);
				}else{//����+����
					read_num=dao.getCount_read_area(fboard_area,fboard_city,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city,null);
				}	
			}else{
				if(fboard_category!=null&&fboard_category!=""){//����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,null,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,fboard_category);
				}else{//����
					read_num=dao.getCount_read_area(fboard_area,null,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,null);
				}
			}
		}else if(fboard_area.equals("�Ϻ�")){
			if(fboard_city!=null&&fboard_city!=""){
				if(fboard_category!=null&&fboard_category!=""){//����+����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,fboard_city,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city, fboard_category);
				}else{//����+����
					read_num=dao.getCount_read_area(fboard_area,fboard_city,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city,null);
				}	
			}else{
				if(fboard_category!=null&&fboard_category!=""){//����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,null,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,fboard_category);
				}else{//����
					read_num=dao.getCount_read_area(fboard_area,null,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,null);
				}
			}
		}else if(fboard_area.equals("����")){
			if(fboard_city!=null&&fboard_city!=""){
				if(fboard_category!=null&&fboard_category!=""){//����+����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,fboard_city,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city, fboard_category);
				}else{//����+����
					read_num=dao.getCount_read_area(fboard_area,fboard_city,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city,null);
				}	
			}else{
				if(fboard_category!=null&&fboard_category!=""){//����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,null,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,fboard_category);
				}else{//����
					read_num=dao.getCount_read_area(fboard_area,null,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,null);
				}
			}
		}else if(fboard_area.equals("����_�߳���")){
			if(fboard_city!=null&&fboard_city!=""){
				if(fboard_category!=null&&fboard_category!=""){//����+����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,fboard_city,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city, fboard_category);
				}else{//����+����
					read_num=dao.getCount_read_area(fboard_area,fboard_city,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, fboard_city,null);
				}	
			}else{
				if(fboard_category!=null&&fboard_category!=""){//����+ī�װ�
					read_num=dao.getCount_read_area(fboard_area,null,fboard_category);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,fboard_category);
				}else{//����
					read_num=dao.getCount_read_area(fboard_area,null,null);
					list=dao.fboard_read_search(startRow, endRow, fboard_area, null,null);
				}
			}
		}
		//��ü ������ ����
		int pageCount=(int)Math.ceil(read_num/9.0);
		//����������
		int startPage=((pageNum-1)/10)*10+1;
		//������������
		int endPage=startPage+9;
		if(pageCount<endPage){endPage=pageCount;}
		//����/����
		if(pageCount>1){
			next_page=true;
			if(pageNum!=1){
			preview_page=true;
			}
			if(pageNum==endPage){
			next_page=false;
			}
		}
		//+10/-10
		if(startPage==1){
			if(pageCount>10){
				next_page10=true;
			}
		}
		if(startPage>10){
			preview_page10=true;
			next_page10=true;
			if(pageNum==endPage){
				next_page10=false;
			}
		}
		request.setAttribute("cmd", "read_search");
		request.setAttribute("fboard_search_area", fboard_area);
		request.setAttribute("fboard_search_city", fboard_city);
		request.setAttribute("fboard_search_category", fboard_category);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("preview_page", preview_page);
		request.setAttribute("next_page", next_page);
		request.setAttribute("preview_page10", preview_page10);
		request.setAttribute("next_page10", next_page10);
		request.setAttribute("menuNum", "20");
		request.setAttribute("cpage","/layout/detail_login.jsp");
		request.setAttribute("spage", "/board_fboard/fboard_read.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	//�۾��� ������
	private void fboard_create_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("spage", "/board_fboard/fboard_create_form.jsp");
		request.setAttribute("menuNum", "20");
		request.setAttribute("cpage","/layout/detail_login.jsp");
		request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
	}
	//�۵��
	private void fboard_create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uploadPath=request.getSession().getServletContext().getRealPath("/fimages");
		request.setAttribute("menuNum", "20");
		MultipartRequest mr=new MultipartRequest(
			request, //request��ü
			uploadPath, //������ ������ ���
			1024*1024*5, //�ִ� ���ε� ������(byte���� - 5mb)
			"utf-8", //���ڵ�Ÿ��
			new DefaultFileRenamePolicy	()//������ ���ϸ��� ����� ���ϳ��� ���ں��̱�
		);
		String fboard_title=mr.getParameter("fboard_title");
		String fboard_sub_title=mr.getParameter("fboard_sub_title");
		String fboard_category=mr.getParameter("fboard_category");
		String fboard_area=mr.getParameter("fboard_area");
		if(fboard_title==null||fboard_title.equals("")){
			request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
		switch(fboard_category){
			case "���":
				String fboard_attraction_time=mr.getParameter("fboard_attraction_time");
				String fboard_attraction_price=mr.getParameter("fboard_attraction_price");
				String fboard_attraction_home_page=mr.getParameter("fboard_attraction_home_page");
				String fboard_attraction_go=mr.getParameter("fboard_attraction_go");
				if(fboard_area.equals("������")){
					String fboard_city1=mr.getParameter("fboard_city1");
					if(fboard_city1.equals("�̰�����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("Ǫ��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�߱�")){
					String fboard_city2=mr.getParameter("fboard_city2");
					if(fboard_city2.equals("��ī��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("ȫ��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("�ϰ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�Ϻ�")){
					String fboard_city3=mr.getParameter("fboard_city3");
					if(fboard_city3.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("����ī")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("�����ī")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����")){
					String fboard_city4=mr.getParameter("fboard_city4");
					if(fboard_city4.equals("�θ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�ĸ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�̽�ź��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����_�߳���")){
					String fboard_city5=mr.getParameter("fboard_city5");
					if(fboard_city5.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�Ͽ���")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�̼���")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardAttractionDTO dto_attraction=new FboardAttractionDTO(0, 0, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardAttractionImageDTO dto_image=new FboardAttractionImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_attraction(dto, dto_attraction, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else{
					request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
					request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				}
				break;
			case "����":
				String fboard_restaurant_time=mr.getParameter("fboard_restaurant_time");
				String fboard_restaurant_price=mr.getParameter("fboard_restaurant_price");
				String fboard_restaurant_home_page=mr.getParameter("fboard_restaurant_home_page");
				String fboard_restaurant_go=mr.getParameter("fboard_restaurant_go");
				if(fboard_area.equals("������")){
					String fboard_city1=mr.getParameter("fboard_city1");
					if(fboard_city1.equals("�̰�����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("Ǫ��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�߱�")){
					String fboard_city2=mr.getParameter("fboard_city2");
					if(fboard_city2.equals("��ī��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("ȫ��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("�ϰ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�Ϻ�")){
					String fboard_city3=mr.getParameter("fboard_city3");
					if(fboard_city3.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("����ī")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("�����ī")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����")){
					String fboard_city4=mr.getParameter("fboard_city4");
					if(fboard_city4.equals("�θ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�ĸ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�̽�ź��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����_�߳���")){
					String fboard_city5=mr.getParameter("fboard_city5");
					if(fboard_city5.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�Ͽ���")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�̼���")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, 0, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardRestaurantImageDTO dto_image=new FboardRestaurantImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_restaurant(dto, restaurant_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else{
					request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
					request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				}
				break;
			case "����":
				String fboard_festival_startDate=mr.getParameter("fboard_festival_startDate");
				String fboard_festival_endDate=mr.getParameter("fboard_festival_endDate");
				String fboard_festival_period=fboard_festival_startDate+"~"+fboard_festival_endDate;
				if(fboard_area.equals("������")){
					String fboard_city1=mr.getParameter("fboard_city1");
					if(fboard_city1.equals("�̰�����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("Ǫ��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�߱�")){
					String fboard_city2=mr.getParameter("fboard_city2");
					if(fboard_city2.equals("��ī��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("ȫ��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("�ϰ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�Ϻ�")){
					String fboard_city3=mr.getParameter("fboard_city3");
					if(fboard_city3.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("����ī")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("�����ī")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����")){
					String fboard_city4=mr.getParameter("fboard_city4");
					if(fboard_city4.equals("�θ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�ĸ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�̽�ź��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����_�߳���")){
					String fboard_city5=mr.getParameter("fboard_city5");
					if(fboard_city5.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�Ͽ���")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�̼���")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, 0, fboard_title, fboard_sub_title, fboard_festival_period, fboard_contents, null);
						FboardFestivalImageDTO dto_image=new FboardFestivalImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_festival(dto, festival_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else{
					request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
					request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				}
				break;
			case "����":
				String fboard_shopping_time=mr.getParameter("fboard_shopping_time");
				String fboard_shopping_home_page=mr.getParameter("fboard_shopping_home_page");
				String fboard_shopping_go=mr.getParameter("fboard_shopping_go");
				if(fboard_area.equals("������")){
					String fboard_city1=mr.getParameter("fboard_city1");
					if(fboard_city1.equals("�̰�����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("Ǫ��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city1, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�߱�")){
					String fboard_city2=mr.getParameter("fboard_city2");
					if(fboard_city2.equals("��ī��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("ȫ��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("�ϰ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city2, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�Ϻ�")){
					String fboard_city3=mr.getParameter("fboard_city3");
					if(fboard_city3.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("����ī")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("�����ī")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city3, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����")){
					String fboard_city4=mr.getParameter("fboard_city4");
					if(fboard_city4.equals("�θ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�ĸ�")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�̽�ź��")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("��Ÿ")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city4, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����_�߳���")){
					String fboard_city5=mr.getParameter("fboard_city5");
					if(fboard_city5.equals("����")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�Ͽ���")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�̼���")){
						String fboard_contents=mr.getParameter("fboard_contents");
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardDTO dto=new FboardDTO(0, fboard_area, fboard_city5, fboard_category);
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, 0, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardShoppingImageDTO dto_image=new FboardShoppingImageDTO(0, 0, fboard_image);
						FboardDAO dao=new FboardDAO();
						int n=dao.create_fboard_shopping(dto, shopping_dto, dto_image);
						if(n>0){
							request.setAttribute("spage", "/board_fboard/fboard_create_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else{
					request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
					request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				}
				break;
			case "ī�װ�":
				request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				break;
		}
	}
	//�� ������
	private void fboard_detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String sfboard_num=request.getParameter("fboard_num");
		  int fboard_num=Integer.parseInt(sfboard_num);
		  String fboard_area=request.getParameter("fboard_area");
		  String fboard_city=request.getParameter("fboard_city");
		  String fboard_category=request.getParameter("fboard_category");
		  FboardDAO dao=new FboardDAO();
		  request.setAttribute("menuNum", "20");
		  if(fboard_category.equals("���")){
			  FboardAttractionDTO attraction_detail=
					  dao.detail_attraction_string(fboard_num);
			  FboardAttractionImageDTO attraction_image=
					  dao.detail_attraction_image(attraction_detail.getFboard_attraction_num());
			  int detail_num=attraction_detail.getFboard_attraction_num();
			  request.setAttribute("fboard_num", fboard_num);
			  request.setAttribute("detail_num", detail_num);
			  request.setAttribute("fboard_area",fboard_area);
			  request.setAttribute("fboard_city",fboard_city);
			  request.setAttribute("fboard_category",fboard_category);
			  request.setAttribute("detail", attraction_detail);
			  request.setAttribute("images", attraction_image);
			  request.setAttribute("cpage","/layout/detail_login.jsp");
			  request.setAttribute("spage", "/board_fboard/fboard_detail.jsp");
			  request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		  }else if(fboard_category.equals("����")){
			  FboardRestaurantDTO restaurant_detail=dao.detail_restaurant_string(fboard_num);
			  FboardRestaurantImageDTO restaurant_image=dao.detail_restaurant_image
					  (restaurant_detail.getFboard_restaurant_num());
			  int detail_num=restaurant_detail.getFboard_restaurant_num();
			  request.setAttribute("fboard_num", fboard_num);
			  request.setAttribute("detail_num", detail_num);
			  request.setAttribute("fboard_area",fboard_area);
			  request.setAttribute("fboard_city",fboard_city);
			  request.setAttribute("fboard_category",fboard_category);
			  request.setAttribute("detail", restaurant_detail);
			  request.setAttribute("images", restaurant_image);
			  request.setAttribute("cpage","/layout/detail_login.jsp");
			  request.setAttribute("spage", "/board_fboard/fboard_detail.jsp");
			  request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		  }else if(fboard_category.equals("����")){
			  FboardFestivalDTO festival_detail=dao.detail_festival(fboard_num);
			  FboardFestivalImageDTO festival_image=dao.detail_festival_image
					  (festival_detail.getFboard_festival_num());
			  int detail_num=festival_detail.getFboard_festival_num();
			  request.setAttribute("fboard_num", fboard_num);
			  request.setAttribute("detail_num", detail_num);
			  request.setAttribute("fboard_area",fboard_area);
			  request.setAttribute("fboard_city",fboard_city);
			  request.setAttribute("fboard_category",fboard_category);
			  request.setAttribute("detail", festival_detail);
			  request.setAttribute("images", festival_image);
			  request.setAttribute("cpage","/layout/detail_login.jsp");
			  request.setAttribute("spage", "/board_fboard/fboard_detail.jsp");
			  request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		  }else if(fboard_category.equals("����")){
			  FboardShoppingDTO shopping_detail=dao.detail_shopping_string(fboard_num);
			  FboardShoppingImageDTO shopping_image=dao.detail_shopping_image
					  (shopping_detail.getFboard_shopping_num());
			  int detail_num=shopping_detail.getFboard_shopping_num();
			  request.setAttribute("fboard_num", fboard_num);
			  request.setAttribute("detail_num", detail_num);
			  request.setAttribute("fboard_area",fboard_area);
			  request.setAttribute("fboard_city",fboard_city);
			  request.setAttribute("fboard_category",fboard_category);
			  request.setAttribute("detail", shopping_detail);
			  request.setAttribute("images", shopping_image);
			  request.setAttribute("cpage","/layout/detail_login.jsp");
			  request.setAttribute("spage", "/board_fboard/fboard_detail.jsp");
			  request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		  }
	}
	//���� ������
	private void fboard_update_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sfboard_num=request.getParameter("fboard_num");
		String detail_num=request.getParameter("detail_num");
		int fboard_num=Integer.parseInt(sfboard_num);
		String fboard_area=request.getParameter("fboard_area");
		  String fboard_city=request.getParameter("fboard_city");
		String fboard_category=request.getParameter("fboard_category");
		System.out.println(sfboard_num+"/"+detail_num+"/"+fboard_area+"/"+ fboard_city+"/"+fboard_category);
		FboardDAO dao=new FboardDAO();
		request.setAttribute("menuNum", "20");
		 if(fboard_category.equals("���")){
			 FboardAttractionDTO attraction_detail=
					  dao.detail_attraction_string(fboard_num);
			 FboardAttractionImageDTO attraction_image=
					  dao.detail_attraction_image(attraction_detail.getFboard_attraction_num());
			 request.setAttribute("fboard_num", fboard_num);
			 request.setAttribute("detail_num", detail_num);
			 request.setAttribute("fboard_area",fboard_area);
			 request.setAttribute("fboard_city",fboard_city);
			 request.setAttribute("fboard_category",fboard_category);
			 request.setAttribute("detail", attraction_detail);
			 request.setAttribute("images", attraction_image);
			 request.setAttribute("cpage","/layout/detail_login.jsp");
			 request.setAttribute("spage", "/board_fboard/fboard_update_form.jsp");
			 request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		 }else if(fboard_category.equals("����")){
			  FboardRestaurantDTO restaurant_detail=dao.detail_restaurant_string(fboard_num);
			  FboardRestaurantImageDTO restaurant_image=dao.detail_restaurant_image
					  (restaurant_detail.getFboard_restaurant_num());
			 request.setAttribute("fboard_num", fboard_num);
			 request.setAttribute("detail_num", detail_num);
			 request.setAttribute("fboard_area",fboard_area);
			 request.setAttribute("fboard_city",fboard_city);
			 request.setAttribute("fboard_category",fboard_category);
			 request.setAttribute("detail", restaurant_detail);
			 request.setAttribute("images", restaurant_image);
			 request.setAttribute("cpage","/layout/detail_login.jsp");
			 request.setAttribute("spage", "/board_fboard/fboard_update_form.jsp");
			 request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		 }else if(fboard_category.equals("����")){
			  FboardFestivalDTO festival_detail=dao.detail_festival(fboard_num);
			  FboardFestivalImageDTO festival_image=dao.detail_festival_image
					  (festival_detail.getFboard_festival_num());
			 request.setAttribute("fboard_num", fboard_num);
			 request.setAttribute("detail_num", detail_num);
			 request.setAttribute("fboard_area",fboard_area);
			 request.setAttribute("fboard_city",fboard_city);
			 request.setAttribute("fboard_category",fboard_category);
			 request.setAttribute("detail", festival_detail);
			 request.setAttribute("images", festival_image);
			 request.setAttribute("cpage","/layout/detail_login.jsp");
			 request.setAttribute("spage", "/board_fboard/fboard_update_form.jsp");
			 request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		 }else if(fboard_category.equals("����")){
			  FboardShoppingDTO shopping_detail=dao.detail_shopping_string(fboard_num);
			  FboardShoppingImageDTO shopping_image=dao.detail_shopping_image
					  (shopping_detail.getFboard_shopping_num());
			 request.setAttribute("fboard_num", fboard_num);
			 request.setAttribute("detail_num", detail_num);
			 request.setAttribute("fboard_area",fboard_area);
			 request.setAttribute("fboard_city",fboard_city);
			 request.setAttribute("fboard_category",fboard_category);
			 request.setAttribute("detail", shopping_detail);
			 request.setAttribute("images", shopping_image);
			 request.setAttribute("cpage","/layout/detail_login.jsp");
			 request.setAttribute("spage", "/board_fboard/fboard_update_form.jsp");
			 request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		 }
	}
	//����
	private void fboard_update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String uploadPath=request.getSession().getServletContext().getRealPath("/fimages");
		MultipartRequest mr=new MultipartRequest(
				request, //request��ü
				uploadPath, //������ ������ ���
				1024*1024*5, //�ִ� ���ε� ������(byte���� - 5mb)
				"utf-8", //���ڵ�Ÿ��
				new DefaultFileRenamePolicy	()//������ ���ϸ��� ����� ���ϳ��� ���ں��̱�
		);
		String sfboard_num=mr.getParameter("fboard_num");
		int fboard_num=Integer.parseInt(sfboard_num);
		String sdetail_num=mr.getParameter("detail_num");
		int detail_num=Integer.parseInt(sdetail_num);
		String fboard_title=mr.getParameter("fboard_title");
		String fboard_sub_title=mr.getParameter("fboard_sub_title");
		String fboard_contents=mr.getParameter("fboard_contents");
		String fboard_category=mr.getParameter("fboard_category");
		String fboard_area=mr.getParameter("fboard_area");
		FboardDAO fboard_dao=new FboardDAO();
		request.setAttribute("fboard_num", fboard_num);
		request.setAttribute("detail_num",detail_num);
		request.setAttribute("fboard_area", fboard_area);
		request.setAttribute("fboard_category", fboard_category);
		if(fboard_title==null||fboard_title.equals("")){
			request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
			request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
		}
		switch(fboard_category){
			case "���":
				String fboard_attraction_time=mr.getParameter("fboard_attraction_time");
				String fboard_attraction_price=mr.getParameter("fboard_attraction_price");
				String fboard_attraction_home_page=mr.getParameter("fboard_attraction_home_page");
				String fboard_attraction_go=mr.getParameter("fboard_attraction_go");
				if(fboard_area.equals("������")){
					String fboard_city1=mr.getParameter("fboard_city1");
					request.setAttribute("fboard_city", fboard_city1);
					if(fboard_city1.equals("�̰�����")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("Ǫ��")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("��Ÿ")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�߱�")){
					String fboard_city2=mr.getParameter("fboard_city2");
					request.setAttribute("fboard_city", fboard_city2);
					if(fboard_city2.equals("��ī��")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("ȫ��")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("����")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("�ϰ�")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("��Ÿ")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("�Ϻ�")){
					String fboard_city3=mr.getParameter("fboard_city3");
					request.setAttribute("fboard_city", fboard_city3);
					if(fboard_city3.equals("����")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("����ī")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("�����ī")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("����")){
					String fboard_city4=mr.getParameter("fboard_city4");
					request.setAttribute("fboard_city", fboard_city4);
					if(fboard_city4.equals("�θ�")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�ĸ�")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�̽�ź��")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("��Ÿ")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_create_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����_�߳���")){
					String fboard_city5=mr.getParameter("fboard_city5");
					request.setAttribute("fboard_city", fboard_city5);
					if(fboard_city5.equals("����")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�Ͽ���")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�̼���")){
						FboardAttractionDTO attraction_dto=new FboardAttractionDTO(0,fboard_num, fboard_title, fboard_sub_title, fboard_attraction_time, fboard_attraction_price, fboard_attraction_home_page, fboard_attraction_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardAttractionImageDTO pre_image=fboard_dao.detail_attraction_image(detail_num);
						if(fboard_image==null){
							FboardAttractionImageDTO image_null=fboard_dao.detail_attraction_image(detail_num);
							fboard_image=image_null.getFboard_attraction_image_name();
						}
						FboardAttractionImageDTO image_dto=new FboardAttractionImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_attraction(fboard_dto, attraction_dto, image_dto,fboard_num,detail_num);
						
						if(n>0){
							if(pre_image.getFboard_attraction_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_attraction_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else{
					request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
					request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				}
				break;
			case "����":
				String fboard_restaurant_time=mr.getParameter("fboard_restaurant_time");
				String fboard_restaurant_price=mr.getParameter("fboard_restaurant_price");
				String fboard_restaurant_home_page=mr.getParameter("fboard_restaurant_home_page");
				String fboard_restaurant_go=mr.getParameter("fboard_restaurant_go");
				if(fboard_area.equals("������")){
					String fboard_city1=mr.getParameter("fboard_city1");
					request.setAttribute("fboard_city", fboard_city1);
					if(fboard_city1.equals("�̰�����")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("Ǫ��")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("��Ÿ")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("�߱�")){
					String fboard_city2=mr.getParameter("fboard_city2");
					request.setAttribute("fboard_city", fboard_city2);
					if(fboard_city2.equals("��ī��")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("ȫ��")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("����")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("�ϰ�")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("��Ÿ")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("�Ϻ�")){
					String fboard_city3=mr.getParameter("fboard_city3");
					request.setAttribute("fboard_city", fboard_city3);
					if(fboard_city3.equals("����")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("����ī")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("�����ī")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("����")){
					String fboard_city4=mr.getParameter("fboard_city4");
					request.setAttribute("fboard_city", fboard_city4);
					if(fboard_city4.equals("�θ�")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�ĸ�")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("����")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�̽�ź��")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("��Ÿ")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
						request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
					}
				}else if(fboard_area.equals("����_�߳���")){
					String fboard_city5=mr.getParameter("fboard_city5");
					request.setAttribute("fboard_city", fboard_city5);
					if(fboard_city5.equals("����")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�Ͽ���")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�̼���")){
						FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_restaurant_time, fboard_restaurant_price, fboard_restaurant_home_page, fboard_restaurant_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardRestaurantImageDTO pre_image=fboard_dao.detail_restaurant_image(detail_num);
						if(fboard_image==null){
							FboardRestaurantImageDTO image_null=fboard_dao.detail_restaurant_image(detail_num);
							fboard_image=image_null.getFboard_restaurant_image();
						}
						FboardRestaurantImageDTO image_dto=new FboardRestaurantImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_restaurant(fboard_dto, restaurant_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_restaurant_image().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_restaurant_image();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else{
					request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
					request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				}
				break;
			case "����":
				String fboard_festival_startDate=mr.getParameter("fboard_festival_startDate");
				String fboard_festival_endDate=mr.getParameter("fboard_festival_endDate");
				String fboard_festival_period=fboard_festival_startDate+""+fboard_festival_endDate;
				if(fboard_area.equals("������")){
					String fboard_city1=mr.getParameter("fboard_city1");
					request.setAttribute("fboard_city", fboard_city1);
					if(fboard_city1.equals("�̰�����")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("Ǫ��")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("��Ÿ")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("�߱�")){
					String fboard_city2=mr.getParameter("fboard_city2");
					request.setAttribute("fboard_city", fboard_city2);
					if(fboard_city2.equals("��ī��")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("ȫ��")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("����")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("�ϰ�")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("��Ÿ")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("�Ϻ�")){
					String fboard_city3=mr.getParameter("fboard_city3");
					request.setAttribute("fboard_city", fboard_city3);
					if(fboard_city3.equals("����")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("����ī")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("�����ī")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("����")){
					String fboard_city4=mr.getParameter("fboard_city4");
					request.setAttribute("fboard_city", fboard_city4);
					if(fboard_city4.equals("�θ�")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�ĸ�")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("����")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�̽�ź��")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("��Ÿ")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("����_�߳���")){
					String fboard_city5=mr.getParameter("fboard_city5");
					request.setAttribute("fboard_city", fboard_city5);
					if(fboard_city5.equals("����")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�Ͽ���")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�̼���")){
						FboardFestivalDTO festival_dto=new FboardFestivalDTO(0, fboard_num, fboard_title, fboard_title, fboard_festival_period, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardFestivalImageDTO pre_image=fboard_dao.detail_festival_image(detail_num);
						if(fboard_image==null){
							FboardFestivalImageDTO image_null=fboard_dao.detail_festival_image(detail_num);
							fboard_image=image_null.getFboard_festival_image_name();
						}
						FboardFestivalImageDTO image_dto=new FboardFestivalImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_festival(fboard_dto, festival_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_festival_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_festival_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else{
					request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
					request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				}
				break;
			case "����":
				String fboard_shopping_time=mr.getParameter("fboard_shopping_time");
				String fboard_shopping_home_page=mr.getParameter("fboard_shopping_home_page");
				String fboard_shopping_go=mr.getParameter("fboard_shopping_go");
				if(fboard_area.equals("������")){
					String fboard_city1=mr.getParameter("fboard_city1");
					request.setAttribute("fboard_city", fboard_city1);
					if(fboard_city1.equals("�̰�����")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("Ǫ��")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("����")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city1.equals("��Ÿ")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city1, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("�߱�")){
					String fboard_city2=mr.getParameter("fboard_city2");
					request.setAttribute("fboard_city", fboard_city2);
					if(fboard_city2.equals("��ī��")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("ȫ��")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("����")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("�ϰ�")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city2.equals("��Ÿ")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city2, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("�Ϻ�")){
					String fboard_city3=mr.getParameter("fboard_city3");
					request.setAttribute("fboard_city", fboard_city3);
					if(fboard_city3.equals("����")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("����ī")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city3.equals("�����ī")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city3, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("����")){
					String fboard_city4=mr.getParameter("fboard_city4");
					request.setAttribute("fboard_city", fboard_city4);
					if(fboard_city4.equals("�θ�")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�ĸ�")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("����")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("�̽�ź��")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city4.equals("��Ÿ")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city4, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else if(fboard_area.equals("����_�߳���")){
					String fboard_city5=mr.getParameter("fboard_city5");
					request.setAttribute("fboard_city", fboard_city5);
					if(fboard_city5.equals("����")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�Ͽ���")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}else if(fboard_city5.equals("�̼���")){
						FboardShoppingDTO shopping_dto=new FboardShoppingDTO(0, fboard_num, fboard_title, fboard_sub_title, fboard_shopping_time, fboard_shopping_home_page, fboard_shopping_go, fboard_contents, null);
						FboardDTO fboard_dto=new FboardDTO(fboard_num, fboard_area, fboard_city5, fboard_category);
						String fboard_image=mr.getFilesystemName("fboard_image");
						FboardShoppingImageDTO pre_image=fboard_dao.detail_shopping_image(detail_num);
						if(fboard_image==null){
							FboardShoppingImageDTO image_null=fboard_dao.detail_shopping_image(detail_num);
							fboard_image=image_null.getFboard_shopping_image_name();
						}
						FboardShoppingImageDTO image_dto=new FboardShoppingImageDTO(0, detail_num, fboard_image);
						int n=fboard_dao.update_shopping(fboard_dto, shopping_dto, image_dto, fboard_num, detail_num);
						if(n>0){
							if(pre_image.getFboard_shopping_image_name().equals(fboard_image)){	
							}else{
								String delfile=uploadPath+"\\"+pre_image.getFboard_shopping_image_name();
								File f=new File(delfile);
								f.delete();
							}
							request.setAttribute("spage", "/board_fboard/fboard_update_success.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}else{
							String delfile=uploadPath+"\\"+fboard_image;
							File f=new File(delfile);
							f.delete();
							request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
							request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
						}
					}
				}else{
					request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
					request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				}
				break;
			case "ī�װ�":
				request.setAttribute("spage", "/board_fboard/fboard_update_fail.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
				break;
		}
	}
	//����
	private void fboard_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath=request.getSession().getServletContext().getRealPath("/fimages");
		String fboard_num=request.getParameter("fboard_num");
		String detail_num=request.getParameter("detail_num");
		int detail_num_i=Integer.parseInt(detail_num);
		String fboard_area=request.getParameter("fboard_area");
		String fboard_city=request.getParameter("fbaord_city");
		String fboard_category=request.getParameter("fboard_category");
		request.setAttribute("fboard_area", fboard_area);
		request.setAttribute("fboard_city", fboard_city);
		request.setAttribute("fboard_category", fboard_category);
		FboardDAO fboard_dao=new FboardDAO();
		if(fboard_category.equals("���")){
			FboardAttractionImageDTO delete_image=fboard_dao.detail_attraction_image(detail_num_i);
			String delfile=uploadPath+"\\"+delete_image.getFboard_attraction_image_name();
			File f=new File(delfile);
			f.delete();
			int n=fboard_dao.delete_attraction(fboard_num,detail_num);
			if(n>0){
				request.setAttribute("spage", "/board_fboard/fboard_delete_success.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
			}else{
				request.setAttribute("spage", "/board_fboard/fboard_delete_fail.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
			}
		}else if(fboard_category.equals("����")){
			FboardRestaurantImageDTO delete_image=fboard_dao.detail_restaurant_image(detail_num_i);
			String delfile=uploadPath+"\\"+delete_image.getFboard_restaurant_image();
			File f=new File(delfile);
			f.delete();
			int n=fboard_dao.delete_restaurant(fboard_num,detail_num);
			if(n>0){
				request.setAttribute("spage", "/board_fboard/fboard_delete_success.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
			}else{
				request.setAttribute("spage", "/board_fboard/fboard_delete_fail.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
			}
		}else if(fboard_category.equals("����")){
			FboardFestivalImageDTO delete_image=fboard_dao.detail_festival_image(detail_num_i);
			String delfile=uploadPath+"\\"+delete_image.getFboard_festival_image_name();
			File f=new File(delfile);
			f.delete();
			int n=fboard_dao.delete_festival(fboard_num,detail_num);
			if(n>0){
				request.setAttribute("spage", "/board_fboard/fboard_delete_success.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
			}else{
				request.setAttribute("spage", "/board_fboard/fboard_delete_fail.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
			}
		}else if(fboard_category.equals("����")){
			FboardShoppingImageDTO delete_image=fboard_dao.detail_shopping_image(detail_num_i);
			String delfile=uploadPath+"\\"+delete_image.getFboard_shopping_image_name();
			File f=new File(delfile);
			f.delete();
			int n=fboard_dao.delete_shopping(fboard_num,detail_num);
			if(n>0){
				request.setAttribute("spage", "/board_fboard/fboard_delete_success.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
			}else{
				request.setAttribute("spage", "/board_fboard/fboard_delete_fail.jsp");
				request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
			}
		}
	}
}
