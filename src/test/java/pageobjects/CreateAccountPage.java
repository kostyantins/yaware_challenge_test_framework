package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import util.PropertiesReader;

@Getter
public class CreateAccountPage extends AbstractPageObject {

    //element to check if First name mask is displayed
    @Name("First name input field")
    @FindBy(id = "firstname")
    @Timeout(30)
    public static TextInput firstNameInput;

    //element to check if Last name mask is displayed
    @Name("Last name input field")
    @FindBy(id = "lastname")
    @Timeout(30)
    public static TextInput lastNameInput;

    //element to check if Email mask is displayed
    @Name("Email input field")
    @FindBy(id = "registerEmail")
    @Timeout(30)
    public static TextInput emailInput;

    //element to check if Password mask is displayed
    @Name("Password input field")
    @FindBy(id = "pwd1")
    @Timeout(30)
    public static TextInput passInput;

    //element to check if Phone mask is displayed
    @Name("Phone input field")
    @FindBy(id = "phone")
    @Timeout(30)
    public static TextInput phoneInput;

    //element to check right navigation to CreateAccountPage
    @Name("Create button")
    @FindBy(id = "register-account-submit")
    @Timeout(30)
    private Button createButton;

    //element to check if invalid account was not created
    @Name("Email exist alert")
    @FindBy(xpath = "//*[@id='registerEmail']//following::div[@class='tooltip-inner']")
    @Timeout(30)
    public static WebElement emailExistAlert;

    //element to check if country flag was changed
    @Name("Country flag dropdown")
    @FindBy(xpath = "//*[@id='form-field-phone']/div[1]/div/div")
    @Timeout(30)
    public static WebElement countryFlagDropdown;

    private String userName = PropertiesReader.getProperty("user.name");
    private String userLastName = PropertiesReader.getProperty("user.lastname");
    private String emailToCreate = PropertiesReader.getProperty("email.to.create");
    private String pass = PropertiesReader.getProperty("user.pass");
    private String phone = PropertiesReader.getProperty("mobile.phone");
    private String invalidEmail = PropertiesReader.getProperty("invalid.email");

    @Step
    public final CreateAccountPage setFirstName() {

        fillInputAs(firstNameInput, userName);

        return this;
    }

    @Step
    public final CreateAccountPage setLastName() {

        fillInputAs(lastNameInput, userLastName);

        return this;
    }

    @Step
    public final CreateAccountPage setEmail() {

        fillInputAs(emailInput, emailToCreate);

        return this;
    }

    @Step
    public final CreateAccountPage setPassword() {

        fillInputAs(passInput, pass);

        return this;
    }

    @Step
    public final CreateAccountPage setPhone() {

        fillInputAs(phoneInput, phone);

        return this;
    }

    @Step
    public final UserAccountPage createNewAccount() {

        clickTo(createButton);

        return new UserAccountPage();
    }

    @Step
    public final CreateAccountPage invalidCreation() {

        clickTo(createButton);

        return this;
    }

    @Step
    public CreateAccountPage setInvalidEmail() {

        fillInputAs(emailInput, invalidEmail);

        return this;
    }

    @Step
    public final void setPhoneCodeAs(final String countryPhoneCode) {

        fillInputAs(phoneInput, countryPhoneCode);
    }
}
