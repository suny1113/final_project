package kr.co.jhta.ultali.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.ultali.dao.CreatedClubDaoInter;
import kr.co.jhta.ultali.dto.AppDto;
import kr.co.jhta.ultali.dto.CNoStartEnd;
import kr.co.jhta.ultali.dto.MyClubDto;
import kr.co.jhta.ultali.dto.WishDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreatedClubServiceImple implements CreatedClubServiceInter{

	@Autowired
	CreatedClubDaoInter createdClubDaoInter;
	
	public void setCreatedClubDaoInter(CreatedClubDaoInter createdClubDaoInter) {
		this.createdClubDaoInter = createdClubDaoInter;
	}

	@Override
	public List<AppDto> showClubList(String mem_id) {
		return createdClubDaoInter.selectClubList(mem_id);
	}
	
	@Override
	public List<AppDto> showAppList(int cNo,int startNo, int endNo) {
		log.info("service 도달");
		return createdClubDaoInter.selectAppList(cNo,startNo, endNo);
	}

	@Override
	public void applyApp(int app_no) {
		createdClubDaoInter.deleteApp(app_no);
	}

	@Override
	public void insertMyClub(MyClubDto myclubdto) {
		createdClubDaoInter.insertMyClub(myclubdto);
	}
	
	@Override
	public int applicantTotalPage(int c_no) {
		return createdClubDaoInter.applicantTotalPage(c_no);
	}
	@Override
	public List<WishDTO> showWishList(String mem_id) {
		System.out.println("service :"+mem_id);
		return createdClubDaoInter.selectWishList(mem_id);
	}
}
