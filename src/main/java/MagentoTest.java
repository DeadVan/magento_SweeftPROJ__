import baseDir.utils.RandomUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static baseDir.SettingsReader.*;

public class MagentoTest extends BaseTest {

    private final MagentoTestSteps magentoTestSteps = new MagentoTestSteps();
    @Severity(SeverityLevel.CRITICAL)
    @Description("Registration and buying product Test")
    @Test(dataProvider = "registrationData", dataProviderClass = RandomUtils.class)
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
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login test with correct credentials")
    @Test()
    public void MagentoAuthorizationTest(){
        magentoTestSteps.assertVerifyProjectPageIsOpen();
        magentoTestSteps.clickSignInButton();
        magentoTestSteps.assertVerifyLoginPageIsOpen();
        magentoTestSteps.fillLoginFieldsAndClickSignInButton(getTetData("email"), getTetData("password"));
        magentoTestSteps.verifyThatAuthorizationWasSuccesfull(getTetData("first.name"),getTetData("last.name"));
    }
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login test with wrong credentials")
    @Test()
    public void MagentoWrongAuthorizationTest(){
        magentoTestSteps.assertVerifyProjectPageIsOpen();
        magentoTestSteps.clickSignInButton();
        magentoTestSteps.assertVerifyLoginPageIsOpen();
        magentoTestSteps.fillLoginFieldsAndClickSignInButton(getTetData("wrong.email"), getTetData("wrong.password"));
        magentoTestSteps.verifyThatAuthorizationWasNotSuccesfull();
    }
}
