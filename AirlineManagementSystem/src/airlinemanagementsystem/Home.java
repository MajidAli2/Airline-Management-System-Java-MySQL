package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    public Home() {
        setTitle("Home");
        setLayout(null);
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.png"));
        JLabel image=new JLabel(il);
        image.setBounds(0,0,1400,700);
        add(image);
        JLabel heading=new JLabel("PIA PAKISTAN WELCOMES YOU");
        heading.setBounds(500,40,1000,40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
        image.add(heading);

        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        JMenu details=new JMenu("Details");
        menuBar.add(details);
        JMenuItem flightDetails=new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        JMenuItem customerDetails=new JMenuItem("Add Customer Dtails");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        JMenuItem bookFlight=new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        JMenuItem journeyDetalis=new JMenuItem("Journey Details");
        journeyDetalis.addActionListener(this);
        details.add(journeyDetalis);
        JMenuItem ticketCancelation=new JMenuItem("Cancel Ticket");
        ticketCancelation.addActionListener(this);
        details.add(ticketCancelation);

        JMenu ticket=new JMenu("Ticket");
        menuBar.add(ticket);
        JMenuItem boardingPass=new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text=e.getActionCommand();
        if(text.equals("Add Customer Dtails")){
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new Flight_info();
        } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JournetDetails();
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();
        } else if (text.equals("Boarding Pass")) {
            new BoardingPass();
        }

    }

    public static void main(String[] args) {

        new Home();
    }
}

