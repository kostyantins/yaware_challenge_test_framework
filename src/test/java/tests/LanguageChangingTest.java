package tests;

import enums.Languages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import util.DataProvider;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.LogInPage.language;


public class LanguageChangingTest extends TestRunner {

    @Test(dataProvider = "testLanguageData", dataProviderClass = DataProvider.class)
    public final void testLanguageChanging(final Languages someLanguage, final String setLanguage) {

        logInPage
                .changLanguage(someLanguage);

        assertThat(language).isChangedAs(setLanguage);

    }

    @AfterMethod
    public final void tarnLanguageBack(){

        logInPage
                .setEnglishLanguage();
    }
}
