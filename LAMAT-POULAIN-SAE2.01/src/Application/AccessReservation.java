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
public class AccessReservation {

    private ArrayList<Reservation> reservations = new ArrayList<>();

    AccessReservation() {

    }

    public void addAReservation(Owner owner, Tenant tenant, Property property, Month month) {
        reservations.add(new Reservation(owner, tenant, property, month));
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void displayAllResvervations() {
        for (Reservation r : reservations) {
            r.toString();
        }
    }
    
    public void displayMyReservations(Tenant tenant){
        for (Reservation r : reservations){
            if(tenant == r.getTENANT()){
                r.toString();
            }   
        }
    }

    public void foundAReservation(){
        
    }
            
            
    private void diplayThisReservation(Reservation r) {
        r.toString();
    }
}
