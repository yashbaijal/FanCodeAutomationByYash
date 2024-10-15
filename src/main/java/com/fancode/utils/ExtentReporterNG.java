package com.fancode.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReportObject()
    {
        String path=System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("API Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        ExtentReports extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","ProductQA");
        return extent;
    }
}
