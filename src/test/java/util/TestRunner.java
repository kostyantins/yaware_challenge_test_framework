package util;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;
import pageobjects.CreateAccountPage;
import pageobjects.LogInPage;
import pageobjects.RemindPasswordPage;
import pageobjects.UserAccountPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.MalformedURLException;

import static util.WebDriverFactory.getDriver;
import static util.WebDriverFactory.setDriver;

@Listeners({Listener.class})
public class TestRunner {

    protected LogInPage logInPage;
    protected CreateAccountPage createAccountPage;
    protected UserAccountPage userAccountPage;
    protected RemindPasswordPage remindPasswordPage;

    @Step
    @Parameters({"browser", "version", "platform"})
    @BeforeMethod
    public final void setUp(@Optional("default") final String browser,
                            @Optional("47") final String version,
                            @Optional("mac") final String platform) throws MalformedURLException {

        final String homePageUrl = PropertiesReader.getProperty("home.page.url");

        setDriver(browser, version, platform);

        getDriver()
                .manage()
                .window()
                .maximize();

        getDriver()
                .get(homePageUrl);

        logInPage = new LogInPage();
    }

    @Step
    @AfterTest
    public final void tarnDown() {

        if (getDriver() != null) {
            try {
                getDriver()
                        .quit();
            } catch (WebDriverException e) {
                System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****" + e);
            }
        }
    }
}
