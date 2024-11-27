import javax.swing.SwingUtilities;

// The Driver Code .

public class Main{
   public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
          public void run(){
           
            new MyCalculator();

          }
        });
    
  }
}
