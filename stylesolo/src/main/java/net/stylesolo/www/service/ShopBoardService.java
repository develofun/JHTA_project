package net.stylesolo.www.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.stylesolo.www.dao.ShopReviewBoardDao;
import net.stylesolo.www.vo.ShopQnaBoardVo;
import net.stylesolo.www.vo.ShopReviewBoardVo;
import net.stylesolo.www.vo.ShopReviewFileVo;

@Service
public class ShopBoardService {
	@Autowired private ShopReviewBoardDao dao;
	public List<ShopReviewBoardVo> viewList(HashMap<String, Object> map){ //첫화면 리뷰게시판글목록
		return dao.viewList(map);
	}
	
	public List<ShopReviewBoardVo> pagingList(HashMap<String, Object> map){ //페이지에 따른 리뷰게시판 글목록
		return dao.pagingList(map);
	}
	
	public int rgetRowCount(int code){
		return dao.rgetRowCount(code);
	}
	public int qgetRowCount(HashMap<String, Object> map){
		return dao.qgetRowCount(map);
	
	}
	public int getRowCount(HashMap<String, Object> map){
		return dao.getRowCount(map);
	}
	
	public ShopReviewBoardVo re_desc(int num){
		return dao.re_desc(num);
	}
	
	public List<ShopQnaBoardVo> qnaList(HashMap<String, Object> map){
		return dao.qnalist(map);
	}
	
	public int insert_review(ShopReviewBoardVo vo){
		return dao.insert_review(vo);
	}
	public int reviewFileUp(ShopReviewFileVo vo){
		return dao.reviewFileUp(vo);
	}
	public int addHit(int num){
		return dao.addHit(num);
	}
	public int insert_qna(ShopQnaBoardVo vo){
		return dao.insert_qna(vo);
	}
}
