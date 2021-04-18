package postmyadqatest;

import com.excel.utility.XLS_Reader;
import com.postmyad.qa.base.PostMyAdBase;
import com.postmyad.qa.po.CreateAdPO;
import com.postmyad.qa.po.LoginPO;
import org.testng.annotations.Test;

public class RentResidentialApartmentTest extends PostMyAdBase {

    //postmyadqatest.LoginTest l1=new postmyadqatest.LoginTest();

    @Test
    public void setCreatead(){

        String sheetname="login";
        XLS_Reader reader = new XLS_Reader();
        reader.XlS_Reader("C:\\PostmyAd\\src\\main\\resources\\login.xlsx");
        int rowcount =reader.getColumnCount(sheetname);
        for(int i=2;i<=rowcount;i++) {

            LoginPO l1 = new LoginPO();
            RentResidentialApartmentTest rent = new RentResidentialApartmentTest();
            CreateAdPO createad = new CreateAdPO();


            rent.start();
            rent.initialization();

            l1.validTopLinks();
            l1.verifyQuickLinksOverlay();
            // l1.findPuneProject();
            l1.Login(reader.getCellData(sheetname, "Username", i), reader.getCellData(sheetname, "Password", i));

            l1.clickAllCloseIconAfterLogin();
            l1.clickPostMyAd();
            createad.createResidentialApartmentAd();
        }
    }
}
