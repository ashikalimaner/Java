package stepDefination;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.RuntimeOptions;

public class BackGround {
	public static WebDriver wb;
	
	public BackGround()
	{
		/*String feature="C:\\Users\\jmanera\\Documents\\Document\\Java work\\Cucumber\\features\\Myapplication.feature";
		System.setProperty("feature",
				feature);
		new RuntimeOptions(feature);*/
		
		
	}
	
	@Given("^Open chrome and start application$")
	public void given()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/jmanera/Documents/Document/Java work/selenium chrome/chromedriver.exe");
	    wb = new ChromeDriver();
		wb.get("https://www.facebook.com");
	}
	
	
	@When("^I enter valid  \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_valid_and(String username, String password) throws Throwable {

		wb.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		wb.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
	}

	
	
	
	@Then("^user should be able to login successfully$")
	public void then() throws InterruptedException  {
	 
		wb.findElement(By.xpath("//input[@value='Log In']")).click();
		
	}
	
	public static  WebDriver getter()
	{
		return wb;
	}

	
	public static String getFilePath()
	{
		File file=new File("C:\\Users\\jmanera\\Documents\\Document\\Java work\\Cucumber\\features\\Myapplication.feature");
		String path=file.getAbsolutePath();
		return path;
		 
	}
}
