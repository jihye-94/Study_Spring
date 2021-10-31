package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.BoardVO;

//DAO (Data Access Object) : 지정된 테이블을 목록 조회, CRUD할 수 있는 메소드를 선언 
public interface BoardMapper {

	
	// 1. 게시판 목록 조회
	@Select("SELECT /*+ index(tbl_board) */ * FROM tbl_board WHERE bno > 0")
	public abstract List<BoardVO> getList();
	
	// 2-1. 새로운 게시물 등록 	
	@Insert("INSERT INTO tbl_board (title, content, writer) "
			+ "VALUES(#{title}, #{content}, #{writer})")
	public abstract Integer insert(BoardVO board);
	
/*	public abstract Integer insert(
			@Param("title") String title, 
			@Param("content") String content, 
			@Param("writer") String writer
	); 
*/	
	// 2-2. 새로운 게시물 등록(xml)
	public abstract Integer insertSelectKey (BoardVO board); 
	
	// 3. 특정 게시물 상세조회 
	public abstract BoardVO read(Integer bno);
	
	// 4. 특정 게시물 업데이트 수행
	public abstract Integer update(BoardVO board);
	
	// 5. 특정 게시물 삭제
	@Delete("DELETE FROM tbl_board WHERE bno=#{bno}")
	public abstract Integer delete(Integer bno2);
	
	
} // end interface
