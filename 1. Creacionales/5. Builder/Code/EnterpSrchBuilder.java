import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;
import java.util.*;

public class EnterpSrchBuilder extends UIBuilder{

    private JTextField txtAddress = new JTextField(17);
    private JTextField txtEIN = new JTextField(15);
    private JTextField txtEmail = new JTextField(15);
    private JTextField txtURL = new JTextField(17);
    private JTextField txtPhone = new JTextField(17);

    @Override
    public void addUIControls() {
    searchUI = new JPanel();

    JLabel lblAddress = new JLabel("Address :");
    JLabel lblEIN = new JLabel("Employer Identification Number:");
    JLabel lblEmail = new JLabel("E-mail :");
    JLabel lblURL = new JLabel("URL of web site :");
    JLabel lblPhone = new JLabel("Phone number :");

    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();
    searchUI.add(lblAddress);
    searchUI.add(txtAddress);
    searchUI.add(lblEIN);
    searchUI.add(txtEIN);
    searchUI.add(lblEmail);
    searchUI.add(txtEmail);
    searchUI.add(lblURL);
    searchUI.add(txtURL);
    searchUI.add(lblPhone);
    searchUI.add(txtPhone);

    gbc.anchor = GridBagConstraints.WEST;

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblAddress, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblEIN, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gridbag.setConstraints(lblEmail, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gridbag.setConstraints(lblURL, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gridbag.setConstraints(lblPhone, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(txtAddress, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(txtEIN, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(txtEmail, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gridbag.setConstraints(txtURL, gbc);
    gbc.gridx = 1;
    gbc.gridy = 4;
    gridbag.setConstraints(txtPhone, gbc);
        
    }
    @Override
    public void initialize() {
        txtAddress.setText("Put address here");
        txtEIN.setText("Write Employment ID");
        txtEmail.setText("example@enter.com");
        txtURL.setText("myEnter.com");
        txtPhone.setText("(999)999-9999");
    }
    @Override
    public String getSQL() {
        return ("Select * from Enterprise where Address='" +
        txtAddress.getText() + "'" + " with EIN='" +
        txtEIN.getText() + "', E-mail='" +
        txtEmail.getText() + "'"+", URL='" +
        txtURL.getText()+ "'"+" and Phone number='" +
        txtPhone.getText());
    }
}
