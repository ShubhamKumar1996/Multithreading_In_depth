package com.learning.creation;

public class ExecutingThread extends Thread {
    public void run() {
        System.out.println("Executing Threads");
        System.out.println("During Thread Execution, Thread Name: " + Thread.currentThread().getName());
    }
}
