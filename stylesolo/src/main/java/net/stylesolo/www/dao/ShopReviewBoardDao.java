package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.ShopQnaBoardVo;
import net.stylesolo.www.vo.ShopReviewBoardVo;
import net.stylesolo.www.vo.ShopReviewFileVo;

@Repository
public class ShopReviewBoardDao {
	@Autowired private SqlSession session;
	private String NAMESPACE="net.stylesolo.www.mybatis.ShopReviewMapper";
	
	public List<ShopReviewBoardVo> viewList(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".viewList", map);
	}
	
	public List<ShopReviewBoardVo> pagingList(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".pagingList", map);
	}
	
	public List<ShopQnaBoardVo> qnaViewList(int item_code){
		return session.selectList(NAMESPACE+".qnaViewList", item_code);
	}
	/*
	public List<ShopQnaBoardVo> qnaPagingList(HashMap<String, Integer> map){
		return session.selectList(NAMESPACE+".qnaPagingList", map);
	}
	*/
	public int rgetRowCount(int code){
		return session.selectOne(NAMESPACE+".rgetCountRow",code);
	}
	public int qgetRowCount(HashMap<String, Object> map){
		return session.selectOne(NAMESPACE+".qgetCountRow",map);
	}
	public int getRowCount(HashMap<String, Object> map){
		return session.selectOne(NAMESPACE+".getRowCount", map);
	}
	
	public ShopReviewBoardVo re_desc(int num){
		return session.selectOne(NAMESPACE+".re_desc", num);
	}
	public List<ShopQnaBoardVo> qnalist(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".qnalist", map);
	}
	public int insert_review(ShopReviewBoardVo vo){
		return session.insert(NAMESPACE+".insert_review", vo);
	}
	public int reviewFileUp(ShopReviewFileVo vo){
		return session.insert(NAMESPACE+".reviewFileUp",vo);
	}
	public int addHit(int num){
		return session.update(NAMESPACE+".addHit",num);
	}
	public int insert_qna(ShopQnaBoardVo vo){
		return session.insert(NAMESPACE+".insert_qna", vo);
	}

}
