package org.zerock.myapp.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.myapp.domain.BoardVO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		})
//junit 기반의 테스트 클래스는 반드시 매개변수 없는
//기본 생성자를 가져야 한다!(다른 생성자는 없어야 함)
public class BoardServiceTests implements InitializingBean, DisposableBean{
	
	@Setter(onMethod_= {@Autowired})
	private BoardService service;
	
	@Before
	public void setUp() {
		log.debug("setup() invoked");
		
		//DI 검증 수행
		assertNotNull(this.service);
		log.info("\t + service:{}", this.service);
	}//setup
	
	
	@Test(timeout=1000)
	public void testRegister() {
		log.debug("testRegister() invoked");
		
		BoardVO board = 
				new BoardVO(
						null, 
						"TITLE_ys",
						"CONTENT_ys",
						"WRITER_ys",
						null,
						null);
		
		boolean isSuccess = this.service.register(board);
		
		log.info("\t + isSuccess:{}" , isSuccess);
		log.info("\t + new bno:{}" , board.getBno());
	}//testRegister
	
	
	@Test(timeout=1000)
	public void testModify() {
		log.debug("testModify() invoked");
		
		BoardVO board = 
				new BoardVO(
						330, 
						"TITLE_ys",
						"CONTENT_ys",
						"WRITER_ys",
						null,
						null);
		
		boolean isSuccess = this.service.modify(board);
		
		log.info("\t + isSuccess:{}" , isSuccess);
		log.info("\t + new bno:{}" , board.getBno());
	}//testModify
	
	
	@Test(timeout=1000)
	public void testRemove() {
		log.debug("testRemove() invoked");
		
		int bno=978;
		boolean isSuccess = this.service.remove(bno);
		
		log.info("\t + isSuccess:{}" , isSuccess);
	}//testRemove
	
	
	@Test(timeout=1000)
	public void testGet() {
		log.debug("testGet() invoked");
		
		int bno=978;
		BoardVO board = this.service.get(bno);
		
		Objects.requireNonNull(board);
		log.info("\t + board:{}" , board);
	}//testRemove
	
	
	@Test
	public void testGetList() {
		log.debug("testGet() invoked");
		
		List<BoardVO>board = this.service.getList();
		
		assert board !=null;
		
		board.forEach(log::info);
		log.info("\t + board:{}" , board);
	}

	
	@Override
	public void destroy() throws Exception {
	} // destroy

	@Override
	public void afterPropertiesSet() throws Exception {
	} // afterPropertiesSet
	
}//end class
