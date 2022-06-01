/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import Account.Account;

/**
 *
 * @author etd
 */
public class Tenant extends Account{
    
    public Tenant(String login, String name, String surname, String nickname, String email) {
        this.setLogin(login);
        this.setName(name);
        this.setSurname(surname);
        this.setNickname(nickname);
        this.setEmail(email);
        this.setWallet(0);
        this.setType(TypeOfAccount.TENANT);
    }
   
}
