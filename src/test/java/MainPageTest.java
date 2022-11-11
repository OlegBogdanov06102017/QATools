import framework.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.DefaultListener;

@Listeners(DefaultListener.class)
public class MainPageTest extends MainTest {
    protected MainPage mainPage;


    @BeforeMethod
    public void setUp() {
        driver.get("https://www.toolsqa.com/");
        mainPage = new MainPage(driver);
        mainPage.cookieClick();
//        mainPage.popupClick();

    }

    @Test
    public void clickHome() {
        String header = driver.getCurrentUrl();
        mainPage.clickHome();
        Assert.assertEquals(header, driver.getCurrentUrl());
    }

    @Test
    public void seleniumOnlineText() {
        String onlineText = mainPage.SeleniumOnlineText();
        Assert.assertEquals("Selenium Online Trainings", onlineText);
    }

    @Test
    public void clickSeleniumTraining() {
        mainPage.clickSeleniumTraining();
        String training = driver.getCurrentUrl();
        Assert.assertEquals(training, driver.getCurrentUrl());
    }

    @Test
    public void clickEnroll() {
        mainPage.clickEnroll();
        String enroll = driver.getCurrentUrl();
        Assert.assertEquals(enroll, driver.getCurrentUrl());
    }

    @Test
    public void clickISTQB() {
        mainPage.clickISTQB();
        String ISTQB = driver.getCurrentUrl();
        Assert.assertEquals(ISTQB, driver.getCurrentUrl());
    }

    @Test
    public void getTextISTQB() {
        String ISTQB = mainPage.getTextISTQB();
        Assert.assertEquals("ISTQB", ISTQB);
    }

    @Test
    public void demoSiteClick() {
        String mainPageUrl = driver.getCurrentUrl();
        mainPage.clickDemoSite();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, mainPageUrl);
    }

    @Test
    public void clickTutorials() {
        mainPage.clickTutorials();
        String urlRestAssured = driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(), urlRestAssured);
    }

    @Test
    public void search() {
        mainPage.Search("Rest");
    }

}
