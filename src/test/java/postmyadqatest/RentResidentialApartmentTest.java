package postmyadqatest;

import com.postmyad.qa.base.PostMyAdBase;
import com.postmyad.qa.po.CreateAdPO;
import com.postmyad.qa.po.LoginPO;
import org.testng.annotations.Test;

public class RentResidentialApartmentTest extends PostMyAdBase {

    //postmyadqatest.LoginTest l1=new postmyadqatest.LoginTest();

    @Test
    public void setCreatead(){
        LoginPO l1 = new LoginPO();
        RentResidentialApartmentTest rent=new RentResidentialApartmentTest();
        CreateAdPO createad=new CreateAdPO();


        rent.start();
        rent.initialization();

        l1.validTopLinks();
        l1.verifyQuickLinksOverlay();
        // l1.findPuneProject();
        l1.Login();
        l1.clickAllCloseIconAfterLogin();
        l1.clickPostMyAd();
        createad.createResidentialApartmentAd();
    }
}
