package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbGongguInsertDao;
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

@Service
public class TbGongguInsertService {
	@Autowired private TbGongguInsertDao dao;
	
	public int insert(TbGongguInsertVo vo){
		return dao.insert(vo);
	}
	
	public TbGongguInfoVo detail(String id){
		return dao.detail(id);
	}
	
	public List<TbGongguInfoVo> joinlist(HashMap<String, Object> map){
		return dao.joinlist(map);
	}
	public List<TbGongguInfoVo> buylist(HashMap<String, Object> map){
		return dao.buylist(map);
	}
	
	//공구리스트 카운트(totalRowCount뽑기위해서)
	public int gonggu_info_cnt(HashMap<String, Object> map){
		return dao.gonggu_info_cnt(map);
	}
	//공구구매리스트 카운트(totalRowCount뽑기위해서)
	public int gonggu_buy_info_cnt(HashMap<String, Object> map){
		return dao.gonggu_buy_info_cnt(map);
	}
	
	public TbGongguInfoVo gonggu_detail(int num){
		return dao.gonggu_detail(num);
	}
	
	public int gonggu_buy(TbGongguBuyVo vo){
		return dao.gonggubuy(vo);
	}
	
	//ordering 페이지 정보 띄우기(유저)
	public TbMemberPrivacyVo gonggu_ordering_user_info(String id){
		return dao.gonggu_ordering_user_info(id);
	}
	//ordering 페이지 정보 띄우기(공구)
	public TbGongguInsertVo gonggu_ordering_info(int num){
		return dao.gonggu_ordering_info(num);
	}
	//ordering 페이지 정보 띄우기(이미지)
	public TbGongguImgVo gonggu_ordering_img_info(int num){
		return dao.gonggu_ordering_img_info(num);
	}
	//ordering 구매완료 후 result 페이지에 띄울 정보들
	public TbMemberInfoGongguInfoVo gonggu_ordering_result(int num){
		return dao.gonggu_ordering_result(num);
	}
	
	
	//공구구매시 DB데이터값 -시켜주기
	public int gonggu_buy_cntUpdate(HashMap<String, Object> map){
		return dao.gonggu_buy_cntUpdate(map);
	}
	
	//공구디테일페이지 구매자리스트 가져오기 위한 서비스
	public List<TbGongguBuyVo> buyerlist(int num){
		return dao.buyerlist(num);
	}
	//공구디테일페이지 구매자카운트 서비스
	public int gonggu_buyer_cnt(int num){
		return dao.gonggu_buyer_cnt(num);
	}
	//공구디테일페이지 댓글정보 서비스
	public List<TbGongguReplyVo> gonggu_reply_list(int num){
		return dao.gonggu_reply_list(num);
	}
	//공구디테일 댓글등록 서비스
	public int gonggu_reply_insert(TbGongguReplyVo vo){
		return dao.gonggu_reply_insert(vo);
	}
	//공구디테일페이지 댓글카운트 서비스
	public int gonggu_reply_cnt(int num){
		return dao.gonggu_reply_cnt(num);
	}
	
	//공구리스트전체출력(회원공구)+vo변경(0410)
	public List<TbGongguListValueVo> gonggu_member_list(HashMap<String, Object> map){
		return dao.gonggu_member_list(map);
	}
	//공구리스트출력(카테고리선택후)+vo변경(0410)
	public List<TbGongguListValueVo> gonggu_member_list_category(HashMap<String, Object> map){
		return dao.gonggu_member_list_category(map);
	}
	
	//공구리스트 카테고리 선택 후 출력
	public List<TbGongguInfoVo> gonggu_list_category(String category){
		return dao.gonggu_list_category(category);
	}
	
	//공구리스트 갯수출력
	public int get_member_list_count(HashMap<String, Object> map){
		return dao.get_member_list_count(map);
	}
	//공구리스트 갯수출력(카테고리선택후)
	public int get_member_list_category_count(HashMap<String, Object> map){
		return dao.get_member_list_category_count(map);
	}
	//전체공구베스트뽑기(판매순)
	public List<TbGongguBestListVo> get_gonggu_best(){
		return dao.get_gonggu_best();
	}
	//공구베스트3의 해당 정보를 뽑아오기
	public TbGongguInfoVo get_gonggu_best_info(int num){
		return dao.get_gonggu_best_info(num);
	}
	
	
	//공구권한신청하기
	public int gonggu_upload_request(TbGongguUploadRequestVo vo){
		return dao.gonggu_upload_request(vo);
	}
}
