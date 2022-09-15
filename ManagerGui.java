package GUI;

import com.sun.source.tree.WhileLoopTree;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static javax.swing.GroupLayout.Alignment.*;

public class ManagerGui extends JFrame {
    DefaultTableModel model;
    private JButton add;
    private JButton delete;
    private JButton update;
    private JButton refund;
    private JButton discount;
    private JList orderlist;
    private JTable table;
    private JScrollPane sp;
    private JPanel addproduct;
    private JPanel deleteprodcut;
    private JPanel updateprodcut;
    private JPanel refundprodcut;
    private JPanel discountpanel;
    private JButton insert;
    private JButton D_delete;
    private JButton U_update;
    private JButton R_refund;
    private JPanel left_panel;
    private JButton search;
    private  JTextField id_txt;
    private JTextField name_txt;
    private JTextField description_txt;
    private JTextField type_txt;
    private JTextField stock_txt;
    private JTextField price_txt;
    private JTextField date_txt;
    private JTextField distributor_txt;
    private JTextField Did_txt;
    private JTextField uname_txt;
    private  JTextField udescription_txt;
    private JTextField utype_txt;
    private JTextField ustock_txt;
    private JTextField uprice_txt;
    private JTextField udate_txt;
    private JTextField udistributor_txt;
    private JTextField uId;
    private JTextField purchaseId;
    private JTextField Refund_prodId;
    private JTextField percentage;
    private JTextField p;
    private JComboBox reasonlist;
    private JTextField qty;
    private JTextField clienttxt;
    private JTextField incometxt;
    private JTextField s_prod_id;
    private JTextField discount_field;
    private JButton set;
    DefaultListModel listModel = new DefaultListModel();
    private DateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd");
    private static DecimalFormat df = new DecimalFormat("0.00");
    public java.util.Date date=new java.util.Date();
    public ManagerGui() {
        super("Admin Page");
        JPanel back_panel=new JPanel();
        back_panel.setLayout(new GridLayout(1,2));
        JPanel Right_panel=new JPanel();
        left_panel=new JPanel();
        Right_panel.setBackground(new Color(255,255,166));                //new Color(246,216,171)
        left_panel.setBackground(new Color(255,255,166));
        GroupLayout layout =new GroupLayout(Right_panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        Right_panel.setLayout(layout);

        back_panel.add(Right_panel);
        back_panel.add(left_panel);
        add(back_panel);


        ////////////////////////////////info supermarket panel//////////////////////////////////////////////
        JPanel info_market =new JPanel(new GridLayout(3,2));
        info_market.setBorder(BorderFactory.createTitledBorder("Fresh Farm Info"));
        info_market.setBackground(Color.BLACK);
        JLabel from = new JLabel("From");
        JLabel to = new JLabel("To");
        JLabel numClient = new JLabel("Number of client:");
        JLabel income = new JLabel("Income:");
        clienttxt=new JTextField();
        incometxt=new JTextField();
        JDateChooser dateChooser1 =new JDateChooser();
        dateChooser1.setDateFormatString("yyyy-MM-dd");
        JDateChooser dateChooser2 =new JDateChooser();
        dateChooser2.setDateFormatString("yyyy-MM-dd");
        search =new JButton("SEARCH");
        JPanel datefrom =new JPanel(new FlowLayout());
        datefrom.setBackground(Color.WHITE);
        datefrom.add(from);
        datefrom.add(dateChooser1);
        JPanel dateto =new JPanel(new FlowLayout());
        dateto.setBackground(Color.WHITE);
        dateto.add(to);
        dateto.add(dateChooser2);
        dateto.add(search);
        info_market.add(datefrom);
        info_market.add(dateto);
        info_market.add(numClient);
        info_market.add(clienttxt);
        info_market.add(income);
        info_market.add(incometxt);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = Date.valueOf(df.format(dateChooser1.getDate()));
                Date date2 = Date.valueOf(df.format(dateChooser2.getDate()));
                if ((Date.valueOf(df.format(dateChooser1.getDate())) == null)||(Date.valueOf(df.format(dateChooser2.getDate())) == null)){
                    JOptionPane.showMessageDialog(null,"Date missing.");
                }else if (date1.after(date2)){
                    JOptionPane.showMessageDialog(null,"Invalid date.");
                }else {
                    calc_date(date1,date2);
                }
            }
        });
        ////////////////////////////////Order panel//////////////////////////////////////////
        JPanel order =new JPanel(new BorderLayout());
        order.setBackground(Color.WHITE);
        JLabel txt_order =new JLabel("Item list that are nearly out of stock(less than15 units/5 kg):");
        order.add(txt_order,BorderLayout.NORTH);
        orderlist=new JList(listModel);
        orderlist.setForeground(Color.RED);
        orderlist.setVisibleRowCount(10);
        orderlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        order.add(new JScrollPane(orderlist),BorderLayout.CENTER);
        DBorder();
        ////////////////////////////////admin action panel//////////////////////////////////////////
        JPanel admin_action =new JPanel(new GridLayout(5,1,10,7));
        admin_action.setBackground(Color.WHITE);
        admin_action.setBorder(BorderFactory.createTitledBorder("Admin Action"));
        add=new JButton("Add Product");
        delete=new JButton("Delete Product");
        update=new JButton("Update Product");
        refund=new JButton("Refund Product");
        discount=new JButton("Add Discount");
        admin_action.add(update);
        admin_action.add(delete);
        admin_action.add(add);
        admin_action.add(refund);
        admin_action.add(discount);
        ButtonHandler handler =new ButtonHandler();
        add.addActionListener(handler);
        delete.addActionListener(handler);
        update.addActionListener(handler);
        refund.addActionListener(handler);
        discount.addActionListener(handler);
        /////////////////////////group layout for right panel//////////////////////////////////////
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(LEADING).addComponent(info_market).addComponent(order).addComponent(admin_action))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE).addComponent(info_market,140,140,140))
                .addGroup(layout.createParallelGroup(BASELINE).addComponent(order,160,160,160))
                .addGroup(layout.createParallelGroup(BASELINE).addComponent(admin_action,240,240,240))
        );

        ////////////////////////////////Left panel///////////////////////////////////////////////
        GroupLayout gl =new GroupLayout(left_panel);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        left_panel.setLayout(gl);

        model = new DefaultTableModel();
        model.addColumn("PRODUCT_ID");
        model.addColumn("PRODUCT_NAME");
        model.addColumn("TYPE");
        model.addColumn("STOCK");
        model.addColumn("PRICE(Rs)");
        model.addColumn("EXPIRE DATE");
        table =new JTable();
        table.setModel(model);
        table.setBackground(Color.WHITE);
        sp=new JScrollPane(table);
        sp.setBackground(Color.WHITE);
        table.disable();
        fillTable();

        ////////////////////////////////add product panel///////////////////////////////////////////////
        insert=new JButton("INSERT");
        insert.addActionListener(handler);
        addproduct =new JPanel(new BorderLayout());
        addproduct.setBackground(Color.WHITE);
        addproduct.setBorder(BorderFactory.createTitledBorder("Add Product"));
        JLabel txt1 =new JLabel("Add details of the new product:");
        JPanel center =new JPanel(new GridLayout(4,4,10,40));
        JLabel id =new JLabel("productId:");
        JLabel name =new JLabel("name:");
        JLabel description =new JLabel("description:");
        JLabel type =new JLabel("type:");
        JLabel stock =new JLabel("stock:");
        JLabel price =new JLabel("price:");
        JLabel expire =new JLabel("expire date:");
        JLabel distributor =new JLabel("distributor:");

        id_txt =new JTextField();
        name_txt =new JTextField();
        description_txt =new JTextField();
        type_txt =new JTextField();
        stock_txt =new JTextField();
        price_txt =new JTextField();
        date_txt =new JTextField();
        distributor_txt =new JTextField();

        center.add(id);
        center.add(id_txt);
        center.add(name);
        center.add(name_txt);
        center.add(description);
        center.add(description_txt);
        center.add(type);
        center.add(type_txt);
        center.add(stock);
        center.add(stock_txt);
        center.add(price);
        center.add(price_txt);
        center.add(expire);
        center.add(date_txt);
        center.add(distributor);
        center.add(distributor_txt);
        center.setBackground(Color.WHITE);

        addproduct.add(txt1,BorderLayout.NORTH);
        addproduct.add(center,BorderLayout.CENTER);
        addproduct.add(insert,BorderLayout.SOUTH);

        ////////////////////////////////delete product panel///////////////////////////////////////////////
        deleteprodcut=new JPanel(new BorderLayout());
        deleteprodcut.setBackground(Color.WHITE);
        deleteprodcut.setBorder(BorderFactory.createTitledBorder("Delete Product"));
        JLabel txt2=new JLabel("Enter the id of the product that you want to delete:");
        D_delete=new JButton("DELETE");
        D_delete.addActionListener(handler);

        JPanel D_center=new JPanel(new GridLayout(1,2,20,20));
        JLabel Did =new JLabel("productId:");
        Did_txt =new JTextField();

        D_center.add(Did);
        D_center.add(Did_txt);
        D_center.setBackground(Color.WHITE);
        deleteprodcut.add(D_center,BorderLayout.CENTER);
        deleteprodcut.add(txt2,BorderLayout.NORTH);
        deleteprodcut.add(D_delete,BorderLayout.SOUTH);
        ////////////////////////////////update product panel///////////////////////////////////////////////
        updateprodcut=new JPanel(new BorderLayout());
        updateprodcut.setBackground(Color.WHITE);
        JPanel updatenorth =new JPanel(new GridLayout(1,2));
        updateprodcut.setBorder(BorderFactory.createTitledBorder("Update Product"));
        JLabel txt3 =new JLabel("Enter the product Id you want to update :");
        uId =new JTextField();

        JPanel ucenter =new JPanel(new GridLayout(4,4,10,40));
        JLabel uname =new JLabel("name:");
        JLabel udescription =new JLabel("description:");
        JLabel utype =new JLabel("type:");
        JLabel ustock =new JLabel("stock:");
        JLabel uprice =new JLabel("price:");
        JLabel uexpire =new JLabel("expire date:");
        JLabel udistributor =new JLabel("distributor:");

        uname_txt =new JTextField();
        udescription_txt =new JTextField();
        utype_txt =new JTextField();
        ustock_txt =new JTextField();
        uprice_txt =new JTextField();
        udate_txt =new JTextField();
        udistributor_txt =new JTextField();
        U_update=new JButton("UPDATE");
        U_update.addActionListener(handler);

        TextFieldHandler txt_handler =new TextFieldHandler();
        uId.addActionListener(txt_handler);

        ucenter.add(uname);
        ucenter.add(uname_txt);
        ucenter.add(udescription);
        ucenter.add(udescription_txt);
        ucenter.add(utype);
        ucenter.add(utype_txt);
        ucenter.add(ustock);
        ucenter.add(ustock_txt);
        ucenter.add(uprice);
        ucenter.add(uprice_txt);
        ucenter.add(uexpire);
        ucenter.add(udate_txt);
        ucenter.add(udistributor);
        ucenter.add(udistributor_txt);
        ucenter.setBackground(Color.WHITE);

        updatenorth.setBackground(Color.WHITE);
        updatenorth.add(txt3);
        updatenorth.add(uId);

        updateprodcut.add(updatenorth,BorderLayout.NORTH);
        updateprodcut.add(ucenter,BorderLayout.CENTER);
        updateprodcut.add(U_update,BorderLayout.SOUTH);


        ////////////////////////////////refund product panel///////////////////////////////////////////////
        String[] reason = { "Damage product", "Expired product", "Wardrobing","Not specify"};

        refundprodcut=new JPanel();
        GroupLayout subgroup =new GroupLayout(refundprodcut);
        refundprodcut.setLayout(subgroup);
        subgroup.setAutoCreateGaps(true);
        subgroup.setAutoCreateContainerGaps(true);
        refundprodcut.setBackground(Color.WHITE);
        refundprodcut.setBorder(BorderFactory.createTitledBorder("Refund Product"));
        JLabel txt4 =new JLabel("Enter the purchase Id of the product you want to refund:");
        JLabel txt5 =new JLabel("Enter the product Id:");
        JLabel txt6 =new JLabel("Enter the percentage to be refund(%):");
        JLabel txt7 =new JLabel("Reason for refund:");
        JLabel txt8 =new JLabel("Refund price(Rs):");
        JLabel txt9 =new JLabel("Quantity of product to refund:");
        R_refund =new JButton("REFUND");
        R_refund.addActionListener(handler);

        purchaseId =new JTextField();
        Refund_prodId =new JTextField();
        percentage =new JTextField();
        p =new JTextField();
        reasonlist=new JComboBox(reason);
        qty=new JTextField("1");
        percentage.addActionListener(txt_handler);


        subgroup.setHorizontalGroup(subgroup.createParallelGroup(CENTER)
                .addGroup(subgroup.createSequentialGroup().addGroup(subgroup.createParallelGroup(LEADING).addComponent(txt4))
                        .addGroup(subgroup.createParallelGroup(LEADING).addComponent(purchaseId))
                )
                .addGroup(subgroup.createSequentialGroup().addGroup(subgroup.createParallelGroup(LEADING).addComponent(txt5))
                        .addGap(211,211,211)
                        .addGroup(subgroup.createParallelGroup(LEADING).addComponent(Refund_prodId))
                )
                .addGroup(subgroup.createSequentialGroup().addGroup(subgroup.createParallelGroup(LEADING).addComponent(txt7))
                        .addGap(200,200,200)
                        .addGroup(subgroup.createParallelGroup(LEADING).addComponent(reasonlist))
                )

                .addGroup(subgroup.createSequentialGroup().addGroup(subgroup.createParallelGroup(LEADING).addComponent(txt6))
                        .addGap(115,117,117)
                        .addGroup(subgroup.createParallelGroup(LEADING).addComponent(percentage))
                )
                .addGroup(subgroup.createSequentialGroup().addGroup(subgroup.createParallelGroup(LEADING).addComponent(txt9))
                        .addGap(160,160,160)
                        .addGroup(subgroup.createParallelGroup(LEADING).addComponent(qty))
                )
                .addGroup(subgroup.createSequentialGroup().addGroup(subgroup.createParallelGroup(LEADING).addComponent(txt8))
                        .addGap(227,227,227)
                        .addGroup(subgroup.createParallelGroup(LEADING).addComponent(p))
                )


                .addGroup(subgroup.createParallelGroup(CENTER).addComponent(R_refund))
        );
        subgroup.setVerticalGroup(subgroup.createSequentialGroup()
            .addGroup(subgroup.createParallelGroup(BASELINE).addGroup(subgroup.createSequentialGroup()
                        .addGroup(subgroup.createParallelGroup(BASELINE).addComponent(txt4).addComponent(purchaseId))))
                .addGroup(subgroup.createParallelGroup(BASELINE).addGroup(subgroup.createSequentialGroup()
                        .addGroup(subgroup.createParallelGroup(BASELINE).addComponent(txt5).addComponent(Refund_prodId))))
                .addGroup(subgroup.createParallelGroup(BASELINE).addGroup(subgroup.createSequentialGroup()
                        .addGroup(subgroup.createParallelGroup(BASELINE).addComponent(txt7).addComponent(reasonlist))))

                .addGroup(subgroup.createParallelGroup(BASELINE).addGroup(subgroup.createSequentialGroup()
                        .addGroup(subgroup.createParallelGroup(BASELINE).addComponent(txt6).addComponent(percentage))))

                .addGroup(subgroup.createParallelGroup(BASELINE).addGroup(subgroup.createSequentialGroup()
                        .addGroup(subgroup.createParallelGroup(BASELINE).addComponent(txt9).addComponent(qty))))

                .addGroup(subgroup.createParallelGroup(BASELINE).addGroup(subgroup.createSequentialGroup()
                        .addGroup(subgroup.createParallelGroup(BASELINE).addComponent(txt8).addComponent(p))))

                .addGroup(subgroup.createParallelGroup(BASELINE).addGroup(subgroup.createSequentialGroup()
                        .addGroup(subgroup.createParallelGroup(CENTER).addComponent(R_refund))))
        );
        ////////////////////////////////add discount panel/////////////////////////////////////////////////
        discountpanel =new JPanel(new BorderLayout());
        discountpanel.setBackground(Color.WHITE);
        discountpanel.setBorder(BorderFactory.createTitledBorder("Add Discount"));
        JPanel scenter =new JPanel(new GridLayout(2,2));
        scenter.setBackground(Color.WHITE);
        JLabel s_productId =new JLabel("Enter productId:");
        JLabel s_discount =new JLabel("Enter discount:");
        s_prod_id=new JTextField();
        discount_field=new JTextField();
        set =new JButton("SET DISCOUNT");
        set.addActionListener(handler);
        scenter.add(s_productId);
        scenter.add(s_prod_id);
        scenter.add(s_discount);
        scenter.add(discount_field);
        discountpanel.add(scenter,BorderLayout.CENTER);
        discountpanel.add(set,BorderLayout.SOUTH);
        ////////////////////////////////group layout for left panel////////////////////////////////////////
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(LEADING).addComponent(sp).addComponent(addproduct).addComponent(deleteprodcut).addComponent(updateprodcut).addComponent(refundprodcut).addComponent(discountpanel))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(BASELINE).addComponent(sp))
                .addGroup(gl.createParallelGroup(BASELINE).addComponent(addproduct,300,300,300))
                .addGroup(gl.createParallelGroup(BASELINE).addComponent(deleteprodcut,100,100,100))
                .addGroup(gl.createParallelGroup(BASELINE).addComponent(updateprodcut,300,300,300))
                .addGroup(gl.createParallelGroup(BASELINE).addComponent(refundprodcut))
                .addGroup(gl.createParallelGroup(BASELINE).addComponent(discountpanel,100,100,100))
        );

        addproduct.setVisible(false);
        deleteprodcut.setVisible(false);
        updateprodcut.setVisible(false);
        refundprodcut.setVisible(false);
        discountpanel.setVisible(false);
    }

    private void calc_date(Date date1, Date date2) {
        java.util.Date purcahse_date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Connection connection;
        int count_person=0;
        float total_Income=0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("select * from purchase");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                purcahse_date= sdf.parse(rs.getString("date"));
                if((purcahse_date.before(date2)&&(purcahse_date.after(date1)))||((purcahse_date.equals(date1))&&(purcahse_date.before(date2)))||((purcahse_date.after(date1))&&(purcahse_date.equals(date2))) || ((purcahse_date.equals(date1))&&(purcahse_date.equals(date2)))){
                    count_person++;
                    total_Income=total_Income+(rs.getFloat("totalprice"));
                }
            }
            clienttxt.setText(String.valueOf(count_person));
            incometxt.setText(String.valueOf(df.format(total_Income)));
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void DBorder() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("select * from product");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
               if(rs.getString("type").equals("unit")&&(rs.getInt("stock")<15)){
                        listModel.addElement(rs.getString("productId"));
               }
               if(rs.getString("type").equals("kg")&&(rs.getInt("stock")<5)){
                   listModel.addElement(rs.getString("productId"));
                }
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillTable() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("select * from product");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("productId"), rs.getString("name"),rs.getString("type"),rs.getString("stock"),rs.getFloat("price"),rs.getString("expire_date") });
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean found=false;
            if (e.getSource()==(add)){
                removeRow();
                addproduct.setVisible(true);
                deleteprodcut.setVisible(false);
                updateprodcut.setVisible(false);
                refundprodcut.setVisible(false);
                discountpanel.setVisible(false);
                sp.setVisible(false);
            }
            if (e.getSource()==(update)){
                removeRow();
                addproduct.setVisible(false);
                deleteprodcut.setVisible(false);
                updateprodcut.setVisible(true);
                refundprodcut.setVisible(false);
                discountpanel.setVisible(false);
                sp.setVisible(false);
            }
            if (e.getSource()==(delete)){
                removeRow();
                addproduct.setVisible(false);
                deleteprodcut.setVisible(true);
                updateprodcut.setVisible(false);
                refundprodcut.setVisible(false);
                discountpanel.setVisible(false);
                sp.setVisible(false);
            }
            if (e.getSource()==(refund)){
                removeRow();
                addproduct.setVisible(false);
                deleteprodcut.setVisible(false);
                updateprodcut.setVisible(false);
                refundprodcut.setVisible(true);
                discountpanel.setVisible(false);
                sp.setVisible(false);
            }
            if (e.getSource()==(discount)){
                removeRow();
                addproduct.setVisible(false);
                deleteprodcut.setVisible(false);
                updateprodcut.setVisible(false);
                refundprodcut.setVisible(false);
                discountpanel.setVisible(true);
                sp.setVisible(false);
            }
            if (e.getSource()==(insert)){
                if((id_txt.getText().equals(""))||(name_txt.getText().equals(""))||(description_txt.getText().equals(""))||(type_txt.getText().equals(""))||(stock_txt.getText().equals(""))||(price_txt.getText().equals(""))||(date_txt.getText().equals(""))||(distributor_txt.getText().equals(""))){
                    JOptionPane.showMessageDialog(null,"Some field are empty.");
                }else if(type_txt.getText().equals("unit")||(type_txt.getText().equals("kg"))){
                    int txt_stck = Integer.parseInt(stock_txt.getText());
                    float txt_price = Float.parseFloat(price_txt.getText());
                        if((txt_stck>0)&&(txt_price>0)){
                           insert_db();
                           found=true;
                        }else {
                            JOptionPane.showMessageDialog(null,"Textfield stock or price should be greater than 0.");
                        }
                }else {
                    JOptionPane.showMessageDialog(null,"Textfield type should contain either 'unit' or 'kg'.");
                }
                if(found){
                    clear_refill();
                    found=false;
                }

            }
            if (e.getSource()==(D_delete)){
                if(Did_txt.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Textfield id should not be null.");
                }else {
                    Row_db();
                    found=true;
                }
                if(found){
                    clear_refill();
                    found=false;
                }
            }
            if (e.getSource()==(U_update)){
                if((uname_txt.getText().equals(""))||(udescription_txt.getText().equals(""))||(utype_txt.getText().equals(""))||(ustock_txt.getText().equals(""))||(uprice_txt.getText().equals(""))||(udate_txt.getText().equals(""))||(udistributor_txt.getText().equals(""))){
                    JOptionPane.showMessageDialog(null,"Some field are empty.");
                }else if(utype_txt.getText().equals("unit")||(utype_txt.getText().equals("kg"))){
                    int txt_stck = Integer.parseInt(ustock_txt.getText());
                    float txt_price = Float.parseFloat(uprice_txt.getText());
                    if((txt_stck>0)&&(txt_price>0)){
                        update_db();
                        found=true;
                    }else {
                        JOptionPane.showMessageDialog(null,"Textfield stock or price should be greater than 0.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Textfield type should contain either 'unit' or 'kg'.");
                }
                if(found){
                    clear_refill();
                    found=false;
                }
            }
            if (e.getSource()==(R_refund)){
                if((purchaseId.getText().equals(""))||(Refund_prodId.getText().equals(""))||(percentage.getText().equals(""))||(p.getText().equals(""))){
                        JOptionPane.showMessageDialog(null,"Some field are empty.");
                }else {
                   Refund_db();
                   found=true;
                }
                if(found){
                    clear_refill();
                    found=false;
                }
            }
            if (e.getSource()==(set)){
                boolean search =false;
                if((s_prod_id.getText().equals(""))||(discount_field.getText().equals(""))){
                    JOptionPane.showMessageDialog(null,"Some field are empty.");
                }else {
                    Connection connection;
                    try {
                        connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
                        Statement s = connection.createStatement();
                        s.execute("SELECT * FROM product");
                        ResultSet rs = s.getResultSet();
                        while (rs.next()) {
                                if(rs.getString("productId").equals(s_prod_id.getText())){
                                    search =true;
                                    int discount = Integer.parseInt(discount_field.getText());
                                    if(discount>0&&discount<=100){
                                        sale_db();
                                        found=true;
                                    }else {
                                        JOptionPane.showMessageDialog(null,"discount out of range.");
                                    }
                                }
                        }
                        if(!search){
                            JOptionPane.showMessageDialog(null,"product Id not found.");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if(found){
                    clear_refill();
                    found=false;
                }
            }
        }
    }

    private void sale_db() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("INSERT  INTO sale VALUES ('"+count_saleId()+"','"+s_prod_id.getText()+"','"+discount_field.getText()+"')");
            JOptionPane.showMessageDialog(null,"Add discount successfully.");
            s_prod_id.setText("");
            discount_field.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clear_refill() {
        addproduct.setVisible(false);
        deleteprodcut.setVisible(false);
        updateprodcut.setVisible(false);
        refundprodcut.setVisible(false);
        discountpanel.setVisible(false);
        sp.setVisible(true);
        fillTable();
    }

    private boolean checkpurchaseId(boolean exist) {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("SELECT * FROM purchase");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                if (rs.getString("purchaseId").equals(purchaseId.getText())){
                    if(rs.getString("productId").equals(Refund_prodId.getText())){
                        exist=true;
                    }else {
                        JOptionPane.showMessageDialog(null,"Invalid product Id.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid purchase Id.");
                }
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    private int count_saleId(){
        Connection connection;
        int count=0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("SELECT * FROM sale");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                count++;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count+1;
    }

    private int count_Id(){
        Connection connection;
        int count=0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("SELECT * FROM refund");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                count++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count+1;
    }
    private void Refund_db() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("INSERT  INTO refund values ('"+count_Id()+"','"+purchaseId.getText()+"','"+Refund_prodId.getText()+"','"+dateFormat.format(date)+"','"+p.getText()+"','"+reasonlist.getSelectedItem()+"')");
            JOptionPane.showMessageDialog(null,"Refund successful.");
            purchaseId.setText("");
            Refund_prodId.setText("");
            percentage.setText("");
            qty.setText("1");
            p.setText("");
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeRow() {
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--)
        {
            model.removeRow(i);
        }
    }

    private void update_db() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("UPDATE product SET productId='"+uId.getText()+"',name='"+uname_txt.getText()+"',description='"+udescription_txt.getText()+"',type='"+utype_txt.getText()+"',stock='"+ustock_txt.getText()+"',price='"+uprice_txt.getText()+"',expire_date='"+udate_txt.getText()+"',distributor='"+udistributor_txt.getText()+"'where productId='"+uId.getText()+"'");
            JOptionPane.showMessageDialog(null,"Update successful.");
            uId.setText("");
            uname_txt.setText("");
            udescription_txt.setText("");
            utype_txt.setText("");
            ustock_txt.setText("");
            uprice_txt.setText("");
            udate_txt.setText("");
            udistributor_txt.setText("");
            s.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void Row_db() {
        Connection connection;
        boolean find =false;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("SELECT * FROM product");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
              if (rs.getString("productId").equals(Did_txt.getText())){
                  find=DeleteRow(find);
                  break;
              }
            }
            Did_txt.setText("");
            if(!find){
                JOptionPane.showMessageDialog(null,"Id does not exist.");
            }
            rs.close();
            s.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean DeleteRow(boolean find) {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            find = true;
            s.execute("DELETE FROM product WHERE productId='"+ Did_txt.getText()+"'");
            JOptionPane.showMessageDialog(null, "Delete successful.");
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return find;
    }

    private void insert_db() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement s = connection.createStatement();
            s.execute("INSERT  INTO product values ('"+id_txt.getText()+"','"+name_txt.getText()+"','"+description_txt.getText()+"','"+type_txt.getText()+"','"+stock_txt.getText()+"','"+price_txt.getText()+"','"+date_txt.getText()+"','"+distributor_txt.getText()+"')");
            JOptionPane.showMessageDialog(null,"Insert successful.");
            id_txt.setText("");
            name_txt.setText("");
            description_txt.setText("");
            type_txt.setText("");
            stock_txt.setText("");
            price_txt.setText("");
            date_txt.setText("");
            distributor_txt.setText("");

            s.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == (uId)) {
                if (uId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Id should not be null.");
                } else {
                    Connection connection;
                    try {
                        connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
                        Statement s = connection.createStatement();
                        s.execute("SELECT * FROM product");
                        ResultSet rs = s.getResultSet();
                        while (rs.next()) {
                            if (rs.getString("productId").equals(uId.getText())) {
                                uname_txt.setText(rs.getString("name"));
                                udescription_txt.setText(rs.getString("description"));
                                utype_txt.setText(rs.getString("type"));
                                ustock_txt.setText(rs.getString("stock"));
                                uprice_txt.setText(rs.getString("price"));
                                udate_txt.setText(rs.getString("expire_date"));
                                udistributor_txt.setText(rs.getString("distributor"));
                            }
                        }
                        rs.close();
                        s.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (event.getSource() == (percentage)) {
                boolean exist =false;
                if (purchaseId.getText().equals("") || (Refund_prodId.getText().equals("")) || (percentage.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Some field are empty.");
                } else {
                    boolean check=checkpurchaseId(exist);
                    if(check) {
                        Connection connection;
                        try {
                            connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
                            Statement s = connection.createStatement();
                            s.execute("SELECT  * FROM  product");
                            ResultSet rs = s.getResultSet();
                            while (rs.next()) {
                                if (rs.getString("productId").equals(Refund_prodId.getText())) {
                                    Float percent = Float.valueOf(((percentage.getText())));
                                    if((percent<0)||(percent>75)){
                                        JOptionPane.showMessageDialog(null, "percentage should be in the range of 0%-75%.");
                                    }else {
                                        int quntiT = Integer.parseInt(qty.getText());
                                        percent=percent/100;
                                        float total =(rs.getFloat("price")*percent*quntiT);
                                        p.setText(String.valueOf(df.format(total)));
                                    }
                                }

                            }
                            rs.close();
                            s.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}