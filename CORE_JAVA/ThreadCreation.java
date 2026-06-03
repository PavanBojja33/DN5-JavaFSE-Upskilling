// Class implementing Runnable
class PrintThread implements Runnable {
    private String threadName;
    
    public PrintThread(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Message " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        System.out.println(threadName + " completed.");
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        System.out.println("Starting threads...\n");
        
        // Create and start two threads
        Thread thread1 = new Thread(new PrintThread("Thread-1"), "Thread 1");
        Thread thread2 = new Thread(new PrintThread("Thread-2"), "Thread 2");
        
        thread1.start();
        thread2.start();
        
        System.out.println("Main thread continues...");
    }
}
