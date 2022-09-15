package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Customer.Customer;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static javax.swing.GroupLayout.Alignment.*;

public class PaymentFrame extends JFrame {
	private String username;
    private JPanel panel ;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JTable table;
    public static JButton button;
    private JLabel purchaseId;
    DefaultTableModel model1;
    private JRadioButton cash;
    private JRadioButton card;
    private JPanel cash_panel;
    private JPanel card_panel;
    private JTextField cashin_text;
    private JLabel change_text;
    private JLabel point_text;
    private JTextField cardin_text;
    private JButton Next;
    private  boolean correct =false;
    private static DecimalFormat df = new DecimalFormat("0.00");
    Font f =new Font("Comic Sans",Font.PLAIN,30);
    Font f1 =new Font("Comic Sans",Font.PLAIN,20);
    private DateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public Date date=new Date();
    
    private  ArrayList<Customer> cus = new ArrayList<Customer>();
    
    public PaymentFrame(String userName){
    	
        super("Payment Page");
        panel =new JPanel(new GridLayout(1,2));
        add(panel);
        rightPanel =new JPanel();
        leftPanel =new JPanel();
        panel.add(rightPanel);
        panel.add(leftPanel);
        this.username=userName;
        
        Connection con;
		ResultSet rs1;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			Statement s= con.createStatement();
			 s.executeQuery("SELECT * FROM accounts");
			rs1= s.getResultSet();
		     
			while (rs1.next()){
				String name= rs1.getString("first_name");
				String lastname= rs1.getString("last_name");
				String phone=rs1.getString("mobile_number");
				String email= rs1.getString("email_id");
				String user_name=rs1.getString("user_name");
				
				cus.add(new Customer(name,lastname,phone,email,user_name));
				}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

        //////////////////////////right panel/////////////////////////////////////////
        GroupLayout groupLayout =new GroupLayout(rightPanel);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        rightPanel.setLayout(groupLayout);
        rightPanel .setBackground(new Color(67, 186, 246,96));
        button=new JButton("BACK");
        ButtonHandler handler =new ButtonHandler();
        button.addActionListener(handler);
        JLabel tile_cart =new JLabel("Cart:");
        JLabel purchase =new JLabel("Purchase id:");
        purchaseId =new JLabel();
        JLabel warning =new JLabel("The company will refund up tp 75% in case of damage or expired product.");


        model1 = new DefaultTableModel();
        model1.addColumn("ITEM");
        model1.addColumn("PRODUCT_ID");
        model1.addColumn("PRODUCT_NAME");
        model1.addColumn("QUANTITY");
        model1.addColumn("PRICE(Rs)");
        table =new JTable();
        table.setModel(model1);
        table.setBackground(new Color(195,229,220));
        JScrollPane sp=new JScrollPane(table);

        for(int i=0;i<HomeFrame.model.getRowCount();i++){
               model1.addRow(new Object[]{HomeFrame.model.getValueAt(i,0),HomeFrame.model.getValueAt(i,1),HomeFrame.model.getValueAt(i,2),HomeFrame.model.getValueAt(i,3),HomeFrame.model.getValueAt(i,4)});
        }
        table.disable();

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(button).addComponent(tile_cart)
                .addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(LEADING).addComponent(purchase)) .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(purchaseId)))
                .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(sp).addComponent(warning)))
        );


        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(button))
                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(tile_cart))
                .addGroup(groupLayout.createParallelGroup(LEADING).addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(purchase).addComponent(purchaseId))))

                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(sp))
                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(warning)));

        dbSearchProduct();

        ////////////////////////////////left panel//////////////////////////////////////////
        GroupLayout Layout =new GroupLayout(leftPanel);
        Layout.setAutoCreateGaps(true);
        Layout.setAutoCreateContainerGaps(true);
        leftPanel.setLayout(Layout);
        leftPanel .setBackground(new Color(67, 186, 246,96));

        JLabel total =new JLabel(" TOTAL :(Rs) ");
        JLabel q =new JLabel();
        total.setFont(f);
        JTextField texttl=new JTextField(String.valueOf(df.format( HomeFrame.total)));
        texttl.setFont(f);
        texttl.setForeground(Color.RED);

        JPanel panel =new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Method of Payment"));
        cash = new JRadioButton("Cash");
        cash.setFont(f1);
        card = new JRadioButton("Card");
        card.setFont(f1);

        ButtonGroup group = new ButtonGroup();
        group.add(cash);
        group.add(card);

        panel.add(cash);
        panel.add(card);


        cash_panel =new JPanel(new GridLayout(3,2));
        cash_panel.setBorder(BorderFactory.createTitledBorder("Cash Payment"));
        JLabel cashin = new JLabel("cash input:(Rs)");
        cashin.setFont(f1);
        JLabel change = new JLabel("change:");
        change.setFont(f1);
        JLabel point = new JLabel("Points:");
        point.setFont(f1);
        cashin_text =new JTextField();
        cashin_text.setFont(f1);
        change_text =new JLabel();
        change_text.setFont(f1);
        point_text =new JLabel();
        point_text.setFont(f1);

        TextFieldHandler Thandler =new TextFieldHandler();
        cashin_text.addActionListener(Thandler);

        cash_panel.add(cashin);
        cash_panel.add(cashin_text);
        cash_panel.add(change);
        cash_panel.add(change_text);
        cash_panel.add(point);
        cash_panel.add(point_text);
        


        card_panel=new JPanel(new GridLayout(2,2));
        card_panel.setBorder(BorderFactory.createTitledBorder("Card Payment"));
        JLabel cardin = new JLabel("Enter your card");
        //cashin.setFont(f1);
        card_panel.add(cardin,BorderLayout.NORTH);
        JLabel empty =new JLabel();
        JLabel cardpin = new JLabel("Enter your pin:");
        cardpin.setFont(f1);
        cardin_text =new JTextField();
        cardin_text.addActionListener(Thandler);
        cardin_text.setFont(f1);

        card_panel.add(cardin);
        card_panel.add(empty);
        card_panel.add(cardpin);
        card_panel.add(cardin_text);

        Next=new JButton("NEXT");
        Next.addActionListener(handler);
        Next.setVisible(false);


        Layout.setHorizontalGroup(Layout.createSequentialGroup()
                .addGroup(Layout.createParallelGroup(LEADING).addComponent(q)
                .addGroup(Layout.createSequentialGroup().addGroup(Layout.createParallelGroup(LEADING).addComponent(total)) .addGroup(Layout.createParallelGroup(LEADING).addComponent(texttl)))
                .addGroup(Layout.createParallelGroup(CENTER).addGroup(Layout.createParallelGroup(LEADING).addComponent(panel).addComponent(cash_panel).addComponent(card_panel)).addComponent(Next)
                )
                ));

        Layout.setVerticalGroup(Layout.createSequentialGroup()
                .addGroup(Layout.createParallelGroup(BASELINE).addComponent(q))
                .addGroup(Layout.createParallelGroup(LEADING).addGroup(Layout.createSequentialGroup()
                        .addGroup(Layout.createParallelGroup(BASELINE).addComponent(total).addComponent(texttl,30,30,40))))
                .addGroup(Layout.createParallelGroup(BASELINE).addComponent(panel,60,60,60))
                .addGroup(Layout.createParallelGroup(BASELINE).addComponent(cash_panel,100,100,100))
                .addGroup(Layout.createParallelGroup(BASELINE).addComponent(card_panel,100,100,100))
                .addGroup(Layout.createParallelGroup().addComponent(Next))
        );
        cash_panel.setVisible(false);
        card_panel.setVisible(false);
        cash.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1) {
                    cash_panel.setVisible(true);
                    card_panel.setVisible(false);
                    Next.setVisible(true);
                }
            }
        });
        card.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1) {
                    cash_panel.setVisible(false);
                    card_panel.setVisible(true);
                    Next.setVisible(true);
                }
            }
        });
    }

    private void dbSearchProduct() {
        Connection connection;
        int count=0;
        try {
            Boolean not_found = false;
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("select purchaseId from purchase");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                int num =rs.getInt("purchaseId");
                if (num>=count){
                    count = num;
                }
            }
            purchaseId.setText(String.valueOf(count+1));



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand()=="BACK"){
                    /*
                    for(int i=0;i<HomeFrame.model.getRowCount();i++){
                        HomeFrame.model.addRow(new Object[]{HomeFrame.model.getValueAt(i,0),HomeFrame.model.getValueAt(i,1),HomeFrame.model.getValueAt(i,2),HomeFrame.model.getValueAt(i,3),HomeFrame.model.getValueAt(i,4)});
                    }
                     */
                HomeFrame homeframe =new HomeFrame(username);
                homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                homeframe.setSize(1000,670);
                homeframe.setLocationRelativeTo(null);
                homeframe.setVisible(true);
                dispose();
            }if(e.getSource()==Next){
                if((cashin_text.getText().equals(""))&&(cardin_text.getText().equals(""))){
                    JOptionPane.showMessageDialog(null, "Cant complete action.");
                }else{
                    if (correct==true) {
                        EndFrame endframe = new EndFrame(username);
                        endframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        endframe.setSize(1000, 670);
                        endframe.setLocationRelativeTo(null);
                        endframe.setVisible(true);
                        String ID=purchaseId.getText();
                        System.out.println("id=="+ID);
                        saveToDB(ID);
                        ReduceStock();
                        dispose();
                    }
                }

            }
        }
    }

    private void ReduceStock() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            for(int i=0;i<HomeFrame.model.getRowCount();i++){
                s.execute("UPDATE product SET stock=stock-'"+HomeFrame.model.getValueAt(i,3)+"' WHERE productId ='"+HomeFrame.model.getValueAt(i,1)+"'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveToDB(String ID) {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            for(int i=0;i<HomeFrame.model.getRowCount();i++){
                s.execute("INSERT  INTO purchase values ('"+ID+"','"+HomeFrame.model.getValueAt(i,1)+"','"+HomeFrame.model.getValueAt(i,3)+"','"+HomeFrame.model.getValueAt(i,4)+"','"+dateFormat.format(date)+"')");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            double amount_in;
            int pin;
            if(event.getSource()==cashin_text) {
                amount_in = Float.valueOf(event.getActionCommand());
                if (amount_in < HomeFrame.total) {
                    JOptionPane.showMessageDialog(null, "amount input not correct.");
                    cashin_text.setText("");
                    change_text.setText("");
                    correct=false;
                } else {
                    double change = amount_in - HomeFrame.total;
                    change_text.setText("Rs "+String.valueOf(df.format(change)));
                    for(int i=0;i<cus.size();i++) {
                    	if(cus.get(i).getUsername().equals(username)) {
                    		cus.get(i).getCard().incrementPoints();
                        	point_text.setText(""+cus.get(i).getCard().getPoints());
                        }
                    }
                    
            
                    correct=true;
                }
            }if(event.getSource()==cardin_text) {
                pin=Integer.parseInt(event.getActionCommand());
                if((pin<1000) || (pin>9999)){
                    JOptionPane.showMessageDialog(null, "Pin should contain only four digits.");
                    cardin_text.setText("");
                    correct=false;
                }else {
                    correct=true;
                }
            }

        }
    }

}
