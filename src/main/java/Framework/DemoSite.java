package Framework;

import Framework.Elements.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;




public class DemoSite extends AbstractPage {
    public DemoSite (WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Elements']")
    private WebElement elements;
    @FindBy(xpath = "//div/div[@class='card-body']/h5[text()='Forms']/.")
    private WebElement forms;
    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindows;
    @FindBy(xpath ="//div[@class='card-body']/h5[text()='Widgets']" )
    private WebElement widgets;
    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Interactions']")
    private WebElement interactions;
    @FindBy(xpath = "//div[@class='card-body']/h5[text()='Book Store Application']")
    private WebElement bookStoreApplication;
//    @FindBy(xpath ="//div[@id='fixedban']");
//    private WebElement fixedban;


    public Elements clickElements() {
        elements.click();
        return new Elements(driver);
    }
    public Forms clickForms() {
        forms.click();
        return new Forms(driver);
    }
    public AlertsFrameWindows clickAlertsFrameWindows() {
        alertsFrameWindows.click();
        return new AlertsFrameWindows(driver);
    }
    public Widgets clickWidgets() {
        widgets.click();
        return new Widgets(driver);
    }
    public Interactions clickInteractions() {
        interactions.click();
        return new Interactions(driver);
    }
    public BookStoreApplication clickBookStoreApplication() {
        bookStoreApplication.click();
        return new BookStoreApplication(driver);
    }
    public DemoSite scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        return new DemoSite(driver);
    }







}
