package postmyadqatest;

import com.postmyad.qa.base.PostMyAdBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Myntra extends PostMyAdBase {
    public static void main(String[] args) {
        Myntra m = new Myntra();
        m.start();
        m.initialization();
        WebElement e =driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
        m.clickOnElement(driver,10,e,"");
        WebElement w = driver.findElement(By.xpath("//a[contains(text(),'login / Signup')]"));
        m.clickOnElement(driver,20,w,"");
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement w1 =driver.findElement(By.xpath("//*[@class='form-control mobileNumberInput']"));
        w1.sendKeys("415167");

        


    }

}

