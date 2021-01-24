package project.p502.spring.member.Controller;


import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.p502.spring.member.Service.MemberService;
import project.p502.spring.member.VO.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	JavaMailSender mailSender;
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String Login(Model model, MemberVO VO) {

 		VO = memberService.login(VO);
 		
		if(VO.getLogincheck() == 1 || VO.getLogincheck() == 2) {
			model.addAttribute("VO", VO);
		} else if(VO.getLogincheck() == 3){
			model.addAttribute("VO",VO);
			HttpSession session = request.getSession();
			session.setAttribute("m_id", VO.getM_id());
			} 
		return "/member/login/check";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(MemberVO VO, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("m_id");
		String logout = "logout";
		model.addAttribute("logout", logout);
		return "/member/login/check";
	}
	
	@RequestMapping(value = "/adminMember", method = RequestMethod.GET)
	public String adminMember(Model model) {
		System.out.println("어드민 멤버 컨트롤러");
		model.addAttribute("memberlist", memberService.adminmember());
		return "./member/admin/adminpage";
		
	}
	@RequestMapping(value = "/minsert", method = RequestMethod.GET)
	public String insert() {
		return "./member/insert/insert";
		
	}
	
	@RequestMapping(value = "/minsert", method = RequestMethod.POST)
	public String insert(MemberVO memberVO, Model model) {
		memberService.insert(memberVO);
		//return "redirect:/";
		model.addAttribute("join", 1);
		return "./member/login/check";
		
	}
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Model model, MemberVO memberVO, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		String m_id = (String) session.getAttribute("m_id"); 
		memberVO.setM_id(m_id);
		memberVO = memberService.mypage(memberVO.getM_id());
		
		model.addAttribute("mypage", memberService.mypage(memberVO.getM_id()));
		
		return "./member/mypage/mypage";
	}
	@RequestMapping(value = "mmodify", method = RequestMethod.GET)
	public String modify(Model model, MemberVO memberVO) {
		HttpSession session = request.getSession();
		String m_id = (String) session.getAttribute("m_id");
		memberVO.setM_id(m_id);
		memberVO = memberService.mypage(memberVO.getM_id());
		
		model.addAttribute("modify", memberService.mypage(memberVO.getM_id()));
		return "./member/modify/member_modify";
	}
	
	@RequestMapping(value = "mmodify", method = RequestMethod.POST)
	public String update(Model model, MemberVO memberVO, RedirectAttributes attri) throws Exception {
		HttpSession session = request.getSession();
		String m_id = (String) session.getAttribute("m_id"); 
		memberVO.setM_id(m_id);
		//memberVO = memberService.mypage(memberVO.getM_id());
//		System.out.println("들어갔나");
//		model.addAttribute("modify", memberService.mypage(memberVO.getM_id()));
		attri.addFlashAttribute("modify", memberService.mypage(memberVO.getM_id()));
//		System.out.println("회원수정" + memberVO);
		
		memberService.modify(memberVO);
		return "redirect:/mypage";
		
	}
	
	@RequestMapping(value = "/mdelete", method = RequestMethod.GET)
	public String delete() {
		return "./member/delete/delete";
	}
	
	@RequestMapping(value = "/mdelete", method = RequestMethod.POST)
	public String delete(Model model,MemberVO memberVO) {
		HttpSession session = request.getSession();
		String m_id = (String) session.getAttribute("m_id"); 
		System.out.println("m_id ///////" + memberVO.getM_id());
		memberService.delete(m_id);
		int delcheck = 1;
		model.addAttribute("delcheck", delcheck);
		
		return "./member/login/check";
	}
	@RequestMapping(value = "/adminDelete", method = RequestMethod.GET)
	public String admindelete(MemberVO memberVO) {
		memberService.delete(memberVO.getM_id());
		return "redirect:/adminMember";
	}
	@RequestMapping(value = "/emailchmove", method = RequestMethod.GET)
	public String emailcheckpagemove(Model model) {
	String mail = request.getParameter("email");
	model.addAttribute("mail", mail);

    return "./member/insert/emailcheck";
	
	}
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String emailsand(Model model, HttpServletResponse response_email) {
		Random random = new Random();
		int checknum = random.nextInt(4589362) + 49311;
		String setfrom = "502mail.send@gmail.com";
		String tomail = request.getParameter("email");
		String subject = "502쇼핑몰 회원가입 인증메일입니다.";
		String content = 
				System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
	            System.getProperty("line.separator")+
	            "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
	            +System.getProperty("line.separator")+
	            System.getProperty("line.separator")+
	            " 인증번호는 " +checknum+ " 입니다. "
	            +System.getProperty("line.separator")+
	            System.getProperty("line.separator")+
	            "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
	                        
	            try {
	                MimeMessage message = mailSender.createMimeMessage();
	                MimeMessageHelper messageHelper = new MimeMessageHelper(message,true, "UTF-8");
	 
	                messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
	                messageHelper.setTo(tomail); // 받는사람 이메일
	                messageHelper.setSubject(subject); // 메일제목은 생략이 가능하다
	                messageHelper.setText(content); // 메일 내용
	                
	                mailSender.send(message);
	            } catch (Exception e) {
	                System.out.println(e);
	            }
	            System.out.println(tomail);
	            System.out.println(checknum);
	            model.addAttribute("mail", tomail);
	            model.addAttribute("checknum", checknum);

	            return "./member/insert/emailcheck";
	}
	
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public String emailcheck(Model model) {
		String mail = request.getParameter("email");
		String checknumber = request.getParameter("checknum");
		String inputnumber = request.getParameter("inputcheck");
		System.out.println(mail);
		System.out.println(checknumber);
		System.out.println(inputnumber);
		if (checknumber.equals(inputnumber)) {
			model.addAttribute("mail", mail);
			model.addAttribute("mailcheck", true);
			return "./member/insert/emailcheck";
		} else {
			model.addAttribute("mailcheck", false);
			return "./member/insert/emailcheck";
		}

	}
//	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
//	public String id_check(Model model) {
//		String id= request.getParameter("id");
//		System.out.println(id);
//		if (id.equals("")) {
//			model.addAttribute("nullid", 1);
//			return "/member/insert/insert";
//		} else {
//			boolean check_id = memberService.idcheck(id);
//			System.out.println(check_id);
//			model.addAttribute("checkId", id);
//			model.addAttribute("check", check_id);
//			return "/member/insert/insert";
//		}
//	
//	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(Model model) {
		String m_id = request.getParameter("id");
			System.out.println(m_id);
			int data = memberService.idCheck(m_id);
			
			return data;
		
	}
	
}
