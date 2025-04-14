package com.pokeapi.poketest.rest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pokeapi.poketest.dto.ErrorDto;
import com.pokeapi.poketest.exception.RequestException;

@RestControllerAdvice
public class ControllerAdvice {
	
private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);
	
	@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex){
		ErrorDto error = new ErrorDto();
		
		error.setCode("500");
		error.setMensaje(ex.getMessage());
		logger.error(ex.getMessage());
		
		return new ResponseEntity<ErrorDto>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=RequestException.class)
	public ResponseEntity<ErrorDto> requestExceptionHandler(RequestException ex){
		ErrorDto error = new ErrorDto();
		
		error.setCode(ex.getCodigo());
		error.setMensaje(ex.getMessage());
		logger.error(ex.getMessage());
		
		return new ResponseEntity<ErrorDto>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDto> datosExceptionHandler(DataIntegrityViolationException ex){
		ErrorDto error = new ErrorDto();
		
		error.setCode("500");
		error.setMensaje(ex.getCause().getCause().getLocalizedMessage());
		logger.error(ex.getMessage());
		
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=NoSuchElementException.class)
	public ResponseEntity<ErrorDto> datosNoEncontradosExceptionHandler(NoSuchElementException ex){
		ErrorDto error = new ErrorDto();
		
		error.setCode("404");
		error.setMensaje(ex.getCause().getCause().getLocalizedMessage());
		logger.error(ex.getMessage());
		
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=IOException.class)
	public ResponseEntity<ErrorDto> escrituraExceptionHandler(IOException ex){
		ErrorDto error = new ErrorDto();
		
		error.setCode("500");
		error.setMensaje(ex.getCause().getCause().getLocalizedMessage());
		logger.error(ex.getMessage());
		
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<ErrorDto> escrituraExceptionHandler(Exception ex){
		ErrorDto error = new ErrorDto();
		
		error.setCode("500");
		error.setMensaje(ex.getCause().getCause().getLocalizedMessage());
		logger.error(ex.getMessage());
		
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=InvocationTargetException.class)
	public ResponseEntity<ErrorDto> InvocationTargetExceptionHandler(InvocationTargetException ex){
		ErrorDto error = new ErrorDto();
		
		error.setCode("500");
		error.setMensaje(ex.getCause().getCause().getLocalizedMessage());
		logger.error(ex.getMessage());
		
		return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
