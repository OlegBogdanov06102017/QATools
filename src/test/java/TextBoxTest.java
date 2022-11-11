import framework.elements.TextBox;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.DefaultListener;
import java.time.Duration;

@Listeners(DefaultListener.class)
public class TextBoxTest extends MainTest {
    protected TextBox textBox;

    @BeforeMethod
    public void setUp() {
        driver.get("https://demoqa.com/text-box");
        textBox = new TextBox(driver);
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
        Assert.assertEquals("Permanent Address", textBox.getAttributePermanentAddress());    //не хватает атрибута, баг
    }

    @Test
    public void sendTextInfo() {
        textBox.sendTextName("Michael")
                .sendTextEmail("bulls@mail.com")
                .sendTextCurrentAddress("North Carolina")
                .sendTextPermanentAddress("New-York");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        textBox.scroll()
                .clickSubmit();
        Assert.assertEquals("Name:Michael", textBox.checkTextName());
        Assert.assertEquals("Email:bulls@mail.com", textBox.checkTextEmail());
        Assert.assertEquals("Current Address :North Carolina", textBox.checkTextCurrentAddress());
        Assert.assertEquals(textBox.checkTextPermanentAddress(), "Permanent Address :New-York");  // баг в проверке
    }

    @Test
    public void sendErrorTextInfo() {
        textBox.sendTextName("Michael")
                .sendTextEmail("bulls")
                .sendTextCurrentAddress("North Carolina")
                .sendTextPermanentAddress("New-York");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));       // проверить всплывающую подсказку
        textBox.scroll()
                .clickSubmit()
                .checkRedField();
        Assert.assertEquals("Aдрес электронной почты должен содержать символ \"@\". В адресе \"1\" отсутсвует символ \"@\".", textBox.getAttributeEmail());
    }
}

