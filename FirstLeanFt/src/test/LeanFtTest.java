package test;

import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.stdwin.*;

import unittesting.UnitTestClassBase;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class LeanFtTest extends UnitTestClassBase {

	public LeanFtTest() throws IOException, InterruptedException, GeneralLeanFtException {
		 new ProcessBuilder("notepad.exe").start();

	        Thread.sleep(3000);

	        Window notepadWin = Desktop.describe(Window.class,
	                new WindowDescription.Builder().windowTitleRegExp("Notepad").build());

	        Editor editor = notepadWin.describe(Editor.class,
	                new EditorDescription.Builder().nativeClass("Edit").windowClassRegExp("Edit").build());

	        editor.sendKeys("1234");

	        Thread.sleep(30000);
	        notepadWin.close();

	        Desktop.describe(Window.class, new WindowDescription.Builder()
	                .ownedWindow(false).childWindow(false).windowClassRegExp("Notepad").windowTitleRegExp(" Notepad").build())
	                .describe(Dialog.class, new DialogDescription.Builder()
	                .ownedWindow(true).childWindow(false).text("Notepad").nativeClass("#32770").build())
	                .describe(Button.class, new ButtonDescription.Builder()
	                .text("Do&n't Save").nativeClass("Button").build()).click();
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
    public  void test() throws Exception{

    }
}