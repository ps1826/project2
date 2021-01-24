package project.p502.spring.product.DAO;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.p502.spring.product.VO.ProductVO;

@Repository
public class ProductDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(ProductVO productVO) {
		sqlSessionTemplate.insert("pinsert", productVO);
	}
	
	public List<ProductVO> select(int page) {	
		System.out.println("프로덕트 다오");
		int startrow = (page - 1) * 5 + 1;
		int endrow = startrow + 4;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		
		return sqlSessionTemplate.selectList("pselect", map);
	}
	
public List<ProductVO> read_count_select(int page, int startrow, int endrow) {	
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		
		return sqlSessionTemplate.selectList("read_count_select", map);
	}
	
	public List<ProductVO> write_date_select(int page, int startrow, int endrow) {			
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		
		return sqlSessionTemplate.selectList("write_date_select", map);
	}
	
	public List<ProductVO> low_price_select(int page, int startrow, int endrow) {	

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		
		return sqlSessionTemplate.selectList("low_price_select", map);
	}
	
	public List<ProductVO> high_price_select(int page,int startrow, int endrow) {	
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		
		return sqlSessionTemplate.selectList("high_price_select", map);
	}
	
	public int count() {
		return sqlSessionTemplate.selectOne("pcount");
	}
	
	public ProductVO detail(int goods_num) {	
		return sqlSessionTemplate.selectOne("pdetail", goods_num);
	}
	
	public void read_count(int goods_num) {
		sqlSessionTemplate.update("pread_count", goods_num);
	}
	
	public void update(ProductVO productVO) {
		sqlSessionTemplate.update("pupdate", productVO);
	}
	
	public void delete(int goods_num) {
		sqlSessionTemplate.delete("pdelete", goods_num);
	}
	
	public List<ProductVO> search(int page, String keyword) {

		int startrow = (page - 1) * 5 + 1;
		int endrow = startrow + 4;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		map.put("keyword", keyword);
		
		return sqlSessionTemplate.selectList("psearch", map);
	}
	
	public int searchcount(String keyword) {
		
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("keyword", keyword);
		return sqlSessionTemplate.selectOne("psearchcount", keyword);
	}

}
