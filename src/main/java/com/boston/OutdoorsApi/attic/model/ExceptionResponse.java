package com.boston.OutdoorsApi.attic.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.text.SimpleDateFormat;

//@Entity
public class ExceptionResponse {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "Exceptionid", columnDefinition = "BIGINT")
//    private Long Exceptionid;

    //@Column(name = "timeStamp", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private String timeStamp = new Date().toString();

    //@Column(name = "name", columnDefinition = "TEXT")
    private String name;
    //@Column(name = "message", columnDefinition = "TEXT")
    private String message;

    //@Column(name = "details", columnDefinition = "TEXT")
    private String details;

    public ExceptionResponse() {
        setTimeStamp(new Date().toString());
    }


//    public Long getExceptionid() {
//        return Exceptionid;
//    }
//
//    public void setExceptionid(Long exceptionid) {
//        Exceptionid = exceptionid;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExceptionResponse(String name, String message, String details) {


        this.name = name;
        this.message = message;
        this.details = details;
    }

    public ExceptionResponse( String message, String details) {

        this.message = message;
        this.details = details;
    }

    public ExceptionResponse(Map<String, String> errors) {

    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
