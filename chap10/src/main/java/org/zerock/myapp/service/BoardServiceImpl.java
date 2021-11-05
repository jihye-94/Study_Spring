package org.zerock.myapp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor

@Service("boardService")
public class BoardServiceImpl implements BoardService, InitializingBean, DisposableBean {
	private BoardMapper mapper;

	// 1. 새로운 게시글 요청을 처리하는 비지니스 메소드
	@Override
	public boolean register(BoardVO board) {
		log.debug("register({}) invoked", board);
		
		// 비지니스 로직 수행에 필요한 경우, 영속성 계층의 메소드 호출
		int affectedRows = mapper.insertSelectKey(board);

		log.info("\t + affectedRows:{}", affectedRows);

		return affectedRows == 1;
	} // register

	// 2. 기존 게시글 수정(변경)
	@Override
	public boolean modify(BoardVO board) {
		log.debug("modify({}) invoked", board);
		
		// 비지니스 로직 수행에 필요한 경우, 영속성 계층의 메소드 호출
		int affectedRows = mapper.update(board);
		
		log.info("\t + affectedRows:{}", affectedRows);

		return affectedRows == 1;
	} // modify

	// 3. 기존 게시글 삭제
	@Override
	public boolean remove(Integer bno) {
		log.debug("remove({}) invoked", bno);
		
		// 비지니스 로직 수행에 필요한 경우, 영속성 계층의 메소드 호출
		int affectedRows = this.mapper.delete(bno);
		log.info("\t + affectedRows:{}", affectedRows);
		return affectedRows == 1;
	} // remove

	// 4. 특정 게시글 상세조회 	
	@Override
	public BoardVO get(Integer bno) {

		log.debug("get({}) invoked", bno);
		BoardVO board = this.mapper.read(bno);
		log.info("\t + board:{}", board);
		
		return board;
		// return mapper.read(bno);
	} // get

	// 5. 전체 목록 조회 
	@Override
	public List<BoardVO> getList() {
		log.debug("get({}) invoked");
		List<BoardVO> allBoard = this.mapper.getList();
		log.info("\t + board:{}", allBoard);
		
		
		return this.mapper.getList();
	} // getList

	//---------------------------------------
	@Override
	public void destroy() throws Exception {
		log.debug("destroy({}) invoked");
		
	}//destroy

	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("afterPropertiesSet({}) invoked");
		
		assert this.mapper != null;
		log.info("\t + mapper:" + this.mapper);
	}//afterPropertiesSet

}
