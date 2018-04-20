package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import dbcp.bean.DbcpBean;
import travel.dto.EventSaleDTO;
import travel.dto.MarketDTO;
import travel.dto.QnaDTO;

public class EventSaleDAO {
	private static EventSaleDAO instance = new EventSaleDAO();

	public static EventSaleDAO getInstance() {
		return instance;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;

	// 이벤트/할인 최근 게시물 번호 추출
	private int getMaxNum() {
		sql = "SELECT NVL(MAX(EVENTSALE_NUM),0) MAXNUM FROM TB_EVENTSALE";
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
		sql = "SELECT NVL(COUNT(*),0) CNUM FROM TB_EVENTSALE";
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

	public int getCountSearch(String eventSale_search_option,String eventSale_search_text){
		sql="SELECT NVL(COUNT(*),0) CNUM FROM TB_eventSale WHERE "+eventSale_search_option+" LIKE '%"+eventSale_search_text+"%'";
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

	// 이벤트/할인 게시물 리스트 추출
	public ArrayList<EventSaleDTO> eventSale_read(int startRow, int endRow) {
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY / MM / DD");
		sql = "SELECT * FROM(SELECT ROWNUM RNUM,AA.* "
				+ "FROM(SELECT * FROM TB_EVENTSALE ORDER BY EVENTSALE_NUM DESC) AA) " + "WHERE RNUM>=? AND RNUM<=?";
		ArrayList<EventSaleDTO> list = new ArrayList<>();
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EventSaleDTO dto = new EventSaleDTO(
						rs.getInt("eventSale_num"), 
						rs.getString("customer_num"),
						rs.getString("eventSale_sort"), 
						rs.getString("eventSale_category"), 
						rs.getString("eventSale_title"),
						rs.getString("eventSale_writer"),
						rs.getString("eventSale_content"),
						rs.getInt("eventSale_hit"), 
						rs.getString("eventSale_w_date"), 
						sdf.format(rs.getDate("eventSale_startDate")),
						sdf.format(rs.getDate("eventSale_endDate"))
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

	// 이벤트/할인 게시물 생성
	public int eventSale_create(EventSaleDTO dto) {
		PreparedStatement pstmt1 = null;
		sql = "INSERT INTO TB_EVENTSALE VALUES(?,?,?,?,?,?,?,0,SYSDATE,?,?)";
		try {
			con = DbcpBean.getConn();
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setInt(1, getMaxNum() + 1);
			pstmt1.setString(2, dto.getCustomer_num());
			pstmt1.setString(3, dto.getEventSale_sort());
			pstmt1.setString(4, dto.getEventSale_category());
			pstmt1.setString(5, dto.getEventSale_title());
			pstmt1.setString(6, dto.getEventSale_writer());
			pstmt1.setString(7, dto.getEventSale_content());
			pstmt1.setString(8, dto.getEventSale_startDate());
			pstmt1.setString(9, dto.getEventSale_endDate());
			return pstmt1.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt1, con);
		}
	}
	
	// 이벤트/할인 리스트 검색
	public ArrayList<EventSaleDTO> eventSale_search(HashMap<String, String> map) {
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY / MM / DD");
		String eventSale_search_option = map.get("eventSale_search_option");
		String eventSale_search_text = map.get("eventSale_search_text");
		String startRow = map.get("startRow");
		String endRow = map.get("endRow");

		sql = "SELECT * FROM(SELECT ROWNUM RNUM,AA.* " + "FROM(SELECT * FROM TB_EVENTSALE WHERE " + eventSale_search_option
				+ " LIKE '%" + eventSale_search_text + "%' " + "ORDER BY eventSale_NUM DESC) AA) WHERE RNUM>=" + startRow
				+ " AND RNUM<=" + endRow;
		ArrayList<EventSaleDTO> list = new ArrayList<>();
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EventSaleDTO dto = new EventSaleDTO(
						rs.getInt("eventSale_num"), 
						rs.getString("customer_num"),
						rs.getString("eventSale_sort"), 
						rs.getString("eventSale_category"), 
						rs.getString("eventSale_title"),
						rs.getString("eventSale_writer"),
						rs.getString("eventSale_content"),
						rs.getInt("eventSale_hit"), 
						rs.getString("eventSale_w_date"), 
						sdf.format(rs.getDate("eventSale_startDate")),
						sdf.format(rs.getDate("eventSale_endDate"))
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
	
	// 이벤트/할인 게시물 상세내용 추출
	public EventSaleDTO eventSale_detail(int eventSale_num) {
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY / MM / DD");
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;

		try {
			con = DbcpBean.getConn();
			sql = "UPDATE TB_eventSale SET EVENTSALE_HIT=eventSale_HIT+1 WHERE EVENTSALE_NUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, eventSale_num);
			pstmt.executeUpdate();

			String sql1 = "SELECT * FROM TB_EVENTSALE WHERE eventSale_NUM=?";
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1, eventSale_num);
			rs = pstmt1.executeQuery();
			rs.next();
			EventSaleDTO dto = new EventSaleDTO(
					rs.getInt("eventSale_num"), 
					rs.getString("customer_num"),
					rs.getString("eventSale_sort"), 
					rs.getString("eventSale_category"), 
					rs.getString("eventSale_title"),
					rs.getString("eventSale_writer"),
					rs.getString("eventSale_content"),
					rs.getInt("eventSale_hit"), 
					rs.getString("eventSale_w_date"), 
					sdf.format(rs.getDate("eventSale_startDate")),
					sdf.format(rs.getDate("eventSale_endDate"))
					);
			return dto;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	// 이벤트/할인 게시물 수정
	public int eventSale_update(EventSaleDTO dto) {
		String sql = "UPDATE TB_EVENTSALE SET EVENTSALE_SORT=?,EVENTSALE_CATEGORY=?,EVENTSALE_TITLE=?,EVENTSALE_CONTENT=?"
				+ " WHERE eventSale_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEventSale_sort());
			pstmt.setString(2, dto.getEventSale_category());
			pstmt.setString(3, dto.getEventSale_title());
			pstmt.setString(4, dto.getEventSale_content());
			pstmt.setInt(5, dto.getEventSale_num());
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt, con);
		}
	}

	// 이벤트/할인 게시물 삭제
	public int eventSale_delete(int eventSale_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM TB_EVENTSALE WHERE EVENTSALE_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, eventSale_num);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt, con);
		}
	}
}
