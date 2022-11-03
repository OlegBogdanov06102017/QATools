package Framework.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBox extends Elements {

    public TextBox(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@id='userName-label']")
    private WebElement getTextName;
    @FindBy(xpath = "//label[@id='userEmail-label']")
    private WebElement getTextEmail;
    @FindBy(xpath = "//label[@id='currentAddress-label']")
    private WebElement getTextCurrentAddress;
    @FindBy(xpath = "//label[@id='permanentAddress-label']")
    private WebElement getTextPermanentAddress;
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement sendName;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement sendEmail;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement sendCurrentAddress;
    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement sendPermanentAddress;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//p[@id='name']")
    private WebElement checkName;
    @FindBy(xpath = "//p[@id='email']")
    private WebElement checkEmail;
    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement checkCurrentAddress;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    private WebElement checkPermanentAddress;

    public String getTextNameField() {
        return getTextName.getText();
    }

    public String getTextEmailField() {
        return getTextEmail.getText();
    }

    public String getTextCurrentAddressField() {
        return getTextCurrentAddress.getText();
    }

    public String getTextPermanentAddressField() {
        return getTextPermanentAddress.getText();
    }

    public TextBox sendTextName(String name) {
        sendName.sendKeys(name);
        return new TextBox(driver);
    }

    public TextBox sendTextEmail(String email) {
        sendEmail.sendKeys(email);
        return new TextBox(driver);
    }

    public TextBox sendTextCurrentAddress(String currentAddress) {
        sendCurrentAddress.sendKeys(currentAddress);
        return new TextBox(driver);
    }

    public TextBox sendTextPermanentAddress(String permanentAddress) {
        sendPermanentAddress.sendKeys(permanentAddress);
        return new TextBox(driver);
    }

    public TextBox clickSubmit() {
        buttonSubmit.click();
        return new TextBox(driver);
    }

    public TextBox checkTextName() {
        checkName.getText();
        return new TextBox(driver);
    }

    public TextBox checkTextEmail() {
        checkEmail.getText();
        return new TextBox(driver);
    }

    public TextBox checkTextCurrentAddress() {
        checkCurrentAddress.getText();
        return new TextBox(driver);
    }

    public TextBox checkTextPermanentAddress() {
        checkPermanentAddress.getText();
        return new TextBox(driver);
    }


}


