package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;
import util.PropertiesReader;

@Getter
public class YourIdeasPage extends AbstractPageObject {

    @Name("Title input field")
    @FindBy(id = "ideaTitle")
    @Timeout(30)
    private TextInput titleInput;

    @Name("Description input field")
    @FindBy(id = "ideaSubject")
    @Timeout(30)
    private TextInput descriptionInput;

    @Name("Email input field")
    @FindBy(id = "ideaEmail")
    @Timeout(30)
    private TextInput emailInput;

    @Name("Email input field")
    @FindBy(id = "aha-submit")
    @Timeout(30)
    private Button createIdeaButton;

    //element to check if created idea is sent
    @Name("Thank you a lot header")
    @FindBy(id = "myModalLabel")
    @Timeout(30)
    public static TextBlock header;

    private String title = PropertiesReader.getProperty("title");
    private String description = PropertiesReader.getProperty("description");
    private String invalidEmail = PropertiesReader.getProperty("invalid.email");

    @Step
    public final YourIdeasPage setTitle() {

        fillInputAs(titleInput, title);

        return this;
    }

    @Step
    public final YourIdeasPage setDescription() {

        fillInputAs(descriptionInput, description);

        return this;
    }

    @Step
    public final YourIdeasPage setEmail() {

        fillInputAs(emailInput, invalidEmail);

        return this;
    }

    @Step
    public final YourIdeasPage createAnIdea() {

        clickTo(createIdeaButton);

        return this;
    }
}
