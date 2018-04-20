package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dbcp.bean.DbcpBean;
import travel.dto.MarketDTO;
import travel.dto.MarketImageDTO;

//수정 기능 추가 필요
public class MarketDAO {
	private static MarketDAO instance=new MarketDAO();
	
	public static MarketDAO getInstance(){
		return instance;
	}
	
	
	String sql=null;
	
	//중고장터 최근 게시물 번호 추출
	private int getMaxNum(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		sql="SELECT NVL(MAX(MARKET_NUM),0) MAXNUM FROM TB_MARKET";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())return rs.getInt(1);
			return 0;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	//중고장터 최근 이미지 게시물 번호 추출
	private int getImageMaxNum(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		sql="SELECT NVL(MAX(MARKET_IMAGE_NUM),0) MAXNUM FROM TB_MARKET_IMAGE";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())return rs.getInt(1);
			return 0;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	public int getCountAll(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		sql="SELECT NVL(COUNT(*),0) CNUM FROM TB_MARKET";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			return rs.getInt("cnum");			
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	public int getCountSearch(String market_search_option,String market_search_text){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		sql="SELECT NVL(COUNT(*),0) CNUM FROM TB_MARKET WHERE "+market_search_option+" LIKE '%"+market_search_text+"%'";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			return rs.getInt("cnum");			
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}	
	//중고장터 게시물 리스트 추출
	public ArrayList<MarketDTO> market_read(int startRow,int endRow){	
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		sql="SELECT * FROM(SELECT ROWNUM RNUM,AA.* "
				+ "FROM(SELECT * FROM TB_MARKET ORDER BY MARKET_NUM DESC) AA) "
				+ "WHERE RNUM>=? AND RNUM<=?";
		ArrayList<MarketDTO> list=new ArrayList<>();
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();			
			while(rs.next()){
				MarketDTO dto=new MarketDTO(
						rs.getInt("market_num"), 
						rs.getString("customer_num"), 
						rs.getString("market_sort"), 
						rs.getString("market_category"), 
						rs.getString("market_title"), 
						rs.getString("market_content"), 
						rs.getInt("market_price"), 
						rs.getString("market_phone"),
						rs.getInt("market_hit"), 
						rs.getString("market_w_date"),
						rs.getString("market_writer")
						);
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	//중고장터 조건부 추출
	
	//중고장터 리스트 검색
	public ArrayList<MarketDTO> market_search(HashMap<String, String> map){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String market_search_option=map.get("market_search_option");
		String market_search_text=map.get("market_search_text");
		String startRow=map.get("startRow");
		String endRow=map.get("endRow");
		
		sql="SELECT * FROM(SELECT ROWNUM RNUM,AA.* "
				+ "FROM(SELECT * FROM TB_MARKET WHERE "+market_search_option+" LIKE '%"+market_search_text+"%' "
						+ "ORDER BY MARKET_NUM DESC) AA) WHERE RNUM>="+startRow+" AND RNUM<="+endRow;
		ArrayList<MarketDTO> list=new ArrayList<>();
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();			
			while(rs.next()){
				MarketDTO dto=new MarketDTO(
						rs.getInt("market_num"), 
						rs.getString("customer_num"), 
						rs.getString("market_sort"), 
						rs.getString("market_category"), 
						rs.getString("market_title"), 
						rs.getString("market_content"), 
						rs.getInt("market_price"), 
						rs.getString("market_phone"),
						rs.getInt("market_hit"), 
						rs.getString("market_w_date"),
						rs.getString("market_writer")
						);
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	//중고장터 텍스트 게시물 등록
	public int market_create_text(MarketDTO dto){
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="INSERT INTO TB_MARKET VALUES(?,?,?,?,?,?,?,?,0,SYSDATE,?)";
		int content_num=getMaxNum()+1;
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, content_num);
			pstmt.setString(2, dto.getCustomer_num());			
			pstmt.setString(3, dto.getMarket_sort());
			pstmt.setString(4, dto.getMarket_category());
			pstmt.setString(5, dto.getMarket_title());
			pstmt.setString(6, dto.getMarket_content());
			pstmt.setInt(7, dto.getMarket_price());
			pstmt.setString(8, dto.getMarket_phone());
			pstmt.setString(9, dto.getMarket_writer());
			int n=pstmt.executeUpdate();
			
			//게시물 텍스트가 정상적으로 등록되었을 경우 게시물 번호 리턴
			//등록 안되었을 경우 0 리턴
			if(n>0){
				return content_num;
			}else{
				return 0;
			}
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}
	}
	
	//중고장터 이미지 게시물 등록
	public int market_create_image(MarketImageDTO dto){
		Connection con=null;
		PreparedStatement pstmt=null;
		sql="INSERT INTO TB_MARKET_IMAGE VALUES(?,?,?,?)";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getImageMaxNum()+1);
			pstmt.setInt(2, getMaxNum());
			pstmt.setString(3, dto.getMarket_image_fileName());
			pstmt.setString(4, dto.getMarket_image_saveFileName());
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}
	}
	
	//중고장터 게시물 상세내용 추출
	public MarketDTO market_detail_text(int market_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt1=null;
		
		try{
			con=DbcpBean.getConn();
			sql="UPDATE TB_MARKET SET MARKET_HIT=MARKET_HIT+1 WHERE MARKET_NUM=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, market_num);
			pstmt.executeUpdate();
			
			String sql1="SELECT * FROM TB_MARKET WHERE MARKET_NUM=?";			
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1, market_num);
			rs=pstmt1.executeQuery();
			rs.next();
			MarketDTO dto=new MarketDTO(
					market_num,
					rs.getString("customer_num"),
					rs.getString("market_sort"),
					rs.getString("market_category"),
					rs.getString("market_title"),
					rs.getString("market_content"),
					rs.getInt("market_price"),
					rs.getString("market_phone"),
					rs.getInt("market_hit"),
					rs.getString("market_w_date"),
					rs.getString("market_writer")
					);
			return dto;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	//중고장터 이미지 게시물 상세 내용 추출
	public MarketImageDTO market_detail_image(int market_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		sql="SELECT * FROM TB_MARKET_IMAGE WHERE MARKET_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, market_num);
			rs=pstmt.executeQuery();
			rs.next();
			MarketImageDTO dto=new MarketImageDTO(
					rs.getInt("market_image_num"),
					market_num,
					rs.getString("market_image_fileName"),
					rs.getString("market_image_saveFileName")
					);
			return dto;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	//중고장터 텍스트 게시물 수정
	public int market_update_text(MarketDTO dto_text){
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="UPDATE TB_MARKET SET MARKET_SORT=?,MARKET_CATEGORY=?,MARKET_TITLE=?,MARKET_CONTENT=?,"
				+ "MARKET_PRICE=?,MARKET_PHONE=? WHERE MARKET_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto_text.getMarket_sort());
			pstmt.setString(2, dto_text.getMarket_category());			
			pstmt.setString(3, dto_text.getMarket_title());
			pstmt.setString(4, dto_text.getMarket_content());
			pstmt.setInt(5, dto_text.getMarket_price());
			pstmt.setString(6, dto_text.getMarket_phone());
			pstmt.setInt(7, dto_text.getMarket_num());
			int n=pstmt.executeUpdate();
			
			//게시물 텍스트가 정상적으로 수정되었을 경우 1 리턴
			//등록 안되었을 경우 0 리턴
			if(n>0){
				return 1;
			}else{
				return 0;
			}
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}
	}
	
	//중고장터 이미지 게시물 수정
	public int market_update_image(MarketImageDTO dto_image){
		Connection con=null;
		PreparedStatement pstmt=null;
		sql="UPDATE TB_MARKET_IMAGE SET MARKET_IMAGE_FILENAME=?,MARKET_IMAGE_SAVEFILENAME=? WHERE MARKET_IMAGE_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto_image.getMarket_image_fileName());
			System.out.println(dto_image.getMarket_image_fileName());
			pstmt.setString(2, dto_image.getMarket_image_saveFileName());
			System.out.println(dto_image.getMarket_image_saveFileName());
			pstmt.setInt(3, dto_image.getMarket_image_num());
			System.out.println(dto_image.getMarket_image_num());
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}
	}
	
	//중고장터 게시물 삭제
	public int market_delete(int market_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="DELETE FROM TB_MARKET WHERE MARKET_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, market_num);
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}
	}
}
