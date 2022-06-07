/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import Account.TypeOfAccount;
import java.util.ArrayList;

/**
 *
 * @author thomas
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        Application app = new Application();
        putExempleDataIn(app);
        app.ARR_ToLogIn();
        System.out.println("disconnect");
    }
    public static void putExempleDataIn(Application app){
        app.createAdminAccount("root", "root", "root", "root", "root");
        app.ARR_CreateAccount("owner", "owner", "owner", "owner", "owner", TypeOfAccount.OWNER);
        app.ARR_CreateAccount("tenant", "tenant", "tenant", "tenant", "tenant", TypeOfAccount.TENANT);
        
    }  
}
