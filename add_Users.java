import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class add_Users extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    public add_Users(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/1.PNG")));
        setTitle("Add Users");
        setBounds(230, 50, 380, 350);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1 = new JLabel("ADD USERS");
        l1.setBounds(70,40,400,40);
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(Color.black);
        add(l1);


        JLabel l2 = new JLabel("Username");
        l2.setBounds(30,100,100,30);
        l2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l2.setForeground(Color.black);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(140,100,150,30);
        t1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(t1);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(30,140,100,30);
        l3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l3.setForeground(Color.black);
        add(l3);

        t2 = new JPasswordField();
        t2.setBounds(140,140,150,30);
        t2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(t2);

        b1 = new JButton("Add");
        b1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.setBounds(60,200,100,35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Home");
        b2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b2.setBounds(170,200,100,35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b3.setBounds(110,250,100,35);
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
                PreparedStatement add = con.prepareStatement("INSERT INTO users VALUES(?,?)");
                add.setString(1,t1.getText());
                add.setString(2,t2.getText());
                int row=add.executeUpdate();
                JOptionPane.showMessageDialog(this,"User added successfully");
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
            new Users();
        }
    }


    public static void main(String[] args) {
        new add_Users();
    }
}
