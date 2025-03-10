import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquary extends JFrame implements ActionListener {

    JLabel l2;
    JButton back;
    String pin;

    BalanceEnquary(String pin) {
        this.pin = pin;

        ImageIcon atmImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image atmImg2 = atmImg1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmImg3 = new ImageIcon(atmImg2);
        JLabel image1 = new JLabel(atmImg3);
        image1.setBounds(0, 0, 1550, 800);
        add(image1);

        JLabel l1 = new JLabel("Your Current Balance Is:");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.white);
        l1.setBounds(450, 160, 400, 35);
        image1.add(l1);

        l2 = new JLabel();
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.white);
        l2.setBounds(450, 195, 400, 35);
        image1.add(l2);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBackground(new Color(65, 125, 128));
        back.setForeground(Color.white);
        back.setBounds(700, 350, 150, 30);
        back.addActionListener(this);
        image1.add(back);

        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from deposit where pin = '" + pin + "'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("ammount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("ammount"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        l2.setText("" + balance);


        setLayout(null);
        setSize(1550, 980);
        setLocation(0, 0);
        setUndecorated(true);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new ATM(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquary("");
    }
}
