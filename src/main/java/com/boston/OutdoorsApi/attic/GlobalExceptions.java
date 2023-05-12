// TODO: Exception handling if exception name not found in database??

package com.boston.OutdoorsApi.attic;



import com.boston.OutdoorsApi.attic.model.ExceptionResponse;
import com.boston.OutdoorsApi.attic.unchecked.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleException(EmptyResultDataAccessException ex){
        ExceptionResponse errorDetails = new ExceptionResponse();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setName("EmptyResultDataAccessException");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleException(NotFoundException ex){
        ExceptionResponse errorDetails = new ExceptionResponse();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setName("NotFoundException");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SaveFailedException.class)
    public ResponseEntity<Object> handleException(SaveFailedException ex){
        ExceptionResponse errorDetails = new ExceptionResponse();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setName("SaveFailedException");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<Object> handleException(PageNotFoundException ex){
        ExceptionResponse errorDetails = new ExceptionResponse();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setName("PageNotFoundException");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(HibernateSearchFailedException.class)
    public ResponseEntity<Object> handleException(HibernateSearchFailedException ex){
        ExceptionResponse errorDetails = new ExceptionResponse();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setName("HibernateSearchFailedException");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MappingFailedException.class)
    public ResponseEntity<Object> handleException(MappingFailedException ex){
        ExceptionResponse errorDetails = new ExceptionResponse();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setName("MappingFailedException");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DeleteFailedException.class)
    public ResponseEntity<Object> handleException(DeleteFailedException ex){
        ExceptionResponse errorDetails = new ExceptionResponse();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setName("DeleteFailedException");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }



  /*  @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleException(RuntimeException ex){
        ExceptionResponse errorDetails = new ExceptionResponse();
        errorDetails.setDetails("Requested URL Not Found!!");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    */
 /*   @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

       // ex.getBindingResult(): extract the bind result for default message. 
          String errorResult = ex.getBindingResult().toString();
         CustomizedExceptionHandlerResponse exceptionResponse = new CustomizedExceptionHandlerResponse(
                errorResult, request.getDescription(false), new Date());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }*/
    
   @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
        Map<String, Object> objectBody = new HashMap<>();
        objectBody.put("Current Timestamp", new Date());
        objectBody.put("Status", httpStatus.value());
        
        ex.getBindingResult().getAllErrors().forEach((error)->{
        	String fieldName = ((FieldError)error).getField();
        	String message =error.getDefaultMessage();
        	
        	objectBody.put(fieldName, message);
        	
        });
        return new ResponseEntity<>(objectBody, HttpStatus.BAD_REQUEST);

}

//class CustomizedExceptionHandlerResponse {
//
//private String message;
//private String status;
//private Date timestamp;
//
//public CustomizedExceptionHandlerResponse(String message, String status, Date timestamp) {
//	super();
//	this.message = message;
//	this.status = status;
//	this.timestamp = timestamp;
//}
//
//public String getMessage() {
//	return message;
//}
//
//public void setMessage(String message) {
//	this.message = message;
//}
//
//public String getStatus() {
//	return status;
//}
//
//public void setStatus(String status) {
//	this.status = status;
//}
//
//public Date getTimestamp() {
//	return timestamp;
//}
//
//public void setTimestamp(Date timestamp) {
//	this.timestamp = timestamp;
//}
//
//
//}
    
    
    
}


	 



