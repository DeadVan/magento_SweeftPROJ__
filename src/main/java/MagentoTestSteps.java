import io.qameta.allure.Step;
import org.testng.Assert;

import static baseDir.SettingsReader.getTetData;
import static forms.CatalogSearchPage.productDto;

public class MagentoTestSteps {

    @Step("verifying that Project page is open")
    public void assertVerifyProjectPageIsOpen() {
        Assert.assertTrue(BaseTest.mainPage.isFormOpen(),"main page is not open!");
    }

    @Step("clicking to create account button")
    public void clickCreateAccountButton() {
        BaseTest.mainPage.clickCreateAnAccount();
    }

    @Step("clicking to sign in button")
    public void clickSignInButton(){
        BaseTest.mainPage.clickSignInButton();
    }
    @Step("verifying that login page is open")
    public void assertVerifyLoginPageIsOpen(){
        Assert.assertTrue(BaseTest.loginPage.isFormOpen(),"Login Page is not open!");
    }
    @Step("filling login fields email = {0},password = {1}")
    public void fillLoginFieldsAndClickSignInButton(String email,String password){
        BaseTest.loginPage.fillEmailField(email);
        BaseTest.loginPage.fillPasswordField(password);
        BaseTest.loginPage.clickSignInButton();
    }
    @Step("verifying that authorization was successful")
    public void verifyThatAuthorizationWasSuccesfull(String firstName,String lastname){
        Assert.assertTrue(BaseTest.mainPage.isFormOpen(),"main page is not open after signing in!");
        Assert.assertTrue(BaseTest.mainPage.checkIfAuthorizationWasSuccesfull(firstName,lastname),"there was issue with authorization");
    }
    @Step("verifying that authorization was not successful")
    public void verifyThatAuthorizationWasNotSuccesfull(){
        Assert.assertFalse(BaseTest.mainPage.isFormOpen(), "main page was open after signing in");
    }
    @Step("verifying that registration page is open")
    public void assertVerifyRegistrationPageIsOpen() {
        Assert.assertTrue(BaseTest.registrationPage.isFormOpen(),"registration page is not open!");
    }
    @Step("filling registration fields and clicking to create acc button")
    public void fillRegistrationFieldsAndClickCreateAccButton(String firstname, String lastname, String emails, String passwords) {
        BaseTest.registrationPage.fillFirstName(firstname);
        BaseTest.registrationPage.fillLastName(lastname);
        BaseTest.registrationPage.fillEmail(emails);
        BaseTest.registrationPage.fillPasswordAndConfiramtionOfPassword(passwords);
        BaseTest.registrationPage.clickCreateAnAccountBtn();

    }
    @Step("verifying that account page is open")
    public void assertVerifyAccountPageIsOpen() {
        Assert.assertTrue(BaseTest.accountPage.isFormOpen(),"account page is not open!");
    }
    @Step("filling search field and clicking to search")
    public void fillSearchFieldAndClickToSearch(String search){
        BaseTest.accountPage.fillSearchField(search);
        BaseTest.accountPage.clickSearchButton();
    }
    @Step("verifying that catalog search is open")
    public void assertVerifyCatalogSearchPageIsOpen(){
        Assert.assertTrue(BaseTest.catalogSearchPage.isFormOpen(),"catalog Page is not open!");
    }
    @Step("verifying that search was correct")
    public void assertVerifySearchTextIsCorrect(){
        Assert.assertEquals(BaseTest.catalogSearchPage.getSearchResultText(),"Search results for: '"+getTetData("search.value")+"'");
    }

    @Step("choosing sorting options")
    public void chooseSortingOption(){
        BaseTest.catalogSearchPage.clickDropDownSort();
        BaseTest.catalogSearchPage.chooseSortOption();
    }
    @Step("choosing random product")
    public void chooseRandomProduct(){
        BaseTest.catalogSearchPage.clickToRandProduct();
    }

    @Step("verifying that product page is opened correctly")
    public void assertVerifyProductPageIsOpenedCorrectly(){
        Assert.assertEquals(BaseTest.productPage.getProductName(),productDto.getProductName(),"Product page was opened incorrectly");
    }
    @Step("filling product options")
    public void fillProductOptions(){
        BaseTest.productPage.chooseSize();
        BaseTest.productPage.chooseColor();
        BaseTest.productPage.fillQtyField();
    }

    @Step("clicking add to cart button")
    public void clickingAddToCartButton(){
        BaseTest.productPage.clickAddToCartButton();
    }

    @Step("checking if product was added to cart")
    public void checkIfProductWasAddedToCart(){
        Assert.assertTrue(BaseTest.productPage.getSuccesLabelText().contains("You added"),"product was not added to cart! ");
    }
    @Step("clicking cart button")
    public void clickingCartButton(){
        BaseTest.productPage.clickCartButton();
    }
    @Step("clicking checkout button")
    public void clickingCheckoutButton(){
        BaseTest.productPage.clickCheckOutButton();
    }

    @Step("verifying that checkout page is open")
    public void assertVerifyCheckoutPageIsOpen(){
        Assert.assertTrue(BaseTest.checkoutPage.isFormOpen(),"Checkout Page is not open");
    }
    @Step("fulling shipping information and clicking to next button")
    public void fillShippingInformationAndClickNext(String address, String city, String postal, String phoneNumb){
        BaseTest.checkoutPage.fillStreetAddressField(address);
        BaseTest.checkoutPage.fillCityField(city);
        BaseTest.checkoutPage.fillPostalCodeField(postal);
        BaseTest.checkoutPage.chooseState();
        BaseTest.checkoutPage.chooseCountry();
        BaseTest.checkoutPage.fillPhoneNumber(phoneNumb);
        BaseTest.checkoutPage.checkCheckBox();
        BaseTest.checkoutPage.clickNextButton();
    }
    @Step("verifying that payment page is open")
    public void assertVerifyPaymentPageIsOpen(){
        Assert.assertTrue(BaseTest.paymentPage.isFormOpen(),"paymentPage Page is not open!");
    }
    @Step("clicking to place ordet button")
    public void clickingPlaceOrderButton(){
        BaseTest.paymentPage.clickPlaceOrderButton();
    }

    @Step("verifying that succes page is open")
    public void assertVerifySuccessPageIsOpen(){
        Assert.assertTrue(BaseTest.successPage.isFormOpen(),"successPage Page is not open!");
    }
}
