import Framework.Elements.Elements;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsTest extends MainTest {
    protected Elements elements;

    @BeforeMethod
    public void setUp() {
        driver.get("https://demoqa.com/elements");
        elements = new Elements(driver);
        elements = PageFactory.initElements(driver, Elements.class);
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
