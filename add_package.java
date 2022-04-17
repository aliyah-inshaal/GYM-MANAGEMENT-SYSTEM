import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class add_package extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1,t2,t3,t4,t5,t6;
    public add_package(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/1.PNG")));
        setTitle("Add Packages");
        setBounds(200, 50, 400, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1 = new JLabel("ADD PACKAGES");
        l1.setBounds(50,40,400,40);
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(Color.black);
        add(l1);


        JLabel l2 = new JLabel("Package id");
        l2.setBounds(30,100,100,30);
        l2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l2.setForeground(Color.black);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(140,100,150,30);
        t1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(t1);

        JLabel l3 = new JLabel("Type");
        l3.setBounds(30,140,100,30);
        l3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l3.setForeground(Color.black);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(140,140,150,30);
        t2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(t2);

        JLabel l4 = new JLabel("Duration");
        l4.setBounds(30,180,100,30);
        l4.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l4.setForeground(Color.black);
        add(l4);

        t5 = new JTextField();
        t5.setBounds(140,180,150,30);
        t5.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(t5);

        JLabel l5 = new JLabel("Sessions");
        l5.setBounds(30,220,100,30);
        l5.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l5.setForeground(Color.black);
        add(l5);

        t4 = new JTextField();
        t4.setBounds(140,220,150,30);
        t4.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(t4);

        JLabel l6 = new JLabel("Fees");
        l6.setBounds(30,260,100,30);
        l6.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l6.setForeground(Color.black);
        add(l6);

        t3 = new JTextField();
        t3.setBounds(140,260,150,30);
        t3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(t3);

        JLabel l7 = new JLabel("Remaining");
        l7.setBounds(30,300,100,30);
        l7.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l7.setForeground(Color.black);
        add(l7);

        t6 = new JTextField();
        t6.setBounds(140,300,150,30);
        t6.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(t6);

        b1 = new JButton("Add");
        b1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.setBounds(60,360,100,35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Home");
        b2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b2.setBounds(170,360,100,35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b3.setBounds(110,420,100,35);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);


        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    Connection con = null;

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            try {
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management","root","");
                PreparedStatement add = con.prepareStatement("INSERT INTO packages VALUES(?,?,?,?,?,?)");
                add.setString(1,t1.getText());
                add.setString(2,t2.getText());
                add.setString(3,t5.getText());
                add.setString(4,t4.getText());
                add.setString(5,t3.getText());
                add.setString(6,t6.getText());
                int row=add.executeUpdate();
                JOptionPane.showMessageDialog(this,"Package added successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b2)
        {
            this.setVisible(false);
            new main_menu();
        }
        else if(ae.getSource()==b3)
        {
            this.setVisible(false);
            new packages();
        }
    }


    public static void main(String[] args) {
        new add_package();
    }
}
