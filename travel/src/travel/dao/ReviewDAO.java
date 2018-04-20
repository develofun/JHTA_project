package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dbcp.bean.DbcpBean;
import travel.dto.ReviewDTO;
import travel.dto.Review_CommentDTO;
import travel.dto.Review_ImageDTO;

public class ReviewDAO {
	private static ReviewDAO instance=new ReviewDAO();
	
	public static ReviewDAO getInstance(){
		return instance;
	}
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql=null;
	
	//가장 큰 글번호 구하기
	public int getMaxNum(){
		sql="SELECT NVL(MAX(REVIEW_NUM),0) MAXNUM FROM TB_REVIEW";
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
		sql ="SELECT NVL(COUNT(*),0) CNUM FROM TB_REVIEW";
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
	public ArrayList<ReviewDTO> review_read(int startRow, int endRow){
		sql="SELECT * FROM(SELECT AA.*,ROWNUM RNUM FROM(SELECT * FROM TB_REVIEW ORDER BY REVIEW_NUM DESC)AA) WHERE RNUM>=? AND RNUM<=?";
		ArrayList<ReviewDTO> list=new ArrayList<>();
		try{		
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);		
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			while(rs.next()){
				int review_num=rs.getInt("review_num");
				String customer_num=rs.getString("customer_num");
				String review_category=rs.getString("review_category");
				String review_title=rs.getString("review_title");
				String review_content=rs.getString("review_content");
				int review_hit=rs.getInt("review_hit");		
				String review_w_date=rs.getString("review_w_date");
				String review_writer=rs.getString("review_writer");
				ReviewDTO dto=new ReviewDTO(review_num, customer_num, review_category, review_title, review_content, review_hit, review_w_date, review_writer);
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
	public ArrayList<ReviewDTO> hit_top10(){
		sql="SELECT * FROM(SELECT AA.*,ROWNUM RNUM FROM(SELECT * FROM TB_REVIEW ORDER BY REVIEW_HIT DESC)AA) WHERE RNUM<'11'";
		ArrayList<ReviewDTO> list1=new ArrayList<>();
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);	
			rs=pstmt.executeQuery();
			while(rs.next()){
				int review_num=rs.getInt("review_num");
				String customer_num=rs.getString("customer_num");
				String review_category=rs.getString("review_category");
				String review_title=rs.getString("review_title");
				String review_content=rs.getString("review_content");
				int review_hit=rs.getInt("review_hit");		
				String review_w_date=rs.getString("review_w_date");
				String review_writer=rs.getString("review_writer");
				ReviewDTO dto1=new ReviewDTO(review_num, customer_num, review_category, review_title, review_content, review_hit, review_w_date, review_writer);
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
	public ArrayList<ReviewDTO> comment_top10(){
		PreparedStatement pstmt1=null;
		ResultSet rs1=null;
		// comment table에서 댓글많은 게시글 10개의 글번호를 구함
		sql="SELECT * FROM(SELECT REVIEW_NUM,COUNT(*) CNT FROM TB_REVIEW_COMMENT GROUP BY REVIEW_NUM ORDER BY CNT DESC) WHERE ROWNUM<11";
		ArrayList<ReviewDTO> list=new ArrayList<>();
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);	
			rs=pstmt.executeQuery();
			while(rs.next()){//구한 글번호로 자유게시판 에서 select하기
				int review_num=rs.getInt("review_num");
				String sql1="SELECT * FROM TB_REVIEW WHERE REVIEW_NUM=?";
				pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1, review_num);
				rs1=pstmt1.executeQuery();
				if(rs1.next()){
					int review_num1=rs1.getInt("review_num");
					String customer_num=rs1.getString("customer_num");
					String review_category=rs1.getString("review_category");
					String review_title=rs1.getString("review_title");
					String review_content=rs1.getString("review_content");
					int review_hit=rs1.getInt("review_hit");		
					String review_w_date=rs1.getString("review_w_date");			
					String review_writer=rs1.getString("review_writer");
					ReviewDTO dto=new ReviewDTO(review_num1, customer_num, review_category, review_title, review_content, review_hit, review_w_date, review_writer);
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
	public ReviewDTO detail(int review_num){	
		String sql1="UPDATE TB_REVIEW SET REVIEW_HIT=REVIEW_HIT+1 WHERE REVIEW_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql1);
			pstmt.setInt(1, review_num);
			int n=pstmt.executeUpdate();
			sql="select * from tb_review where review_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String customer_num=rs.getString("customer_num");
				String review_category=rs.getString("review_category"); //회원번호가 출력됨
				String review_title=rs.getString("review_title");		
				String review_content=rs.getString("review_content");
				String review_w_date=rs.getString("review_w_date");
				int review_hit=rs.getInt("review_hit");
				String review_writer=rs.getString("review_writer");
				ReviewDTO dto=new ReviewDTO(review_num, customer_num, review_category,  review_title, review_content, review_hit, review_w_date, review_writer);
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
	// 상세보기 이미지 불러오기
	public Review_ImageDTO image(int review_num){
		sql="SELECT * FROM TB_REVIEW_IMAGE WHERE REVIEW_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				int review_image_num=rs.getInt("review_image_num");
				String review_image_original_name=rs.getString("review_image_original_name");
				String review_image_name=rs.getString("review_image_name");
				Review_ImageDTO dto=new Review_ImageDTO(review_image_num, review_num, review_image_original_name, review_image_name);
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
	public int create(ReviewDTO dto){
		sql="INSERT INTO TB_REVIEW VALUES(tb_review_seq.nextval,?,?,?,?,'0',SYSDATE,?)";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getCustomer_num());
			pstmt.setString(2, dto.getReview_category());
			pstmt.setString(3, dto.getReview_title());
			pstmt.setString(4, dto.getReview_content());
			pstmt.setString(5, dto.getReview_writer());
			int n=pstmt.executeUpdate();
			String sql1="SELECT NVL(MAX(REVIEW_NUM),0) MAXNUM FROM TB_REVIEW WHERE CUSTOMER_NUM=?";
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
	public int reviewimageinsert(Review_ImageDTO dto){
		/*
		System.out.println("글번호:"+dto.getReview_num());
		System.out.println("실제 이미지 이름:"+dto.getReview_image_original_name());
		System.out.println("저장될 이미지 이름:"+dto.getReview_image_name());
		*/
		sql="INSERT INTO TB_REVIEW_IMAGE VALUES(TB_REVIEW_IMAGE_SEQ.NEXTVAL,?,?,?)";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);			
			pstmt.setString(1, dto.getReview_image_original_name());
			pstmt.setString(2, dto.getReview_image_name());
			pstmt.setInt(3,dto.getReview_num());
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	public int review_delete(int review_num){
		sql="DELETE FROM TB_REVIEW WHERE REVIEW_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,review_num);
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}
	}
	//댓글저장
	public int review_comment_create(Review_CommentDTO dto){
		PreparedStatement pstmt1=null;
		int lev=dto.getLev();//첫댓글은 전부 0
		int step=dto.getStep();// 최초댓글은 1 이후에 +1
		
		try{
			con=DbcpBean.getConn();
			if(step!=1){//첫댓글이 아닐경우
				//같은 댓글그룹에서 부모댓글보다 큰 댓글들은step를 +1씩 해준다.
				String sql1="UPDATE TB_REVIEW_COMMENT SET STEP=STEP+1 WHERE REVIEW_NUM=? AND STEP>?"; 
				pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1,dto.getReview_num());
				pstmt1.setInt(2, step);
				lev=lev+1;
				step=step+1;
			}
			sql="INSERT INTO TB_REVIEW_COMMENT VALUES(TB_REVIEW_COMMENT_SEQ.NEXTVAL,?,SYSDATE,?,?,?,?)";
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getReview_comment_content());
			pstmt.setString(2, dto.getReview_comment_writer());
			pstmt.setInt(3, dto.getLev());
			pstmt.setInt(4, dto.getStep());
			pstmt.setInt(5,dto.getReview_num());
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
	public ArrayList<Review_CommentDTO> review_comment_read(int review_num){
		sql="SELECT * FROM TB_REVIEW_COMMENT WHERE REVIEW_NUM=? ORDER BY REVIEW_COMMENT_NUM DESC";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs=pstmt.executeQuery();
			ArrayList<Review_CommentDTO> list=new ArrayList<>();
			while(rs.next()){
				Review_CommentDTO dto=new Review_CommentDTO(
						rs.getInt("review_comment_num"),
						rs.getInt("review_num"),
						rs.getString("review_comment_writer"),
						rs.getString("review_comment_content"),
						rs.getString("review_comment_w_date"),
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
	public int update(ReviewDTO dto){
		sql="UPDATE TB_REVIEW SET CUSTOMER_NUM=?,REVIEW_TITLE=?,REVIEW_CONTENT=?,REVIEW_WRITER=? WHERE REVIEW_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getCustomer_num());
			pstmt.setString(2, dto.getReview_title());
			pstmt.setString(3, dto.getReview_content());
			pstmt.setString(4, dto.getReview_writer());
			pstmt.setInt(5, dto.getReview_num());
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
	public Review_ImageDTO review_detail_image(int review_num){
		sql="SELECT * FROM TB_REVIEW_IMAGE WHERE REVIEW_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs=pstmt.executeQuery();
			rs.next();
			Review_ImageDTO dto=new Review_ImageDTO(
					rs.getInt("review_image_num"),
					review_num,
					rs.getString("review_image_original_name"),
					rs.getString("review_image_name")
					);
			return dto;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, con);
		}
	}
	public int review_update_image(Review_ImageDTO dto_image){
		sql="UPDATE TB_REVIEW_IMAGE SET REVIEW_IMAGE_NAME=?,REVIEW_IMAGE_ORIGINAL_NAME=? WHERE REVIEW_NUM=?";
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto_image.getReview_image_name());
			pstmt.setString(2, dto_image.getReview_image_original_name());
			pstmt.setInt(3, dto_image.getReview_num());
			return pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt, con);
		}	
	}
	public int getCountSearch(String review_search_option,String review_search_text){
		sql="SELECT NVL(COUNT(*),0) CNUM FROM TB_REVIEW WHERE "+review_search_option+" LIKE '%"+review_search_text+"%'";
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
	
	public ArrayList<ReviewDTO> review_search(HashMap<String, String> map){
		String review_search_option=map.get("review_search_option");
		String review_search_text=map.get("review_search_text");
		//System.out.println(review_search_option);
		//System.out.println(review_search_text);
		String startRow=map.get("startRow");
		String endRow=map.get("endRow");
		
		sql="SELECT * FROM(SELECT ROWNUM RNUM,AA.* "
				+ "FROM(SELECT * FROM TB_REVIEW WHERE "+review_search_option+" LIKE '%"+review_search_text+"%' "
						+ "ORDER BY REVIEW_NUM DESC) AA) WHERE RNUM>="+startRow+" AND RNUM<="+endRow;
		ArrayList<ReviewDTO> list=new ArrayList<>();
		try{
			con=DbcpBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ReviewDTO dto=new ReviewDTO(
						rs.getInt("review_num"),
						rs.getString("customer_num"),
						rs.getString("review_category"),
						rs.getString("review_title"),
						rs.getString("review_content"),
						rs.getInt("review_hit"),
						rs.getString("review_w_date"),
						rs.getString("review_writer")
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








