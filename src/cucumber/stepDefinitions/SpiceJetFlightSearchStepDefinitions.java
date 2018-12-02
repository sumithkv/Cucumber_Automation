package cucumber.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.utilities.BaseStepDefinition;

import org.junit.Assert;

public class SpiceJetFlightSearchStepDefinitions extends BaseStepDefinition {

	WebDriver driver = setWebDriver();

	@Given("^I am on SpiceJet Website$")
	public void openSpiceJetWebsite() throws Throwable {
		driver.get("http://www.spicejet.com/Default.aspx");
	}

	@When("^I selected One Way Trip$")
	public void tripSelection() throws Throwable {
		WebElement oneWay = driver.findElement(By.xpath("//input[@type='radio' and @value='OneWay']"));
		oneWay.click();
	}

	@When("^I am travelling from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void travelFromTo(String sss, String ddd) throws Throwable {

		// Method for normal parameter passing

		driver.findElement(By.xpath("//*[contains(@id, 'originStation') and @value='Leaving from...']")).click();
		driver.findElement(By.xpath("//div[@class='dropdownDiv']/ul/li/a[text()=' " + sss + "']")).click();

		driver.findElement(By.xpath("//*[contains(@id, 'destinationStation') and @value='Going to...']")).click();
		driver.findElement(By.xpath("//div[@class='dropdownDiv']/ul/li/a[text()=' " + ddd + "']")).click();
	}

	@When("^I am travelling on (\\d+)-(\\d+)-(\\d+)$")
	public void travellingOn(int dd, int mm, int yyyy) throws Throwable {

		// Method for normal parameter passing

		mm = mm - 1;
		WebElement fromDate = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']//table//tbody//td[@data-year="
				+ yyyy + " and @data-month=" + mm + "]//a[text()=" + dd + "]"));

		try {
			fromDate.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println(">>>>> YOU HAVE SELECTED AN INVALID DATE <<<<<");
		}
	}

	@When("^I selected (\\d+) Adults and (\\d+) Child$")
	public void travellersNumber(int arg1, int arg2) throws Throwable {

		// Method for normal parameter passing

		Select s1 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s1.selectByValue(Integer.toString(arg1));

		Select s2 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		s2.selectByValue(Integer.toString(arg2));
	}

	@When("^I click on the Find Flight button$")
	public void flightSearch() throws Throwable {
		WebElement findFlight = driver.findElement(By.xpath("//input[contains(@id,'FindFlights')]"));
		findFlight.click();
		Thread.sleep(10000);
	}

	@When("^I Move My Mouse Over \"([^\"]*)\" Menu$")
	public void mouseOverMenu(String menu) throws Throwable {

		// Method for normal parameter passing

		WebElement menuElement = driver.findElement(By.xpath("//a[contains(text()," + "'" + menu + "'" + ")]"));
		Actions act = new Actions(driver);
		act.moveToElement(menuElement).build().perform();
	}

	@Then("^I should get the Flight Information$")
	public void searchResults() throws Throwable {

		Assert.assertTrue(driver.findElement(By.xpath("//table[@id='availabilityTable0']/tbody/tr[2]/th[1]")).getText()
				.contains("Flight Information"));

		WebElement flightCount = driver
				.findElement(By.xpath("//table[@id='availabilityTable0']//tbody//span[@class='bound-flights']"));
		WebElement fromTo = driver
				.findElement(By.xpath("//table[@id='availabilityTable0']//tbody//span[@class='bound-city']"));
		WebElement date = driver
				.findElement(By.xpath("//table[@id='availabilityTable0']//tbody//span[@class='bound-date']"));

		System.out
				.println("*******************************************************************************************");
		System.out.println("On " + date.getText() + "  " + flightCount.getText() + "  from " + fromTo.getText());
		System.out.println("Lowest Price is : " + driver
				.findElement(By
						.xpath("//table[@id='availabilityTable0']//tr//td[contains(@class, 'SelectedFareTD')]//label//span"))
				.getText());
		System.out
				.println("*******************************************************************************************");

	}

	@And("^I close my window$")
	public void closeBrowser() throws Throwable {

		driver.close();
	}

	@When("^I am travelling between ([^\"]*) to ([^\"]*)$")
	public void journey(String sss, String ddd) throws Throwable {

		// Method for Outline Data Table

		driver.findElement(By.xpath("//*[contains(@id, 'originStation') and @value='Leaving from...']")).click();
		driver.findElement(By.xpath("//div[@class='dropdownDiv']/ul/li/a[text()=' " + sss + "']")).click();

		driver.findElement(By.xpath("//*[contains(@id, 'destinationStation') and @value='Going to...']")).click();
		driver.findElement(By.xpath("//div[@class='dropdownDiv']/ul/li/a[text()=' " + ddd + "']")).click();

	}

	@When("^I selected (\\d+) and (\\d+)$")
	public void travellers(int arg1, int arg2) throws Throwable {

		// Method for Outline Data Table

		Select s1 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s1.selectByValue(Integer.toString(arg1));

		Select s2 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		s2.selectByValue(Integer.toString(arg2));

	}

}
