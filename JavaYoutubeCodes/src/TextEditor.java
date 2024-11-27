import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.event.*;


public class TextEditor extends JFrame implements ActionListener {
	
	JTextArea textArea;
	JScrollPane scrollpane;
	JSpinner fontsizeSpinner;
	JLabel fontlabel;
	JButton fontcolor;
	JComboBox fontbox;
	JMenuBar menubar;
	JMenu filemenu;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
	
	TextEditor(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Notes For You");
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true); /* This changes the line when you reach the leftmost end of frame */
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial",Font.PLAIN,20));
		
		scrollpane = new JScrollPane(textArea);
		scrollpane.setPreferredSize(new Dimension(450,450));
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		fontlabel = new JLabel("Font :");
		
		fontsizeSpinner = new JSpinner(); //Need to Change Size of font according to the user.
		fontsizeSpinner.setPreferredSize(new Dimension(50,25));
		fontsizeSpinner.setValue(12);
		fontsizeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontsizeSpinner.getValue()));
			}
		});
		
		fontcolor = new JButton("Color");
		fontcolor.addActionListener(this);
		
		/*This gets all the available fonts and store in the array of String named as fonts. */
		String []fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
	   fontbox = new JComboBox(fonts);
	   fontbox.addActionListener(this);
	   fontbox.setSelectedItem("Arial");
	   
	   //--- Menubar Code ---
	   
	   menubar = new JMenuBar();
	   filemenu = new JMenu("File");
	   openItem = new JMenuItem("Open");
	   saveItem = new JMenuItem("Save");
	   exitItem = new JMenuItem("Exit");
	   
	   openItem.addActionListener(this);
	   saveItem.addActionListener(this);
	   exitItem.addActionListener(this);
	   
	   filemenu.add(openItem);
	   filemenu.add(saveItem);
	   filemenu.add(exitItem);
	   menubar.add(filemenu);
	   
	   //--Menubar finished--
		
	    this.setJMenuBar(menubar);
		this.add(fontlabel);
		this.add(fontsizeSpinner);
		this.add(fontcolor);
		this.add(fontbox);
		this.add(scrollpane);
		this.setVisible(true);
        this.setLocationRelativeTo(null);		;
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fontcolor) {
			JColorChooser choose = new JColorChooser();
			Color color = choose.showDialog(null,"Choose a Color",Color.white); //This will Store the color chosen by user.
			
			textArea.setForeground(color);
		}
		
		if(e.getSource() == fontbox) {
			
			textArea.setFont(new Font((String)fontbox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
		}
		
		if(e.getSource() == openItem) {
			JFileChooser filechooser = new JFileChooser();
			filechooser.setCurrentDirectory(new File("."));
			
			int response = filechooser.showOpenDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				Scanner filein = null;
				
				try {
					
					filein = new Scanner(file);
					if(file.isFile()) {
						while(filein.hasNextLine()) {
							String line = filein.nextLine()+"\n";
							textArea.append(line);
						}
						
					}
					
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				
				finally {
					filein.close();
				}
				
			}
			
		}
		
       if(e.getSource() == saveItem) {
			JFileChooser filechooser = new JFileChooser();
			filechooser.setCurrentDirectory(new File("."));
			
			int response = filechooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file;
				PrintWriter fileout = null;
				
				file = new File(filechooser.getSelectedFile().getAbsolutePath());
				try {
					fileout = new PrintWriter(file);
					fileout.println(textArea.getText());
					
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				
				finally {
					fileout.close();
				}
			}
			
		}
 
       if(e.getSource() == exitItem) {
	   System.exit(0);
}
		
	}

}
