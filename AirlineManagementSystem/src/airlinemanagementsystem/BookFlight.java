package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener{

    JTextField CNICField;
    JLabel tfname, lbnationality, lbaddress,labelgender,labelfname,labelfcode;
    JButton bookflight,fetchButton,flight;
    Choice source, destination;
    JDateChooser ds;

    public BookFlight(){

        setTitle("Book Flight");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel titleLabel = new JLabel("Book Flight");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setBounds(420, 20, 500, 35);
        add(titleLabel);

        JLabel CNICNumber = new JLabel("CNIC ");
        CNICNumber.setBounds(60, 80, 150, 25);
        CNICNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(CNICNumber);

        CNICField = new JTextField();
        CNICField.setBounds(220, 80, 150, 25);
        add(CNICField);

        fetchButton=new JButton("Fetch User");
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

        JLabel nationalityLabel = new JLabel("Nationality");
        nationalityLabel.setBounds(60, 180, 150, 25);
        nationalityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nationalityLabel);

        lbnationality = new JLabel();
        lbnationality.setBounds(220, 180, 150, 25);
        add(lbnationality);

        JLabel jladdress = new JLabel("Address ");
        jladdress.setBounds(60, 230, 150, 25);
        jladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jladdress);

        lbaddress = new JLabel();
        lbaddress.setBounds(220, 230, 150, 25);
        add(lbaddress);

        JLabel jlgender= new JLabel("Gender ");
        jlgender.setBounds(60, 280, 150, 25);
        jlgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlgender);

        labelgender= new JLabel("Gender ");
        labelgender.setBounds(220, 280, 150, 25);
        labelgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelgender);

        JLabel jlsource = new JLabel("Source ");
        jlsource.setBounds(60, 330, 150, 25);
        jlsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlsource);

        source =new Choice();
        source.setBounds(220,330,150,25);
        add(source);

        JLabel jldest = new JLabel("Destination ");
        jldest.setBounds(60, 380, 150, 25);
        jldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jldest);

        destination =new Choice();
        destination.setBounds(220,380,150,25);
        add(destination);

        try {
            ConnectionDBMS c=new ConnectionDBMS();
            String query="select * from flight";
            ResultSet rs=c.s.executeQuery(query);

            while (rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        flight=new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380,380,120,25);
        flight.addActionListener(this);
        add(flight);

        JLabel jlname = new JLabel("Flight Name ");
        jlname.setBounds(60, 430, 150, 25);
        jlname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);

        JLabel jlcode = new JLabel("Flight Code");
        jlcode.setBounds(60, 480, 150, 25);
        jlcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);

        JLabel jldate = new JLabel("Date of Travel");
        jldate.setBounds(60, 530, 150, 25);
        jldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jldate);

        ds= new JDateChooser();
        ds.setBounds(220, 530, 150, 25);
        add(ds);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,320,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel jlimage =new JLabel(image);
        jlimage.setBounds(550,80,500,410);
        add(jlimage);

        bookflight =new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220,580,150,25);
        bookflight.addActionListener(this);
        add(bookflight);


        setSize(1100,670);
        setLocation(200,50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchButton) {
            String cnic = CNICField.getText();
            String gender = null;

            try {
                ConnectionDBMS con = new ConnectionDBMS();
                String query = "select * from passenger where cnic ='" + cnic + "'";
                ResultSet rs=con.s.executeQuery(query);
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    lbnationality.setText(rs.getString("nationality"));
                    lbaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));

                }
                else {
                    JOptionPane.showMessageDialog(null, "User does not exit");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource()==flight) {
            String src = source.getSelectedItem();
            String dest=destination.getSelectedItem();

            try {
                ConnectionDBMS con = new ConnectionDBMS();
                String query = "select * from flight where source='" + src + "' and destination='"+dest+"'";
                ResultSet rs=con.s.executeQuery(query);
                if(rs.next()){
                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else {
            Random random=new Random();
            String nic=CNICField.getText();
            String name = tfname.getText();
            String nationality=lbnationality.getText();
            String ad=lbaddress.getText();
            String fname =labelfname.getText();
            String fcode=labelfcode.getText();
            String scr= source.getSelectedItem();
            String des=destination.getSelectedItem();
            String date=((JTextField) ds.getDateEditor().getUiComponent()).getText();

            try {
                ConnectionDBMS con = new ConnectionDBMS();
                String query = "insert into reservation values('PNR-"+random.nextInt(100000)+"','TIC-"+random.nextInt(10000)+"','"+nic+"','"+ name +"','"+nationality+"','"+ fname +"','"+fcode+"','"+scr+"','"+des+"','"+date+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        new BookFlight();

    }
}
