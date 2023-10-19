package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions
		(
		
		features=".//features/Verify_The_User_Details.feature",
		glue="stepDefinition",
		tags="@Test",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-reports/report.html"}
		
		)
public class RunnerClass {
	
	

}
