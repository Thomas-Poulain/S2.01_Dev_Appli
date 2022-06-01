/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Application;

import Property.Property;
import Account.TypeOfAccount;
import Account.Owner;
import Account.Tenant;
import Account.Admin;
import Account.Account;
import java.util.ArrayList;
import java.util.Scanner;
import Auction.AccessAuction;
import Auction.Auction;
import Reservation.AccessReservation;
import Reservation.Reservation;

/**
 *
 * @author etd
 */
public class Application {

    private ArrayList<Account> accounts = new ArrayList();
    private ArrayList<Property> properties = new ArrayList();
    private Account currentConnected = null;
    private int walletSociety = 0;
    private Scanner scan = new Scanner(System.in);
    private ArrayList<String> menuItems = new ArrayList<>();
    private ArrayList<String> beginItems = new ArrayList<>();
    private AccessAuction aAuction = new AccessAuction();
    private AccessReservation aReservation = new AccessReservation();

    Application() {
        beginItems.add("Quit");
        beginItems.add("To log in");
        beginItems.add("Create an account");
    }

    public void logIn() {
        displayMenu(beginItems);
        int choice = ARR_userNumericInput(0, beginItems.size() - 1, "Choose an action");
        performActionConnection(choice);
    }

    public void createMenu() {
        switch (currentConnected.getType()) {
            case ADMIN:
                menuItems.add("Quit");
                menuItems.add("Display all users");
                menuItems.add("Delete a user");
                menuItems.add("Edit a user");
                menuItems.add("Remove a property");
                menuItems.add("Edit a property");
                menuItems.add("Display all properties");
                menuItems.add("Display account's informations");
                menuItems.add("Edit account't informations");
                menuItems.add("Create an admin account");
                menuItems.add("Display all auctions");
                break;
            case OWNER:
                menuItems.add("Quit");
                menuItems.add("Add a property");
                menuItems.add("Remove a property");
                menuItems.add("Edit a property");
                menuItems.add("Display all properties");
                menuItems.add("List account's informations");
                menuItems.add("Edit account's informations");
                break;
            case TENANT:
                menuItems.add("Quit");
                menuItems.add("List account's informations");
                menuItems.add("Edit account's informations");
                menuItems.add("Fill wallet");
                menuItems.add("Make a bid");    
                menuItems.add("List auctions");
                menuItems.add("List bid history");
                menuItems.add("List reservation");
                menuItems.add("Display reservztion information");
                break;
            default:
                break;
        }
    }

    private void displayMenu(ArrayList<String> list) {
        System.out.println("What do you want to do?");
        displayList(list);
    }

