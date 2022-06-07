/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auction;

import java.util.Comparator;

/**
 *
 * @author thomas
 */
public class BestOffer implements Comparator<Offer>{

    @Override
    public int compare(Offer o1, Offer o2) {
        return o1.getNOMINALPRICE()*o1.getNbNight()*o1.getNbPers() - o2.getNOMINALPRICE()*o2.getNbNight()*o2.getNbPers();
    }
    
}
