package cucumber.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAfterMethods extends BaseStepDefinition {

	// This class contains only methods which are applicable to entire test
	// suite

	@Before
	public void setUp() throws Exception {

		System.out.println("Cucumber Scenario started at : " + getMyTime());
		driver.manage().deleteAllCookies();
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {

		scenario.write("***** SUCCESSFULLY COMPLETED THE EXECUTION *****");

		if (scenario.isFailed()) {

			// The following 2 lines will embed the Screen Shot of the FAiled
			// Test Case in HTML Result File
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");

			// The following 3 lines will capture the Screen Shot of the Failed
			// Test Case
			File file = new File(
					"E:\\My Docs\\Workspace\\MyStudy_Space\\Cucumber\\ErrorImages\\" + scenario.getName() + ".png");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, file);
		}

		else if (!scenario.getStatus().equals("passed")) {
			System.out.println("This is not a Scenario. And the Test Case is Passed. Add code for restart WebBrowser here");
		}

		System.out.println("Cucumber Scenario ended at : " + getMyTime());
		driver.quit();
	}

	public String getMyTime() {

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd, EEEEE hh:mm:ss, zzz");
		Date dt1 = new Date();
		return df.format(dt1);
	}

}
