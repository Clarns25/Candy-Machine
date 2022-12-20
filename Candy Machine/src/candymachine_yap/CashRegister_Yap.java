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
public class CashRegister_Yap 
{
    private int cashOnHand;
    
    public CashRegister_Yap()
    {
        cashOnHand = 500;
    }
    
    public CashRegister_Yap(int cashIn)
    {
        if (cashIn >= 0)
            cashOnHand = cashIn;
        else
            cashOnHand = 500;
    }
    
    public int currentBalance()
    {
        return cashOnHand;
    }
    public void acceptAmount(int amountIn)
    {
        cashOnHand = cashOnHand + amountIn;
    } 
}
