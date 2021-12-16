package Guru99Gateway.Pages;

import Guru99Gateway.Utils.CommonUtils;
import Guru99Gateway.Utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Mother Elephant With Babies Soft Toy')]")
    private WebElement pageHeader;
    @FindBy (xpath = "//h3[contains(text(),'Price: $20')]")
    private WebElement toyPrice;
    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement quantitySelect;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buyNowButton;

    public void HeaderIsDisplayed() {
        Assert.assertTrue(pageHeader.isDisplayed());
    }
    public String getTitle(){return pageHeader.getText();}
    public void headerAsExpected(String string) {
        Assert.assertEquals(pageHeader.getText(),string);
    }

    public void toyPriceIsDisplayed(){
        Assert.assertTrue(toyPrice.isDisplayed());
    }
    public void toyPriceAsExpected(String string){Assert.assertTrue((toyPrice.getText()).contains("20"));}

    public void urlTitle(String string){
        Assert.assertTrue((Driver.getDriver().getCurrentUrl()).contains(string) );
    }
    public void selectQuantity(String num){CommonUtils.selectFromDropDown(quantitySelect,num);}
    public void clickBuyNow(){
        CommonUtils.clickWithWait(buyNowButton);
    }
}
