/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package aime.services.implementations;

import aime.entities.Sms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class SmsServiceImplTest {
    
    public SmsServiceImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of ajouterSms method, of class SmsServiceImpl.
     */
    @Test
    public void testAjouterSms() {
        System.out.println("ajouterSms");
        Sms sms = null;
        SmsServiceImpl instance = new SmsServiceImpl();
        instance.ajouterSms(sms);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trouverSmsParId method, of class SmsServiceImpl.
     */
    @Test
    public void testTrouverSmsParId() {
        System.out.println("trouverSmsParId");
        int id = 0;
        SmsServiceImpl instance = new SmsServiceImpl();
        Sms expResult = null;
        Sms result = instance.trouverSmsParId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
