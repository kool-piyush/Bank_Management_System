import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM extends JFrame implements ActionListener {

    JButton deposit, fastCash, pinChange, cashWithdrowel, miniStatement, balanceEnqury, exit;
    String pin;
    ATM(String pin) {
        this.pin = pin;

        ImageIcon atmImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image atmImg2 = atmImg1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmImg3 = new ImageIcon(atmImg2);
        JLabel image1 = new JLabel(atmImg3);
        image1.setBounds(0, 0, 1550, 800);
        add(image1);

        JLabel l1 = new JLabel("Please select your transaction");
        l1.setFont(new Font("System", Font.BOLD, 23));
        l1.setForeground(Color.white);
        l1.setBounds(480, 160, 400, 35);
        image1.add(l1);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway", Font.BOLD, 10));
        deposit.setBackground(new Color(65,125,128));
        deposit.setForeground(Color.white);
        deposit.setBounds(420,260,150,30);
        deposit.addActionListener(this);
        image1.add(deposit);

        fastCash = new JButton("FAST CASH");
        fastCash.setFont(new Font("Raleway", Font.BOLD, 10));
        fastCash.setBackground(new Color(65,125,128));
        fastCash.setForeground(Color.white);
        fastCash.setBounds(420,305,150,30);
        fastCash.addActionListener(this);
        image1.add(fastCash);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setFont(new Font("Raleway", Font.BOLD, 10));
        pinChange.setBackground(new Color(65,125,128));
        pinChange.setForeground(Color.white);
        pinChange.setBounds(420,350,150,30);
        pinChange.addActionListener(this);
        image1.add(pinChange);

        cashWithdrowel = new JButton("CASH WITHDROWEL");
        cashWithdrowel.setFont(new Font("Raleway", Font.BOLD, 10));
        cashWithdrowel.setBackground(new Color(65,125,128));
        cashWithdrowel.setForeground(Color.white);
        cashWithdrowel.setBounds(700,260,150,30);
        cashWithdrowel.addActionListener(this);
        image1.add(cashWithdrowel);

        balanceEnqury = new JButton("BALANCE ENQURY");
        balanceEnqury.setFont(new Font("Raleway", Font.BOLD, 10));
        balanceEnqury.setBackground(new Color(65, 125, 128));
        balanceEnqury.setForeground(Color.white);
        balanceEnqury.setBounds(700, 305, 150, 30);
        balanceEnqury.addActionListener(this);
        image1.add(balanceEnqury);

        exit = new JButton("EXIT");
        exit.setFont(new Font("Raleway", Font.BOLD, 10));
        exit.setBackground(new Color(65, 125, 128));
        exit.setForeground(Color.white);
        exit.setBounds(700, 350, 150, 30);
        exit.addActionListener(this);
        image1.add(exit);




        setLayout(null);
        setSize(1550, 1030);
        setLocation(0, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit){
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == cashWithdrowel) {
            new Withdrowel(pin);
            setVisible(false);
        } else if (e.getSource() == balanceEnqury) {
            new BalanceEnquary(pin);
            setVisible(false);
        } else if (e.getSource() == fastCash) {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource() == pinChange) {
            new ChangePin(pin);
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new ATM("");
    }
}
