package com.money.money.exceptions;

public class QuestionNotFoundException extends RuntimeException{

    public QuestionNotFoundException(){}

    public QuestionNotFoundException(String message){
        super(message);
    }
}

