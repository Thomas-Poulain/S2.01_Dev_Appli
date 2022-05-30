/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Application;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author etd
 */
public class Application {

    private ArrayList<Account> accounts = new ArrayList();
    private ArrayList<Property> properties = new ArrayList();
    private Account currentConnected = null;
    private int walletSociety=0;
    private Scanner scan = new Scanner(System.in);
    private ArrayList<String> menuItems = new ArrayList<>();
    private ArrayList<String> beginItems = new ArrayList<>();

    Application(){
        beginItems.add("Quit");
        beginItems.add("To log in");
        beginItems.add("Create an account");
        
        logIn();
       
        /*
        gAccess = new GameAccess();
        mAccess = new MemberAccess(gAccess);
        lAccess = new LoanAccess(gAccess, mAccess);
        */

        menuItems.add("Quit");
        menuItems.add("List all games in the library");
        menuItems.add("Add new board game");
        menuItems.add("Add new video game");
        menuItems.add("Add new member");
        menuItems.add("Borrow board game");
        menuItems.add("Borrow video game");
        menuItems.add("Check all loans");
        menuItems.add("Search for board game by number of players");
        menuItems.add("Search for video game by platform");
        menuItems.add("Search for game by genre");
        menuItems.add("Return board game");
        menuItems.add("Return video game");
    }
    private void logIn(){
        boolean quit = false;
        displayMenu(beginItems);
        int choice = ARR_userNumericInput(0, beginItems.size() - 1, "Choose an action");
        performActionConnection(choice);
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
    
    private void createAccount(){
        String login = ARR_userStringInput("your login ?");
        String name = ARR_userStringInput("your name ?");
        String surname = ARR_userStringInput("your surname ?");
        String nickname = ARR_userStringInput("your nickname ?");
        String email = ARR_userStringInput("your email ?");
        int typaAccount =  ARR_userNumericInput(0, 1, " 1. Owner \n 2. Tenant" );
    }
    
    private void connection(){
        String login = ARR_userStringInput("your login ?");
        toLogIn(login);
    }
    
    void whoIsConnected(){}

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
        boolean quit = false;
        displayMenu(menuItems);
        do {
            int choice = ARR_userNumericInput(0, menuItems.size() - 1, "Choose an action");
            quit = performAction(choice);
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
    
    private void performActionConnection(int choice){
        switch (choice)  {
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
              
    private boolean performAction(int choice) {
        boolean res = false;
        switch (choice)  {
            case 0:
                res = true;
                break;
            /*case 1:
                displayAllBoardGames();
                displayAllVideoGames();
                break;
            case 2:
                performNewBoardGameEntry();
                break;
            case 3:
                performNewVideoGameEntry();
                break;
            case 4:
                performNewMemberEntry();
                break;
            case 5:
                performNewBoardGameLoan();
                break;
            case 6:
                performNewVideoGameLoan();
                break;
            case 7:
                displayAllLoans();
                break;
            case 8:
                performBoardGameSearchByPlayers();
                break;
            case 9:
                performVideoGameSearchByPlatform();
                break;
            case 10:
                performSearchByGenre(); 
                break;
            case 11:
                performBoardGameReturn();
                break;
            case 12:
                performVideoGameReturn();
                break;*/
        }
        return res;
    }
    
    public void createAccount(String login, String name, String surname, String nickname, String email, int wallet, TypeOfAccount type){
        if(currentConnected==null){
            switch(type){
                case OWNER:
                    accounts.add(new Owner(login, name, surname, nickname, email, wallet));
                    break;
                case TENANT:
                    accounts.add(new Tenant(login, name, surname, nickname, email, wallet));
                    break;
                default:
                    break;
            }
        }
    }
    
    public void addAdminAccount(String login, String name, String surname, String nickname, String email, int wallet){
        if(currentConnected.getType()==TypeOfAccount.ADMIN){
            accounts.add(new Admin(login, name, surname, nickname, email, wallet));
        }
    }
    
    public void toLogIn(String login){
        for(Account acc : accounts){
            if(acc.login.equals(login)){
                currentConnected=acc;
            }
        }
        if(currentConnected==null){
            System.out.println("Login failed");
        }
    }
    
    public void toSignOut(){
        currentConnected=null;
        System.out.println("Disconnected");
    }
    
    public void deleteAProperty(Account currentConnected,Property p){
        if(currentConnected.getType()==TypeOfAccount.ADMIN){
            properties.remove(p);
            ArrayList<Property> tmp = new ArrayList<>();
            tmp=p.getOwner().getProperties();
            tmp.remove(p);
            p.getOwner().setProperties(tmp);
        }else if(currentConnected.getType()==TypeOfAccount.OWNER){
            if(currentConnected.equals(p.getOwner())){
              properties.remove(p);
                ArrayList<Property> tmp = new ArrayList<>();
                tmp=p.getOwner().getProperties();
                tmp.remove(p);  
            }
        }
    }
    
    public void changePropertyDesc(Account currentConnected,Property p,String s){
        if(currentConnected.getType()==TypeOfAccount.ADMIN){   
            p.setDescription(s);
        }else if(currentConnected.getType()==TypeOfAccount.OWNER){
            if(currentConnected.equals(p.getOwner())){
                p.setDescription(s);
            }
        }
    }
        
    public void changePropretyAdress(Account currentConnected,Property p,String s){
        if(currentConnected.getType()==TypeOfAccount.OWNER){
            if(currentConnected.equals(p.getOwner())){
                p.setAdress(s);
            }
        }
    }
    
    public void changePropretyTown(Account currentConnected,Property p,String s){
        if(currentConnected.getType()==TypeOfAccount.OWNER){
            if(currentConnected.equals(p.getOwner())){
                p.setTown(s);
            }
        }
    }
    
    public void changePropretyOwner(Account currentConnected,Property p,Owner o){
        if(currentConnected.getType()==TypeOfAccount.OWNER){
            if(currentConnected.equals(p.getOwner())){
                p.setOwner(o);
            }
        }
    }
    
    public void changePropretyMaxCapacity(Account currentConnected,Property p,int i){
        if(currentConnected.getType()==TypeOfAccount.OWNER){
            if(currentConnected.equals(p.getOwner())){
                p.setMaxCapacity(i);
            }
        }
    }
    
    public void changePropretyNominalrice(Account currentConnected,Property p,int i){
        if(currentConnected.getType()==TypeOfAccount.OWNER){
            if(currentConnected.equals(p.getOwner())){
                p.setMaxCapacity(i);
            }
        }
    }
}
