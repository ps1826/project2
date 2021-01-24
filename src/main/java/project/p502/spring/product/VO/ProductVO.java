package project.p502.spring.product.VO;

import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ProductVO {
	private int goods_num;
	private String goods_name;
	private String price;
	private MultipartFile imagefile;
	private String image;
	private String category;
	private String energy_efcnc;
	private String liter;
	private int read_count;
	private Date write_ate;
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
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEnergy_efcnc() {
		return energy_efcnc;
	}
	public void setEnergy_efcnc(String energy_efcnc) {
		this.energy_efcnc = energy_efcnc;
	}
	public String getLiter() {
		return liter;
	}
	public void setLiter(String liter) {
		this.liter = liter;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public Date getWrite_ate() {
		return write_ate;
	}
	public void setWrite_ate(Date write_ate) {
		this.write_ate = write_ate;
	}
	@Override
	public String toString() {
		return "ProductVO [goods_num=" + goods_num + ", goods_name=" + goods_name + ", price=" + price + ", imagefile="
				+ imagefile + ", image=" + image + ", category=" + category + ", energy_efcnc=" + energy_efcnc
				+ ", liter=" + liter + ", read_count=" + read_count + ", write_ate=" + write_ate + "]";
	}
	
	
}
