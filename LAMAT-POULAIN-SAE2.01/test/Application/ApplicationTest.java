/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Application;

import Account.Account;
import Account.Owner;
import Account.TypeOfAccount;
import Auction.Auction;
import Auction.Month;
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
        assertTrue(app.getAccounts().size()==3);
        assertTrue(app.getProperties().isEmpty());
        for(Account a : app.getAccounts()){
            if(a.getType().equals(TypeOfAccount.ADMIN)){
                app.setCurrentConnected(a);
                break;
            } 
        }
        assertTrue(app.getCurrentConnected().getLogin().equals("root"));
        Owner o = null;
        for(Account a : app.getAccounts()){
            if(a.getType().equals(TypeOfAccount.OWNER)){
                app.setCurrentConnected(a);
                o=(Owner)a;
                break;
            } 
        }
        assertTrue(app.getCurrentConnected().getLogin().equals("owner"));
        ArrayList<Property> tmp = app.getProperties();
        Property p2 = new Property("TheTest", "test", "test", "test",o , 5, 75, TypeOfProperty.APARTMENT);
        tmp.add(p2);
        //app.setProperties(tmp);
        
        assertTrue(app.getProperties().size()==1);
    }
    
    public void initializeData(Application app){
        app.createAdminAccount("root", "root", "root", "root", "root");
        app.ARR_CreateAccount("owner", "owner", "owner", "owner", "owner", TypeOfAccount.OWNER);
        app.ARR_CreateAccount("tenant", "tenant", "tenant", "tenant", "tenant", TypeOfAccount.TENANT);
        
        assertTrue(app.getAccounts().size()==3);
        assertTrue(app.getProperties().isEmpty());
    }     
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of disconnect method, of class Application.
     */
    @Test
    public void testDisconnect() {
        System.out.println("disconnect");
        Application instance = new Application();
        instance.disconnect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of log method, of class Application.
     */
    @Test
    public void testLog() {
        System.out.println("log");
        Application instance = new Application();
        instance.log();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ARR_ToLogIn method, of class Application.
     */
    @Test
    public void testARR_ToLogIn() {
        System.out.println("ARR_ToLogIn");
        Application instance = new Application();
        instance.ARR_ToLogIn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMenu method, of class Application.
     */
    @Test
    public void testCreateMenu() {
        System.out.println("createMenu");
        Application instance = new Application();
        instance.createMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ARR_CreateAdminAccount method, of class Application.
     */
    @Test
    public void testARR_CreateAdminAccount_5args() {
        System.out.println("ARR_CreateAdminAccount");
        String login = "";
        String name = "";
        String surname = "";
        String nickname = "";
        String email = "";
        Application instance = new Application();
        instance.ARR_CreateAdminAccount(login, name, surname, nickname, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentConnected method, of class Application.
     */
    @Test
    public void testSetCurrentConnected() {
        System.out.println("setCurrentConnected");
        Account currentConnected = null;
        Application instance = new Application();
        instance.setCurrentConnected(currentConnected);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWalletSociety method, of class Application.
     */
    @Test
    public void testSetWalletSociety() {
        System.out.println("setWalletSociety");
        int walletSociety = 0;
        Application instance = new Application();
        instance.setWalletSociety(walletSociety);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccounts method, of class Application.
     */
    @Test
    public void testGetAccounts() {
        System.out.println("getAccounts");
        Application instance = new Application();
        ArrayList<Account> expResult = null;
        ArrayList<Account> result = instance.getAccounts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProperties method, of class Application.
     */
    @Test
    public void testGetProperties() {
        System.out.println("getProperties");
        Application instance = new Application();
        ArrayList<Property> expResult = null;
        ArrayList<Property> result = instance.getProperties();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentConnected method, of class Application.
     */
    @Test
    public void testGetCurrentConnected() {
        System.out.println("getCurrentConnected");
        Application instance = new Application();
        Account expResult = null;
        Account result = instance.getCurrentConnected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWalletSociety method, of class Application.
     */
    @Test
    public void testGetWalletSociety() {
        System.out.println("getWalletSociety");
        Application instance = new Application();
        int expResult = 0;
        int result = instance.getWalletSociety();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class Application.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Application instance = new Application();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMyOffer method, of class Application.
     */
    @Test
    public void testDisplayMyOffer() {
        System.out.println("displayMyOffer");
        Application instance = new Application();
        instance.displayMyOffer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayOffers method, of class Application.
     */
    @Test
    public void testDisplayOffers() {
        System.out.println("displayOffers");
        Application instance = new Application();
        instance.displayOffers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ARR_CreateABid method, of class Application.
     */
    @Test
    public void testARR_CreateABid() {
        System.out.println("ARR_CreateABid");
        Application instance = new Application();
        instance.ARR_CreateABid();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOffer method, of class Application.
     */
    @Test
    public void testAddOffer() {
        System.out.println("addOffer");
        Auction auction = null;
        int amount = 0;
        int nbNight = 0;
        Application instance = new Application();
        instance.addOffer(auction, amount, nbNight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBid method, of class Application.
     */
    @Test
    public void testIsBid() {
        System.out.println("isBid");
        int amount = 0;
        Application instance = new Application();
        boolean expResult = false;
        boolean result = instance.isBid(amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of proposeOffer method, of class Application.
     */
    @Test
    public void testProposeOffer() {
        System.out.println("proposeOffer");
        Auction auction = null;
        Application instance = new Application();
        int expResult = 0;
        int result = instance.proposeOffer(auction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of foundAuctionByPropertyAndMonth method, of class Application.
     */
    @Test
    public void testFoundAuctionByPropertyAndMonth() {
        System.out.println("foundAuctionByPropertyAndMonth");
        Property property = null;
        Month month = null;
        Application instance = new Application();
        Auction expResult = null;
        Auction result = instance.foundAuctionByPropertyAndMonth(property, month);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ARR_CreateAccount method, of class Application.
     */
    @Test
    public void testARR_CreateAccount() {
        System.out.println("ARR_CreateAccount");
        String login = "";
        String name = "";
        String surname = "";
        String nickname = "";
        String email = "";
        TypeOfAccount type = null;
        Application instance = new Application();
        instance.ARR_CreateAccount(login, name, surname, nickname, email, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLogIn method, of class Application.
     */
    @Test
    public void testToLogIn() {
        System.out.println("toLogIn");
        String login = "";
        Application instance = new Application();
        instance.toLogIn(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePropertyDesc method, of class Application.
     */
    @Test
    public void testChangePropertyDesc() {
        System.out.println("changePropertyDesc");
        Account currentConnected = null;
        Property p = null;
        String s = "";
        Application instance = new Application();
        instance.changePropertyDesc(currentConnected, p, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePropretyAdress method, of class Application.
     */
    @Test
    public void testChangePropretyAdress() {
        System.out.println("changePropretyAdress");
        Account currentConnected = null;
        Property p = null;
        String s = "";
        Application instance = new Application();
        instance.changePropretyAdress(currentConnected, p, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePropretyTown method, of class Application.
     */
    @Test
    public void testChangePropretyTown() {
        System.out.println("changePropretyTown");
        Account currentConnected = null;
        Property p = null;
        String s = "";
        Application instance = new Application();
        instance.changePropretyTown(currentConnected, p, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePropretyOwner method, of class Application.
     */
    @Test
    public void testChangePropretyOwner() {
        System.out.println("changePropretyOwner");
        Account currentConnected = null;
        Property p = null;
        Owner o = null;
        Application instance = new Application();
        instance.changePropretyOwner(currentConnected, p, o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePropretyMaxCapacity method, of class Application.
     */
    @Test
    public void testChangePropretyMaxCapacity() {
        System.out.println("changePropretyMaxCapacity");
        Account currentConnected = null;
        Property p = null;
        int i = 0;
        Application instance = new Application();
        instance.changePropretyMaxCapacity(currentConnected, p, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePropretyNominalrice method, of class Application.
     */
    @Test
    public void testChangePropretyNominalrice() {
        System.out.println("changePropretyNominalrice");
        Account currentConnected = null;
        Property p = null;
        int i = 0;
        Application instance = new Application();
        instance.changePropretyNominalrice(currentConnected, p, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllUsers method, of class Application.
     */
    @Test
    public void testDisplayAllUsers() {
        System.out.println("displayAllUsers");
        Application instance = new Application();
        instance.displayAllUsers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllProperties method, of class Application.
     */
    @Test
    public void testDisplayAllProperties() {
        System.out.println("displayAllProperties");
        Application instance = new Application();
        instance.displayAllProperties();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayInformations method, of class Application.
     */
    @Test
    public void testDisplayInformations() {
        System.out.println("displayInformations");
        Application instance = new Application();
        instance.displayInformations();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editInformations method, of class Application.
     */
    @Test
    public void testEditInformations() {
        System.out.println("editInformations");
        Application instance = new Application();
        instance.editInformations();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillWallet method, of class Application.
     */
    @Test
    public void testFillWallet() {
        System.out.println("fillWallet");
        Application instance = new Application();
        instance.fillWallet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ARR_CreateAdminAccount method, of class Application.
     */
    @Test
    public void testARR_CreateAdminAccount_0args() {
        System.out.println("ARR_CreateAdminAccount");
        Application instance = new Application();
        instance.ARR_CreateAdminAccount();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAdminAccount method, of class Application.
     */
    @Test
    public void testCreateAdminAccount() {
        System.out.println("createAdminAccount");
        String login = "";
        String name = "";
        String surname = "";
        String nickname = "";
        String email = "";
        Application instance = new Application();
        instance.createAdminAccount(login, name, surname, nickname, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllAuctions method, of class Application.
     */
    @Test
    public void testDisplayAllAuctions() {
        System.out.println("displayAllAuctions");
        Application instance = new Application();
        instance.displayAllAuctions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAProperty method, of class Application.
     */
    @Test
    public void testRemoveAProperty() {
        System.out.println("removeAProperty");
        Application instance = new Application();
        instance.removeAProperty();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class Application.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        Application instance = new Application();
        instance.deleteUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editUser method, of class Application.
     */
    @Test
    public void testEditUser() {
        System.out.println("editUser");
        Application instance = new Application();
        instance.editUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchPropertyByName method, of class Application.
     */
    @Test
    public void testSearchPropertyByName() {
        System.out.println("searchPropertyByName");
        String name = "";
        Application instance = new Application();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.searchPropertyByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of foundPropertyByName method, of class Application.
     */
    @Test
    public void testFoundPropertyByName() {
        System.out.println("foundPropertyByName");
        Application instance = new Application();
        Property expResult = null;
        Property result = instance.foundPropertyByName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPropertyForAOwner method, of class Application.
     */
    @Test
    public void testGetPropertyForAOwner() {
        System.out.println("GetPropertyForAOwner");
        Application instance = new Application();
        ArrayList<Property> expResult = null;
        ArrayList<Property> result = instance.GetPropertyForAOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchPropertyByAdress method, of class Application.
     */
    @Test
    public void testSearchPropertyByAdress() {
        System.out.println("searchPropertyByAdress");
        String adress = "";
        Application instance = new Application();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.searchPropertyByAdress(adress);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of foundPropertyByAdress method, of class Application.
     */
    @Test
    public void testFoundPropertyByAdress() {
        System.out.println("foundPropertyByAdress");
        Application instance = new Application();
        Property expResult = null;
        Property result = instance.foundPropertyByAdress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editProperty method, of class Application.
     */
    @Test
    public void testEditProperty() {
        System.out.println("editProperty");
        Application instance = new Application();
        instance.editProperty();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAuction method, of class Application.
     */
    @Test
    public void testCreateAuction() {
        System.out.println("createAuction");
        Application instance = new Application();
        instance.createAuction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ARR_addProperty method, of class Application.
     */
    @Test
    public void testARR_addProperty() {
        System.out.println("ARR_addProperty");
        Application instance = new Application();
        instance.ARR_addProperty();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProperty method, of class Application.
     */
    @Test
    public void testCreateProperty() {
        System.out.println("createProperty");
        String name = "";
        String town = "";
        String adress = "";
        String description = "";
        Owner owner = null;
        int maxCapacity = 0;
        int nominalPrice = 0;
        TypeOfProperty type = null;
        Application instance = new Application();
        instance.createProperty(name, town, adress, description, owner, maxCapacity, nominalPrice, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
