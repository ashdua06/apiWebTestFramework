package com.sample.pages;
import com.sample.apiRequestBuilder.userGenerator.RandomUserGenerator;
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
public class ShippingAddressPage extends AbstractBasePage{
    @FindBy(xpath = "//li[@id='shipping']")
    private WebElement shippingAddress;


    @FindBy(xpath = "//div[@name='shippingAddress.street.0']//input")
    private WebElement streetAddressLine1;

    @FindBy(xpath = "//div[@name='shippingAddress.street.1']//input")
    private WebElement streetAddressLine2;

    @FindBy(xpath = "//div[@name='shippingAddress.street.2']//input")
    private WebElement streetAddressLine3;


    @FindBy(xpath = "//div[@name='shippingAddress.city']//input")
    private WebElement city;


    @FindBy(xpath = "//div[@name='shippingAddress.region_id']//select")
    private WebElement state;


    @FindBy(xpath = "//div[@name='shippingAddress.postcode']//input")
    private WebElement pincode;


    @FindBy(xpath = "//div[@name='shippingAddress.country_id']//select")
    private WebElement country;


    @FindBy(xpath = "//div[@name='shippingAddress.telephone']//input")
    private WebElement phoneNumber;


    @FindBy(xpath = "(//*[@id='co-shipping-method-form']//input)[1]")
    private WebElement flatRateShippingMethod;


    @FindBy(xpath = "//button[@class='button action continue primary']")
    private WebElement nextBtn;

    public ShippingAddressPage(WebDriver driver) {
        super(driver);
    }

    public ShippingAddressPage enterShippingAddressLine1(RandomUserGenerator user){
        waitForVisibilityOfElement(getStreetAddressLine1());
        typeText(getStreetAddressLine1(),String.valueOf(user.getResponsePojo().getResults().get(0).getLocation().getStreet().getNumber()));
        Logger.logInfo("enter shippind address 1");
        return this;
    }

    public ShippingAddressPage enterShippingAddressLine2(RandomUserGenerator user){
        waitForVisibilityOfElement(getStreetAddressLine2());
        typeText(getStreetAddressLine2(),user.getResponsePojo().getResults().get(0).getLocation().getStreet().getName());
        Logger.logInfo("enter shipping address 2");
        return this;
    }

    public ShippingAddressPage enterCity(RandomUserGenerator user){
        waitForVisibilityOfElement(getCity());
        typeText(getCity(),user.getResponsePojo().getResults().get(0).getLocation().getCity());
        Logger.logInfo("enter city");
        return this;
    }

    public ShippingAddressPage selectState(RandomUserGenerator user){
        waitForVisibilityOfElement(getState());
        selectByText(getState(),user.getResponsePojo().getResults().get(0).getLocation().getState());
        Logger.logInfo("select state");
        return this;
    }

    public ShippingAddressPage enterPincode(RandomUserGenerator user){
        waitForVisibilityOfElement(getPincode());
        typeText(getPincode(),String.valueOf(user.getResponsePojo().getResults().get(0).getLocation().getPostcode()));
        Logger.logInfo("enter postal code");
        return this;
    }
    public ShippingAddressPage selectCountry(RandomUserGenerator user){
        waitForVisibilityOfElement(getCountry());
        selectByText(getCountry(),user.getResponsePojo().getResults().get(0).getLocation().getCountry());
        Logger.logInfo("select country");
        return this;
    }

    public ShippingAddressPage enterPhoneNumber(RandomUserGenerator user){
        waitForVisibilityOfElement(getPhoneNumber());
        typeText(getPhoneNumber(),user.getResponsePojo().getResults().get(0).getPhone());
        Logger.logInfo("enter phone no");
        return this;
    }

    public ShippingAddressPage selectFlatRateShippingMethod(){
        waitForVisibilityOfElement(getFlatRateShippingMethod());
        click(getFlatRateShippingMethod());
        Logger.logInfo("select shipping method");
        return this;
    }

    public ShippingAddressPage clickNext(){
        waitForVisibilityOfElement(getNextBtn());
        click(getNextBtn());
        Logger.logInfo("click on next");
        return this;
    }

    @Override
    public void isOnPage() {
        log.info("Verify Shipping Address Page");
        waitForVisibilityOfElement(getPhoneNumber());
    }
}
