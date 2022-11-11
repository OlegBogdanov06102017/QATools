package framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    private boolean isCookieAccept;
    @FindBy(xpath = "//ul[@class='navbar__links d-none d-lg-flex']/li/a[text()='Home']")
    private WebElement home;
    @FindBy(xpath = "//div[text()='Selenium Online Trainings']")
    private WebElement headerText; //локатор Selenium Online Trainings
    @FindBy(xpath = "//ul[@class='navbar__links d-none d-lg-flex']/li/a[text()='Selenium Training']")
    private WebElement seleniumTraining; //локатор кнопки Selenium Training below Tutorials
    @FindBy(xpath = "//a[@class='btn btn-primary-shadow btn-block']")
    private WebElement enrollYourself; //link enrollYourself
    @FindBy(xpath = "//ul[@class='links']//li//a[text()='ISTQB']")
    private WebElement istqbButton;
    @FindBy(xpath = "//button[@id='accept-cookie-policy']")
    private WebElement cookieButton;
    @FindBy(xpath = "//ul[@class='navbar__links d-none d-lg-flex']/li/a[text()='Demo Site']")
    private WebElement demoSite;
    @FindBy(xpath = "//input[@class='navbar__search--input']")
    private WebElement lupa;
    @FindBy(xpath = "//span[text()='Tutorials']")
    private WebElement tutorials;
    @FindBy(xpath = "//span[text()='Back-End Testing Automation']")
    private WebElement backEndTestingAutomation;
    @FindBy(xpath = "//div[@class='second-generation']/ul/li/a[@title='Rest Assured']")
    private WebElement restAssured;
    @FindBy(xpath = "//main/button[@class='modal__close']")
    private WebElement popup;


    public MainPage clickHome() {
        home.click();
        return new MainPage(driver);
    }

    public String SeleniumOnlineText() {
        return headerText.getText();
    }

    public SeleniumTraining clickSeleniumTraining() {
        seleniumTraining.click();
        return new SeleniumTraining(driver);
    }

    public DemoSite clickDemoSite() {
        demoSite.click();
        return new DemoSite(driver);
    }

    public RestAssured clickTutorials() {
        tutorials.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        backEndTestingAutomation.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        restAssured.click();
        return new RestAssured(driver);
    }

    public MainPage Search(String a) {
        lupa.sendKeys(a);
        return new MainPage(driver);
    }

    public SeleniumTraining clickEnroll() {
        enrollYourself.click();
        return new SeleniumTraining(driver);
    }

    public String getTextISTQB() {
        return istqbButton.getText();
    }

    public IstqbPage clickISTQB() {
        istqbButton.click();
        return new IstqbPage(driver);
    }

    public IstqbPage cookieClick() {
        if (cookieButton.isEnabled()) {
            cookieButton.click();
            isCookieAccept=true;
        }
        else {
            isCookieAccept=false;
        }
        return new IstqbPage(driver);
    }

    public MainPage popupClick() {
        if (popup.isEnabled()) {
            popup.click();
        }
        return new MainPage(driver);
    }
    public boolean isCookieAccept() {
        return isCookieAccept;
    }
}
