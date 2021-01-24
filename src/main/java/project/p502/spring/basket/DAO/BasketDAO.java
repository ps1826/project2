package project.p502.spring.basket.DAO;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.p502.spring.basket.VO.BasketVO;

@Repository
public class BasketDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

//	페이징 처리, 장바구니 목록
	public List<BasketVO> basketList(HashMap<String, Object> hashMap) {

		return sqlSessionTemplate.selectList("basketList", hashMap);
	}

//	장바구니 상품 삭제
	public void basketDelete(BasketVO basketVO) {
		sqlSessionTemplate.delete("basketDelete", basketVO);
	}

//	장바구니 상품 추가
	public void basketAdd(BasketVO basketVO) {
		sqlSessionTemplate.insert("basketAdd", basketVO);
	}

//	페이징 처리, 행 개수
	public int basketListCount(BasketVO basketVO) {
		return sqlSessionTemplate.selectOne("basketListCount", basketVO);
	}
	
//	public int basketSumMoney(BasketVO basketVO) {
//		return sqlSessionTemplate.selectOne("basketSumMoney", basketVO);
//	}
//	public void basketUpdate(BasketVO basketVO) {
//		sqlSessionTemplate.update("basketupdate", basketVO);
//	}
	public void basketPriceSum(BasketVO basketVO) {
		sqlSessionTemplate.update("basketPriceSum", basketVO);
	}
	
	public void basketUpdateAmount(BasketVO basketVO) {
		sqlSessionTemplate.update("basketUpdateAmount", basketVO);
	}
}
