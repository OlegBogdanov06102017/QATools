import Framework.Elements.TextBox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.DefaultListener;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Listeners(DefaultListener.class)
public class TextBoxTest extends MainTest {
    protected TextBox textBox;

    @BeforeMethod
    public void setUp() {
        driver.get("https://demoqa.com/text-box");
        textBox = new TextBox(driver);
//        textBox = PageFactory.initElements(driver, TextBox.class);
    }

    @Test
    public void getTextNameField() {
        String textName = textBox.getTextNameField();
        Assert.assertEquals("Full Name", textName);
    }

    @Test
    public void getTextEmailField() {
        String textEmail = textBox.getTextEmailField();
        Assert.assertEquals("Email", textEmail);
    }

    @Test
    public void getTextCurrentAddressField() {
        String textCurrentAddress = textBox.getTextCurrentAddressField();
        Assert.assertEquals("Current Address", textCurrentAddress);
    }

    @Test
    public void getTextPermanentAddressField() {
        String textPermanentAddress = textBox.getTextPermanentAddressField();
        Assert.assertEquals("Permanent Address", textPermanentAddress);
    }

    @Test
    public void getAttributeName() {
        Assert.assertEquals("Full Name", textBox.getAttributeName());
    }

    @Test
    public void getAttributeEmail() {
        Assert.assertEquals("name@example.com", textBox.getAttributeEmail());
    }

    @Test
    public void getAttributeCurrentAddress() {
        Assert.assertEquals("Current Address", textBox.getAttributeCurrentAddress());
    }

    @Test
    public void getAttributePermanentAddress() {
        Assert.assertEquals("Permanent Address", textBox.getAttributePermanentAddress());
    }

    @Test
    public void sendTextInfo() {
        textBox.sendTextName("Svin")
                .sendTextEmail("1@mail.com")
                .sendTextCurrentAddress("new Svinarnik")
                .sendTextPermanentAddress("old Svinarnik");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        textBox.scroll()
                .clickSubmit();
        Assert.assertEquals("Name:Svin", textBox.checkTextName());
        Assert.assertEquals("Email:1@mail.com", textBox.checkTextEmail());
        Assert.assertEquals("Current Address :new Svinarnik", textBox.checkTextCurrentAddress());
        Assert.assertEquals("Permanent Address :old Svinarnik", textBox.checkTextPermanentAddress());
    }

    @Test
    public void sendErrorTextInfo() {
        textBox.sendTextName("Svin")
                .sendTextEmail("1")
                .sendTextCurrentAddress("new Svinarnik")
                .sendTextPermanentAddress("old Svinarnik");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        textBox.scroll()
                .clickSubmit()
                .checkRedField();
        Assert.assertEquals("Aдрес электронной почты должен содержать символ \"@\". В адресе \"1\" отсутсвует символ \"@\".", textBox.getAttributeEmail());
    }
}

