import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyFrame extends JFrame {
 
	 Calendar calendar; //Creating a calendar get us the current date and time of system.
	 SimpleDateFormat timeformat;//Fomatting the view of date and time.
	 SimpleDateFormat dayformat;
	 SimpleDateFormat dateformat;
	 JLabel datelabel;
	 JLabel timelabel;
	 JLabel daylabel;
	 String day;
	 String time;
	 String date;
	
	MyFrame(){
		this.setTitle("My Clock ");
		this.setLayout(new FlowLayout());
		this.setSize(250,200);
		this.setResizable(false);
		
		timeformat = new SimpleDateFormat("hh:mm:ss a");
        dayformat = new SimpleDateFormat("EEEE");
        dateformat = new SimpleDateFormat("MMMMM dd, yyyy");
		
		timelabel = new JLabel();
		timelabel.setFont(new Font("Arial",Font.BOLD,30));
		timelabel.setForeground(Color.YELLOW);
		timelabel.setBackground(Color.BLACK);
		timelabel.setOpaque(true);
		
		daylabel = new JLabel();
		daylabel.setFont(new Font("Ink Free",Font.BOLD,25));
		daylabel.setForeground(Color.CYAN);
		daylabel.setBackground(Color.black);
		daylabel.setOpaque(true);
		

		datelabel = new JLabel();
		datelabel.setFont(new Font("Ink Free",Font.BOLD,20));
		datelabel.setForeground(Color.GREEN);
		datelabel.setBackground(Color.black);
		datelabel.setOpaque(true);
		
		
		this.add(timelabel);
		this.add(daylabel);
		this.add(datelabel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Method to change time after every second.
		setTime();
	}
	
	public void setTime() {
		while(true) {
			time = timeformat.format(Calendar.getInstance().getTime());//This gets the current time and stores in time variable.
			timelabel.setText(time);
			
			day = dayformat.format(Calendar.getInstance().getTime());
			daylabel.setText(day);
			

			date = dateformat.format(Calendar.getInstance().getTime());
			datelabel.setText(date);
			
			try {
				Thread.sleep(1000); //This causes current thread to sleep every 1 second.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	
}
