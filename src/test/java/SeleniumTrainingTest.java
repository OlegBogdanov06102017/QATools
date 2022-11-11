import framework.SeleniumTraining;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.DefaultListener;

@Listeners(DefaultListener.class)
public class SeleniumTrainingTest extends MainTest {
    protected SeleniumTraining seleniumTraining;

    @BeforeClass
    public void setUp() {
        driver.get("https://www.toolsqa.com/selenium-training?q=headers");
        seleniumTraining = new SeleniumTraining(driver);
    }
    @Test
    public void whatIsIncludedText() {
        String text = seleniumTraining.whatIsIncludedText();
        Assert.assertEquals("What is included", text);
    }
    @Test
    public void goToRegistrationClick(){
        seleniumTraining.goToRegistrationClick();
        String header = driver.getCurrentUrl();
        Assert.assertEquals(header, driver.getCurrentUrl());
    }
    @Test
    public void firstNameSend() {
        seleniumTraining.firstNameSend("Oleg");
    }
    @Test
    public void lastNameSend() {
        seleniumTraining.lastNameSend("Bogdanov");
    }
    @Test
    public void emailSend() {
        seleniumTraining.emailSend("gavno@gavno.ru");
    }
    @Test
    public void mobileSend() {
        seleniumTraining.mobileSend("89313734944");
    }
    @Test
    public void citySend() {
        seleniumTraining.citySend("Svinarnik");
    }
    @Test
    public void selectCountryClick() {
        seleniumTraining.countrySelect();
    }
    @Test
    public void sendClick() {
        seleniumTraining.sendClick();
    }

}
