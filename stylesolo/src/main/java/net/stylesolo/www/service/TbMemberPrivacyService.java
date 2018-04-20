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
	
//	회원 가입 정보 저장
	public int saveJoiningMemberData(TbMemberPrivacyVo vo) {
		return dao.saveJoiningMemberData(vo);
	}
	
//	로그인 체크
	public boolean isMember(TbMemberPrivacyVo mvo) {
		TbMemberPrivacyVo vo=dao.isMember(mvo);
		
		boolean result = !vo.getMember_privacy_id().isEmpty() &&
				!vo.getMember_privacy_state().equals("2") &&
				!vo.getMember_privacy_state().equals("0");
		
		return result;
	}
	
//	로그인 회원 정보 가져오기
	public TbMemberPrivacyVo callMemberInformation(String id) {
		return dao.callMemberInformation(id);
	}
	
//	계정 찾기(아이디, 비밀번호)
	public String lookForAnAccount(TbMemberPrivacyVo mvo) {
		String resultString = dao.lookForAnAccount(mvo);
		if(mvo.getMember_privacy_id() == null ||
				"".equals(mvo.getMember_privacy_id())) {
//			아아디 찾기
			return resultString;
		}else {
//			임시 비밀번호 생성
			String temporaryPasswordForEmailAuth = String.valueOf(UUID.randomUUID()).substring(0, 8);
			mvo.setMember_privacy_pwd(temporaryPasswordForEmailAuth);
			
//			임시 비밀번호 저장
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
	
	// 아이디, 비밀번호 찾기 //
	public TbMemberPrivacyVo member_findId(HashMap<String, Object> map){
		return dao.member_findId(map);
	}
	public TbMemberPrivacyVo member_findPwd(HashMap<String, Object> map){
		return dao.member_findPwd(map);
	}
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
	
	
	
	
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
	//비번찾기에서 회원유무 확인 후 변경페이지에서 비번변경하기
	public int new_change_pwd(HashMap<String, Object> map){
		return dao.new_change_pwd(map);
	}
}
