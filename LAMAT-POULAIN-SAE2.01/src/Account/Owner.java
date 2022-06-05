/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import Account.Account;
import Property.Property;
import java.util.ArrayList;

/**
 *
 * @author etd
 */
public class Owner extends Account{

    public Owner(String login, String name, String surname, String nickname, String email) {
       this.setLogin(login);
        this.setName(name);
        this.setSurname(surname);
        this.setNickname(nickname);
        this.setEmail(email);
        this.setWallet(0);
        this.setType(TypeOfAccount.OWNER);
    }   
}
