package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbItemsetCodeVo;
import net.stylesolo.www.vo.TbItemsetJjimVo;
import net.stylesolo.www.vo.TbShopJjimVo;

@Repository
public class TbShopJjimDao {
	@Autowired private SqlSession session;
	private final String NAMESPACE="net.stylesolo.www.mybatis.ShopJjimMapper";
	
	public List<TbShopJjimVo> jjim_list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE + ".jjim_list", map);
	}
	public int getCount(String id){
		return session.selectOne(NAMESPACE + ".getCount", id);
	}
	public List<TbItemsetCodeVo> itemset_list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE + ".itemset_list", map);
	}
	public int itemset_check(TbItemsetJjimVo vo){
		return session.selectOne(NAMESPACE+".itemset_check", vo);
	}
	public int jjim_del(HashMap<String, Object> map){
		return session.delete(NAMESPACE+".jjim_del", map);
	}
	public int itemset_jjim_del(HashMap<String, Object> map){
		return session.delete(NAMESPACE+".itemset_jjim_del", map);
	}
}
