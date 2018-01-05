package stepDefination;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import cucumber.BaseClass;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginDefination  {
  public static WebDriver wb;
	
	public  LoginDefination()
	{
		wb=BackGround.getter();
		
	}
	

	@Given("^Enter search in Search Box$")
	public void enter_in_Search_Box(DataTable data)  {
		try {
			List<List<String>> args=data.raw();//data table concept..Not used much
			Thread.sleep(8000);
			System.out.println("Hi");
			wb.findElement(By.xpath("//input[@data-testid='search_input']")).sendKeys(args.get(0).get(0));
			
		} catch (Exception e) {
			System.out.println("Element not found in page");
			
		}
	}
	
	
	
	
	@When("^click search$")
	public void when1()
	{
		try {
			Thread.sleep(3000);
			
			wb.findElement(By.xpath("//button[@data-testid='facebar_search_button']")).click();
		} catch (InterruptedException e) {
		
			System.out.println("Button element didnot found");
		}
		
	}
	
	
	@Then("^I should get my friend in the list and send him friend request$")
	public void then1() throws InterruptedException  {
	 
		Thread.sleep(3000);
		List<WebElement> names = wb.findElements(By.xpath("//div[@style='-webkit-line-clamp: 2;']"));

		for (int i = 0; i < names.size(); i++) {

			if (names.get(i).getText().equalsIgnoreCase("ashikali maner")) {
				names.get(i).click();
				System.out.println("Found  friend at location in list" + (i + 1));
				break;

			} else {
				System.out.println("No friend with such name");
			}
		}
		Thread.sleep(2000);
		String r = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to sent friend request?  Press Yes or No");
		r = sc.next();
		if (r.equalsIgnoreCase("Yes")) {
			wb.findElement(By.xpath("//button[@class='_42ft _4jy0 FriendRequestAdd addButton _4jy4 _517h _9c6']"))
					.click();
		} else {
			System.out.println("Friend request did not send");

		}
		
	}
	
	@Given("^Click Profile Photo$")
	public void click_Profile_Photo() throws InterruptedException {
		Thread.sleep(3000);
		wb.findElement(By.xpath("//a[@title='Profile']")).click();

		Thread.sleep(3000);
	   
	}

	@When("^steps done to add photo$")
	public void steps_done_to_add_photo() throws InterruptedException  {
		Thread.sleep(3000);
		wb.findElement(By.xpath("//div[@class='fbTimelineProfilePicSelector _23fv']")).click();
		Thread.sleep(4000);
		/*if (wb.getTitle().contains("Ashik Ali")) {*/

			Thread.sleep(1000);
			wb.findElement(By.xpath("//a[@aria-label='Upload Photo']")).click();
		/*}*/
		Thread.sleep(4000);
	   
	}

	@Then("^Add from given path$")
	public void add_from_given_path() throws Exception  {
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection(
				"C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(4000);
	   
	}

	@Then("^click add Profile Photo$")
	public void click_add_Profile_Photo() throws InterruptedException {

		Thread.sleep(4000);
		wb.findElement(By.xpath("//button[@data-testid='profilePicSaveButton']")).click();
	   
	}


	
	
}
