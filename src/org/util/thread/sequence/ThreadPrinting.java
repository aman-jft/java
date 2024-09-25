package org.util.thread.sequence;

class PrintTask implements Runnable {
    private final Object lock;
    private final int[] numbers;
    private final int threadNumber;
    private final int totalThreads;
    private static int currentThread = 0;

    public PrintTask(Object lock, int[] numbers, int threadNumber, int totalThreads) {
        this.lock = lock;
        this.numbers = numbers;
        this.threadNumber = threadNumber;
        this.totalThreads = totalThreads;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            synchronized (lock) {
                while (threadNumber != currentThread) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(String.format("%d (%d -> %d)", number, currentThread,  (currentThread + 1) % totalThreads));
                currentThread = (currentThread + 1) % totalThreads;
                lock.notifyAll();
            }
        }
    }
}

public class ThreadPrinting {
    public static void main(String[] args) {
        Object lock = new Object();
        int[] numbers0 = {0, 0, 0, 0, 0};
        int[] numbers1 = {1, 3, 5, 7, 9};
        int[] numbers2 = {2, 4, 6, 8, 10};

        Thread t0 = new Thread(new PrintTask(lock, numbers0, 0, 3));
        Thread t1 = new Thread(new PrintTask(lock, numbers1, 1, 3));
        Thread t2 = new Thread(new PrintTask(lock, numbers2, 2, 3));

        t0.start();
        t1.start();
        t2.start();
    }
}
