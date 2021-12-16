package Guru99Gateway.Pages;

import Guru99Gateway.Utils.CommonUtils;
import Guru99Gateway.Utils.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {



    public Payment(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='card_nmuber']")
    private WebElement cardNumber;
    @FindBy(xpath="//select[@name='month']")
    private WebElement cardExpMonth;
    @FindBy(xpath = "//select[@name='year']")
    private WebElement cardExpYear;
    @FindBy(xpath = "//input[@name='cvv_code']")
    private WebElement cardCVV;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement payButton;

    Faker faker=new Faker();

    public void enterCardNumber(String num){
        Assert.assertTrue(num.length()==16);
        CommonUtils.enterText(cardNumber,num);
    }
    public void enterExpirationMonth(String month){
        CommonUtils.enterText(cardExpMonth,month);
    }
    public void enterExpirationYear(String year){
        CommonUtils.enterText(cardExpYear,year);
    }
    public void enterCVVCode(String code){
        CommonUtils.enterText(cardCVV,code);
    }
    public void enterFakerCardNumber(){
        cardNumber.sendKeys(faker.business().creditCardNumber().replaceAll("-",""));
        CommonUtils.hardWait(1000);
    }
    public void enterDropDownExpMonth(){
        CommonUtils.selectFromDropDown(cardExpMonth,CommonUtils.randomMonth());
        CommonUtils.hardWait(1000);
    }
    public void enterDropDownExpYear(){
        CommonUtils.selectFromDropDown(cardExpYear,CommonUtils.randomMonth());
        CommonUtils.hardWait(2000);
    }
    public void enterFakerCVVcode(){
        String CVV=CommonUtils.randomCVV()+"";
        CommonUtils.enterText(cardCVV,CVV);
    }
    public void submitPayment(){
        CommonUtils.clickWithWait(payButton);
    }


}
