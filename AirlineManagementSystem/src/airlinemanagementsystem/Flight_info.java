package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import  java.sql.*;
import net.proteanit.sql.DbUtils;

public class Flight_info extends JFrame{
    public Flight_info(){

        setTitle("Flight Details");

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JTable table=new JTable();
        try {
            ConnectionDBMS co=new ConnectionDBMS();
            ResultSet rs=co.s.executeQuery("select*from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,0,800,500);
        add(sp);

        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {

        new JournetDetails();
    }
}
