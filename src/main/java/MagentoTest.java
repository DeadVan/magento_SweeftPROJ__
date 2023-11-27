import baseDir.utils.RandomUtils;
import org.testng.annotations.Test;

import static baseDir.SettingsReader.*;

public class MagentoTest extends BaseTest {

    private final MagentoTestSteps magentoTestSteps = new MagentoTestSteps();

    @Test(testName = "Registration and buying product",dataProvider = "registrationData", dataProviderClass = RandomUtils.class)
    public void MagentoWebAppTest(String firstName, String lastName, String email, String password) {
        magentoTestSteps.assertVerifyProjectPageIsOpen();
        magentoTestSteps.clickCreateAccountButton();
        magentoTestSteps.assertVerifyRegistrationPageIsOpen();
        magentoTestSteps.fillRegistrationFieldsAndClickCreateAccButton(firstName, lastName, email, password);
        magentoTestSteps.assertVerifyAccountPageIsOpen();
        magentoTestSteps.fillSearchFieldAndClickToSearch(getTetData("search.value"));
        magentoTestSteps.assertVerifyCatalogSearchPageIsOpen();
        magentoTestSteps.assertVerifySearchTextIsCorrect();
        magentoTestSteps.chooseSortingOption();
        magentoTestSteps.chooseRandomProduct();
        magentoTestSteps.assertVerifyProductPageIsOpenedCorrectly();
        magentoTestSteps.fillProductOptions();
        magentoTestSteps.clickingAddToCartButton();
        magentoTestSteps.checkIfProductWasAddedToCart();
        magentoTestSteps.clickingCartButton();
        magentoTestSteps.clickingCheckoutButton();
        magentoTestSteps.assertVerifyCheckoutPageIsOpen();
        magentoTestSteps.fillShippingInformationAndClickNext(getTetData("address"),getTetData("city"),getTetData("postal"),getTetData("phone.number"));
        magentoTestSteps.assertVerifyPaymentPageIsOpen();
        magentoTestSteps.clickingPlaceOrderButton();
        magentoTestSteps.assertVerifySuccessPageIsOpen();
    }
    @Test(testName = "Authorization with correct credentials")
    public void MagentoAuthorizationTest(){
        magentoTestSteps.assertVerifyProjectPageIsOpen();
        magentoTestSteps.clickSignInButton();
        magentoTestSteps.assertVerifyLoginPageIsOpen();
        magentoTestSteps.fillLoginFieldsAndClickSignInButton(getTetData("email"), getTetData("password"));
        magentoTestSteps.verifyThatAuthorizationWasSuccesfull(getTetData("first.name"),getTetData("last.name"));
    }

    @Test(testName = "Authorization with wrong credentials")
    public void MagentoWrongAuthorizationTest(){
        magentoTestSteps.assertVerifyProjectPageIsOpen();
        magentoTestSteps.clickSignInButton();
        magentoTestSteps.assertVerifyLoginPageIsOpen();
        magentoTestSteps.fillLoginFieldsAndClickSignInButton(getTetData("wrong.email"), getTetData("wrong.password"));
        magentoTestSteps.verifyThatAuthorizationWasNotSuccesfull();
    }
}
