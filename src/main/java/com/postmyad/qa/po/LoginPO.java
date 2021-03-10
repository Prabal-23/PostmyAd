package com.postmyad.qa.po;

import com.postmyad.qa.base.PostMyAdBase;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginPO extends PostMyAdBase {

    @FindBy(xpath = "//*[@class='iconS ham-Icon']")
    WebElement navigationbar;

    @FindBy(xpath="//*[contains(text(),'Login / Register')]")
    WebElement loginlink;

    @FindBy(name="username")
    WebElement usernametextbox;


    @FindBy(xpath="//a[text()='Continue']")
    WebElement continuebutton;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//*[@id='loginSubmit']")
    WebElement loginbutton;

    @FindBy(xpath = "//a[contains(text(),'Post Property for Free')]")WebElement postpropertyforfreebutton;

    @FindBy(xpath = "//a[contains(text(),'CUSTOMER SERVICE')]")WebElement customerservicelink;

    @FindBy(id = "homeLoan")WebElement homeloanslink;

    @FindBy(id = "quickLnk-lbl")WebElement quicklinks;

    @FindBy(xpath="//div[@class='component__icon_cross component__top_25']") WebElement closeicon;

    @FindBy(xpath="//i[@class='component__icon component__DIFIcon component__hideGuide']") WebElement closeicon1;

    @FindBy(xpath="//button[text()='Got it']") WebElement gotit;

    @FindBy(xpath="//*[@id='HmMenuTTPID']//a") WebElement menuicon ;

    @FindBy(xpath = "//*[@id=\"SidePaneComponent\"]/div[2]/a") WebElement postad;

    @FindBy(xpath="//*[text()='Do not show again']") WebElement donotshow;

    By e = By.xpath("//*[@id=\"SidePaneComponent\"]/div[2]/a");



    public LoginPO(){
        PageFactory.initElements(driver,this);

    }



    public void thodaWait()
    {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
public void Login (){
        clickOnElement(driver,10,navigationbar,"Element not visible");
        clickOnElement(driver,10,loginlink,"");
        sendKeysInTextBox(driver,20,usernametextbox,prop.getProperty("username"));
        clickOnElement(driver,20,continuebutton,"Button not visible");
    sendKeysInTextBox(driver,20,password,prop.getProperty("password"));
    clickOnElement(driver,20,loginbutton,"Button ot visible");
    System.out.println("Login Successful");


}



public  void validTopLinks(){

        Assert.assertEquals(postpropertyforfreebutton.getText(),"Post Property for Free","Link not present");
        Assert.assertEquals(customerservicelink.getText(),"CUSTOMER SERVICE","Link not present");
        Assert.assertEquals(homeloanslink.getText(),"HOME LOANS","Link not present");
        Assert.assertEquals(quicklinks.getText(),"Quick Links");
        System.out.println("Top Navigation Ok");
    }

    public void verifyQuickLinksOverlay(){
        Assert.assertFalse(driver.findElement(By.id("sBluDrpWrap")).isDisplayed());
        System.out.println("Quick Links Overlay is collapsed");
        clickOnElement(driver,10,quicklinks,"Quick Link not displayed");
        thodaWait();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Hot Projects')]")).isDisplayed(),"Overlay not expanded");

        System.out.println("Quick Links Overlay is expanded");
        String s=driver.findElement(By.id("sBluDrpWrap")).getAttribute("style");
        s.contains("visible");
        System.out.println(s);


    }



    public void findPuneProject(){
        List<WebElement> citylist = driver.findElements(By.xpath("//tr[@class='clr']/th/a"));
        for(int i=0;i<citylist.size();i++) {
        System.out.println(citylist.get(i).getText());

        if(citylist.get(i).getText().equals("KOLKATA"))

        {
            driver.findElement(By.xpath("//tr[@class='clr']//descendant::a[contains(text(),'View All')]")).click();

    }

    }


}



public void clickAllCloseIconAfterLogin() {
clickOnElement(driver,20,closeicon,"adda");
    //clickOnElement(driver,20,closeicon1,"adda");

}

public void clickPostMyAd(){
        clickOnElement(driver,20,menuicon,"menu not displayed");
        clickOnElement(driver,20,postad,"post ad button broken");

        //closeMaxListingPop();
    }

    public void closeMaxListingPop (){

        WebElement element=driver.findElement(By.xpath("//button[text()='Got it']"));
      if (element.equals(null)) {

          System.out.println("max listings not reached");
      }

      else{
          clickOnElement(driver,20,gotit,"button not present");

      }
    }



    }
