package com.sample.pages;
import com.sample.reporting.extentReports.Logger;
import com.sample.web.core.AbstractBasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * This class contains all the elements and actions performed on HomePage
 *
 * @author Himanshu Dua
 */
@Log4j2
@Getter
public class Homepage extends AbstractBasePage {
    @FindBy(xpath = "(//li/a[text()='Create an Account'])[1]")
    private WebElement createAccount;

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public Homepage clickCreateAccount(){
        waitForVisibilityOfElement(getCreateAccount());
        click(getCreateAccount());
        Logger.logInfo("click on create account link");
        return this;
    }

    @Override
    public void isOnPage() {
        log.info("Verify Home Page");
        waitForVisibilityOfElement(createAccount);
    }
}
