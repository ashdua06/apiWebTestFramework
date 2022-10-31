package systemTesting.buyItem;

import baseSetup.TestBase;
import com.sample.apiRequestBuilder.userGenerator.RandomUserGenerator;
import com.sample.pages.*;
import com.sample.validators.userGenerator.RandomUserGeneratorValidator;
import org.testng.annotations.Test;

import static com.sample.constants.ABGConstants.QA_URL;

public class PurchaseItemTest extends TestBase {

    static RandomUserGenerator randomUserGenerator;


    @Test( priority = 0)
    public void createRandomUserTest() {
        randomUserGenerator=new RandomUserGenerator();
        randomUserGenerator.createRequestJsonAndExecute();
        RandomUserGeneratorValidator.getInstance().validateRandomUserGenerator(randomUserGenerator);
    }

    @Test( priority = 1)
    public void registerUserTest() {
        launchUrl(QA_URL);
        new Homepage(getDriver()).clickCreateAccount();
        CreateAccountPage createAccountPage=new CreateAccountPage(getDriver());
        createAccountPage.createAccount(randomUserGenerator);
        MyAccountPage myAccountPage=new MyAccountPage(getDriver());
        boolean accountCreationFlag= myAccountPage.verifyAccountCreationSuccessful();
        createAccountPage.retryAccountCreationIfFailed(randomUserGenerator,accountCreationFlag);
    }

    @Test( priority = 2)
    public void purchaseItemTest() {
        new MyAccountPage(getDriver()).clickSale();
        new SalePage(getDriver()).clickMensJacket().selectJacket().addToCart();
        new ProductPage(getDriver()).selectXsSize().selectColor().addToCart().itemAddedToCartMessage().goToShoppingCart();
        new ShoppingCartPage(getDriver()).proceedToCheckout();
        new ShippingAddressPage(getDriver()).enterShippingAddressLine1(randomUserGenerator)
                .enterShippingAddressLine2(randomUserGenerator).enterCity(randomUserGenerator)
                .selectState(randomUserGenerator).enterPincode(randomUserGenerator)
                .selectCountry(randomUserGenerator).enterPhoneNumber(randomUserGenerator)
                .selectFlatRateShippingMethod().clickNext();
        new PaymentPage(getDriver()).placeOrder().validatePaymentStatus();
    }





}
