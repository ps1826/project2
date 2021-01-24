package project.p502.spring.qna.DAO;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import project.p502.spring.qna.VO.QnaVO;

@Repository
public class QnaDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<QnaVO> list(int startrow) {
		return sqlSessionTemplate.selectList("qselectAll", startrow);
	}
	
	public String numcount() {
		return sqlSessionTemplate.selectOne("qnumcount");
	}
	public void insert(QnaVO VO) {
		sqlSessionTemplate.insert("qadd",VO);
	
	}
	public QnaVO select (int num) {
		return sqlSessionTemplate.selectOne("qselect",num);
	}
	public void update(QnaVO VO) {
		sqlSessionTemplate.update("qupdate",VO);
	}
	public void delete(int num) {
	sqlSessionTemplate.delete("qdelete",num);	
	}
	public int listcount() {
		return sqlSessionTemplate.selectOne("qListCount");
	}
	public void readcount(QnaVO VO) {
		sqlSessionTemplate.update("qreadcount", VO);
	}
	public int searchcount(HashMap<String, Object> valueMap) {

		return sqlSessionTemplate.selectOne("qsearchcount", valueMap);
	}
	public List<QnaVO> searchlist(HashMap<String, Object> valueMap) {
		return sqlSessionTemplate.selectList("qsearchlist", valueMap);
	}

	public void answerup(HashMap<String, Object> valueMap) {
		sqlSessionTemplate.update("qanswer", valueMap);
	}
	public void reply(QnaVO VO) {
		sqlSessionTemplate.insert("qreply", VO);

	}
}
