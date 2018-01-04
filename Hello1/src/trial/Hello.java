package trial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Hello {
	
	@Test
	public void hello()
	{
		System.out.println("Hello1");
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/jmanera/Documents/Document/Java work/selenium chrome/chromedriver.exe");
		WebDriver wb = new ChromeDriver();
		wb.get("https://www.facebook.com");
		
		System.out.println(wb.getTitle());
		System.out.println("Hello2");
		wb.quit();
	}

}
