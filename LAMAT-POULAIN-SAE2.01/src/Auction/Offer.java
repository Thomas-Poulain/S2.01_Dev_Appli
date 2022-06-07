package Auction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Auction.Month;
import Account.Tenant;

/**
 *
 * @author etd
 */
public class Offer {
    private final int NBNIGHTS;
    private final Auction AUCTION;
    private final Tenant TENANT;
    private final int NOMINALPRICE;
    private boolean winner;
    private final int NBPERS;
    private final int AMOUNT;

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
    
    public Offer(Auction auction, int nominalPrice, int nbNight,  Tenant tenant, int nbPers){
        this.TENANT=tenant;
        this.NOMINALPRICE=nominalPrice;
        this.AUCTION=auction;
        this.NBNIGHTS = nbNight;
        this.NBPERS=nbPers;
        this.AMOUNT=(NBNIGHTS*NBPERS*NOMINALPRICE);
    }

    public int getNbNight() {
        return NBNIGHTS;
    }

    public Tenant getTENANT() {
        return TENANT;
    }

    public int getNbPers() {
        return NBPERS;
    }

    public int getAMOUNT() {
        return NOMINALPRICE;
    }

    public int getNOMINALPRICE() {
        return NOMINALPRICE;
    }
   
    @Override
    public String toString(){
        String mess = TENANT.getLogin() + " on " + AUCTION.getPROPERTY() + " in " + AUCTION.getMONTH() + " at " + AMOUNT;
        if(AUCTION.getIsClose()){
            if(isWinner()){
                mess += " have won, congrulation !";
            }else{
                mess += " have loose";
            }
        }
        else{
            if(isWinner()){
                mess += " is winning";
            }else{
                mess += " have loose";
            }
        }
        return mess;
    }

    public Auction getAUCTION() {
        return AUCTION;
    }
}
