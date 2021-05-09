
package myfirstgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Faiza Satt
 */
public class Calculator implements ActionListener{
    
    //decalartions
    JFrame frame;
    JTextField textfield; //hold display and numbers
    JButton[] numberButtons=new JButton[10];  //numbers 
    JButton[] functionButtons=new JButton[8]; //operators
    JButton add,sub,div,mul,decimal,equalsSign,del,clr;
    JPanel panel;
    Font myFont=new Font("Ink Free", Font.BOLD,25);
    
    double num1, num2, result=0;
    char operator;
    
    
    Calculator(){
        frame=new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(450,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        textfield=new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);// stop user to type in anything
        
        add=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        decimal=new JButton(".");
        equalsSign=new JButton("=");
        del=new JButton("delete");
        clr=new JButton("clear");
        
        //initilized and now put it in array
        functionButtons[0]=add;
        functionButtons[1]=sub;
        functionButtons[2]=mul;
        functionButtons[3]=div;
        functionButtons[4]=decimal;
        functionButtons[5]=equalsSign;
        functionButtons[6]=del;
        functionButtons[7]=clr;
        
        for(int i=0;i<8;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
        }
        
        //number buttons are being set
        for(int i=0;i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
        }
        
        del.setBounds(50,420,120,50);
        clr.setBounds(210,420,120,50);
        
        panel=new JPanel();
        panel.setBounds(50,100,300,250);
        panel.setLayout(new GridLayout(4,4,10,5));
        panel.setBackground(Color.LIGHT_GRAY);
        
        //adding number and operators
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(add);
        
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sub);
        
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mul);
        
        panel.add(decimal);
        panel.add(numberButtons[0]);
        panel.add(equalsSign);
        panel.add(div);
        
        
        frame.add(panel);
        frame.add(textfield);
        frame.add(del);
        frame.add(clr);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args){
        Calculator calc=new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        
        //decimal k liye
        if(e.getSource()==decimal){
            textfield.setText(textfield.getText().concat("."));
        }
        
        //add operator
        if(e.getSource()==add){
            num1=Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }
        
         //sub operator
        if(e.getSource()==sub){
            num1=Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }
        
        //multiply
        if(e.getSource()==mul){
            num1=Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }
        
        //clear
        if(e.getSource()==clr){
            textfield.setText("");
        }
        
        //delete
        if(e.getSource()==del){
            String de=textfield.getText();
            textfield.setText("");
            for(int i=0;i<de.length()-1;i++){
                textfield.setText(textfield.getText()+de.charAt(i));
            }
        }
        
        //resulting equals
        if(e.getSource()==equalsSign){
            num2=Double.parseDouble(textfield.getText());
            switch(operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
            }
                textfield.setText(String.valueOf(result));
                num1=result;
            }
           
        }
    
}
