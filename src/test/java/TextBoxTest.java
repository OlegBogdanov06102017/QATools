import Framework.Elements.TextBox;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxTest extends MainTest {
    protected TextBox textBox;

    @BeforeMethod
    public void setUp() {
        driver.get("https://demoqa.com/text-box");
        textBox = new TextBox(driver);
        textBox = PageFactory.initElements(driver, TextBox.class);
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
        Assert.assertEquals("Email", textCurrentAddress);
    }
    @Test
    public void getTextPermanentAddressField() {
        String textPermanentAddress = textBox.getTextPermanentAddressField();
        Assert.assertEquals("Email", textPermanentAddress);
    }
    @Test
    public void sendTextInfo() {
        textBox.sendTextName("Svin");
        textBox.sendTextEmail("1@mail.com");
        textBox.sendTextCurrentAddress("old Svinarnik");
        textBox.sendTextPermanentAddress("new Svinarnik");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        textBox.clickSubmit();
    }





}
