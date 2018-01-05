package cucumber;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import stepDefination.BackGround;



@Parameters({"feature"})
@Test()
@CucumberOptions(features={"C:\\Users\\jmanera\\Documents\\Document\\Java work\\Cucumber\\features\\Myapplication.feature"},glue={"stepDefination"},plugin={"pretty", "html:target/output"/*"json:json_Output/cucmber.json"*//*"TestNG:testng/trial.xml"*/},dryRun=false,monochrome=true,strict=false,tags={"@FriendRequest","~@ProfilePicChange"})
public class CucumberRunner1  extends BaseClass{
	/*static String a;
	static
	{
		a="C:\\Users\\jmanera\\Documents\\Document\\Java work\\Cucumber\\features\\Myapplication.feature";
	}*/
	public static String value;
	
	
	

}