    private void displayList(ArrayList<String> list) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                System.out.println("" + i + "." + list.get(i));
            }
        } else {
            System.out.println("Giving up: no matches.");
        }
    }

    private void createAccount() {
        String login = ARR_userStringInput("your login ?");
        String name = ARR_userStringInput("your name ?");
        String surname = ARR_userStringInput("your surname ?");
        String nickname = ARR_userStringInput("your nickname ?");
        String email = ARR_userStringInput("your email ?");
        
        int typeAccount = ARR_userNumericInput(0, 1, " 0. Owner \n 1. Tenant");
        TypeOfAccount type;
        if (typeAccount == 0) {
            type = TypeOfAccount.OWNER;
        } else {
            type = TypeOfAccount.TENANT;
        }
        createAccount(login, name, surname, nickname, email, type);
    }

    public void createAdminAccount(String login, String name, String surname, String nickname, String email) {
        accounts.add(new Admin(login, name, surname, nickname, email));
    }

    private void connection() {
        String login = ARR_userStringInput("your login ?");
        toLogIn(login);
    }

    public void setCurrentConnected(Account currentConnected) {
        this.currentConnected = currentConnected;
    }

    public void setWalletSociety(int walletSociety) {
        this.walletSociety = walletSociety;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public Account getCurrentConnected() {
        return currentConnected;
    }

    public int getWalletSociety() {
        return walletSociety;
    }

    /**
     * execution de l'application
     */
    void run() {
        if(currentConnected==null){return;}
        boolean quit = false;
        createMenu();
        displayMenu(menuItems);
        do {
            int choice = ARR_userNumericInput(0, menuItems.size() - 1, "Choose an action");
            switch (currentConnected.getType()) {
                case OWNER:
                    quit = performActionOwner(choice);
                    break;
                case TENANT:
                    quit = performActionTenant(choice);
                    break;
                case ADMIN:
                    quit = performActionAdmin(choice);
                    break;
            }
        } while (!quit);
    }

    private String ARR_userStringInput(String prompt) {
        String input;
        do {
            System.out.format("Please enter %s:", prompt);
            System.out.println();
            input = scan.next();
        } while (input.length() < 1);
        return input;
    }

    private int ARR_userNumericInput(int min, int max, String prompt) {
        int input = -1;
        do {
            System.out.format("%s.\nYour choice? [%d - %d]", prompt, min, max);
            System.out.println();
            input = scan.nextInt();
        } while (min > input || max < input);
        return input;
    }

    private void performActionConnection(int choice) {
        switch (choice) {
            case 0:
                break;
            case 1:
                connection();
                break;
            case 2:
                createAccount();
                break;
            default:
                break;
        }
    }

    private boolean performActionAdmin(int choice) {
        boolean res = false;
        switch (choice) {
            case 0:
                res = true;
                break;
            case 1:
                displayAllUsers();
                break;

            case 2:
                deleteUser();
                break;
            case 3:
            /*
                editUser();
                break;
             */
            case 4:
                removeAProperty();
                break;
            /*
            case 5:
                editAProperty();
                break;
             */
            case 6:
                displayAllProperties();
                break;
            case 7:
                displayInformations();
                break;
            case 8:
                editInformations();
                break;
            case 9:
                createAnOtherAdminAccount();
                break;
            case 10:
                displayAllAuctions();
                break;
        }
        return res;
    }

    private boolean performActionOwner(int choice) {
        boolean res = false;
        switch (choice) {
            case 0:
                res = true;
                break;
            case 1:
                //addProperty();
                break;
            case 2:
                removeAProperty();
                break;
            case 3:
                // editAProperty();
                break;
            case 4:
                displayAllProperties();
                break;
            case 5:
                displayInformations();
                break;
            case 6:
                editInformations();
                break;
        }
        return res;
    }

    private boolean performActionTenant(int choice) {
        boolean res = false;
        switch (choice) {
            case 0:
                res = true;
                break;
            case 1:
                displayInformations();
                break;
            case 2:
                editInformations();
                break;
            case 3:
                // faire une offre
                break;
            case 4:
                fillWallet();
                break;
            case 5:
                // voir les enchères
                break;
            case 6:
                // lister historique des offres
                break;
            case 7:
                // lister reservation 
                break;
            case 8:
                // afficher détails reservation
                break;
        }
        return res;
    }

    public void createAccount(String login, String name, String surname, String nickname, String email, TypeOfAccount type) {
        if (currentConnected == null) {
            switch (type) {
                case OWNER:
                    accounts.add(new Owner(login, name, surname, nickname, email));
                    break;
                case TENANT:
                    accounts.add(new Tenant(login, name, surname, nickname, email));
                    break;
                default:
                    break;
            }
            currentConnected = accounts.get(accounts.size() - 1);
        }
    }

    public void toLogIn(String login) {
        for (Account acc : accounts) {
            if (acc.getLogin().equals(login)) {
                currentConnected = acc;
            }
        }
        if (currentConnected == null) {
            System.out.println("Login failed");
        }
    }

    public void toSignOut() {
        currentConnected = null;
        System.out.println("Disconnected");
    }

    public void deleteAProperty(Account currentConnected, Property p) {
        if (currentConnected.getType() == TypeOfAccount.ADMIN) {
            properties.remove(p);
            ArrayList<Property> tmp = new ArrayList<>();
            tmp = p.getOwner().getProperties();
            tmp.remove(p);
            p.getOwner().setProperties(tmp);
        } else if (currentConnected.getType() == TypeOfAccount.OWNER) {
            if (currentConnected.equals(p.getOwner())) {
                properties.remove(p);
                ArrayList<Property> tmp = new ArrayList<>();
                tmp = p.getOwner().getProperties();
                tmp.remove(p);
            }
        }
    }

    public void changePropertyDesc(Account currentConnected, Property p, String s) {
        if (currentConnected.getType() == TypeOfAccount.ADMIN) {
            p.setDescription(s);
        } else if (currentConnected.getType() == TypeOfAccount.OWNER) {
            if (currentConnected.equals(p.getOwner())) {
                p.setDescription(s);
            }
        }
    }

    public void changePropretyAdress(Account currentConnected, Property p, String s) {
        if (currentConnected.getType() == TypeOfAccount.OWNER) {
            if (currentConnected.equals(p.getOwner())) {
                p.setAdress(s);
            }
        }
    }

    public void changePropretyTown(Account currentConnected, Property p, String s) {
        if (currentConnected.getType() == TypeOfAccount.OWNER) {
            if (currentConnected.equals(p.getOwner())) {
                p.setTown(s);
            }
        }
    }

    public void changePropretyOwner(Account currentConnected, Property p, Owner o) {
        if (currentConnected.getType() == TypeOfAccount.OWNER) {
            if (currentConnected.equals(p.getOwner())) {
                p.setOwner(o);
            }
        }
    }

    public void changePropretyMaxCapacity(Account currentConnected, Property p, int i) {
        if (currentConnected.getType() == TypeOfAccount.OWNER) {
            if (currentConnected.equals(p.getOwner())) {
                p.setMaxCapacity(i);
            }
        }
    }

    public void changePropretyNominalrice(Account currentConnected, Property p, int i) {
        if (currentConnected.getType() == TypeOfAccount.OWNER) {
            if (currentConnected.equals(p.getOwner())) {
                p.setMaxCapacity(i);
            }
        }
    }

    public void displayAllUsers() {
        if (!accounts.isEmpty()) {
            for (Account a : accounts) {
                a.displayAccountInformations();
            }
        } else {
            System.out.println("No accounts found !");
        }
    }

    public void displayAllProperties() {
        if (!properties.isEmpty()) {
            for (Property p : properties) {
                p.displayPropertyInformation();
            }
        } else {
            System.out.println("No property available !");
        }
    }

    public void displayInformations() {
        currentConnected.displayAccountInformations();
    }

    public void editInformations() {
        System.out.println("What do you want to change ?");
        ArrayList<String> mess = new ArrayList<>();
        mess.add("name");
        mess.add("surname");
        mess.add("nickname");
        mess.add("email");
        displayList(mess);

        int choice = ARR_userNumericInput(0, 3, "Choose an action");

        String newest = ARR_userStringInput("The newest");

        switch (choice) {
            case 0:
                currentConnected.setName(newest);
                break;
            case 1:
                currentConnected.setSurname(newest);
                break;
            case 2:
                currentConnected.setNickname(newest);
                break;
            case 3:
                currentConnected.setEmail(newest);
        }
    }

    public void fillWallet() {
        String cN = ARR_userStringInput("Card number");
        String e = ARR_userStringInput("Expiration");
        String p = ARR_userStringInput("Passord");
        int addition = 0;
        do {
            addition = ARR_userNumericInput(5, 1000000, "Enter a multiple of 5");
        } while (addition % 5 != 0);
        
        int valid = ARR_userNumericInput(0, 1, "Valid this transaction : \n 0.Yes \n 1.No");
        if(valid==1){
           currentConnected.setWallet(currentConnected.getMoney()+addition);
        }  
    }

    public void createAnOtherAdminAccount() {
        String login = ARR_userStringInput("login");
        String name = ARR_userStringInput("name");
        String surname = ARR_userStringInput("surname");
        String nickname = ARR_userStringInput("nickname");
        String email = ARR_userStringInput("email");
        createAdminAccount(login, name, surname, nickname, email);
        System.out.println("Your account was created with success !");
    }

    public void displayAllAuctions() {
        aAuction.displayAllaActions();
    }

    public void removeAProperty() {
        String adress = ARR_userStringInput("adress");
        Property toDelete = null;
        if (!properties.isEmpty()) {
            for (Property p : properties) {
                if (p.getAdress().equals(adress)) {
                    toDelete = p;
                }
            }
            if (toDelete != null) {
                properties.remove(toDelete);
                System.out.println("Successfully deleted !");
            } else {
                System.out.println("No property find for the adress " + adress + ".");
            }
        } else {
            System.out.println("No properties found.");
        }
    }

    public void deleteUser() {
        String user = ARR_userStringInput("user's login");
        Account toDelete = null;
        if(currentConnected.getLogin() == user){
            System.out.println("YOU ARE STUPID ? YOU ARE CONNECTED !");
            return;
        }
        
        if (!accounts.isEmpty()) {
            for (Account a : accounts) {
                if (a.getLogin().equals(user)) {
                    toDelete = a;
                }
            }
            if (toDelete != null) {
                accounts.remove(toDelete);
                System.out.println("Successfully deleted !");
            } else {
                System.out.println("No user found for the login " + user + ".");
            }
        } else {
            System.out.println("No accounts found.");
        }
    }
}
