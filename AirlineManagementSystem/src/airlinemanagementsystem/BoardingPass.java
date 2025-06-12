package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BoardingPass extends JFrame implements ActionListener{

    JTextField tfpnr;
    JLabel tfname, lbnationality, lbsrc,labeldest,labelfname,labelfcode,labeldate;
    JButton fetchButton;

    public BoardingPass(){

        setTitle("Boarding Pass");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel titleLabel = new JLabel("PIA PAKISTSN");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        titleLabel.setBounds(380, 10, 450, 35);
        add(titleLabel);

        JLabel subLabel = new JLabel("Boarding Pass");
        subLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subLabel.setForeground(Color.BLUE);
        subLabel.setBounds(360, 50, 300, 30);
        add(subLabel);

        JLabel CNICNumber = new JLabel("PNR Details ");
        CNICNumber.setBounds(60, 100, 150, 25);
        CNICNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(CNICNumber);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);

        fetchButton=new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,100,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setBounds(60, 140, 150, 25);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nameLabel);

        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);

        JLabel nationalityLabel = new JLabel("NATIONALITY");
        nationalityLabel.setBounds(60, 180, 150, 25);
        nationalityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nationalityLabel);

        lbnationality = new JLabel();
        lbnationality.setBounds(220, 180, 150, 25);
        add(lbnationality);

        JLabel jladdress = new JLabel("SOURCE ");
        jladdress.setBounds(60, 220, 150, 25);
        jladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jladdress);

        lbsrc = new JLabel();
        lbsrc.setBounds(220, 220, 150, 25);
        add(lbsrc);

        JLabel jlgender= new JLabel("DESTINATION ");
        jlgender.setBounds(380, 220, 150, 25);
        jlgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlgender);

        labeldest= new JLabel();
        labeldest.setBounds(540, 220, 150, 25);
        labeldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeldest);

        JLabel jlname = new JLabel("Flight Name ");
        jlname.setBounds(60, 260, 150, 25);
        jlname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);

        JLabel jlcode = new JLabel("Flight Code");
        jlcode.setBounds(380, 260, 150, 25);
        jlcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);

        JLabel jldate = new JLabel("Date ");
        jldate.setBounds(60, 300, 150, 25);
        jldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jldate);

        labeldate= new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/piapakistan.png"));
        Image i2=i1.getImage().getScaledInstance(300,230,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel jlimage =new JLabel(image);
        jlimage.setBounds(600,0,300,350);
        add(jlimage);

        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

           String pnr = tfpnr.getText();
            String gender = null;

            try {
                ConnectionDBMS con = new ConnectionDBMS();
                String query = "select * from reservation where PNR ='"+pnr+"'";
                ResultSet rs=con.s.executeQuery(query);
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    lbnationality.setText(rs.getString("nationality"));
                    lbsrc.setText(rs.getString("scr"));
                    labeldest.setText(rs.getString("des"));
                    labelfname.setText(rs.getString("fname"));
                    labelfcode.setText(rs.getString("fcode"));
                    labeldate.setText(rs.getString("date"));

                }
                else {
                    JOptionPane.showMessageDialog(null, "User does not exit");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public static void main(String[] args) {
        new BoardingPass();

    }
}

