package project.p502.spring.qna.Controller;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import project.p502.spring.qna.Service.QnaService;
import project.p502.spring.qna.VO.QnaVO;

@Controller
public class QnaController {
@Autowired
private QnaService qnaService;


private int page = 1;
private int limit = 10;
@RequestMapping(value = "/qlistAll")
public String listAll(Model model,HttpServletRequest request) {
	if (request.getParameter("page")!=null) {
		page=Integer.parseInt(request.getParameter("page"));
	}
	int listcount = qnaService.listcount();
	int maxpage = qnaService.maxpage(listcount,limit);
	int startpage= qnaService.startpage(page);
	int endpage = qnaService.endpage(startpage,maxpage);
	
	model.addAttribute("page",page);
	model.addAttribute("maxpage", maxpage);
	model.addAttribute("startpage", startpage);
	model.addAttribute("endpage", endpage);
	model.addAttribute("listcount", listcount);
	model.addAttribute("list", qnaService.listAll(page, limit));
	return "./qna/qnalist/list";
}
@RequestMapping(value = "/qinsert", method = RequestMethod.GET)
public String add() {
	return "./qna/qnainsert/insert";
}
@RequestMapping(value = "/qinsert", method = RequestMethod.POST)
public String add(QnaVO VO ,MultipartHttpServletRequest request)throws Exception{
	if(!VO.getFilename().isEmpty()) {
		String fileName = VO.getFilename().getOriginalFilename();
		CommonsMultipartFile commons = (CommonsMultipartFile) VO.getFilename();
		System.out.println(fileName);
		String savePath = request.getSession().getServletContext().getRealPath("./resources/upload");
		String filePath=savePath + "\\" + fileName;
		File file = new File(filePath);
		commons.transferTo(file);
		VO.setAttached_file(fileName);
		}
	System.out.println(VO);
		qnaService.add(VO);
		
		return "redirect:http://localhost:8088/spring/qlistAll";
	}
@RequestMapping(value = "/qselect", method = RequestMethod.GET)
public String select(Model model,QnaVO VO) {
	qnaService.readcount(VO);
	model.addAttribute("view" , qnaService.select(VO.getNum()));
	return "./qna/qnaview/view";
}
@RequestMapping(value = "/down", method = RequestMethod.GET)
public String down(@RequestParam(value = "attached_file", required = true) String attached_file, HttpServletResponse response) throws Exception {
	attached_file = URLEncoder.encode(attached_file, "UTF-8").replaceAll("\\+", "%20");
	System.out.println(attached_file);
	response.setContentType("application/octet-stream");
	return "redirect:/resources/upload/"+attached_file;
}
@RequestMapping(value = "/qupdate", method = RequestMethod.GET)
public String Update(Model model,  QnaVO VO) {
	model.addAttribute("olddate", qnaService.select(VO.getNum()));
	return "/qna/qnaupdate/update";
}
@RequestMapping(value = "/qupdate", method = RequestMethod.POST)
public String Update(QnaVO VO, MultipartHttpServletRequest request, Model model) throws Exception {
	HttpSession session = request.getSession();
	if(VO.getM_id().equals(session.getAttribute("m_id")) || session.getAttribute("m_id").equals("admin")) {
	if(!VO.getFilename().isEmpty()) {
	String fileName = VO.getFilename().getOriginalFilename();
	CommonsMultipartFile commons = (CommonsMultipartFile) VO.getFilename();
	System.out.println(fileName);
	String savePath = request.getSession().getServletContext().getRealPath("./resources/upload");
	String filePath=savePath + "\\" + fileName;
	File file = new File(filePath);
	commons.transferTo(file);
	VO.setAttached_file(fileName);
	}
	qnaService.update(VO);
	return "redirect:http://localhost:8088/spring/qlistAll";
	} else {
		model.addAttribute("updateidchelck", false);
	return "./qna/qnacheck/qnacheck";
	}
	
}
@RequestMapping(value = "/qsearch")
public String search(Model model, HttpServletRequest request) {
	String keyword= request.getParameter("keyword");
	String keyfield = request.getParameter("keyfield");
	int searchlistcount = qnaService.searchcount(keyword, keyfield);
	page=1;
	limit=10;
	if(request.getParameter("page") != null) {
		page=Integer.parseInt(request.getParameter("page"));
	}
	
	int maxpage = qnaService.maxpage(searchlistcount , limit);
	int startpage = qnaService.startpage(page);
	int endpage = qnaService.endpage(startpage, maxpage);
	
	System.out.println(keyfield);
	System.out.println(keyword);
	
	model.addAttribute("page",page);
	model.addAttribute("maxpage", maxpage);
	model.addAttribute("startpage", startpage);
	model.addAttribute("endpage", endpage);
	model.addAttribute("searchlistcount", searchlistcount);
	model.addAttribute("searchlist", qnaService.searchlist(keyword, keyfield, startpage, endpage, page));
	return "./qna/qnasearch/searchlist";
}
@RequestMapping(value = "/qdelete", method = RequestMethod.GET)
public String delete(QnaVO VO, HttpServletRequest request, Model model) {
	VO =qnaService.select(VO.getNum());
	System.out.println("딜리트 VO"+ VO);
	
	HttpSession session = request.getSession();
	if(VO.getM_id().equals(session.getAttribute("m_id")) || session.getAttribute("m_id").equals("admin")) {
	qnaService.delete(VO.getNum());
	return "redirect:http://localhost:8088/spring/qlistAll";
	} else {
	model.addAttribute("deleteidchelck", false);
	return "./qna/qnacheck/qnacheck";
	}
	
}
@RequestMapping(value = "/qreply", method = RequestMethod.GET)
public String replymove(Model model, QnaVO VO ) {
	model.addAttribute("reply" , qnaService.select(VO.getNum()));
	return "./qna/qnareply/reply";
}
@RequestMapping(value = "/qreply", method = RequestMethod.POST)
public String reply(QnaVO VO, MultipartHttpServletRequest request) throws Exception {
	if(!VO.getFilename().isEmpty()) {
	String fileName = VO.getFilename().getOriginalFilename();
	CommonsMultipartFile commons = (CommonsMultipartFile) VO.getFilename();
	System.out.println(fileName);
	String savePath = request.getSession().getServletContext().getRealPath("./resources/upload");
	String filePath=savePath + "\\" + fileName;
	File file = new File(filePath);
	commons.transferTo(file);
	VO.setAttached_file(fileName);
	}
	System.out.println("리플 컨트롤러");
	System.out.println(VO);
	qnaService.reply(VO);
	return "redirect:http://localhost:8088/spring/qlistAll";
}


}