package kr.co.jhta.ultali.service;
import kr.co.jhta.ultali.dto.MyInfoDto;

public interface MyInfoServiceInter {
	
	// 회원 불러오기
	public MyInfoDto showInfo(String id);
	
	// 수정하기
	public void update(String mem_id);
	
	// 탈퇴하기
	public void delete(String id);

}
