/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ACER
 */
public class DaftarPenggunaTest {
    
    public DaftarPenggunaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class DaftarPengguna.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarPengguna instance = new DaftarPengguna();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of check method, of class DaftarPengguna.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        String email = "";
        String password = "";
        DaftarPengguna instance = new DaftarPengguna();
        boolean expResult = false;
        boolean result = instance.check(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkId method, of class DaftarPengguna.
     */
    @Test
    public void testCheckId() {
        System.out.println("checkId");
        Long id = null;
        DaftarPengguna instance = new DaftarPengguna();
        boolean expResult = false;
        boolean result = instance.checkId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkEmail method, of class DaftarPengguna.
     */
    @Test
    public void testCheckEmail() {
        System.out.println("checkEmail");
        String email = "";
        DaftarPengguna instance = new DaftarPengguna();
        boolean expResult = false;
        boolean result = instance.checkEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPengguna method, of class DaftarPengguna.
     */
    @Test
    public void testGetPengguna() {
        System.out.println("getPengguna");
        String email = "";
        String password = "";
        DaftarPengguna instance = new DaftarPengguna();
        Pengguna expResult = null;
        Pengguna result = instance.getPengguna(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPengguna method, of class DaftarPengguna.
     */
    @Test
    public void testFindPengguna() {
        System.out.println("findPengguna");
        Long id = null;
        DaftarPengguna instance = new DaftarPengguna();
        Pengguna expResult = null;
        Pengguna result = instance.findPengguna(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPenggunas method, of class DaftarPengguna.
     */
    @Test
    public void testGetPenggunas_Long() {
        System.out.println("getPenggunas");
        Long id = null;
        DaftarPengguna instance = new DaftarPengguna();
        List expResult = null;
        List result = instance.getPenggunas(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPenggunas method, of class DaftarPengguna.
     */
    @Test
    public void testGetPenggunas_0args() {
        System.out.println("getPenggunas");
        DaftarPengguna instance = new DaftarPengguna();
        List expResult = null;
        List result = instance.getPenggunas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPengguna method, of class DaftarPengguna.
     */
    @Test
    public void testEditPengguna() {
        System.out.println("editPengguna");
        Pengguna pengguna = null;
        DaftarPengguna instance = new DaftarPengguna();
        instance.editPengguna(pengguna);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPengguna method, of class DaftarPengguna.
     */
    @Test
    public void testAddPengguna() {
        System.out.println("addPengguna");
        Pengguna pengguna = null;
        DaftarPengguna instance = new DaftarPengguna();
        instance.addPengguna(pengguna);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePengguna method, of class DaftarPengguna.
     */
    @Test
    public void testDeletePengguna() throws Exception {
        System.out.println("deletePengguna");
        Long id = null;
        DaftarPengguna instance = new DaftarPengguna();
        instance.deletePengguna(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmf method, of class DaftarPengguna.
     */
    @Test
    public void testGetEmf() {
        System.out.println("getEmf");
        DaftarPengguna instance = new DaftarPengguna();
        EntityManagerFactory expResult = null;
        EntityManagerFactory result = instance.getEmf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmf method, of class DaftarPengguna.
     */
    @Test
    public void testSetEmf() {
        System.out.println("setEmf");
        EntityManagerFactory emf = null;
        DaftarPengguna instance = new DaftarPengguna();
        instance.setEmf(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
