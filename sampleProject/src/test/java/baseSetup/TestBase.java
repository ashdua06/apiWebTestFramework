package baseSetup;

import com.sample.reporting.generics.ReportingGenericFunctions;
import com.sample.reporting.listeners.AnnotationTransformer;
import com.sample.reporting.listeners.ReportingTestngListener;
import com.sample.constants.EnvConstants;
import com.sample.constants.TestNGParams;
import com.sample.web.core.BrowserInstance;
import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

@Log4j2
@Listeners({ ReportingTestngListener.class, AnnotationTransformer.class})
public class TestBase {

    protected static final String DEFAULT_PROVIDER = "defaultConfig";
    private final ThreadLocal<BrowserInstance> appInstance = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void startTest(XmlTest xmlTest, ITestContext context) {
        TestNGParams.getInstance().setTestNgParameters(xmlTest,context);
        initExtentReporter();
    }
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void beforeMethodTestBase(@Optional("config") String browser, Method method) {
        appInstance.set(new BrowserInstance(browser));
        log.info("beforeMethodTestBase() called");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodTestBase(ITestResult result) throws IOException {
        log.info("afterMethodTestBase() called");
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment(result.getMethod().getMethodName(), new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterTest(){
        /*if(getDriver()!=null)
            getDriver().quit();*/
    }

    public BrowserInstance getBrowserInstance() {
        return appInstance.get();
    }

    public void launchUrl(String url) {
        getBrowserInstance().start(url);
    }

    public WebDriver getDriver() {
        return getBrowserInstance().getDriver();
    }

    public synchronized void initExtentReporter() {
        ReportingGenericFunctions.initExtentReporter(EnvConstants.FLAG_REMOVE_RETRIEDTESTS, EnvConstants.FLAG_UPDATE_SCREENSHOTS, EnvConstants.FILE_NAME_REPORT, EnvConstants.REPORT_TITLE);
    }

}
