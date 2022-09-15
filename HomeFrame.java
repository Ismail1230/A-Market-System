package GUI;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import Customer.Customer;
import Product.Fruits;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.awt.BorderLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.GroupLayout.Alignment.CENTER;

public class HomeFrame extends JFrame implements MenuListener {
	private String username;
    public JPanel back_panel;
    public JPanel home;
    private JPanel home1;
    private  JPanel categorypanel;
    private JPanel add_product;
    public JPanel panelcenter;
    public JPanel product;
    public JPanel category;
    public  JMenu homeMenu;
    public JMenu productMenu;
    public  JMenu categoryMenu;
    public static JTextField output;
    private JTable table;
    static DefaultTableModel model ;
    private JTextField op_total;
    private JButton payment;
    private JButton remove;
    private JButton clear;
    private  JButton addproduct;
    private  JButton choose_category;
    private JPanel vegetablepanel;
    private  JButton Vegetable;
    private JButton Fruit;
    private JButton DairyProduct;

    private JPanel fruitpanel;

    private JPanel dairypanel;


    private JLabel vegname1;
    private JLabel vegprice1;
    private JLabel picveg1;
    private JButton vegcart1;

    private JLabel vegname2;
    private JLabel vegprice2;
    private JLabel picveg2;
    private JButton vegcart2;

    private JLabel vegname3;
    private JLabel vegprice3;
    private JLabel picveg3;
    private JButton vegcart3;

    private JLabel vegname4;
    private JLabel vegprice4;
    private JLabel picveg4;
    private JButton vegcart4;

    private JLabel vegname5;
    private JLabel vegprice5;
    private JLabel picveg5;
    private JButton vegcart5;
    
    private JLabel vegname6;
    private JLabel vegprice6;
    private JLabel picveg6;
    private JButton vegcart6;
    
    private JLabel vegname7;
    private JLabel vegprice7;
    private JLabel picveg7;
    private JButton vegcart7;
    
    private JLabel vegname8;
    private JLabel vegprice8;
    private JLabel picveg8;
    private JButton vegcart8;
    
    private JLabel vegname9;
    private JLabel vegprice9;
    private JLabel picveg9;
    private JButton vegcart9;
    
    private JLabel vegname10;
    private JLabel vegprice10;
    private JLabel picveg10;
    private JButton vegcart10;
    
    private JLabel vegname11;
    private JLabel vegprice11;
    private JLabel picveg11;
    private JButton vegcart11;
    
    private JLabel vegname12;
    private JLabel vegprice12;
    private JLabel picveg12;
    private JButton vegcart12; 

    private JLabel name;
    private JLabel price;
    private JLabel picture;
    private JButton fcart1;
    private JButton fcart2;
    private JButton fcart3;
    private JButton fcart4;
    private JButton fcart5;
    private JButton fcart6;
    private JButton fcart7;
    private JButton fcart8;
    private JButton fcart9;
    private JButton fcart10;
    private JButton fcart11;
    private JButton fcart12;

    private JButton mcart1;
    private JButton mcart2;
    private JButton mcart3;
    private JButton mcart4;
    private JButton mcart5;
    private JButton mcart6;

    private static DecimalFormat df = new DecimalFormat("0.00");
   

