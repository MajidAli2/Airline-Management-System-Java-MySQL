package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import  java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JournetDetails extends JFrame implements ActionListener {
    JTable table;
    JTextField pnr;
    JButton show;
    public JournetDetails(){

        setTitle("PNR Details");

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lbpnr=new JLabel("PNR Details");
        lbpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbpnr.setBounds(50,50,100,25);
        add(lbpnr);

        pnr =new JTextField();
        pnr.setBounds(160,50,120,25);
        add(pnr);

        show =new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,50,120,25);
        add(show);

        table=new JTable();

        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,100,800,150);
        sp.setBackground(Color.WHITE);
        show.addActionListener(this);
        add(sp);

        setSize(800,500);
        setLocation(400,150);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ConnectionDBMS co=new ConnectionDBMS();
            ResultSet rs=co.s.executeQuery("select*from reservation where PNR='"+pnr.getText()+"'");
            if (!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null,"No Information Found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception ae){
            ae.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new JournetDetails();
    }
}

