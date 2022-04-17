import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class delete_pkg extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1;
    public delete_pkg(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/1.PNG")));
        setTitle("Delete Package");
        setBounds(230, 50, 400, 350);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1 = new JLabel("DELETE PACKAGE");
        l1.setBounds(45,40,400,40);
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(Color.black);
        add(l1);

        JLabel l2 = new JLabel("Package id");
        l2.setBounds(30,130,150,40);
        l2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        l2.setForeground(Color.black);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(160,130,150,30);
        t1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(t1);


        b1 = new JButton("Delete");
        b1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.setBounds(70,200,100,35);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Home");
        b2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b2.setBounds(180,200,100,35);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b3.setBounds(120,250,100,35);
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
            String query = "SELECT * FROM packages WHERE pkg_id='"+t1.getText()+"'";
            try {
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management","root","");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(query);
                if(rs.next()){
                    try {
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management","root","");
                    PreparedStatement add = con.prepareStatement("Delete FROM packages WHERE pkg_id=?");
                    add.setString(1,t1.getText());
                    int row=add.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Package Deleted successfully");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                }
                else{
                    JOptionPane.showMessageDialog(this,"Package not found");
                }
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
        new delete_pkg();
    }
}
