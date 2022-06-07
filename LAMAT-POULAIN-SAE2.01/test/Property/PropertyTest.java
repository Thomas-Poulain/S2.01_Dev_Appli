/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Property;

import Account.Owner;
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
public class PropertyTest {
    
    public PropertyTest() {
    }
    
    @Test
    public void propertyTests(){
        Owner o = new Owner("tpoulain", "poulain", "thomas", "tp", "thomas.poulain@etu-u.bordeaux.fr");
        Property p = new Property("test", "Pessac", "4 rue Ilar", "Test House.", o, 4, 25, TypeOfProperty.HOUSE);
        
        assertFalse(p.isIsRented());
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
     * Test of getName method, of class Property.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Property instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Property.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Property instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTown method, of class Property.
     */
    @Test
    public void testGetTown() {
        System.out.println("getTown");
        Property instance = null;
        String expResult = "";
        String result = instance.getTown();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Property.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Property instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIsRented method, of class Property.
     */
    @Test
    public void testIsIsRented() {
        System.out.println("isIsRented");
        Property instance = null;
        boolean expResult = false;
        boolean result = instance.isIsRented();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdress method, of class Property.
     */
    @Test
    public void testGetAdress() {
        System.out.println("getAdress");
        Property instance = null;
        String expResult = "";
        String result = instance.getAdress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class Property.
     */
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        Property instance = null;
        Owner expResult = null;
        Owner result = instance.getOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxCapacity method, of class Property.
     */
    @Test
    public void testGetMaxCapacity() {
        System.out.println("getMaxCapacity");
        Property instance = null;
        int expResult = 0;
        int result = instance.getMaxCapacity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNominalPrice method, of class Property.
     */
    @Test
    public void testGetNominalPrice() {
        System.out.println("getNominalPrice");
        Property instance = null;
        int expResult = 0;
        int result = instance.getNominalPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTown method, of class Property.
     */
    @Test
    public void testSetTown() {
        System.out.println("setTown");
        String town = "";
        Property instance = null;
        instance.setTown(town);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdress method, of class Property.
     */
    @Test
    public void testSetAdress() {
        System.out.println("setAdress");
        String adress = "";
        Property instance = null;
        instance.setAdress(adress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Property.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Property instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOwner method, of class Property.
     */
    @Test
    public void testSetOwner() {
        System.out.println("setOwner");
        Owner owner = null;
        Property instance = null;
        instance.setOwner(owner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsRented method, of class Property.
     */
    @Test
    public void testSetIsRented() {
        System.out.println("setIsRented");
        boolean isRented = false;
        Property instance = null;
        instance.setIsRented(isRented);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxCapacity method, of class Property.
     */
    @Test
    public void testSetMaxCapacity() {
        System.out.println("setMaxCapacity");
        int maxCapacity = 0;
        Property instance = null;
        instance.setMaxCapacity(maxCapacity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeOfProperty method, of class Property.
     */
    @Test
    public void testGetTypeOfProperty() {
        System.out.println("getTypeOfProperty");
        Property instance = null;
        TypeOfProperty expResult = null;
        TypeOfProperty result = instance.getTypeOfProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNominalPrice method, of class Property.
     */
    @Test
    public void testSetNominalPrice() {
        System.out.println("setNominalPrice");
        int nominalPrice = 0;
        Property instance = null;
        instance.setNominalPrice(nominalPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayPropertyInformation method, of class Property.
     */
    @Test
    public void testDisplayPropertyInformation() {
        System.out.println("displayPropertyInformation");
        Property instance = null;
        instance.displayPropertyInformation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
