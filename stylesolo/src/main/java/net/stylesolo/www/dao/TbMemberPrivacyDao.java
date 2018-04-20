package net.stylesolo.www.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.MemberChangePwdVo;
import net.stylesolo.www.vo.TbMemberOutVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;

@Repository
public class TbMemberPrivacyDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="net.stylesolo.www.mybatis.MemberPrivacyMapper.";
	
//	ȸ�� ���� ���� ����
	public int saveJoiningMemberData(TbMemberPrivacyVo vo) {
		return sqlSession.insert(NAMESPACE + "insert", vo);
	}
	
//	�α��� üũ
	public TbMemberPrivacyVo isMember(TbMemberPrivacyVo mvo) {
		return sqlSession.selectOne(NAMESPACE + "isMember", mvo);
	}
	
//	�α��� ȸ�� ���� ��������
	public TbMemberPrivacyVo callMemberInformation(String id) {
		return sqlSession.selectOne(NAMESPACE + "callMemberInformation",id);
	}
	
//	���� ã��(���̵�, ��й�ȣ)
	public String lookForAnAccount(TbMemberPrivacyVo mvo) {
		TbMemberPrivacyVo resultVo = sqlSession.selectOne(NAMESPACE + "lookForAnAccount", mvo);
		
		if(mvo.getMember_privacy_id() == null ||
				"".equals(mvo.getMember_privacy_id())) {
			return resultVo.getMember_privacy_id();
		}else {
			return resultVo.getMember_privacy_pwd();
		}
	}
	
	public int member_point_add(String id){
		return sqlSession.update(NAMESPACE+"member_point_add",id);
	}
	
	// ���̵�,��й�ȣ ã�� //
	public TbMemberPrivacyVo member_findId(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+"member_findId",map);
	}
	public TbMemberPrivacyVo member_findPwd(HashMap<String, Object> map){
		return sqlSession.selectOne(NAMESPACE+"member_findPwd",map);
	}
	//////////////////////
	
	public void updateMemberData(TbMemberPrivacyVo mvo) {
		sqlSession.update(NAMESPACE + "updateMemberData", mvo);
	}
	
	
	
	public TbMemberPrivacyVo idCheck(String id){
		return sqlSession.selectOne(NAMESPACE+"idcheck",id);
	}
	
	public TbMemberPrivacyVo pwdCheck(HashMap<String, String> map){
		return sqlSession.selectOne(NAMESPACE+"pwdcheck",map);
	}
	
	public TbMemberPrivacyVo checkMember(HashMap<String,Object> map){
		return sqlSession.selectOne(NAMESPACE+"checkMember",map);
	}
	
	public int update(TbMemberPrivacyVo vo){
		int n=sqlSession.update(NAMESPACE+"update",vo);
		return n;
	}
	
	public int changepwd(MemberChangePwdVo vo){
		int n=sqlSession.update(NAMESPACE+"changepwd",vo);
		return n;
	}
	
	public int memberout_insert(TbMemberOutVo vo){
		return sqlSession.insert(NAMESPACE+"memberout_insert",vo);
	}
	public int memberout_change_state(TbMemberOutVo vo){
		return sqlSession.update(NAMESPACE+"memberout_state_update",vo);
	}
	public HashMap<String,Object> memberout_prevent_login(HashMap<String,Object> map){
		return sqlSession.selectOne(NAMESPACE+"login_memberout",map);
	}
	
	//���ã�⿡�� ȸ������ Ȯ�� �� �������������� ��������ϱ�
	public int new_change_pwd(HashMap<String, Object> map){
		return sqlSession.update(NAMESPACE+"new_change_pwd",map);
	}
}
