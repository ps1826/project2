package project.p502.spring.member.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.p502.spring.member.DAO.MemberDAO;
import project.p502.spring.member.VO.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public MemberVO login(MemberVO VO) {
		System.out.println("----서비스 컨트롤러에서 받은 값-----");
		System.out.println(VO.getM_id());
		System.out.println(VO.getM_password());
		System.out.println("----서비스 DAO 받은 값-----");
		System.out.println(VO);
		
		MemberVO  VO1 = new MemberVO(); 
		VO1 = memberDAO.login(VO.getM_id());
		
		if(VO1 == null) {
			VO.setLogincheck(1);
			return VO;
		} else if(!VO1.getM_password().equals(VO.getM_password())) {
			VO1.setLogincheck(2);
			return VO1;
		}else {
			VO1.setLogincheck(3);
			return VO1;
		}
		
	}
	public MemberVO mypage(String m_id) {
		return memberDAO.mypage(m_id);
	}

	public void insert(MemberVO memberVO) {
		memberDAO.insert(memberVO);
	}
	public void modify(MemberVO memberVO) {
//		System.out.println("서비스1" + memberVO);
		memberDAO.modify(memberVO);
//		System.out.println("서비스2");
	}
		public void delete(String m_id) { 
			memberDAO.delete(m_id); 
	}
		public List<MemberVO> adminmember() {
			System.out.println("어드민 멤버 서비스");
			return memberDAO.adminmember();
	}
//		public boolean  idcheck(String id) {
//			boolean checkid = false;
//			List<MemberVO> memberinfo = new ArrayList<MemberVO>();
//			memberinfo = memberDAO.adminmember();
//			
//			for (int i = 0; i < memberinfo.size(); i++) {
//				if (memberinfo.get(i).getM_id().equals(id)) {
//					checkid=true;
//				}
//			}
//			
//			return checkid;
//	}
		
		public int idCheck(String m_id) {
			return memberDAO.idCheck(m_id);
		}

}
