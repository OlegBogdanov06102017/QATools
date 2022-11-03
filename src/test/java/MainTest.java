import Framework.Main;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MainTest {
    public static WebDriver driver;


    @BeforeTest
    public static void openDriver() {
        driver = Main.getDriver();
    }

//    @AfterTest
//    public static void quit() {
//        driver.quit();
//    }

}
