package com.example.proiectcolectiv.exceptions;

public class UserUnknownException extends Exception{
    public UserUnknownException(){
        super();
    }
    public UserUnknownException(String m){
        super(m);
    }
    public UserUnknownException(String m, Throwable t){
        super(m,t);
    }
}
