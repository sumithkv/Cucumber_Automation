package cucumber.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.utilities.BaseStepDefinition;

public class PythonOffline extends BaseStepDefinition {

	WebDriver driver= setWebDriver();

	@Given("^I am on Python Website$")
	public void i_am_on_Python_Website() throws Throwable {
		driver.get("file:///E:/My%20Docs/Tech%20Docs/Python/Python%20Tutorials/Python%20-%20HTML/index.html");
	}

	@When("^I click on \"([^\"]*)\" link$")
	public void i_click_on_link(String arg1) throws Throwable {

		driver.findElement(By.xpath("//a[text()='" + arg1 + "']")).click();

	}

	@And("^I close window$")
	public void closeBrowser() throws Throwable {

		driver.close();
	}
}
