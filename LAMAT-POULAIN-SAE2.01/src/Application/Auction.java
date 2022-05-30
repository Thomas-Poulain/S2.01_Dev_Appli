/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

/**
 *
 * @author Thomas
 */
public class Auction {
    private Offer LastOffer;
    private Owner OWNER;
    private Property PROPERTY;
    private Month MONTH;
    
    Auction(Owner owner, Property property, Month month){
        this.OWNER = owner;
        this.PROPERTY = property;
        this.MONTH = month;
    }
} 
