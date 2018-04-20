package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.bean.DbcpBean;
import travel.dto.Notice_CommentsDTO;

public class Notice_CommentsDAO {
	
	public int notice_comments_create(Notice_CommentsDTO dto,int notice_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=DbcpBean.getConn();
			String sql="insert into tb_notice_comments values(notice_comments_seq.nextval,?,?,sysdate,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			pstmt.setString(2, dto.getNotice_comments_content());
			pstmt.setString(3, dto.getNotice_comments_writer());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(null, pstmt, con);
		}
	}
	public ArrayList<Notice_CommentsDTO> notice_comments_read(int notice_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=DbcpBean.getConn();
			String sql="select * from tb_notice_comments "
					+ "where notice_num=? "
					+ "order by notice_comments_num desc";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			rs=pstmt.executeQuery();
			ArrayList<Notice_CommentsDTO> list=new ArrayList<>();
			while(rs.next()){
				Notice_CommentsDTO dto=new Notice_CommentsDTO(
						rs.getInt("notice_comments_num"),
						rs.getInt("notice_num"),
						rs.getString("notice_comments_content"),
						rs.getDate("notice_comments_w_date"),
						rs.getString("notice_comments_writer")
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
	public int notice_comments_delete(int notice_comments_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=DbcpBean.getConn();
			String sql="delete from tb_notice_comments where notice_comments_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, notice_comments_num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(null, pstmt, con);
		}
	}
}
