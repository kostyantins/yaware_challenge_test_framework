package tests;

import enums.PageToGo;
import enums.PageToGoConfirmElements;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.RemindPasswordPage;
import ru.yandex.qatools.allure.annotations.Description;
import util.DataProvider;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.LogInPage.logo;
import static util.WebDriverFactory.getDriver;

public class NavigateBetweenPagesTest extends TestRunner {

    @Description("The test check if we really get the right navigation result" +
            "Every pages are have some unique element which we take to confirm right navigation" +
            "Thus if unique page element is displayed - we have right navigation result")

    @Test(dataProvider = "testNavigateData", dataProviderClass = DataProvider.class)
    public final void testNavigateBetweenPages(final PageToGo somePage, final PageToGoConfirmElements pageElement) {

        logInPage
                .openPage(somePage);

        assertThat(logInPage.getPageElement(pageElement)).isDisplayed();

        getDriver()
                .navigate()
                .back();

        logInPage
                .refreshPage();

        assertThat(logInPage.getLoginButton()).isDisplayed();
    }

    @AfterMethod
    public final void comeBackToLoginPage(){

        remindPasswordPage = new RemindPasswordPage();

        remindPasswordPage
                .clickTo(logo);
    }
}
