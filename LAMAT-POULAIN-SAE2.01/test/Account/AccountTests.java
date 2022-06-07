package Account;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Utilisateur
 */
public class AccountTests {
    
    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        tenantTests();
        ownerTests();
        adminTests();
    }
    
    
    public void tenantTests(){
        Tenant t = new Tenant("rlamat", "lamat", "remi", "rl", "remi.lamat@etu-u.bordeaux.fr");
        
        Assert.assertEquals(t.getType(),TypeOfAccount.TENANT);
        assert t.getWallet()==0;
        
        t.setWallet(150);
        assert t.getWallet()==150;
        Assert.assertTrue(t.enougthToPay(100));
        Assert.assertTrue(t.enougthToPay(150));
        Assert.assertFalse(t.enougthToPay(151));
        Assert.assertFalse(t.enougthToPay(367));
        
        System.out.println("Tenant Tests OK");
    }
    
    public void ownerTests(){
        Owner o = new Owner("root", "root", "root", "root", "root.root@root.com");
        
        Assert.assertEquals(o.getType(),TypeOfAccount.OWNER);
        assert o.getWallet()==0;
        
        o.setWallet(150);
        assert o.getWallet()==150;
        Assert.assertTrue(o.enougthToPay(100));
        Assert.assertTrue(o.enougthToPay(150));
        Assert.assertFalse(o.enougthToPay(151));
        Assert.assertFalse(o.enougthToPay(367));
        
        
        System.out.println("Owner Tests OK");
    }
    
    public void adminTests(){
        Admin a = new Admin("rlamat", "lamat", "remi", "rl", "remi.lamat@etu-u.bordeaux.fr");
        
        Assert.assertEquals(a.getType(),TypeOfAccount.ADMIN);
        assert a.getWallet()==0;
        
        a.setWallet(150);
        assert a.getWallet()==150;
        Assert.assertTrue(a.enougthToPay(100));
        Assert.assertTrue(a.enougthToPay(150));
        Assert.assertFalse(a.enougthToPay(151));
        Assert.assertFalse(a.enougthToPay(367));
        
        System.out.println("Admin Tests OK");
    }
}