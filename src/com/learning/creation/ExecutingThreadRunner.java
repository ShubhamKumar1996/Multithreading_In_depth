package com.learning.creation;

public class ExecutingThreadRunner {
    public static void main(String[] args) {
        Thread thread = new ExecutingThread();
	    thread.setName("Worker Thread 1");
	    thread.setPriority(Thread.MAX_PRIORITY);
	    System.out.println("Before Execution, Thread Name: " + Thread.currentThread().getName());
	    thread.start();
	    System.out.println("After Execution, Thread Name: " + Thread.currentThread().getName());
    }
}
