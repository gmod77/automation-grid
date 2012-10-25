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

    int count = 0;

    @Override
    public void onTestFailure(ITestResult result) {

        Reporter.setCurrentTestResult(result);

        if(result.getMethod().getRetryAnalyzer().retry(result)) {
            count++;
            result.setStatus(ITestResult.SKIP);
            System.out.println("Setting test run attempt status to Skipped");
        } else {
            count = 0;
            System.out.println("Retry limit exceeded for " + result.getName());
        }
        Reporter.setCurrentTestResult(null);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        count = 0;
    }

}
