package project.p502.spring.basket.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.p502.spring.basket.DAO.BasketDAO;
import project.p502.spring.basket.VO.BasketVO;

@Service
public class BasketService {

	@Autowired
	private BasketDAO basketDAO;

	public List<BasketVO> basketList(int page, int limit, BasketVO basketVO) {

		int startrow = (page - 1) * 10 + 1;
		int endrow = startrow + limit - 1;

		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		hashMap.put("startrow", startrow);
		hashMap.put("endrow", endrow);
		// 김훈영 추가한거 
		hashMap.put("m_id", basketVO.getM_id());

		return basketDAO.basketList(hashMap);
	}

	public void basketDelete(BasketVO basketVO) {
		basketDAO.basketDelete(basketVO);
	}

	public void basketAdd(BasketVO basketVO) {
		basketDAO.basketAdd(basketVO);
//		boolean add = false;
//		int price_sum; 
//		HashMap<String, Object> hashMap = new HashMap<String, Object>();
//		List<BasketVO> list = new ArrayList<BasketVO>();
//		hashMap.put("m_id", basketVO.getM_id());
//		list = basketDAO.basketList(hashMap);
//		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getGoods_num()==basketVO.getGoods_num()) {
//				add = true;
//			}
//		}
//		price_sum = Integer.parseInt(basketVO.getPrice())*Integer.parseInt(basketVO.getAmount());
//		basketVO.setPrice_sum(Integer.toString(price_sum));	
//		System.out.println(basketVO);
//		if(add) {
//			System.out.println("더하기");
//			System.out.println(basketVO);
//			basketDAO.basketUpdate(basketVO);
//		} else {
//			System.out.println("추가");
//			System.out.println(basketVO);
//			basketDAO.basketAdd(basketVO);
//		}
	}

	public int basketListCount(BasketVO basketVO) {
		return basketDAO.basketListCount(basketVO);
	}
	
//	public int basketSumMoney(BasketVO basketVO) {
//		return basketDAO.basketSumMoney(basketVO);
//	}
	public void basketPriceSum(BasketVO basketVO) {
		basketDAO.basketPriceSum(basketVO);
	}
	
	public void basketUpdateAmount(BasketVO basketVO) {
		basketDAO.basketUpdateAmount(basketVO);
	}
}
