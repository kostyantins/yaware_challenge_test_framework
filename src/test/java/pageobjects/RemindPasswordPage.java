package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Getter
public class RemindPasswordPage extends AbstractPageObject {

    //element to check right navigation to RemindPasswordPage
    @Name("Remind password button")
    @FindBy(id = "remind-password-submit")
    private Button remindPassButton;

    //element to check if Email mask is displayed
    @Name("Email input field")
    @FindBy(id = "remindEmail")
    public static TextInput emailInput;
}
