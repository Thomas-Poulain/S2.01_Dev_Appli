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
    private final Tenant TENANT;
    private int amount;
    private boolean winner;

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
    
    public Offer(Tenant tenant, int amount){
        this.TENANT=tenant;
        this.amount=amount;
        roundAmount();
    }

    public Tenant getTENANT() {
        return TENANT;
    }

    public int getAmount() {
        return amount;
    }
    
    private void roundAmount(){
        while(amount%10!=0) {
            amount+=1;
        }     
    }
}
