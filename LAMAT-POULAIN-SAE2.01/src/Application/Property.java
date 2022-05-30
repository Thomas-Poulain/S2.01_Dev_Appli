/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

/**
 *
 * @author etd
 */
public class Property {
    private String town;
    private String adress;
    private String description;
    private Owner owner;
    private boolean isRented=false;
    private int maxCapacity;
    private int nominalPrice;
    private TypeOfProperty typeOfProperty;

    public Property(String town,String adress,String description, Owner owner,int maxCapacity, int nominalPrice, TypeOfProperty typeOfProperty) {
        this.town=town;
        this.adress=adress;
        this.description=description;
        this.owner=owner;
        this.maxCapacity=maxCapacity;
        this.nominalPrice=nominalPrice;
    }

    public String getTown() {
        return town;
    }

    public String getDescription() {
        return description;
    }

    public boolean isIsRented() {
        return isRented;
    }

    public String getAdress() {
        return adress;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getNominalPrice() {
        return nominalPrice;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setNominalPrice(int nominalPrice) {
        this.nominalPrice = nominalPrice;
    }
    
    
}