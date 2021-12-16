package Guru99GateWay.Pages;

import Guru99Gateway.Utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmationPage {
    public confirmationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="//h2[contains(text(),'Payment successfull!')]")
    private WebElement confirmationText;

    public void displayedConfirmationText(String message){
        Assert.assertTrue(confirmationText.getText().equals(message));
    }

}
