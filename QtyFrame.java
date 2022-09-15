package GUI;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class QtyFrame extends JDialog {
    static int qty =0;
    private JButton button;
    private JTextField textField;
    static boolean inQty=false;
    public QtyFrame(){

        super((Window)null);
        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);
        //super("Quantity of product");
        JPanel panel =new JPanel();
        panel.setLayout(new MigLayout("","10[75]10[75]10[100]10","10[30]10[30]10"));
        JLabel label= new JLabel("Enter quantity(unit) :");
        textField =new JTextField("0");
        button =new JButton("NEXT");
        ButtonHandler handler =new ButtonHandler();
        button.addActionListener(handler);

        panel.add(label,"grow,span 2");
        panel.add(textField,"wrap,grow");
        panel.add(button,"cell 1 1,grow");
        add(panel);

    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s=textField.getText();
            inQty=true;
            if (s.equals("") ||s.equals("0")){
                JOptionPane.showMessageDialog(null,"Textfield quantity should not be empty.");
                inQty=false;
            }else {
                if (!(s.matches("[0-9]+"))) {
                    JOptionPane.showMessageDialog(null, "Textfield quantity should be numbers only.");
                    textField.setText("");
                    inQty=false;
                } else {
                    Connection connection;
                    try {
                        connection = DriverManager.getConnection("jdbc:mysql://localhost/market?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
                        Statement stm = connection.createStatement();
                        stm.execute("select * from product");
                        ResultSet rs = stm.getResultSet();
                        while (rs.next()) {
                            String num =rs.getString("productId");
                            if (num.equals(HomeFrame.output.getText())){
                                if(rs.getInt("stock")>=Integer.parseInt(textField.getText())){
                                    qty = Integer.parseInt(textField.getText());
                                    textField.setText("");
                                    dispose();
                                }else {
                                    JOptionPane.showMessageDialog(null,"Out of stock.");
                                    inQty=false;
                                }
                            }
                        }
                    } catch (SQLException event) {
                        event.printStackTrace();
                    }
                }
            }
        }
    }
}
