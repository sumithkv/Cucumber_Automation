package cucumber.utilities;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class JUnitTestListener extends RunListener { 
	
	// This class is not working in my framework

public void testRunStarted(Description description) throws Exception {
    System.out.println("Sumith >>>>> Number of tests to execute: " + description.testCount());
}

public void testRunFinished(Result result) throws Exception {
    System.out.println("Sumith >>>>> Number of tests executed: " + result.getRunCount());
}

public void testStarted(Description description) throws Exception {
    System.out.println("Sumith >>>>> Starting: " + description.getMethodName());
}

public void testFinished(Description description) throws Exception {
    System.out.println("Sumith >>>>> Finished: " + description.getMethodName());
  
}

public void testFailure(Failure failure) throws Exception {
    System.out.println("Sumith >>>>> Failed: " + failure.getDescription().getMethodName());
}

public void testAssumptionFailure(Failure failure) {
    System.out.println("Sumith >>>>> Failed: " + failure.getDescription().getMethodName());
}

public void testIgnored(Description description) throws Exception {
    System.out.println("Sumith >>>>> Ignored: " + description.getMethodName());
}

}
