package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.bean.DbcpBean;
import travel.dto.KboardDTO;

public class KboardDAO {
	// 전체 글의 갯수 구하기
	public int getCount(String kboard_area, String kboard_city,
			String kboard_category) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String where = "1=1";
		if(kboard_area != null && !kboard_area.equals("")) {
			where += " AND kboard_area='"+kboard_area+"'";
		}
		if(kboard_city != null && !kboard_city.equals("")) {
			where += " AND kboard_city='"+kboard_city+"'";
		}
		if(kboard_category != null && !kboard_category.equals("")) {
			where += " AND kboard_category='"+kboard_category+"'";
		}
		try {
			con = DbcpBean.getConn();
			String sql = "select NVL(count(kboard_num),0) countnum from tb_kboard where "+where;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int cnum = rs.getInt("countnum");
			return cnum;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(rs, pstmt, con);
		}
	}

	public ArrayList<KboardDTO> kboard_read(int startRow, int endRow, String kboard_area, String kboard_city,
			String kboard_category) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String where = "1=1";
		if(kboard_area != null && !kboard_area.equals("")) {
			where += " AND kboard_area='"+kboard_area+"'";
		}
		if(kboard_city != null && !kboard_city.equals("") ) {
			where += " AND kboard_city='"+kboard_city+"'";
		}
		if(kboard_category != null && !kboard_category.equals("")) {
			where += " AND kboard_category='"+kboard_category+"'";
		}
		
		String sql = "SELECT * FROM(SELECT ROWNUM RNUM,AA.* " + "FROM"
				+ " (SELECT * FROM TB_KBOARD WHERE "
				+ where
				+ " ORDER BY KBOARD_NUM DESC) AA)"
				+ " WHERE RNUM>=? AND RNUM<=?";
		try {
			con = DbcpBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			ArrayList<KboardDTO> list = new ArrayList<>();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				KboardDTO dto = new KboardDTO(rs.getInt("kboard_num"), rs.getString("kboard_area"),
						rs.getString("kboard_city"), rs.getString("kboard_category"), rs.getString("kboard_title"),
						rs.getString("kboard_imgname"), rs.getString("kboard_save_imgname"), rs.getString("kboard_content"),
						rs.getString("kboard_plus_content"), rs.getString("kboard_addr"), rs.getString("kboard_x"),
						rs.getString("kboard_y"));
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

	public int Kboard_create(KboardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbcpBean.getConn();
			con.setAutoCommit(false);
			String sql = "insert into tb_kboard values(kboard_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getKboard_area());
			pstmt.setString(2, dto.getKboard_city());
			pstmt.setString(3, dto.getKboard_category());
			pstmt.setString(4, dto.getKboard_title());
			pstmt.setString(5, dto.getKboard_imgname());
			pstmt.setString(6, dto.getKboard_save_imgname());
			pstmt.setString(7, dto.getKboard_content());
			pstmt.setString(8, dto.getKboard_plus_content());
			pstmt.setString(9, dto.getKboard_addr());
			pstmt.setString(10, dto.getKboard_x());
			pstmt.setString(11, dto.getKboard_y());
			int n = pstmt.executeUpdate();
			con.commit();
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			try {
				con.rollback();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return -1;
		} finally {
			DbcpBean.close(null, pstmt, con);
		}
	}

	public KboardDTO detail(int kboard_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbcpBean.getConn();
			String sql = "select * from tb_kboard where kboard_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kboard_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String kboard_area = rs.getString("kboard_area");
				String kboard_city = rs.getString("kboard_city");
				String kboard_category = rs.getString("kboard_category");
				String kboard_title = rs.getString("kboard_title");
				String kboard_imgname = rs.getString("kboard_imgname");
				String kboard_save_imgname = rs.getString("kboard_save_imgname");
				String kboard_content = rs.getString("kboard_content");
				String kboard_plus_content = rs.getString("kboard_plus_content");
				String kboard_addr = rs.getString("kboard_addr");
				String kboard_x = rs.getString("kboard_x");
				String kboard_y = rs.getString("kboard_y");
				KboardDTO dto = new KboardDTO(kboard_num, kboard_area, kboard_city, kboard_category, kboard_title,
						kboard_imgname, kboard_save_imgname, kboard_content, kboard_plus_content, kboard_addr, kboard_x, kboard_y);
				return dto;
			}
			return null;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			DbcpBean.close(rs, pstmt, con);
		}
	}

	public int delete(int kboard_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbcpBean.getConn();
			String sql = "delete from tb_kboard where kboard_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kboard_num);
			int n = pstmt.executeUpdate();
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(null, pstmt, con);
		}
	}

	public int update(KboardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbcpBean.getConn();
			String sql = "update tb_kboard set kboard_title=?,"
					+ " kboard_imgname=?, kboard_save_imgname=?, kboard_content=?, kboard_plus_content=?,"
					+ " kboard_addr=?, kboard_x=?, kboard_y=?" + " where kboard_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getKboard_title());
			pstmt.setString(2, dto.getKboard_imgname());
			pstmt.setString(3, dto.getKboard_save_imgname());
			pstmt.setString(4, dto.getKboard_content());
			pstmt.setString(5, dto.getKboard_plus_content());
			pstmt.setString(6, dto.getKboard_addr());
			pstmt.setString(7, dto.getKboard_x());
			pstmt.setString(8, dto.getKboard_y());
			pstmt.setInt(9, dto.getKboard_num());
			int n = pstmt.executeUpdate();
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			DbcpBean.close(null, pstmt, con);
		}
	}
}
