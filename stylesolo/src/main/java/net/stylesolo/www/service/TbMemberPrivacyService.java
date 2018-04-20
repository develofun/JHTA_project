package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.TbMemberPrivacyDao;
import net.stylesolo.www.vo.MemberChangePwdVo;
import net.stylesolo.www.vo.TbMemberOutVo;
import net.stylesolo.www.vo.TbMemberPrivacyVo;

@Service
public class TbMemberPrivacyService {
	@Autowired private TbMemberPrivacyDao dao;
	
//	ȸ�� ���� ���� ����
	public int saveJoiningMemberData(TbMemberPrivacyVo vo) {
		return dao.saveJoiningMemberData(vo);
	}
	
//	�α��� üũ
	public boolean isMember(TbMemberPrivacyVo mvo) {
		TbMemberPrivacyVo vo=dao.isMember(mvo);
		
		boolean result = !vo.getMember_privacy_id().isEmpty() &&
				!vo.getMember_privacy_state().equals("2") &&
				!vo.getMember_privacy_state().equals("0");
		
		return result;
	}
	
//	�α��� ȸ�� ���� ��������
	public TbMemberPrivacyVo callMemberInformation(String id) {
		return dao.callMemberInformation(id);
	}
	
//	���� ã��(���̵�, ��й�ȣ)
	public String lookForAnAccount(TbMemberPrivacyVo mvo) {
		String resultString = dao.lookForAnAccount(mvo);
		if(mvo.getMember_privacy_id() == null ||
				"".equals(mvo.getMember_privacy_id())) {
//			�ƾƵ� ã��
			return resultString;
		}else {
//			�ӽ� ��й�ȣ ����
			String temporaryPasswordForEmailAuth = String.valueOf(UUID.randomUUID()).substring(0, 8);
			mvo.setMember_privacy_pwd(temporaryPasswordForEmailAuth);
			
//			�ӽ� ��й�ȣ ����
			updateTemporaryPassword(mvo);
			
			return temporaryPasswordForEmailAuth;
		}
	}
	
	public int member_point_add(String id){
		return dao.member_point_add(id);
	}

	private void updateTemporaryPassword(TbMemberPrivacyVo mvo) {
		dao.updateMemberData(mvo);
	}
	
	// ���̵�, ��й�ȣ ã�� //
	public TbMemberPrivacyVo member_findId(HashMap<String, Object> map){
		return dao.member_findId(map);
	}
	public TbMemberPrivacyVo member_findPwd(HashMap<String, Object> map){
		return dao.member_findPwd(map);
	}
	//�ѤѤѤѤѤѤѤѤѤѤѤ�//
	
	
	
	
	public TbMemberPrivacyVo idCheck(String id){
		return dao.idCheck(id);
	}
	
	public TbMemberPrivacyVo pwdCheck(HashMap<String, String> map){
		return dao.pwdCheck(map);
	}
	
	
	public TbMemberPrivacyVo checkMember(HashMap<String, Object> map){
		return dao.checkMember(map);
	}
	
	public int update(TbMemberPrivacyVo vo){
		return dao.update(vo);
	}
	
	public int changepwd(MemberChangePwdVo vo){
		return dao.changepwd(vo);
	}
	
	public int memberout_insert(TbMemberOutVo vo){
		return dao.memberout_insert(vo);
	}
	public int memberout_change_state(TbMemberOutVo vo){
		return dao.memberout_change_state(vo);
	}
	public HashMap<String, Object> memberout_prevent_login(HashMap<String, Object> map){
		return dao.memberout_prevent_login(map);
	}
	//���ã�⿡�� ȸ������ Ȯ�� �� �������������� ��������ϱ�
	public int new_change_pwd(HashMap<String, Object> map){
		return dao.new_change_pwd(map);
	}
}
