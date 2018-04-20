<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dbcp.bean.DbcpBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String member_email=request.getParameter("member_email");

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	boolean using=false;
	try{
		con=DbcpBean.getConn();
		String sql="select * from tb_member where member_email=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, member_email);
		rs=pstmt.executeQuery();
		if(rs.next()){
			using=true;
		}
	}catch(SQLException se){
		System.out.println(se.getMessage());
	}finally{
		DbcpBean.close(rs, pstmt, con);
	}
	
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print("<result>");
	pw.print("<using>"+using+"</using>");
	pw.print("</result>");
	pw.close();
%>