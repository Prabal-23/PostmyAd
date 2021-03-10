package com.postmyad.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PostMyAdBase {

    public static WebDriver driver;
    public static Properties prop;

    public void start()  {
        prop= new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("C:\\Users\\Lucky\\IdeaProjects\\PostmyAd\\src\\main\\java\\com\\postmyad\\qa\\config\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization(){

        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)   ;

        driver.get(prop.getProperty("url"));



    }

    public WebElement getElementSmartly (By locator){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return driver.findElement(locator);
    }




        public WebElement getElementSmartly (WebDriver driver,int timeout,WebElement locator, String message){
            return new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(locator));


    }

    public void clickOnElement(WebDriver driver,int timeout,WebElement locator, String message){

        WebDriverWait wait= new WebDriverWait(driver,timeout);
                wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(locator))
                    .click();

    }

    public void sendKeysInTextBox(WebDriver driver,int timeout,WebElement locator, String value){

        WebDriverWait wait= new WebDriverWait(driver,timeout);
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator))
                .sendKeys(value);
    }

    public  String getCSSValueofElement(WebDriver driver,int timeout, WebElement locator,String attribute){

         String actualvalue= new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(locator)).getCssValue(attribute);
         String actualcolorhex = Color.fromString(actualvalue).asHex();

         return actualcolorhex;

    }

    public void validateColorOfAnElement (WebDriver driver,int timeout, WebElement locator,String attribute,String expectedcolor){

        String actualcolor = getCSSValueofElement( driver, timeout, locator,attribute);
        Assert.assertEquals(actualcolor,expectedcolor,  "color isnt as expected");

    }








}
