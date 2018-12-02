package cucumber.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/JsonReport/cucumber.json", "html:target/HtmlReport",
		"junit:target/JUnitReport/cucumber.xml", "rerun:target/rerun.txt" },
		features = { "src/cucumber/features/" }, glue = { "cucumber.stepDefinitions",
				"cucumber.utilities" }, monochrome = true, tags = { "@Python, @Flight, @FunToosh, @FluentEnglish" })

public class CucumberRunner {

	@BeforeClass
	public static void setup() {

		System.out.println("...JUnit @BeforeClass...");
	}

	@AfterClass
	public static void teardown() {

		System.out.println("...JUnit @AfterClass...");
	}

}
