package pricecomparison;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
//added
import javax.swing.JTextArea;

public class PriceComparison extends JFrame implements ActionListener{
    private JTextField searchField;
    private JButton searchButton;
    private JLabel titleLabel;
    public JTextArea resultArea;
    //added
    //public JComboBox menu;
    public JMenuBar menuBar;
    public JMenu menu;
    
    //priceComparison UI
    public PriceComparison(){
        setSize(350, 300);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        titleLabel = new JLabel("lah price compare");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        add(titleLabel, BorderLayout.NORTH);
        
        //creates the menubar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Option");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        JMenu storeMenu = new JMenu("Stores");
        JMenuItem walmart = new JMenuItem("Walmart");
        JMenuItem winndixie = new JMenuItem("Winndixie");
        JMenuItem target = new JMenuItem("Target");
        JMenuItem rouses = new JMenuItem("Rouses");
        storeMenu.add(walmart);
        storeMenu.add(winndixie);
        storeMenu.add(target);
        storeMenu.add(rouses);
        menuBar.add(storeMenu);
        setJMenuBar(menuBar);

        // Create the search field and button
        
        searchField = new JTextField(5);
        
        
        searchButton = new JButton("Search");
        
        JPanel searchPanel = new JPanel(new BorderLayout(0,2));
        //searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.setPreferredSize(new Dimension(350,25));
        this.setResizable(false);
        //setLayout(new GridLayout(5,2,1,1));
        searchPanel.add(searchField,BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        
        add(searchPanel);

        // Create the result area
        resultArea = new JTextArea(10, 5);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Add action listeners
        searchButton.addActionListener(this);
        searchField.addActionListener(this);
        
        class exitAction implements ActionListener{
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }
        class waL implements ActionListener{
            public void actionPerformed(ActionEvent e){
                ImageIcon icon = new ImageIcon(waL.class.getResource("/images/walmart.png"));
                JOptionPane.showMessageDialog(null,"Walmart, Inc. engages in retail and wholesale business.\n" 
                        +"The company offers an assortment of merchandise and services at everyday low prices.\n" 
                        +"It operates through the following business segments: Walmart U.S., Walmart International, and Sam's Club.","Walmart", JOptionPane.INFORMATION_MESSAGE,icon);
            }
        }
        class wiL implements ActionListener{
            public void actionPerformed(ActionEvent e){
                ImageIcon icon = new ImageIcon(wiL.class.getResource("/images/winndixie.png"));
                JOptionPane.showMessageDialog(null,"Winndixie is a store","Winndixie", JOptionPane.INFORMATION_MESSAGE,icon);
            }
        }
        class roL implements ActionListener{
            public void actionPerformed(ActionEvent e){
                ImageIcon icon = new ImageIcon(roL.class.getResource("/images/rouses.png"));
                JOptionPane.showMessageDialog(null,"Rouses is a store","Winndixie", JOptionPane.INFORMATION_MESSAGE,icon);
            }
        }
        class taL implements ActionListener{
            public void actionPerformed(ActionEvent e){
                ImageIcon icon = new ImageIcon(taL.class.getResource("/images/target.png"));
                JOptionPane.showMessageDialog(null,"Target is a store","Target", JOptionPane.INFORMATION_MESSAGE,icon);
            }
        }
        
        exitMenuItem.addActionListener(new exitAction());
        rouses.addActionListener(new roL());
        walmart.addActionListener(new waL());
        winndixie.addActionListener(new wiL());
        target.addActionListener(new taL());
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
    
