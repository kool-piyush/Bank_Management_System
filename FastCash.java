import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {


    JButton Rs100, Rs500, Rs1000, Rs2000, Rs5000, Rs10000, Back;
    String pin;

    FastCash(String pin) {
        this.pin = pin;

        ImageIcon atmImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image atmImg2 = atmImg1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmImg3 = new ImageIcon(atmImg2);
        JLabel image1 = new JLabel(atmImg3);
        image1.setBounds(0, 0, 1550, 800);
        add(image1);

        JLabel l1 = new JLabel("Select Withdrowel Ammount");
        l1.setFont(new Font("System", Font.BOLD, 23));
        l1.setForeground(Color.white);
        l1.setBounds(480, 160, 400, 35);
        image1.add(l1);

        Rs100 = new JButton("Rs. 100");
        Rs100.setFont(new Font("Raleway", Font.BOLD, 10));
        Rs100.setBackground(new Color(65, 125, 128));
        Rs100.setForeground(Color.white);
        Rs100.setBounds(420, 260, 150, 30);
        Rs100.addActionListener(this);
        image1.add(Rs100);

        Rs500 = new JButton("Rs. 500");
        Rs500.setFont(new Font("Raleway", Font.BOLD, 10));
        Rs500.setBackground(new Color(65, 125, 128));
        Rs500.setForeground(Color.white);
        Rs500.setBounds(420, 300, 150, 30);
        Rs500.addActionListener(this);
        image1.add(Rs500);

        Rs1000 = new JButton("Rs. 1000");
        Rs1000.setFont(new Font("Raleway", Font.BOLD, 10));
        Rs1000.setBackground(new Color(65, 125, 128));
        Rs1000.setForeground(Color.white);
        Rs1000.setBounds(420, 340, 150, 30);
        Rs1000.addActionListener(this);
        image1.add(Rs1000);

        Rs2000 = new JButton("Rs. 2000");
        Rs2000.setFont(new Font("Raleway", Font.BOLD, 10));
        Rs2000.setBackground(new Color(65, 125, 128));
        Rs2000.setForeground(Color.white);
        Rs2000.setBounds(700, 260, 150, 30);
        Rs2000.addActionListener(this);
        image1.add(Rs2000);

        Rs5000 = new JButton("Rs. 5000");
        Rs5000.setFont(new Font("Raleway", Font.BOLD, 10));
        Rs5000.setBackground(new Color(65, 125, 128));
        Rs5000.setForeground(Color.white);
        Rs5000.setBounds(700, 300, 150, 30);
        Rs5000.addActionListener(this);
        image1.add(Rs5000);

        Rs10000 = new JButton("Rs. 10000");
        Rs10000.setFont(new Font("Raleway", Font.BOLD, 10));
        Rs10000.setBackground(new Color(65, 125, 128));
        Rs10000.setForeground(Color.white);
        Rs10000.setBounds(700, 345, 150, 30);
        Rs10000.addActionListener(this);
        image1.add(Rs10000);

        Back = new JButton("Back");
        Back.setFont(new Font("Raleway", Font.BOLD, 10));
        Back.setBackground(new Color(65, 125, 128));
        Back.setForeground(Color.white);
        Back.setBounds(700, 385, 150, 30);
        Back.addActionListener(this);
        image1.add(Back);


        setLayout(null);
        setSize(1550, 1030);
        setLocation(0, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            new ATM(pin);
        } else {
            String ammount = ((JButton) e.getSource()).getText().substring(4);
            Conn c = new Conn();
            Date date = new Date();

            try {

                ResultSet resultSet = c.statement.executeQuery("select * from deposit where pin = '"+pin+"'");
                int balance = 0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("ammount"));
                    } else {
                        balance -=  Integer.parseInt(resultSet.getString("ammount"));
                    }
                }

                if (e.getSource() != Back && balance < Integer.parseInt(ammount)) {
                    JOptionPane.showMessageDialog(null, "Insuffisent balance");
                    return;
                }

                c.statement.executeUpdate("insert into deposit values('"+pin +"','"+ date+"','Withdrowel', '"+ammount +"')");
                JOptionPane.showMessageDialog(null, "Rs. "+ ammount + "Withdrowel Successfully");

            } catch (Exception E) {
                E.printStackTrace();
            }
            setVisible(false);
            new ATM(pin);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
