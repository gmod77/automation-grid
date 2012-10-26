package org.urbandaddy.com.common;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: sargenziano
 * Date: 10/24/12
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class RetryTestListener extends TestListenerAdapter{

    @Override
    public void onTestFailure(ITestResult result) {

        Reporter.setCurrentTestResult(result);

        if(result.getMethod().getRetryAnalyzer().retry(result)) {
            result.setStatus(ITestResult.SKIP);
            System.out.println("Setting test run attempt status to Skipped");
        } else {
            System.out.println("Retry limit exceeded for " + result.getName());
        }
        Reporter.setCurrentTestResult(null);
    }
}
