import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.applet.*;

public class hardl5 extends JFrame
{
    JTextField t1, t2, t3, t4;
    JLabel j4;
    ButtonListener bl1;
    ButtonListener2 bl2;
    ButtonListener3 bl3;

    Random r=new Random();
    //setting random number in rand variable
    int rand=r.nextInt(1000);
    int count=0;

    public hardl5()
    {
        //Get the container
        Container c = getContentPane();

        //Set absolute layout
        c.setLayout(null);

        //Set Background Color
        c.setBackground(Color.WHITE);

        //Creating image
        JLabel lblpic = new JLabel("");
        lblpic.setIcon(new ImageIcon("images.png"));
        lblpic.setBounds(0,0,500,350);

        //Creating label Guess my number text
        JLabel j=new JLabel("Guess my number game");
        j.setForeground(Color.blue);
        j.setFont(new Font("tunga",Font.BOLD,24));
        j.setSize(600,40);
        j.setLocation(100,55);

        //Creating label Enter a number.....
        JLabel j1=new JLabel("Enter a number b/w 0-1000 within a single attempt!!");
        j1.setFont(new Font("tunga",Font.PLAIN,17));
        j1.setSize(800,40);
        j1.setLocation(200,75);

        //Creating TextField for input guess
        t1=new JTextField(10);
        t1.setSize(50,30);
        t1.setLocation(350,110);

        //Creating Label for Display message
        j4=new JLabel("Try and guess my number");
        j4.setFont(new Font("tunga",Font.PLAIN,17));
        j4.setSize(270,20);
        j4.setLocation(300,140);

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
        JButton b1=new JButton("Guess");
        b1.setSize(150,40);
        b1.setLocation(300,300);
        bl1=new ButtonListener();
        b1.addActionListener(bl1);


        JButton b2=new JButton("Give up!");
        b2.setSize(100,30);
        b2.setLocation(300,200);
        bl2=new ButtonListener2();
        b2.addActionListener(bl2);

        JButton b3=new JButton("Play Again");
        b3.setSize(120,30);
        b3.setLocation(300,250);
        bl3=new ButtonListener3();
        b3.addActionListener(bl3);


        //Place the components in the pane
        c.add(j5);
        c.add(j4);
        c.add(lblpic);
        c.add(j);
        c.add(j1);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(b1);
        c.add(b2);
        c.add(b3);
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
        int flag=0;
        public void actionPerformed(ActionEvent e)
        {
            int a = Integer.parseInt(t1.getText());
            count=count+1;
            if(a<rand)
            {
                j4.setText(a+" is too low, try again!!");
            }
            else if(a>rand)
            {
                j4.setText(a+" is too high, try again!!");
            }
            else
            {
                j4.setText("CORRECT, YOU WIN!!!!");
                flag=1;
                if(count<bestScore)
                {
                    bestScore=count;
                    t2.setText(bestScore+"");

                }
                else
                    t2.setText(""+bestScore);
                t1.setEditable(false);
            }
            if(count==1)
            {
                t1.setEditable(false);
            }
            if(flag==1)
            {
                try{
                    Statement st=null;
                    Connection con= DriverManager.getConnection("jdbc:ucanaccess//game.accdb");
                    st=con.createStatement();
                    String x="won this game in final level!!";
                    st.executeUpdate("insert into kamal1(status) values('"+x+"')");

                }
                catch(Exception exp)
                {

                }
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
            j4.setText(rand+" is the answer!");
            t1.setText("");
            t1.setEditable(false);
        }
    }

    private class ButtonListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            rand=r.nextInt(1000);
            t1.setText("");
            t3.setText("");
            j4.setText("Try and guess my number");
            t3.setText("");
            count=0;
            t1.setEditable(true);
            t1.requestFocus();
        }
    }

}

