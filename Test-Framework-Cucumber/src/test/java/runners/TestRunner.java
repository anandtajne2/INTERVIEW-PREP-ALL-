package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", 
	glue = { "stepdefination" }, 
	plugin = { "pretty",
		"html:target/cucumber-reports/cucumber.html", 
		"json:target/cucumber-reports/cucumber.json" 
		},
	monochrome = true,
	tags = "@Regression"
)
public class TestRunner {

}
