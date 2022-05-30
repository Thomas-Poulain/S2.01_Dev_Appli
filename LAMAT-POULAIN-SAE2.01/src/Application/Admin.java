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
    public Admin(String login, String name, String surname, String nickname, String email, int wallet) {
        this.login=login;
        this.name=name;
        this.surname=surname;
        this.nickname=nickname;
        this.email=email;
        this.wallet=wallet; 
        this.type=TypeOfAccount.ADMIN;
    }
    
    public Account createAdminAccount(String login, String name, String surname, String nickname, String email, int wallet){
        return new Admin(login, name, surname, nickname, email, wallet);
    }   
}
