import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp2 extends JFrame implements ActionListener {
    String formno;
    JComboBox riligion,catagory,income,gradution,Occupation;
    JTextField panNO,aadharNO;
    JRadioButton r1,r2,r3,r4;
    JButton next;

    SignUp2(String formno){

        super("Application Form");
        this.formno=formno;

        ImageIcon bankImg1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image bankImg2 = bankImg1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankImg3 = new ImageIcon(bankImg2);
        JLabel image1 = new JLabel(bankImg3);
        image1.setBounds(150, 10, 100, 100);
        add(image1);


        JLabel label1 = new JLabel("Page 2 :-");
        label1.setFont(new Font("Raleway", Font.BOLD, 25));
        label1.setBounds(300, 30, 600, 60);
        add(label1);

        JLabel label2 = new JLabel("Additional Details");
        label2.setFont(new Font("Raleway", Font.BOLD, 25));
        label2.setBounds(300, 60, 600, 60);
        add(label2);

        JLabel lable3 = new JLabel("Religion:");
        lable3.setFont(new Font("Raleway", Font.BOLD, 20));
        lable3.setBounds(150, 160, 600, 40);
        add(lable3);

        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        riligion = new JComboBox(religion);
        riligion.setFont(new Font("Raleway", Font.BOLD, 15));
//        riligion.setBackground(new Color(156, 62, 0));
        riligion.setBounds(350,170,320,25);
        add(riligion);

        JLabel lable4 = new JLabel("Catagory:");
        lable4.setFont(new Font("Raleway", Font.BOLD, 20));
        lable4.setBounds(150, 210, 600, 40);
        add(lable4);

        String Catagory[] = {"Genral","OBC","HT","SC","Other"};
        catagory = new JComboBox(Catagory);
        catagory.setFont(new Font("Raleway", Font.BOLD, 15));
//        catagory.setBackground(new Color(156, 62, 0));
        catagory.setBounds(350,220,320,25);
        add(catagory);

        JLabel lable5 = new JLabel("Income:");
        lable5.setFont(new Font("Raleway", Font.BOLD, 20));
        lable5.setBounds(150, 260, 600, 40);
        add(lable5);

        String Income[] = {"0 to 20,000","20,000 to 50,000","1,00,000 to 2,00,000","2,50,000 to 500000","Upto 10,00,000"};
        income = new JComboBox(Income);
        income.setFont(new Font("Raleway", Font.BOLD, 15));
//        income.setBackground(new Color(156, 62, 0));
        income.setBounds(350,270,320,25);
        add(income);

        JLabel lable6 = new JLabel("Education:");
        lable6.setFont(new Font("Raleway", Font.BOLD, 20));
        lable6.setBounds(150, 310, 600, 40);
        add(lable6);

        String Education[] = {"Non-Graduate","Graduate","Post-Graduate","Other"};
        gradution = new JComboBox(Education);
        gradution.setFont(new Font("Raleway", Font.BOLD, 15));
//        gradution.setBackground(new Color(156, 62, 0));
        gradution.setBounds(350,320,320,25);
        add(gradution);

        JLabel lable7 = new JLabel("Occupation:");
        lable7.setFont(new Font("Raleway", Font.BOLD, 20));
        lable7.setBounds(150, 360, 600, 40);
        add(lable7);

        String occupation[] = {"Student","Business","Self-Employed","Salaried","Retired","Other"};
        Occupation = new JComboBox(occupation);
        Occupation.setFont(new Font("Raleway", Font.BOLD, 15));
//        Occupation.setBackground(new Color(156, 62, 0));
        Occupation.setBounds(350,370,320,25);
        add(Occupation);

        JLabel lable8 = new JLabel("Aadhar no:");
        lable8.setFont(new Font("Raleway", Font.BOLD, 20));
        lable8.setBounds(150, 410, 600, 40);
        add(lable8);

        aadharNO = new JTextField();
        aadharNO.setFont(new Font("Raleway", Font.BOLD, 15));
//        aadharNO.setBackground(new Color(156, 62, 0));
        aadharNO.setBounds(350,420,320,25);
        add(aadharNO);

        JLabel lable9 = new JLabel("Pan no:");
        lable9.setFont(new Font("Raleway", Font.BOLD, 20));
        lable9.setBounds(150, 460, 600, 40);
        add(lable9);

        panNO = new JTextField();
        panNO.setFont(new Font("Raleway", Font.BOLD, 15));
//        panNO.setBackground(new Color(156, 62, 0));
        panNO.setBounds(350,470,320,25);
        add(panNO);

        JLabel lable10 = new JLabel("Sinear Citizen:");
        lable10.setFont(new Font("Raleway", Font.BOLD, 20));
        lable10.setBounds(150, 510, 600, 40);
        add(lable10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 20));
        r1.setBackground(new Color(156,62,0));
        r1.setBounds(350, 520, 80, 30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 20));
        r2.setBackground(new Color(156,62,0));
        r2.setBounds(430, 520, 70, 30);
        add(r2);

        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(r1);
        btnGroup1.add(r2);

        JLabel lable11 = new JLabel("Existing Account:");
        lable11.setFont(new Font("Raleway", Font.BOLD, 20));
        lable11.setBounds(150, 560, 600, 40);
        add(lable11);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 20));
        r3.setBackground(new Color(156,62,0));
        r3.setBounds(350, 570, 80, 30);
        add(r3);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 20));
        r4.setBackground(new Color(156,62,0));
        r4.setBounds(430, 570, 70, 30);
        add(r4);

        ButtonGroup btnGroup2 = new ButtonGroup();
        btnGroup2.add(r3);
        btnGroup2.add(r4);

        JLabel lable12 = new JLabel("Form no:");
        lable12.setFont(new Font("Raleway", Font.BOLD, 15));
        lable12.setBounds(660, 15, 100, 20);
        add(lable12);


        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD,15));
        l13.setBounds(730,10,60,30);
        add(l13);

        next = new JButton("Next:");
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBackground(Color.white);
        next.setForeground(Color.BLACK);
        next.setBounds(580,640,100,30);
        next.addActionListener(this);
        add(next);


        setLayout(null);
        getContentPane().setBackground(new Color(156, 62, 0));
        setSize(850,750);
        setLocation(400,50);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) riligion.getSelectedItem();
        String category =  (String) catagory.getSelectedItem();
        String Income = (String) income.getSelectedItem();
        String Gradution = (String) gradution.getSelectedItem();
        String occupation =  (String) Occupation.getSelectedItem();

        String aadhar = aadharNO.getText();
        String pan = panNO.getText();

        String sineorS = null;
        if (r1.isSelected()){
            sineorS = "Yes";
        } else if (r2.isSelected()) {
            sineorS = "No";
        }

        String ExistingAccount = null;
        if(r3.isSelected()){
            ExistingAccount = "yes";
        } else if (r4.isSelected()) {
            ExistingAccount = "No";
        }

        try {
            if (panNO.getText().equals("") || aadharNO.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }
            else {
                Conn c1 = new Conn();
                String q = "insert into SignUp2 values('"+formno+"','" + religion + "','" + category + "','" + Income + "','" + Gradution + "','" + occupation + "','" + aadhar + "','" + pan + "','" + sineorS + "','" + ExistingAccount + "')";
                c1.statement.executeUpdate(q);
                new SignUp3(formno);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new SignUp2("");
    }
}
