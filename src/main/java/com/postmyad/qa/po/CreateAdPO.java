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

import com.postmyad.qa.base.PostMyAdBase;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class CreateAdPO extends PostMyAdBase {

    @FindBy(xpath="//*[text()='Rent / Lease']") WebElement rentleaselink;
    @FindBy(xpath="//*[text()='Residential']/parent::div")WebElement reseidentiallink;
    @FindBy(xpath="//*[text()='Continue']")WebElement continuebutton;
    @FindBy(xpath="//*[text()='Apartment']")WebElement apartmentlink;
    @FindBy(xpath="//input[@id='city']")WebElement citytextbox;
    //@FindBy(xpath="")WebElement reseidentiallink;




    public CreateAdPO(){
        PageFactory.initElements(driver,this);

    }

    public void selectRentOption(){
        clickOnElement(driver,20,rentleaselink,"mrent option not there");
    }
    public void selectResidentialButton(){
        clickOnElement(driver,20,rentleaselink,"menu not displayed");
    }
    public void clickApartment(){
        clickOnElement(driver,20,apartmentlink,"menu not displayed");
    }
    public void clickContinueButton(){
        clickOnElement(driver,20,continuebutton,"menu not displayed");
    }

    public void enterCity(){
        sendKeysInTextBox(driver,20,citytextbox,"kota");
    }

    public void createResidentialApartmentAd(){
       selectRentOption();
       selectResidentialButton();
       clickApartment();
       clickContinueButton();
       enterCity();
    }


}
