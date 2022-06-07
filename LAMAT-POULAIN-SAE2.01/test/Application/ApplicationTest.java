/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Application;

import Account.Account;
import Account.Owner;
import Account.TypeOfAccount;
import Auction.AccessAuction;
import Auction.AccessOffer;
import Auction.Auction;
import Auction.Month;
import Auction.Offer;
import Property.Property;
import Property.TypeOfProperty;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thoma
 */
public class ApplicationTest {
    
    public ApplicationTest() {
    }
    
    @Test
    public void applicationTests(){
        Application app = new Application();
        initializeData(app);
        for(Account a : app.getAccounts()){
            if(a.getType().equals(TypeOfAccount.ADMIN)){
                app.setCurrentConnected(a);
                break;
            } 
        }
        assertTrue(app.getCurrentConnected().getLogin().equals("root"));

        app.createProperty("TheTest", "test", "test", "test",app.foundOwnerByName("owner") , 3, 75, TypeOfProperty.APARTMENT);
        app.createProperty("TheTest", "test", "adress", "descAdress",app.foundOwnerByName("owner") , 5, 37, TypeOfProperty.HOUSE);
        app.createProperty("TheTest", "test", "towerOld", "desc",app.foundOwnerByName("owner2") , 10, 150, TypeOfProperty.CASTLE);
        assertTrue(app.getProperties().size()==3);
        assertTrue(app.PropertyByAdress("adress").getDescription().equals("descAdress"));
        
        assertTrue(app.foundPropertyByOwner(app.foundOwnerByName("owner")).size()==2);
        assertTrue(app.foundPropertyByOwner(app.foundOwnerByName("owner2")).size()==1);
        assertTrue(app.foundPropertyByOwner(app.foundOwnerByName("owner2")).contains(app.PropertyByAdress("towerOld")));
        
        app.deleteUserForALogin("owner2");
        assertTrue(app.getAccounts().size()==3);
        assertTrue(app.getProperties().size()==2); //owner2's property was also remove
        
        //Auction simulation
        app.ARR_CreateAccount("tenant2", "tenant2", "tenant2", "tenant2", "tenant2", TypeOfAccount.TENANT);
        AccessAuction aaccess = app.getaAuction();
        aaccess.addAAuction(app.foundOwnerByName("owner"), app.PropertyByAdress("adress"), Month.August, 10);
        app.setaAuction(aaccess);
        assertTrue(app.getaAuction().getAuctions().size()==1);
        
        app.foundTenantByName("tenant").setWallet(10000);
        app.foundTenantByName("tenant2").setWallet(10000);
        app.addOffer(app.getaAuction().getAuctions().get(0), 5, 1, app.foundTenantByName("tenant"));
        app.addOffer(app.getaAuction().getAuctions().get(0), 10, 1, app.foundTenantByName("tenant2"));
        app.addOffer(app.getaAuction().getAuctions().get(0), 5, 3, app.foundTenantByName("tenant"));
        assertTrue(app.getaOffer().getOffers().size()==3);
        app.foundTenantByName("tenant2").setWallet(15);
        app.addOffer(app.getaAuction().getAuctions().get(0), 10, 2, app.foundTenantByName("tenant2"));
        assertTrue(app.getaOffer().getOffers().size()==3);
        app.getaAuction().getAuctions().get(0).getLastOffer().equals(app.getaOffer().getOffers().get(2));
        app.addOffer(app.getaAuction().getAuctions().get(0), 5, 5, app.foundTenantByName("tenant"));
        assertTrue(app.getaOffer().getOffers().size()==4);
        app.addOffer(app.getaAuction().getAuctions().get(0), 5, 6, app.foundTenantByName("tenant2"));
        assertTrue(app.getaOffer().getOffers().size()==4);
         assertEquals(app.getaAuction().getAuctions().get(0).getWinner(),null);
        app.getaAuction().getAuctions().get(0).setIsClose(true);  
        assertEquals(app.getaAuction().getAuctions().get(0).getWinner().getLogin(),"tenant2");
   }
    
    public void initializeData(Application app){
        app.createAdminAccount("root", "root", "root", "root", "root");
        app.ARR_CreateAccount("owner", "owner", "owner", "owner", "owner", TypeOfAccount.OWNER);
        app.ARR_CreateAccount("owner2", "owner2", "owner2", "owner2", "owner2", TypeOfAccount.OWNER);
        app.ARR_CreateAccount("tenant", "tenant", "tenant", "tenant", "tenant", TypeOfAccount.TENANT);
        
        assertTrue(app.getAccounts().size()==4);
        assertTrue(app.getProperties().isEmpty());
    }     
}
