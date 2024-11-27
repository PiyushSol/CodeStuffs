import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MyTrig extends JFrame implements ActionListener {

    JTextField resultlabel;
    Border border,border1;
    JPanel numpanel;
    JButton Numbers[] = new JButton[10];
    JButton Functions[] = new JButton[13];
    JButton neg,clear,delete,sinbutton,cosbutton,tanbutton,cotbutton,cosecbutton,secbutton,squarebutton,cubebutton,squarerootbutton,cuberootbutton; 
    JScrollPane scrollpane;
    double num,res=0;

    MyTrig(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,360);
        this.setTitle("Calculator");
        this.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        border = BorderFactory.createLineBorder(Color.BLACK,2);
        border1 = BorderFactory.createLineBorder(Color.DARK_GRAY);
      
        resultlabel= new JTextField();
        resultlabel.setBorder(border);
        resultlabel.setFont(new Font("Arial Bold",Font.BOLD,25));
        resultlabel.setPreferredSize(new Dimension(360,40));
        
        numpanel = new JPanel();
        numpanel.setLayout(new GridLayout(5,4,5,5));
        numpanel.setPreferredSize(new Dimension(360,200));

        scrollpane = new JScrollPane(numpanel);
        scrollpane.setBackground(Color.LIGHT_GRAY);
    
        //For Loop to add Number Buttons  on the pane.
        for(int i=0; i<=9;i++){
            Numbers[i] = new JButton(i+" ");
            Numbers[i].setBorder(border1);
            Numbers[i].setForeground(Color.DARK_GRAY);
            Numbers[i].setPreferredSize(new Dimension(50,30));
            Numbers[i].setFont(new Font("Arial",Font.PLAIN,20));
            Numbers[i].setBackground(Color.white);
            Numbers[i].addActionListener(this);
        }
        
          //For Loop to add Numbers on Panel.
       for(int i=0; i<=9; i++){
        numpanel.add(Numbers[i]);
       }  
     
      sinbutton = new JButton("Sine");
      cosbutton = new JButton("Cosine");
      tanbutton = new JButton("Tan");
      secbutton = new JButton("Sec");
      cosecbutton = new JButton("Cosec");
      cotbutton = new JButton("Cot");
      squarebutton = new JButton("x^2");
      squarerootbutton = new JButton("x^1/2");
      cubebutton = new JButton("x^3");
      cuberootbutton = new JButton(" x^1/3");
      neg = new JButton("(-)");
      clear = new JButton("Clear");
      delete = new JButton("Delete");

       
       Functions[0]=sinbutton;
       Functions[1]=cosbutton;
       Functions[2]=tanbutton;
       Functions[3]=secbutton;
       Functions[4]=cosecbutton;
       Functions[5]=cotbutton;
       Functions[6]=squarebutton;
       Functions[7]=cubebutton;
       Functions[8]=squarerootbutton;
       Functions[9]=cuberootbutton;
       Functions[10]=neg;
       Functions[11]=clear;
       Functions[12]=delete;
  
        //For Loop to add Function Buttons  on the pane.
        for(int i=0;i<13;i++){
            Functions[i].setBorder(border1);
            Functions[i].setForeground(Color.DARK_GRAY);
            Functions[i].setPreferredSize(new Dimension(50,30));
            Functions[i].setFont(new Font("Arial",Font.PLAIN,20));
            Functions[i].setBackground(Color.white);
            Functions[i].addActionListener(this);
        }

        //For Loop to add Functions on Panel.  
        for(int i=0; i<13;i++){
            numpanel.add(Functions[i]);
        }


       this.add(resultlabel);
       this.add(scrollpane);
       this.setVisible(true);
       this.setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        for( int i=0 ; i<10 ; i++){
            if(e.getSource() == Numbers[i]){
               resultlabel.setText(resultlabel.getText().concat(String.valueOf(i)));
            }
          }

        if(e.getSource() == clear){
            resultlabel.setText("");
        } 
        
        if (e.getSource() == delete){
            String temp_text = resultlabel.getText();
            resultlabel.setText("");
    
            //To delete character from particular index position.
    
            for(int i=0; i< temp_text.length()-1;i++){
             resultlabel.setText(resultlabel.getText()+temp_text.charAt(i));
            }
        }
      
        
       if(e.getSource() == neg){
        double temp = Double.parseDouble(resultlabel.getText());
        temp *= -1;
        resultlabel.setText(String.valueOf(temp));
       }
         
       if(e.getSource() == sinbutton){
        num =Double.parseDouble(resultlabel.getText());
        res = Math.sin(num);
        resultlabel.setText(res+"");
       }

       if(e.getSource() == cosbutton){
        num =Double.parseDouble(resultlabel.getText());
        res = Math.cos(num);
        resultlabel.setText(res+"");
       }

       if(e.getSource() == tanbutton){
        num =Double.parseDouble(resultlabel.getText());
        res = Math.tan(num);
        resultlabel.setText(res+"");
       }

       if(e.getSource() == secbutton){
        num =Double.parseDouble(resultlabel.getText());
        res = 1/(Math.cos(num));
        resultlabel.setText(res+"");
       }

       if(e.getSource() == cosecbutton){
        num =Double.parseDouble(resultlabel.getText());
        res = 1/(Math.sin(num));
        resultlabel.setText(res+"");
       }

       if(e.getSource() == cotbutton){
        num =Double.parseDouble(resultlabel.getText());
        res = 1/(Math.tan(num));
        resultlabel.setText(res+"");
       }
   
       if(e.getSource() == squarebutton){
        num =Double.parseDouble(resultlabel.getText());
        res =Math.pow(num,2.0);
        resultlabel.setText(""+res);
       }

       
       if(e.getSource() == squarerootbutton){
        num =Double.parseDouble(resultlabel.getText());
        res =Math.sqrt(num);
        resultlabel.setText(""+res);
       }

       
       if(e.getSource() == cubebutton){
        num =Double.parseDouble(resultlabel.getText());
        res = Math.pow(num, 3.0);
        resultlabel.setText(""+res);
       }

       
       if(e.getSource() == cuberootbutton){
        num =Double.parseDouble(resultlabel.getText());
        res =Math.cbrt(num);
        resultlabel.setText(""+res);
       }


    }

    
}
