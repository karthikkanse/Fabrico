package com.ty.fabrico.fabrico_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchIdFoundExceptionHandler(NoSuchIdFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Such ID is Present");
		responseStructure.setData(exception.getMessage());
		return responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchUsernameFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchUsernameFoundExceptionHandler(NoSuchUsernameFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("User Name Not Found");
		responseStructure.setData(exception.getMessage());
		return responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PasswordIncorrectException.class)
	public ResponseEntity<ResponseStructure<String>> passwordIncorrectExceptionHandler(PasswordIncorrectException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Invalid Password");
		responseStructure.setData(exception.getMessage());
		return responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNameAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> userNameAlreadyExistsExceptionHandler(UserNameAlreadyExists exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;
		responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		responseStructure.setMessage("UserName or Email-id Already Exists Try With Diffrent UserName or Email-id");
		responseStructure.setData(exception.getMessage());
		return responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> cartNotFoundExceptionHandler( CartNotFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Cart not Found to add Products");
		responseStructure.setData(exception.getMessage());
		return responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(value =  MethodArgumentNotValidException.class)
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
//	public ResponseEntity handleValidationException(MethodArgumentNotValidException exception){
		
//		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
//		ResponseEntity<ResponseStructure<String>> responseEntity;
//		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
//		responseStructure.setMessage("Please fill the field");
//		responseStructure.setData(exception.getMessage());
//		return responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
//		return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
//	}
}
