import org.testng.Assert;

import static baseDir.SettingsReader.getTetData;
import static forms.CatalogSearchPage.productDto;

public class MagentoTestSteps {


    public void assertVerifyProjectPageIsOpen() {
        Assert.assertTrue(BaseTest.mainPage.isFormOpen(),"main page is not open!");
    }

    public void clickCreateAccountButton() {
        BaseTest.mainPage.clickCreateAnAccount();
    }
    public void clickSignInButton(){
        BaseTest.mainPage.clickSignInButton();
    }
    public void assertVerifyLoginPageIsOpen(){
        Assert.assertTrue(BaseTest.loginPage.isFormOpen(),"Login Page is not open!");
    }
    public void fillLoginFieldsAndClickSignInButton(String email,String password){
        BaseTest.loginPage.fillEmailField(email);
        BaseTest.loginPage.fillPasswordField(password);
        BaseTest.loginPage.clickSignInButton();
    }
    public void verifyThatAuthorizationWasSuccesfull(String firstName,String lastname){
        Assert.assertTrue(BaseTest.mainPage.isFormOpen(),"main page is not open after signing in!");
        Assert.assertTrue(BaseTest.mainPage.checkIfAuthorizationWasSuccesfull(firstName,lastname),"there was issue with authorization");
    }
    public void verifyThatAuthorizationWasNotSuccesfull(){
        Assert.assertFalse(BaseTest.mainPage.isFormOpen(), "main page was open after signing in");
    }

    public void assertVerifyRegistrationPageIsOpen() {
        Assert.assertTrue(BaseTest.registrationPage.isFormOpen(),"registration page is not open!");
    }

    public void fillRegistrationFieldsAndClickCreateAccButton(String firstname, String lastname, String emails, String passwords) {
        BaseTest.registrationPage.fillFirstName(firstname);
        BaseTest.registrationPage.fillLastName(lastname);
        BaseTest.registrationPage.fillEmail(emails);
        BaseTest.registrationPage.fillPasswordAndConfiramtionOfPassword(passwords);
        BaseTest.registrationPage.clickCreateAnAccountBtn();

    }
    public void assertVerifyAccountPageIsOpen() {
        Assert.assertTrue(BaseTest.accountPage.isFormOpen(),"account page is not open!");
    }
    public void fillSearchFieldAndClickToSearch(String search){
        BaseTest.accountPage.fillSearchField(search);
        BaseTest.accountPage.clickSearchButton();
    }

    public void assertVerifyCatalogSearchPageIsOpen(){
        Assert.assertTrue(BaseTest.catalogSearchPage.isFormOpen(),"catalog Page is not open!");
    }

    public void assertVerifySearchTextIsCorrect(){
        Assert.assertEquals(BaseTest.catalogSearchPage.getSearchResultText(),"Search results for: '"+getTetData("search.value")+"'");
    }
    public void chooseSortingOption(){
        BaseTest.catalogSearchPage.clickDropDownSort();
        BaseTest.catalogSearchPage.chooseSortOption();
    }
    public void chooseRandomProduct(){
        BaseTest.catalogSearchPage.clickToRandProduct();
    }
    public void assertVerifyProductPageIsOpenedCorrectly(){
        Assert.assertEquals(BaseTest.productPage.getProductName(),productDto.getProductName(),"Product page was opened incorrectly");
    }
    public void fillProductOptions(){
        BaseTest.productPage.chooseSize();
        BaseTest.productPage.chooseColor();
        BaseTest.productPage.fillQtyField();
    }
    public void clickingAddToCartButton(){
        BaseTest.productPage.clickAddToCartButton();
    }
    public void checkIfProductWasAddedToCart(){
        Assert.assertTrue(BaseTest.productPage.getSuccesLabelText().contains("You added"),"product was not added to cart! ");
    }
    public void clickingCartButton(){
        BaseTest.productPage.clickCartButton();
    }
    public void clickingCheckoutButton(){
        BaseTest.productPage.clickCheckOutButton();
    }
    public void assertVerifyCheckoutPageIsOpen(){
        Assert.assertTrue(BaseTest.checkoutPage.isFormOpen(),"Checkout Page is not open");
    }
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

    public void assertVerifyPaymentPageIsOpen(){
        Assert.assertTrue(BaseTest.paymentPage.isFormOpen(),"paymentPage Page is not open!");
    }

    public void clickingPlaceOrderButton(){
        BaseTest.paymentPage.clickPlaceOrderButton();
    }
    public void assertVerifySuccessPageIsOpen(){
        Assert.assertTrue(BaseTest.successPage.isFormOpen(),"successPage Page is not open!");
    }
}
