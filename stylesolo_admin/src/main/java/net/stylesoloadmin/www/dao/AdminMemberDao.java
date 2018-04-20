package net.stylesoloadmin.www.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.stylesoloadmin.www.vo.AdminMemberVo;

@Repository
public class AdminMemberDao {
	@Resource SqlSession session;
	private final String NAMESPACE="net.stylesoloadmin.www.MemberMapper";
	
	public int insert(AdminMemberVo vo){
		return session.insert(NAMESPACE+".insert",vo);
	}
}
