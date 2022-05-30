/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

/**
 *
 * @author etd
 */
public abstract class Account {
    String login;
    String name;
    String surname;
    String nickname;
    String email;
    int wallet = 0;
    TypeOfAccount type = null;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public int getMoney() {
        return wallet;
    }

    public void setMoney(int wallet) {
        this.wallet = wallet;
    }

    public TypeOfAccount getType() {
        return type;
    }
    
    public boolean enougthToPay(int price){
        return wallet>=price;
    }
    
    public void displayAccountInformations(){
        System.out.println("login :" + login);
        System.out.println("name :" + name);
        System.out.println("surname :" + surname);
        System.out.println("nickname :" + nickname);
        System.out.println("email :" + email);
        System.out.println("wallet :" + wallet);
    }
}
