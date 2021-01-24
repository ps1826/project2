package project.p502.spring.product.Controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import project.p502.spring.product.Service.ProductService;
import project.p502.spring.product.VO.ProductVO;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/plist", method = RequestMethod.GET)
	public String select(Model model, HttpServletRequest request) {
		System.out.println("프로덕트 컨트롤로");
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			}
		int limit = 5;
		int listcount = productService.count();
		System.out.println(listcount);
		int maxpage = (int) ((double) listcount / limit + 0.95); 
		int startpage = (((int) ((double) page / 5 + 0.9)) - 1) * 5 + 1;	
		model.addAttribute("list", productService.select(page));
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);

		return "./product/productlist";
	}
	
	@RequestMapping(value = "/read_count_select", method = RequestMethod.GET)
	public String read_count_select(Model model, HttpServletRequest request) {
		
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			}
		int limit = 5;
		int listcount = productService.count();
		int maxpage = (int) ((double) listcount / limit + 0.95); 
		int startpage = (((int) ((double) page / 5 + 0.9)) - 1) * 5 + 1;
		int startrow = (page - 1) * 5 + 1;
		int endrow = startrow + 4;
		model.addAttribute("list", productService.read_count_select(page, startrow, endrow));
		model.addAttribute("startrow", startrow);
		model.addAttribute("endrow", endrow);
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);

		return "./product/productreadcountlist";
	} 
	
	@RequestMapping(value = "/write_date_select", method = RequestMethod.GET)
	public String write_date_select(Model model, HttpServletRequest request) {
		
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			}
		int limit = 5;
		int listcount = productService.count();
		int maxpage = (int) ((double) listcount / limit + 0.95); 
		int startpage = (((int) ((double) page / 5 + 0.9)) - 1) * 5 + 1;
		int startrow = (page - 1) * 5 + 1;
		int endrow = startrow + 4;
		model.addAttribute("list", productService.write_date_select(page, startrow, endrow));
		model.addAttribute("startrow", startrow);
		model.addAttribute("endrow", endrow);
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);

		return "./product/productwritedatelist";
	}
	
	@RequestMapping(value = "/low_price_select", method = RequestMethod.GET)
	public String low_price_select(Model model, HttpServletRequest request) {
		
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			}
		int limit = 5;
		int listcount = productService.count();
		int maxpage = (int) ((double) listcount / limit + 0.95); 
		int startpage = (((int) ((double) page / 5 + 0.9)) - 1) * 5 + 1;
		int startrow = (page - 1) * 5 + 1;
		int endrow = startrow + 4;
		System.out.println(startrow);
		System.out.println(endrow);
		model.addAttribute("list", productService.low_price_select(page, startrow, endrow));
		model.addAttribute("startrow", startrow);
		model.addAttribute("endrow", endrow);
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);

		return "./product/productlowpricelist";
	}
	
	@RequestMapping(value = "/high_price_select", method = RequestMethod.GET)
	public String high_price_select(Model model, HttpServletRequest request) {
		
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			}
		int limit = 5;
		int listcount = productService.count();
		int maxpage = (int) ((double) listcount / limit + 0.95); 
		int startpage = (((int) ((double) page / 5 + 0.9)) - 1) * 5 + 1;	
		int startrow = (page - 1) * 5 + 1;
		int endrow = startrow + 4;
		model.addAttribute("list", productService.high_price_select(page, startrow, endrow));
		model.addAttribute("startrow", startrow);
		model.addAttribute("endrow", endrow);
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);

		return "./product/producthighpricelist";
	}
	
		
	@RequestMapping(value = "/pinsert", method = RequestMethod.GET)
	public String insert() {
		
		return "./product/productinsert";
	}
	
	@RequestMapping(value = "/pinsert", method = RequestMethod.POST)
	public String insert(ProductVO productVO, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		
		int goods_num = productService.count() + 1;
		productVO.setGoods_num(goods_num);
		
		String image = productVO.getImagefile().getOriginalFilename();
		
		CommonsMultipartFile commons = (CommonsMultipartFile) productVO.getImagefile();
		String savePath = multipartHttpServletRequest.getSession( ).getServletContext( ).getRealPath("./resources/img"); 
		String filePath = savePath + "/" + image;
		File file = new File(filePath);
		commons.transferTo(file);
		productVO.setImage(image);
		
		productService.insert(productVO);
		
		return "redirect:/plist";
	}
	
	@RequestMapping(value = "/pdetail", method = RequestMethod.GET)
	public String detail(Model model, ProductVO productVO) {
		
		productService.read_count(productVO.getGoods_num());
		model.addAttribute("detail", productService.detail(productVO.getGoods_num()));
		
		return "./product/productdetail";
	}
	
	@RequestMapping(value = "/pupdate", method = RequestMethod.GET)
	public String update(Model model, ProductVO productDTO) {
		
		model.addAttribute("update", productService.detail(productDTO.getGoods_num()));
		
		return "./product/productupdate";
	}
	
	@RequestMapping(value = "/pupdate", method = RequestMethod.POST)
	public String update(ProductVO productVO, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		
		if (!productVO.getImagefile().isEmpty()) {
			String image = productVO.getImagefile().getOriginalFilename();
			CommonsMultipartFile commons = (CommonsMultipartFile) productVO.getImagefile();
			String savePath = multipartHttpServletRequest.getSession( ).getServletContext( ).getRealPath("./resources/img"); 
			String filePath = savePath + "/" + image;
			File file = new File(filePath);
			commons.transferTo(file);
			productVO.setImage(image);
			
		}

		productService.update(productVO);
		
		return "redirect:/pdetail?goods_num=" + productVO.getGoods_num();
	}
	
	@RequestMapping(value = "/pdelete", method = RequestMethod.GET)
	public String update(ProductVO productVO) {
		
		productService.delete(productVO.getGoods_num());
		
		return "redirect:/plist";
	}
	
	@RequestMapping(value = "/psearch", method = RequestMethod.POST)
	public String search(Model model, HttpServletRequest request) {
		
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			}
		int limit = 5;
		String keyword = request.getParameter("keyword");
		int listcount = productService.searchcount(keyword);
		int maxpage = (int) ((double) listcount / limit + 0.95); 
		int startpage = (((int) ((double) page / 5 + 0.9)) - 1) * 5 + 1;
	
		model.addAttribute("search", productService.search(page, keyword));
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);
		
		return "./product/productsearch";
	}
	
	@RequestMapping(value = "/psearch", method = RequestMethod.GET)
	public String searchpage(Model model, HttpServletRequest request) {
		
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			}
		int limit = 5;
		String keyword = request.getParameter("keyword");
		int listcount = productService.searchcount(keyword);
		int maxpage = (int) ((double) listcount / limit + 0.95); 
		int startpage = (((int) ((double) page / 5 + 0.9)) - 1) * 5 + 1;
	
		model.addAttribute("search", productService.search(page, keyword));
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);
		
		return "./product/productsearch";
	}
}
