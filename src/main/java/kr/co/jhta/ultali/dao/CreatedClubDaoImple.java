package kr.co.jhta.ultali.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.jhta.ultali.dto.AppDto;
import kr.co.jhta.ultali.dto.CNoStartEnd;
import kr.co.jhta.ultali.dto.MyClubDto;
import kr.co.jhta.ultali.dto.WishDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CreatedClubDaoImple implements CreatedClubDaoInter {
	String namespace = "kr.co.jhta.ultali.createdclub.";
	@Autowired
	SqlSession ss;
	
	@Override
	public List<AppDto> selectClubList(String mem_id) {
		return ss.selectList(namespace+"selectClubList",mem_id);
	}

	@Override
	public List<AppDto> selectAppList(int cNo, int startNo, int endNo) {
		log.info("dao 도달");
		CNoStartEnd cNoStartEnd = new CNoStartEnd(cNo, startNo, endNo);
		return ss.selectList(namespace+"selectAppList",cNoStartEnd);
	}

	@Override
	public void deleteApp(int app_no) {
		ss.delete(namespace+"deleteOne",app_no);
	}

	@Override
	public void insertMyClub(MyClubDto myclubdto) {
		// TODO Auto-generated method stub
		ss.insert(namespace+"insertMyClub",myclubdto);
	}
	
	@Override
	public int applicantTotalPage(int c_no) {
		return ss.selectOne(namespace+"totalPage", c_no );
	}
	
	@Override
	public List<WishDTO> selectWishList(String mem_id) {
		System.out.println("dao ::"+mem_id);
		return ss.selectList(namespace+"wishList",mem_id);
	}
}
