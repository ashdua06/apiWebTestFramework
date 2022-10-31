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
public class ShoppingCartPage extends AbstractBasePage{
    @FindBy(xpath = "//li/button[@title='Proceed to Checkout']")
    private WebElement proceedToCheckoutBtn;



    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage proceedToCheckout(){
        waitForElementToBeClickable(getProceedToCheckoutBtn());
        click(getProceedToCheckoutBtn());
        Logger.logInfo("click on proceed to checkout");
        return this;
    }

    @Override
    public void isOnPage() {
        log.info("Verify Shopping Cart Page");
        waitForVisibilityOfElement(getProceedToCheckoutBtn());
    }
}
