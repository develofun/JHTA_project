package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dbcp.bean.DbcpBean;
import travel.dto.FreeDTO;
import travel.dto.KboardDTO;
import travel.dto.NoticeDTO;

public class MainDAO {
	public ArrayList<NoticeDTO> main_notice(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("SELECT * FROM(SELECT ROWNUM RNUM,AA.*"
					+ "FROM(SELECT * FROM TB_NOTICE ORDER BY NOTICE_NUM DESC) AA)"
					+ "WHERE RNUM>=1 AND RNUM<=5");
			rs=pstmt.executeQuery();
			ArrayList<NoticeDTO> list=new ArrayList<>();
			while(rs.next()){
				NoticeDTO dto=new NoticeDTO(
						rs.getInt("notice_num"),
						rs.getString("notice_title"),
						rs.getString("notice_content"),
						rs.getInt("notice_hit"),
						rs.getDate("notice_w_date")
						);
				list.add(dto);
			}
			return list;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	
	public ArrayList<FreeDTO> main_free_new(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("SELECT * FROM(SELECT AA.*,ROWNUM RNUM FROM"
					+ "(SELECT * FROM TB_FREE ORDER BY FREE_w_date DESC)AA)"
					+ "WHERE RNUM<'11'");
			rs=pstmt.executeQuery();
			ArrayList<FreeDTO> list=new ArrayList<>();
			while(rs.next()){
				FreeDTO free_dto=new FreeDTO(
				rs.getInt("free_num"),rs.getString("customer_num"),rs.getString("free_title"),
				rs.getString("free_content"),rs.getInt("free_hit"),rs.getString("free_w_date"),
				rs.getInt("free_password"),rs.getString("free_writer"));
				list.add(free_dto);
			}
			return list;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	
	public ArrayList<KboardDTO> main_kboard(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("SELECT * FROM(SELECT ROWNUM RNUM,AA.* FROM"
					+ "(SELECT * FROM TB_KBOARD ORDER BY KBOARD_NUM DESC) AA)"
					+ "WHERE RNUM>=1 AND RNUM<=5");
			rs=pstmt.executeQuery();
			ArrayList<KboardDTO> list=new ArrayList<>();
			while(rs.next()){
				KboardDTO kbaord_dto=new KboardDTO
				(rs.getInt("kboard_num"),rs.getString("kboard_area"),rs.getString("kboard_city")
				,rs.getString("kboard_category"), rs.getString("kboard_title"), rs.getString("kboard_imgname")
				,rs.getString("kboard_save_imgname"),rs.getString("kboard_content"),rs.getString("kboard_plus_content")
				,rs.getString("kboard_addr"),rs.getString("kboard_x"),rs.getString("kboard_y"));
				list.add(kbaord_dto);
			}
			return list;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
}
