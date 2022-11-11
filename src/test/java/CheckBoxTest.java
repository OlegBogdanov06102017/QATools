import framework.elements.CheckBox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.DefaultListener;

@Listeners(DefaultListener.class)
public class CheckBoxTest extends MainTest {
    protected CheckBox checkBox;
    @BeforeMethod
    public void setUp() {
        driver.get("https://demoqa.com/checkbox");
        checkBox = new CheckBox(driver);
    }
    @Test
    public void clickPlus() {
        checkBox.clickPlus();
        String textReact = checkBox.getTextReact();
        Assert.assertEquals("React",textReact);

    }
    @Test
    public void clickMinus() {
        checkBox.clickMinus();
        boolean checkMinus = checkBox.checkMinus();
        Assert.assertEquals(checkMinus, true);
    }
}
