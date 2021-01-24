package project.p502.spring.qna.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.p502.spring.qna.DAO.QnaDAO;
import project.p502.spring.qna.VO.QnaVO;

@Service
public class QnaService {
@Autowired
private QnaDAO qnaDAO;

private HashMap<String,Object> valueMap = new HashMap<String,Object>(); 


public List<QnaVO> listAll(int page,int limit){
	int startrow =(page-1)*10+1;
	return qnaDAO.list(startrow);
}
public void add(QnaVO VO) {
	String num = qnaDAO.numcount();
	int num1;
	if (num == null) {
		num1 = 1;
	}else {
		num1 = Integer.parseInt(num) + 1;
	}
	VO.setNum(num1);
	System.out.println(num1);
	qnaDAO.insert(VO);
}
public QnaVO select(int num) {
	return qnaDAO.select(num);
}
public void update(QnaVO VO) {
	qnaDAO.update(VO);
	}
public void delete(int num) {
	qnaDAO.delete(num);
}
public int listcount() {
	int listcount = qnaDAO.listcount();
	return listcount;
}
public void readcount(QnaVO VO) {
	qnaDAO.readcount(VO);
}
public int maxpage(int listcount,int limit) {
	int maxpage= (int)((double)listcount/limit+0.95);
	return maxpage;
}
public int startpage(int page) {
	int startpage = (((int)((double) page/10+0.9))-1)*10 +1;
	return startpage;
}
public int endpage(int startpage, int maxpage) {
	int endpage = startpage +10 -1;
	if(endpage > maxpage) {
		endpage = maxpage;
	}
	return endpage;
	}
public int searchcount(String keyword,String keyfield) {
	valueMap.put("keyword", keyword);
	valueMap.put("keyfield", keyfield);
	
	 return qnaDAO.searchcount(valueMap);

}
public List<QnaVO> searchlist(String keyword,String keyfield, int startpage, int endpage, int page){
	int startrow = (page-1)*10+1;
	int endrow = startpage + 10 - 1;
	valueMap.put("keyword", keyword);
	valueMap.put("keyfield", keyfield);
	valueMap.put("startpage", startrow);
	valueMap.put("endpage", endrow);
	
	return qnaDAO.searchlist(valueMap);
	
}
public void reply(QnaVO VO) {
	String num = qnaDAO.numcount();
	int num1;
	if (num == null) {
		num1 = 1;
	}else {
		num1 = Integer.parseInt(num) + 1;
	}
	VO.setNum(num1);
	
	valueMap.put("answer_num", VO.getAnswer_num());
	valueMap.put("answer_seq", VO.getAnswer_seq());
	qnaDAO.answerup(valueMap);
	VO.setAnswer_seq(VO.getAnswer_seq()+1);
	VO.setAnswer_lev(VO.getAnswer_lev()+1);
	qnaDAO.reply(VO);
	
}
}
