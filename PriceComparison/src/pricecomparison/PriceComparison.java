package pricecomparison;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PriceComparison extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JTextField searchField;
    private JButton searchButton;
    
    public Price Comparison(){
         super("Price Comparison");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        
        JPanel panel = new JPanel(new BorderLayout());
        searchField = new JTextField(20);
        panel.add(searchField, BorderLayout.CENTER);
        
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        panel.add(searchButton, BorderLayout.EAST);
        
        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PriceComparison();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
        String searchText = searchField.getText();
        prosearch(searchField.getText());
        }    
    }
    public static void prosearch(String name){
        //Scanner s = new Scanner(System.in);
        //System.out.print("Enter Product name: ");
        String product  = name;
        String line = "";
        
        try{
            FileInputStream f = new FileInputStream("productData.txt");
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if(line.startsWith(product)){
                    System.out.println(line);
                }
            }
        }
       catch(IOException ioe){
           ioe.printStackTrace();
       }
    }
    
}
