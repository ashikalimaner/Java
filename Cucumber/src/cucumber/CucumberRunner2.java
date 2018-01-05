package cucumber;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;


@Test
@CucumberOptions(features={"C:\\Users\\jmanera\\Documents\\Document\\Java work\\Cucumber\\features\\Myapplication.feature"},glue={"stepDefination"},plugin={"pretty", "html:target/output"/*"json:json_Output/cucmber.json"*//*"TestNG:testng/trial.xml"*/},dryRun=false,monochrome=true,strict=true)
public class CucumberRunner2 extends BaseClass {

}
