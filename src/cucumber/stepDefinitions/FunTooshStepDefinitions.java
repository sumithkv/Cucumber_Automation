package cucumber.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.utilities.BaseStepDefinition;

public class FunTooshStepDefinitions extends BaseStepDefinition {

	WebDriver driver = setWebDriver();

	@Before("@FunToosh")
	public void testSetupStartTime() {
		System.out.println("Cucumber Scenario : LEARNING HOOKS Started");
	}

	@After("@FunToosh")
	public void tearDownEndTime() {

		System.out.println("Cucumber Scenario : LEARNING HOOKS Ended");

	}

	@Given("^I am on FunToosh website$")
	public void navigateFunToosh() throws Throwable {

		driver.navigate().to("http://www.funtoosh.com/");
	}

	@When("^I selected the Age ([^\"]*)$")
	public void selectPoll(String sss) throws Throwable {

		WebElement age = driver.findElement(By
				.xpath("//table[@class='text_joke']//tr//td[child::input[@type='radio'] and following-sibling::td[contains(text(),'"
						+ sss + "')]]"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", age);

		age.click();

	}

	@When("^I clicked on Vote button$")
	public void clickVote() throws Throwable {

		driver.findElement(By.xpath("//input[@type='submit' and @value='Vote']")).click();

	}

	@Then("^I should get Funtoosh Poll Results$")
	public void verifyPoll() throws Throwable {

		WebElement txt = driver.findElement(By.xpath("//b[text()='Funtoosh Poll Results']"));
		Assert.assertTrue(txt.getText().length() != 0);
		driver.close();

	}

}
