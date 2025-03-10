import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {


    String pin;
    TextField textField;
    JButton deposit,back;

    Deposit(String pin) {
        super("Deposit ATM");
        this.pin = pin;

        ImageIcon atmImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image atmImg2 = atmImg1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmImg3 = new ImageIcon(atmImg2);
        JLabel image1 = new JLabel(atmImg3);
        image1.setBounds(0, 0, 1550, 800);
        add(image1);

        JLabel l1 = new JLabel("Enter Ammount You Want To Deposit");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setForeground(Color.white);
        l1.setBounds(480,160,400,35);
        image1.add(l1);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setBounds(480,210,290,22);
        textField.setFont(new Font("Raleway",Font.BOLD,15));
        image1.add(textField);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway", Font.BOLD, 15));
        deposit.setBackground(new Color(65,125,128));
        deposit.setForeground(Color.white);
        deposit.setBounds(740,350,100,30);
        deposit.addActionListener(this);
        image1.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBackground(new Color(65,125,128));
        back.setForeground(Color.white);
        back.setBounds(740,400,100,30);
        back.addActionListener(this);
        image1.add(back);


        setLayout(null);
        setSize(1550, 980);
        setLocation(0, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String ammount = textField.getText();
            Date date = new Date();
            if (e.getSource() == deposit){
                if (textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your Ammount! You want to deposit");
                }else {
                    Conn c = new Conn();
                    c.statement.executeUpdate("insert into deposit values('"+pin +"','"+date +"','Deposit','"+ammount +"' )");
                    JOptionPane.showMessageDialog(null, "Rs. " + ammount + " Deposit Successfully");
                    setVisible(false);
                    new ATM(pin);
                }
            } else if (e.getSource() == back) {
                setVisible(false);
                new ATM(pin);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
