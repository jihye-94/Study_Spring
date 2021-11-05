package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.BoardVO;

public interface BoardService {
	// 비지니스 로직 : 게시판의 운영 
	// 비지니스 로직 실행에 필요한 추상 메소드를 선언하라!!
	
	
	// 1. 새로운 게시물 등록 
	public abstract boolean register(BoardVO board);
	
	// 2. 기존 게시글 수정(변경)
	public abstract boolean modify(BoardVO board);
	
	// 3. 기존 게시글 삭제
	public abstract boolean remove(Integer bno);
	
	// 4. 특정 게시글 상세조회 	
	public abstract BoardVO get(Integer bno);
	
	// 5. 전체 목록 조회 
	public abstract List<BoardVO> getList();

} // end interface