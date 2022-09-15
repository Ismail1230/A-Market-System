package GUI;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndFrame  extends JFrame  {
	
	private JButton logout;
	private JButton home;
	private String username;

    public EndFrame(String Username){
        super("Good bye!");
        setResizable(false);
        Font f =new Font("Billy Ohio",Font.PLAIN,60);
        this.username= Username;
        Container c =getContentPane();
        c.setLayout(new MigLayout("","[250][500][250]","[255][155][260]"));
        JPanel endpanel =new JPanel();
        endpanel.setSize(1000,670);
        GroupLayout groupLayout =new GroupLayout(endpanel);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        endpanel.setLayout(groupLayout);
        c.add(endpanel,"cell 1 1,grow");
        c.setBackground(new Color(67, 186, 246,96));
        endpanel.setBackground(new Color(11,43,119,47));
        JLabel thank =new JLabel("Thank you for your purchase.");
        JLabel label =new JLabel("See u soon.");
        logout= new JButton();
        logout.setText("Logout");
        logout.setSize(200,50);
        c.add(logout);
        home= new JButton();
        home.setText("Home");
        home.setSize(200,50);
        c.add(home);
        thank.setFont(f);

        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(thank).addComponent(label)
       );
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup().addComponent(thank).addComponent(label)
       );
        
        logout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	Hello h = new Hello();
                h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                h.setSize(1000, 670);
                h.setLocationRelativeTo(null);
                h.setVisible(true);
                dispose();
            }
        });
        
        home.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	HomeFrame h1 = new HomeFrame(username);
                h1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                h1.setSize(1000, 670);
                h1.setLocationRelativeTo(null);
                h1.setVisible(true);
                dispose();
            }
        });
    }
}
