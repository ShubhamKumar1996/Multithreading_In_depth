package com.learning.exception;

public class ExceptionThread extends Thread{
    @Override
    public void run() {
        System.out.println("Executing Thread: " + Thread.currentThread().getName());
        throw new RuntimeException("Intentional Exception");
    }
}
