/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auction;

import Auction.Offer;
import Account.Owner;
import Property.Property;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Thomas
 */
public class Auction {
    private Offer LastOffer;
    private Owner OWNER;
    private Property PROPERTY;
    private Month MONTH;
    private ArrayList<Offer> storyOfOffer = new ArrayList<>();
    
    Auction(Owner owner, Property property, Month month){
        this.OWNER = owner;
        this.PROPERTY = property;
        this.MONTH = month;   
    }

    public Offer getLastOffer() {
        return LastOffer;
    }

    public Owner getOWNER() {
        return OWNER;
    }

    public Property getPROPERTY() {
        return PROPERTY;
    }

    public Month getMONTH() {
        return MONTH;
    }
    
    private void changeBestOffer(Offer o){
        LastOffer.setWinner(false);
        setLastOffer(o);
        storyOfOffer.add(o);
        o.setWinner(true);
    }
    
    private boolean ItsTheFirst(){
        if(LastOffer==null){return true;}
        else{return false;}
    }
    
    public void updateBestOffer(Offer o){
        if(ItsTheFirst()){
            setLastOffer(o);
            storyOfOffer.add(o);
            o.setWinner(true);
            return;
        }
        BestOffer bO = new BestOffer();
        if(bO.compare(o, LastOffer) > 0){
            changeBestOffer(o);
        }
    }

    public void setLastOffer(Offer LastOffer) {
        this.LastOffer = LastOffer;
    }

    public void setOWNER(Owner OWNER) {
        this.OWNER = OWNER;
    }

    public void setPROPERTY(Property PROPERTY) {
        this.PROPERTY = PROPERTY;
    }

    public void setMONTH(Month MONTH) {
        this.MONTH = MONTH;
    }
    
    @Override
    public String toString() {
        return "The property at " + this.getPROPERTY().getAdress()
                + " at " + this.getMONTH()
                + "rented by " + this.getOWNER().getLogin() +"."
                + "The actual winner is" + this.LastOffer.getTENANT().getLogin();
    }
} 
