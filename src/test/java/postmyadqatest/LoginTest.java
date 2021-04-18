package postmyadqatest;

import com.excel.utility.XLS_Reader;
import com.postmyad.qa.base.PostMyAdBase;
import com.postmyad.qa.po.LoginPO;
import org.testng.annotations.Test;

public class LoginTest extends PostMyAdBase {

    @Test
    public void login () throws InterruptedException {

        String sheetname="login";
        LoginTest login = new LoginTest();
        XLS_Reader reader = new XLS_Reader();
        reader.XlS_Reader("C:\\PostmyAd\\src\\main\\resources\\login.xlsx");
        int rowcount =reader.getRowCount(sheetname);

for(int i=2;i<=rowcount;i++) {
    login.start();
    login.initialization();
    LoginPO l1 = new LoginPO();
    l1.validTopLinks();

    l1.verifyQuickLinksOverlay();
    // l1.findPuneProject();

    l1.Login(reader.getCellData(sheetname, "Username", i), reader.getCellData(sheetname, "Password", i));


    l1.clickAllCloseIconAfterLogin();
    l1.clickPostMyAd();
    l1.enterBasicDetailsForRentApartment();
    l1.enterLocationDetails(reader.getCellData(sheetname, "Cityname", i),reader.getCellData(sheetname, "Societyname", i),reader.getCellData(sheetname, "Housenumber", i));
    l1.enterpropertyProfile();
    l1.uploadImage();
}
    //    l1.closeMaxListingPop();

      //  driver.quit();










    }
}
