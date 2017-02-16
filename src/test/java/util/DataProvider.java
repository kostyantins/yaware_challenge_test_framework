package util;

import java.io.IOException;

import static enums.Languages.*;
import static enums.PageToGo.CREATE_ACCOUNT_PAGE;
import static enums.PageToGo.REMIND_PASS_PAGE;
import static enums.PageToGoConfirmElements.CREATE_BUTTON;
import static enums.PageToGoConfirmElements.REMIND_PASS_BUTTON;
import static util.ExcelReader.getExcelData;
import static util.PropertiesReader.getProperty;

public class DataProvider {

    private final static String EXCEL_FILE = getProperty("excel.date");

    private DataProvider() {
    }

    @org.testng.annotations.DataProvider
    public static Object[][] testInvalidDataLogIn() {
        return new Object[][]{
                {"xxxxx@ukr.net", "qwerty"},
                {"kostyantins@mail.ru", "123456"},
                {"1234567890@mail.ru", "1q2w3e4r"},
                {"", ""},
                {"@#$!%^&*(){}|", "!@#$%^&*()_{}"},
                {"kostyantins@mail.ru", ""},
                {"", "qwerty"},
                {"qwetryfufjcnbdhg", "qyetrgdbxvdferstahxneuyd"},
                {"132445566778890", "122324354556576879"}
        };
    }

    @org.testng.annotations.DataProvider
    public static Object[][] testLanguageData() {
        return new Object[][]{
                {ENGLISH, "First time here?"},
                {RUSSIAN, "Впервые здесь?"},
                {UKRAINE, "Вперше тут?"},
                {FRANCE, "Première fois ici ?"}
        };
    }

    @org.testng.annotations.DataProvider
    public static Object[][] testNavigateData() {
        return new Object[][]{
                {CREATE_ACCOUNT_PAGE, CREATE_BUTTON},
                {REMIND_PASS_PAGE, REMIND_PASS_BUTTON}
        };
    }

    @org.testng.annotations.DataProvider
    public static Object[][] loginData() throws IOException {
        return getExcelData(EXCEL_FILE, "sheet1");
    }
}
