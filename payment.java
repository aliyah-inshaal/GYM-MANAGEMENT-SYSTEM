import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class payment extends JFrame implements ActionListener {
    JTable table;
    JButton b2;
    String[] columnNames = { "Member Name", "pkg_id", "amount"};
    public String[][] data = new String[20][10];
    Connection con = null;

    public payment(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/1.PNG")));
        setTitle("Payment");
        setBounds(200, 50, 650, 650);
        getContentPane().setBackground(Color.white);
        setLayout(new FlowLayout());

        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management","root","");
            if(con!=null) {
                Statement st = con.createStatement();
                ResultSet RS = st.executeQuery("SELECT*from payments");

                int i=0;
                while(RS.next()){
                    data[i][0]=RS.getString(1);
                    data[i][1]=RS.getString(2);
                    data[i][2]=RS.getString(3);
                    i++;
                }
                table=new JTable(data,columnNames);
                table.setPreferredScrollableViewportSize(new Dimension(600,500));
                table.setFillsViewportHeight(true);
                JScrollPane sp = new JScrollPane(table);
                add(sp);
                setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        b2 = new JButton("Home");
        b2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        b2.setBounds(180,700,150,45);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2)
        {
            this.setVisible(false);
            new main_menu();
        }
    }


    public static void main(String[] args) {
        new payment();
    }
}


