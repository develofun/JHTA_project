package net.stylesolo.www.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.stylesolo.www.vo.TbCsNRnumVo;
import net.stylesolo.www.vo.TbCsNoticeVo;

@Repository
public class CsNoticeDao {
		@Autowired
		private SqlSession sqlsession; 
		private final String NAMESPACE="net.stylesolo.www.mybatis.CsNoticeMapper";
		
		public void setSqlsession(SqlSession sqlsession){
			this.sqlsession = sqlsession;
		}
		public List<TbCsNoticeVo> CsNoticeList(HashMap<String, Object> map){
			return sqlsession.selectList(NAMESPACE + ".CsNoticeList",map);
		}
		public List<TbCsNoticeVo> CsNoticehits(HashMap<String, Object> map){
			return sqlsession.selectList(NAMESPACE + ".CsNoticehits",map);
		}
		public int csNoticeCount(HashMap<String, Object> map){
			return sqlsession.selectOne(NAMESPACE + ".csNoticeCount",map);
		}
		public int NoticeHitUpdate(int num){
			return sqlsession.update(NAMESPACE + ".NoticeHitUpdate",num);
		}
		public TbCsNRnumVo csn_get_rnum(HashMap<String, Object> map){
			return sqlsession.selectOne(NAMESPACE + ".csn_get_rnum",map);
		}
		public TbCsNoticeVo csNoticeDetail(HashMap<String, Object> map){
			return sqlsession.selectOne(NAMESPACE + ".csNoticeDetail",map);
		}
		
}
























