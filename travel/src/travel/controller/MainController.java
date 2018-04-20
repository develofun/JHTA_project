package travel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import travel.dao.EventSaleDAO;
import travel.dao.FboardDAO;
import travel.dao.FreeDAO;
import travel.dao.MainDAO;
import travel.dao.MarketDAO;
import travel.dao.ReviewDAO;
import travel.dto.EventSaleDTO;
import travel.dto.FboardReadAllDTO;
import travel.dto.FreeDTO;
import travel.dto.KboardDTO;
import travel.dto.MarketDTO;
import travel.dto.NoticeDTO;
import travel.dto.ReviewDTO;
@WebServlet("/main.do")
public class MainController extends HttpServlet{
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String cmd=request.getParameter("cmd");
      System.out.println(cmd);
      if(cmd.equals("main_page")){
         main_page(request,response);
      }else if(cmd.equals("fboard_move")){
         fboard_move(request,response);
      }else if(cmd.equals("kboard_move")){
         kboard_move(request, response);
      }else if(cmd.equals("free_move")){
         free_move(request, response);
      }else if(cmd.equals("top10_move")){
    	  top10_move(request, response);
      }else if(cmd.equals("eventSale_move")){
         eventSale_move(request, response);
      }else if(cmd.equals("review_move")){
         review_move(request,response);
      }else if(cmd.equals("market_move")){
    	  market_move(request,response);
      }
   }
   private void main_page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      MainDAO main_dao=new MainDAO();
      String sfboard_cnt=request.getParameter("fboard_cnt");
      String skboard_cnt=request.getParameter("kboard_cnt");
      String sfree_cnt=request.getParameter("free_cnt");
      String stop10_cnt=request.getParameter("top10_cnt");
      String sreview_cnt=request.getParameter("review_cnt");
      String seventSale_cnt=request.getParameter("eventSale_cnt");
      String smarket_cnt=request.getParameter("market_cnt");
      String sqna_cnt=request.getParameter("qna_cnt");
      boolean free_empty=false;
      boolean notice_empty=false;
      boolean review_empty=false;
      boolean eventSale_empty=false;
      boolean market_empty=false;
      boolean qna_empty=false;
      //해외여행 최신순
      FboardDAO fboard_dao=new FboardDAO();
      ArrayList<FboardReadAllDTO> main_fboard_all=fboard_dao.fboard_read_all(1, 5);
      int fboard_num=0;
      String fboard_area="";
      String fboard_city="";
      String fboard_category="";
      int fboard_size=0;
      if(sfboard_cnt==null){
         sfboard_cnt="1";
      }
      
      int fboard_cnt=Integer.parseInt(sfboard_cnt);
      String fboard_title="";
      String fboard_image="";
      if(main_fboard_all.isEmpty()){
         fboard_cnt=0;
      }else{
         fboard_title=main_fboard_all.get(fboard_cnt-1).getFboard_title();
         String fboard_imageName=main_fboard_all.get(fboard_cnt-1).getFboard_image();
         fboard_num=main_fboard_all.get(fboard_cnt-1).getFboard_num();
         fboard_area=main_fboard_all.get(fboard_cnt-1).getFboard_area();
         fboard_city=main_fboard_all.get(fboard_cnt-1).getFboard_city();
         fboard_category=main_fboard_all.get(fboard_cnt-1).getFboard_category();
         fboard_image=request.getContextPath()+"/fimages/"+fboard_imageName;
         fboard_size=main_fboard_all.size();
      }
      //국내여행
      ArrayList<KboardDTO> main_kboard=main_dao.main_kboard();
      int kboard_size=0;
      if(skboard_cnt==null){
         skboard_cnt="1";
      }
      int kboard_cnt=Integer.parseInt(skboard_cnt);
      int kboard_num=0;
      String kboard_title="";
      String kboard_image="";
      if(main_kboard.isEmpty()){
         kboard_cnt=0;
         
      }else{
         kboard_title=main_kboard.get(kboard_cnt-1).getKboard_title();
         String kboard_imageName=main_kboard.get(kboard_cnt-1).getKboard_save_imgname();
         kboard_image=request.getContextPath()+"/kimages/"+kboard_imageName;
         kboard_num=main_kboard.get(kboard_cnt-1).getKboard_num();
         kboard_size=main_kboard.size();
      }
      //자유게시판
      //최신
      ArrayList<FreeDTO>main_free_all=main_dao.main_free_new();
      ArrayList<FreeDTO>main_free=new ArrayList<>();
      int free_size=0;
      if(sfree_cnt==null){
         sfree_cnt="1";
      }
      int free_cnt=Integer.parseInt(sfree_cnt);
      int free_length=0;
      if(main_free_all.isEmpty()){
         free_empty=true;
         free_cnt=0;
      }else{
         if(main_free_all.size()>5){
        	 free_size=2;
        	 free_length=5;
         }else{
        	 free_size=1;
        	 free_length=main_free_all.size();
         }
         for(int i=0;i<free_length;i++){
            main_free.add(main_free_all.get(i));
         }
      }
      //베스트(조회수)free_dao.comment_top10
      FreeDAO free_dao=new FreeDAO();
      ArrayList<FreeDTO>main_top10_all=free_dao.hit_top10();
      ArrayList<FreeDTO>main_top10=new ArrayList<>();
      int top10_size=0;
      int top10_length=main_top10_all.size()/2;
      if(stop10_cnt==null){
         stop10_cnt="1";
      }
      int top10_cnt=Integer.parseInt(stop10_cnt);
      if(main_top10_all.isEmpty()){
         free_empty=true;
         top10_cnt=0;
      }else{
         if(main_top10_all.size()>5){
        	 top10_size=2;
        	 top10_length=5;
         }else{
        	top10_size=1;
        	top10_length=main_top10_all.size();
         }
         for(int i=0;i<top10_length;i++){
            main_top10.add(main_top10_all.get(i));
         }
      }
      //이벤트 배너&이벤트/할인
      EventSaleDAO eventSale_dao=EventSaleDAO.getInstance();
      ArrayList<EventSaleDTO>main_eventSale_all=eventSale_dao.eventSale_read(1, 10);
      ArrayList<EventSaleDTO>main_eventSale=new ArrayList<>();
      int eventSale_size=0;
      if(seventSale_cnt==null){
         seventSale_cnt="1";
      }
      int eventSale_cnt=Integer.parseInt(seventSale_cnt);
      if(main_eventSale_all.isEmpty()){
         eventSale_empty=true;
         eventSale_cnt=0;
      }else{
         if(main_eventSale_all.size()>5){eventSale_size=2;}else{eventSale_size=1;}
         int eventSale_length=main_eventSale_all.size();
         for(int i=0;i<eventSale_length;i++){
            main_eventSale.add(main_eventSale_all.get(i));
         }
      }
      
      //리뷰/후기
      ReviewDAO review_dao=new ReviewDAO();
      ArrayList<ReviewDTO>main_review_all=review_dao.review_read(1, 10);
      ArrayList<ReviewDTO>main_review=new ArrayList<>();
      int review_size=0;
      int review_length=0;
      if(sreview_cnt==null){
         sreview_cnt="1";
      }
      int review_cnt=Integer.parseInt(sreview_cnt);
      if(main_review_all.isEmpty()){
         review_empty=true;
         review_cnt=0;
      }else{
         if(main_review_all.size()>5){
        	 review_size=2;
        	 review_length=5;
         }else{
        	 review_size=1;
        	 review_length=main_review_all.size();
        }
         
         for(int i=0;i<review_length;i++){
            main_review.add(main_review_all.get(i));
         }
      }
      //중고장터market_read
      MarketDAO market_dao=MarketDAO.getInstance();
      ArrayList<MarketDTO>main_market_all=market_dao.market_read(1, 10);
      ArrayList<MarketDTO>main_market=new ArrayList<>();
      int market_size=0;
      int market_length=0;
      if(smarket_cnt==null){
         smarket_cnt="1";
      }
      int market_cnt=Integer.parseInt(smarket_cnt);
      if(main_market_all.isEmpty()){
         market_empty=true;
         market_cnt=0;
      }else{
         if(main_market_all.size()>5){
        	 market_size=2;
        	 market_length=5;
         }else{
        	 market_size=1;
        	 market_length=main_market_all.size();
         }
         for(int i=0;i<market_length;i++){
            main_market.add(main_market_all.get(i));
         }
      }
      //공지사항(DAO필요)
      ArrayList<NoticeDTO> main_notice=main_dao.main_notice();
      if(main_notice.isEmpty()){
         notice_empty=true;
      }
      request.setAttribute("fboard_size", fboard_size);
      request.setAttribute("kboard_size", kboard_size);
      request.setAttribute("free_size", free_size);
      request.setAttribute("top10_size", top10_size);
      request.setAttribute("review_size", review_size);
      request.setAttribute("market_size", market_size);
      request.setAttribute("fboard_cnt", fboard_cnt);
      request.setAttribute("kboard_cnt", kboard_cnt);
      request.setAttribute("free_cnt", free_cnt);
      request.setAttribute("top10_cnt", top10_cnt);
      request.setAttribute("eventSale_cnt", eventSale_cnt);
      request.setAttribute("review_cnt", review_cnt);
      request.setAttribute("market_cnt", market_cnt);
      request.setAttribute("fboard_image", fboard_image);
      request.setAttribute("fboard_title", fboard_title);
      request.setAttribute("fboard_num", fboard_num);
      request.setAttribute("fboard_area", fboard_area);
      request.setAttribute("fboard_city", fboard_city);
      request.setAttribute("fboard_category", fboard_category);
      request.setAttribute("kboard_image", kboard_image);
      request.setAttribute("kboard_title", kboard_title);
      request.setAttribute("kboard_num", kboard_num);
      request.setAttribute("free_empty", free_empty);
      request.setAttribute("eventSale_empty", eventSale_empty);
      request.setAttribute("review_empty", review_empty);
      request.setAttribute("market_empty", market_empty);
      request.setAttribute("notice_empty", notice_empty);
      request.setAttribute("main_free",main_free);
      request.setAttribute("main_top10",main_top10);
      request.setAttribute("main_eventSale",main_eventSale);
      request.setAttribute("main_review",main_review);
      request.setAttribute("main_market",main_market);
      request.setAttribute("main_notice", main_notice);
      request.setAttribute("spage", "/layout/mainpage.jsp");
      request.getRequestDispatcher("/layout/layout.jsp").forward(request, response);
   }
   
   private void fboard_move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      FboardDAO fboard_dao=new FboardDAO();
      ArrayList<FboardReadAllDTO> main_fboard_all=fboard_dao.fboard_read_all(1, 5);
      String sfboard_cnt=request.getParameter("fboard_cnt");
      int fboard_num=0;
      String fboard_area="";
      String fboard_city="";
      String fboard_category="";
      String fboard_title="";
      String fboard_image="";
      int fboard_cnt=Integer.parseInt(sfboard_cnt);
      if(main_fboard_all.isEmpty()){
         fboard_cnt=0;
      }else{
         fboard_title=main_fboard_all.get(fboard_cnt-1).getFboard_title();
         fboard_num=main_fboard_all.get(fboard_cnt-1).getFboard_num();
         String fboard_imageName=main_fboard_all.get(fboard_cnt-1).getFboard_image();
         fboard_area=main_fboard_all.get(fboard_cnt-1).getFboard_area();
         fboard_city=main_fboard_all.get(fboard_cnt-1).getFboard_city();
         fboard_category=main_fboard_all.get(fboard_cnt-1).getFboard_category();
         fboard_image=request.getContextPath()+"/fimages/"+fboard_imageName;
         System.out.println(fboard_category);
      }
      response.setContentType("text/xml;charset=utf-8");
      PrintWriter pw=response.getWriter();
      pw.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
      pw.println("<result>");
      pw.println("<result>");
      pw.println("<fboard_cnt>"+fboard_cnt+"</fboard_cnt>");
      pw.println("<fboard_num>"+fboard_num+"</fboard_num>");
      pw.println("<fboard_area>"+fboard_area+"</fboard_area>");
      pw.println("<fboard_city>"+fboard_city+"</fboard_city>");
      pw.println("<fboard_category>"+fboard_category+"</fboard_category>");
      pw.println("<fboard_title>"+fboard_title+"</fboard_title>");
      pw.println("<fboard_image>"+fboard_image+"</fboard_image>");
      pw.println("</result>");
      pw.println("</result>");
   }
   private void kboard_move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      MainDAO main_dao=new MainDAO();
      String skboard_cnt=request.getParameter("kboard_cnt");
      ArrayList<KboardDTO> main_kboard=main_dao.main_kboard();
      int kboard_cnt=Integer.parseInt(skboard_cnt);
      int kboard_num=0;
      String kboard_title="";
      String kboard_image="";
      if(main_kboard.isEmpty()){
         kboard_cnt=0;
         
      }else{
         kboard_title=main_kboard.get(kboard_cnt-1).getKboard_title();
         String kboard_imageName=main_kboard.get(kboard_cnt-1).getKboard_save_imgname();
         kboard_num=main_kboard.get(kboard_cnt-1).getKboard_num();
         kboard_image=request.getContextPath()+"/kimages/"+kboard_imageName;
      }
      response.setContentType("text/xml;charset=utf-8");
      PrintWriter pw=response.getWriter();
      pw.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
      pw.println("<result>");
      pw.println("<result>");
      pw.println("<kboard_cnt>"+kboard_cnt+"</kboard_cnt>");
      pw.println("<kboard_num>"+kboard_num+"</kboard_num>");
      pw.println("<kboard_title>"+kboard_title+"</kboard_title>");
      pw.println("<kboard_image>"+kboard_image+"</kboard_image>");
      pw.println("</result>");
      pw.println("</result>");
   }
   private void free_move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  MainDAO main_dao=new MainDAO();
	  ArrayList<FreeDTO>main_free_all=main_dao.main_free_new();
	  JSONArray main_free=new JSONArray();
	  JSONArray main_free_num=new JSONArray();
	  String sfree_cnt=request.getParameter("free_cnt");
	  int free_cnt=Integer.parseInt(sfree_cnt);
	  int free_length=0;
	  System.out.println(free_cnt);
	  if(free_cnt==1){
		  if(main_free_all.size()<5){
			  free_length=main_free_all.size();
		  }else{
			  free_length=5;
		  }
		  for(int i=0;i<free_length;i++){
	            main_free.add(main_free_all.get(i).getFree_title());
	            main_free_num.add(main_free_all.get(i).getFree_num());
		  }
	  }else{
		  free_length=main_free_all.size();
		  for(int i=5;i<free_length;i++){
			  main_free.add(main_free_all.get(i).getFree_title());
	          main_free_num.add(main_free_all.get(i).getFree_num());
		  }
	  }
	  JSONObject result=new JSONObject();
		result.put("free_cnt", free_cnt);
		result.put("main_free",main_free);
		result.put("main_free_num",main_free_num);
		response.setContentType("text/json;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println(result.toString());
		pw.close();
	  
   }
   
   private void top10_move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  FreeDAO free_dao=new FreeDAO();
		  ArrayList<FreeDTO>main_top10_all=free_dao.hit_top10();
		  JSONArray main_top10=new JSONArray();
		  JSONArray main_top10_num=new JSONArray();
		  String stop10_cnt=request.getParameter("top10_cnt");
		  int top10_cnt=Integer.parseInt(stop10_cnt);
		  int top10_length=0;
		  if(top10_cnt==1){
			  if(main_top10_all.size()<5){
				  top10_length=main_top10_all.size();
			  }else{
				  top10_length=5;
			  }
			  for(int i=0;i<top10_length;i++){
		            main_top10.add(main_top10_all.get(i).getFree_title());
		            main_top10_num.add(main_top10_all.get(i).getFree_num());
			  }
		  }else{
			  top10_length=main_top10_all.size();
			  for(int i=5;i<top10_length;i++){
				  main_top10.add(main_top10_all.get(i).getFree_title());
		          main_top10_num.add(main_top10_all.get(i).getFree_num());
			  }
		  }
		  JSONObject result=new JSONObject();
			result.put("top10_cnt", top10_cnt);
			result.put("main_top10",main_top10);
			result.put("main_top10_num",main_top10_num);
			response.setContentType("text/json;charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.println(result.toString());
			pw.close();
   }
   
  
   
   private void review_move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  ReviewDAO review_dao=new ReviewDAO();
		  ArrayList<ReviewDTO>main_review_all=review_dao.review_read(1, 10);
		  JSONArray main_review=new JSONArray();
		  JSONArray main_review_num=new JSONArray();
		  String sreview_cnt=request.getParameter("review_cnt");
		  int review_cnt=Integer.parseInt(sreview_cnt);
		  int review_length=0;
		  if(review_cnt==1){
			  if(main_review_all.size()<5){
				  review_length=main_review_all.size();
			  }else{
				  review_length=5;
			  }
			  for(int i=0;i<review_length;i++){
		            main_review.add(main_review_all.get(i).getReview_title());
		            main_review_num.add(main_review_all.get(i).getReview_num());
			  }
		  }else{
			  review_length=main_review_all.size();
			  for(int i=5;i<review_length;i++){
				  main_review.add(main_review_all.get(i).getReview_title());
		          main_review_num.add(main_review_all.get(i).getReview_num());
			  }
		  }
		  JSONObject result=new JSONObject();
			result.put("review_cnt", review_cnt);
			result.put("main_review",main_review);
			result.put("main_review_num",main_review_num);
			response.setContentType("text/json;charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.println(result.toString());
			pw.close();
   }
   
   private void market_move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 MarketDAO market_dao=new MarketDAO();
		 ArrayList<MarketDTO>main_market_all=market_dao.market_read(1, 10);
		  JSONArray main_market=new JSONArray();
		  JSONArray main_market_num=new JSONArray();
		  String smarket_cnt=request.getParameter("market_cnt");
		  int market_cnt=Integer.parseInt(smarket_cnt);
		  int market_length=0;
		  if(market_cnt==1){
			  if(main_market_all.size()<5){
				  market_length=main_market_all.size();
			  }else{
				  market_length=5;
			  }
			  for(int i=0;i<market_length;i++){
		            main_market.add(main_market_all.get(i).getMarket_title());
		            main_market_num.add(main_market_all.get(i).getMarket_num());
			  }
		  }else{
			  market_length=main_market_all.size();
			  for(int i=5;i<market_length;i++){
				  main_market.add(main_market_all.get(i).getMarket_title());
		          main_market_num.add(main_market_all.get(i).getMarket_num());
			  }
		  }
		  JSONObject result=new JSONObject();
			result.put("market_cnt", market_cnt);
			result.put("main_market",main_market);
			result.put("main_market_num",main_market_num);
			response.setContentType("text/json;charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.println(result.toString());
			pw.close();
   }
   
   //이벤트
   private void eventSale_move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //이벤트 배너&이벤트/할인
	      EventSaleDAO eventSale_dao=EventSaleDAO.getInstance();
	      ArrayList<EventSaleDTO>main_eventSale_all=eventSale_dao.eventSale_read(1, 10);
	      JSONArray main_eventSale=new JSONArray();
	      JSONArray eventSale_num=new JSONArray();
	      int eventSale_size=0;
	      if(main_eventSale_all.isEmpty()){
	      }else{
	         int eventSale_length=main_eventSale_all.size();
	         for(int i=0;i<eventSale_length;i++){
	            main_eventSale.add(main_eventSale_all.get(i).getEventSale_title());
	            eventSale_num.add(main_eventSale_all.get(i).getEventSale_num());
	         }
	      }
		  JSONObject result=new JSONObject();
		  result.put("main_eventSale", main_eventSale);
		  result.put("eventSale_num", eventSale_num);
		  response.setContentType("text/json;charset=utf-8");
		  PrintWriter pw=response.getWriter();
		  pw.println(result.toString());
		  pw.close();
   }
}