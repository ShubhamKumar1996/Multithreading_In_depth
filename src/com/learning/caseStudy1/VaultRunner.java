package com.learning.caseStudy1;

import java.util.Random;

public class VaultRunner {
    public static final int MAX_PASSWORD = 10000;

    public static class Vault {
        private final int password;
        public Vault(int password) {
            this.password = password;
        }
        public boolean passwordCheck(int guess){
            return this.password == guess;
        }
    }

    public abstract static class HackerThread extends Thread {
        Vault vault;
        public HackerThread(Vault vault) {
            this.vault = vault;
        }
        @Override
        public abstract void run();

        public void tryPassword(int guessedPassword) {
            if(vault.passwordCheck(guessedPassword)) {
                System.out.format("\nWe lost your money %d", guessedPassword);
                System.exit(0);
            }
        }
    }

    public static class AscendingHackerThread extends HackerThread {
        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int i=1;i<=MAX_PASSWORD;i++) {
                tryPassword(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class DescendingHackerThread extends HackerThread {
        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int i=MAX_PASSWORD;i>0;i--) {
                tryPassword(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class RandomHackerThread extends HackerThread {
        public RandomHackerThread(Vault vault) {
            super(vault);
        }
        public void run() {
            Random randomNumber = new Random();
            for(int i=0;i<MAX_PASSWORD;i++) {
                int guess = randomNumber.nextInt(MAX_PASSWORD);
                tryPassword(guess);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class PoliceThread extends Thread {
        @Override
        public void run() {
            for(int i=10;i>0;i--) {
                System.out.format("%d ", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.format("\nHacker's caught red handed");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Random random = new Random(52);
        int password = random.nextInt(MAX_PASSWORD);
        Vault vault = new Vault(password);

        // Create Hacker Threads & police Thread;
        HackerThread hackerThread1 = new AscendingHackerThread(vault);
        HackerThread hackerThread2 = new DescendingHackerThread(vault);
        HackerThread hackerThread3 = new RandomHackerThread(vault);
        PoliceThread policeThread = new PoliceThread();

        // Starting Execution of police Thread & Hacker Thread.
        hackerThread1.start();
        hackerThread2.start();
        hackerThread3.start();
        policeThread.start();
    }
}
