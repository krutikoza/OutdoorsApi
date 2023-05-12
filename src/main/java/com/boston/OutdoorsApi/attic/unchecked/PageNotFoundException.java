package com.boston.OutdoorsApi.attic.unchecked;

public class PageNotFoundException extends RuntimeException{
    public PageNotFoundException(String message) {
        super(message);
    }
}
