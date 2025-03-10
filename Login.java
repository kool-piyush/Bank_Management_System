
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField;
    JPasswordField password;
    ResultSet resultset;

    JButton btn1, btn2, btn3;

    Login() {
        super("Bank Management System");

        ImageIcon bankImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image bankImg2 = bankImg1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankImg3 = new ImageIcon(bankImg2);
        JLabel image1 = new JLabel(bankImg3);
        image1.setBounds(360, 10, 100, 100);
        add(image1);

        ImageIcon cardImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image cardImg2 = cardImg1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon cardImg3 = new ImageIcon(cardImg2);
        JLabel image2 = new JLabel(cardImg3);
        image2.setBounds(630, 350, 100, 100);
        add(image2);


        label1 = new JLabel("Welcome to ATM");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 45));
        label1.setBounds(235, 125, 450, 40);
        add(label1);

        label2 = new JLabel("Card no: ");
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setForeground(Color.white);
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        textField = new JTextField(15);
        textField.setFont(new Font("Ralway", Font.BOLD, 15));
        textField.setBounds(320, 190, 230, 30);
        add(textField);


        label3 = new JLabel("Card Pin: ");
        label3.setFont(new Font("Arial", Font.BOLD, 28));
        label3.setForeground(Color.white);
        label3.setBounds(150, 250, 375, 30);
        add(label3);

        password = new JPasswordField(15);
        password.setFont(new Font("Arial", Font.BOLD, 15));
        password.setBounds(320, 250, 230, 30);
        add(password);

        btn1 = new JButton("Log in");
        btn1.setFont(new Font("Arial", Font.BOLD, 14));
        btn1.setForeground(Color.white);
        btn1.setBackground(Color.darkGray);
        btn1.setBounds(320, 300, 100, 30);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton("Sign up");
        btn2.setFont(new Font("Arial", Font.BOLD, 14));
        btn2.setForeground(Color.white);
        btn2.setBackground(Color.darkGray);
        btn2.setBounds(450, 300, 100, 30);
        btn2.addActionListener(this);
        add(btn2);

        btn3 = new JButton("Clear");
        btn3.setFont(new Font("Arial", Font.BOLD, 14));
        btn3.setForeground(Color.white);
        btn3.setBackground(Color.darkGray);
        btn3.setBounds(335, 350, 200, 30);
        btn3.addActionListener(this);
        add(btn3);


        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image bg2 = bg1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon bg3 = new ImageIcon(bg2);
        JLabel image3 = new JLabel(bg3);
        image3.setBounds(0, 0, 850, 480);
        add(image3);

        setSize(850, 480);
        setLocation(400, 200);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btn1) {


                Conn c = new Conn();
                String cardno = textField.getText();
                String pin = password.getText();
                String q = "select * from login where card_number = '" + cardno + "' and  pin = '" + pin + "'";
                ResultSet resultSet = c.statement.executeQuery(q);
//                if (resultSet.next()) {
                    setVisible(false);
                    new ATM(pin);
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
//                }


            } else if (e.getSource() == btn2) {


                new SignUp("");
                setVisible(false);
            } else if (e.getSource() == btn3) {

                textField.setText("");
                password.setText("");


            }
        } catch (Exception E) {
           E.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}
