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
public class ProductPage extends AbstractBasePage{

    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement addToCart;

    @FindBy(xpath = "//div[@id='option-label-size-143-item-166']")
    private WebElement selectXsSize;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-49']")
    private WebElement selectColor;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement itemAddedToCart;


    @FindBy(xpath = "//div[@role='alert']//a")
    private WebElement goToShoppingCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectXsSize(){
        waitForVisibilityOfElement(getSelectXsSize());
        click(getSelectXsSize());
        Logger.logInfo("select size");
        return this;
    }

    public ProductPage selectColor(){
        waitForVisibilityOfElement(getSelectColor());
        clickUsingJS(getSelectColor());
        Logger.logInfo("select color");
        return this;
    }


    public ProductPage addToCart(){
        waitForElementToBeClickable(getAddToCart());
        clickUsingJS(getAddToCart());
        Logger.logInfo("add item to cart");
        return this;
    }

    public ProductPage itemAddedToCartMessage(){
        waitForVisibilityOfElement(getItemAddedToCart());
        Logger.logPass("item added to cart successfully");
        return this;
    }

    public ProductPage goToShoppingCart(){
        waitForVisibilityOfElement(getGoToShoppingCart());
        click(getGoToShoppingCart());
        Logger.logInfo("go to shopping cart");
        return this;
    }

    @Override
    public void isOnPage() {
        log.info("Verify Product Page");
        waitForVisibilityOfElement(getAddToCart());
    }
}
