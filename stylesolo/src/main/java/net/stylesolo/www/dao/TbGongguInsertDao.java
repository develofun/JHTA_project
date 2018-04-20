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
	
	
	//�������Ÿ���Ʈī��Ʈ(totalRowCount�̱����ؼ�)
	public int gonggu_buy_info_cnt(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".gonggu_buy_info_cnt",map);
	}
	//������ϸ���Ʈī��Ʈ(totalRowCount�̱����ؼ�)
	public int gonggu_info_cnt(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".gonggu_info_cnt",map);
	}
	//������ϸ���Ʈ���(+����¡ó��)
	public List<TbGongguInfoVo> joinlist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".gonggu_info",map);
	}
	//�������Ÿ���Ʈ���(+����¡ó��)
	public List<TbGongguInfoVo> buylist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".gonggu_buy_info",map);
	}
	
	
	public TbGongguInfoVo gonggu_detail(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_detail",num);
	}
	
	public int gonggubuy(TbGongguBuyVo vo){
		return sqlSession.insert(NAMESPACE+".gonggu_buy",vo);
	}
	
	
	//ordering ���������� ����(����)
	public TbMemberPrivacyVo gonggu_ordering_user_info(String id){
		return sqlSession.selectOne(NAMESPACE+".gonggu_ordering_user_info",id);
	}
	//ordering ���������� ����(����)
	public TbGongguInsertVo gonggu_ordering_info(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_ordering_info",num);
	}
	//ordering ���������� ����(�̹���)
	public TbGongguImgVo gonggu_ordering_img_info(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_ordering_img_info",num);
	}
	//ordering ���ſϷ� �� result�������� ������ ������
	public TbMemberInfoGongguInfoVo gonggu_ordering_result(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_ordering_result",num);
	}
	
	
	//�������Ž� DB�����Ͱ�-�����ֱ�
	public int gonggu_buy_cntUpdate(HashMap<String, Object> map){
		return sqlSession.update(NAMESPACE+".gonggu_buy_cntUpdate",map);
	}
	
	//�������������������� �����ڸ���Ʈ �������� ���� dao
	public List<TbGongguBuyVo> buyerlist(int num){
		return sqlSession.selectList(NAMESPACE+".gonggu_buy_list",num);
	}
	//���������������� ������ī��Ʈ dao
	public int gonggu_buyer_cnt(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_buyer_cnt",num);
	}
	//���������������� �ش���������� �� ��۸���Ʈ dao
	public List<TbGongguReplyVo> gonggu_reply_list(int num){
		return sqlSession.selectList(NAMESPACE+".gonggu_reply_list",num);
	}
	//���������������� ��� ���
	public int gonggu_reply_insert(TbGongguReplyVo vo){
		return sqlSession.insert(NAMESPACE+".gonggu_reply_insert",vo);
	}
	//���������������� ���ī��Ʈ dao
	public int gonggu_reply_cnt(int num){
		return sqlSession.selectOne(NAMESPACE+".gonggu_reply_cnt",num);
	}
	
	//��������Ʈ��ü���(ȸ������)+vo����(0410)
	public List<TbGongguListValueVo> gonggu_member_list(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".gonggu_member_list",map);
	}
	//��������Ʈ���(ī�װ���)0406����+vo����(0410)
	public List<TbGongguListValueVo> gonggu_member_list_category(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".gonggu_member_list_category",map);
	}
	
	//��������Ʈī�װ�������ϱ�(ȸ���������������� ī�װ����ý�)
	public List<TbGongguInfoVo> gonggu_list_category(String category){
		return sqlSession.selectList(NAMESPACE+".gonggu_list_category",category);
	}
	
	//��������Ʈ����
	public int get_member_list_count(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".get_member_list_count",map);
	}
	//��������Ʈ����(ī�װ�������)
	public int get_member_list_category_count(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+".get_member_list_category_count",map);
	}
	
	//��ü��������Ʈ���� ����Ʈ3 �̱�(�Ǹż�)
	public List<TbGongguBestListVo> get_gonggu_best(){
		return sqlSession.selectList(NAMESPACE+".get_gonggu_best");
	}
	//����Ʈ3�� �ش��ϴ� �������� �̱�
	public TbGongguInfoVo get_gonggu_best_info(int num){
		return sqlSession.selectOne(NAMESPACE+".get_gonggu_best_info",num);
	}
	
	
	//�������ѽ�û�ϱ�
	public int gonggu_upload_request(TbGongguUploadRequestVo vo){
		return sqlSession.insert(NAMESPACE+".gonggu_upload_request",vo);
	}
}
