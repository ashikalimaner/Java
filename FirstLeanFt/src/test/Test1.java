package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.*;
import com.hp.lft.sdk.java.WindowDescription;
import com.hp.lft.sdk.stdwin.*;
import com.hp.lft.verifications.*;
import org.junit.Test;
import com.hp.lft.sdk.Desktop;

import static org.junit.Assert.assertEquals;

import unittesting.*;

public class Test1 extends UnitTestClassBase {

    public Test1() {
    	
      
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new Test1();
        globalSetup(Test1.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
    	
    }
    	
    }

