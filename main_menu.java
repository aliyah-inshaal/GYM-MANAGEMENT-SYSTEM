import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_menu extends JFrame implements ActionListener {
    JButton b1,b3,b4,b6,b7;

    main_menu(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/1.PNG")));
        setTitle("MAIN MENU");
        setBounds(235, 50, 790, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(310,120,150,150);
        add(l1);

        JLabel l2 = new JLabel("MAIN MENU");
        l2.setFont(new Font("ALGERIAN",Font.BOLD,50));
        l2.setForeground(Color.black);
        l2.setBounds(250,25,300,60);
        add(l2);

        b1 = new JButton("MEMBERS");
        b1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        b1.setBackground(Color.white);
        b1.setBounds(50,100,200,80);
        b1.addActionListener(this);
        add(b1);

        b3 = new JButton("PACKAGES");
        b3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        b3.setBackground(Color.white);
        b3.setBounds(520,100,200,80);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("USERS");
        b4.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        b4.setBackground(Color.white);
        b4.setBounds(50,200,200,80);
        b4.addActionListener(this);
        add(b4);

        b6 = new JButton("PAYMENTS");
        b6.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        b6.setBackground(Color.white);
        b6.setBounds(520,200,200,80);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("EXIT");
        b7.setFont(new Font("Times New Roman",Font.PLAIN,30));
        b7.setBounds(300,330,160,50);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        add(b7);


        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            this.setVisible(false);
            new members_details();
        }
        if(ae.getSource()==b3)
        {
            this.setVisible(false);
            new packages();
        }
        if(ae.getSource()==b4)
        {
            this.setVisible(false);
            new Users();
        }
        if(ae.getSource()==b6)
        {
            this.setVisible(false);
            new payment();
        }
        else if(ae.getSource()==b7)
        {
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new main_menu();
    }
}
