
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;
import java.sql.*;

public class guess extends Frame implements ActionListener
{
    Frame f;
    Button el1,el2,el3,el4,el5,ml1,ml2,ml3,ml4,ml5, hl1,hl2,hl3,hl4,hl5,btn;
    Label lbl,lbl1,lbl2;
    TextField txtname;
    guess()
    {
        f=new Frame("Guessing number game");
        f.setSize(1000,900);
        f.setLayout(null);
        f.setVisible(true);
        f.setBackground(Color.lightGray);
        lbl=new Label("Enter your name here:");
        lbl.setFont(new Font("serif",Font.BOLD,20));
        lbl.setBounds(100,400,200,20);
        f.add(lbl);
	btn=new Button("yes");
	btn.setBounds(550,400,80,30);
	f.add(btn);
	btn.addActionListener(this);
        lbl2=new Label("Note: Before starting the game enter your name and click 'yes' then start your game");
        lbl2.setBounds(5,500,1000,40);
        lbl2.setFont(new Font("serif",Font.BOLD,25));
        f.add(lbl2);
        lbl1=new Label("EASY                   MEDIUM                    HARD");
        lbl1.setFont(new Font("serif",Font.BOLD,20));
	lbl1.setBounds(10,50,800,50);
        f.add(lbl1);
        txtname=new TextField();
        txtname.setBounds(300,400,200,30);
        f.add(txtname);
        txtname.addActionListener(this);

        el1=new Button("Easy level 1");
	el1.setFont(new Font("serif",Font.BOLD,15));
        el1.setBounds(10,100,100,50);
        f.add(el1);
        el1.setBackground(Color.orange);

        el2=new Button("Easy level 2");
	el2.setFont(new Font("serif",Font.BOLD,15));
        el2.setBounds(10,150,100,50);
        f.add(el2);
        el2.setBackground(Color.orange);

        el3=new Button("Easy level 3");
	el3.setFont(new Font("serif",Font.BOLD,15));
        el3.setBounds(10,200,100,50);
        f.add(el3);
        el3.setBackground(Color.orange);
        el4=new Button("Easy level 4");
        el4.setFont(new Font("serif",Font.BOLD,15));
	el4.setBounds(10,250,100,50);
        f.add(el4);
        el4.setBackground(Color.orange);
        el5=new Button("Easy level 5");
        el5.setFont(new Font("serif",Font.BOLD,15));
	el5.setBounds(10,300,100,50);
        f.add(el5);
        el5.setBackground(Color.orange);
        el1.addActionListener(this);
        el2.addActionListener(this);
        el3.addActionListener(this);
        el4.addActionListener(this);
        el5.addActionListener(this);


        ml1=new Button("Medium Level 1");
	ml1.setFont(new Font("serif",Font.BOLD,15));
        ml1.setBounds(150,100,120,50);
        f.add(ml1);
        ml1.setBackground(Color.blue);
        ml2=new Button("Medium Level 2");
        ml2.setFont(new Font("serif",Font.BOLD,15));
	ml2.setBounds(150,150,120,50);
        f.add(ml2);
        ml2.setBackground(Color.blue);
        ml3=new Button("Medium Level 3");
        ml3.setFont(new Font("serif",Font.BOLD,15));
	ml3.setBounds(150,200,120,50);
        f.add(ml3);
        ml3.setBackground(Color.blue);
        ml4=new Button("Medium Level 4");
	ml4.setFont(new Font("serif",Font.BOLD,15));
        ml4.setBounds(150,250,120,50);
        f.add(ml4);
        ml4.setBackground(Color.blue);

        ml5=new Button("Medium Level 5");
	ml5.setFont(new Font("serif",Font.BOLD,15));
        ml5.setBounds(150,300,120,50);
        f.add(ml5);
        ml5.setBackground(Color.blue);
        ml1.addActionListener(this);
        ml2.addActionListener(this);
        ml3.addActionListener(this);
        ml4.addActionListener(this);
        ml5.addActionListener(this);




        hl1=new Button("Hard level 1");
	hl1.setFont(new Font("serif",Font.BOLD,15));
        hl1.setBounds(300,100,100,50);
        f.add(hl1);
        hl1.setBackground(Color.green);
        hl2=new Button("Hard level 2");
	hl2.setFont(new Font("serif",Font.BOLD,15));
        hl2.setBounds(300,150,100,50);
        f.add(hl2);
        hl2.setBackground(Color.green);

        hl3=new Button("Hard level 3");
	hl3.setFont(new Font("serif",Font.BOLD,15));
        hl3.setBounds(300,200,100,50);
        f.add(hl3);
        hl3.setBackground(Color.green);
        hl4=new Button("Hard level 4");
	hl4.setFont(new Font("serif",Font.BOLD,15));
        hl4.setBounds(300,250,100,50);
        f.add(hl4);
        hl4.setBackground(Color.green);
        hl5=new Button("Hard level 5");
	hl5.setFont(new Font("serif",Font.BOLD,15));
        hl5.setBounds(300,300,100,50);
        f.add(hl5);
        hl5.setBackground(Color.green);
        hl1.addActionListener(this);
        hl2.addActionListener(this);
        hl3.addActionListener(this);
        hl4.addActionListener(this);
        hl5.addActionListener(this);





    }
    public void actionPerformed(ActionEvent ae)
    {
             if(ae.getSource()==btn)
            {
                try{

                    Statement st=null;
                    
                    Connection con=DriverManager.getConnection("jdbc:ucanaccess://game.accdb");
			st=con.createStatement();
			String xyz=txtname.getText();
			st.executeUpdate("insert into kamal(name) values('"+xyz+"')");
			 }
                catch(Exception exp)
                {
                    System.out.println(exp);
                }
            }

            if(ae.getSource()==el1)
            {
                dispose();

                easyl1 ea1=new easyl1();
                ea1.setVisible(true);
                ea1.setSize(700,500);

            }
            if(ae.getSource()==el2)
            {
                dispose();

                easyl2 ea2=new easyl2();
                ea2.setVisible(true);
                ea2.setSize(700,500);

            }
            if(ae.getSource()==el3)
            {
                dispose();

                easyl3 ea3=new easyl3();
                ea3.setVisible(true);
                ea3.setSize(700,500);

            }
            if(ae.getSource()==el4)
            {
                dispose();

                easyl4 ea4=new easyl4();
                ea4.setVisible(true);
                ea4.setSize(700,500);

            }
            if(ae.getSource()==el5)
            {
                dispose();

                easyl5 ea5=new easyl5();
                ea5.setVisible(true);
                ea5.setSize(700,500);

            }

         if(ae.getSource()==ml1)
        {
            dispose();
            mediuml1 me1=new mediuml1();
            me1.setVisible(true);
            me1.setSize(800,800);

        }

        if(ae.getSource()==ml2)
        {
            dispose();
            mediuml2 me2=new mediuml2();
            me2.setVisible(true);
            me2.setSize(800,800);

        }
        if(ae.getSource()==ml3)
        {
            dispose();
            mediuml3 me3=new mediuml3();
            me3.setVisible(true);
            me3.setSize(800,800);

        }
        if(ae.getSource()==ml4)
        {
            dispose();
            mediuml4 me4=new mediuml4();
            me4.setVisible(true);
            me4.setSize(800,800);

        }
        if(ae.getSource()==ml5)
        {
            dispose();
            mediuml5 me5=new mediuml5();
            me5.setVisible(true);
            me5.setSize(800,800);

        }

        if(ae.getSource()==hl1)
            {
                dispose();

                hardl1 ha1=new hardl1();
                ha1.setVisible(true);
                ha1.setSize(600,700);

            }
            if(ae.getSource()==hl2)
            {
                dispose();

                hardl2 ha2=new hardl2();
                ha2.setVisible(true);
                ha2.setSize(700,700);

            }
            if(ae.getSource()==hl3)
            {
                dispose();

                hard3 ha3=new hard3();
                ha3.setVisible(true);
                ha3.setSize(800,700);

            }
            if(ae.getSource()==hl4)
            {
                dispose();

                hardl4 ha4=new hardl4();
                ha4.setVisible(true);
                ha4.setSize(900,700);

            }
            if(ae.getSource()==hl5)
            {
                dispose();

                hardl5 ha5=new hardl5();
                ha5.setVisible(true);
                ha5.setSize(1000,700);

            }

        }


    public static void main(String arg[])throws Exception
    {
        guess obj=new guess();
    }

}










