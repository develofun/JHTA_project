package net.stylesolo.www.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;


public class LoginFilter implements Filter{

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
   
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
    //  System.out.println("dddddddd");
      HttpServletRequest hrs=(HttpServletRequest)request;
      HttpSession session=hrs.getSession();
      boolean login=false;
      if(session!=null){
         String id=(String)session.getAttribute("id");
         if(id!=null){
            login=true;
         }
      }
      if(login){ //�α��� �Ǿ��ִ� ����
    	//  System.out.println("333333333333333");
         chain.doFilter(request, response); //����ڰ� ��û�� �������� �̵��ϱ�
      }else{ //�α��� �ȵ� ����
         //�α��� �������� �̵��ϱ�
         HttpServletResponse rsp=(HttpServletResponse)response;
     //    System.out.println("44444444444444444444");
         rsp.sendRedirect("/member/login");
      }
   }

   @Override
   public void destroy() {
   
   }

   
}