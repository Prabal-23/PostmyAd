package postmyadqatest;

import com.postmyad.qa.base.PostMyAdBase;
import com.postmyad.qa.po.LoginPO;
import org.testng.annotations.Test;

public class LoginTest extends PostMyAdBase {

    @Test
    public void login () throws InterruptedException {

        LoginTest login = new LoginTest();

        login.start();
        login.initialization();
        LoginPO l1 = new LoginPO();
        l1.validTopLinks();

        l1.verifyQuickLinksOverlay();
       // l1.findPuneProject();
        l1.Login();

        l1.clickAllCloseIconAfterLogin();
        l1.clickPostMyAd();
        l1.createAd();
        l1.uploadImage();
    //    l1.closeMaxListingPop();

      //  driver.quit();










    }
}
