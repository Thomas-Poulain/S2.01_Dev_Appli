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
    AccessReservation(){
    }
     
    public void addAReservation(Owner owner, Property property, Month month){
        reservations.add(new Reservation(owner, property, month));
    }
}
