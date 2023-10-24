package Week10.Walkthrough;

public class MyThread implements Runnable {

  public void run() { // MUST NOT have any parameters!
    // thread logic
    System.out.println("Running!"); 
  }

  public static void main(String[] args) {
    Thread t = new Thread(new MyThread());
    t.start();

    try {
        t.join(); // wait for t to finish
    } catch (InterruptedException ie) {
        ie.printStackTrace(); // will print the stack trace of the origin of the InterruptedException
    }


  }
}
