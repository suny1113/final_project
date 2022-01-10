package kr.co.jhta.ultali.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.jhta.ultali.dto.CNoStartEnd;
import kr.co.jhta.ultali.dto.InquirePageUtil;
import kr.co.jhta.ultali.dto.MyClubDto;
import kr.co.jhta.ultali.dto.PageUtil;
import kr.co.jhta.ultali.service.CreatedClubServiceInter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class CreatedClubController {
	
	@Autowired
	CreatedClubServiceInter createdClubServiceInter;
	
	public void setCreatedClubServiceInter(CreatedClubServiceInter createdClubServiceInter) {
		this.createdClubServiceInter = createdClubServiceInter;
	}
	
	@RequestMapping("myPage/createdClub")
	public ModelAndView createdClub(HttpSession session) {
		log.info("controller 도달");
		return new ModelAndView("myPage/createdClub","showClubList",createdClubServiceInter.showClubList((String)session.getAttribute("id")));
	}
	
	
//	@RequestMapping("myPage/applicant")
//	public ModelAndView applicant(@ModelAttribute("c_no") int c_no,@RequestParam(name="currentPage",defaultValue = "1")int currentPage,Model model,HttpSession session) {
//		
//		// 여기 안에 선언을 해도 다시 불러오면 0 값이 되어버려서
//		session.setAttribute("c_no", c_no);
//		int totalPage = createdClubServiceInter.applicantTotalPage(c_no);
//		int countPerPage = 4;
//		
//		// 다시 여기부터
//		Map<String, Object> map  = InquirePageUtil.getPageData(totalPage, countPerPage, currentPage);
//		model.addAttribute("map", map);
//		
//		int startNo = (int)map.get("startNo");
//		int endNo = (int)map.get("endNo");
//		System.out.println(startNo);
//		System.out.println(endNo);
//		
//		return new ModelAndView("myPage/applicantList","showAppList",createdClubServiceInter.showAppList(c_no, startNo,endNo));
//	}
	
	// 버전 3
	@RequestMapping("myPage/applicantList")
	public ModelAndView applicantList(@ModelAttribute("c_no") int c_no, HttpSession session, @RequestParam(name="currentPage",defaultValue = "1")int currentPage,Model model) {
		
		model.addAttribute("c_no",c_no);
		int totalPage = createdClubServiceInter.applicantTotalPage(c_no);
		int countPerPage = 4;

		Map<String, Object> map  = InquirePageUtil.getPageData(totalPage, countPerPage, currentPage);
		model.addAttribute("map", map);
		
		int startNo = (int)map.get("startNo");
		int endNo = (int)map.get("endNo");
		
		return new ModelAndView("myPage/applicantList","showAppList",createdClubServiceInter.showAppList(c_no, startNo,endNo));
	}
	
	// 버전2
//	@RequestMapping("applicantList")
//	public ModelAndView applicantList(HttpSession session) {
//		System.out.println(session.getAttribute("mem_id"));
//		return new ModelAndView("myPage/applicantList","showAppList",createdClubServiceInter.showAppList((String)session.getAttribute("mem_id")));
//	}
	
	@RequestMapping("myPage/approveApp")
	public String approveApp(@ModelAttribute("app_no")int app_no, @ModelAttribute("myclub")MyClubDto myclub) {
		createdClubServiceInter.applyApp(app_no);
		createdClubServiceInter.insertMyClub(myclub);
		return "redirect:applicantList";
	}
	
	// wishList
	@RequestMapping("myPage/wishList")
	public ModelAndView showWish(HttpSession session) {
		System.out.println("wishList"+session.getAttribute("id"));
		log.info("controller 도달");
		return new ModelAndView("myPage/wishList","showClubList",createdClubServiceInter.showWishList((String)session.getAttribute("id")));
	}
	
}
