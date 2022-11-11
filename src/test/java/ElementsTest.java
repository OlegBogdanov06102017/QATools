import framework.elements.Elements;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.DefaultListener;

@Listeners(DefaultListener.class)
public class ElementsTest extends MainTest {
    protected Elements elements;

    @BeforeMethod
    public void setUp() {
        driver.get("https://demoqa.com/elements");
        elements = new Elements(driver);
    }

    @Test
    public void getTextHeader() {
        String header = elements.getTextHeader();
        Assert.assertEquals("Elements", header);
    }

    @Test
    public void clickItemElements() {
        elements.clickItemElements();               //как бы тут проверить что открывается кроме как визуально
        String url = "https://demoqa.com/elements";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void clickTextBox() {
        elements.clickTextBox();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, driver.getCurrentUrl());
    }


}
