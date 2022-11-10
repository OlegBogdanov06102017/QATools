package utils;

import Framework.Main;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class DefaultListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshotElements = ((TakesScreenshot) Main.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotElements, new File("C:\\project\\Screenshots\\sendErrorTextInfo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
