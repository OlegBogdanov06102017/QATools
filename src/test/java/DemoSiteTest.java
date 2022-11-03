import Framework.DemoSite;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


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
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public void clickElements()  {
        demoSite.clickElements();
        String elementsUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/elements", elementsUrl);
    }

    @Test
    public void clickForms()  {
        demoSite.clickForms();
        String formsUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/forms", formsUrl);
    }

    @Test
    public void clickAlertsFrameWindows() {
        demoSite.clickAlertsFrameWindows();
    }

    @Test
    public void clickWidgets() {
        demoSite.clickWidgets();
    }

    @Test
    public void clickInteractions() {
        demoSite.clickInteractions();
    }

    @Test
    public void clickBookStoreApplication() {
        demoSite.clickBookStoreApplication();
    }

//        @AfterMethod
//        public void screenShot() throws IOException {
//            File screenshotElements = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(screenshotElements, new File("C:\\project\\Screenshots\\screenShotElements.png"));
//        }


}
