package kr.co.jhta.ultali.dao;

import java.util.List;

import kr.co.jhta.ultali.dto.AdminInquirePagingVO;
import kr.co.jhta.ultali.dto.InquireDto;

public interface InquireDaoInter {
	public InquireDto selectOne(int p_inq_no);
	public List<InquireDto> selectList(String mem_id);
	public void insertInquire(InquireDto dto);
	
	// 게시물 총 갯수
	public int countBoard();

	// 페이징 처리 게시글 조회
	public List<InquireDto> selectBoard(AdminInquirePagingVO vo);
	
}
