package pricecomparison;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PriceComparison extends JFrame implements ActionListener{
    private JTextField searchField;
    private JButton searchButton;
    private JLabel titleLabel;
    public JTextArea resultArea;
    
    //priceComparison UI
    public PriceComparison(){
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        titleLabel = new JLabel("lah price compare");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Create the search field and button
        searchField = new JTextField();
        searchButton = new JButton("Search");
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        add(searchPanel, BorderLayout.CENTER);

        // Create the result area
        resultArea = new JTextArea(10, 5);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Add action listeners
        searchButton.addActionListener(this);
        searchField.addActionListener(this);
    }
    
    public static void main(String[] args) {
        PriceComparison gui = new PriceComparison();
        gui.setVisible(true);
    }
    
    //actionPerformed gets the user input searchTerm from price comparison ui and sends to checkValidity() then displays products if valid
    public void actionPerformed(ActionEvent e) {
        String searchTerm = searchField.getText();
        resultArea.setText("");
        DataFulfillment df = new DataFulfillment();
        df.checkValidity(searchTerm);
        if(!df.found){
            resultArea.append("No results found.");
        }
        if(df.found){
            String[][] ans = df.makeList(searchTerm);
            resultArea.append(ans[0][0] + " - $" + ans[0][1] + " - " +ans[0][2] + "\n");
            resultArea.append(ans[1][0] + " - $" + ans[1][1] + " - " +ans[1][2] + "\n");
            resultArea.append(ans[2][0] + " - $" + ans[2][1] + " - " +ans[2][2] + "\n");
            resultArea.append(ans[3][0] + " - $" + ans[3][1] + " - " +ans[3][2] + "\n");
        }
    }
}
    