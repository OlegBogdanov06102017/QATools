package Framework.Elements;

import Framework.DemoSite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements extends DemoSite {

    public Elements(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement textElementsHeader;
    @FindBy(xpath = "//span[@class='group-header']/div/div[text()='Elements']")
    private WebElement itemElements;
    @FindBy(xpath = "//li[@id='item-0']")
    private WebElement textBox;

    public String getTextHeader() {
        return textElementsHeader.getText();
    }

    public Elements clickItemElements() {
        itemElements.click();
        itemElements.click();
        return new Elements(driver);
    }

    public TextBox clickTextBox() {
        textBox.click();
        return new TextBox(driver);
    }

}
