/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        Application app = new Application();
        putExempleDataIn(app);
        app.logIn();
        app.run();
        System.out.println("disconnect");
    }
    public static void putExempleDataIn(Application app){
        app.createAdminAccount("root", "root", "root", "root", "root");
    }  
}
