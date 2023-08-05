package techproed.stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.BlueRentalPage;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

import java.security.Key;
import java.util.Map;

public class BlueRentalStepDefinition {
    BlueRentalPage blueRentalPage =new BlueRentalPage();
    @Then("kullanici login butonuna tiklar")
    public void kullaniciLoginButonunaTiklar() {
        blueRentalPage.loginButtonu.click();



    }

    @And("kullanici tabloda verilen bilgiler ile login olur")
    public void kullaniciTablodaVerilenBilgilerIleLoginOlur(DataTable data) {
        blueRentalPage.emailBox.sendKeys(data.row(1).get(0), Keys.TAB,data.row(1).get(1),Keys.ENTER);
        ReusableMethods.bekle(3);
        Driver.getDriver().navigate().back();// giriş yaptıktan sonra çıkış yapıp tekrar logine tıklamak yerine back yaptık
        blueRentalPage.emailBox.sendKeys(data.row(2).get(0),Keys.TAB,data.row(2).get(1),Keys.ENTER);
        ReusableMethods.bekle(3);



    }

    @And("Kullanici tabloda ki verilen bilgileri kullanarak map ile login olur")
    public void kullaniciTablodaKiVerilenBilgileriKullanarakMapIleLoginOlur(DataTable data) {

        for (Map<String,String> w:data.asMaps()) {
            blueRentalPage.emailBox.sendKeys(w.get("email"),Keys.TAB,w.get("password"),Keys.ENTER);
            ReusableMethods.bekle(3);
            Driver.getDriver().navigate().back();
            ReusableMethods.bekle(3);
        }


        }
    @And("kullanici exceldeki {string} sayfasindaki bilgiler ile giris yapip giris yapildigini test eder")
    public void kullaniciExceldekiSayfasindakiBilgilerIleGirisYapipGirisYapildiginiTestEder(String sayfaIsmi) {
        String dosyaYolu = "src/test/resources/mysmoketestdata.xlsx";
        ExcelReader excelReader = new ExcelReader(dosyaYolu,sayfaIsmi);
        for (int i = 1; i <=excelReader.rowCount() ; i++) {
            String email = excelReader.getCellData(i,0);
            String password = excelReader.getCellData(i,1);
            blueRentalPage.loginButtonu.click();
            ReusableMethods.bekle(2);
            blueRentalPage.emailBox.sendKeys(email,Keys.TAB,password,Keys.ENTER);
            ReusableMethods.bekle(2);
            blueRentalPage.loginButton2.click();
            ReusableMethods.bekle(2);
            blueRentalPage.profileButton.click();
            ReusableMethods.bekle(2);
            Assert.assertEquals(blueRentalPage.profileMail.getText(),email);
            ReusableMethods.bekle(2);
            blueRentalPage.loginButton2.click();
            ReusableMethods.bekle(2);
            blueRentalPage.LogoutButton.click();
            ReusableMethods.bekle(2);
            blueRentalPage.okButton.click();
            ReusableMethods.bekle(2);


        }

    }
}

