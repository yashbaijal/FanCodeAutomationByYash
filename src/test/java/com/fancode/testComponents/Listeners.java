package com.fancode.testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fancode.utils.ExtentReporterNG;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    ExtentReports extent= ExtentReporterNG.getReportObject();

    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
         test.log(Status.FAIL, "Test failed: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
         test.log(Status.SKIP, "Test skipped: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        test.log(Status.WARNING, "Test partially passed: " + result.getThrowable().getMessage());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite " + context.getName() + " started.");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();
    }
}
