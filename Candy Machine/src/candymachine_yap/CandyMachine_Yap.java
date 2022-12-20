/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candymachine_yap;

/**
 *
 * @author Puyas MPC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CandyMachine_Yap extends JFrame
{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    
    private CashRegister_Yap cashRegister = new CashRegister_Yap();
    private Dispenser_Yap candy = new Dispenser_Yap(100, 50);
    private Dispenser_Yap chips = new Dispenser_Yap(100, 65);
    private Dispenser_Yap gum = new Dispenser_Yap(75, 45);
    private Dispenser_Yap cookies = new Dispenser_Yap(100, 85);
    
    private JLabel headingMainL;
    private JLabel selectionL;
    
    private JButton exitB, candyB, chipsB, gumB, cookiesB;
    private ButtonHandler pbHandler;
    
    public CandyMachine_Yap()
    {
        setTitle("Candy Machine");
        setSize(WIDTH, HEIGHT);
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(7,1));
        
        pbHandler = new ButtonHandler();
        
        headingMainL =
                new JLabel("WELCOME TO CLARN'S CANDY SHOP", 
                        SwingConstants.CENTER);
        selectionL = new JLabel("To Make a Selection, " 
                + "Click on the Product Button", SwingConstants.CENTER);
        
        pane.add(headingMainL);
        pane.add(selectionL);
        
        candyB = new JButton("Candy");
        candyB.addActionListener(pbHandler);
        
        chipsB = new JButton("Chips");
        chipsB.addActionListener(pbHandler);
        
        gumB = new JButton("Gum");
        gumB.addActionListener(pbHandler);
        
        cookiesB = new JButton("Cookies");
        cookiesB.addActionListener(pbHandler);
        
        exitB = new JButton("Exit");
        exitB.addActionListener(pbHandler);
        
        pane.add(candyB);
        pane.add(chipsB);
        pane.add(gumB);
        pane.add(cookiesB);
        pane.add(exitB);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
private class ButtonHandler implements ActionListener
{
    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand().equals("Exit"))
            System.exit(0);
        else if (e.getActionCommand().equals("Candy"))
            sellProduct(candy, "Candy");
        else if (e.getActionCommand().equals("Chips"))
            sellProduct(chips, "Chips");
        else if (e.getActionCommand().equals("Gum"))
            sellProduct(gum, "Gum");
        else if (e.getActionCommand().equals("Cookies"))
            sellProduct(cookies, "Cookies");     
    }
}
private void sellProduct(Dispenser_Yap product, String productName)
{
    int coinsInserted = 0;
    int price;
    int coinsRequired;
    
    String str;
    
    if (product.getCount() > 0)
    {
        price = product.getProductCost();
        coinsRequired = price - coinsInserted;
        
        while (coinsRequired > 0)
        {
            str = JOptionPane.showInputDialog("To buy "
            + productName
            +" please insert "
            + coinsRequired + " cents");
            coinsInserted = coinsInserted
                    + Integer.parseInt(str);
            coinsRequired = price - coinsInserted;
        }
        cashRegister.acceptAmount(coinsInserted);
        product.makeSale();
        
        JOptionPane.showMessageDialog(null, "Please pick up "
        +"your " + productName + " and enjoy", "Thank you, Come again!",
        JOptionPane.PLAIN_MESSAGE);
        
    }
    else
        JOptionPane.showMessageDialog(null, "Sorry "+ productName 
                +" is sold out\n" + "Make another selection", "Thank you, Come again!",
                JOptionPane.PLAIN_MESSAGE);
} 
    public static void main(String[] args) {
     CandyMachine_Yap candyShop = new CandyMachine_Yap();
    }
}
