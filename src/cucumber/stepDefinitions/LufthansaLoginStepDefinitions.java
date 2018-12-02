package cucumber.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.utilities.BaseStepDefinition;

import org.junit.Assert;

public class LufthansaLoginStepDefinitions extends BaseStepDefinition {

	WebDriver driver = setWebDriver();
	WebDriverWait wait1, wait2, wait3 = null;

	@Given("^I am on Lufthansa website$")
	public void navigateToLufthansaSite() throws Throwable {
		driver.get("http://www.lufthansa.com/in/en/Homepage");
	}

	@When("^I click on the Login link$")
	public void clickLoginLink() throws Throwable {
		WebElement login = driver.findElement(By.id("header-profile-toggle"));
		login.click();
	}

	@When("^I enters invalid User Name and Password$")
	public void enterInvalidCredentials() throws Throwable {
		wait1 = new WebDriverWait(driver, 3000);
		wait1.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//form[@id='loginUserdataForm']/h5[text()='Login at Lufthansa:']"))));
		WebElement username = driver.findElement(By.id("lluserid"));
		username.clear();
		username.sendKeys("AppuKuttan");
		WebElement password = driver.findElement(By.id("llpassword"));
		password.clear();
		password.sendKeys("Password123");
	}

	@When("^I enters valid User Name and Password$")
	public void enterValidCredentials() throws Throwable {
		wait2 = new WebDriverWait(driver, 3000);
		wait2.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//form[@id='loginUserdataForm']/h5[text()='Login at Lufthansa:']")));
		WebElement username = driver.findElement(By.id("lluserid"));
		username.clear();
		username.sendKeys("sumithkv");
		WebElement password = driver.findElement(By.id("llpassword"));
		password.clear();
		password.sendKeys("Lufthansa123");
	}

	@When("^I uncheck the Keep Me Logged In checkbox$")
	public void uncheckRememberMe() throws Throwable {
		WebElement chkBox = driver.findElement(By.xpath(
				"//*[@id='loginUserdataForm']//div[@class='checkbox']//label[@for='ll-remember-me']//input[@id='ll-remember-me']"));

		if (chkBox.isSelected()) {
			chkBox.click();
		}
	}

	@When("^I click on the Login button$")
	public void clickLoginButton() throws Throwable {
		WebElement loginButton = driver.findElement(By.id("ll-btn"));
		loginButton.click();
	}

	@When("^I click on the Forgot Password link$")
	public void clickForgotPassword() throws Throwable {
		WebElement forgotPassword = driver
				.findElement(By.xpath("//form[@id='loginUserdataForm']//a[text()='Forgotten password/PIN']"));
		forgotPassword.click();
	}

	@Then("^I should see Login Failed message$")
	public void verifyLoginFailureMessage() throws Throwable {
		WebElement errMsg = driver.findElement(
				By.xpath("//div[@class='error-container']//ul[@class='msg-error']//li[@class='error-headline']"));
		Assert.assertEquals("Your login failed", errMsg.getText());
	}

	@Then("^I should see User Profiles$")
	public void userProfile() throws Throwable {
		WebElement loggedUser = driver.findElement(By
				.xpath("//div[contains(@class,'user-information')]//h3//a[contains(text(),'Sumith Kottila Veettil')]"));
		loggedUser.click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='profile']//div[@class='heading']//h1")).getText()
				.contains("Sumith Kottila Veettil"));
	}

	@Then("^I should see Request new password$")
	public void seeRequestNewPassword() throws Throwable {
		wait3 = new WebDriverWait(driver, 3000);
		wait3.until(ExpectedConditions.titleContains("Forgotten Password - Lufthansa ® India"));
		WebElement requestPassword = driver.findElement(By.id("forget-pass"));
		Assert.assertTrue("Request Password Page is not found...",
				requestPassword.getText().contains("Request new password"));
	}

	@Then("^I close the browser$")
	public void closeBrowser() throws Throwable {
		driver.close();
	}

}
