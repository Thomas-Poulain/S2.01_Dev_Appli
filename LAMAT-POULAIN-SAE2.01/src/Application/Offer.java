/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

/**
 *
 * @author etd
 */
public class Offer {
    private final Tenant TENANT;
    private int nbPers;
    private int nbNights;
    private int amount;
    private Month month;
    
    public Offer(Tenant tenant, int nbPers, int amount, Month month){
        this.TENANT=tenant;
        this.nbPers=nbPers;
        this.amount=amount;
        roundAmount();
        this.month=month;
    }

    public Tenant getTENANT() {
        return TENANT;
    }

    public int getNbPers() {
        return nbPers;
    }

    public int getNbNights() {
        return nbNights;
    }

    public int getAmount() {
        return amount;
    }

    public Month getMonth() {
        return month;
    }
    
    private void roundAmount(){
        while(amount%10!=0) {
            amount+=1;
        }     
    }
}
