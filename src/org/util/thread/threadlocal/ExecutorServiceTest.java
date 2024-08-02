package org.util.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit 10 tasks to the executor service
        for (int i = 1; i <= 10; i++) {
            executorService.submit(new Task("Task " + i));
        }

        // Shutdown the executor service
        //executorService.shutdown();
    }
}
