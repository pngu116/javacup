package pricecomparison;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * LoginPage --- program that creates the login page
 *
 * @author Timmy Tran
 */
public class LoginPage implements ActionListener {

    private JFrame frame;
    private JButton loginButton;
    private JButton resetButton;
    private JTextField userField;
    private JPasswordField passwordField;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel messageLabel;
    private JCheckBox showPassword;

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    /**
     * Creates the JFrame
     *
     * @param newLoginInfo A HashMap containing user and password
     */
    LoginPage(HashMap<String, String> newLoginInfo) {
        loginInfo = newLoginInfo;

        userLabel = new JLabel("User:");
        userLabel.setBounds(50, 50, 75, 25);
        userField = new JTextField();
        userField.setBounds(125, 50, 200, 25);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 85, 75, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(125, 85, 200, 25);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(125, 115, 150, 20);
        showPassword.addActionListener(this);

        loginButton = new JButton("Login");
        loginButton.setBounds(125, 150, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.setBounds(225, 150, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        messageLabel = new JLabel();
        messageLabel.setBounds(125, 200, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        frame = new JFrame();
        frame.setTitle("Price Comparer Login");
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(showPassword);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(messageLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     * A specific action happens when a button on the JFrame is pressed
     *
     * @param e Action Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userField.getText();
            String password = String.valueOf(passwordField.getPassword());
            
            if (loginInfo.containsKey(user)) {
                if (loginInfo.get(user).equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                    frame.dispose();
                    PriceComparison gui = new PriceComparison();
                    gui.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "User Not Found");
            }
        }
        
        if (e.getSource() == resetButton) {
            userField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
}
