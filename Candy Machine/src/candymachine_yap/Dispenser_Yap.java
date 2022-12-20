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
public class Dispenser_Yap 
{
 private int numberOfItems;
 private int cost;
 
 public Dispenser_Yap()
 {
     numberOfItems = 50;
     cost = 50;
 }
 public Dispenser_Yap(int setNoOfItems, int setCost)
 {
     if(setNoOfItems >= 0)
         numberOfItems = setNoOfItems;
     else 
         numberOfItems = 50;
     
     if(setCost >= 0)
         cost = setCost;
     else
         cost = 50;
 }
 public int getCount()
 {
     return numberOfItems;
 }
 public int getProductCost()
 {
     return cost;
 }
 public void makeSale()
 {
     numberOfItems--;
 }
}
