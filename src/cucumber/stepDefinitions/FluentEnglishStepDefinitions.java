package cucumber.stepDefinitions;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.utilities.BaseStepDefinition;

public class FluentEnglishStepDefinitions extends BaseStepDefinition {

	WebDriver driver = setWebDriver();

	@Given("^I am on Fluent English page$")
	public void launchWebPage() throws Throwable {
		driver.get("http://www.fluentin3months.com/");
	}

	@When("^I enters valid data and submit the page$")
	public void populateDataTableData(DataTable myTable) throws Throwable {

		// This method explains the use of Data Tables

		List<List<String>> data = myTable.raw();

		driver.findElement(By.id("inf_field_FirstName")).sendKeys(data.get(1).get(1));
		driver.findElement(By.id("inf_field_Email")).sendKeys(data.get(2).get(1));

		Select select = new Select(driver.findElement(By.name("inf_option_Whatlanguageareyoulearning")));
		select.selectByVisibleText(data.get(3).get(1));

		driver.findElement(By.xpath("//div[@class='infusion-submit']//input[@type='submit']")).click();
	}

	@Then("^I should register the user successfully$")
	public void verifyRegistration() throws Throwable {

		Assert.assertTrue(driver.getTitle().contains("Stop"));
		driver.close();
	}

}