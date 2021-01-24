package project.p502.spring.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.p502.spring.product.DAO.ProductDAO;
import project.p502.spring.product.VO.ProductVO;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;
	
	public void insert(ProductVO productVO) {
		productDAO.insert(productVO);
	}
	
	public List<ProductVO> select(int page) {
		System.out.println("프로덕트 서비스");
		return productDAO.select(page);
	}
	
	public List<ProductVO> read_count_select(int page, int startrow, int endrow) {
		return productDAO.read_count_select(page, startrow, endrow);
	}
	
	public List<ProductVO> write_date_select(int page, int startrow, int endrow) {
		return productDAO.write_date_select(page, startrow, endrow);
	}
	
	public List<ProductVO> low_price_select(int page, int startrow, int endrow) {
		return productDAO.low_price_select(page, startrow, endrow);
	}
	
	public List<ProductVO> high_price_select(int page, int startrow, int endrow) {
		return productDAO.high_price_select(page, startrow, endrow);
	}
	
	public int count() {
		return productDAO.count();
	}
	
	public ProductVO detail(int goods_num) {
		return productDAO.detail(goods_num);
	}
	
	public void read_count(int goods_num) {
		productDAO.read_count(goods_num);
	}
	
	public void update(ProductVO productVO) {
		productDAO.update(productVO);
	}
	
	public void delete(int goods_num) {
		productDAO.delete(goods_num);
	}
	
	public List<ProductVO> search(int page, String keyword) {
		return productDAO.search(page, keyword);
	}
	
	public int searchcount(String keyword) {
		return productDAO.searchcount(keyword);
	}
}
