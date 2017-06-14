package pageobjects;

import enums.Languages;
import enums.PageToGo;
import enums.PageToGoConfirmElements;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.*;
import util.PropertiesReader;

import java.util.List;

@Getter
public class LogInPage extends AbstractPageObject {

    @Name("Create user link")
    @FindBy(xpath = "(//*[@id='main-content']//header//a)[2]")
    @Timeout(30)
    private Link createAccountLink;

    //element to check if Email mask is displayed
    @Name("Email input field")
    @FindBy(id = "email")
    @Timeout(30)
    public static TextInput emailInput;

    //element to check if Password mask is displayed
    @Name("Password input field")
    @FindBy(id = "password")
    @Timeout(30)
    public static TextInput passInput;

    @Name("Log in credentials")
    @FindAll({
            @FindBy(id = "email"),
            @FindBy(id = "password")
    })
    private List<WebElement> allElementsInList;

    //element to check right navigation to LogInPage
    @Name("Login button")
    @FindBy(id = "login-submit")
    @Timeout(30)
    private Button loginButton;

    //element for check if invalid user is not login
    @Name("Wrong credentials alert")
    @FindBy(xpath = "//*[@id='password']//following::div[@class='tooltip-inner']")
    @Timeout(30)
    public static WebElement invalidUser;

    //element to check if logo exist
    @Name("Logo image")
    @FindBy(id = "logo")
    @Timeout(30)
    public static Image logo;

    @Name("English language link")
    @FindBy(xpath = "//*[@id='lang-box']//a[1]")
    @Timeout(30)
    private Link englishLanguage;

    @Name("Russian language link")
    @FindBy(xpath = "//*[@id='lang-box']//a[2]")
    @Timeout(30)
    private Link russianLanguage;

    @Name("Ukraine language link")
    @FindBy(xpath = "//*[@id='lang-box']//a[3]")
    @Timeout(30)
    private Link ukraineLanguage;

    @Name("France language link")
    @FindBy(xpath = "//*[@id='lang-box']//a[4]")
    @Timeout(30)
    private Link franceLanguage;

    //element to check if language changed
    @Name("Language title")
    @FindBy(xpath = "//*[@id='log-in']/div[2]/h3")
    @Timeout(30)
    public static TextBlock language;

    @Name("Remind password page link")
    @FindBy(xpath = "(//*[@id='main-content']//header//a)[3]")
    @Timeout(30)
    private Link remindPassLink;

    @Name("Have an idea link")
    @FindBy(xpath = "html/body/div[2]")
    @Timeout(30)
    private Link haveAnIdeaLink;

    @Name("Remember me checkbox")
    @FindBy(xpath = "//*[@id='form-field-rememberMe']/label")
    @Timeout(30)
    private WebElement rememberMeCheckbox;

    private String validEmail = PropertiesReader.getProperty("valid.email");
    private String validPass = PropertiesReader.getProperty("valid.pass");

    @Step
    public final CreateAccountPage openCreateAccountPage() {

        clickTo(createAccountLink);

        return new CreateAccountPage();
    }

    @Step
    public final YourIdeasPage openYourIdeasPage() {

        clickTo(haveAnIdeaLink);

        return new YourIdeasPage();
    }

    @Step
    public final LogInPage setEmail() {

        fillInputAs(emailInput, validEmail);

        return this;
    }

    @Step
    public final LogInPage setInvalidEmail(final String invalidEmail) {

        fillInputAs(emailInput, invalidEmail);

        return this;
    }

    @Step
    public final LogInPage setPassword() {

        fillInputAs(passInput, validPass);

        return this;
    }

    @Step
    public final LogInPage setInvalidPassword(final String invalidPassword) {

        fillInputAs(passInput, invalidPassword);

        return this;
    }

    @Step
    public final UserAccountPage doAuthorization() {

        clickTo(loginButton);

        return new UserAccountPage();
    }

    @Step
    public final void changLanguage(final Languages someLanguage) {

        final LogInPage logInPage = new LogInPage();

        switch (someLanguage) {

            case ENGLISH:

                logInPage
                        .clickTo(englishLanguage);
                break;

            case RUSSIAN:

                logInPage
                        .clickTo(russianLanguage);
                break;

            case UKRAINE:

                logInPage
                        .clickTo(ukraineLanguage);
                break;

            case FRANCE:

                logInPage
                        .clickTo(franceLanguage);
                break;
        }
    }

    @Step
    public final void openPage(final PageToGo somePage) {

        final LogInPage logInPage = new LogInPage();

        switch (somePage) {

            case CREATE_ACCOUNT_PAGE:

                logInPage
                        .openCreateAccountPage();
                break;

            case REMIND_PASS_PAGE:

                logInPage
                        .openRemindPasswordPage();
                break;
        }
    }

    @Step
    public final RemindPasswordPage openRemindPasswordPage() {

        final LogInPage logInPage = new LogInPage();

        logInPage
                .clickTo(remindPassLink);

        return new RemindPasswordPage();
    }

    @Step
    public final WebElement getPageElement(final PageToGoConfirmElements pageElement) {

        WebElement element = null;

        switch (pageElement) {

            case REMIND_PASS_BUTTON:

                final RemindPasswordPage remindPasswordPage = new RemindPasswordPage();

                element = remindPasswordPage.getRemindPassButton();

                break;

            case CREATE_BUTTON:

                final CreateAccountPage createAccountPage = new CreateAccountPage();

                element = createAccountPage.getCreateButton();

                break;
        }
        return element;
    }

    @Step
    public LogInPage setEnglishLanguage() {

        clickTo(englishLanguage);

        return this;
    }

    @Step
    public LogInPage setRememberMeCheckbox() {

        clickTo(rememberMeCheckbox);

        return this;
    }
}

