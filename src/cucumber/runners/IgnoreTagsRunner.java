package cucumber.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","json:target/JsonReport/cucumber.json", "html:target/HtmlReport", "junit:target/JUnitReport/cucumber.xml"},
		features = {"src/cucumber/features/"},
		glue = {"cucumber.stepDefinitions"},
		monochrome = false,
		tags = {"~@Flight"}
		)
public class IgnoreTagsRunner {

}
