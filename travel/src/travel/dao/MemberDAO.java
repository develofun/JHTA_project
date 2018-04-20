package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


import dbcp.bean.DbcpBean;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import travel.dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();
	
	public static MemberDAO getInstance(){
		return instance;
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql=null;
	
	public int insert(MemberDTO mem){	
		//회원번호 생성 - 오늘날짜 구하기
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String today = format.format(new Date()); //20170113이 출력됨(오늘 년월일)
		String customer_num=null;

		//오늘가입한 회원번호중 가장 큰값 구하기 // 있으면 20170113xxxx중 가장 큰값 없으면 문자0 출력
		sql="SELECT NVL(MAX(CUSTOMER_NUM),0) MAXNUM FROM TB_MEMBER WHERE CUSTOMER_NUM LIKE '%'||?||'%'";		
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,today);
			rs=pstmt.executeQuery();
			// 최대값호출 & +1 & String로 다시 형변환
			rs.next();
			Long long_maxnum_cusmun=Long.parseLong(rs.getString(1))+1;			
			customer_num=String.valueOf(long_maxnum_cusmun); 
			String sql1="INSERT INTO TB_MEMBER VALUES(TB_MEMBER_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,'agent',SYSDATE)";
			pstmt=con.prepareStatement(sql1);
			if(rs.getString(1).equals("0")){
				pstmt.setString(1,today+"0000");
			}else{
				pstmt.setString(1,customer_num);
			}
			pstmt.setString(2,mem.getLogin_id());
			pstmt.setString(3,mem.getMember_password());
			pstmt.setString(4,mem.getMember_nickname());
			pstmt.setString(5,mem.getMember_name());
			pstmt.setString(6,mem.getMember_birthday());
			pstmt.setInt(7,mem.getMember_phone());
			pstmt.setString(8,mem.getMember_email());
			int n=pstmt.executeUpdate();
			return n;		
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con); 
		}
	}
	public HashMap<String, String> login(HashMap<String, String> map){
		String login_id=map.get("login_id");
		String member_password=map.get("member_password");
		sql="SELECT * FROM TB_MEMBER WHERE LOGIN_ID=? AND MEMBER_PASSWORD=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,login_id);
			pstmt.setString(2,member_password);
			rs=pstmt.executeQuery();
			if(rs.next()){//조회되면 리턴 1
				// 세션에 담을 닉네임, 회원번호 가져오기
				String member_nickname=rs.getString("member_nickname");
				String customer_num=rs.getString("customer_num");
				String member_power=rs.getString("member_power");
				
				HashMap<String,String> map1=new HashMap<>();
				map1.put("member_nickname",member_nickname);
				map1.put("member_power",member_power);
				map1.put("customer_num",customer_num);
				
				/* 정상출력
				String customer_num1=map1.get("customer_num");
				String member_nickname1=map1.get("member_nickname");
				String member_power1=map1.get("member_power");
				System.out.println("DAO 맵에 담긴값:" + customer_num1);
				System.out.println("DAO 맵에 담긴 값:" + member_nickname1);
				System.out.println("DAO 맵에 담긴 값:" + member_power1);
				*/
				return map1;
			}else{
				return null; 
			}
		}catch(SQLException se){//오류발생시 리턴 -1
			System.out.println(se.getMessage());
			return null; 
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	public String find_id(HashMap<String, String> map){
		sql="SELECT LOGIN_ID FROM TB_MEMBER WHERE MEMBER_NAME=? AND MEMBER_EMAIL=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, map.get("user_name"));
			pstmt.setString(2, map.get("user_email"));
			rs=pstmt.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
			return null;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null; 
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	public String find_password(HashMap<String, String> map){
		sql="SELECT MEMBER_PASSWORD FROM TB_MEMBER WHERE LOGIN_ID=? AND MEMBER_NAME=? AND MEMBER_EMAIL=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, map.get("user_id"));
			pstmt.setString(2, map.get("user_name"));
			pstmt.setString(3, map.get("user_email"));
			rs=pstmt.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
			return null;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null; 
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	public MemberDTO detail(String customer_num){
		//System.out.println(customer_num);출력됨
		sql="SELECT * FROM TB_MEMBER WHERE CUSTOMER_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, customer_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				int member_num=rs.getInt("member_num");
				String customer_num1=rs.getString("customer_num");
				String login_id=rs.getString("login_id");
				String member_password=rs.getString("member_password");
				String member_nickname=rs.getString("member_nickname");
				String member_name=rs.getString("member_name");
				String member_birthday=rs.getString("member_birthday");
				int member_phone=rs.getInt("member_phone");
				String member_email=rs.getString("member_email");
				String member_power=rs.getString("member_power");
				String member_regdate=rs.getString("member_regdate");
				//System.out.println("DAO 출력:"+member_num+member_power+customer_num1+member_regdate);
				MemberDTO dto=new MemberDTO(member_num, customer_num1, login_id, member_password, member_nickname, member_name, member_birthday, member_phone, member_email, member_power, member_regdate);
				return dto;
			}	
			return null;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;	
		}finally {
			DbcpBean.close(rs, pstmt, con);
		}		
	}
	public int update(MemberDTO dto){
		sql="UPDATE TB_MEMBER SET MEMBER_PASSWORD=?, MEMBER_NICKNAME=?, MEMBER_NAME=?, MEMBER_BIRTHDAY=?, MEMBER_PHONE=?, MEMBER_EMAIL=? WHERE CUSTOMER_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getMember_password());
			pstmt.setString(2, dto.getMember_nickname());
			pstmt.setString(3, dto.getMember_name());
			pstmt.setString(4, dto.getMember_birthday());
			pstmt.setInt(5, dto.getMember_phone());
			pstmt.setString(6, dto.getMember_email());
			pstmt.setString(7, dto.getCustomer_num());
			int n=pstmt.executeUpdate();
			if(n>0){
				return 1;
			}else{
				return 0;
			}	
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}	
	}
	
}
