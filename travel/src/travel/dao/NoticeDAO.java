package travel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.bean.DbcpBean;
import travel.dto.NoticeDTO;


public class NoticeDAO {
	//전체 글의 갯수 구하기
	public int getCount(String notice_search_box, String notice_search){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		if(notice_search_box == null){
			notice_search_box = "";
		}
		
		String where = "1=1";
		if(notice_search_box.equals("제목")){
			where += " and notice_title like '%"+notice_search+"%' ";
		}else if(notice_search_box.equals("내용")){
			where += " and notice_content like '%"+notice_search+"%' ";
		}
		try{
			con=DbcpBean.getConn();
			String sql="select NVL(count(notice_num),0) countnum from tb_notice where "+where;
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int cnum=rs.getInt("countnum");
			return cnum;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	//공지사항 게시물 리스트 추출
	public ArrayList<NoticeDTO> notice_read(int startRow, int endRow, String notice_search_box, String notice_search){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		if(notice_search_box == null){
			notice_search_box = "";
		}
		
		String where = "1=1";
		if(notice_search_box.equals("제목")){
			where += " and notice_title like '%"+notice_search+"%' ";
		}else if(notice_search_box.equals("내용")){
			where += " and notice_content like '%"+notice_search+"%' ";
		}
		
		String sql="SELECT * FROM(SELECT ROWNUM RNUM,AA.* "
				+ "FROM(SELECT * FROM TB_NOTICE where " + where
				+ "ORDER BY NOTICE_NUM DESC) AA) "
				+ "WHERE RNUM>=? AND RNUM<=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			ArrayList<NoticeDTO> list=new ArrayList<>();
			rs=pstmt.executeQuery();
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
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	public int Notice_create(NoticeDTO dto){
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=DbcpBean.getConn();
			String sql="insert into tb_notice values(notice_seq.nextval,?,?,0,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getNotice_title());
			pstmt.setString(2, dto.getNotice_content());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(null, pstmt, con);
		}
	}
	public NoticeDTO detail(int notice_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=DbcpBean.getConn();
			String sql="select * from tb_notice where notice_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String notice_title=rs.getString("notice_title");
				String notice_content=rs.getString("notice_content");
				int notice_hit=rs.getInt("notice_hit");
				Date notice_w_date=rs.getDate("notice_w_date");
				NoticeDTO dto=new NoticeDTO(notice_num, notice_title, notice_content, notice_hit, notice_w_date);
				return dto;
			}
			return null;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	public int delete(int notice_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		try{
			con = DbcpBean.getConn();
			String sql1="delete from tb_notice_comments where notice_num=?";
			String sql="delete from tb_notice where notice_num=?";
			pstmt1=con.prepareStatement(sql1);
			pstmt=con.prepareStatement(sql);
			pstmt1.setInt(1, notice_num);
			pstmt.setInt(1, notice_num);
			int n1=pstmt1.executeUpdate();
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(null, pstmt, con);
		}
	}
	public int notice_hit_update(int notice_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=DbcpBean.getConn();
			String sql="update tb_notice set notice_hit=notice_hit+1 where notice_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(null, pstmt, con);
		}
	}
	public int notice_update(NoticeDTO dto){
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=DbcpBean.getConn();
			String sql="update tb_notice set notice_title=?, notice_content=? where notice_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getNotice_title());
			pstmt.setString(2, dto.getNotice_content());
			pstmt.setInt(3, dto.getNotice_num());
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









