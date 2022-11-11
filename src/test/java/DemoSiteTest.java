import framework.DemoSite;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DefaultListener;


import java.time.Duration;

@Listeners(DefaultListener.class)
public class DemoSiteTest extends MainTest {
    protected DemoSite demoSite;

    @BeforeMethod
    public void setUp() {
        driver.get("https://demoqa.com/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        demoSite = new DemoSite(driver);
        demoSite.scroll();

    }


    @Test
    public void clickElements() {
        demoSite.clickElements();
        String elementsUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/elements", elementsUrl);
    }

    @Test
    public void clickForms() {
        demoSite.clickForms();
        String formsUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/forms", formsUrl);
    }

    @Test
    public void clickAlertsFrameWindows() {
        demoSite.clickAlertsFrameWindows();
        String alertsUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/alertsWindows", alertsUrl);
    }

    @Test
    public void clickWidgets() {
        demoSite.clickWidgets();
        String widgetsUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/widgets", widgetsUrl);
    }

    @Test
    public void clickInteractions() {
        demoSite.clickInteractions();
        String interactionUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/interaction", interactionUrl);
    }

    @Test
    public void clickBookStoreApplication() {
        demoSite.clickBookStoreApplication();
        String booksUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/books", booksUrl);
    }


}
