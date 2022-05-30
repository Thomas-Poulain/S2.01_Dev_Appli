/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import java.util.ArrayList;

/**
 *
 * @author etd
 */
public class Owner extends Account{
    
    ArrayList<Property> properties = new ArrayList();
    public Owner(String login, String name, String surname, String nickname, String email, int wallet) {
        this.login=login;
        this.name=name;
        this.surname=surname;
        this.nickname=nickname;
        this.email=email;
        this.wallet=wallet; 
        this.type=TypeOfAccount.OWNER;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }
    
    
}
