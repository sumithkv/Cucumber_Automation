package cucumber.utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class BaseStepDefinition {

	protected static WebDriver driver;

	protected static WebDriver setWebDriver() {

		String Browser = LoadTestProperties.getProperty("WebBrowser");

		if (Browser.equalsIgnoreCase("firefox"))

		{
			System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\MyStudy_Space\\Drivers\\geckodriver.exe");
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("browser.startup.homepage", "http://google.co.in");
			driver = new FirefoxDriver(fp);
		}

		else if (Browser.equalsIgnoreCase("ie32"))

		{
			System.setProperty("webdriver.ie.driver",
					"E:\\My Docs\\Workspace\\MyStudy_Space\\Drivers\\IE32\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else if (Browser.equalsIgnoreCase("ie64"))

		{
			System.setProperty("webdriver.ie.driver",
					"E:\\My Docs\\Workspace\\MyStudy_Space\\Drivers\\IE64\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else if (Browser.equalsIgnoreCase("chrome"))

		{
			System.setProperty("webdriver.chrome.driver",
					"E:\\My Docs\\Workspace\\MyStudy_Space\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (Browser.equalsIgnoreCase("phantomjs"))

		{
			System.setProperty("phantomjs.binary.path", "C:\\Selenium\\phantomjs.exe");
			driver = new PhantomJSDriver();
		}

		else {
			System.out.println("The Specified Browser Does Not Exists...");
		}

		driver.manage().window().maximize();

		// Implicit wait specified for the WebDriver
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Page load timeout for the WebDriver
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		// Script timeout for the WebDriver
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.MINUTES);

		return driver;
	}

}
