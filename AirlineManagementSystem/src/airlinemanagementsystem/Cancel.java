package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;


public class Cancel extends JFrame implements ActionListener{

    JTextField PNRField;
    JLabel tfname, cancellationno, lbcode,labeldate;
    JButton fetchButton,flight;
    public Cancel(){

        setTitle("Cancel");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random r=new Random();
        JLabel titleLabel = new JLabel("CANCELLATION");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        titleLabel.setBounds(180, 20, 250, 35);
        add(titleLabel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2=imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(470,100,250,300);
        add(image);

        JLabel PNRNumber = new JLabel("PNR Number ");
        PNRNumber.setBounds(60, 80, 150, 25);
        PNRNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(PNRNumber);

        PNRField = new JTextField();
        PNRField.setBounds(220, 80, 150, 25);
        add(PNRField);

        fetchButton=new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,80,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(60, 130, 150, 25);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nameLabel);

        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);

        JLabel nationalityLabel = new JLabel(" Cancellation No");
        nationalityLabel.setBounds(55, 180, 150, 25);
        nationalityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nationalityLabel);

        cancellationno= new JLabel(" "+r.nextInt(1000000));
        cancellationno.setBounds(220, 180, 150, 25);
        add(cancellationno);

        JLabel jladdress = new JLabel("Flight Code ");
        jladdress.setBounds(60, 230, 150, 25);
        jladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jladdress);

        lbcode = new JLabel();
        lbcode.setBounds(220, 230, 150, 25);
        add(lbcode);

        JLabel jlgender= new JLabel("Date ");
        jlgender.setBounds(60, 280, 150, 25);
        jlgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlgender);

        labeldate= new JLabel();
        labeldate.setBounds(220, 280, 150, 25);
        labeldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeldate);

        flight=new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220,330,120,25);
        flight.addActionListener(this);
        add(flight);

        setSize(800,450);
        setLocation(400,150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchButton) {
            String pnr = PNRField.getText();
            String gender = null;

            try {
                ConnectionDBMS con = new ConnectionDBMS();
                String query = "select * from reservation where PNR ='" +pnr+ "'";
                ResultSet rs=con.s.executeQuery(query);
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    lbcode.setText(rs.getString("fcode"));
                    labeldate.setText(rs.getString("date"));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource()==flight) {
            String name = tfname.getText();
            String pnr=PNRField.getText();
            String cancelno=cancellationno.getText();
            String fcode=lbcode.getText();
            String date=labeldate.getText();

            try {
                ConnectionDBMS con = new ConnectionDBMS();
                String query = "insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
                con.s.executeUpdate(query);
                con.s.executeUpdate("delete from reservation where PNR='"+pnr+"'");
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Cancel();

    }
}

