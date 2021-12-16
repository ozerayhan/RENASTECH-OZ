package Guru99Gateway.Step_Definition;

import Guru99Gateway.Pages.HomePage;
import Guru99Gateway.Pages.Payment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import java.util.Map;

public class gateWaySteps {


    private static final Logger logger= Logger.getLogger(gateWaySteps.class);
    HomePage homePage=new HomePage();
    Payment payment=new Payment();

    @Given("The user on the home page of the application")
    public void the_user_on_the_home_page_of_the_application() {
        logger.info("===== The User on The home page =====");
    }
    @Given("The user should be able to see the header")
    public void the_user_should_be_able_to_see_the_header() {
        homePage.HeaderIsDisplayed();
        logger.info("===== Header is displayed =====");
    }
    @Then("The header should be as {string}")
    public void the_header_should_be_as(String string) {
        homePage.headerAsExpected(string);
        logger.info("===== Header as expected >>>> "+homePage.getTitle()+" =====");
    }
    @When("The user check the toy price")
    public void the_user_check_the_toy_price() {
        homePage.toyPriceIsDisplayed();
        logger.info("===== Price is displayed =====");
    }
    @Then("The price should be as {string}")
    public void the_price_should_be_as(String string) {
        homePage.toyPriceAsExpected(string);
        logger.info("===== Price as expected =====");
    }

    @When("the user on the application the url should contain {string}")
    public void the_user_on_the_application_the_url_should_contain(String string) {
        homePage.urlTitle(string);
        logger.info("===== Title contains "+string+" =====");
    }
    @When("The user selects {string} toys")
    public void the_user_selects_toys(String num) {
        homePage.selectQuantity(num);
        logger.debug("===== Selected toys are "+num+" =====");
    }
    @Then("The user can click Buy Now")
    public void the_user_can_click_buy_now() {
        homePage.clickBuyNow();
        logger.info("===== Buy Now Process =====");
    }
    @Then("The user will be able to provide sixteen digits card number")
    public void the_User_Will_Be_Able_To_Provide_The_Digits_Card_Number() {
        payment.enterFakerCardNumber();
    }
    @Then("The user will enter the expiration month")
    public void the_user_will_enter_the_expiration_month() {
        payment.enterDropDownExpMonth();
    }
    @Then("The user will enter the expiration year")
    public void the_user_will_enter_the_expiration_year() {
        payment.enterDropDownExpYear();
    }
    @Then("The user will enter the CVV code")
    public void the_user_will_enter_the_cvv_code() {
        payment.enterFakerCVVcode();
    }
    @Then("The user will submit the payment")
    public void the_user_will_submit_the_payment() {
        payment.submitPayment();
        logger.info("===== Order submitted =====");
    }
    @Then("The user will get a confirmation text as {string}")
    public void the_user_will_get_a_confirmation_text_as(String string) {
        Guru99GateWay.Pages.confirmationPage message=new Guru99GateWay.Pages.confirmationPage();
        message.displayedConfirmationText(string);
        logger.info("===== Confirmation message displayed =====");
    }
    @And("The user will be able to provide the payment information as")
    public void the_User_Will_Be_Able_To_Provide_The_PaymentInformationAs(Map<String,String> dataTable){
        payment.enterCardNumber(dataTable.get("CNumber"));
        payment.enterExpirationMonth(dataTable.get("EMonth"));
        payment.enterExpirationYear(dataTable.get("EYear"));
        payment.enterCVVCode(dataTable.get("CVVCode"));
        logger.info(" ===== Order submitted =====");
    }

    @When("The user selects the toy quantity as {string}")
    public void the_user_selects_the_toy_quantity_as(String string) {
        homePage.selectQuantity(string);
        logger.info("===== Toy Quantity Selected =====");
    }


}
