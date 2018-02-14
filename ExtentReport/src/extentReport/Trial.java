package extentReport;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Trial {
	public static ExtentReports report;
	public static ExtentTest logger;
	public static Scanner sc;

	
	
	@BeforeSuite
	
	public static void beforesuite()
	{
		 sc = new Scanner(System.in);
	}
	@BeforeTest
	public static void settings() {
		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/ashikali.html", true);
		//report.addSystemInfo("ashikali", "system");
        logger=new ExtentTest("trial", "Just Testing");
       
	}

	@AfterMethod
	public static void end() {
		report.endTest(logger);
		report.flush();
		
		
	}
	
	@AfterSuite
	public static void ending() throws Exception
	{
		
		report.close();
		HtmlModifier.main();
	}

	public static String getScreenShot(WebDriver wb, String screenShotName) throws IOException {
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());

		TakesScreenshot scrShot = ((TakesScreenshot) wb);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "\\Screenshot\\" + screenShotName + date + ".png";
		File DestFile = new File(destination);

		FileUtils.copyFile(SrcFile, DestFile);
		return destination;
	}

	public static void registration(WebDriver wb) {

		wb.findElement(By.xpath("//input[@name='firstname']")).sendKeys("ashik");
		wb.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ali");
		wb.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8788948300");
		wb.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("ashikalimaner");
		Select i = new Select(wb.findElement(By.xpath("//select[@name='birthday_day']")));
		i.selectByIndex(3);

		Select i1 = new Select(wb.findElement(By.xpath("//select[@name='birthday_month']")));
		i1.selectByVisibleText("Sept");
		Select i2 = new Select(wb.findElement(By.xpath("//select[@name='birthday_year']")));
		i2.selectByVisibleText("1998");
		wb.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		wb.findElement(By.xpath("//button[@name='websubmit']")).click();

	}

	public static void login(WebDriver wb) {
		wb.findElement(By.xpath("//input[@name='email']")).sendKeys("8788948300");
		wb.findElement(By.xpath("//input[@name='pass']")).sendKeys("ashikalimaner");
		wb.findElement(By.xpath("//input[@value='Log In']")).click();
		logger.log(LogStatus.PASS, "Login Successfully");
	}

	public static void profilepic(WebDriver wb) throws InterruptedException, AWTException {
		wb.findElement(By.xpath("//a[@title='Profile']")).click();

		Thread.sleep(3000);
		wb.findElement(By.xpath("//div[@class='name']//following::a[text()='Add Photo']")).click();
		Thread.sleep(4000);
		if (wb.getTitle().contains("Ashik Ali")) {

			Thread.sleep(1000);
			wb.findElement(By.xpath("//input[@title='Choose a file to upload']//parent::div")).click();
		}
		Thread.sleep(4000);

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
		wb.findElement(By.xpath("//button[@data-testid='profilePicSaveButton']")).click();

	}

	public static void coverphoto(WebDriver wb) throws InterruptedException, AWTException {
		wb.findElement(By.xpath("//a[@title='Profile']")).click();
		if (wb.getTitle().contains("Shreya")) {

			Thread.sleep(1000);
			wb.findElement(By.xpath("//span[text()='Add Cover Photo']")).click();
			Thread.sleep(2000);
			try {
				System.out.println(
						wb.findElement(By.xpath("//div[@class='_53iv']/h3[text()='Your cover photo']")).getText());
				wb.findElement(By
						.xpath("//table[@class='uiGrid _51mz uiOverlayFooterGrid']//following::button[@type='submit']"))
						.click();
			} catch (NoSuchElementException e) {
				System.out.println("Element not present");
			}

			try {
				wb.findElement(By.xpath("//input[@name='pic']//parent::div")).click();
			} catch (ElementNotVisibleException e) {

				System.out.println("Element not visble");
			}
		}
		Thread.sleep(4000);

		StringSelection stringSelection = new StringSelection(
				"C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(8000);
		wb.findElement(By.xpath("//button[@name='save']")).click();

	}

	public static void SearchNFriend(WebDriver wb) throws InterruptedException {
		Thread.sleep(3000);
		try {
			wb.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("ashikali");
			logger.log(LogStatus.PASS, "Search friend name enetered successfully");
			wb.findElement(By.xpath("//button[@data-testid='facebar_search_button']")).click();
			logger.log(LogStatus.PASS, "Search friend Clicked  successfully");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "No friend found");
			// e.printStackTrace();
		}
		Thread.sleep(3000);
		List<WebElement> names = wb.findElements(By.xpath("//div[@style='-webkit-line-clamp: 2;']"));

		for (int i = 0; i < names.size(); i++) {

			if (names.get(i).getText().equalsIgnoreCase("ashikali maner")) {
				names.get(i).click();
				logger.log(LogStatus.PASS, "Found  friend at location in list" + (i + 1));

				break;

			} else {
				logger.log(LogStatus.PASS, "No friend found");
			}
		}
		Thread.sleep(2000);
		String r = null;
	
		System.out.println("Do you want to sent friend request?  Press Yes or No");
		logger.log(LogStatus.PASS, "Do you want to sent friend request?  Press Yes or No");
		
		r = sc.next();
		if (r.equalsIgnoreCase("Yes")) {
			logger.log(LogStatus.PASS, "Yes");
			wb.findElement(By.xpath("//button[@class='_42ft _4jy0 FriendRequestAdd addButton _4jy4 _517h _9c6']"))
					.click();
		} else {
			logger.log(LogStatus.FAIL, "Friend request did not send");
			

		}
		

	}

	@Test(priority=0)
	public static void main1() throws Exception {
		logger=report.startTest("Login 1");
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/jmanera/Documents/Document/Java work/selenium chrome/chromedriver.exe");
		WebDriver wb = new ChromeDriver();

		wb.get("https://www.facebook.com");
		logger.log(LogStatus.PASS, "Facebook opened successfully");
		// wb.manage().window().maximize();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Facebook page opening");
		// registration(wb);
		login(wb);
		Thread.sleep(5000);
		// profilepic(wb);
		// coverphoto(wb);
		SearchNFriend(wb);
		String destination=getScreenShot( wb,"Trial");
		
		logger.log(LogStatus.PASS, logger.addScreenCapture(destination));
		

	}
	@Test(priority=1)
	public static void main2() throws Exception {
		logger=report.startTest("Login 2");
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/jmanera/Documents/Document/Java work/selenium chrome/chromedriver.exe");
		WebDriver wb = new ChromeDriver();

		wb.get("https://www.facebook.com");
		logger.log(LogStatus.PASS, "Facebook opened successfully");
		// wb.manage().window().maximize();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Facebook page opening");
		// registration(wb);
		login(wb);
		Thread.sleep(5000);
		// profilepic(wb);
		// coverphoto(wb);
		SearchNFriend(wb);
		String destination=getScreenShot( wb,"Trial1");
		
		logger.log(LogStatus.PASS, logger.addScreenCapture(destination));
		
		
		

	}
}
