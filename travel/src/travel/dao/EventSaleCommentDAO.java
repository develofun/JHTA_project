package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.bean.DbcpBean;
import travel.dto.EventSaleCommentDTO;

public class EventSaleCommentDAO {
	private static EventSaleCommentDAO instance = new EventSaleCommentDAO();

	public static EventSaleCommentDAO getInstance() {
		return instance;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;

	// 이벤트/할인 최근 게시물 번호 추출
	private int getCommentMaxNum() {
		sql = "SELECT NVL(MAX(EVENTSALE_COMMENT_NUM),0) MAXNUM FROM TB_EVENTSALE_COMMENT";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt("maxnum");
			return 0;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(rs, pstmt, con);
		}
	}

	// 이벤트/할인 댓글 리스트 추출
	public ArrayList<EventSaleCommentDTO> eventSale_comment_read(int eventSale_num) {
		sql = "SELECT * FROM TB_EVENTSALE_COMMENT WHERE EVENTSALE_NUM=? ORDER BY EVENTSALE_COMMENT_NUM DESC";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, eventSale_num);
			rs = pstmt.executeQuery();
			ArrayList<EventSaleCommentDTO> list = new ArrayList<>();
			while (rs.next()) {
				EventSaleCommentDTO dto = new EventSaleCommentDTO(
						rs.getInt("eventSale_comment_num"),
						rs.getInt("eventSale_num"),
						rs.getString("customer_num"),
						rs.getString("eventSale_comment_writer"),
						rs.getString("eventSale_comment_content"),
						rs.getString("eventSale_comment_w_date"));
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

	// 이벤트/할인 댓글 생성
	public int eventSale_comment_create(EventSaleCommentDTO dto) {
		PreparedStatement pstmt1 = null;
		sql = "INSERT INTO TB_EVENTSALE_COMMENT VALUES(?,?,?,?,?,SYSDATE)";
		try {
			con = DbcpBean.getConn();
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setInt(1, getCommentMaxNum() + 1);
			pstmt1.setInt(2, dto.getEventSale_num());
			pstmt1.setString(3, dto.getCustomer_num());
			pstmt1.setString(4, dto.getEventSale_comment_writer());
			pstmt1.setString(5, dto.getEventSale_comment_content());
			return pstmt1.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt1, con);
		}
	}

	// 이벤트/할인 댓글 삭제
	public int eventSale_delete(int eventSale_comment_num) {
		sql = "DELETE FROM TB_EVENTSALE_COMMENT WHERE EVENTSALE_COMMENT_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, eventSale_comment_num);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt, con);
		}
	}
}
