/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

/**
 *
 * @author etd
 */
public class Tenant extends Account{
    
    public Tenant(String login, String name, String surname, String nickname, String email) {
        this.login=login;
        this.name=name;
        this.surname=surname;
        this.nickname=nickname;
        this.email=email;
        this.wallet=wallet; 
        this.type=TypeOfAccount.TENANT;
    }
   
}
