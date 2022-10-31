package com.sample.pages;
import com.sample.apiRequestBuilder.userGenerator.RandomUserGenerator;
import com.sample.constants.ABGConstants;
import com.sample.reporting.assertions.CustomAssert;
import com.sample.reporting.extentReports.Logger;
import com.sample.utils.CommonUtils;
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
public class CreateAccountPage extends AbstractBasePage{
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstName;


    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastname;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement passwordConfirmation;

    @FindBy(xpath = "//button[contains(@class,'submit ')]")
    private WebElement createAccountBtn;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage enterFirstName(String firstName){
        waitForVisibilityOfElement(getFirstName());
        typeText(getFirstName(),firstName);
        Logger.logInfo("enter first name");
        return this;
    }

    public CreateAccountPage enterLastName(String lastName){
        waitForVisibilityOfElement(getLastname());
        typeText(getLastname(),lastName);
        Logger.logInfo("enter last name");
        return this;
    }

    public CreateAccountPage enterEmail(String emailAddress){
        waitForVisibilityOfElement(getEmail());
        typeText(getEmail(),emailAddress);
        Logger.logInfo("enter email");
        return this;
    }

    public CreateAccountPage enterPassword(String password){
        waitForVisibilityOfElement(getPassword());
        typeText(getPassword(),password);
        Logger.logInfo("enter password");
        return this;
    }

    public CreateAccountPage enterConfirmationPassword(String confirmPassword){
        waitForVisibilityOfElement(getPasswordConfirmation());
        typeText(getPasswordConfirmation(),confirmPassword);
        Logger.logInfo("reenter password");
        return this;
    }

    public CreateAccountPage clickCreateAccountBtn(){
        waitForElementToBeClickable(getCreateAccountBtn());
        click(getCreateAccountBtn());
        Logger.logInfo("click on create account button");
        return this;
    }

    public void createAccount(RandomUserGenerator randomUserGenerator){
        enterFirstName(randomUserGenerator.getResponsePojo().getResults().get(0).getName().getFirst());
        enterLastName(randomUserGenerator.getResponsePojo().getResults().get(0).getName().getLast());
        enterEmail(randomUserGenerator.getResponsePojo().getResults().get(0).getEmail());
        enterPassword(randomUserGenerator.getResponsePojo().getResults().get(0).getLogin().getSalt()+ ABGConstants.passwordSuffix);
        enterConfirmationPassword(randomUserGenerator.getResponsePojo().getResults().get(0).getLogin().getSalt()+ ABGConstants.passwordSuffix);
        clickCreateAccountBtn();
    }

    public void retryAccountCreationIfFailed(RandomUserGenerator randomUserGenerator,boolean accountCreationFlag){

        if(!accountCreationFlag){
            Logger.logInfo("Retry account creation");
            String randomDigit=CommonUtils.getRandomNumber(10,20);
            enterFirstName(randomUserGenerator.getResponsePojo().getResults().get(0).getName().getFirst());
            enterLastName(randomUserGenerator.getResponsePojo().getResults().get(0).getName().getLast());
            String[] newEmailArr=randomUserGenerator.getResponsePojo().getResults().get(0).getEmail().split("@");
            String newEmail=newEmailArr[0]+randomDigit+"@"+newEmailArr[1];
            enterEmail(newEmail);
            enterPassword(randomUserGenerator.getResponsePojo().getResults().get(0).getLogin().getSalt()+ABGConstants.passwordSuffix);
            enterConfirmationPassword(randomUserGenerator.getResponsePojo().getResults().get(0).getLogin().getSalt()+ ABGConstants.passwordSuffix);
            clickCreateAccountBtn();
        }
        else{
            CustomAssert.assertTrue(true,"Account created successfully");
        }

    }


    @Override
    public void isOnPage() {
        log.info("Verify Create Account Page");
        waitForVisibilityOfElement(firstName);
    }
}
