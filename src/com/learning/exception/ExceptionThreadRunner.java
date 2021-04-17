package com.learning.exception;

public class ExceptionThreadRunner {
    public static void main(String[] args) {
        Thread thread = new ExceptionThread();
        thread.setName("Exception Thread");
        Thread.UncaughtExceptionHandler exceptionHandlerClass = new ExceptionHandlerClass();
        thread.setUncaughtExceptionHandler(exceptionHandlerClass);
        thread.start();
    }
}
