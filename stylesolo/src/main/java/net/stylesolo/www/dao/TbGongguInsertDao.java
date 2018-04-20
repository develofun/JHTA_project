package net.stylesolo.www.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbGongguBestListVo;
import net.stylesolo.www.vo.TbGongguBuyVo;
import net.stylesolo.www.vo.TbGongguImgVo;
import net.stylesolo.www.vo.TbGongguInfoVo;
import net.stylesolo.www.vo.TbGongguInsertVo;
import net.stylesolo.www.vo.TbGongguListValueVo;
import net.stylesolo.www.vo.TbGongguReplyVo;
import net.stylesolo.www.vo.TbGongguUploadRequestVo;
import net.stylesolo.www.vo.TbMemberInfoGongguInfoVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;

@Repository
public class TbGongguInsertDao {
	@Autowired private SqlSession sqlSession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.GongguInsertMapper";
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(TbGongguInsertVo vo){
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}
	
	public TbGongguInfoVo detail(String id){
		return sqlSession.selectOne(NAMESPACE+".gonggu_info",id);
	}
	
	
	//공구구매리스트카운트(totalRowCount뽑기위해서)
	public int gonggu_buy_info_cnt(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".gonggu_buy_info_cnt",map);
	}
	//공구등록리스트카운트(totalRowCount뽑기위해서)
	public int gonggu_info_cnt(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".gonggu_info_cnt",map);
	}
	//공구등록리스트출력(+페이징처리)
	public List<TbGongguInfoVo> joinlist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".gonggu_info",map);
	}
	//공구구매리스트출력(+페이징처리)
	public List<TbGongguInfoVo> buylist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".gonggu_buy_info",map);
	}
	
	
	public TbGongguInfoVo gonggu_detail(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_detail",num);
	}
	
	public int gonggubuy(TbGongguBuyVo vo){
		return sqlSession.insert(NAMESPACE+".gonggu_buy",vo);
	}
	
	
	//ordering 페이지정보 띄우기(유저)
	public TbMemberPrivacyVo gonggu_ordering_user_info(String id){
		return sqlSession.selectOne(NAMESPACE+".gonggu_ordering_user_info",id);
	}
	//ordering 페이지정보 띄우기(공구)
	public TbGongguInsertVo gonggu_ordering_info(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_ordering_info",num);
	}
	//ordering 페이지정보 띄우기(이미지)
	public TbGongguImgVo gonggu_ordering_img_info(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_ordering_img_info",num);
	}
	//ordering 구매완료 후 result페이지로 가져갈 정보들
	public TbMemberInfoGongguInfoVo gonggu_ordering_result(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_ordering_result",num);
	}
	
	
	//공구구매시 DB데이터값-시켜주기
	public int gonggu_buy_cntUpdate(HashMap<String, Object> map){
		return sqlSession.update(NAMESPACE+".gonggu_buy_cntUpdate",map);
	}
	
	//공구디테일페이지에서 구매자리스트 가져오기 위한 dao
	public List<TbGongguBuyVo> buyerlist(int num){
		return sqlSession.selectList(NAMESPACE+".gonggu_buy_list",num);
	}
	//공구디테일페이지 구매자카운트 dao
	public int gonggu_buyer_cnt(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_buyer_cnt",num);
	}
	//공구디테일페이지 해당공구페이지 내 댓글리스트 dao
	public List<TbGongguReplyVo> gonggu_reply_list(int num){
		return sqlSession.selectList(NAMESPACE+".gonggu_reply_list",num);
	}
	//공구디테일페이지 댓글 등록
	public int gonggu_reply_insert(TbGongguReplyVo vo){
		return sqlSession.insert(NAMESPACE+".gonggu_reply_insert",vo);
	}
	//공구디테일페이지 댓글카운트 dao
	public int gonggu_reply_cnt(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_reply_cnt",num);
	}
	
	//공구리스트전체출력(회원공구)+vo변경(0410)
	public List<TbGongguListValueVo> gonggu_member_list(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".gonggu_member_list",map);
	}
	//공구리스트출력(카테고리별)0406수정+vo변경(0410)
	public List<TbGongguListValueVo> gonggu_member_list_category(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".gonggu_member_list_category",map);
	}
	
	//공구리스트카테고리별출력하기(회원공구페이지에서 카테고리선택시)
	public List<TbGongguInfoVo> gonggu_list_category(String category){
		return sqlSession.selectList(NAMESPACE+".gonggu_list_category",category);
	}
	
	//공구리스트갯수
	public int get_member_list_count(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".get_member_list_count",map);
	}
	//공구리스트갯수(카테고리선택후)
	public int get_member_list_category_count(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".get_member_list_category_count",map);
	}
	
	//전체공구리스트에서 베스트3 뽑기(판매순)
	public List<TbGongguBestListVo> get_gonggu_best(){
		return sqlSession.selectList(NAMESPACE+".get_gonggu_best");
	}
	//베스트3에 해당하는 공구정보 뽑기
	public TbGongguInfoVo get_gonggu_best_info(int num){
		return sqlSession.selectOne(NAMESPACE+".get_gonggu_best_info",num);
	}
	
	
	//공구권한신청하기
	public int gonggu_upload_request(TbGongguUploadRequestVo vo){
		return sqlSession.insert(NAMESPACE+".gonggu_upload_request",vo);
	}
}
