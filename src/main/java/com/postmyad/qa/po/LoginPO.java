package com.postmyad.qa.po;

import com.postmyad.qa.base.PostMyAdBase;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

    @FindBy(xpath = "//div[@id='R']") WebElement renttab;

    @FindBy(xpath = "//span[text()='Apartment']") WebElement residentialradio;

    @FindBy(xpath = "//span[text()='Continue']") WebElement continue2;

    @FindBy(xpath = "//input[@id='city']")  WebElement citytextbox;

    @FindBy(xpath = "//*[@id='citySuggestor']/div[7]")WebElement kotavalue;

    @FindBy(xpath = "//div/input[@id='project']")WebElement apartmenttextbox;

    @FindBy(xpath = "//div[@id='projectSuggestor']/div[3]")WebElement apartmentvalue;

    @FindBy(xpath = "//input[@id='address-input']")WebElement housenumbertextbox;

    @FindBy(xpath = "//*[contains(text(),'Continue')]")WebElement continuebutton3;

    @FindBy(xpath = "//div[@id='carpet-input']//input")WebElement carpetareatextbox;

    @FindBy(xpath = "//div[@id='bedroomNum']/div[2]")WebElement numberofbedroom;

    @FindBy(xpath = "//*[@id='bathroomNum-input']//div[2]")WebElement numberofbathroom;

    @FindBy(xpath = "//div[@id='balconyNum']/div[3]")WebElement numberofbalconies;

    @FindBy(xpath = "//span[contains(text(),'Semi-furnished')]")WebElement semifurnishedtab;
    @FindBy(xpath = "(//div[@id='furnishing_Ward-input']//i)[2]")WebElement wardrobeicon;
    @FindBy(xpath = "//div[@class='furnishingCustom_inline_list_wrap__3h2HE']/div[@id='furnishing_Wtrpurfr-input']")WebElement waterpurifiercheckbox;
  //  @FindBy(xpath = "//label[@for='furnishing_Wtrpurfr']")WebElement n;
    @FindBy(xpath = "//label[@for='furnishing_Kit']")WebElement modularkitchen;
    @FindBy(xpath = "(//div[@id='coveredParking-input']//i)[2]")WebElement coveredparking;
    @FindBy(xpath = "//div[@id='totalFloor-input']//input") WebElement totalfloor;
    @FindBy(xpath = "//div[@id='floorNum-input']//span[text()='7']") WebElement flatfloornumber;
    @FindBy(xpath = "//div[@id='age-input']//span[contains(text(),'1-5 years')]") WebElement propertyage;
    @FindBy(xpath = "//div[@id='availabilityDate-input']") WebElement datepicker;
    @FindBy(xpath = "//span[@class='flatpickr-day today']") WebElement today;
    @FindBy(xpath = "//div[@id='availableFor-input']//i") WebElement availablefor;
    @FindBy(xpath = "//span[contains(text(),'Continue')]")WebElement continue4;
    @FindBy(xpath = "//*[@id='photo-upload']")WebElement upload;
    @FindBy(xpath = "//*[contains(text(),'Review & Edit')]") WebElement reviewandeditbutton;
    @FindBy(xpath = "//span[contains(text(),'Click to add more pics')]") WebElement addmoreimages;





    By e = By.xpath("//*[@id=\"SidePaneComponent\"]/div[2]/a");



    public LoginPO() {
        PageFactory.initElements(driver, this);


    }






    public void thodaWait()
    {
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
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

    public void createAd() throws InterruptedException {

        clickOnElement(driver,20,renttab,"");
        clickOnElement(driver,20,residentialradio,"");
        clickOnElement(driver,20,continue2,"");
       sendKeysInTextBox(driver,20,citytextbox,"kot");
       clickOnElement(driver,20,kotavalue,"");
        sendKeysInTextBox(driver,20,apartmenttextbox,"Mahala");
        clickOnElement(driver,20,apartmentvalue,"");
        sendKeysInTextBox(driver,20,housenumbertextbox,"E6-703");
        clickOnElement(driver,20,continuebutton3,"");
        clickOnElement(driver,20,numberofbedroom,"");
        clickOnElement(driver,20,numberofbathroom,"");
        clickOnElement(driver,20,numberofbalconies,"");

        sendKeysInTextBox(driver,20,carpetareatextbox,"1080");
        clickOnElement(driver,20,semifurnishedtab,"");
        clickOnElement(driver,20,wardrobeicon,"");
        scroll();
       Thread.sleep(1000);
      // clickSafelyJS(waterpurifiercheckbox);

      clickOnElement(driver,220,waterpurifiercheckbox,"");
        clickOnElement(driver,20,modularkitchen,"");
        clickOnElement(driver,20,coveredparking,"");
        sendKeysInTextBox(driver,20,totalfloor,"7");
        clickSafelyJS(flatfloornumber);
       // clickOnElement(driver,120,flatfloornumber,"");
        clickOnElement(driver,120,propertyage,"");
        clickOnElement(driver,220,datepicker,"");
        clickOnElement(driver,220,today,"");
        clickOnElement(driver,220,availablefor,"");
        clickOnElement(driver,20,continue4,"");



    }
public void uploadImage() {

    driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Lucky\\Desktop\\Home\\lucky1.jpg");
    clickOnElement(driver,20,reviewandeditbutton,"");
    for (int i = 2; i < 8; i++) {
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Lucky\\Desktop\\Home\\lucky"+i+".jpg");


    }
}


    }
