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
	
	//��������Ʈ ī��Ʈ(totalRowCount�̱����ؼ�)
	public int gonggu_info_cnt(HashMap<String, Object> map){
		return dao.gonggu_info_cnt(map);
	}
	//�������Ÿ���Ʈ ī��Ʈ(totalRowCount�̱����ؼ�)
	public int gonggu_buy_info_cnt(HashMap<String, Object> map){
		return dao.gonggu_buy_info_cnt(map);
	}
	
	public TbGongguInfoVo gonggu_detail(int num){
		return dao.gonggu_detail(num);
	}
	
	public int gonggu_buy(TbGongguBuyVo vo){
		return dao.gonggubuy(vo);
	}
	
	//ordering ������ ���� ����(����)
	public TbMemberPrivacyVo gonggu_ordering_user_info(String id){
		return dao.gonggu_ordering_user_info(id);
	}
	//ordering ������ ���� ����(����)
	public TbGongguInsertVo gonggu_ordering_info(int num){
		return dao.gonggu_ordering_info(num);
	}
	//ordering ������ ���� ����(�̹���)
	public TbGongguImgVo gonggu_ordering_img_info(int num){
		return dao.gonggu_ordering_img_info(num);
	}
	//ordering ���ſϷ� �� result �������� ��� ������
	public TbMemberInfoGongguInfoVo gonggu_ordering_result(int num){
		return dao.gonggu_ordering_result(num);
	}
	
	
	//�������Ž� DB�����Ͱ� -�����ֱ�
	public int gonggu_buy_cntUpdate(HashMap<String, Object> map){
		return dao.gonggu_buy_cntUpdate(map);
	}
	
	//���������������� �����ڸ���Ʈ �������� ���� ����
	public List<TbGongguBuyVo> buyerlist(int num){
		return dao.buyerlist(num);
	}
	//���������������� ������ī��Ʈ ����
	public int gonggu_buyer_cnt(int num){
		return dao.gonggu_buyer_cnt(num);
	}
	//���������������� ������� ����
	public List<TbGongguReplyVo> gonggu_reply_list(int num){
		return dao.gonggu_reply_list(num);
	}
	//���������� ��۵�� ����
	public int gonggu_reply_insert(TbGongguReplyVo vo){
		return dao.gonggu_reply_insert(vo);
	}
	//���������������� ���ī��Ʈ ����
	public int gonggu_reply_cnt(int num){
		return dao.gonggu_reply_cnt(num);
	}
	
	//��������Ʈ��ü���(ȸ������)+vo����(0410)
	public List<TbGongguListValueVo> gonggu_member_list(HashMap<String, Object> map){
		return dao.gonggu_member_list(map);
	}
	//��������Ʈ���(ī�װ�������)+vo����(0410)
	public List<TbGongguListValueVo> gonggu_member_list_category(HashMap<String, Object> map){
		return dao.gonggu_member_list_category(map);
	}
	
	//��������Ʈ ī�װ� ���� �� ���
	public List<TbGongguInfoVo> gonggu_list_category(String category){
		return dao.gonggu_list_category(category);
	}
	
	//��������Ʈ �������
	public int get_member_list_count(HashMap<String, Object> map){
		return dao.get_member_list_count(map);
	}
	//��������Ʈ �������(ī�װ�������)
	public int get_member_list_category_count(HashMap<String, Object> map){
		return dao.get_member_list_category_count(map);
	}
	//��ü��������Ʈ�̱�(�Ǹż�)
	public List<TbGongguBestListVo> get_gonggu_best(){
		return dao.get_gonggu_best();
	}
	//��������Ʈ3�� �ش� ������ �̾ƿ���
	public TbGongguInfoVo get_gonggu_best_info(int num){
		return dao.get_gonggu_best_info(num);
	}
	
	
	//�������ѽ�û�ϱ�
	public int gonggu_upload_request(TbGongguUploadRequestVo vo){
		return dao.gonggu_upload_request(vo);
	}
}
