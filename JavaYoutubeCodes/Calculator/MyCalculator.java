import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


public class MyCalculator extends JFrame implements ActionListener{
    JTextField resultlabel;
    Border border,border1;
    JPanel numpanel;
    JButton Numbers[] = new JButton[10]; 
   JButton Functions[] = new JButton[11];
     JButton add,sub,div,mul,ce,dot,mod,clear,equals,delete,neg,MoreFunction;
     JScrollPane scrollpane;
      double  f_num, s_num, res=0;
      char operator;

    MyCalculator(){
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
         
        add = new JButton(" + ");
        sub = new JButton(" - ");
        mul = new JButton(" x ");
        div= new JButton(" / ");
        mod = new JButton(" % ");
        dot = new JButton(" . ");
        ce = new JButton(" CE ");
        equals = new JButton(" = ");
        clear = new JButton(" Clear ");
        delete = new JButton("Delete");
        neg= new JButton(" (-) ");

        Functions[0]=add;
        Functions[1]=sub;
        Functions[2]=mul;
        Functions[3]=div;
        Functions[4]=mod;
        Functions[5]=dot;
        Functions[6]=neg;
        Functions[7]=ce;
        Functions[8]=equals;
        Functions[9]=clear;
        Functions[10]=delete;
       
     //For Loop to add Function Buttons  on the pane.
       for(int i=0;i<=10;i++){
           Functions[i].setBorder(border1);
           Functions[i].setForeground(Color.DARK_GRAY);
           Functions[i].setPreferredSize(new Dimension(50,30));
           Functions[i].setFont(new Font("Arial",Font.PLAIN,20));
           Functions[i].setBackground(Color.white);
           Functions[i].addActionListener(this);
       }

      //For Loop to add Numbers on Panel.
       for(int i=0; i<=9; i++){
        numpanel.add(Numbers[i]);
       }    
      
     //For Loop to add Functions on Panel.  
        for(int i=0; i<=10;i++){
            numpanel.add(Functions[i]);
        }

        MoreFunction = new JButton("More Functions");
        MoreFunction.setBorder(border1);
        MoreFunction.setForeground(Color.DARK_GRAY);
        MoreFunction.setPreferredSize(new Dimension(150,35));
        MoreFunction.setFont(new Font("Arial",Font.PLAIN,20));
        MoreFunction.setBackground(Color.white);
        MoreFunction.addActionListener(this);


        this.add(resultlabel);
        this.add(scrollpane);
        this.add(MoreFunction);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for( int i=0 ; i<10 ; i++){
         if(e.getSource() == Numbers[i]){
            resultlabel.setText(resultlabel.getText().concat(String.valueOf(i)));
         }
       }
        
       if(e.getSource() == dot){
        resultlabel.setText(resultlabel.getText().concat("."));
       }

       if(e.getSource() ==add){
        f_num=Double.parseDouble(resultlabel.getText());
        operator= '+';
        resultlabel.setText("");
       }

       if(e.getSource() ==sub){
        f_num=Double.parseDouble(resultlabel.getText());
        operator= '-';
        resultlabel.setText("");
        
       }

       if(e.getSource() ==mul){
        f_num=Double.parseDouble(resultlabel.getText());
        operator= 'x';
        resultlabel.setText("");
       }

       if(e.getSource() ==div){
        f_num=Double.parseDouble(resultlabel.getText());
        operator= '/';
        resultlabel.setText("");
       }

       if(e.getSource() ==mod){
        f_num=Double.parseDouble(resultlabel.getText());
        operator= '%';
        resultlabel.setText("");
       }

       if(e.getSource() ==equals){
       s_num = Double.parseDouble(resultlabel.getText());

       switch(operator){
       case '+':
         res=f_num + s_num;
         break;

      case '-':
         res=f_num - s_num;
         break;

      case 'x':
         res=f_num * s_num;
         break;

     case '/':
         res=f_num / s_num;
         break;

     case '%':
         res=f_num % s_num;
         break;
      }

      resultlabel.setText(String.valueOf(res));
      f_num= res;
       }

       if(e.getSource() ==ce){
        resultlabel.setText("0.0");
       }

       if(e.getSource() ==clear){
        resultlabel.setText("");
       }

       if(e.getSource() == delete){
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

       if(e.getSource() == MoreFunction){
        new MyTrig();
        this.dispose();
       }

    }


}