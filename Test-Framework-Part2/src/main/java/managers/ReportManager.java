package managers;

import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReport;

public class ReportManager {
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    public static void initializeReport() {
        // Initialize report instance
        ExtentReport.getReportInstance();
    }
    
    public static ExtentTest createTest(String testName) {
        ExtentTest extentTest = ExtentReport.getReportInstance().createTest(testName);
        test.set(extentTest);
        return extentTest;
    }
    
    public static ExtentTest getTest() {
        return test.get();
    }
    
    public static void flushReport() {
        ExtentReport.getReportInstance().flush();
    }
}