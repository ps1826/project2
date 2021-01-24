package project.p502.spring.basket.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.p502.spring.basket.Service.BasketService;
import project.p502.spring.basket.VO.BasketVO;

@Controller
public class BasketController {

	@Autowired
	private BasketService basketService;

	@RequestMapping(value = "/basketList", method = RequestMethod.GET)
	public String basketList(BasketVO basketVO, Model model, HttpServletRequest request) {
		
		basketService.basketPriceSum(basketVO);
		
		HttpSession session = request.getSession();
		String m_id = (String) session.getAttribute("m_id"); 
		basketVO.setM_id(m_id);
		
		int page = 1;
		int limit = 10;
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount = basketService.basketListCount(basketVO);
		int maxpage = (int) ((double) listcount / limit + 0.95);
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;

		int endpage = startpage + 10 - 1;
		if (endpage > maxpage) {
			endpage = maxpage;
		}
		int basketsum= 0;
		List<BasketVO> listsum = new ArrayList<BasketVO>();
		listsum = basketService.basketList(page, limit, basketVO);
		for (int i = 0; i < listsum.size(); i++) {
			basketsum = basketsum + Integer.parseInt(listsum.get(i).getPrice_sum());
		}
		
		model.addAttribute("basketList", basketService.basketList(page, limit, basketVO));
		model.addAttribute("basketSumMoney", basketsum);
//		System.out.println(basketService.basketList(page, limit));
		model.addAttribute("page", page);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("listcount", listcount);

		return "./basket/basketList";
	}

	@RequestMapping(value = "/basketDelete", method = RequestMethod.GET)
	public String basketDelete(BasketVO basketVO, Model model) {
		System.out.println("바스켓 컨트롤");
		basketService.basketDelete(basketVO);
		model.addAttribute("delete", 1);
		return "./basket/basketalert";
	}

//	@RequestMapping(value = "/basketAdd", method = RequestMethod.GET)
//	public String basketAdd(BasketVO basketVO) {
//		basketService.basketAdd(basketVO);
//		basketService.basketAdd(productService.productListDetail(productVO.getGoods_num()));
//		return "redirect:http://localhost/basket/productListDetail?goods_num=" + basketVO.getGoods_num() + "&goods_name=" + basketVO.getGoods_name() + "&price =" + basketVO.getPrice() + "&image =" + basketVO.getImage() + "&amount =" + basketVO.getAmount();
//	}

//	@RequestMapping(value = "/basketAdd", method = RequestMethod.POST)
//	public String basketAdd(BasketVO basketVO, Model model) {
//		basketService.basketAdd(basketVO);
//		model.addAttribute("goods_num", basketVO.getGoods_num());
//		//return "redirect:/pdetail?goods_num=" + basketVO.getGoods_num();
//		return "./basket/basketalert";
//	}
	
//	@RequestMapping(value = "/basketSumMoney", method = RequestMethod.POST)
//	public String basketSumMoney(Model model,BasketVO basketVO) {
//		model.addAttribute("basketSumMoney", basketService.basketSumMoney(basketVO));
//		return "./basket/basketList";
//	}
	@RequestMapping(value = "/basketAdd", method = RequestMethod.POST)
	public String basketAdd(BasketVO basketVO) {
		

		int count = basketService.basketListCount(basketVO);

		if (count == 0) {
			basketService.basketAdd(basketVO);
		} else {
			basketService.basketUpdateAmount(basketVO);
		}
		return "redirect:/pdetail?goods_num=" + basketVO.getGoods_num();
	}
}
