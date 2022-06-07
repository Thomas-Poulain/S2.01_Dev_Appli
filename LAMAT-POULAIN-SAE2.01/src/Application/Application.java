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
import Auction.*;
import Property.TypeOfProperty;
import static Property.TypeOfProperty.HOUSE;
import Reservation.AccessReservation;
import Reservation.Reservation;
import java.util.HashSet;

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
    private AccessOffer aOffer = new AccessOffer();

    Application() {
    }

    void disconnect() {
        currentConnected = null;
        beginItems.clear();
        menuItems.clear();
    }

    public void log() {
        beginItems.add("Quit");
        beginItems.add("To log in");
        beginItems.add("Create an account");
    }

    public void ARR_ToLogIn() {
        log();
        displayMenu(beginItems);
        int choice = ARR_userNumericInput(0, beginItems.size() - 1, "Choose an action");
        performActionConnection(choice);
        if (!(choice == 0)) {
            run();
        }
    }

    public void createMenu() {
        if (currentConnected != null) {
            switch (currentConnected.getType()) {
                case ADMIN:
                    menuItems.add("Disconnect");
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
                    menuItems.add("Disconnect");
                    menuItems.add("Add a property");
                    menuItems.add("Remove a property");
                    menuItems.add("Edit a property");
                    menuItems.add("Display my properties");
                    menuItems.add("List account's informations");
                    menuItems.add("Edit account's informations");
                    break;
                case TENANT:
                    menuItems.add("Disconnect");
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

    private void ARR_CreateAccount() {
        String login;
        boolean loginOk = true;

        do {
            login = ARR_userStringInput("your login ?");
            if (!loginAvailable(login)) {
                loginOk = false;
                System.out.println("login already used");
            }
        } while (!loginOk);

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
        ARR_CreateAccount(login, name, surname, nickname, email, type);
        currentConnected = accounts.get(accounts.size() - 1);
    }

    public void ARR_CreateAdminAccount(String login, String name, String surname, String nickname, String email) {
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

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public void setaAuction(AccessAuction aAuction) {
        this.aAuction = aAuction;
    }

    public void setaOffer(AccessOffer aOffer) {
        this.aOffer = aOffer;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public AccessAuction getaAuction() {
        return aAuction;
    }

    public AccessOffer getaOffer() {
        return aOffer;
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
        if (currentConnected == null) {
            return;
        }
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
            if (!quit) {
                displayMenu(menuItems);
            }
        } while (!quit);
        disconnect();
        ARR_ToLogIn();
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
                System.out.println("");
                break;
            case 1:
                connection();
                break;
            case 2:
                ARR_CreateAccount();
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
                System.out.println("");
                System.out.println("Log out !");
                System.out.println("");
                break;
            case 1:
                displayAllUsers();
                break;
            case 2:
                deleteUser();
                break;
            case 3:
                editUser();
                break;
            case 4:
                removeAProperty();
                break;
            case 5:
                editProperty();
                break;
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
                ARR_CreateAdminAccount();
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
                System.out.println("");
                System.out.println("Log out !");
                System.out.println("");
                break;
            case 1:
                ARR_addProperty();
                break;
            case 2:
                removeAProperty();
                break;
            case 3:
                editProperty();
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
            case 7:
                createAuction();
                break;
            case 8:
                displayOffers();
                break;
        }
        return res;
    }

    private boolean performActionTenant(int choice) {
        boolean res = false;
        switch (choice) {
            case 0:
                res = true;
                System.out.println("");
                System.out.println("Log out !");
                System.out.println("");
                break;
            case 1:
                displayInformations();
                break;
            case 2:
                editInformations();
                break;
            case 3:
                ARR_CreateABid();
                break;
            case 4:
                fillWallet();
                break;
            case 5:
                displayAllAuctions();
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
            case 9:
                displayAllProperties();
                break;
            case 10:
                displayMyOffer();
                break;
        }
        return res;
    }

    public void displayMyOffer() {
        ArrayList<Offer> offers = aOffer.getOffers();
        ArrayList<Offer> myOffers = myOffers(offers, currentConnected);
        if (!myOffers.isEmpty()) {
            for (Offer o : myOffers) {
                o.toString();
            }
        }
    }

    public ArrayList<Offer> myOffers(ArrayList<Offer> offers, Account a) {
        ArrayList<Offer> myOffers = new ArrayList<>();
        for (Offer o : offers) {
            if (o.getTENANT().equals(currentConnected)) {
                myOffers.add(o);
            }
        }
        return myOffers;
    }

    public void displayOffers() {
        Property property = foundPropertyByName();
        Month.displayEnumTypeOfMonth();
        int choice = ARR_userNumericInput(1, 12, "Which month ? ");
        Month month = null;
        switch (choice) {
            case 1:
                month = Month.January;
                break;
            case 2:
                month = Month.February;
                break;
            case 3:
                month = Month.March;
                break;
            case 4:
                month = Month.April;
                break;
            case 5:
                month = Month.May;
                break;
            case 6:
                month = Month.June;
                break;
            case 7:
                month = Month.July;
                break;
            case 8:
                month = Month.August;
                break;
            case 9:
                month = Month.September;
                break;
            case 10:
                month = Month.October;
                break;
            case 11:
                month = Month.November;
                break;
            case 12:
                month = Month.December;
                break;
            default:
                break;
        }
        Auction auction = foundAuctionByPropertyAndMonth(property, month);
        for (Offer o : auction.getStoryOfOffer()) {
            o.toString();
        }
    }

    public void ARR_CreateABid() {
        Property property = foundPropertyByName();
        Month.displayEnumTypeOfMonth();
        int choice = ARR_userNumericInput(1, 12, "Which month ? ");
        Month month = null;
        switch (choice) {
            case 1:
                month = Month.January;
                break;
            case 2:
                month = Month.February;
                break;
            case 3:
                month = Month.March;
                break;
            case 4:
                month = Month.April;
                break;
            case 5:
                month = Month.May;
                break;
            case 6:
                month = Month.June;
                break;
            case 7:
                month = Month.July;
                break;
            case 8:
                month = Month.August;
                break;
            case 9:
                month = Month.September;
                break;
            case 10:
                month = Month.October;
                break;
            case 11:
                month = Month.November;
                break;
            case 12:
                month = Month.December;
                break;
            default:
                break;
        }
        Auction auction = foundAuctionByPropertyAndMonth(property, month);

        int nbNight = ARR_userNumericInput(1, auction.getNbNight(), "number of night (max " + auction.getNbNight() + ") ?");
        if (auction == null) {
            System.out.println("No auction found");
            return;
        } else {
            int amount = proposeOffer(auction);
            while (amount % 10 != 0) {
                amount += 1;
            }
            if (isBid(amount)) {
                addOffer(auction, amount, nbNight);
            }
        }
    }

    public void addOffer(Auction auction, int amount, int nbNight) {
        Offer offer = new Offer((Tenant) currentConnected, amount, auction, nbNight);
        aAuction.addOffer(offer, auction);
        aOffer.addOffer(offer);
    }

    public boolean isBid(int amount) {
        int addition = 0;
        for (Offer o : aOffer.getOffers()) {
            if (currentConnected == o.getTENANT()) {
                if (!(o.getAUCTION().getIsClose())) {
                    if (o.isWinner()) {
                        addition += o.getAMOUNT();
                    } else {
                        addition += 1;
                    }
                }
            }
        }
        return currentConnected.enougthToPay(addition + amount);
    }

    public int proposeOffer(Auction auction) {
        Offer lastOffer = auction.getLastOffer();
        System.out.println("The last offer is actual as " + lastOffer.getAMOUNT());
        int choice = ARR_userNumericInput(1, 1000000, "Your amount ? It's a must be greater by 10 than the last offer (arround at multiple of 10 automatically)");
        return choice;
    }

    public Auction foundAuctionByPropertyAndMonth(Property property, Month month) {
        ArrayList<Auction> auctions = aAuction.getAuctions();
        Auction auction = null;
        for (Auction a : auctions) {
            if (a.getMONTH().equals(month) && a.getPROPERTY().equals(property)) {
                auction = a;
            }
        }
        return auction;
    }

    public void ARR_CreateAccount(String login, String name, String surname, String nickname, String email, TypeOfAccount type) {
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
    }

    private boolean loginAvailable(String login) {
        boolean ok = true;
        for (Account a : accounts) {
            if (a.getLogin().equals(login)) {
                ok = false;
            }
        }
        return ok;
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
            if (currentConnected.getType().equals(TypeOfAccount.OWNER)) {
                ArrayList<Property> ownerProperties = foundPropertyByOwner(currentConnected);
                if (!ownerProperties.isEmpty()) {
                    for (Property p2 : ownerProperties) {
                        p2.displayPropertyInformation();
                    }
                }
            } else {
                if (currentConnected.getType().equals(TypeOfAccount.ADMIN)) {
                    for (Property p3 : properties) {
                        p3.displayPropertyInformation();
                    }
                }
            }
        } else {
            System.out.println("No property available !");
        }
    }

    public ArrayList<Property> foundPropertyByOwner(Account a) {
        ArrayList<Property> ownerProperties = new ArrayList<>();
        if (!properties.isEmpty()) {
            for (Property p : properties) {
                if (p.getOwner().getLogin().equals(a.getLogin())) {
                    ownerProperties.add(p);
                }
            }
        }
        return ownerProperties;
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
        String cN = ARR_userStringInput("Credit card number");
        String e = ARR_userStringInput("Expiration");
        String p = ARR_userStringInput("Passord");
        int addition = 0;
        do {
            addition = ARR_userNumericInput(5, 1000000, "Enter a multiple of 5");
        } while (addition % 5 != 0);

        int valid = ARR_userNumericInput(0, 1, "Valid this transaction : \n 0.Yes \n 1.No");
        if (valid == 1) {
            currentConnected.setWallet(currentConnected.getMoney() + addition);
        }
    }

    public void ARR_CreateAdminAccount() {
        String login = ARR_userStringInput("login");
        String name = ARR_userStringInput("name");
        String surname = ARR_userStringInput("surname");
        String nickname = ARR_userStringInput("nickname");
        String email = ARR_userStringInput("email");
        createAdminAccount(login, name, surname, nickname, email);
        System.out.println("Your account was created with success !");
    }

    public void createAdminAccount(String login, String name, String surname, String nickname, String email) {
        accounts.add(new Admin(login, name, surname, nickname, email));
    }

    public void displayAllAuctions() {
        aAuction.displayAllaActions();
    }

    public void removeAProperty() {
        String adress = ARR_userStringInput("adress");
        Property toRemove = removeAPropertyByAdress(adress);
        if (toRemove != null) {
            properties.remove(toRemove);
            System.out.println("Successfully deleted !");
        }
    }

    public Property removeAPropertyByAdress(String s) {
        Property toRemove = null;
        if (!properties.isEmpty()) {
            for (Property p : properties) {
                if (p.getAdress().equals(s)) {
                    toRemove = p;
                    break;
                }
            }
        } else {
            System.out.println("No properties found.");
        }
        return toRemove;
    }

    public void deleteUser() {
        String user = ARR_userStringInput("user's login");
        Account toDelete = null;
        if (currentConnected.getLogin().equals(user)) {
            System.out.println("You can't delete your own account !");
            return;
        }

        if (!accounts.isEmpty()) {
            deleteUserForALogin(user);
        } else {
            System.out.println("No accounts found.");
        }

    }

    public void deleteUserForALogin(String s) {
        Account toDelete = null;
        for (Account a : accounts) {
            if (a.getLogin().equals(s)) {
                toDelete = a;
                removePropertyFortheDeletedUser(s);
                break;
            }
        }
        if (toDelete != null) {
            accounts.remove(toDelete);
            System.out.println("Successfully deleted !");
        } else {
            System.out.println("No user found for the login " + s + ".");
        }
    }

   public void removePropertyFortheDeletedUser(String s){
       ArrayList<Property> userProperties = new ArrayList<>();
       if(!properties.isEmpty()){
           for(Property p : properties){
               if(p.getOwner().getLogin().equals(s)){
                   userProperties.add(p);
               }
           }
       }
       if(!userProperties.isEmpty()){
           for(Property p2 : userProperties){
               properties.remove(p2);
           }
       }
   }     
   
    public void editUser() {
        String user = ARR_userStringInput("user's login ");
        boolean find = false;
        if (!accounts.isEmpty()) {
            for (Account a : accounts) {
                if (a.getLogin().equals(user)) {
                    find = true;
                    editUserChoice(a);
                }
            }
            if (!find) {
                System.out.println("No user found for the login " + user + ".");
            }
        } else {
            System.out.println("No accounts found.");
        }
    }

    private void editUserChoice(Account a) {
        System.out.println("What do you want to change ?");
        ArrayList<String> mess = new ArrayList<>();
        mess.add("user's name");
        mess.add("user's surname");
        mess.add("user's nickname");
        mess.add("user's email");
        displayList(mess);

        int choice = ARR_userNumericInput(0, mess.size() - 1, "Choose an action");

        String newest = ARR_userStringInput("The newest");

        switch (choice) {
            case 0:
                a.setName(newest);
                break;
            case 1:
                a.setSurname(newest);
                break;
            case 2:
                a.setNickname(newest);
                break;
            case 3:
                a.setEmail(newest);
                break;
        }
    }

    public ArrayList<String> searchPropertyByName(String name) {
        ArrayList<String> nameList = new ArrayList<>();
        for (Property p : properties) {
            if (currentConnected.getType() == TypeOfAccount.ADMIN) {
                nameList.add(p.getName());
            } else {
                if (p.getOwner() == currentConnected) {
                    nameList.add(p.getName());
                }
            }
        }
        return searchListByPart(name, nameList);
    }

    public Property foundPropertyByName() {
        String partName = ARR_userStringInput("name property");
        ArrayList<String> name = searchPropertyByAdress(partName);
        if (name.isEmpty()) {
            return null;
        }
        displayList(name);
        String a = name.get(ARR_userNumericInput(0, name.size() - 1, "Which name ?"));

        Property property = null;
        for (Property p : properties) {
            if (p.getAdress().equals(a)) {
                property = p;
            }
        }
        return property;
    }

    public ArrayList<Property> GetPropertyForAOwner() {
        ArrayList propertiesByOwner = new ArrayList<>();
        for (Property p : properties) {
            if (currentConnected.getLogin().equals(p.getOwner().getLogin())) {
                propertiesByOwner.add(p);
            }
        }
        return propertiesByOwner;
    }

    public ArrayList<String> searchPropertyByAdress(String adress) {
        ArrayList<String> adressList = new ArrayList<>();
        for (Property p : properties) {
            if (currentConnected.getType() == TypeOfAccount.ADMIN) {
                adressList.add(p.getAdress());
            } else {
                if (p.getOwner() == currentConnected) {
                    adressList.add(p.getAdress());
                }
            }
        }
        return searchListByPart(adress, adressList);
    }

    public Property foundPropertyByAdress() {
        String partName = ARR_userStringInput("adress property");
        ArrayList<String> adress = searchPropertyByAdress(partName);
        if (adress.isEmpty()) {
            return null;
        }
        displayList(adress);
        String a = adress.get(ARR_userNumericInput(0, adress.size() - 1, "Which adress ?"));

        return PropertyByAdress(a);
    }
    
    public Property PropertyByAdress(String s){
        Property property = null;
        for (Property p : properties) {
            if (p.getAdress().equals(s)) {
                property = p;
            }
        }
        return property;
    }

    public void editProperty() {
        Property property = foundPropertyByAdress();
        if (!(property == null)) {
            editPropertyChoice(property);
        }
    }

    private void editPropertyChoice(Property property) {
        System.out.println("What do you want to change ?");
        ArrayList<String> mess = new ArrayList<>();
        mess.add("property name");
        mess.add("property adress");
        mess.add("property town");
        mess.add("property max capacity");
        mess.add("property nominal price");
        mess.add("property description");
        displayList(mess);

        int choice = ARR_userNumericInput(0, 3, "Choose an action");

        String newest = ARR_userStringInput("The newest");
        int i;
        switch (choice) {
            case 0:
                property.setName(newest);
                break;
            case 1:
                property.setAdress(newest);
                break;
            case 2:
                property.setTown(newest);
                break;
            case 3:
                i = Integer.parseInt(newest);
                property.setMaxCapacity(i);
                break;
            case 4:
                i = Integer.parseInt(newest);
                property.setNominalPrice(i);
                break;
            case 5:
                property.setDescription(newest);
                break;
        }
    }

    public void createAuction() {
        Property property = foundPropertyByName();
        Month.displayEnumTypeOfMonth();
        int nbNight = ARR_userNumericInput(0, 15, "the number of night");
        int choice = ARR_userNumericInput(1, 12, "Which month ? ");
        Month month = null;
        switch (choice) {
            case 1:
                month = Month.January;
                break;
            case 2:
                month = Month.February;
                break;
            case 3:
                month = Month.March;
                break;
            case 4:
                month = Month.April;
                break;
            case 5:
                month = Month.May;
                break;
            case 6:
                month = Month.June;
                break;
            case 7:
                month = Month.July;
                break;
            case 8:
                month = Month.August;
                break;
            case 9:
                month = Month.September;
                break;
            case 10:
                month = Month.October;
                break;
            case 11:
                month = Month.November;
                break;
            case 12:
                month = Month.December;
                break;
            default:
                break;
        }
        if (property.getOwner().getLogin().equals(currentConnected.getName())) {
            setUpAuction((Owner)currentConnected, property, month, nbNight);
            System.out.println("Auction created with sucess");
        } else {
            System.out.println("It's not your own property !");
        }
    }

    public void setUpAuction(Owner o, Property p, Month m, int n){
        aAuction.addAAuction(o, p, m, n);
    }
    
    public void ARR_addProperty() {
        String name = ARR_userStringInput("property's name");
        String town = ARR_userStringInput("property's town ");
        String adress = ARR_userStringInput("property's adress ");
        String description = ARR_userStringInput("property's description ");
        TypeOfProperty.displayEnumTypeOfProperty();
        TypeOfProperty type = null;
        int choice = ARR_userNumericInput(1, 6, "Type of Property");
        switch (choice) {
            case 1:
                type = TypeOfProperty.APARTMENT;
                break;
            case 2:
                type = TypeOfProperty.HOUSE;
                break;
            case 3:
                type = TypeOfProperty.VILLA;
                break;
            case 4:
                type = TypeOfProperty.CASTLE;
                break;
            case 5:
                type = TypeOfProperty.HUT;
                break;
            case 6:
                type = TypeOfProperty.OTHER;
                break;
            default:
                break;
        }
        int maxCapacity = ARR_userNumericInput(1, 100, "Property's capacity :");
        int nominalPrice = ARR_userNumericInput(1, 100, "nominalPrice (€) :");
        createProperty(name, town, adress, description, (Owner) currentConnected, maxCapacity, nominalPrice, type);
    }

    public void createProperty(String name, String town, String adress, String description, Owner owner, int maxCapacity, int nominalPrice, TypeOfProperty type) {
        Property p = new Property(name, town, adress, description, owner, maxCapacity, nominalPrice, type);
        properties.add(p);
    }

    private ArrayList<String> searchListByPart(String part, ArrayList<String> list) {
        ArrayList<String> res = new ArrayList<>();
        for (String item : list) {
            if (item.contains(part)) {
                res.add(item);
            }
        }
        return res;
    }
    
    public Owner foundOwnerByName(String s){
        Owner exit = null;
        if(!accounts.isEmpty()){
            for(Account a:accounts){
                if(a.getType().equals(TypeOfAccount.OWNER)){
                    if(a.getLogin().equals(s)){
                        exit = (Owner)a;
                    }
                }
            }
        }
        return exit;
    }
}
