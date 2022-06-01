/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

/**
 *
 * @author etd
 */
public class Admin extends Account{
    public Admin(String login, String name, String surname, String nickname, String email) {
        this.login=login;
        this.name=name;
        this.surname=surname;
        this.nickname=nickname;
        this.email=email;
        this.wallet=0; 
        this.type=TypeOfAccount.ADMIN;
    }
    
}
