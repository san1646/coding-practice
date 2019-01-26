package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.testng.Assert.assertTrue;

public class ConcurrentRequestTest {

    ConcurrentRequest req;

    @Before
    public void setUp() throws Exception {
        req = new ConcurrentRequest();
        req.start();
    }

    @After
    public void tearDown() throws Exception {
        req.stop();
    }

    @Test
    public void testGetOne() throws Exception {
        String s = req.getAreaFromDomainServices(BigInteger.ONE);
        Thread.sleep(10);
        assertTrue(s.contains("Area1"));
    }
    
    @Test
    public void testCreateArea() throws Exception {
        String areaName = "testArea-"+System.currentTimeMillis();
        String s = req.createArea(areaName);
        Thread.sleep(10);
        assertTrue(s.contains(areaName));
        
        
    }
}
