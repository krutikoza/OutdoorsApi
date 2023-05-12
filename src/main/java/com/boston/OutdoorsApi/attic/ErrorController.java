package com.boston.OutdoorsApi.attic;


import com.boston.OutdoorsApi.attic.model.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {


    @RequestMapping("/error")
    public ResponseEntity<Object> handleError(HttpServletRequest request) {
        // get error status
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // TODO: log error details here

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            // display specific error page
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                ExceptionResponse errorDetails = new ExceptionResponse();
                errorDetails.setName("NotFoundException");
                errorDetails.setDetails("Requested path not found");
                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                ExceptionResponse errorDetails = new ExceptionResponse();
                errorDetails.setName("InternalServerError");
                errorDetails.setDetails("Some Internal Error into the server");
                return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                ExceptionResponse errorDetails = new ExceptionResponse();
                errorDetails.setName("Forbidden");
                errorDetails.setDetails("You do not have access to the requested path");
                return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
            }
        }

        // display generic error
        ExceptionResponse errorDetails = new ExceptionResponse();
        errorDetails.setName("Generic Error!");
        errorDetails.setDetails("Some internal error occurred, this error is not handled in the server");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
