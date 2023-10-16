package Practice;
public class MainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("main thread: " + t);

        System.out.println("going to sleep...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ah, that was nice");
        System.out.println("letting someone else have a turn...");
        Thread.yield();
        System.out.println("back");
    }
}