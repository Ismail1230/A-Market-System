package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class Hello extends JFrame {
	private JLabel pic;
    private JButton Button;
    private JLabel label;
    private JPanel contentPane;
    private ImageIcon titleImg;
	private JLabel labeltitle;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Hello frame = new Hello();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
		
		 public Hello() {
			   
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setBounds(100, 0, 1100, 700);
		     
		        setResizable(false);
		        contentPane = new JPanel();
		        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		        setContentPane(contentPane);
		        setTitle("Fresh Farm Market");
		        contentPane.setLayout(null);
		        
				//contentPane.setBackground(Color.BLUE);
		        
		        JPanel title =new JPanel();
		        title.setLayout(null);
		        title.setBackground(Color.CYAN);
		        title.setSize(370,150);
		        title.setBounds(380,200,370,100);
		        JLabel lblNewLabel = new JLabel("Welcome To Fresh Farm Market System");
		        lblNewLabel.setForeground(Color.BLACK);
		        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		        lblNewLabel.setBounds(0, 10, 500, 100);
		        lblNewLabel.setVisible(true);
		        title.add(lblNewLabel);
		        
		        JButton Button = new JButton("LogIn As User");
		        Button.setForeground(Color.BLACK);
		        Button.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		        Button.setBounds(200, 400, 150, 50);
		        Button.addActionListener(new ActionListener() {

		            public void actionPerformed(ActionEvent e) {
		                        dispose();
		                        LoginGui lg = new LoginGui();
		                        lg.setTitle("Login");
		                        lg.setVisible(true);
		            }
		        });
		        contentPane.add(Button);
		        
		        JButton Button1 = new JButton("Register As User");
		        Button1.setForeground(Color.BLACK);
		        Button1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		        Button1.setBounds(450, 400, 150, 50);
		        Button1.addActionListener(new ActionListener() {

		            public void actionPerformed(ActionEvent e) {
		                        dispose();
		                        RegistrationGui rg = new RegistrationGui();
		                        rg.setTitle("Register");
		                        rg.setVisible(true);
		                        JOptionPane.showMessageDialog(Button, "Please Register");
		            }
		        }); 
		        
		        contentPane.add(Button1);
		        
		        JButton Button2 = new JButton("Manager LogIn");
		        Button2.setForeground(Color.BLACK);
		        Button2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		        Button2.setBounds(700, 400, 150, 50);
		       Button2.addActionListener(new ActionListener() {

		            public void actionPerformed(ActionEvent e) {
		                        dispose();
		                        ManagerLogin lg = new ManagerLogin();
		                        lg.setTitle("Welcome Manager");
		                        lg.setVisible(true);
		            }
		        });
		        
		        contentPane.add(Button2);
		        // background
		        ImageIcon img1 =new ImageIcon(getClass().getResource("images/wallpaper.jpg"));
		        Image scaleImage1 =img1.getImage().getScaledInstance(1100,700,Image.SCALE_SMOOTH);
		        ImageIcon image1=new ImageIcon(scaleImage1);
		        pic=new JLabel("",image1,JLabel.CENTER);
		        pic.add(title);
		        pic.setBounds(0,0,1100,700);
		        add(pic);

		

	}

}
