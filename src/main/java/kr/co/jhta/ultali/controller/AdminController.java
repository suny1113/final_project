package kr.co.jhta.ultali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.ultali.service.AdminReportService;

@Controller
public class AdminController {
	
	@Autowired
	AdminReportService adminReportService;
	
	@RequestMapping("admin/home")
	public String main() {
		return "redirect:/home";
	}
	
	@RequestMapping("admin/reportList")
	public String reportList(Model model) {
		model.addAttribute("dto", adminReportService.selectAllReportService());
		return "admin/reportList";
	}
	
	@RequestMapping("admin/admin/reportList")
	public String reportList2() {
		return "redirect:/admin/reportList";
	}
	
	@RequestMapping("admin/reportDetail")
	public String reportDetail(@RequestParam("rep_no")int rep_no, Model model) {
		model.addAttribute("dto", adminReportService.selectOneReportService(rep_no));
		return "admin/reportDetail";
	}
	
	@RequestMapping("admin/moveToDetail")
	public String moveToDetail(@RequestParam("dto")int c_no, Model model) {
		// 게시판 글 1개 조회 model.add코드 추가
		return "board/BoardDetail";
	}
	
	@RequestMapping("admin/meetingDelete")
	public String meetingDelete(@RequestParam("c_no")int c_no, @RequestParam("rep_no")int rep_no) {
	
		//신고내역 게시판에서 삭제
		adminReportService.DeleteOne(rep_no);
		
		//실제 게시판에서 삭제
		//게시판 글 삭제 서비스 사용 
		
		return "redirect:admin/reportList";
	}
	
	@RequestMapping("admin/Inquire")
	public String Inquire() {
		return "admin/manageInquire";
	}
	
}
