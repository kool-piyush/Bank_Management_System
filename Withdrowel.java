import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrowel extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton Withdrowel, back;

    Withdrowel(String pin) {
        this.pin = pin;

        ImageIcon atmImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image atmImg2 = atmImg1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmImg3 = new ImageIcon(atmImg2);
        JLabel image1 = new JLabel(atmImg3);
        image1.setBounds(0, 0, 1550, 800);
        add(image1);

        JLabel l1 = new JLabel("Maximum Withdrowel is 10000");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.white);
        l1.setBounds(480, 160, 400, 35);
        image1.add(l1);

        JLabel l2 = new JLabel("Please Enter Your Ammount");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.white);
        l2.setBounds(480, 195, 400, 35);
        image1.add(l2);

        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.white);
        textField.setBounds(480, 230, 290, 22);
        textField.setFont(new Font("Raleway", Font.BOLD, 15));
        image1.add(textField);

        Withdrowel = new JButton("Withdrow");
        Withdrowel.setFont(new Font("Raleway", Font.BOLD, 15));
        Withdrowel.setBackground(new Color(65, 125, 128));
        Withdrowel.setForeground(Color.white);
        Withdrowel.setBounds(700, 350, 150, 30);
        Withdrowel.addActionListener(this);
        image1.add(Withdrowel);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBackground(new Color(65, 125, 128));
        back.setForeground(Color.white);
        back.setBounds(700, 400, 150, 30);
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
        if (e.getSource() == Withdrowel) {

            try {
                String ammount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter your Ammount! You want to Withdrow");

                } else {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from deposit Where pin = '"+pin+"'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("ammount"));
                        } else {
                            balance +=  Integer.parseInt(resultSet.getString("ammount"));
                        }
                    }
                    if (balance < Integer.parseInt(ammount)) {
                        JOptionPane.showMessageDialog(null, "Insuffisent balance");
                        return;
                    }
                    c.statement.executeUpdate("insert into deposit values('" + pin + "','" + date + "','Withdrowel','" + ammount + "')");
                    JOptionPane.showMessageDialog(null, "Rs." + ammount + " Withdrowel Successfully");
                    setVisible(false);
                    new ATM(pin);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back){
            setVisible(false);
            new ATM(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrowel("");
    }
}
