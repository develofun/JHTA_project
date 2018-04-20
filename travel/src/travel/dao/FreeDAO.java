package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dbcp.bean.DbcpBean;
import travel.dto.FreeDTO;
import travel.dto.Free_CommentDTO;
import travel.dto.Free_ImageDTO;

public class FreeDAO {
	private static FreeDAO instance=new FreeDAO();
	
	public static FreeDAO getInstance(){
		return instance;
	}
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql=null;
	
	//가장 큰 글번호 구하기
	public int getMaxNum(){
		sql="SELECT NVL(MAX(FREE_NUM),0) MAXNUM FROM TB_FREE";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())return rs.getInt(1);
			return 0;
		}catch (SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	public int getCountAll() {
		sql ="SELECT NVL(COUNT(*),0) CNUM FROM TB_FREE";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			return rs.getInt("cnum");
		}catch (SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	//게시글 리스트
	public ArrayList<FreeDTO> free_read(int startRow, int endRow){
		sql="SELECT * FROM(SELECT AA.*,ROWNUM RNUM FROM(SELECT * FROM TB_FREE ORDER BY FREE_NUM DESC)AA) WHERE RNUM>=? AND RNUM<=?";
		ArrayList<FreeDTO> list=new ArrayList<>();
		try{		
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);		
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			while(rs.next()){
				int free_num=rs.getInt("free_num");
				String customer_num=rs.getString("customer_num");
				String free_title=rs.getString("free_title");
				String free_content=rs.getString("free_content");
				int free_hit=rs.getInt("free_hit");		
				String free_w_date=rs.getString("free_w_date");
				int free_password=rs.getInt("free_password");
				String free_writer=rs.getString("free_writer");
				FreeDTO dto=new FreeDTO(free_num, customer_num, free_title, free_content, free_hit, free_w_date, free_password, free_writer);
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

	//조회순 높은 게시물 top10
	public ArrayList<FreeDTO> hit_top10(){
		sql="SELECT * FROM(SELECT AA.*,ROWNUM RNUM FROM(SELECT * FROM TB_FREE ORDER BY FREE_HIT DESC)AA) WHERE RNUM<'11'";
		ArrayList<FreeDTO> list1=new ArrayList<>();
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);	
			rs=pstmt.executeQuery();
			while(rs.next()){
				int free_num=rs.getInt("free_num");
				String customer_num=rs.getString("customer_num");
				String free_title=rs.getString("free_title");
				String free_content=rs.getString("free_content");
				int free_hit=rs.getInt("free_hit");		
				String free_w_date=rs.getString("free_w_date");
				int free_password=rs.getInt("free_password");
				String free_writer=rs.getString("free_writer");
				FreeDTO dto1=new FreeDTO(free_num, customer_num, free_title, free_content, free_hit, free_w_date, free_password, free_writer);
				list1.add(dto1);
			}
			return list1;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	// 댓글만은 게시물 top10
	public ArrayList<FreeDTO> comment_top10(){
		PreparedStatement pstmt1=null;
		ResultSet rs1=null;
		// comment table에서 댓글많은 게시글 10개의 글번호를 구함
		sql="SELECT * FROM(SELECT FREE_NUM,COUNT(*) CNT FROM TB_FREE_COMMENT GROUP BY FREE_NUM ORDER BY CNT DESC) WHERE ROWNUM<11";
		ArrayList<FreeDTO> list=new ArrayList<>();
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);	
			rs=pstmt.executeQuery();
			while(rs.next()){//구한 글번호로 자유게시판 에서 select하기
				int free_num=rs.getInt("free_num");
				String sql1="SELECT * FROM TB_FREE WHERE FREE_NUM=?";
				pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1, free_num);
				rs1=pstmt1.executeQuery();
				if(rs1.next()){
					int free_num1=rs1.getInt("free_num");
					String customer_num=rs1.getString("customer_num");
					String free_title=rs1.getString("free_title");
					String free_content=rs1.getString("free_content");
					int free_hit=rs1.getInt("free_hit");		
					String free_w_date=rs1.getString("free_w_date");
					int free_password=rs1.getInt("free_password");
					String free_writer=rs1.getString("free_writer");
					//System.out.println("DAO부분:"+free_num1+free_title);
					FreeDTO dto=new FreeDTO(free_num1, customer_num, free_title, free_content, free_hit, free_w_date, free_password, free_writer);
					list.add(dto);
				}
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, con);
			DbcpBean.close(rs1, pstmt1, con);
		}
	}
	// 게시글 상세보기
	public FreeDTO detail(int free_num){	
		String sql1="UPDATE TB_FREE SET FREE_HIT=FREE_HIT+1 WHERE FREE_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql1);
			pstmt.setInt(1, free_num);
			int n=pstmt.executeUpdate();
			sql="select * from tb_free where free_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String free_title=rs.getString("free_title");
				String customer_num=rs.getString("customer_num");
				String free_content=rs.getString("free_content");
				String free_w_date=rs.getString("free_w_date");
				int free_hit=rs.getInt("free_hit");
				int free_password=rs.getInt("free_password");
				String free_writer=rs.getString("free_writer");
				FreeDTO dto=new FreeDTO(free_num, customer_num, free_title, free_content, free_hit, free_w_date, free_password, free_writer);
				return dto;
			}
			return null;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally {
			DbcpBean.close(rs, pstmt, con);
		}			
	}
	// 글번호에 따른 이미지 정보가져오기
	public Free_ImageDTO image(int free_num){
		sql="SELECT * FROM TB_FREE_IMAGE WHERE FREE_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				int free_image_num=rs.getInt("free_image_num");
				String free_image_original_name=rs.getString("free_image_original_name");
				String free_image_name=rs.getString("free_image_name");
				Free_ImageDTO dto=new Free_ImageDTO(free_image_num, free_num, free_image_original_name, free_image_name);
				return dto;	
			}
			return null;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally {
			DbcpBean.close(rs, pstmt, con);
		}			
	}
	//글저장
	public int create(FreeDTO dto){
		sql="INSERT INTO TB_FREE VALUES(TB_FREE_SEQ.nextval,?,?,?,'0',SYSDATE,'1234',?)";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getCustomer_num());
			pstmt.setString(2, dto.getFree_title());
			pstmt.setString(3, dto.getFree_content());
			pstmt.setString(4, dto.getFree_writer());
			int n=pstmt.executeUpdate();
			String sql1="SELECT NVL(MAX(FREE_NUM),0) MAXNUM FROM TB_FREE WHERE CUSTOMER_NUM=?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, dto.getCustomer_num());
			rs=pstmt.executeQuery();
			rs.next();
			int a=Integer.parseInt(rs.getString(1));
			//System.out.println(a);게시물 최대값 출력됨
			return a;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con); 
		}
	}
	//글번호에 따라 이미지 등록
	public int freeimageinsert(Free_ImageDTO dto){
		/* 
		System.out.println(dto.getFree_num());
		System.out.println(dto.getFree_image_original_name());
		System.out.println(dto.getFree_image_name());
		System.out.println(dto.getFree_image_size());
		*/
		sql="INSERT INTO TB_FREE_IMAGE VALUES(TB_FREE_IMAGE_SEQ.NEXTVAL,?,?,?)";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);			
			pstmt.setString(1, dto.getFree_image_original_name());
			pstmt.setString(2, dto.getFree_image_name());
			pstmt.setInt(3,dto.getFree_num());
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	public int free_delete(int free_num){
		sql="DELETE FROM TB_FREE WHERE FREE_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,free_num);
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}
	}
	//댓글 저장
	public int free_comment_create(Free_CommentDTO dto){
		PreparedStatement pstmt1=null;
		int lev=dto.getLev();//첫댓글은 전부 0
		int step=dto.getStep();// 최초댓글은 1 이후에 +1
		
		try{
			con=DbcpBean.getConn();
			if(step!=1){//첫댓글이 아닐경우
				//같은 댓글그룹에서 부모댓글보다 큰 댓글들은step를 +1씩 해준다.
				String sql1="UPDATE TB_FREE_COMMENT SET STEP=STEP+1 WHERE FREE_NUM=? AND STEP>?"; 
				pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1,dto.getFree_num());
				pstmt1.setInt(2, step);
				lev=lev+1;
				step=step+1;
			}
			sql="INSERT INTO TB_FREE_COMMENT VALUES(TB_FREE_COMMENT_SEQ.NEXTVAL,?,SYSDATE,?,?,?,?)";
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getFree_comment_content());
			pstmt.setString(2, dto.getFree_comment_writer());
			pstmt.setInt(3, dto.getLev());
			pstmt.setInt(4, dto.getStep());
			pstmt.setInt(5,dto.getFree_num());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	//댓글 리스트 불러오기
	public ArrayList<Free_CommentDTO> free_comment_read(int free_num){
		sql="SELECT * FROM TB_FREE_COMMENT WHERE FREE_NUM=? ORDER BY FREE_COMMENT_NUM DESC";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs=pstmt.executeQuery();
			ArrayList<Free_CommentDTO> list=new ArrayList<>();
			while(rs.next()){
				Free_CommentDTO dto=new Free_CommentDTO(
						rs.getInt("free_comment_num"),
						rs.getInt("free_num"),
						rs.getString("free_comment_writer"),
						rs.getString("free_comment_content"),
						rs.getString("free_comment_w_date"),
						rs.getInt("lev"),
						rs.getInt("step")						
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
	// 게시물 수정
	public int update(FreeDTO dto){
		sql="UPDATE TB_FREE SET CUSTOMER_NUM=?,FREE_TITLE=?,FREE_CONTENT=?,FREE_WRITER=? WHERE FREE_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getCustomer_num());
			pstmt.setString(2, dto.getFree_title());
			pstmt.setString(3, dto.getFree_content());
			pstmt.setString(4, dto.getFree_writer());
			pstmt.setInt(5, dto.getFree_num());
			int n=pstmt.executeUpdate();
			if(n>0){//정상
				return 1;
			}else{//등록 X경우
				return 0;
			}
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	public Free_ImageDTO free_detail_image(int free_num){
		sql="SELECT * FROM TB_FREE_IMAGE WHERE FREE_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs=pstmt.executeQuery();
			rs.next();
			Free_ImageDTO dto=new Free_ImageDTO(
					rs.getInt("free_image_num"),
					free_num,
					rs.getString("free_image_original_name"),
					rs.getString("free_image_name")
					);
			return dto;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	public int free_update_image(Free_ImageDTO dto_image){
		sql="UPDATE TB_FREE_IMAGE SET FREE_IMAGE_NAME=?,FREE_IMAGE_ORIGINAL_NAME=? WHERE FREE_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto_image.getFree_image_name());
			pstmt.setString(2, dto_image.getFree_image_original_name());
			pstmt.setInt(3, dto_image.getFree_num());
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}	
	}
	public int getCountSearch(String free_search_option,String free_search_text){
		sql="SELECT NVL(COUNT(*),0) CNUM FROM TB_FREE WHERE "+free_search_option+" LIKE '%"+free_search_text+"%'";
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
	
	public ArrayList<FreeDTO> free_search(HashMap<String, String> map){
		String free_search_option=map.get("free_search_option");
		String free_search_text=map.get("free_search_text");
		String startRow=map.get("startRow");
		String endRow=map.get("endRow");
		
		sql="SELECT * FROM(SELECT ROWNUM RNUM,AA.* "
				+ "FROM(SELECT * FROM TB_FREE WHERE "+free_search_option+" LIKE '%"+free_search_text+"%' "
						+ "ORDER BY FREE_NUM DESC) AA) WHERE RNUM>="+startRow+" AND RNUM<="+endRow;
		ArrayList<FreeDTO> list=new ArrayList<>();
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				FreeDTO dto=new FreeDTO(
						rs.getInt("free_num"),
						rs.getString("customer_num"),
						rs.getString("free_title"),
						rs.getString("free_content"),
						rs.getInt("free_hit"),
						rs.getString("free_w_date"),
						rs.getInt("free_password"),
						rs.getString("free_writer")
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
}








