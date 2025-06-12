package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class AddCustomer extends JFrame implements ActionListener{

    JTextField nameField,nationalityField,CNICField, tfaddress,tfphone,tfemail;
    JRadioButton rbmale,rbfemale;

    public AddCustomer(){

        setTitle("ADD CUSTOMER");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel titleLabel = new JLabel("ADD CUSTOMER DETAILS");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setBounds(220, 20, 500, 35);
        add(titleLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(60, 80, 150, 25);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(220, 80, 150, 25);
        add(nameField);

        JLabel nationalityLabel = new JLabel("Nationality");
        nationalityLabel.setBounds(60, 130, 150, 25);
        nationalityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nationalityLabel);

        nationalityField = new JTextField();
        nationalityField.setBounds(220, 130, 150, 25);
        add(nationalityField);

        JLabel CNICNumber = new JLabel("CNIC Number ");
        CNICNumber.setBounds(60, 180, 150, 25);
        CNICNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(CNICNumber);

        CNICField = new JTextField();
        CNICField.setBounds(220, 180, 150, 25);
        add(CNICField);

        JLabel jladdress = new JLabel("Address ");
        jladdress.setBounds(60, 230, 150, 25);
        jladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);

        JLabel jlgender= new JLabel("Gender ");
        jlgender.setBounds(60, 280, 150, 25);
        jlgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlgender);

        ButtonGroup gendergroup=new ButtonGroup();

        rbmale=new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale =new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);

        JLabel jlphone = new JLabel("Phone Number");
        jlphone.setBounds(60, 330, 150, 25);
        jlphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel jlemail = new JLabel("Email");
        jlemail.setBounds(60, 380, 150, 25);
        jlemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jlemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 380, 150, 25);
        add(tfemail);

        JButton save=new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,440,150,30);
        save.addActionListener(this);
        add(save);

        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel jlimage =new JLabel(image);
        jlimage.setBounds(450,80,280,400);
        add(jlimage);


        setSize(900,550);
        setLocation(300,150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String name=nameField.getText();
        String nationality=nationalityField.getText();
        String cnic=CNICField.getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String gender=null;
        if (rbmale.isSelected()){
            gender="Male";
        }
        else {
            gender="Female";
        }
        try{
            ConnectionDBMS con=new ConnectionDBMS();
            String query="insert into passenger values('"+name+"','"+nationality+"','"+cnic+"','"+address+"','"+phone+"','"+email+"','"+gender+"')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
            setVisible(false);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new AddCustomer();

    }
}
