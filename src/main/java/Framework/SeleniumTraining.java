package Framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumTraining extends AbstractPage {
    public SeleniumTraining (WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='included__heading']")
    private WebElement whatIsIncludedconText;
    @FindBy(xpath = "//a[text()='Go To Registration ']")
    private WebElement goToRegistration; //кнопка го ту регистратион
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName; //поле для ввода имени  a
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;//поле для ввода фамилии         b
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email; //поле для мыла                  c
    @FindBy(xpath = "//input[@id='mobile']")
    private WebElement mobile;//поле для мобилы                   d
    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;//поле для города                     e
    @FindBy(xpath = "//select[@id='country']")
    private WebElement country;//поле для выпадающего списка страны  f
    @FindBy(xpath = "//option[text()='Sri Lanka']")
    private WebElement countryName;//поле для выбора страны из списка
    @FindBy(xpath = "//button[text()= 'Send']")
    private WebElement send; //кнопка Send





    public String whatIsIncludedText() {
        return whatIsIncludedconText.getText();
    }

    public SeleniumTraining goToRegistrationClick() {
        goToRegistration.click();
        return new SeleniumTraining(driver);
    }

    public SeleniumTraining firstNameSend(String a) {
        firstName.sendKeys(a);
        return new SeleniumTraining(driver);
    }
    public SeleniumTraining lastNameSend(String b) {
        lastName.sendKeys(b);
        return new SeleniumTraining(driver);
    }
    public SeleniumTraining emailSend(String c) {
        email.sendKeys(c);
        return new SeleniumTraining(driver);
    }
    public SeleniumTraining mobileSend(String d) {
        mobile.sendKeys(d);
        return new SeleniumTraining(driver);
    }
    public SeleniumTraining citySend(String e) {
        city.sendKeys(e);
        return new SeleniumTraining(driver);
    }

    public SeleniumTraining countrySelect() {
        country.click();
        countryName.click();
        return new SeleniumTraining(driver);
    }
    public SeleniumTraining sendClick() {
        send.click();
        return new SeleniumTraining(driver);
    }
}
