package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbcp.bean.DbcpBean;
import travel.dto.FboardAttractionDTO;
import travel.dto.FboardAttractionImageDTO;
import travel.dto.FboardDTO;
import travel.dto.FboardFestivalDTO;
import travel.dto.FboardFestivalImageDTO;
import travel.dto.FboardReadAllDTO;
import travel.dto.FboardRestaurantDTO;
import travel.dto.FboardRestaurantImageDTO;
import travel.dto.FboardShoppingDTO;
import travel.dto.FboardShoppingImageDTO;

public class FboardDAO {
	//전체 글 수
	public int getCount_read_all(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(count(fboard_num),0) from tb_fboard");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//지역 글 수
	public int getCount_read_area(String fboard_area,String fboard_city,String fboard_category){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		try{
			conn=DbcpBean.getConn();
			if(fboard_area!=null){
				if(fboard_city!=null){
					if(fboard_category!=null){//모든조건
						sql="select nvl(count(fboard_num),0) from tb_fboard where fboard_area=? and fboard_city=? and fboard_category=?";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_area);
						pstmt.setString(2, fboard_city);
						pstmt.setString(3, fboard_category);
					}else{//지역+도시
						sql="select nvl(count(fboard_num),0) from tb_fboard where fboard_city=? and fboard_area=?";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_city);
						pstmt.setString(2, fboard_area);
					}
				}else{//지역+카테
					if(fboard_category!=null){//지역+카테
						sql="select nvl(count(fboard_num),0) from tb_fboard where fboard_area=? and fboard_category=?";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_area);
						pstmt.setString(2, fboard_category);
					}else{//지역
						sql="select nvl(count(fboard_num),0) from tb_fboard where fboard_area=?";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_area);
					}
				}
			}else{
				if(fboard_city!=null){
					if(fboard_category!=null){
						sql="select nvl(count(fboard_num),0) from tb_fboard where fboard_city=? and fboard_category=?";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_city);
						pstmt.setString(2, fboard_category);
						
					}else{
						sql="select nvl(count(fboard_num),0) from tb_fboard where fboard_city=?";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_city);
					}
				}else{
					sql="select nvl(count(fboard_num),0) from tb_fboard where fboard_category=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, fboard_category);
				}
			}
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//해외여행 최근 게시물번호
	public int getMaxNum_fboard(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(max(fboard_num),0) from tb_fboard");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//명소 최근 게시물번호
	public int getMaxNum_fboard_attraction(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(max(fboard_attraction_num),0) from tb_fboard_attraction");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//맛집 최근 게시물번호
	public int getMaxNum_fboard_restaurant(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(max(fboard_restaurant_num),0) from tb_fboard_restaurant");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//축제/행사 최근 게시물번호
	public int getMaxNum_fboard_festival(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(max(fboard_festival_num),0) from tb_fboard_festival");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	
	//쇼핑 최근 게시물번호
	public int getMaxNum_fboard_shopping(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(max(fboard_shopping_num),0) from tb_fboard_shopping");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//카테고리 최근 이미지 게시물번호
	//명소
	public int getMaxNum_fboard_attraction_image(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(max(fboard_attraction_num),0) from tb_fboard_attraction");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//맛집
	public int getMaxNum_fboard_restaurant_image(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(max(fboard_restaurant_image_num),0) from tb_fboard_restaurant_image");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//축제
	public int getMaxNum_fboard_festival_image(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(max(fboard_festival_num),0) from tb_fboard_festival_image");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//쇼핑
	public int getMaxNum_fboard_shopping_image(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement("select nvl(max(fboard_shopping_image_num),0) from tb_fboard_shopping_image");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			return num;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	
	
	//글쓰기
	//명소
	public int create_fboard_attraction(FboardDTO dto,FboardAttractionDTO dto_attraction, FboardAttractionImageDTO dto_image){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("insert into tb_fboard values(?,?,?,?)");
			pstmt2=conn.prepareStatement("insert into tb_fboard_attraction values(?,?,?,?,?,?,?,?,?,sysdate)");
			pstmt3=conn.prepareStatement("insert into tb_fboard_attraction_image values(?,?,?)");
			pstmt1.setInt(1, getMaxNum_fboard()+1);
			pstmt1.setString(2, dto.getFboard_area());
			pstmt1.setString(3, dto.getFboard_city());
			pstmt1.setString(4, dto.getFboard_category());
			pstmt2.setInt(1, getMaxNum_fboard_attraction()+1);
			pstmt2.setInt(2, getMaxNum_fboard()+1);
			pstmt2.setString(3, dto_attraction.getFboard_attraction_title());
			pstmt2.setString(4, dto_attraction.getFboard_attraction_sub_title());
			pstmt2.setString(5, dto_attraction.getFboard_attraction_time());
			pstmt2.setString(6, dto_attraction.getFboard_attraction_price());
			pstmt2.setString(7, dto_attraction.getFboard_attraction_home_page());
			pstmt2.setString(8, dto_attraction.getFboard_attraction_go());
			pstmt2.setString(9, dto_attraction.getFboard_attraction_content());
			pstmt3.setInt(1, getMaxNum_fboard_attraction_image()+1);
			pstmt3.setInt(2, getMaxNum_fboard_attraction()+1);
			pstmt3.setString(3, dto_image.getFboard_attraction_image_name());
			int n1=pstmt1.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n3=pstmt3.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			try {
				conn.rollback();
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			}
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//맛집
	public int create_fboard_restaurant(FboardDTO dto,FboardRestaurantDTO restaurant_dto, FboardRestaurantImageDTO dto_image){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("insert into tb_fboard values(?,?,?,?)");
			pstmt2=conn.prepareStatement("insert into tb_fboard_restaurant values(?,?,?,?,?,?,?,?,?,sysdate)");
			pstmt3=conn.prepareStatement("insert into tb_fboard_restaurant_image values(?,?,?)");
			pstmt1.setInt(1, getMaxNum_fboard()+1);
			pstmt1.setString(2, dto.getFboard_area());
			pstmt1.setString(3, dto.getFboard_city());
			pstmt1.setString(4, dto.getFboard_category());
			pstmt2.setInt(1, getMaxNum_fboard_restaurant()+1);
			pstmt2.setInt(2, getMaxNum_fboard()+1);
			pstmt2.setString(3, restaurant_dto.getFboard_restaurant_title());
			pstmt2.setString(4, restaurant_dto.getFboard_restaurant_sub_title());
			pstmt2.setString(5, restaurant_dto.getFboard_restaurant_time());
			pstmt2.setString(6, restaurant_dto.getFboard_restaurant_price());
			pstmt2.setString(7, restaurant_dto.getFboard_restaurant_home_page());
			pstmt2.setString(8, restaurant_dto.getFboard_restaurant_go());
			pstmt2.setString(9, restaurant_dto.getFboard_restaurant_content());
			pstmt3.setInt(1, getMaxNum_fboard_restaurant_image()+1);
			pstmt3.setInt(2, getMaxNum_fboard_restaurant()+1);
			pstmt3.setString(3, dto_image.getFboard_restaurant_image());
			int n1=pstmt1.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n3=pstmt3.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//축제/행사
	public int create_fboard_festival(FboardDTO dto,FboardFestivalDTO festival_dto, FboardFestivalImageDTO dto_image){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("insert into tb_fboard values(?,?,?,?)");
			pstmt2=conn.prepareStatement("insert into tb_fboard_festival values(?,?,?,?,?,?,sysdate)");
			pstmt3=conn.prepareStatement("insert into tb_fboard_festival_image values(?,?,?)");
			pstmt1.setInt(1, getMaxNum_fboard()+1);
			pstmt1.setString(2, dto.getFboard_area());
			pstmt1.setString(3, dto.getFboard_city());
			pstmt1.setString(4, dto.getFboard_category());
			pstmt2.setInt(1, getMaxNum_fboard_festival()+1);
			pstmt2.setInt(2, getMaxNum_fboard()+1);
			pstmt2.setString(3, festival_dto.getFboard_festival_title());
			pstmt2.setString(4, festival_dto.getFboard_festival_sub_title());
			pstmt2.setString(5, festival_dto.getFboard_festival_period());
			pstmt2.setString(6, festival_dto.getFboard_festival_contents());
			pstmt3.setInt(1, getMaxNum_fboard_festival_image()+1);
			pstmt3.setInt(2, getMaxNum_fboard_festival()+1);
			pstmt3.setString(3, dto_image.getFboard_festival_image_name());
			int n1=pstmt1.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n3=pstmt3.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//쇼핑
	public int create_fboard_shopping(FboardDTO dto,FboardShoppingDTO shopping_dto, FboardShoppingImageDTO dto_image){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("insert into tb_fboard values(?,?,?,?)");
			pstmt2=conn.prepareStatement("insert into tb_fboard_shopping values(?,?,?,?,?,?,?,?,sysdate)");
			pstmt3=conn.prepareStatement("insert into tb_fboard_shopping_image values(?,?,?)");
			pstmt1.setInt(1, getMaxNum_fboard()+1);
			pstmt1.setString(2, dto.getFboard_area());
			pstmt1.setString(3, dto.getFboard_city());
			pstmt1.setString(4, dto.getFboard_category());
			pstmt2.setInt(1, getMaxNum_fboard_shopping()+1);
			pstmt2.setInt(2, getMaxNum_fboard()+1);
			pstmt2.setString(3, shopping_dto.getFboard_shopping_title());
			pstmt2.setString(4, shopping_dto.getFboard_shopping_sub_title());
			pstmt2.setString(5, shopping_dto.getTb_fboard_shopping_time());
			pstmt2.setString(6, shopping_dto.getFboard_shopping_homepage());
			pstmt2.setString(7, shopping_dto.getFboard_shopping_go());
			pstmt2.setString(8, shopping_dto.getFboard_shopping_contents());
			pstmt3.setInt(1, getMaxNum_fboard_shopping_image()+1);
			pstmt3.setInt(2, getMaxNum_fboard_shopping()+1);
			pstmt3.setString(3, dto_image.getFboard_shopping_image_name());
			int n1=pstmt1.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n3=pstmt3.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//해외여행 페이지 리스트
	//전체
	public ArrayList<FboardReadAllDTO> fboard_read_all(int startRow,int endRow){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select* from(select uni.* ,rownum rnum from (select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_attraction_TITLE fboard_title,fboard_attraction_image_name fboard_image from tb_fboard_attraction_image tai, TB_FBOARD_attraction ta ,tb_fboard t WHERE ta.FBOARD_ATTRACTION_NUM=tai.FBOARD_ATTRACTION_NUM and ta.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_restaurant_TITLE, fboard_restaurant_image from tb_fboard_restaurant_image tri, TB_FBOARD_RESTAURANT tr,tb_fboard t where tri.FBOARD_RESTAURANT_NUM=tr.FBOARD_RESTAURANT_NUM and tr.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_festival_TITLE, FBOARD_FESTIVAL_IMAGE_NAME from tb_fboard_festival_image tfi, TB_FBOARD_festival tf,tb_fboard t where tfi.FBOARD_FESTIVAL_NUM=tf.FBOARD_FESTIVAL_NUM and tf.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,fboard_shopping_title, fboard_shopping_image_name from tb_fboard_shopping_image tsi,tb_fboard_shopping ts,tb_fboard t where tsi.FBOARD_SHOPPING_NUM=ts.FBOARD_SHOPPING_NUM and ts.FBOARD_NUM=t.FBOARD_NUM order by fboard_num desc) uni) where rnum>=? and rnum<=? order by fboard_num desc";
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<FboardReadAllDTO>list=new ArrayList<>();
			while(rs.next()){
				FboardReadAllDTO readdto=new FboardReadAllDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7));
				list.add(readdto);
			}
			return list;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
		
	}
	//조건 리스트
	public ArrayList<FboardReadAllDTO> fboard_read_search(int startRow,int endRow,String fboard_area,String fboard_city,String fboard_category){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<FboardReadAllDTO>list=new ArrayList<>();
		String sql="";
		try{
			conn=DbcpBean.getConn();
			if(fboard_area!=null){
				if(fboard_city!=null&&fboard_category!=""){
					if(fboard_category!=null&&fboard_category!=""){//지역+도시+카테
						sql="select*from(select uni.* ,rownum rnum from (select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_attraction_TITLE fboard_title,fboard_attraction_image_name fboard_image from tb_fboard_attraction_image tai, TB_FBOARD_attraction ta ,tb_fboard t WHERE ta.FBOARD_ATTRACTION_NUM=tai.FBOARD_ATTRACTION_NUM and ta.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_restaurant_TITLE, fboard_restaurant_image from tb_fboard_restaurant_image tri, TB_FBOARD_RESTAURANT tr,tb_fboard t where tri.FBOARD_RESTAURANT_NUM=tr.FBOARD_RESTAURANT_NUM and tr.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_festival_TITLE, FBOARD_FESTIVAL_IMAGE_NAME from tb_fboard_festival_image tfi, TB_FBOARD_festival tf,tb_fboard t where tfi.FBOARD_FESTIVAL_NUM=tf.FBOARD_FESTIVAL_NUM and tf.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,fboard_shopping_title, fboard_shopping_image_name from tb_fboard_shopping_image tsi,tb_fboard_shopping ts,tb_fboard t where tsi.FBOARD_SHOPPING_NUM=ts.FBOARD_SHOPPING_NUM and ts.FBOARD_NUM=t.FBOARD_NUM order by fboard_num desc) uni where fboard_area=? and fboard_city=? and fboard_category=?) where rnum>=? and rnum<=? order by fboard_num desc";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_area);
						pstmt.setString(2, fboard_city);
						pstmt.setString(3, fboard_category);
						pstmt.setInt(4, startRow);
						pstmt.setInt(5, endRow);
						rs=pstmt.executeQuery();
						while (rs.next()) {
							FboardReadAllDTO fboard_dto=new FboardReadAllDTO
									(rs.getInt(1), rs.getString(2),rs.getString(3), 
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
							list.add(fboard_dto);
						}
					}else{//지역+도시
						sql="select*from(select uni.* ,rownum rnum from (select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_attraction_TITLE fboard_title,fboard_attraction_image_name fboard_image from tb_fboard_attraction_image tai, TB_FBOARD_attraction ta ,tb_fboard t WHERE ta.FBOARD_ATTRACTION_NUM=tai.FBOARD_ATTRACTION_NUM and ta.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_restaurant_TITLE, fboard_restaurant_image from tb_fboard_restaurant_image tri, TB_FBOARD_RESTAURANT tr,tb_fboard t where tri.FBOARD_RESTAURANT_NUM=tr.FBOARD_RESTAURANT_NUM and tr.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_festival_TITLE, FBOARD_FESTIVAL_IMAGE_NAME from tb_fboard_festival_image tfi, TB_FBOARD_festival tf,tb_fboard t where tfi.FBOARD_FESTIVAL_NUM=tf.FBOARD_FESTIVAL_NUM and tf.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,fboard_shopping_title, fboard_shopping_image_name from tb_fboard_shopping_image tsi,tb_fboard_shopping ts,tb_fboard t where tsi.FBOARD_SHOPPING_NUM=ts.FBOARD_SHOPPING_NUM and ts.FBOARD_NUM=t.FBOARD_NUM order by fboard_num desc) uni where fboard_area=? and fboard_city=?) where rnum>=? and rnum<=? order by fboard_num desc";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_area);
						pstmt.setString(2, fboard_city);
						pstmt.setInt(3, startRow);
						pstmt.setInt(4, endRow);
						rs=pstmt.executeQuery();
						while (rs.next()) {
							FboardReadAllDTO fboard_dto=new FboardReadAllDTO
									(rs.getInt(1), rs.getString(2),rs.getString(3), 
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
							list.add(fboard_dto);
						}
					}
				}else{//지역,카테
					if(fboard_category!=null&&fboard_category!=""){//지역+카테
						sql="select*from(select uni.* ,rownum rnum from (select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_attraction_TITLE fboard_title,fboard_attraction_image_name fboard_image from tb_fboard_attraction_image tai, TB_FBOARD_attraction ta ,tb_fboard t WHERE ta.FBOARD_ATTRACTION_NUM=tai.FBOARD_ATTRACTION_NUM and ta.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_restaurant_TITLE, fboard_restaurant_image from tb_fboard_restaurant_image tri, TB_FBOARD_RESTAURANT tr,tb_fboard t where tri.FBOARD_RESTAURANT_NUM=tr.FBOARD_RESTAURANT_NUM and tr.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_festival_TITLE, FBOARD_FESTIVAL_IMAGE_NAME from tb_fboard_festival_image tfi, TB_FBOARD_festival tf,tb_fboard t where tfi.FBOARD_FESTIVAL_NUM=tf.FBOARD_FESTIVAL_NUM and tf.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,fboard_shopping_title, fboard_shopping_image_name from tb_fboard_shopping_image tsi,tb_fboard_shopping ts,tb_fboard t where tsi.FBOARD_SHOPPING_NUM=ts.FBOARD_SHOPPING_NUM and ts.FBOARD_NUM=t.FBOARD_NUM order by fboard_num desc) uni where fboard_area=? and fboard_category=?) where rnum>=? and rnum<=? order by fboard_num desc";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_area);
						pstmt.setString(2, fboard_category);
						pstmt.setInt(3, startRow);
						pstmt.setInt(4, endRow);
						rs=pstmt.executeQuery();
						while (rs.next()) {
							FboardReadAllDTO fboard_dto=new FboardReadAllDTO
									(rs.getInt(1), rs.getString(2),rs.getString(3), 
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
							list.add(fboard_dto);
						}
					}else{//지역
						System.out.println(fboard_area);
						sql="select*from(select uni.* ,rownum rnum from (select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_attraction_TITLE fboard_title,fboard_attraction_image_name fboard_image from tb_fboard_attraction_image tai, TB_FBOARD_attraction ta ,tb_fboard t WHERE ta.FBOARD_ATTRACTION_NUM=tai.FBOARD_ATTRACTION_NUM and ta.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_restaurant_TITLE, fboard_restaurant_image from tb_fboard_restaurant_image tri, TB_FBOARD_RESTAURANT tr,tb_fboard t where tri.FBOARD_RESTAURANT_NUM=tr.FBOARD_RESTAURANT_NUM and tr.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_festival_TITLE, FBOARD_FESTIVAL_IMAGE_NAME from tb_fboard_festival_image tfi, TB_FBOARD_festival tf,tb_fboard t where tfi.FBOARD_FESTIVAL_NUM=tf.FBOARD_FESTIVAL_NUM and tf.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,fboard_shopping_title, fboard_shopping_image_name from tb_fboard_shopping_image tsi,tb_fboard_shopping ts,tb_fboard t where tsi.FBOARD_SHOPPING_NUM=ts.FBOARD_SHOPPING_NUM and ts.FBOARD_NUM=t.FBOARD_NUM order by fboard_num desc) uni where fboard_area=?) where rnum>=? and rnum<=? order by fboard_num desc";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_area);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						rs=pstmt.executeQuery();
						while (rs.next()) {
							FboardReadAllDTO fboard_dto=new FboardReadAllDTO
									(rs.getInt(1), rs.getString(2),rs.getString(3), 
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
							list.add(fboard_dto);
						}
					}
				}
			}else{//도시,카테
				if(fboard_city!=null){
					if(fboard_category!=null){//도시+카테
						sql="select*from(select uni.* ,rownum rnum from (select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_attraction_TITLE fboard_title,fboard_attraction_image_name fboard_image from tb_fboard_attraction_image tai, TB_FBOARD_attraction ta ,tb_fboard t WHERE ta.FBOARD_ATTRACTION_NUM=tai.FBOARD_ATTRACTION_NUM and ta.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_restaurant_TITLE, fboard_restaurant_image from tb_fboard_restaurant_image tri, TB_FBOARD_RESTAURANT tr,tb_fboard t where tri.FBOARD_RESTAURANT_NUM=tr.FBOARD_RESTAURANT_NUM and tr.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_festival_TITLE, FBOARD_FESTIVAL_IMAGE_NAME from tb_fboard_festival_image tfi, TB_FBOARD_festival tf,tb_fboard t where tfi.FBOARD_FESTIVAL_NUM=tf.FBOARD_FESTIVAL_NUM and tf.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,fboard_shopping_title, fboard_shopping_image_name from tb_fboard_shopping_image tsi,tb_fboard_shopping ts,tb_fboard t where tsi.FBOARD_SHOPPING_NUM=ts.FBOARD_SHOPPING_NUM and ts.FBOARD_NUM=t.FBOARD_NUM order by fboard_num desc) uni where fboard_city=? and fboard_category=?) where rnum>=? and rnum<=? order by fboard_num desc";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_city);
						pstmt.setString(2, fboard_category);
						pstmt.setInt(3, startRow);
						pstmt.setInt(4, endRow);
						rs=pstmt.executeQuery();
						while (rs.next()) {
							FboardReadAllDTO fboard_dto=new FboardReadAllDTO
									(rs.getInt(1), rs.getString(2),rs.getString(3), 
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
							list.add(fboard_dto);
						}
					}else{//도시
						sql="select*from(select uni.* ,rownum rnum from (select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_attraction_TITLE fboard_title,fboard_attraction_image_name fboard_image from tb_fboard_attraction_image tai, TB_FBOARD_attraction ta ,tb_fboard t WHERE ta.FBOARD_ATTRACTION_NUM=tai.FBOARD_ATTRACTION_NUM and ta.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_restaurant_TITLE, fboard_restaurant_image from tb_fboard_restaurant_image tri, TB_FBOARD_RESTAURANT tr,tb_fboard t where tri.FBOARD_RESTAURANT_NUM=tr.FBOARD_RESTAURANT_NUM and tr.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_festival_TITLE, FBOARD_FESTIVAL_IMAGE_NAME from tb_fboard_festival_image tfi, TB_FBOARD_festival tf,tb_fboard t where tfi.FBOARD_FESTIVAL_NUM=tf.FBOARD_FESTIVAL_NUM and tf.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,fboard_shopping_title, fboard_shopping_image_name from tb_fboard_shopping_image tsi,tb_fboard_shopping ts,tb_fboard t where tsi.FBOARD_SHOPPING_NUM=ts.FBOARD_SHOPPING_NUM and ts.FBOARD_NUM=t.FBOARD_NUM order by fboard_num desc) uni where fboard_city=?) where rnum>=? and rnum<=? order by fboard_num desc";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, fboard_city);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						rs=pstmt.executeQuery();
						while (rs.next()) {
							FboardReadAllDTO fboard_dto=new FboardReadAllDTO
									(rs.getInt(1), rs.getString(2),rs.getString(3), 
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
							list.add(fboard_dto);
						}
					}
				}else{//카테
					sql="select*from(select uni.* ,rownum rnum from (select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_attraction_TITLE fboard_title,fboard_attraction_image_name fboard_image from tb_fboard_attraction_image tai, TB_FBOARD_attraction ta ,tb_fboard t WHERE ta.FBOARD_ATTRACTION_NUM=tai.FBOARD_ATTRACTION_NUM and ta.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_restaurant_TITLE, fboard_restaurant_image from tb_fboard_restaurant_image tri, TB_FBOARD_RESTAURANT tr,tb_fboard t where tri.FBOARD_RESTAURANT_NUM=tr.FBOARD_RESTAURANT_NUM and tr.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,FBOARD_festival_TITLE, FBOARD_FESTIVAL_IMAGE_NAME from tb_fboard_festival_image tfi, TB_FBOARD_festival tf,tb_fboard t where tfi.FBOARD_FESTIVAL_NUM=tf.FBOARD_FESTIVAL_NUM and tf.FBOARD_NUM=t.FBOARD_NUM union select t.fboard_num,t.FBOARD_AREA,t.FBOARD_CITY,t.FBOARD_CATEGORY,fboard_shopping_title, fboard_shopping_image_name from tb_fboard_shopping_image tsi,tb_fboard_shopping ts,tb_fboard t where tsi.FBOARD_SHOPPING_NUM=ts.FBOARD_SHOPPING_NUM and ts.FBOARD_NUM=t.FBOARD_NUM order by fboard_num desc) uni where fboard_category=?) where rnum>=? and rnum<=? order by fboard_num desc";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, fboard_category);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					rs=pstmt.executeQuery();
					while (rs.next()) {
						FboardReadAllDTO fboard_dto=new FboardReadAllDTO
								(rs.getInt(1), rs.getString(2),rs.getString(3), 
								rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
						list.add(fboard_dto);
					}
				}
			}
			return list;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
		
	}
	
	
	
	//상세 페이지 (명소)
	public FboardAttractionDTO detail_attraction_string(int fboard_num){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select*from tb_fboard_attraction where fboard_num=?";
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, fboard_num);
			rs=pstmt.executeQuery();
			rs.next();
			FboardAttractionDTO attraction_dto=new FboardAttractionDTO
					(rs.getInt(1),fboard_num,rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8),rs.getString(9),
					rs.getString(10));
			return attraction_dto;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	public FboardAttractionImageDTO detail_attraction_image(int fboard_attraction_num){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select * from tb_fboard_attraction_image where fboard_attraction_num=?";
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, fboard_attraction_num);
			rs=pstmt.executeQuery();
			rs.next();
			FboardAttractionImageDTO fboard_attraction_image=new FboardAttractionImageDTO
					(fboard_attraction_num,rs.getInt(2),rs.getString(3));
			return fboard_attraction_image;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//상세 페이지 (맛집)
	public FboardRestaurantDTO detail_restaurant_string(int fboard_num){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select*from tb_fboard_restaurant where fboard_num=?";
		try {
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, fboard_num);
			rs=pstmt.executeQuery();
			rs.next();
			FboardRestaurantDTO restaurant_dto=new FboardRestaurantDTO
					(rs.getInt(1),fboard_num,rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8),rs.getString(9),
					rs.getString(10));
			return restaurant_dto;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	public FboardRestaurantImageDTO detail_restaurant_image(int fboard_restaurant_num){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select * from tb_fboard_restaurant_image where fboard_restaurant_num=?";
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, fboard_restaurant_num);
			rs=pstmt.executeQuery();
			rs.next();
			FboardRestaurantImageDTO fboard_restaurant_image=new FboardRestaurantImageDTO
					(fboard_restaurant_num,rs.getInt(2),rs.getString(3));
			return fboard_restaurant_image;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//상세 페이지 (축제)
	public FboardFestivalDTO detail_festival(int fboard_num){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select * from tb_fboard_festival where fboard_num=?";
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, fboard_num);
			rs=pstmt.executeQuery();
			rs.next();
			FboardFestivalDTO festival_dto=new FboardFestivalDTO
					(rs.getInt(1),
					fboard_num,
					rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7));
			return festival_dto;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	public FboardFestivalImageDTO detail_festival_image(int fboard_festival_num){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select * from tb_fboard_festival_image where fboard_festival_num=?";
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, fboard_festival_num);
			rs=pstmt.executeQuery();
			rs.next();
			FboardFestivalImageDTO fboard_festival_image=new FboardFestivalImageDTO
					(fboard_festival_num,rs.getInt(2),rs.getString(3));
			return fboard_festival_image;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//상세 페이지 (쇼핑)
	public FboardShoppingDTO detail_shopping_string(int fboard_num){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select * from tb_fboard_shopping where fboard_num=?";
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, fboard_num);
			rs=pstmt.executeQuery();
			rs.next();
			FboardShoppingDTO shopping_dto=new FboardShoppingDTO
					(rs.getInt(1),fboard_num,rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8),rs.getString(9));
			return shopping_dto;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	public FboardShoppingImageDTO detail_shopping_image(int fboard_shopping_num){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select * from tb_fboard_shopping_image where fboard_shopping_num=?";
		ResultSet rs=null;
		try{
			conn=DbcpBean.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, fboard_shopping_num);
			rs=pstmt.executeQuery();
			rs.next();
			FboardShoppingImageDTO fboard_shopping_image=
					new FboardShoppingImageDTO
					(fboard_shopping_num,rs.getInt(2),rs.getString(3));
			return fboard_shopping_image;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally{
			DbcpBean.close(rs, pstmt, conn);
		}
	}
	//수정
	//명소
	public int update_attraction(FboardDTO fboard_dto,FboardAttractionDTO attraction_dto, FboardAttractionImageDTO image_dto,int fboard_num,int detail_num){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
	try{
		conn=DbcpBean.getConn();
		conn.setAutoCommit(false);
		pstmt1=conn.prepareStatement("update tb_fboard set fboard_area=?, fboard_city=?, fboard_category=? where fboard_num=?");
		pstmt1.setString(1, fboard_dto.getFboard_area());
		pstmt1.setString(2, fboard_dto.getFboard_city());
		pstmt1.setString(3, fboard_dto.getFboard_category());
		pstmt1.setInt(4, fboard_num);
		pstmt2=conn.prepareStatement("update tb_fboard_attraction set fboard_attraction_title=?, fboard_attraction_sub_title=?,"
				+ "fboard_attraction_time=?, fboard_attraction_price=?, fboard_attraction_home_page=?,"
				+ "fboard_attraction_go=?, fboard_attraction_content=? where fboard_num=?");
		pstmt2.setString(1, attraction_dto.getFboard_attraction_title());
		pstmt2.setString(2, attraction_dto.getFboard_attraction_sub_title());
		pstmt2.setString(3, attraction_dto.getFboard_attraction_time());
		pstmt2.setString(4, attraction_dto.getFboard_attraction_price());
		pstmt2.setString(5, attraction_dto.getFboard_attraction_home_page());
		pstmt2.setString(6, attraction_dto.getFboard_attraction_go());
		pstmt2.setString(7, attraction_dto.getFboard_attraction_content());
		pstmt2.setInt(8, fboard_num);
		int n3=0;
		if(image_dto.getFboard_attraction_image_name()!=null){
			pstmt3=conn.prepareStatement("update tb_fboard_attraction_image set fboard_attraction_image_name=? where fboard_attraction_num=?");
			pstmt3.setString(1, image_dto.getFboard_attraction_image_name());
			pstmt3.setInt(2, detail_num);
			n3=pstmt3.executeUpdate();
		}else{
			n3=1;
		}
		int n1=pstmt1.executeUpdate();
		int n2=pstmt2.executeUpdate();
		int n=0;
		if(n1>0&&n2>0&&n3>0){
			n=1;
			conn.commit();
		}else{
			conn.rollback();
		}
		return n;
	}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//맛집
	public int update_restaurant(FboardDTO fboard_dto ,FboardRestaurantDTO restaurant_dto,FboardRestaurantImageDTO image_dto,int fboard_num,int detail_num){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("update tb_fboard set fboard_area=?, fboard_city=?, fboard_category=? where fboard_num=?");
			pstmt1.setString(1, fboard_dto.getFboard_area());
			pstmt1.setString(2, fboard_dto.getFboard_city());
			pstmt1.setString(3, fboard_dto.getFboard_category());
			pstmt1.setInt(4, fboard_num);
			pstmt2=conn.prepareStatement("update tb_fboard_restaurant set fboard_restaurant_title=?,"
					+ "fboard_restaurant_sub_title=?, fboard_restaurant_time=?,"
					+ "fboard_restaurant_price=?,fboard_restaurant_home_page=?,"
					+ "fboard_restaurant_go=?, fboard_restaurant_content=? where fboard_num=?");
			pstmt2.setString(1, restaurant_dto.getFboard_restaurant_title());
			pstmt2.setString(2, restaurant_dto.getFboard_restaurant_sub_title());
			pstmt2.setString(3, restaurant_dto.getFboard_restaurant_time());
			pstmt2.setString(4, restaurant_dto.getFboard_restaurant_price());
			pstmt2.setString(5, restaurant_dto.getFboard_restaurant_home_page());
			pstmt2.setString(6, restaurant_dto.getFboard_restaurant_go());
			pstmt2.setString(7, restaurant_dto.getFboard_restaurant_content());
			pstmt2.setInt(8, fboard_num);
			int n3=0;
			if(image_dto.getFboard_restaurant_image()!=null){
				pstmt3=conn.prepareStatement("update tb_fboard_restaurant_image set fboard_restaurant_image=? where fboard_restaurant_num=?");
				pstmt3.setString(1, image_dto.getFboard_restaurant_image());
				pstmt3.setInt(2, detail_num);
				n3=pstmt3.executeUpdate();
			}else{
				n3=1;
			}
			int n1=pstmt1.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//축제
	public int update_festival(FboardDTO fboard_dto ,FboardFestivalDTO festival_dto,FboardFestivalImageDTO image_dto,int fboard_num,int detail_num){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("update tb_fboard set fboard_area=?, fboard_city=?, fboard_category=? where fboard_num=?");
			pstmt1.setString(1, fboard_dto.getFboard_area());
			pstmt1.setString(2, fboard_dto.getFboard_city());
			pstmt1.setString(3, fboard_dto.getFboard_category());
			pstmt1.setInt(4, fboard_num);
			pstmt2=conn.prepareStatement("update tb_fboard_festival set fboard_festival_title=?,"
					+ "fboard_festival_sub_title=?, fboard_festival_period=?,"
					+ "fboard_festival_contents=? where fboard_num=?");
			pstmt2.setString(1, festival_dto.getFboard_festival_title());
			pstmt2.setString(2, festival_dto.getFboard_festival_sub_title());
			pstmt2.setString(3, festival_dto.getFboard_festival_period());
			pstmt2.setString(4, festival_dto.getFboard_festival_contents());
			pstmt2.setInt(5, fboard_num);
			int n3=0;
			if(image_dto.getFboard_festival_image_name()!=null){
				pstmt3=conn.prepareStatement("update tb_fboard_festival_image set fboard_festival_image_name=? where fboard_festival_num=?");
				pstmt3.setString(1, image_dto.getFboard_festival_image_name());
				pstmt3.setInt(2, detail_num);
				n3=pstmt3.executeUpdate();
			}else{
				n3=1;
			}
			int n1=pstmt1.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//쇼핑
	public int update_shopping(FboardDTO fboard_dto,FboardShoppingDTO shopping_dto,FboardShoppingImageDTO image_dto,int fboard_num,int detail_num){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("update tb_fboard set fboard_area=?, fboard_city=?, fboard_category=? where fboard_num=?");
			pstmt1.setString(1, fboard_dto.getFboard_area());
			pstmt1.setString(2, fboard_dto.getFboard_city());
			pstmt1.setString(3, fboard_dto.getFboard_category());
			pstmt1.setInt(4, fboard_num);
			pstmt2=conn.prepareStatement("update tb_fboard_shopping set fboard_shopping_title=?,"
					+ "fboard_shopping_sub_title=?,tb_fboard_shopping_time=?,"
					+ "fboard_shopping_home_page=?,fboard_shopping_go=?,"
					+ "fboard_shopping_contents=? where fboard_num=?");
			pstmt2.setString(1, shopping_dto.getFboard_shopping_title());
			pstmt2.setString(2, shopping_dto.getFboard_shopping_sub_title());
			pstmt2.setString(3, shopping_dto.getTb_fboard_shopping_time());
			pstmt2.setString(4, shopping_dto.getFboard_shopping_homepage());
			pstmt2.setString(5, shopping_dto.getFboard_shopping_go());
			pstmt2.setString(6, shopping_dto.getFboard_shopping_contents());
			pstmt2.setInt(7, fboard_num);
			int n3=0;
			if(image_dto.getFboard_shopping_image_name()!=null){
				pstmt3=conn.prepareStatement("update tb_fboard_shopping_image set fboard_shopping_image_name=? where fboard_shopping_num=?");
				pstmt3.setString(1, image_dto.getFboard_shopping_image_name());
				pstmt3.setInt(2, detail_num);
				n3=pstmt3.executeUpdate();
			}else{
				n3=1;
			}
			int n1=pstmt1.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//삭제
	//명소
	public int delete_attraction(String fboard_num,String detail_num){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("delete from tb_fboard where fboard_num=?");
			pstmt2=conn.prepareStatement("delete from tb_fboard_attraction where fboard_num=?");
			pstmt3=conn.prepareStatement("delete from tb_fboard_attraction_image where fboard_attraction_num=?");
			pstmt1.setString(1, fboard_num);
			pstmt2.setString(1, fboard_num);
			pstmt3.setString(1, detail_num);
			int n3=pstmt3.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n1=pstmt1.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	
	//맛집
	public int delete_restaurant(String fboard_num,String detail_num){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("delete from tb_fboard where fboard_num=?");
			pstmt2=conn.prepareStatement("delete from tb_fboard_restaurant where fboard_num=?");
			pstmt3=conn.prepareStatement("delete from tb_fboard_restaurant_image where fboard_restaurant_num=?");
			pstmt1.setString(1, fboard_num);
			pstmt2.setString(1, fboard_num);
			pstmt3.setString(1, detail_num);
			int n3=pstmt3.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n1=pstmt1.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//축제
	public int delete_festival(String fboard_num,String detail_num){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("delete from tb_fboard where fboard_num=?");
			pstmt2=conn.prepareStatement("delete from tb_fboard_festival where fboard_num=?");
			pstmt3=conn.prepareStatement("delete from tb_fboard_festival_image where fboard_festival_num=?");
			pstmt1.setString(1, fboard_num);
			pstmt2.setString(1, fboard_num);
			pstmt3.setString(1, detail_num);
			int n3=pstmt3.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n1=pstmt1.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
	//쇼핑
	public int delete_shopping(String fboard_num,String detail_num){
		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		try{
			conn=DbcpBean.getConn();
			conn.setAutoCommit(false);
			pstmt1=conn.prepareStatement("delete from tb_fboard where fboard_num=?");
			pstmt2=conn.prepareStatement("delete from tb_fboard_shopping where fboard_num=?");
			pstmt3=conn.prepareStatement("delete from tb_fboard_shopping_image where fboard_shopping_num=?");
			pstmt1.setString(1, fboard_num);
			pstmt2.setString(1, fboard_num);
			pstmt3.setString(1, detail_num);
			int n3=pstmt3.executeUpdate();
			int n2=pstmt2.executeUpdate();
			int n1=pstmt1.executeUpdate();
			int n=0;
			if(n1>0&&n2>0&&n3>0){
				n=1;
				conn.commit();
			}else{
				conn.rollback();
			}
			return n;
		}catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally{
			DbcpBean.close(pstmt1, null);
			DbcpBean.close(pstmt2, null);
			DbcpBean.close(pstmt3, conn);
		}
	}
}
