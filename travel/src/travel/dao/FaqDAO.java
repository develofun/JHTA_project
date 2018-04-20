package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dbcp.bean.DbcpBean;
import travel.dto.FaqDTO;
import travel.dto.MarketDTO;

public class FaqDAO {
	private static FaqDAO instance = new FaqDAO();

	public static FaqDAO getInstance() {
		return instance;
	}

	
	String sql = null;

	// FAQ 최근 게시물 번호 추출
	private int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql = "SELECT NVL(MAX(faq_NUM),0) MAXNUM FROM TB_FAQ";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
			return 0;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(rs, pstmt, con);
		}
	}

	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql = "SELECT NVL(COUNT(*),0) CNUM FROM TB_FAQ";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("cnum");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	public int getCountSearch(String faq_search_option,String faq_search_text){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		sql="SELECT NVL(COUNT(*),0) CNUM FROM TB_FAQ WHERE "+faq_search_option+" LIKE '%"+faq_search_text+"%'";
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

	// FAQ 게시물 리스트 추출
	public ArrayList<FaqDTO> faq_read(int startRow, int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql = "SELECT * FROM(SELECT ROWNUM RNUM,AA.* " + "FROM(SELECT * FROM TB_FAQ ORDER BY FAQ_NUM DESC) AA) "
				+ "WHERE RNUM>=? AND RNUM<=?";
		ArrayList<FaqDTO> list = new ArrayList<>();
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FaqDTO dto = new FaqDTO(
						rs.getInt("faq_num"),
						rs.getString("faq_category"),
						rs.getString("faq_title"),
						rs.getString("faq_content")
						);
				list.add(dto);
			}
			return list;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			DbcpBean.close(rs, pstmt, con);
		}
	}

	// FAQ 게시물 생성
	public int faq_create(FaqDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		sql = "INSERT INTO TB_FAQ VALUES(?,?,?,?)";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum() + 1);
			pstmt.setString(2, dto.getFaq_category());
			pstmt.setString(3, dto.getFaq_title());
			pstmt.setString(4, dto.getFaq_content());
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt, con);
		}
	}

	// FAQ 값 비교
	public int faq_compare(String input_password, int faq_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql = "SELECT faq_PASSWORD FROM TB_faq WHERE faq_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, faq_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if (input_password.equals(rs.getString("faq_password"))) {
					return 1;
				}
			}
			return 0;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(rs, pstmt, con);
		}
	}

	// FAQ 게시물 상세내용 추출
	public FaqDTO faq_detail(int faq_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql="SELECT * FROM TB_FAQ WHERE FAQ_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, faq_num);
			rs = pstmt.executeQuery();
			rs.next();
			FaqDTO dto = new FaqDTO(
					rs.getInt("faq_num"),
					rs.getString("faq_category"),
					rs.getString("faq_title"),
					rs.getString("faq_content")
					);
			return dto;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	//FAQ 리스트 검색
		public ArrayList<FaqDTO> faq_search(HashMap<String, String> map){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String faq_search_option=map.get("faq_search_option");
			String faq_search_text=map.get("faq_search_text");
			String startRow=map.get("startRow");
			String endRow=map.get("endRow");
			
			sql="SELECT * FROM(SELECT ROWNUM RNUM,AA.* "
					+ "FROM(SELECT * FROM TB_FAQ WHERE "+faq_search_option+" LIKE '%"+faq_search_text+"%' "
							+ "ORDER BY FAQ_NUM DESC) AA) WHERE RNUM>="+startRow+" AND RNUM<="+endRow;
			ArrayList<FaqDTO> list=new ArrayList<>();
			try{
				con=DbcpBean.getConn();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();			
				while(rs.next()){
					FaqDTO dto=new FaqDTO(
							rs.getInt("faq_num"), 
							rs.getString("faq_category"), 
							rs.getString("faq_title"), 
							rs.getString("faq_content")
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

	// FAQ 게시물 수정
	public int faq_update(HashMap<String, String> map) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE TB_FAQ SET FAQ_CATEGORY=?,FAQ_TITLE=?,FAQ_CONTENT=? WHERE FAQ_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, map.get("faq_category"));
			pstmt.setString(2, map.get("faq_title"));
			pstmt.setString(3, map.get("faq_content"));
			pstmt.setString(4, map.get("faq_num"));
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt, con);
		}
	}
	
	// FAQ 게시물 삭제
	public int faq_delete(int faq_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM TB_faq WHERE faq_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, faq_num);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt, con);
		}
	}
}
