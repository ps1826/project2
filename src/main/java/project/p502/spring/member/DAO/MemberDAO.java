package project.p502.spring.member.DAO;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.p502.spring.member.VO.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public MemberVO login(String m_id) {
		try {
			return sqlSessionTemplate.selectOne("login", m_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	public MemberVO mypage(String m_id) {
		return sqlSessionTemplate.selectOne("mselect", m_id);
	}

	@Transactional
	public void insert(MemberVO memberVO) {
		sqlSessionTemplate.insert("minsert", memberVO);
	}
	public void modify(MemberVO memberVO) {
		sqlSessionTemplate.update("mupdate", memberVO);
	}
	
	public void delete(String m_id) {
		System.out.println("바스켓 다오");
		sqlSessionTemplate.delete("mdelete", m_id);
	}
	public  List<MemberVO> adminmember() {
		System.out.println("어드민 멤버 다오");
		return sqlSessionTemplate.selectList("memberall");
	}
	
	public int idCheck(String m_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("m_id", m_id);
		
		return sqlSessionTemplate.selectOne("idCheck", map);
	}

}
