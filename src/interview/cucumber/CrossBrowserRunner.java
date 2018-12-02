package interview.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Chrome")
class ChromeTest {
	@Before("@Chrome")
	public void launchChrome() {
	}
}

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Firefox")
class FirefoxTest {
	@Before("@Firefox")
	public void launchFireFox() {
	}
}

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@IE")
class IeTest {
	@Before("@IE")
	public void launchIE() {
	}
}


// The invocation codes for all the browser can be written in BaseStepDefinition class.
// There @Before() annotation can be used multiple times for each browser.