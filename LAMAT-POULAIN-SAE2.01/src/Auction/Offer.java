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
    private final int nbNight;
    private final Auction AUCTION;
    private final Tenant TENANT;
    private final int AMOUNT;
    private boolean winner;

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
    
    public Offer(Tenant tenant, int amount, Auction auction, int nbNight){
        this.TENANT=tenant;
        this.AMOUNT=amount;
        this.AUCTION=auction;
        this.nbNight = nbNight;
    }

    public int getNbNight() {
        return nbNight;
    }

    public Tenant getTENANT() {
        return TENANT;
    }

    public int getAMOUNT() {
        return AMOUNT;
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
