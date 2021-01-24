package project.p502.spring.basket.VO;

import org.springframework.stereotype.Component;

@Component
public class BasketVO {

	private int basketID;
	private String m_id;
	private int goods_num;
	private String goods_name;
	private String price;
	private String image;
	private String amount;
	private String price_sum;
	public int getBasketID() {
		return basketID;
	}
	public void setBasketID(int basketID) {
		this.basketID = basketID;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPrice_sum() {
		return price_sum;
	}
	public void setPrice_sum(String price_sum) {
		this.price_sum = price_sum;
	}
	@Override
	public String toString() {
		return "basketVO [basketID=" + basketID + ", m_id=" + m_id + ", goods_num=" + goods_num + ", goods_name="
				+ goods_name + ", price=" + price + ", image=" + image + ", amount=" + amount + ", price_sum="
				+ price_sum + "]";
	}
	
}
