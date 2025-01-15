
public class ThreadDemo extends Thread {

    ThreadDemo() {
        System.out.println("Inside Child Thread");
        start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Exception");
        }
        System.out.println("Exiting Child");
    }
}
