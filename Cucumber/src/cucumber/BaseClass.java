package cucumber;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepDefination.BackGround;

public class BaseClass extends AbstractTestNGCucumberTests{
	
	
	
	@Before
	public  void beforeMethod()
	{
		System.out.println("I am in before method");
		//value=BackGround.getFilePath();
	}
	
	@After
	public  void afterMethod(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			System.out.println("I am in Scenario Fail case");
		}
		System.out.println("I am in After method");
		//BaseClass.getFinalReport();
	}
	

}