    public HomeFrame(String userName) {
    	
        super("Home Page");
        Font f =new Font("Billy Ohio",Font.PLAIN,40);
        this.username=userName;

		

        back_panel=new JPanel();
        back_panel.setLayout(new BorderLayout());

        //Menu bar
        JMenuBar menuBar=new JMenuBar();
         homeMenu =new JMenu("Home");
         productMenu =new JMenu("Product");

        menuBar.setBackground(new Color(11,119,51));
        menuBar.add(homeMenu);
        menuBar.add(productMenu);
        back_panel.add(menuBar, NORTH);
        back_panel.setBackground(new Color(67,246,174,96));


        panelcenter =new JPanel();
        back_panel.add(panelcenter,BorderLayout.CENTER);
        panelcenter.setLayout(new CardLayout());

         ////////////////home panel//////////////////
        home=new JPanel();
        home.setLayout(null);
        ImageIcon img1 =new ImageIcon(getClass().getResource("images/veg1.jpg"));
        JLabel pic =new JLabel(img1);
        JLabel welcome =new JLabel("WELCOME TO FRESH MARKET");
        welcome.setFont(f);
        pic.setBounds(0,0,1000,670);
        welcome.setBounds(220,280,630,70);
        welcome.setForeground(Color.black);
        home.add(welcome);
        home.add(pic);



        /////////////product panel////////////////////
        product =new JPanel();
        product.setLayout(new GridLayout(1,2));
        //panel for input product id
        add_product =new JPanel();
        add_product.setLayout(new BorderLayout());
        JPanel northborder =new JPanel();
        northborder.setLayout(new GridLayout(1,2));
        choose_category =new JButton("Category");
        addproduct =new JButton("Add product ID");
        northborder.add(choose_category);
        northborder.add(addproduct);
        add_product.add(northborder, NORTH);

        //////////////////////////////home1 panel is adding a product by its Id///////////////////////////////
        home1 =new JPanel();
        home1 .setBackground(new Color(69,90,21,90));
        home1.setLayout(new MigLayout("","[grow]","[grow]"));
        JLabel text=new JLabel("Enter a product ID :");
        JPanel produtIN =new JPanel(new MigLayout("","10[92][92][92][92]","10[40]10[41]10[41]10[41]10[41]10[41]10[41]10[41]10[41]"));
        produtIN .setBackground(new Color(69,181,151,70));
        //insert number and text field
        output =new JTextField();
        output .setBackground(new Color(195,229,220));
        JButton num7 =new JButton("7");
        num7.setSize(92,41);
        JButton num8 =new JButton("8");
        JButton num9 =new JButton("9");
        JButton A =new JButton("B");
        A.setBackground(Color.orange);

        JButton num4 =new JButton("4");
        JButton num5 =new JButton("5");
        JButton num6 =new JButton("6");
        JButton B =new JButton("D");
        B.setBackground(Color.orange);

        JButton num1 =new JButton("1");
        JButton num2 =new JButton("2");
        JButton num3 =new JButton("3");
        JButton C =new JButton("F");
        C.setBackground(Color.orange);

        JButton num0 =new JButton("0");
        JButton AC =new JButton("AC");
        JButton Enter =new JButton("ENTER");
        JButton D =new JButton("FF");
        D.setBackground(Color.orange);
        JButton E =new JButton("SM");
        E.setBackground(Color.orange);
        JButton F =new JButton("V");
        F.setBackground(Color.orange);

        produtIN.add(text,"wrap");
        produtIN.add(output,"span 4,h 60!,wrap,grow");
        produtIN.add(num7,"grow");
        produtIN.add(num8,"grow");
        produtIN.add(num9,"grow");
        produtIN.add(A,"wrap ,grow");

        produtIN.add(num4,"grow");
        produtIN.add(num5,"grow");
        produtIN.add(num6,"grow");
        produtIN.add(B,"wrap ,grow");

        produtIN.add(num1,"grow");
        produtIN.add(num2,"grow");
        produtIN.add(num3,"grow");
        produtIN.add(C,"wrap ,grow");

        produtIN.add(num0,"span 3 ,grow");
        produtIN.add(D,"wrap ,grow");

        produtIN.add(AC,"span 3 ,grow");
        produtIN.add(E,"wrap ,grow");

        produtIN.add(Enter,"span 3 ,grow");
        produtIN.add(F,"wrap ,grow");
        home1.add(produtIN,"w 400!,h 400!,center");


        //////////////button handler/////////////
        ButtonHandler handler =new ButtonHandler();
        num0.addActionListener(handler);
        num1.addActionListener(handler);
        num2.addActionListener(handler);
        num3.addActionListener(handler);
        num4.addActionListener(handler);
        num5.addActionListener(handler);
        num6.addActionListener(handler);
        num7.addActionListener(handler);
        num8.addActionListener(handler);
        num9.addActionListener(handler);
        AC.addActionListener(handler);
        Enter.addActionListener(handler);
        A.addActionListener(handler);
        B.addActionListener(handler);
        C.addActionListener(handler);
        D.addActionListener(handler);
        E.addActionListener(handler);
        F.addActionListener(handler);
        choose_category.addActionListener(handler);
        addproduct.addActionListener(handler);
        
       
        /////////////////////////////////////panel for choosing category/////////////////////////
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("select * from product");
            ResultSet rs = s.getResultSet();


                categorypanel = new JPanel();
                categorypanel.setLayout(new GridLayout(3, 3, 10, 10));
                Fruit = new JButton("Fruit");
                DairyProduct = new JButton("Frozen Food");
                Vegetable = new JButton("Vegetables");
                ////vegetable button///////
                JPanel veg = new JPanel(new BorderLayout());
                ImageIcon bug = new ImageIcon(getClass().getResource("pic/v.jpg"));
                Image scaleImage1 = bug.getImage().getScaledInstance(225, 215, Image.SCALE_SMOOTH);
                ImageIcon image1 = new ImageIcon(scaleImage1);
                JLabel label1 = new JLabel("", image1, JLabel.CENTER);
                veg.setBackground(Color.WHITE);
                veg.add(label1, BorderLayout.CENTER);
                Vegetable.add(veg);
                ////Dairy button///////
                JPanel ff = new JPanel(new BorderLayout());
                ImageIcon bug_icon2 = new ImageIcon(getClass().getResource("images/dairy/dairy.jpg"));
                Image scale_pic2 = bug_icon2.getImage().getScaledInstance(225, 215, Image.SCALE_SMOOTH);
                ImageIcon icon_image2 = new ImageIcon(scale_pic2);
                JLabel pic_label2 = new JLabel("", icon_image2, JLabel.CENTER);
                ff.setBackground(Color.WHITE);
                ff.add(pic_label2, BorderLayout.CENTER);
                DairyProduct.add(ff);

            ////fruits button///////
            JPanel ft = new JPanel(new BorderLayout());
            ImageIcon bug_icon5 = new ImageIcon(getClass().getResource("pic/fruit.jpg"));
            Image scale_pic5 = bug_icon5.getImage().getScaledInstance(225, 215, Image.SCALE_SMOOTH);
            ImageIcon icon_image5 = new ImageIcon(scale_pic5);
            JLabel pic_label5 = new JLabel("", icon_image5, JLabel.CENTER);
            ft.setBackground(Color.WHITE);
            ft.add(pic_label5, BorderLayout.CENTER);
            Fruit.add(ft);

                Vegetable.addActionListener(handler);
                Fruit.addActionListener(handler);
                DairyProduct.addActionListener(handler);
            //////////frozen food panel/////////////
            dairypanel=new JPanel(new GridLayout(3,3));
            dairypanel .setBackground(new Color(69,181,151,70));
            dairypanel.setLayout(new GridLayout(3, 3,15,15));

            JPanel dairy1 = new JPanel();
            JPanel dairy2 = new JPanel();
            JPanel dairy3 = new JPanel();
            JPanel dairy4 = new JPanel();
            JPanel dairy5 = new JPanel();
            JPanel dairy6 = new JPanel();

            dairy1.setBackground(Color.white);
            dairy2.setBackground(Color.white);
            dairy3.setBackground(Color.white);
            dairy4.setBackground(Color.white);
            dairy5.setBackground(Color.white);
            dairy6.setBackground(Color.white);
            

            dairy1.setLayout(new BoxLayout(dairy1, BoxLayout.Y_AXIS));
            dairy2.setLayout(new BoxLayout(dairy2, BoxLayout.Y_AXIS));
            dairy3.setLayout(new BoxLayout(dairy3, BoxLayout.Y_AXIS));
            dairy4.setLayout(new BoxLayout(dairy4, BoxLayout.Y_AXIS));
            dairy5.setLayout(new BoxLayout(dairy5, BoxLayout.Y_AXIS));
            dairy6.setLayout(new BoxLayout(dairy6, BoxLayout.Y_AXIS));

            //////////fruit panel/////////////
                fruitpanel=new JPanel(new GridLayout(3,3));
                fruitpanel .setBackground(new Color(69,181,151,70));
                fruitpanel.setLayout(new GridLayout(3, 3,15,15));

                JPanel fruit1 = new JPanel();
                JPanel fruit2 = new JPanel();
                JPanel fruit3 = new JPanel();
                JPanel fruit4 = new JPanel();
                JPanel fruit5 = new JPanel();
                JPanel fruit6 = new JPanel();
                JPanel fruit7 = new JPanel();
                JPanel fruit8 = new JPanel();
                JPanel fruit9 = new JPanel();
                JPanel fruit10 = new JPanel();
                JPanel fruit11= new JPanel();
                JPanel fruit12 = new JPanel();

            fruit1.setBackground(Color.white);
            fruit2.setBackground(Color.white);
            fruit3.setBackground(Color.white);
            fruit4.setBackground(Color.white);
            fruit5.setBackground(Color.white);
            fruit6.setBackground(Color.white);
            fruit7.setBackground(Color.white);
            fruit8.setBackground(Color.white);
            fruit9.setBackground(Color.white);
            fruit10.setBackground(Color.white);
            fruit11.setBackground(Color.white);
            fruit12.setBackground(Color.white);

            fruit1.setLayout(new BoxLayout(fruit1, BoxLayout.Y_AXIS));
            fruit2.setLayout(new BoxLayout(fruit2, BoxLayout.Y_AXIS));
            fruit3.setLayout(new BoxLayout(fruit3, BoxLayout.Y_AXIS));
            fruit4.setLayout(new BoxLayout(fruit4, BoxLayout.Y_AXIS));
            fruit5.setLayout(new BoxLayout(fruit5, BoxLayout.Y_AXIS));
            fruit6.setLayout(new BoxLayout(fruit6, BoxLayout.Y_AXIS));
            fruit7.setLayout(new BoxLayout(fruit7, BoxLayout.Y_AXIS));
            fruit8.setLayout(new BoxLayout(fruit8, BoxLayout.Y_AXIS));
            fruit9.setLayout(new BoxLayout(fruit9, BoxLayout.Y_AXIS));
            fruit10.setLayout(new BoxLayout(fruit10, BoxLayout.Y_AXIS));
            fruit11.setLayout(new BoxLayout(fruit11, BoxLayout.Y_AXIS));
            fruit12.setLayout(new BoxLayout(fruit12, BoxLayout.Y_AXIS));

                //////////vegetable panel/////////////
                vegetablepanel = new JPanel();
                vegetablepanel.setLayout(new BorderLayout());
                JPanel vegCenter = new JPanel();
                vegCenter .setBackground(new Color(69,181,151,70));
                vegCenter.setLayout(new GridLayout(3, 3,15,15));

                vegetablepanel.add(vegCenter, BorderLayout.CENTER);

                JPanel veg1 = new JPanel();
                JPanel veg2 = new JPanel();
                JPanel veg3 = new JPanel();
                JPanel veg4 = new JPanel();
                JPanel veg5 = new JPanel();
                
                JPanel veg6 = new JPanel();
                JPanel veg7 = new JPanel();
                JPanel veg8 = new JPanel();
                JPanel veg9 = new JPanel();
                JPanel veg10 = new JPanel();
                JPanel veg11 = new JPanel();
                JPanel veg12 = new JPanel();

                veg1.setBackground(Color.white);
                veg2.setBackground(Color.white);
                veg3.setBackground(Color.white);
                veg4.setBackground(Color.white);
                veg5.setBackground(Color.white);
                
                veg6.setBackground(Color.white);
                veg7.setBackground(Color.white);
                veg8.setBackground(Color.white);
                veg9.setBackground(Color.white);
                veg10.setBackground(Color.white);
                veg11.setBackground(Color.white);
                veg12.setBackground(Color.white);

                veg1.setLayout(new BoxLayout(veg1, BoxLayout.Y_AXIS));
                veg2.setLayout(new BoxLayout(veg2, BoxLayout.Y_AXIS));
                veg3.setLayout(new BoxLayout(veg3, BoxLayout.Y_AXIS));
                veg4.setLayout(new BoxLayout(veg4, BoxLayout.Y_AXIS));
                veg5.setLayout(new BoxLayout(veg5, BoxLayout.Y_AXIS));
                veg6.setLayout(new BoxLayout(veg6, BoxLayout.Y_AXIS));
                veg7.setLayout(new BoxLayout(veg7, BoxLayout.Y_AXIS));
                veg8.setLayout(new BoxLayout(veg8, BoxLayout.Y_AXIS));
                veg9.setLayout(new BoxLayout(veg9, BoxLayout.Y_AXIS));
                veg10.setLayout(new BoxLayout(veg10, BoxLayout.Y_AXIS));
                veg11.setLayout(new BoxLayout(veg11, BoxLayout.Y_AXIS));
                veg12.setLayout(new BoxLayout(veg12, BoxLayout.Y_AXIS));

            while (rs.next()) {
                if(rs.getString("productId").equals("V101")) {
                    vegname1 = new JLabel(rs.getString("name"));
                    vegprice1 = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picveg1 = new JLabel("", imagconveg1, JLabel.CENTER);
                    vegcart1 = new JButton("Add to cart");
                    vegcart1.addActionListener(handler);

                    picveg1.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname1.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice1.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart1.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg1.add(picveg1);
                    veg1.add(vegname1);
                    veg1.add(vegprice1);
                    veg1.add(vegcart1);

                }
                if(rs.getString("productId").equals("V102")) {
                    vegname2 = new JLabel(rs.getString("name"));
                    vegprice2 = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image2 =rs.getBytes("image");
                    ImageIcon iconveg2 = new ImageIcon(image2);
                    Image imgveg2 = iconveg2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg2 = new ImageIcon(imgveg2);
                    picveg2 = new JLabel("", imagconveg2, JLabel.CENTER);
                    vegcart2 = new JButton("Add to cart");
                    vegcart2.addActionListener(handler);

                    picveg2.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname2.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice2.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart2.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg2.add(picveg2);
                    veg2.add(vegname2);
                    veg2.add(vegprice2);
                    veg2.add(vegcart2);
                }
                if(rs.getString("productId").equals("V103")) {
                    vegname3 = new JLabel(rs.getString("name"));
                    vegprice3 = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image3 =rs.getBytes("image");
                    ImageIcon iconveg3 = new ImageIcon(image3);
                    Image imgveg3 = iconveg3.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg3 = new ImageIcon(imgveg3);
                    picveg3 = new JLabel("", imagconveg3, JLabel.CENTER);
                    vegcart3 = new JButton("Add to cart");
                    vegcart3.addActionListener(handler);

                    picveg3.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname3.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice3.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart3.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg3.add(picveg3);
                    veg3.add(vegname3);
                    veg3.add(vegprice3);
                    veg3.add(vegcart3);
                }

                if(rs.getString("productId").equals("V104")) {
                    vegname4 = new JLabel(rs.getString("name"));
                    vegprice4 = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image4 =rs.getBytes("image");
                    ImageIcon iconveg4 = new ImageIcon(image4);
                    Image imgveg4 = iconveg4.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg4 = new ImageIcon(imgveg4);
                    picveg4 = new JLabel("", imagconveg4, JLabel.CENTER);
                    vegcart4 = new JButton("Add to cart");
                    vegcart4.addActionListener(handler);

                    picveg4.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname4.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice4.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart4.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg4.add(picveg4);
                    veg4.add(vegname4);
                    veg4.add(vegprice4);
                    veg4.add(vegcart4);
                }
                if(rs.getString("productId").equals("V105")) {
                    vegname5 = new JLabel(rs.getString("name"));
                    vegprice5 = new JLabel("Rs "+String.valueOf(rs.getFloat("price")));
                    byte[] image5 =rs.getBytes("image");
                    ImageIcon iconveg5 = new ImageIcon(image5);
                    Image imgveg5 = iconveg5.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg5 = new ImageIcon(imgveg5);
                    picveg5 = new JLabel("", imagconveg5, JLabel.CENTER);
                    vegcart5 = new JButton("Add to cart");
                    vegcart5.addActionListener(handler);

                    picveg5.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname5.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice5.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart5.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg5.add(picveg5);
                    veg5.add(vegname5);
                    veg5.add(vegprice5);
                    veg5.add(vegcart5);
                }
                if(rs.getString("productId").equals("V106")) {
                    vegname6 = new JLabel(rs.getString("name"));
                    vegprice6 = new JLabel("Rs "+String.valueOf(rs.getFloat("price")));
                    byte[] image6 =rs.getBytes("image");
                    ImageIcon iconveg6 = new ImageIcon(image6);
                    Image imgveg5 = iconveg6.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg6 = new ImageIcon(imgveg5);
                    picveg6 = new JLabel("", imagconveg6, JLabel.CENTER);
                    vegcart6 = new JButton("Add to cart");
                    vegcart6.addActionListener(handler);

                    picveg6.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname6.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice6.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart6.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg6.add(picveg6);
                    veg6.add(vegname6);
                    veg6.add(vegprice6);
                    veg6.add(vegcart6);
                }
                if(rs.getString("productId").equals("V107")) {
                    vegname7 = new JLabel(rs.getString("name"));
                    vegprice7 = new JLabel("Rs "+String.valueOf(rs.getFloat("price")));
                    byte[] image7 =rs.getBytes("image");
                    ImageIcon iconveg7 = new ImageIcon(image7);
                    Image imgveg7 = iconveg7.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg7 = new ImageIcon(imgveg7);
                    picveg7 = new JLabel("", imagconveg7, JLabel.CENTER);
                    vegcart7 = new JButton("Add to cart");
                    vegcart7.addActionListener(handler);

                    picveg7.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname7.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice7.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart7.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg7.add(picveg7);
                    veg7.add(vegname7);
                    veg7.add(vegprice7);
                    veg7.add(vegcart7); 
                }
                
                if(rs.getString("productId").equals("V108")) {
                    vegname8 = new JLabel(rs.getString("name"));
                    vegprice8 = new JLabel("Rs "+String.valueOf(rs.getFloat("price")));
                    byte[] image8 =rs.getBytes("image");
                    ImageIcon iconveg8 = new ImageIcon(image8);
                    Image imgveg8 = iconveg8.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg8 = new ImageIcon(imgveg8);
                    picveg8 = new JLabel("", imagconveg8, JLabel.CENTER);
                    vegcart8 = new JButton("Add to cart");
                    vegcart8.addActionListener(handler);

                    picveg8.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname8.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice8.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart8.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg8.add(picveg8);
                    veg8.add(vegname8);
                    veg8.add(vegprice8);
                    veg8.add(vegcart8); 
                }
                
                if(rs.getString("productId").equals("V109")) {
                    vegname9 = new JLabel(rs.getString("name"));
                    vegprice9 = new JLabel("Rs "+String.valueOf(rs.getFloat("price")));
                    byte[] image9 =rs.getBytes("image");
                    ImageIcon iconveg9 = new ImageIcon(image9);
                    Image imgveg9 = iconveg9.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg9 = new ImageIcon(imgveg9);
                    picveg9 = new JLabel("", imagconveg9, JLabel.CENTER);
                    vegcart9 = new JButton("Add to cart");
                    vegcart9.addActionListener(handler);

                    picveg9.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname9.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice9.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart9.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg9.add(picveg9);
                    veg9.add(vegname9);
                    veg9.add(vegprice9);
                    veg9.add(vegcart9); 
                }
                if(rs.getString("productId").equals("V110")) {
                    vegname10 = new JLabel(rs.getString("name"));
                    vegprice10 = new JLabel("Rs "+String.valueOf(rs.getFloat("price")));
                    byte[] image10 =rs.getBytes("image");
                    ImageIcon iconveg10 = new ImageIcon(image10);
                    Image imgveg10 = iconveg10.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg10 = new ImageIcon(imgveg10);
                    picveg10 = new JLabel("", imagconveg10, JLabel.CENTER);
                    vegcart10 = new JButton("Add to cart");
                    vegcart10.addActionListener(handler);

                    picveg10.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname10.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice10.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart10.setAlignmentX(Component.CENTER_ALIGNMENT);
                    
                    veg10.add(picveg10);
                    veg10.add(vegname10);
                    veg10.add(vegprice10);
                    veg10.add(vegcart10); 
                }
                
                if(rs.getString("productId").equals("V111")) {
                    vegname11 = new JLabel(rs.getString("name"));
                    vegprice11 = new JLabel("Rs "+String.valueOf(rs.getFloat("price")));
                    byte[] image11 =rs.getBytes("image");
                    ImageIcon iconveg11 = new ImageIcon(image11);
                    Image imgveg11 = iconveg11.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg11 = new ImageIcon(imgveg11);
                    picveg11 = new JLabel("", imagconveg11, JLabel.CENTER);
                    vegcart11 = new JButton("Add to cart");
                    vegcart11.addActionListener(handler);

                    picveg11.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname11.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice11.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart11.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg11.add(picveg11);
                    veg11.add(vegname11);
                    veg11.add(vegprice11);
                    veg11.add(vegcart11); 
                }
                
                if(rs.getString("productId").equals("V112")) {
                    vegname12 = new JLabel(rs.getString("name"));
                    vegprice12 = new JLabel("Rs "+String.valueOf(rs.getFloat("price")));
                    byte[] image12 =rs.getBytes("image");
                    ImageIcon iconveg12 = new ImageIcon(image12);
                    Image imgveg12 = iconveg12.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg12 = new ImageIcon(imgveg12);
                    picveg12 = new JLabel("", imagconveg12, JLabel.CENTER);
                    vegcart12 = new JButton("Add to cart");
                    vegcart12.addActionListener(handler);

                    picveg12.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegname12.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegprice12.setAlignmentX(Component.CENTER_ALIGNMENT);
                    vegcart12.setAlignmentX(Component.CENTER_ALIGNMENT);

                    veg12.add(picveg12);
                    veg12.add(vegname12);
                    veg12.add(vegprice12);
                    veg12.add(vegcart12); 
                }
                
                if(rs.getString("productId").equals("F101")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart1 = new JButton("Add to cart");
                    fcart1.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart1.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit1.add(picture);
                    fruit1.add(name);
                    fruit1.add(price);
                    fruit1.add(fcart1);

                }
                if(rs.getString("productId").equals("F102")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart2 = new JButton("Add to cart");
                    fcart2.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart2.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit2.add(picture);
                    fruit2.add(name);
                    fruit2.add(price);
                    fruit2.add(fcart2);

                }
                if(rs.getString("productId").equals("F103")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart3 = new JButton("Add to cart");
                    fcart3.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart3.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit3.add(picture);
                    fruit3.add(name);
                    fruit3.add(price);
                    fruit3.add(fcart3);

                }
                if(rs.getString("productId").equals("F104")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart4 = new JButton("Add to cart");
                    fcart4.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart4.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit4.add(picture);
                    fruit4.add(name);
                    fruit4.add(price);
                    fruit4.add(fcart4);

                }
                if(rs.getString("productId").equals("F105")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart5 = new JButton("Add to cart");
                    fcart5.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart5.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit5.add(picture);
                    fruit5.add(name);
                    fruit5.add(price);
                    fruit5.add(fcart5);

                }
                
                if(rs.getString("productId").equals("F106")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart6 = new JButton("Add to cart");
                    fcart6.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart6.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit6.add(picture);
                    fruit6.add(name);
                    fruit6.add(price);
                    fruit6.add(fcart6);

                }
                
                if(rs.getString("productId").equals("F107")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart7 = new JButton("Add to cart");
                    fcart7.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart7.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit7.add(picture);
                    fruit7.add(name);
                    fruit7.add(price);
                    fruit7.add(fcart7);
                
                }
                
                if(rs.getString("productId").equals("F108")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart8 = new JButton("Add to cart");
                    fcart8.addActionListener(handler);
                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart8.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit8.add(picture);
                    fruit8.add(name);
                    fruit8.add(price);
                    fruit8.add(fcart8);
                
                }
                
                if(rs.getString("productId").equals("F109")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart9 = new JButton("Add to cart");
                    fcart9.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart9.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit9.add(picture);
                    fruit9.add(name);
                    fruit9.add(price);
                    fruit9.add(fcart9);
                
                }
                
                if(rs.getString("productId").equals("F110")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart10 = new JButton("Add to cart");
                    fcart10.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart10.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit10.add(picture);
                    fruit10.add(name);
                    fruit10.add(price);
                    fruit10.add(fcart10);
                
                }
                
                if(rs.getString("productId").equals("F111")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart11 = new JButton("Add to cart");
                    fcart11.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart11.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit11.add(picture);
                    fruit11.add(name);
                    fruit11.add(price);
                    fruit11.add(fcart11);
                
                }
                
                if(rs.getString("productId").equals("F112")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image =rs.getBytes("image");
                    ImageIcon iconveg1 = new ImageIcon(image);
                    Image imgveg1 = iconveg1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg1 = new ImageIcon(imgveg1);
                    picture = new JLabel("", imagconveg1, JLabel.CENTER);
                    fcart12 = new JButton("Add to cart");
                    fcart12.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    fcart12.setAlignmentX(Component.CENTER_ALIGNMENT);

                    fruit12.add(picture);
                    fruit12.add(name);
                    fruit12.add(price);
                    fruit12.add(fcart12);
                
                }
                
                if(rs.getString("productId").equals("D101")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image2 =rs.getBytes("image");
                    ImageIcon iconveg2 = new ImageIcon(image2);
                    Image imgveg2 = iconveg2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg2 = new ImageIcon(imgveg2);
                    picture = new JLabel("", imagconveg2, JLabel.CENTER);
                    mcart1 = new JButton("Add to cart");
                    mcart1.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    mcart1.setAlignmentX(Component.CENTER_ALIGNMENT);

                    dairy1.add(picture);
                    dairy1.add(name);
                    dairy1.add(price);
                    dairy1.add(mcart1);
                }
                if(rs.getString("productId").equals("D102")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image2 =rs.getBytes("image");
                    ImageIcon iconveg2 = new ImageIcon(image2);
                    Image imgveg2 = iconveg2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg2 = new ImageIcon(imgveg2);
                    picture = new JLabel("", imagconveg2, JLabel.CENTER);
                    mcart2 = new JButton("Add to cart");
                    mcart2.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    mcart2.setAlignmentX(Component.CENTER_ALIGNMENT);

                    dairy2.add(picture);
                    dairy2.add(name);
                    dairy2.add(price);
                    dairy2.add(mcart2);
                }
                if(rs.getString("productId").equals("D103")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image2 =rs.getBytes("image");
                    ImageIcon iconveg2 = new ImageIcon(image2);
                    Image imgveg2 = iconveg2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg2 = new ImageIcon(imgveg2);
                    picture = new JLabel("", imagconveg2, JLabel.CENTER);
                    mcart3 = new JButton("Add to cart");
                    mcart3.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    mcart3.setAlignmentX(Component.CENTER_ALIGNMENT);

                    dairy3.add(picture);
                    dairy3.add(name);
                    dairy3.add(price);
                    dairy3.add(mcart3);
                }
                if(rs.getString("productId").equals("D104")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image2 =rs.getBytes("image");
                    ImageIcon iconveg2 = new ImageIcon(image2);
                    Image imgveg2 = iconveg2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg2 = new ImageIcon(imgveg2);
                    picture = new JLabel("", imagconveg2, JLabel.CENTER);
                    mcart4 = new JButton("Add to cart");
                    mcart4.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    mcart4.setAlignmentX(Component.CENTER_ALIGNMENT);

                    dairy4.add(picture);
                    dairy4.add(name);
                    dairy4.add(price);
                    dairy4.add(mcart4);
                }

                if(rs.getString("productId").equals("D105")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image2 =rs.getBytes("image");
                    ImageIcon iconveg2 = new ImageIcon(image2);
                    Image imgveg2 = iconveg2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg2 = new ImageIcon(imgveg2);
                    picture = new JLabel("", imagconveg2, JLabel.CENTER);
                    mcart5 = new JButton("Add to cart");
                    mcart5.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    mcart5.setAlignmentX(Component.CENTER_ALIGNMENT);

                    dairy5.add(picture);
                    dairy5.add(name);
                    dairy5.add(price);
                    dairy5.add(mcart5);
                }
                if(rs.getString("productId").equals("D106")) {
                    name = new JLabel(rs.getString("name"));
                    price = new JLabel(String.valueOf("Rs "+rs.getFloat("price")));
                    byte[] image2 =rs.getBytes("image");
                    ImageIcon iconveg2 = new ImageIcon(image2);
                    Image imgveg2 = iconveg2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon imagconveg2 = new ImageIcon(imgveg2);
                    picture = new JLabel("", imagconveg2, JLabel.CENTER);
                    mcart6 = new JButton("Add to cart");
                    mcart6.addActionListener(handler);

                    picture.setAlignmentX(Component.CENTER_ALIGNMENT);
                    name.setAlignmentX(Component.CENTER_ALIGNMENT);
                    price.setAlignmentX(Component.CENTER_ALIGNMENT);
                    mcart6.setAlignmentX(Component.CENTER_ALIGNMENT);

                    dairy6.add(picture);
                    dairy6.add(name);
                    dairy6.add(price);
                    dairy6.add(mcart6);
                }

                dairypanel.add(dairy1);
                dairypanel.add(dairy2);
                dairypanel.add(dairy3);
                dairypanel.add(dairy4);
                dairypanel.add(dairy5);
                dairypanel.add(dairy6);

                fruitpanel.add(fruit1);
                fruitpanel.add(fruit2);
                fruitpanel.add(fruit3);
                fruitpanel.add(fruit4);
                fruitpanel.add(fruit5);
                fruitpanel.add(fruit6);
                fruitpanel.add(fruit7);
                fruitpanel.add(fruit8);
                fruitpanel.add(fruit9);
                fruitpanel.add(fruit10);
                fruitpanel.add(fruit11);
                fruitpanel.add(fruit12);

                vegCenter.add(veg1);
                vegCenter.add(veg2);
                vegCenter.add(veg3);
                vegCenter.add(veg4);
                vegCenter.add(veg5);
                
                vegCenter.add(veg6);
                vegCenter.add(veg7);
                vegCenter.add(veg8);
                vegCenter.add(veg9);
                vegCenter.add(veg10);
                vegCenter.add(veg11);
                vegCenter.add(veg12);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        categorypanel.add(Fruit);
        categorypanel.add(DairyProduct);
        categorypanel.add(Vegetable);

       
        add_product.add(dairypanel, BorderLayout.CENTER);
        add_product.add(vegetablepanel, BorderLayout.CENTER);
        add_product.add(fruitpanel, BorderLayout.CENTER);
        add_product.add(home1, BorderLayout.CENTER);
        add_product.add(categorypanel, BorderLayout.CENTER);
        product.add(add_product);
        /////////////////////////panel for cart///////////////////////////////////
        JPanel home2 =new JPanel();
        GroupLayout groupLayout =new GroupLayout(home2);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        home2.setLayout(groupLayout);
        home2 .setBackground(new Color(67, 186, 246,96));
        product.add(home2);

        JLabel tile_cart =new JLabel("Temporary Cart:");
        remove=new JButton("REMOVE");
        remove.addActionListener(handler);

        payment=new JButton("NEXT");
        payment.addActionListener(handler);

        clear=new JButton("CLEAR ALL");
        clear.addActionListener(handler);

        JLabel total =new JLabel("total price:");
        op_total=new JTextField("0.00");


        model = new DefaultTableModel();
        model.addColumn("ITEM");
        model.addColumn("PRODUCT_ID");
        model.addColumn("PRODUCT_NAME");
        model.addColumn("QUANTITY");
        model.addColumn("PRICE(Rs)");
        table =new JTable();
        table.setModel(model);
        table.setBackground(new Color(195,229,220));
        JScrollPane sp=new JScrollPane(table);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(tile_cart).addComponent(sp)
                .addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(LEADING).addComponent(remove))
                        .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(clear))
                        .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(payment))
                        .addGap(50,50,50)
                        .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(total))
                        .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(op_total))
                )));




        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(tile_cart))
                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(sp))
                .addGroup(groupLayout.createParallelGroup(BASELINE))
                .addGroup(groupLayout.createParallelGroup(LEADING).addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(remove).addComponent(clear).addComponent(payment).addComponent(total).addComponent(op_total))))
                );



        panelcenter.add(home);
        panelcenter.add(product);

        add(back_panel);

        homeMenu.addMenuListener(this);
        productMenu.addMenuListener(this);

    }

    @Override
    public void menuSelected(MenuEvent e) {
        if (e.getSource()==(homeMenu)){
            panelcenter.removeAll();
            panelcenter.repaint();
            panelcenter.revalidate();
            panelcenter.add(home);
            panelcenter.repaint();
            panelcenter.revalidate();

        }
        if(e.getSource()==(productMenu)){
            panelcenter.removeAll();
            panelcenter.repaint();
            panelcenter.revalidate();
            panelcenter.add(product);
            panelcenter.repaint();
            panelcenter.revalidate();
        }

        if(e.getSource()==(categoryMenu)){
            panelcenter.removeAll();
            panelcenter.repaint();
            panelcenter.revalidate();
            panelcenter.add(category);
            panelcenter.repaint();
            panelcenter.revalidate();
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s=output.getText();
            if(e.getActionCommand()=="V"){
                s=s+"V";
                output.setText(s);
            }
            if(e.getActionCommand()=="FF"){
                s=s+"FF";
                output.setText(s);
            }
            if(e.getActionCommand()=="B"){
                s=s+"B";
                output.setText(s);
            }
            if(e.getActionCommand()=="D"){
                s=s+"D";
                output.setText(s);
            }
            if(e.getActionCommand()=="SM"){
                s=s+"SM";
                output.setText(s);
            }
            if(e.getActionCommand()=="F"){
                s=s+"F";
                output.setText(s);
            }
            if(e.getActionCommand()=="1"){
                s=s+"1";
                output.setText(s);
            }
            if(e.getActionCommand()=="2"){
                s=s+"2";
                output.setText(s);
            }
            if(e.getActionCommand()=="3"){
                s=s+"3";
                output.setText(s);
            }
            if(e.getActionCommand()=="4"){
                s=s+"4";
                output.setText(s);
            }
            if(e.getActionCommand()=="5"){
                s=s+"5";
                output.setText(s);
            }
            if(e.getActionCommand()=="6"){
                s=s+"6";
                output.setText(s);
            }
            if(e.getActionCommand()=="7"){
                s=s+"7";
                output.setText(s);
            }
            if(e.getActionCommand()=="8"){
                s=s+"8";
                output.setText(s);
            }
            if(e.getActionCommand()=="9"){
                s=s+"9";
                output.setText(s);
            }
            if(e.getActionCommand()=="0"){
                s=s+"0";
                output.setText(s);
            }
            if(e.getActionCommand()=="AC"){
                output.setText("");
            }
            if(e.getActionCommand()=="ENTER"){
                dbSearchProduct(output.getText());
                output.setText("");
            }
            if(e.getActionCommand()=="CLEAR ALL"){
                if(table.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"Cart is empty.");
                }else {
                    DefaultTableModel tbl=(DefaultTableModel) table.getModel();
                    int rowCount = tbl.getRowCount();
                    for (int i = rowCount - 1; i >= 0; i--) {
                        tbl.removeRow(i);
                    }
                    op_total.setText("");
                }


            }
            if(e.getActionCommand()=="REMOVE"){
                DefaultTableModel tbl=(DefaultTableModel) table.getModel();
                if(table.getSelectedRowCount()==1){
                    tbl.removeRow(table.getSelectedRow());
                    op_total.setText("");
                    Totalprice();
                    for(int i = 0; i < table.getRowCount(); i++){
                        //Object cellValue = table.getValueAt(i,0);
                        table.setValueAt(i+1,i,0);
                    }
                }else {
                    if(table.getRowCount()==0){
                        JOptionPane.showMessageDialog(null,"Cart is empty.");
                    }else {
                        JOptionPane.showMessageDialog(null,"Please select a row to remove.");
                    }
                }
            }
            if(e.getActionCommand()=="NEXT"){
                if(table.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"Cart is empty.");
                }else {
                    PaymentFrame Paymentframe = new PaymentFrame(username);
                    Paymentframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    Paymentframe.setSize(1000, 670);
                    Paymentframe.setLocationRelativeTo(null);
                    Paymentframe.setVisible(true);
                    dispose();
                }
            }if(e.getActionCommand()=="Add product ID"){
                add_product.remove(categorypanel);
                add_product.remove(vegetablepanel);
                add_product.remove(fruitpanel);
                add_product.remove(dairypanel);
                add_product.repaint();
                add_product.revalidate();
                add_product.add(home1);
                add_product.repaint();
                add_product.revalidate();
            }if(e.getActionCommand()=="Category"){
                add_product.remove(home1);
                add_product.remove(vegetablepanel);
                add_product.remove(fruitpanel);
                add_product.remove(dairypanel);
                add_product.repaint();
                add_product.revalidate();
                add_product.add(categorypanel);
                add_product.repaint();
                add_product.revalidate();
            }if(e.getSource()==Vegetable){
                add_product.remove(categorypanel);
                add_product.repaint();
                add_product.revalidate();
                add_product.add(vegetablepanel);
                add_product.repaint();
                add_product.revalidate();
            }if(e.getSource()==Fruit){
                add_product.remove(categorypanel);
                add_product.repaint();
                add_product.revalidate();
                add_product.add(fruitpanel);
                add_product.repaint();
                add_product.revalidate();
            }
            if(e.getSource()==DairyProduct) {
                add_product.remove(categorypanel);
                add_product.repaint();
                add_product.revalidate();
                add_product.add(dairypanel);
                add_product.repaint();
                add_product.revalidate();
            }
            if(e.getSource()==vegcart1){
                output.setText("V101");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart2){
                output.setText("V102");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart3){
                output.setText("V103");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart4){
                output.setText("V104");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart5){
                output.setText("V105");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart6){
                output.setText("V106");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart7){
                output.setText("V107");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart8){
                output.setText("V108");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart9){
                output.setText("V109");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart10){
                output.setText("V110");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart11){
                output.setText("V111");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==vegcart12){
                output.setText("V112");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==fcart1){
                output.setText("F101");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==fcart2){
                output.setText("F102");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==fcart3){
                output.setText("F103");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==fcart4){
                output.setText("F104");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==fcart5){
                output.setText("F105");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==fcart6){
                output.setText("F106");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==fcart7){
                output.setText("F107");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==fcart8){
                output.setText("F108");
                dbSearchProduct(output.getText());
            }
            
            if(e.getSource()==fcart9){
                output.setText("F109");
                dbSearchProduct(output.getText());
            }
            
            if(e.getSource()==fcart10){
                output.setText("F105");
                dbSearchProduct(output.getText());
            }
            
            if(e.getSource()==fcart11){
                output.setText("F111");
                dbSearchProduct(output.getText());
            }
            
            if(e.getSource()==fcart12){
                output.setText("F112");
                dbSearchProduct(output.getText());
            }
           
            if(e.getSource()==mcart1){
                output.setText("D101");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==mcart2){
                output.setText("D102");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==mcart3){
                output.setText("D103");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==mcart4){
                output.setText("D104");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==mcart5){
                output.setText("D105");
                dbSearchProduct(output.getText());
            }
            if(e.getSource()==mcart6){
                output.setText("D106");
                dbSearchProduct(output.getText());
            }
           
        }
    }

    private void dbSearchProduct(String text) {
        Connection connection;
        try{
            Boolean not_found=false;
            connection= DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            Statement s =connection.createStatement();
            s.execute("select p.productId,p.name,p.description,p.type,p.stock,p.price,s.discount from product p LEFT join sale s on p.productId=s.productId");
            ResultSet rs =s.getResultSet();

            while (rs.next()){
                int Counter = 0;
                for(int i = 0; i < table.getRowCount(); i++){
                    for(int j = 0; j < 1; j++){
                        Counter= (int) table.getModel().getValueAt(i,j);
                    }
                }
                String id=(rs.getString("productId"));
                if((id).equals(text)){
                    not_found=true;
                    float discount=1;
                    String textdiscount="";
                    if(rs.getString("productId").equals(text)) {
                        if ((rs.getString("discount")!=(null))) {
                            discount = (float) (100.0 - (Float.parseFloat(rs.getString("discount"))))/100;
                            textdiscount = "(on sale)";
                        }
                    }
                    if ((rs.getString("type")).equals("kg")) {
                        QtyweightFrame Frame = new QtyweightFrame();
                        Frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        Frame.setSize(290, 120);
                        Frame.setVisible(true);

                        if ((rs.getString("type")).equals("kg")&&(QtyweightFrame.weight!=0)&&(QtyweightFrame.inQty==(true))) {
                            model.addRow(new Object[]{Counter+1, text, rs.getString("name")+textdiscount, QtyweightFrame.weight+"(kg)",((rs.getFloat("price") * QtyweightFrame.weight*discount))});
                            Totalprice();
                            QtyweightFrame.inQty=false;
                        }
                    }else{
                        QtyFrame Frame = new QtyFrame();
                        Frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        Frame.setSize(290, 120);
                        Frame.setVisible(true);
                        if ((QtyFrame.qty != 0)&&(QtyFrame.inQty==(true))) {
                            model.addRow(new Object[]{Counter+1, text, rs.getString("name")+textdiscount, QtyFrame.qty, ((rs.getFloat("price") * QtyFrame.qty*discount))});
                            Totalprice();
                            QtyFrame.inQty=false;
                        }
                    }
                }
            }
            if(not_found==false) {
                JOptionPane.showMessageDialog(null, "ProductID does not exist.");
                output.setText("");
            }
            s.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static double total=0.0;
    private void Totalprice() {
        total=0.0;
        for(int i = 0; i < table.getRowCount(); i++){
                total= total+(Float) table.getModel().getValueAt(i,4);
        }
        op_total.setText(String.valueOf(df.format(total)));
    }
    
    

}



