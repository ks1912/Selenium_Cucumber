package runner;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions
	(
	
		features=".//features/Verify_The_User_Details.feature",
		glue="stepDefinition",
		tags="@Test",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-reports/report.html"}
	
	)

public class RunnerTestNG extends AbstractTestNGCucumberTests  {

}
