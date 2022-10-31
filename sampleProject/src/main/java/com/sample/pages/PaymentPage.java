package com.sample.pages;
import com.sample.apiRequestBuilder.userGenerator.RandomUserGenerator;
import com.sample.exceptions.PaymentException;
import com.sample.exceptions.UserGeneratorException;
import com.sample.reporting.assertions.CustomAssert;
import com.sample.reporting.extentReports.Logger;
import com.sample.web.core.AbstractBasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * This class contains all the elements and actions performed on HomePage
 *
 * @author Himanshu Dua
 */
@Log4j2
@Getter
public class PaymentPage extends AbstractBasePage{
    @FindBy(xpath = "//div[@id='checkout-payment-method-load']")
    private WebElement paymentPage;

    @FindBy(xpath = "//button[@class='action primary checkout']")
    private WebElement checkout;


    @FindBy(xpath = "//div[@class='checkout-success']//strong")
    private WebElement paymentSuccess;



    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage placeOrder(){
        waitForElementToBeClickable(getCheckout());
        clickUsingJS(getCheckout());
        Logger.logInfo("click on place order");
        return this;
    }

    public void validatePaymentStatus(){
        try{
            waitForVisibilityOfElement(getPaymentSuccess());
            CustomAssert.assertTrue(readText(getPaymentSuccess())!=null,"Order id generated successfully "+readText(getPaymentSuccess()));
        }
        catch (Exception e){
            throw new PaymentException("error in placing order ",e);
        }

    }

    @Override
    public void isOnPage() {
        log.info("Verify Payment Page");
        waitForElementToBeClickable(getCheckout());
    }
}

