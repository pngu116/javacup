package pricecomparison;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * PriceComparison --- program that creates the main JFrame where user will
 * compare prices
 *
 * @author Tam Nguyen, Phil Nguyen, Khoi Tran, Timmy Tran, Henry Do, Blake Bonnette
 */
public class PriceComparison extends JFrame implements ActionListener {
    private JTextField searchField;
    private JButton searchButton;
    private JLabel titleLabel;
    private JTextArea resultArea;
    private JMenuBar menuBar;
    private JMenu menu;

    /**
     * Main User Interface where user can search product and compare prices
     * through different retailers
     *
     */
    public PriceComparison() {

        setSize(350, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        titleLabel = new JLabel("Price Comparer");
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
        JMenuItem winndixie = new JMenuItem("Winn-Dixie");
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

        JPanel searchPanel = new JPanel(new BorderLayout(0, 2));
        searchPanel.setPreferredSize(new Dimension(350, 25));
        this.setResizable(false);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        add(searchPanel);

        // Create the result area
        resultArea = new JTextArea(10, 5);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Add action listeners
        searchButton.addActionListener(this);
        searchField.addActionListener(this);

        class exitAction implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        class waL implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(waL.class.getResource("/images/walmart.png"));
                JOptionPane.showMessageDialog(null, "Walmart, Inc. is an American multinational retail corporation that engages in retail and wholesale business.\n"
                        + "The company offers an assortment of merchandise and services at everyday low prices.\n"
                        + "'Save Money. Live Better.'", "Walmart", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
        class wiL implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(wiL.class.getResource("/images/winndixie.png"));
                JOptionPane.showMessageDialog(null, "Winn-Dixie Stores, Inc. is America's fifth-largest supermarket chain.\n"
                        + "'Getting Better All the Time'", "Winn-Dixie", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
        class roL implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(roL.class.getResource("/images/rouses.png"));
                JOptionPane.showMessageDialog(null, "Rouses Markets are a chain of grocery supermarkets in the south.\n"
                        + "The company carries local products such as seafood and more.\n"
                        + "'Best Quality + Best Price Since 1960'", "Rouses", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
        class taL implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(taL.class.getResource("/images/target.png"));
                JOptionPane.showMessageDialog(null, "Target Corporation is America's eigth largest retail corporation.\n"
                        + "Target is a general merchandise retailer that offers a wide range of products, and whose positioning statement is 'To help all families discover the joy of everyday life.'\n"
                        + "'Expect More. Pay Less.'", "Target", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }

        exitMenuItem.addActionListener(new exitAction());
        rouses.addActionListener(new roL());
        walmart.addActionListener(new waL());
        winndixie.addActionListener(new wiL());
        target.addActionListener(new taL());
    }

    /**
     * Creates loginPage
     *
     * @param arg A string array containing the command line arguments.
     */
    public static void main(String[] args) {
        UserAndPasswords userAndPasswords = new UserAndPasswords();
        LoginPage loginPage = new LoginPage(userAndPasswords.getLoginInfo());
    }

    /**
     * Gets the user input searchTerm from PriceComparison UI and sends to
     * checkValidity()
     *
     * @param e Action Event
     */
    public void actionPerformed(ActionEvent e) {
        String searchTerm = searchField.getText();
        resultArea.setText("");
        DataFulfillment df = new DataFulfillment();
        df.checkValidity(searchTerm);
        if (!df.found) {
            resultArea.append("No results found.");
        }
        if (df.found) {
            String[][] ans = df.makeList(searchTerm);
            resultArea.append(ans[0][0] + " - $" + ans[0][1] + " - " + ans[0][2] + "\n");
            resultArea.append(ans[1][0] + " - $" + ans[1][1] + " - " + ans[1][2] + "\n");
            resultArea.append(ans[2][0] + " - $" + ans[2][1] + " - " + ans[2][2] + "\n");
            resultArea.append(ans[3][0] + " - $" + ans[3][1] + " - " + ans[3][2] + "\n");
        }
    }
}
