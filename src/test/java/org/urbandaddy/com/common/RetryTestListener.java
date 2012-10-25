package org.urbandaddy.com.common;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: sargenziano
 * Date: 10/24/12
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class RetryTestListener extends TestListenerAdapter{
    private int count = 0;
    private int maxCount = 3;

    private static Logger testbaseLog;

    static {
        testbaseLog = Logger.getLogger(RetryTestListener.class);
    }



    @Override
    public void onTestFailure(ITestResult result) {
        Logger testbaseLog = Logger.getLogger(RetryTestListener.class);
        Reporter.setCurrentTestResult(result);

        if(result.getMethod().getRetryAnalyzer().retry(result)) {
            count++;
            result.setStatus(ITestResult.SKIP);
            testbaseLog.warn("Error in " + result.getName() + " with status "
                    + result.getStatus()+ " Retrying " + count + " of 3 times");
            testbaseLog.info("Setting test run attempt status to Skipped");
        } else {
            count = 0;
            testbaseLog.error("Retry limit exceeded for " + result.getName());
        }
        Reporter.setCurrentTestResult(null);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        count = 0;
    }

}
