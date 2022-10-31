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
public class SalePage extends AbstractBasePage{

    @FindBy(xpath = "//h1/span[text()='Sale']")
    private WebElement saleHeader;

    @FindBy(xpath = "//span[contains(text(),'Mens')]/../following-sibling::ul//a[text()='Jackets']")
    private WebElement menJacket;


    @FindBy(xpath = "(//ol[contains(@class,'products list items')]/li)[1]//a[@class='product-item-link']")
    private WebElement jacketProductLink;


    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    private WebElement addToCart;

    public SalePage(WebDriver driver) {
        super(driver);
    }

    public SalePage clickMensJacket(){
        waitForVisibilityOfElement(getMenJacket());
        click(getMenJacket());
        Logger.logInfo("click on men's jacket");
        return this;
    }

    public SalePage selectJacket(){
        waitForVisibilityOfElement(getJacketProductLink());
        click(getJacketProductLink());
        Logger.logInfo("select jacket");
        return this;
    }

    public SalePage addToCart(){
        waitForElementToBeClickable(getAddToCart());
        click(getAddToCart());
        Logger.logInfo("add item to cart");
        return this;
    }

    @Override
    public void isOnPage() {
        log.info("Verify Sale Page");
        waitForVisibilityOfElement(saleHeader);
    }
}
