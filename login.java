import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JButton b1;
    JButton b2;
    JTextField t1;
    JPasswordField t2;
    login(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/1.PNG")));
        setTitle("GYM MANAGEMENT");
        setBounds(235, 120, 500, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l2 = new JLabel("POWER ZONE");
        l2.setFont(new Font("ALGERIAN",Font.BOLD,30));
        l2.setForeground(Color.black);
        l2.setBounds(140,15,200,40);
        add(l2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(157,50,150,150);
        add(l1);

        JLabel l3 = new JLabel("Power, Fitness and Strength");
        l3.setFont(new Font("Mongolian Baiti",Font.BOLD,15));
        l3.setForeground(Color.black);
        l3.setBounds(140,200,200,30);
        add(l3);

        JLabel l4 = new JLabel("USERNAME");
        l4.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        l4.setForeground(Color.black);
        l4.setBounds(60,260,200,30);
        add(l4);

        JLabel l5 = new JLabel("PASSWORD");
        l5.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        l5.setForeground(Color.black);
        l5.setBounds(60,300,200,30);
        add(l5);


        t1 = new JTextField();
        t1.setBounds(180,260,200,30);
        t1.setFont(new Font("Times New Roman",Font.PLAIN,18));
        add(t1);


        t2 = new JPasswordField();
        t2.setBounds(180,300,200,30);
        t2.setFont(new Font("Times New Roman",Font.PLAIN,18));
        add(t2);


        b1 = new JButton("LOGIN");
        b1.setBounds(100,350,100,30);
        b1.setFont(new Font("Mongolian Baiti",Font.BOLD,15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);


        b2 = new JButton("EXIT");
        b2.setBounds(250,350,100,30);
        b2.setFont(new Font("Mongolian Baiti",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            String query = "SELECT * FROM users WHERE Username='"+t1.getText()+"'and password='"+t2.getText()+"'";
            try {
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management","root","");
                st=con.createStatement();
                rs=st.executeQuery(query);
                if(rs.next()){
                    this.setVisible(false);
                    new main_menu();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Wrong username or password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==b2)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
