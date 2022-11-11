import framework.elements.RadioButton;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.DefaultListener;

@Listeners(DefaultListener.class)
public class RadioButtonTest extends MainTest {
    protected RadioButton radioButton;

    @BeforeMethod
    public void setUp() {
        driver.get("https://demoqa.com/radio-button");
        radioButton = new RadioButton(driver);
    }

    @Test
    public void clickYes() {
        radioButton.clickYes();
        Assert.assertEquals("Yes",radioButton.getYesText());
        Assert.assertEquals(true,radioButton.isCheckYes());
    }
    @Test
    public void clickImpressive() {
        radioButton.clickImpressive();
        Assert.assertEquals("Impressive",radioButton.getImpressiveText());
        Assert.assertEquals(true, radioButton.isCheckImpressive());
    }
    @Test
    public void clickNo() {
        radioButton.isCheckNo();
        Assert.assertEquals(false, radioButton.isCheckNo());
    }
}
