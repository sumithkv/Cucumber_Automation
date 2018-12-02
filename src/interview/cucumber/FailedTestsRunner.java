package interview.cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/JsonReport/cucumber.json", "html:target/HtmlReport",
		"junit:target/JUnitReport/cucumber.xml", "rerun:target/rerun.txt" }, features = {
				"@target/rerun.txt" }, glue = { "cucumber.stepDefinitions", "cucumber.utilities" })

public class FailedTestsRunner {

	@BeforeClass
	public static void setup() {

		System.out.println("...JUnit @BeforeClass...");
	}

	@AfterClass
	public static void teardown() {

		System.out.println("...JUnit @AfterClass...");
	}

}
