package framework.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButton extends Elements {
    private boolean isYesSelect;
    private boolean isImpressiveSelect;
    private boolean isNoSelect;

    public RadioButton(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@for='yesRadio']")
    private WebElement yesRadioButton;
    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveRadioButton;
    @FindBy(xpath = "//label[@for='noRadio']")
    private WebElement noRadioButton;
    @FindBy(xpath = "//span[text()='Yes']")
    private WebElement yesText;
    @FindBy(xpath = "//span[text()='Impressive']")
    private WebElement impressiveText;

    public RadioButton clickYes() {
        yesRadioButton.click();
        return new RadioButton(driver);
    }

    public String getYesText() {
        return yesText.getText();
    }

    public boolean isCheckYes() {
        if (!yesRadioButton.isSelected()) {
            yesRadioButton.click();
            isYesSelect = true;
        }
        return isYesSelect;
    }

    public RadioButton clickImpressive() {
        impressiveRadioButton.click();
        return new RadioButton(driver);
    }

    public String getImpressiveText() {
        return impressiveText.getText();
    }

    public boolean isCheckImpressive() {
        if (!impressiveRadioButton.isSelected()) {
            impressiveRadioButton.click();
            isImpressiveSelect = true;
        }
        return isImpressiveSelect;
    }

    public RadioButton clickNo() {
        noRadioButton.click();
        return new RadioButton(driver);
    }

    public boolean isCheckNo() {
        if (noRadioButton.isEnabled()) {
            noRadioButton.click();
        } else isNoSelect = false;
        return isNoSelect;
    }
}
