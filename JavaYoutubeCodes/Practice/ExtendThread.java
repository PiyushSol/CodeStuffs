
public class ExtendThread {

    public static void main(String[] args) {
        new ThreadDemo();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("MainThread " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread Exception");

        }
        System.out.println("Exiting Main");
    }
}
