package org.zerock.myapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor(access = lombok.AccessLevel.PUBLIC)

@ControllerAdvice // For all packages.
public class CommonExceptionHandler {
	
	/*
	// Spring MVC model에서 수신된 요청을 처리할 컨트롤러의 메소드에 대한 
	// 매핑 정보가 없는 경우에 발생하는 NoHandlerFoundException 발생시 예외처리ㄱ
	@ResponseStatus(code=HttpStatus.NOT_FOUND)	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleNoHandlerFoundException(Exception e, Model model) {
        log.debug("handleNoHandlerFoundException({}) is invoked", "e = " + e + ", model = " + model);

		log.error("1. Exception Type: " + e.getClass().getName());
		log.error("2. Exception Message: " + e.getMessage());

		model.addAttribute("exception", e);

		// 예외처리를 수행 
		e.printStackTrace(); // 발생한 예외의 스택트레이스를 콘솔에 출력 
		return "errorPage";
	} // handleNoHandlerFoundException

	*/
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleNumberFormatException(Exception e, Model model) {
        log.debug("handleNoHandlerFoundException({}) is invoked", "e = " + e + ", model = " + model);

		log.error("1. Exception Type: " + e.getClass().getName());
		log.error("2. Exception Message: " + e.getMessage());

		model.addAttribute("exception", e);

		// 예외처리를 수행 
		//e.printStackTrace(); // 발생한 예외의 스택트레이스를 콘솔에 출력 
		return "errorPage";
	} // handleNoHandlerFoundException


} // end class
