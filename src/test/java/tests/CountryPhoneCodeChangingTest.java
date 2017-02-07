package tests;

import org.testng.annotations.Test;
import util.TestRunner;

import static asserts.WebElementAsserts.assertThat;
import static pageobjects.CreateAccountPage.countryFlagDropdown;

public class CountryPhoneCodeChangingTest extends TestRunner {

    //TODO use DataProvider to check all countries phone code, also use constants to fill or/and check code: USA=1
    @Test
    public final void testCountryPhoneCodeChanging() {

        logInPage
                .openCreateAccountPage()
                .setPhoneCodeAs("1");

        assertThat(countryFlagDropdown).isChangedOn("United States: +1");
    }
}
