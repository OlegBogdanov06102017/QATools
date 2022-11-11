package framework.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBox extends Elements {
    private boolean isDesktopCheckSelectedButton;
    private boolean isCheckMinusSuccess;

    public CheckBox(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement plusButton;
    @FindBy(xpath = "//button[@title='Collapse all']")
    private WebElement minusButton;
    @FindBy(xpath = "//span[@class='rct-checkbox']")
    private WebElement generalCheckBox;
    @FindBy(xpath = "//div[@id='tree-node']/ol/li/span/button")
    private WebElement generalToggle;
    @FindBy(xpath = "//div[@id='result']/span[3]")
    private WebElement textAfterSelect;
    @FindBy(xpath = "//span[text()='Desktop']")
    private WebElement desktop;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[1]/span/label/span[1]")
    private WebElement desktopCheckBox;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[1]/span/button")
    private WebElement desktopToggle;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[1]/ol/li[1]/span/label/span[3]")
    private WebElement notesText;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/ol/li[1]/span/label/span[3]")
    private WebElement reactText;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[3]")
    private WebElement generalText;

    public CheckBox clickPlus() {
        plusButton.click();
        if (reactText.isEnabled()) {
            reactText.getText();
        }
        return new CheckBox(driver);
    }


    public String getTextReact() {
        return reactText.getText();
    }

    public CheckBox clickMinus() {
        plusButton.click();
        if (generalText.isEnabled()) {
            generalText.getText();
        }
        return new CheckBox(driver);
    }
    public boolean checkMinus(){
        if(generalText.isDisplayed()) {
            generalText.getText();
        } else  plusButton.click();
        return isCheckMinusSuccess= true;
    }

    public CheckBox generalCheckBoxClick() {
        if (!generalCheckBox.isSelected()) {
            generalCheckBox.click();
            textAfterSelect.getText();
        }
        return new CheckBox(driver);
    }

    public CheckBox generalToggleClick() {
        generalToggle.click();
        if (desktop.isEnabled()) {
            desktop.click();
            notesText.getText();
        }
        return new CheckBox(driver);
    }

    public boolean isDesktopCheckSelected() {
        desktopCheckBox.isEnabled();
        desktopCheckBox.isSelected();
        return isDesktopCheckSelectedButton;
    }

    public CheckBox clickDesktopToggle() {
        if (desktopToggle.isEnabled()) {
            desktopToggle.click();
            notesText.getText();
        }
        return new CheckBox(driver);
    }

}

