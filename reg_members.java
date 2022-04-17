import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class reg_members extends JFrame implements ActionListener {
    JButton b1, b2, b4;
    JTextField t1, t2, t3, t4, t5, t6, t7,t8;
    JRadioButton rb1, rb2;
    ButtonGroup bg1;

    public reg_members() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/1.PNG")));
        setTitle("Register Members");
        setBounds(200, 50, 550, 650);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1 = new JLabel("REGISTRATION");
        l1.setBounds(160, 40, 400, 40);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setForeground(Color.black);
        add(l1);


        JLabel l2 = new JLabel("Name");
        l2.setBounds(30, 100, 100, 30);
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l2.setForeground(Color.black);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(140, 100, 250, 30);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(t1);

        JLabel l3 = new JLabel("Age");
        l3.setBounds(30, 140, 100, 30);
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l3.setForeground(Color.black);
        add(l3);

        t7 = new JTextField();
        t7.setBounds(140, 140, 60, 30);
        t7.setBackground(Color.white);
        add(t7);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(30, 180, 100, 30);
        l4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l4.setForeground(Color.black);
        add(l4);

        rb1 = new JRadioButton("Male");
        rb1.setBounds(140, 180, 100, 30);
        rb1.setBackground(Color.white);
        rb1.setForeground(Color.black);
        rb1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        rb1.setActionCommand("Male");
        add(rb1);

        rb2 = new JRadioButton("Female");
        rb2.setBounds(240, 180, 100, 30);
        rb2.setBackground(Color.white);
        rb2.setForeground(Color.black);
        rb2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        rb2.setActionCommand("Female");
        add(rb2);

        bg1 = new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);

        JLabel l5 = new JLabel("Email");
        l5.setBounds(30, 220, 100, 30);
        l5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l5.setForeground(Color.black);
        add(l5);

        t2 = new JTextField();
        t2.setBounds(140, 220, 250, 30);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(t2);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(30, 260, 100, 30);
        l6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l6.setForeground(Color.black);
        add(l6);

        t3 = new JTextField();
        t3.setBounds(140, 260, 250, 30);
        t3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(t3);

        JLabel l7 = new JLabel("Package id 1");
        l7.setBounds(30, 300, 150, 30);
        l7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l7.setForeground(Color.black);
        add(l7);
        t4 = new JTextField();
        t4.setBounds(140, 300, 150, 30);
        t4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(t4);

        JLabel l10 = new JLabel("Package id 2");
        l10.setBounds(30, 340, 150, 30);
        l10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l10.setForeground(Color.black);
        add(l10);

        t6 = new JTextField();
        t6.setBounds(140, 340, 150, 30);
        t6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(t6);

        JLabel l8 = new JLabel("Make Payment");
        l8.setBounds(30, 380, 200, 30);
        l8.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l8.setForeground(Color.black);
        add(l8);

        JLabel l9 = new JLabel("Add amount 1");
        l9.setBounds(30, 420, 200, 30);
        l9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l9.setForeground(Color.black);
        add(l9);

        t5 = new JTextField();
        t5.setBounds(150, 420, 150, 30);
        t5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(t5);

        JLabel l12 = new JLabel("Add amount 2");
        l12.setBounds(30, 460, 200, 30);
        l12.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        l12.setForeground(Color.black);
        add(l12);

        t8 = new JTextField();
        t8.setBounds(150, 460, 150, 30);
        t8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        add(t8);

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management","root","");
            if(con!=null) {
                st = con.createStatement();
                rs = st.executeQuery("SELECT * FROM packages WHERE Remaining IN(SELECT MIN(Remaining) FROM packages)");
                rs.next();
                JLabel l11 = new JLabel("MOST RUNNING: "+rs.getString(1));
                    l11.setBounds(30, 500, 200, 30);
                    l11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    l11.setForeground(Color.black);
                    add(l11);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        b1 = new JButton("Add");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        b1.setBounds(70, 540, 100, 35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Home");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        b2.setBounds(180, 540, 100, 35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b4 = new JButton("Back");
        b4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        b4.setBounds(290, 540, 100, 35);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        add(b4);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            boolean b = false;
            boolean c = false;
            String query = "SELECT * FROM packages WHERE (pkg_id ='"+t4.getText()+"'and amount='"+t5.getText()+"') OR (pkg_id ='"+t6.getText()+"'and amount='"+t8.getText()+"')";
            try {
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management","root","");
                st=con.createStatement();
                rs=st.executeQuery(query);
                if(rs.next()){
                    try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management", "root", "");
                    PreparedStatement add = con.prepareStatement("INSERT INTO members VALUES(?,?,?,?,?,?,?,?,?)");
                    add.setString(1, t1.getText());
                    add.setString(2, t7.getText());
                    add.setString(3, bg1.getSelection().getActionCommand());
                    add.setString(4, t2.getText());
                    add.setString(5, t3.getText());
                    add.setString(6, t4.getText());
                    add.setString(7, t6.getText());
                    add.setString(8, t5.getText());
                    add.setString(9, t8.getText());
                    int row = add.executeUpdate();
                    b = true;
                    c = true;

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                    if (b) {
                        if (t6.getText().equals("0")) {
                            try {
                                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management", "root", "");
                                PreparedStatement add1 = con.prepareStatement("INSERT INTO payments VALUES(?,?,?)");
                                add1.setString(1, t1.getText());
                                add1.setString(2, t4.getText());
                                add1.setString(3, t5.getText());
                                int row1 = add1.executeUpdate();

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management", "root", "");
                                PreparedStatement add1 = con.prepareStatement("INSERT INTO payments VALUES(?,?,?)");
                                add1.setString(1, t1.getText());
                                add1.setString(2, t4.getText());
                                add1.setString(3, t5.getText());
                                int row1 = add1.executeUpdate();

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            try {
                                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management", "root", "");
                                PreparedStatement add1 = con.prepareStatement("INSERT INTO payments VALUES(?,?,?)");
                                add1.setString(1, t1.getText());
                                add1.setString(2, t6.getText());
                                add1.setString(3, t8.getText());
                                int row1 = add1.executeUpdate();

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    if (c) {
                        String r1 = t4.getText();
                        String r2 = t6.getText();
                        try {
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management", "root", "");
                            PreparedStatement add = con.prepareStatement("update packages set Remaining = Remaining-1 where pkg_id = ?");
                            add.setString(1, r2);
                            int row = add.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Package updated successfully");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        try {
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management", "root", "");
                            PreparedStatement add = con.prepareStatement("update packages set Remaining = Remaining-1 where pkg_id = ?");
                            add.setString(1, r1);
                            int row = add.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Package updated successfully");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"Invalid package id or amount");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(b){

            }

        }
        else if(ae.getSource() == b2) {
                this.setVisible(false);
                new main_menu();
            }
        else if (ae.getSource() == b4) {
                this.setVisible(false);
                new members_details();
        }
        }
        public static void main (String[]args){
            new reg_members();
        }
    }

