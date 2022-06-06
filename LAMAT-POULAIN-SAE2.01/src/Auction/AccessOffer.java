/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auction;

import Account.Owner;
import Account.Tenant;
import Property.Property;
import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class AccessOffer {
     private ArrayList<Offer> offers = new ArrayList<>();
    
    public AccessOffer(){}
     
    public void addAOffer(Tenant tenant, int amount, Auction auction){
        offers.add(new Offer(tenant , amount, auction));
    }

    public void displayAllaOffers(){
        if(!offers.isEmpty()){
            for(Offer o : offers){
                o.toString();
            }
        }else{
            System.out.println("No offers find.");
        }
    }
    
    public void displayOfferByTenant(Tenant t){
        if(!offers.isEmpty()){
            for(Offer o : offers){
                if(t.getLogin().equals(o.getTENANT().getLogin())){
                    o.toString();
                }      
            }
        }else{
            System.out.println("No auctions find.");
        }
    }
}
