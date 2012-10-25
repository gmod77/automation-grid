package org.urbandaddy.com.common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created with IntelliJ IDEA.
 * User: sargenziano
 * Date: 10/23/12
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */

public class Analyzer implements IRetryAnalyzer {
    private int count = 0;
    private int MAX_COUNT = 3;

    public Analyzer() {
        System.out.println(" ModeledAnalyzer constructor "
            + this.getClass().getName());
    }

    @Override
    public boolean retry(ITestResult result) {
        System.out.println("running retry logic for '" + result.getName() +
             "' on class " + this.getClass().getName());
        if (count < MAX_COUNT) {
            result.getTestContext().getSkippedTests().removeResult(result.getMethod());
            count += 1;
            return true;
        }
        return false;
    }
}
