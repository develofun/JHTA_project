package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dbcp.bean.DbcpBean;
import travel.dto.EventSaleDTO;
import travel.dto.QnaDTO;

public class QnaDAO {
	private static QnaDAO instance = new QnaDAO();

	public static QnaDAO getInstance() {
		return instance;
	}

	
	String sql = null;

	// Q&A 최근 게시물 번호 추출
	private int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql = "SELECT NVL(MAX(QNA_NUM),0) MAXNUM FROM TB_QNA";
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
		sql = "SELECT NVL(COUNT(*),0) CNUM FROM TB_QNA";
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

	// Q&A 게시물 리스트 추출
	public ArrayList<QnaDTO> qna_read(int startRow, int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql = "SELECT * FROM(SELECT ROWNUM RNUM,AA.* " + "FROM(SELECT * FROM TB_QNA ORDER BY QNA_NUM DESC) AA) "
				+ "WHERE RNUM>=? AND RNUM<=?";
		ArrayList<QnaDTO> list = new ArrayList<>();
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaDTO dto = new QnaDTO(rs.getInt("qna_num"), rs.getString("customer_num"), rs.getString("qna_state"),
						rs.getString("qna_title"), rs.getString("qna_writer"), rs.getString("qna_content"),
						rs.getString("qna_reply"), rs.getInt("qna_hit"), rs.getString("qna_password"),
						rs.getString("qna_w_date"));
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

	// Q&A 게시물 생성
	public int qna_create(QnaDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		sql = "INSERT INTO TB_QNA VALUES(?,?,?,?,?,?,' ',0,?,SYSDATE)";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum() + 1);
			pstmt.setString(2, dto.getCustomer_num());
			pstmt.setString(3, "확인 중");
			pstmt.setString(4, dto.getQna_title());
			pstmt.setString(5, dto.getQna_writer());
			pstmt.setString(6, dto.getQna_content());
			pstmt.setString(7, dto.getQna_password());
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt, con);
		}
	}

	// Q&A 값 비교
	public int qna_compare(String input_password, int qna_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql = "SELECT QNA_PASSWORD FROM TB_QNA WHERE QNA_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if (input_password.equals(rs.getString("qna_password"))) {
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

	// Q&A 게시물 상세내용 추출
	public QnaDTO qna_detail(int qna_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql="SELECT * FROM TB_QNA WHERE QNA_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			rs = pstmt.executeQuery();
			rs.next();
			QnaDTO dto = new QnaDTO(
					rs.getInt("qna_num"),
					rs.getString("customer_num"),
					rs.getString("qna_state"),
					rs.getString("qna_title"),
					rs.getString("qna_writer"),
					rs.getString("qna_content"),
					rs.getString("qna_reply"),
					rs.getInt("qna_hit"),
					rs.getString("qna_password"),
					rs.getString("qna_w_date")
					);
			return dto;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			DbcpBean.close(rs, pstmt, con);
		}
	}

	// Q&A 게시물 수정
	public int qna_update(HashMap<String, String> map) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE TB_QNA SET QNA_TITLE=?,QNA_CONTENT=? WHERE QNA_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, map.get("qna_title"));
			pstmt.setString(2, map.get("qna_content"));
			pstmt.setString(3, map.get("qna_num"));
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt, con);
		}
	}
	
	// Q&A 게시물 삭제
	public int qna_delete(int qna_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM TB_QNA WHERE QNA_NUM=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(pstmt, con);
		}
	}
}
