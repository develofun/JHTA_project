package net.stylesoloadmin.www.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.stylesoloadmin.www.dao.AdminMemberDao;
import net.stylesoloadmin.www.vo.AdminMemberVo;

@Service
public class AdminMemberService {
	@Resource AdminMemberDao dao;
	
	public int insert(AdminMemberVo vo){
		return dao.insert(vo);
	}
}
