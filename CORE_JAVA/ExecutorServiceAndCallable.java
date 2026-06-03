import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Callable class that performs a calculation and returns a result
class CalculationTask implements Callable<Integer> {
    private int taskId;
    private int number;
    
    public CalculationTask(int taskId, int number) {
        this.taskId = taskId;
        this.number = number;
    }
    
    @Override
    public Integer call() throws Exception {
        System.out.println("Task " + taskId + " started (calculating factorial of " + number + ")");
        
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        
        // Simulate some processing time
        Thread.sleep(1000);
        
        System.out.println("Task " + taskId + " completed");
        return result;
    }
}

public class ExecutorServiceAndCallable {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Create a list to store Future objects
        List<Future<Integer>> futures = new ArrayList<>();
        
        System.out.println("Submitting tasks to executor service...\n");
        
        // Submit 5 callable tasks
        for (int i = 1; i <= 5; i++) {
            CalculationTask task = new CalculationTask(i, i + 3); // Calculate factorial of 4, 5, 6, 7, 8
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }
        
        System.out.println("\nWaiting for results...\n");
        
        // Retrieve and display results
        int taskNum = 1;
        for (Future<Integer> future : futures) {
            try {
                // Get the result (blocking until task completes)
                Integer result = future.get();
                System.out.println("Task " + taskNum + " Result: " + result);
            } catch (InterruptedException e) {
                System.out.println("Task " + taskNum + " was interrupted: " + e.getMessage());
            } catch (ExecutionException e) {
                System.out.println("Task " + taskNum + " threw an exception: " + e.getMessage());
            }
            taskNum++;
        }
        
        // Shutdown the executor
        executor.shutdown();
        
        try {
            // Wait for all tasks to complete
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("\nAll tasks completed successfully.");
            } else {
                System.out.println("\nTimeout: Not all tasks completed.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Executor interrupted: " + e.getMessage());
            executor.shutdownNow();
        }
    }
}
