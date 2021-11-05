package org.zerock.myapp.controller;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Red;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.service.BoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


/** 웹에서의 매핑! Model: 비지니스 로직 처리 결과 데이터
 * (1) 모든 조회 요청 --------------------> GET
 * (2) html 에서 <a>태그를 이용한 요청----> GET
 * (3) 특정 화면을 띄워달라는 요청--------> GET
 * (4) 모든 데이터 수정요청(DML) ---> 기본 POST
 * (5) Restful 요청 : 다양함 ---> GET, POST, PUT, DELETE 
 * */


@Log4j2
@NoArgsConstructor

@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Setter(onMethod_= { @Autowired })
	private BoardService service;		// 비지니스 계층

	
	@GetMapping("/list") 
	public void list(Model model) {	// 게시판 목록화면 요청 
		// void 라서 /board + /list가 자동으로 return 값 매핑처럼 
		// 그렇기에 list를 모델데이터로 담아서 보내버리기 
		log.debug("list() invoked.");

		// Model: 비지니스 로직 처리 결과 데이터
		List<BoardVO> list = this.service.getList();
		log.info("\t+ list size: {}", list.size()); 
		
		model.addAttribute("list", list); 		
		
	} // list
	
	
	@GetMapping("/get")
	public void get(Integer bno, Model model) {	// 특정 게시물 상세조회 화면 요청 
		log.debug("get({}, {}) invoked.", bno, model);

		BoardVO board = this.service.get(bno);
		log.info("\t+ board: {}", board); 
		
		model.addAttribute("board", board); 
	} // get
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Integer bno, RedirectAttributes rttrs) {
		log.debug("modify({}, {}) invoked.", bno, rttrs);
		
		log.info("\t+ bno: " + bno);
		boolean result = this.service.remove(bno);

		rttrs.addAttribute("result",result); 
//		if(service.remove(bno)) {
//			rttrs.addFlashAttribute("result", "success");
//		} // if
		
		return "redirect:/board/list";
	} // remove
	
	@PostMapping("/modify") 
	public String modify(BoardDTO board, RedirectAttributes rttrs) {
		log.debug("modify({}, {}) invoked.", board, rttrs);		
		
		// DTO 객체를 VO객체로 변환 (form에서 받아오는 정보는 dto객체고, modify메서드는 매개변수가 vo라 변환필요)		
		BoardVO vo = 
				new BoardVO(
					board.getBno(),
					board.getTitle(),
					board.getContent(),
					board.getWriter(),
					null, null
				);
	
		
		boolean result = this.service.modify(vo); 

		// 이동되는 화면으로 전송해줘야할 파라메터가 있으면 rttrs 사용! 
		
		rttrs.addAttribute("result", result); 
		
		return "redirect:/board/list";
	} // modify

	
} // end class
