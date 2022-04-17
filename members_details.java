import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class members_details extends JFrame implements ActionListener {
    JTable table;
    JButton b1,b2,b3;
    public String[][] data = new String[20][10];
    String[] columnNames = { "Name", "Age", "Gender","Email","Phone","Package id 1","Package id 2","Payment 1","Payment 2" };
    Connection con = null;
    Statement st = null;
    ResultSet RS = null;

    public members_details(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/1.PNG")));
        setTitle("Members Details");
        setBounds(235, 50, 790, 650);
        getContentPane().setBackground(Color.white);
        setLayout(new FlowLayout());

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management","root","");
            if(con!=null) {
                st = con.createStatement();
                RS = st.executeQuery("SELECT*from members");

                int i=0;
                while(RS.next()){
                    data[i][0]=RS.getString(1);
                    data[i][1]=RS.getString(2);
                    data[i][2]=RS.getString(3);
                    data[i][3]=RS.getString(4);
                    data[i][4]=RS.getString(5);
                    data[i][5]=RS.getString(6);
                    data[i][6]=RS.getString(7);
                    data[i][7]=RS.getString(8);
                    data[i][8]=RS.getString(9);
                    i++;
                }
                table=new JTable(data,columnNames);
                table.setPreferredScrollableViewportSize(new Dimension(700,500));
                table.setFillsViewportHeight(true);
                JScrollPane sp = new JScrollPane(table);
                add(sp);
                setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        b1 = new JButton("Register new");
        b1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b1.setBounds(140,700,150,45);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Home");
        b2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b2.setBounds(290,700,150,45);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Delete Member");
        b3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b3.setBounds(290,700,150,45);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            setVisible(false);
            new reg_members();
        }
        else if(ae.getSource()==b2){
            setVisible(false);
            new main_menu();
        }
        else if(ae.getSource()==b3){
            setVisible(false);
            new deleteMember();
        }
    }


    public static void main(String[] args) {
        new members_details();
    }
}
