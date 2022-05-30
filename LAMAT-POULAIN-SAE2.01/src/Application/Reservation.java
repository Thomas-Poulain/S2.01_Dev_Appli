/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

/**
 *
 * @author Thomas
 */
public class Reservation {
    private Owner OWNER;
    private Property PROPERTY;
    private Month MONTH;
          
    
    public Reservation(Owner owner, Property property, Month month){
        OWNER=owner;
        PROPERTY = property;
        MONTH = month;
    }

    public Owner getOWNER() {
        return OWNER;
    }

    public void setOWNER(Owner OWNER) {
        this.OWNER = OWNER;
    }

    public Property getPROPERTY() {
        return PROPERTY;
    }

    public void setPROPERTY(Property PROPERTY) {
        this.PROPERTY = PROPERTY;
    }

    public Month getMONTH() {
        return MONTH;
    }

    public void setMONTH(Month MONTH) {
        this.MONTH = MONTH;
    }
    
    public void displayInformation(){
        this.toString();
    }
    
    
     @Override
    public String toString() {
        return "The description : " + PROPERTY.getDescription()
                + "The Adress : " + PROPERTY.getAdress() + " in " + PROPERTY.getTown()
                + "The month of reservation : " + MONTH
                + "Reserv by " + OWNER.surname + " " + OWNER.name;
    }
}
