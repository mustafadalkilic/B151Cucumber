package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

    public class GooglePage {


        public GooglePage(){
            PageFactory.initElements(Driver.getDriver() , this);
        }

        @FindBy(xpath = "//*[@id='APjFqb']")
        public WebElement anaSayfa;

        @FindBy(xpath = "//*[@class='gLFyf']")
        public WebElement aramaKutusu;

    /*
List<WebElement> urunler = Driver.getDriver().findElements(By.xpath("sdfsdfsdf"));

PAGE CLASS'ında KARSILIGI
@FindBy(xpath = "fgdfgdfg")
public List<WebElement> urunler;
 */

}