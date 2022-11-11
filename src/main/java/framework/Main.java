package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;


public class Main {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-popup-blocking");
            ChromeDriver driverNew = new ChromeDriver(options);
            driverNew.manage().window().maximize();
            driverNew.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver = driverNew;
        }
        return driver;
    }

    public static void main(String[] args) {

    }

}
