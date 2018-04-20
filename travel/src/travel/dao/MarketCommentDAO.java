package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.bean.DbcpBean;
import travel.dto.MarketCommentDTO;
import travel.dto.MarketDTO;

//���� ��� �߰� �ʿ�
public class MarketCommentDAO {
	private static MarketCommentDAO instance=new MarketCommentDAO();
	
	public static MarketCommentDAO getInstance(){
		return instance;
	}
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql=null;
	
	//�߰����� �ֱ� �Խù� ��ȣ ����
	private int getCommentMaxNum(){
		sql="SELECT NVL(MAX(MARKET_COMMENT_NUM),0) MAXNUM FROM TB_MARKET_COMMENT";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())return rs.getInt("maxnum");
			return 0;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	
	//�߰����� ��� ����Ʈ ����
	public ArrayList<MarketCommentDTO> market_comment_read(int market_num){
		sql="SELECT * FROM TB_MARKET_COMMENT WHERE MARKET_NUM=? ORDER BY MARKET_COMMENT_NUM DESC";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, market_num);
			rs=pstmt.executeQuery();
			ArrayList<MarketCommentDTO> list=new ArrayList<>();
			while(rs.next()){
				MarketCommentDTO dto=new MarketCommentDTO(
						rs.getInt("market_comment_num"), 
						rs.getInt("market_num"), 
						rs.getString("market_comment_writer"),
						rs.getString("market_comment_content"), 
						rs.getString("market_comment_w_date")
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
	
	//�߰����� ��� ����
	public int market_comment_create(MarketCommentDTO dto){
		PreparedStatement pstmt1=null;
		sql="INSERT INTO TB_MARKET_COMMENT VALUES(?,?,?,?,SYSDATE)";
		try{
			con=DbcpBean.getConn();
			pstmt1=con.prepareStatement(sql);
			pstmt1.setInt(1, getCommentMaxNum()+1);
			pstmt1.setInt(2, dto.getMarket_num());
			pstmt1.setString(3, dto.getMarket_comment_writer());
			pstmt1.setString(4, dto.getMarket_comment_content());
			return pstmt1.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt1, con);
		}
	}
	
	//�߰����� ��� ����
	public int market_delete(int market_comment_num){
		sql="DELETE FROM TB_MARKET_COMMENT WHERE MARKET_COMMENT_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, market_comment_num);
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}
	}
}
