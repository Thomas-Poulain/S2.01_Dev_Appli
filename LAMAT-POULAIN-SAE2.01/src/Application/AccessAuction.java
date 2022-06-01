/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class AccessAuction {
    private ArrayList<Auction> auctions = new ArrayList<>();
    AccessAuction(){}
     
    public void addAAuction(Owner owner, Property property, Month month){
        auctions.add(new Auction(owner , property, month));
    }

    public ArrayList<Auction> getAuctions() {
        return auctions;
    }
    
    public void displayAllaActions(){
        if(!auctions.isEmpty()){
            for(Auction a : auctions){
                a.toString();
            }
        }else{
            System.out.println("No auctions find.");
        }
    }
}
