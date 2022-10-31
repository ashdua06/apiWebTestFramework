package com.sample.reporting.generics;


import com.sample.reporting.extentReports.ExtentManager;
import com.sample.reporting.perfStatusReport.CreateAPIPerfReport;

public class ReportingGenericFunctions {
    public static void initExtentReporter(boolean removeRetriedTests, boolean addScreenshotsToReport, String reportName, String reportTitle) {
        ExtentManager.createInstance(reportTitle, removeRetriedTests, addScreenshotsToReport, reportName);

    }

    public static void initAPIPerfReporter(String apiPerfReportFileName, String apiPerfReportTitle){
        CreateAPIPerfReport.setApiPerfReport(true);
        CreateAPIPerfReport.createHTMLReport(apiPerfReportFileName,apiPerfReportTitle);
    }
}
