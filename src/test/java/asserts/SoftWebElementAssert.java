package asserts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Step;

public class SoftWebElementAssert extends SoftAssert {

    private WebElement actual;

    private SoftWebElementAssert(final WebElement actual) {
        this.actual = actual;
    }

    public static final SoftWebElementAssert assertThat(final WebElement actual) {

        return new SoftWebElementAssert(actual);
    }

    @Step
    private final SoftWebElementAssert isNotNull() {

        if (actual == null) {
            Assert.fail("Element should be not null");
        }
        return this;
    }

    @Step
    public final SoftWebElementAssert hasMaskLike(final String mask) {

        isNotNull();

        assertEquals(actual.getAttribute("placeholder"), mask);

        assertAll();

        return this;
    }
}
