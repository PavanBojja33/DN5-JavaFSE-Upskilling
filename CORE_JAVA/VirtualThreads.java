import java.time.Instant;

public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Virtual Threads Example (Java 21+)\n");
        
        // Test 1: Create a small number of virtual threads
        System.out.println("Test 1: Creating 100 virtual threads");
        Instant start = Instant.now();
        
        for (int i = 1; i <= 100; i++) {
            final int threadNum = i;
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(100); // Simulate work
                    System.out.println("Virtual Thread " + threadNum + " executed");
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            });
        }
        
        // Give threads time to complete
        Thread.sleep(2000);
        Instant end = Instant.now();
        System.out.println("Time taken: " + (end.toEpochMilli() - start.toEpochMilli()) + " ms\n");
        
        // Test 2: Create a large number of virtual threads (demonstrating scalability)
        System.out.println("Test 2: Creating 10,000 virtual threads");
        start = Instant.now();
        
        for (int i = 1; i <= 10000; i++) {
            final int threadNum = i;
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(50); // Simulate lightweight work
                    if (threadNum % 1000 == 0) {
                        System.out.println("Virtual Thread " + threadNum + " milestone reached");
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            });
        }
        
        // Give threads time to complete
        Thread.sleep(3000);
        end = Instant.now();
        System.out.println("Time taken for 10,000 virtual threads: " + (end.toEpochMilli() - start.toEpochMilli()) + " ms\n");
        
        System.out.println("Virtual threads are much lighter weight than platform threads,");
        System.out.println("allowing for millions of concurrent tasks efficiently!");
    }
}
