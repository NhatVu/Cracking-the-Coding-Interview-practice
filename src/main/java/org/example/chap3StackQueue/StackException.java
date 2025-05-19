package org.example.chap3StackQueue;

public class StackException extends RuntimeException{
    public StackException(String message){
        super(message);
    }

    public StackException(String message, Throwable t){
        super(message, t);
    }
}
