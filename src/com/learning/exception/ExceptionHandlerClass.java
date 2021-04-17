package com.learning.exception;

public class ExceptionHandlerClass implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(e.getMessage() + " occurred in " + t.getName());
    }
}
