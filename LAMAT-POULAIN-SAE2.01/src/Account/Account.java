/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import Account.Account;
import Account.Admin;
/**
 *
 * @author etd
 */
public abstract class Account {
    private String login;
    private String name;
    private String surname;
    private String nickname;
    private String email;
    private int wallet;
    private TypeOfAccount type;

    public String getLogin() {
        return login;
    }

    public int getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void setType(TypeOfAccount type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public TypeOfAccount getType() {
        return type;
    }
    
    public boolean enougthToPay(int price){
        return wallet>=price;
    }
    
    public void displayAccountInformations(){
        System.out.println("-----");
        System.out.println("login :" + login);
        System.out.println("name :" + name);
        System.out.println("surname :" + surname);
        System.out.println("nickname :" + nickname);
        System.out.println("email :" + email);
        System.out.println("wallet :" + wallet);
        System.out.println("-----"); 
    }
}
