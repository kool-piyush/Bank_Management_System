import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener {

    JButton changpin, back;
    JPasswordField p1, p2;

    String pin;

    ChangePin(String pin) {
        this.pin = pin;


        ImageIcon atmImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image atmImg2 = atmImg1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon atmImg3 = new ImageIcon(atmImg2);
        JLabel image1 = new JLabel(atmImg3);
        image1.setBounds(0, 0, 1550, 800);
        add(image1);

        JLabel l1 = new JLabel("Change Your Pin");
        l1.setFont(new Font("System", Font.BOLD, 25));
        l1.setForeground(Color.white);
        l1.setBounds(480, 160, 400, 35);
        image1.add(l1);

        JLabel l2 = new JLabel("Your New Pin");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.white);
        l2.setBounds(480, 200, 400, 35);
        image1.add(l2);

        p1 = new JPasswordField();
        p1.setFont(new Font("Arial", Font.BOLD, 15));
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.white);
        p1.setBounds(480, 230, 230, 30);
        add(p1);

        JLabel l3 = new JLabel("Re-Enter New Pin");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.white);
        l3.setBounds(480, 280, 400, 35);
        image1.add(l3);

        p2 = new JPasswordField();
        p2.setFont(new Font("Arial", Font.BOLD, 15));
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.white);
        p2.setBounds(480, 310, 230, 30);
        add(p2);

        changpin = new JButton("Change Pin");
        changpin.setFont(new Font("Raleway", Font.BOLD, 15));
        changpin.setBackground(new Color(65, 125, 128));
        changpin.setForeground(Color.white);
        changpin.setBounds(420, 400, 130, 30);
        changpin.addActionListener(this);
        image1.add(changpin);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBackground(new Color(65, 125, 128));
        back.setForeground(Color.white);
        back.setBounds(740, 400, 100, 30);
        back.addActionListener(this);
        image1.add(back);


        setLayout(null);
        setSize(1550, 1030);
        setLocation(0, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Enterd Pin Does Not Match");
                return;
            }
            if (e.getSource() == changpin) {
                if (p1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, " Enter New Pin");
                    return;
                }
                if (p2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, " Re-Enter New Pin");
                    return;
                }

                Conn c = new Conn();
                String q1 = "update deposit set pin = '" + pin1 + "' where pin = '" + pin + "'";
                String q2 = "update login set pin = '" + pin1 + "' where pin = '" + pin + "'";
                String q3 = "update signup3 set pin = '" + pin1 + "' where pin = '" + pin + "'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "Pin Change Successfully");
                setVisible(false);
                new ATM(pin);
                return;
            } else if (e.getSource() == back) {
                setVisible(false);
                new ATM(pin);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChangePin("");
    }
}
