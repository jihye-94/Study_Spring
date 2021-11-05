package org.zerock.myapp.mapper;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.myapp.domain.BoardVO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" 
)
public class BoardMapperTests {

//	@Setter(onMethod_ = { @Inject })
//	@Setter(onMethod_ = { @Resource })
//	@Setter(onMethod_ = { @Resource(type=BoardMapper.class)})
//	@Inject
//	@Resource
//	@Autowired
	
	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;

	@Before	
	public void setup() {	//사전처리: 주입받은 객체가 null인지 체크 
		log.debug("setup() invoked.");
		
		assert this.mapper != null;
		log.info("\t+ mapper: " + mapper);
		log.info("\t+ type: " + mapper.getClass().getName());

	} // setup

	@Test
	public void testGetList() {
		log.debug("testGetList() invoked.");
		
		List<BoardVO> list = this.mapper.getList();
		list.forEach(log::info);
	} // testGetList
	
	@Test
	public void testInsert() {
		log.debug("testInsert() invoked.");
	
		//1st. method : ok
	/*	int affectedLines = 
				this.
				mapper.insert(978, "TITLE_978", "CONTENT_978", "WRITER_978");
		
		log.info("\t+ affectedRows: " + affectedLines); 		
		log.info("\t+ newBoard: " + newBoard); */
		

		//2nd. method : ok
		BoardVO newBoard = 
				new BoardVO(
					null, 
					"TITLE_879", 
					"CONTENT_879", 
					"WRITER_879", null, null);
		
		int affectedRows = mapper.insert(newBoard); 
		log.info("\t+ affectedRows: " + affectedRows);
	} // testInsert
	
	@Test
	public void testInsertSelectKey() { //insert xml로
		log.debug("testInsertSelectKey() invoked.");
		
		// BoardVO board = new BoardVO(null, "TITLE_1000", "CONTENT_1000", "WRITER_1000", null, null);
		BoardVO board = new BoardVO( null,"title", "CONTENT_1000", "WRITER_1000", null, null);
		int affectedRows = mapper.insertSelectKey(board);
		
		log.info("\t+ affectedRows: " + affectedRows);
		log.info("\t+ board: " + board);
	} // testInsertSelectKey
	
	
	@Test
	public void testDelete() {
		log.debug("testDelete() invoked.");
		int bno = 633;
		int affectedRows = mapper.delete(bno);
		
		log.info("\t+ affectedRows: " + affectedRows);
	} // testDelete
	
	@Test
	public void testRead() {
		log.debug("testDelete() invoked.");
		int bno = 633;
		BoardVO board = mapper.read(bno);
		
		log.info("\t+ affectedRows: " + board);
	} // testRead
	
	@Test
	public void testUpdate() {
		log.debug("testUpdate() invoked.");
		
		BoardVO board = 
				new BoardVO(
						201, 
						"지혜다녀감-6", 
						"지혜다녀감-6", 
						"지혜다녀감-6", null, null);
		
		int affectedRows = mapper.update(board);
		
		log.info("\t+ affectedRows: " + affectedRows);
	} // testUpdate
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
		
	} // tearDown

}
