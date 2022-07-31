package test;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ImdbPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class ImdbTest extends TestBaseRapor {

    /*
    https://www.imdb.com/ adresine gidilir
• Arama çubuğunun sol tarafında bulunan Menü butonuna basılır
• Gelen ekranda “Award & Events” başlığı altında bulunan “Oscars” butonuna
tıklanır
• “Event History” başlığı altında “1929” değeri seçilir
• “Honorary Award” başlığı altında “The Circus (Charles Chaplin)” seçilir
• Gelen ekranda, The Circus’a ait;
a. Director: bilgisi kayıt edilir.
b. Writer: bilgisi kayıt edilir.
c. Stars: bilgisi kayıt edilir.
• Ekranın sol üstünde bulunan “IMDb” butonuna tıklanarak “Anasayfa’ya”
dönülür.
• Arama çubuğuna “The Circus” yazılır.
• Sonuçlar arasında gelen “The Circus’a” tıklanır.
• Gelen ekranda;
a. Director: bilgisi kayıt edilen directorle aynı mı kontrol edilir.
b. Writer: bilgisi kayıt edilen Writer’la aynı mı kontrol edilir.
c. Stars: bilgisi kayıt edilen Starts’la aynı mı kontrol edilir.
• Kontroller yapıldıktan sonra “See all .. photos” linkine tıklanır
• Gelen ekranda:
a. Bütün fotoğrafların linklerinin kırık olmadığını kontrol edilir.
• Aynı işlemler “The Jazz Singer” filmi için de yapılmalıdır.
Beklenen Sonuç (Expected result):
• Director: bilgisi değişmemeli
• Writer: bilgisi değişmemeli
• Stars: bilgisi değişmemeli.
• Filmle alakalı fotoğrafların linkleri kırık olmamalı.
     */

    ImdbPage page;
    SoftAssert softAssert;
    JavascriptExecutor jse;
    Actions actions;


    @BeforeMethod
    public void beforeTests(){

        page=new ImdbPage();
        softAssert= new SoftAssert();
        jse= (JavascriptExecutor) Driver.getDriver();
        actions = new Actions(Driver.getDriver());
    }

    @Test
    public void theCircus() throws InterruptedException {
        extentTest = extentReports.createTest("The Circus film bilgileri", " The Circus film bilgileri karsilastirilir, fotograflara bakilir");

       Driver.getDriver().get(ConfigReader.getProperty("imdbUrl"));
       extentTest.info("https://www.imdb.com/ sayfasina gidildi");

       page.menu.click();
       Thread.sleep(1000);
       extentTest.info("menu butonuna tiklandi");

       page.oscars.click();
       extentTest.info("Oscars bolumune tiklandi");

       page.year.click();
       extentTest.info("1929 yilina tiklandi");

        ReusableMethods.scrollIntoView(page.theCircus);
        Thread.sleep(2000);
        page.theCircus.click();
        extentTest.info("The Circus secnegine tiklandi");

        List<String> informationList=new ArrayList<>();
        String circusdirector= page.circusDirector.getText();
        String circuswriter= page.circusWriter.getText();
        String circusstars= page.circusStars.getText();

       page.imdbHomePage.click();
       Thread.sleep(1000);
       extentTest.info("Anasayfaya gidildi");

       page.searchTextBox.sendKeys("The Circus"+Keys.ENTER);
       extentTest.info("Arama kutusunda The Circus aratildi");

       page.circus.click();
       extentTest.info("Circus sayfasina gidildi");

       actions.sendKeys(Keys.PAGE_DOWN);
       softAssert.assertEquals(circusdirector,page.directorResult.getText());
       extentTest.info("director bilgisi karsilastirildi");

       softAssert.assertEquals(circuswriter,page.writerResult.getText());
       extentTest.info("writer bilgisi karsilastirildi");

       softAssert.assertEquals(circusstars,page.starsResult.getText());
       extentTest.info("stars bilgisi karsilastirildi");
       softAssert.assertAll();

       page.photos.click();
       extentTest.info("fotograflara tiklandi");

        for (int i = 0; i <page.photoList1.size() ; i++) {
            page.photoList1.get(i).click();
            Thread.sleep(1000);
            page.close.click();
        }

        page.next.click();
        Thread.sleep(2000);

        for (int i = 0; i <page.photoList2.size() ; i++) {
            page.photoList2.get(i).click();
            Thread.sleep(1000);
            page.close.click();
        }
        extentTest.info("Tum fotograflara sira ile tiklandi");

        extentReports.flush();

    }
    @Test
    public void theJazzSinger() throws InterruptedException {
        extentTest = extentReports.createTest("The Jazz Singer film bilgileri", " The Jazz Singer film bilgileri karsilastirilir, fotograflara bakilir");

        Driver.getDriver().get(ConfigReader.getProperty("imdbUrl"));
        extentTest.info("https://www.imdb.com/ sayfasina gidildi");

        page.menu.click();
        Thread.sleep(1000);
        page.oscars.click();
        extentTest.info("Oscars bolumune tiklandi");

        page.year.click();
        extentTest.info("1929 yilina tiklandi");

        ReusableMethods.scrollIntoView(page.theJazzSinger);
        page.theJazzSinger.click();
        extentTest.info("The Jazz Singer secenegine tiklandi");

        String jazzDirector=page.jazzDirector.getText();
        String jazzWriter=page.jazzWriter.getText();
        String jazzStars=page.jazzStars.getText();

        page.imdbHomePage.click();
        extentTest.info("Anasayfaya gidildi");

        page.searchTextBox.sendKeys("The Jazz Singer"+Keys.ENTER);
        extentTest.info("Arama kutusunda The Jazz Singer aratildi");

        page.jazzSinger.click();
        extentTest.info("the jazz singer sayfasina gidildi");

        softAssert.assertEquals(jazzDirector,page.jDirectorResult.getText());
        softAssert.assertEquals(jazzWriter,page.jWriterResult.getText());
        softAssert.assertEquals(jazzStars,page.jStarsResult.getText());

        actions.sendKeys(Keys.PAGE_DOWN);

        page.jphotos.click();
        extentTest.info("fotograflara tiklandi");

        for (int i = 0; i <page.jphotosList.size(); i++) {
            page.jphotosList.get(i).click();
            Thread.sleep(10000);
            page.close.click();
        }
        extentTest.info("tum fotograflara sira ile tiklandi");

        extentReports.flush();


    }


}
