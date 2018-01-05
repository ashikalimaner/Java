package cucumber;

//import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;

//import com.google.common.annotations.VisibleForTesting;

//import cucumber.api.junit.*;

//@RunWith(Cucumber.class)
@Test
@CucumberOptions(features={"C:\\Users\\jmanera\\Documents\\Document\\Java work\\Cucumber\\features\\Myapplication.feature"}/*,glue={"stepDefination"}*/,plugin={"pretty", "html:target/output"/*"json:json_Output/cucmber.json"*//*"TestNG:testng/trial.xml"*/},dryRun=false,monochrome=true,strict=true)
public class CucumberRunnerOld extends BaseClass {

	
	
}
