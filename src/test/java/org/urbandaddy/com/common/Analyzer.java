package org.urbandaddy.com.common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

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
    private static Logger testbaseLog;

    static {
        testbaseLog = Logger.getLogger(Analyzer.class);

    }

    public Analyzer() {
        testbaseLog.trace(" ModeledAnalyzer constructor "
            + this.getClass().getName());
    }

    @Override
    public boolean retry(ITestResult result) {
        testbaseLog.trace("running retry logic for '" + result.getName() +
             "' on class " + this.getClass().getName());
        if (count < MAX_COUNT) {

            count += 1;
            return true;
        }
        return false;
    }
}
