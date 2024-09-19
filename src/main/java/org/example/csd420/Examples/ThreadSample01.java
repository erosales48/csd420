package org.example.csd420.Examples;

public class ThreadSample01 extends Thread {

    private static int threadNumber = 0;
    private int loopCount = 1;

    public ThreadSample01() {

        super("Thread-" + ++threadNumber);

        start();
    }

    @Override
    public String toString() {
        return ("Thread #" + this.getName() + ": Loop count " + loopCount);
    }

    public void run() {
        while(true) {
            System.out.println(this);
            if (loopCount < 10) {
                loopCount++;
            } else {
                System.out.println("\t\tThread #" + this.getName() + " is complete.");
                return;
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new ThreadSample01();
        }
    }

}