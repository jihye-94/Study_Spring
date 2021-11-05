package org.zerock.myapp.domain;

import lombok.Data;


// 웹 브라우저에서 전송되는 파라미터들을 수집(지역변수로 선언된)
@Data
public class BoardDTO {
	private Integer bno;
	private String title;
	private String content;
	private String writer;

} // end class 
