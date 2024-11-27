import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {

	static final int screen_width=800;
	static final int screen_height=600;
	static final int unit_size =30;
	static final int game_units =(screen_width * screen_height )/(unit_size * unit_size);	
	static final int delay= 60;
	
	final int x[]= new int[game_units];
	final int y[]= new int[game_units];
	
	int bodyparts = 6;
	int appleseaten= 0 ;
	int appleX,appleY;
	char direction='R';  //R = Right , L= Left, D= Down , U = Up
	boolean running= false;
	Timer timer;
	Random random;
	
	GamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(screen_width,screen_height));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
        startgame();	

	}
	
	public void startgame() {
		newApple();
		running = true;
		timer = new Timer(delay,this);
        timer.start();		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		
		/* for(int i=0; i<screen_height/unit_size; i++) {
			g.drawLine(i*unit_size,0,i * unit_size, screen_height);
			g.drawLine(0, i*unit_size,screen_width, i * unit_size);
		} */
		if(running) {
		g.setColor(Color.RED);
		g.fillOval(appleX, appleY,unit_size, unit_size);
		
		for(int i =0 ; i<bodyparts ; i++) {
			if(i ==0) {
				g.setColor(Color.GREEN);
				g.fillRect(x[i],y[i],unit_size,unit_size);
			}
			else {
				g.setColor(Color.green);
				g.fillRect(x[i],y[i],unit_size,unit_size);
			}
		}
		g.setColor(Color.yellow);
		g.setFont(new Font("Ink Free",Font.BOLD,35));
		FontMetrics metrics =getFontMetrics(g.getFont());
		g.drawString("Score : "+appleseaten,(screen_width - metrics.stringWidth("Score : "+appleseaten))/2,g.getFont().getSize());
		repaint();
		           }
		
		else {
			gameOver(g);
		}
	}
	
	public void newApple() {
	  //Purpose of this method is to generate new apple everytime.
		appleX = random.nextInt((int)(screen_width/unit_size))*unit_size;
		appleY = random.nextInt((int)(screen_height/unit_size))*unit_size;
		
	}
	
	public void move() {
		for(int i = bodyparts ; i>0 ; i--) {
			x[i]= x[i-1];
			y[i]= y[i-1];
		}
		
		switch(direction) {
		case 'U': y[0] = y[0]-unit_size;
		break;
		
		case 'D': y[0] = y[0]+ unit_size;
		break;
		
		case 'L': x[0]= x[0]- unit_size;
		break;
		
		case 'R':x[0]= x[0]+ unit_size;
		break;
		
		}
	}
	
	public void checkApple() {
		if((x[0]==appleX && (y[0] == appleY))) {
			bodyparts++;
			appleseaten++;
			newApple();
		}
		
		
	}
	
	public void checkCollisions() {
		
		//This Loop Check If Head Is collided with the body.
		for(int i=bodyparts; i>0; i--) {
			if ((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
			}
		}
		
	  //Check if head collide with left border.
		if(x[0] < 0) {
			running = false;
		}
		
     //Check if head collide with right border.
		if(x[0]> screen_width) {
			running = false;
		}
		
	//Check if head collide with top
		if(y[0] < 0) {
			running = false;
		}
		
	//Check if head collide with bottom
		if(y[0] > screen_height) {
			running = false;
		}
		
		if(!running) {
			timer.stop();
		}
		
	}
	
	public void gameOver(Graphics g) {
		g.setColor(Color.yellow);
		g.setFont(new Font("Ink Free",Font.BOLD,35));
		
		//Use of Font metrics to assigning text into the center.
		FontMetrics metrics1 =getFontMetrics(g.getFont());
		g.drawString("Score : "+appleseaten,(screen_width - metrics1.stringWidth("Score : "+appleseaten))/2,g.getFont().getSize());
		// Game Ove text Setup
		g.setColor(Color.BLUE);
		g.setFont(new Font("Ink Free",Font.BOLD,70));
		
		//Use of Font metrics to assigning text into the center.
		FontMetrics metrics =getFontMetrics(g.getFont());
		g.drawString("Game Over!!",(screen_width - metrics.stringWidth("Game Over!!"))/2, screen_height/2);	
   
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction= 'L';
				}
				break;
				
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction= 'R';
				}
				break;		
		  
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction= 'U';
				}
				break;
				
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction= 'D';
				}
				break;
			}
		}
	}
}

