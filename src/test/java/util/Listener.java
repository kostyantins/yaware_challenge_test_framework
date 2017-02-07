package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import static util.WebDriverFactory.getDriver;

public class Listener extends TestListenerAdapter {

    @Override
    public void onTestFailure(final ITestResult result) {

        byte[] srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

        saveScreenshot(srcFile);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(final byte[] screenshot) {

        return screenshot;
    }
}
