package Week10.Walkthrough;

public class MyThreadTwo extends Thread {

  public void run() { // MUST NOT have any parameters!
    // thread logic
    System.out.println("Running!"); 
  }

  public static void main(String[] args) {
    Thread t = new MyThreadTwo();
    t.start();

    try {
        t.join(); // wait for t to finish
    } catch (InterruptedException ie) {
        ie.printStackTrace(); // will print the stack trace of the origin of the InterruptedException
    }
  }
}
