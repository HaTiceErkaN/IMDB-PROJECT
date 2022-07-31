package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ImdbPage {
    public ImdbPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "imdbHeader-navDrawerOpen--desktop")
    public WebElement menu;

    @FindBy(xpath = "(//a[@role='menuitem'])[20]")
    public WebElement oscars;

    @FindBy(xpath = "//*[text()='1929']")
    public WebElement year;

    //TheCircus

    @FindBy(xpath = "(//span[@class='event-widgets__nominee-name'])[68]")
    public WebElement theCircus;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[1]")
    public WebElement circusDirector;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[2]")
    public WebElement circusWriter;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[3]")
    public WebElement circusStars;

    @FindBy(id = "home_img_holder")
    public WebElement imdbHomePage;

    @FindBy(xpath = "//input[@id='suggestion-search']")
    public WebElement searchTextBox;

    @FindBy(linkText = "Şarlo Sirkte")
    public WebElement circus;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[1]")
    public WebElement directorResult;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[2]")
    public WebElement writerResult;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[3]")
    public WebElement starsResult;

    @FindBy(xpath = "(//h3[@class='ipc-title__text'])[1]")
    public WebElement photos;

    @FindBy(xpath = "//img[@height='100']")
    public List<WebElement> photoList1;

    @FindBy(xpath = "//div[@class='ipc-button__text']")
    public WebElement close;

    @FindBy(xpath = "(//a[@class='prevnext'])[1]")
    public WebElement next;

    @FindBy(xpath = "//img[@height='100']")
    public List<WebElement> photoList2;


    //TheJazzSinger

    @FindBy(linkText = "Caz Mugannisi")
    public WebElement theJazzSinger;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[1]")
    public WebElement jazzDirector;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[2]")
    public WebElement jazzWriter;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[3]")
    public WebElement jazzStars;

    @FindBy(linkText = "Caz Mugannisi")
    public WebElement jazzSinger;

    @FindBy(xpath = "(//li[@class='ipc-metadata-list__item'])[1]")
    public WebElement jDirectorResult;

    @FindBy(xpath = "(//li[@class='ipc-metadata-list__item'])[2]")
    public WebElement jWriterResult;

    @FindBy(xpath = "(//li[@class='ipc-metadata-list__item'])[3]")
    public WebElement jStarsResult;

    @FindBy(xpath = "(//h3[@class='ipc-title__text'])[1]")
    public WebElement jphotos;

    @FindBy(xpath = "//img[@height='100']")
    public List<WebElement> jphotosList;


}
