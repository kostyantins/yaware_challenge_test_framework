package util;

import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import enums.Browsers;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    // If U need some particular driver version use 'version()' method to set version U need
    private static ThreadLocal<WebDriver> driver;

    public static WebDriver getDriver() {
        return driver.get();
    }

    static void setDriver(final String browser, final String version, final String platform) throws MalformedURLException {

        if (driver == null) {

            final DesiredCapabilities capabilities = new DesiredCapabilities();

            final String remoteWebDriverUrl = PropertiesReader.getProperty("remote.webDriver.url");

            final String remote = PropertiesReader.getProperty("remote");
            final String propertyBrowser = PropertiesReader.getProperty("browser");

            final Browsers propertyBrowserTypeEnum = Browsers.valueOf(propertyBrowser.toUpperCase());
            final Browsers cmdBrowserTypeEnum = Browsers.valueOf(browser.toUpperCase());

            final boolean isRemote = Boolean.valueOf(remote);

            if (isRemote) {

                driver = new ThreadLocal<WebDriver>() {
                    @Override
                    protected WebDriver initialValue() {

                        capabilities
                                .setPlatform(Platform.extractFromSysProperty(platform));

                        capabilities
                                .setBrowserName(String.valueOf(browser));

                        capabilities
                                .setVersion(String.valueOf(version));

                        RemoteWebDriver remoteWebDriver = null;

                        try {
                            remoteWebDriver = new RemoteWebDriver(new URL(remoteWebDriverUrl), capabilities);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        return remoteWebDriver;
                    }
                };
            } else {

                if ("default".equals(browser)) {

                    switch (propertyBrowserTypeEnum) {  //Switching browser if using property

                        case CHROME:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    ChromeDriverManager.getInstance().setup();
                                    return new ChromeDriver();
                                }
                            };
                            break;

                        case CHROME_MAC:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    ChromeDriverManager.getInstance().setup();
                                    return new ChromeDriver();
                                }
                            };
                            break;

                        case EXPLORER:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    InternetExplorerDriverManager.getInstance().setup();
                                    return new InternetExplorerDriver();
                                }
                            };
                            break;

                        case SAFARI:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    return new SafariDriver();
                                }
                            };
                            break;

                        default:
                        case FIREFOX:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    FirefoxDriverManager.getInstance().setup();
                                    return new FirefoxDriver();
                                }
                            };
                            break;
                    }
                } else {
                    switch (cmdBrowserTypeEnum) {  //Switching browser if using command line

                        case CHROME:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    ChromeDriverManager.getInstance().setup();

                                    return new ChromeDriver();
                                }
                            };
                            break;

                        case CHROME_MAC:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    ChromeDriverManager.getInstance().setup();
                                    return new ChromeDriver();
                                }
                            };
                            break;

                        case EXPLORER:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    InternetExplorerDriverManager.getInstance().setup();
                                    return new InternetExplorerDriver();
                                }
                            };
                            break;

                        case SAFARI:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    return new SafariDriver();
                                }
                            };
                            break;

                        default:
                        case FIREFOX:
                            driver = new ThreadLocal<WebDriver>() {
                                @Override
                                protected WebDriver initialValue() {
                                    FirefoxDriverManager.getInstance().setup();
                                    return new FirefoxDriver();
                                }
                            };
                            break;
                    }
                }
            }
        }
    }
}