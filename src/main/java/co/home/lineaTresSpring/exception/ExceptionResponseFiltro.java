package co.home.lineaTresSpring.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.home.lineaTresSpring.dto.ExceptionRespuesta;


@ControllerAdvice
@RestController
public class ExceptionResponseFiltro extends ResponseEntityExceptionHandler {
	
	
	 @ExceptionHandler(GuardarException.class)
	 public ResponseEntity<ExceptionRespuesta> guardarException(GuardarException e ,WebRequest request){
		e.printStackTrace();//para imprimir la traza del error
		ExceptionRespuesta ex= new ExceptionRespuesta(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.toString(),e.getMessage(),request.getDescription(false));
		
		
		return new ResponseEntity<ExceptionRespuesta>(ex,HttpStatus.CONFLICT);
		}
	 
	 @ExceptionHandler(NoencontradoException.class)
	 public ResponseEntity<ExceptionRespuesta> noencontradoException(NoencontradoException e,WebRequest request){
		 e.printStackTrace();//para imprimir la traza del error
		 ExceptionRespuesta ex = new ExceptionRespuesta(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(),e.getMessage(),request.getDescription(false));
		 return new ResponseEntity<ExceptionRespuesta>(ex,HttpStatus.NOT_FOUND);		
		 
		 
	 }


}
