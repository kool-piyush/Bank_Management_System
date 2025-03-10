import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    JTextField textName, textFname, textMname, EmailAdd, Address, City, PinCode, State;
    JDateChooser dateChooser;

    JRadioButton r1, r2, r3, m1, m2, m3;

    JButton next;
    String formno;

    //Randomly generate value
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    SignUp(String formno) {
        super("Application Form");

        ImageIcon bankImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image bankImg2 = bankImg1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankImg3 = new ImageIcon(bankImg2);
        JLabel image1 = new JLabel(bankImg3);
        image1.setBounds(30, 10, 100, 100);
        add(image1);

        // Heddings
        JLabel label1 = new JLabel("Application Form No." + first);
        label1.setFont(new Font("Raleway", Font.BOLD, 45));
        label1.setBounds(160, 30, 600, 60);
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway", Font.BOLD, 25));
        label2.setBounds(385, 84, 600, 40);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 25));
        label3.setBounds(340, 115, 600, 40);
        add(label3);

        // Name
        JLabel labelName = new JLabel("Name: ");
        labelName.setFont(new Font("Raleway", Font.BOLD, 15));
        labelName.setBounds(100, 170, 100, 40);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 15));
        textName.setBounds(300, 180, 400, 25);
        add(textName);

        //Father Name
        JLabel labelFName = new JLabel("Father Name:");
        labelFName.setFont(new Font("Raleway", Font.BOLD, 15));
        labelFName.setBounds(100, 220, 200, 40);
        add(labelFName);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway", Font.BOLD, 15));
        textFname.setBounds(300, 230, 400, 25);
        add(textFname);

        // Mother Name
        JLabel labelMName = new JLabel("Mother Name:");
        labelMName.setFont(new Font("Raleway", Font.BOLD, 15));
        labelMName.setBounds(100, 270, 200, 40);
        add(labelMName);

        textMname = new JTextField();
        textMname.setFont(new Font("Raleway", Font.BOLD, 15));
        textMname.setBounds(300, 280, 400, 25);
        add(textMname);

        // Date of Birth
        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 15));
        DOB.setBounds(100, 320, 200, 40);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 330, 400, 25);
        add(dateChooser);

        // Gender Radio button
        JLabel Gender = new JLabel("Gender:");
        Gender.setFont(new Font("Raleway", Font.BOLD, 15));
        Gender.setBounds(100, 370, 200, 40);
        add(Gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 15));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 380, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 15));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(380, 380, 90, 30);
        add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Raleway", Font.BOLD, 15));
        r3.setBackground(new Color(222, 255, 228));
        r3.setBounds(480, 380, 90, 30);
        add(r3);

        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(r1);
        btnGroup1.add(r2);
        btnGroup1.add(r3);

        // Email Address
        JLabel Email = new JLabel("Email Address:");
        Email.setFont(new Font("Raleway", Font.BOLD, 15));
        Email.setBounds(100, 420, 200, 40);
        add(Email);

        EmailAdd = new JTextField();
        EmailAdd.setFont(new Font("Raleway", Font.BOLD, 15));
        EmailAdd.setBounds(300, 430, 400, 25);
        add(EmailAdd);

        // Marrid Stutes
        JLabel marride = new JLabel("Married Status:");
        marride.setFont(new Font("Raleway", Font.BOLD, 15));
        marride.setBounds(100, 470, 200, 40);
        add(marride);

        m1 = new JRadioButton("Single");
        m1.setFont(new Font("Raleway", Font.BOLD, 15));
        m1.setBackground(new Color(222, 255, 228));
        m1.setBounds(300, 480, 80, 30);
        add(m1);

        m2 = new JRadioButton("Married");
        m2.setFont(new Font("Raleway", Font.BOLD, 15));
        m2.setBackground(new Color(222, 255, 228));
        m2.setBounds(380, 480, 90, 30);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setFont(new Font("Raleway", Font.BOLD, 15));
        m3.setBackground(new Color(222, 255, 228));
        m3.setBounds(480, 480, 90, 30);
        add(m3);

        ButtonGroup btnGroup2 = new ButtonGroup();
        btnGroup2.add(m1);
        btnGroup2.add(m2);
        btnGroup2.add(m3);

        // Address
        JLabel Addres = new JLabel("Address:");
        Addres.setFont(new Font("Raleway", Font.BOLD, 15));
        Addres.setBounds(100, 520, 200, 40);
        add(Addres);

        Address = new JTextField();
        Address.setFont(new Font("Raleway", Font.BOLD, 15));
        Address.setBounds(300, 530, 400, 25);
        add(Address);

        // City
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 15));
        city.setBounds(100, 570, 200, 40);
        add(city);

        City = new JTextField();
        City.setFont(new Font("Raleway", Font.BOLD, 15));
        City.setBounds(300, 580, 400, 25);
        add(City);

        // Pin code
        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 15));
        pinCode.setBounds(100, 630, 200, 15);
        add(pinCode);

        PinCode = new JTextField();
        PinCode.setFont(new Font("Raleway", Font.BOLD, 15));
        PinCode.setBounds(300, 630, 400, 25);
        add(PinCode);

        // State
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 15));
        state.setBounds(100, 670, 200, 40);
        add(state);

        State = new JTextField();
        State.setFont(new Font("Raleway", Font.BOLD, 15));
        State.setBounds(300, 680, 400, 25);
        add(State);

        // Next Button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBackground(Color.DARK_GRAY);
        next.setForeground(Color.white);
        next.setBounds(600, 720, 80, 30);
     next.addActionListener(this::actionPerformed);
        add(next);


        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 20);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = first;
        String name = textName.getText();
        String Fname = textFname.getText();
        String Mname = textMname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        } else if (r3.isSelected()) {
            gender = "Other";
        }
        String email = EmailAdd.getText();
        String married = null;
        if (m1.isSelected()) {
            married = "Single";
        } else if (m2.isSelected()) {
            married = "Married";
        } else if (m3.isSelected()) {
            married = "Other";
        }

        String address = Address.getText();
        String city = City.getText();
        String pincode = PinCode.getText();
        String state = State.getText();

        try {
            if (textName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
              Conn  con = new Conn();
                String q = "insert into signup values('" + formNo + "','" + name + "','" + Fname + "','" + Mname + "','" + dob + "','" + gender + "','" + email + "','" + married + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                con.statement.executeUpdate(q);
                new SignUp2(first);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp("");
    }

}
