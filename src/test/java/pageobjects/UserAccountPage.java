package pageobjects;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

@Getter
public class UserAccountPage extends AbstractPageObject {

    //field to check if user logIn, static caused easier to read Assert
    @Name("User initials")
    @FindBy(xpath = "//*[@id='container']//header//ul/li[1]//p[1]")
    @Timeout(30)
    public static HtmlElement user;

    @Name("Logout link")
    @FindBy(xpath = "(//*[@id='container']//ul/li[4]/a)[8]")
    @Timeout(30)
    private Link logOutLink;
}
