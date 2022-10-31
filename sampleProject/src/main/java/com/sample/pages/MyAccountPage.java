package com.sample.pages;
import com.sample.reporting.extentReports.Logger;
import com.sample.web.core.AbstractBasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This class contains all the elements and actions performed on HomePage
 *
 * @author Himanshu Dua
 */
@Log4j2
@Getter
public class MyAccountPage extends AbstractBasePage{
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement accountCreationMessage;


    @FindBy(xpath = "//div[@data-ui-id='message-success']")
    private List<WebElement> accountCreationSuccessMessage;

    @FindBy(xpath = "//div[@data-ui-id='message-error']")
    private List<WebElement> accountCreationFailureMessage;

    @FindBy(xpath = "//span[text()='Sale']/..")
    private WebElement sale;



    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage waitForAccountCreation(){
       waitForVisibilityOfElement(getAccountCreationMessage());
        return this;
    }

    public boolean verifyAccountCreationSuccessful(){
       return isElementExist(getAccountCreationSuccessMessage());
    }

    public MyAccountPage clickSale(){
        click(getSale());
        Logger.logInfo("click on sale");
        return this;
    }


    @Override
    public void isOnPage() {
        log.info("Verify My Account Page");
        waitForVisibilityOfElement(accountCreationMessage);
    }

}
