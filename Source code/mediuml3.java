import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;

public class mediuml3 extends JFrame
{
    JTextField t1, t2, t3, t4,t5,t6;
    JLabel j4,jy;
    //jy is the label for b
    ButtonListener bl1;
    ButtonListener2 bl2;
    ButtonListener3 bl3;
    ButtonListener4 bl4;
    ButtonListener5 bl5;
    ButtonListener6 bl6;


    Random r=new Random();
    Random r1=new Random();
    int a11=r.nextInt(100);
    int b11=r1.nextInt(100);
    //setting random number in rand variable
    int rand=a11-b11;
    int count=0;

    public mediuml3()
    {
        //Get the container
        Container c = getContentPane();

        //Set absolute layout
        c.setLayout(null);

        //Set Background Color
        c.setBackground(Color.WHITE);


        //Creating label Guess my number text
        JLabel j=new JLabel("Guess my number game");
        j.setForeground(Color.blue);
        j.setFont(new Font("tunga",Font.BOLD,24));
        j.setSize(350,40);
        j.setLocation(300,35);

        //Creating label Enter a number.....
        JLabel j1=new JLabel("Enter a number b/w 0-100");
        j1.setFont(new Font("tunga",Font.PLAIN,17));
        j1.setSize(300,20);
        j1.setLocation(350,200);

        JLabel jx=new JLabel("Enter b number b/w 0-100");
        jx.setFont(new Font("tunga",Font.PLAIN,17));
        jx.setSize(270,20);
        jx.setLocation(350,400);
        c.add(jx);
        JLabel jz=new JLabel("Your difference (a-b) values are:"+rand+"Find the a=? & b=? values!!");
        jz.setForeground(Color.orange);
        jz.setFont(new Font("serif",Font.BOLD,24));
        jz.setSize(800,40);
        jz.setLocation(100,105);
        c.add(jz);

        //Creating TextField for input guess
        t1=new JTextField(10);
        t1.setSize(50,30);
        t1.setLocation(350,220);

        t4=new JTextField(10);
        t4.setSize(50,30);
        t4.setLocation(350,420);

        //Creating Label for Display message
        j4=new JLabel("Try and guess my a value!!");

        j4.setSize(270,20);
        j4.setLocation(350,250);

        jy=new JLabel("Try and guess my b value!!");

        jy.setSize(270,20);
        jy.setLocation(350,450);

        //Creating Text field for best score
        t2=new JTextField(10);
        t2.setSize(40,20);
        t2.setLocation(10,10);

        //Creating Label for best score
        JLabel j5=new JLabel("Best Score");
        j5.setFont(new Font("tunga",Font.PLAIN,17));
        j5.setSize(270,20);
        j5.setLocation(60,10);

        //Creating guess text field
        t3=new JTextField(10);
        t3.setSize(40,20);
        t3.setLocation(160,10);

        //Creating guess Label
        JLabel j6=new JLabel("Guesses");
        j6.setFont(new Font("tunga",Font.PLAIN,17));
        j6.setSize(270,20);
        j6.setLocation(210,10);

        //creating 3 buttons
        JButton b1=new JButton("Guess a value");
        b1.setSize(150,40);
        b1.setLocation(300,300);
        bl1=new ButtonListener ();
        b1.addActionListener(bl1);

        JButton bx=new JButton("Guess b value:");
        bx.setSize(150,40);
        bx.setLocation(300,500);
        bl4 = new ButtonListener4();
        bx.addActionListener(bl4);

        JButton b2=new JButton("Give up for a!");
        b2.setSize(150,30);
        b2.setLocation(180,200);
        bl2=new ButtonListener2();
        b2.addActionListener(bl2);

        JButton by=new JButton("Give up for b!");
        by.setSize(150,30);
        by.setLocation(180,400);
        bl5=new ButtonListener5();
        by.addActionListener(bl5);

        JButton b3=new JButton("Play Again for a!");
        b3.setSize(150,30);
        b3.setLocation(180,250);
        bl3=new ButtonListener3();
        b3.addActionListener(bl3);

        JButton bz=new JButton("Play Again for b!");
        bz.setSize(150,30);
        bz.setLocation(180,450);
        bl6=new ButtonListener6();
        bz.addActionListener(bl6);

        //Place the components in the pane
        c.add(j5);
        c.add(j4);
        c.add(jy);
        c.add(j);
        c.add(j1);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(t4);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(bx);
        c.add(by);
        c.add(bz);
        c.add(j6);

        //Changing TextFields to UnEditable
        t2.setEditable(false);
        t3.setEditable(false);

        //Set the title of the window
        setTitle("GUESS MY NUMBER");

        //Set the size of the window and display it
        setSize(1000,1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener
    {
        int bestScore=100;

        public void actionPerformed(ActionEvent e)
        {
            int a = Integer.parseInt(t1.getText());
            count=count+1;
            if(a<a11)
            {
                j4.setText(a+" is too low, try again!!");
            }
            else if(a>a11)
            {
                j4.setText(a+" is too high, try again!!");
            }
            else
            {
                j4.setText("CORRECT, YOU WIN!!!!");
                if(count<bestScore)
                {
                    bestScore=count;
                    t2.setText(bestScore+"");
                }
                else
                    t2.setText(""+bestScore);
                t1.setEditable(false);
            }

            //setting focus to input guess text field
            t1.requestFocus();
            t1.selectAll();

            t3.setText(count+"");
        }
    }

    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            t3.setText("");
            j4.setText(a11+" is the answer!");
            t1.setText("");
            t1.setEditable(false);
        }
    }

    private class ButtonListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            rand=r.nextInt(100);
            t1.setText("");
            t3.setText("");
            j4.setText("Try and guess my number");
            t3.setText("");
            count=0;
            t1.setEditable(true);
            t1.requestFocus();
        }
    }
    private class ButtonListener4 implements ActionListener
    {
        int bestScore=100;

        public void actionPerformed(ActionEvent e)
        {
            int b = Integer.parseInt(t4.getText());
            count=count+1;
            if(b<b11)
            {
                jy.setText(b+" is too low, try again!!");
            }
            else if(b>b11)
            {
                jy.setText(b+" is too high, try again!!");
            }
            else
            {
                jy.setText("CORRECT, YOU WIN!!!!");
                if(count<bestScore)
                {
                    bestScore=count;
                    t2.setText(bestScore+"");
                }
                else
                    t2.setText(""+bestScore);
                t4.setEditable(false);
            }

            //setting focus to input guess text field
            t4.requestFocus();
            t4.selectAll();

            t3.setText(count+"");
        }
    }
    private class ButtonListener5 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            t3.setText("");
            jy.setText(b11+" is the answer!");
            t4.setText("");
            t4.setEditable(false);
        }
    }

    private class ButtonListener6 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            rand=r.nextInt(100);
            t4.setText("");
            t3.setText("");
            jy.setText("Try and guess my number");
            t3.setText("");
            count=0;
            t4.setEditable(true);
            t4.requestFocus();
        }
    }


}

