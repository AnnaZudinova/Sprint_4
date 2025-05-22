import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjectModel.MainPage;
import pageObjectModel.OrderPage;

import static org.junit.Assert.assertEquals;

public class OrderButtonsTests {
    @Test
    public void testUpperOrderButtonInChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.clickUpperOrderButton();

        OrderPage orderPageObj = new OrderPage(driver);
        assertEquals(true, orderPageObj.isOrderFormAvailable());

        driver.quit();
    }
    @Test
    public void testLowerOrderButtonInChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.clickLowerOrderButton();

        OrderPage orderPageObj = new OrderPage(driver);
        assertEquals(true, orderPageObj.isOrderFormAvailable());

        driver.quit();
    }

    @Test
    public void testUpperOrderButtonInFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.clickUpperOrderButton();

        OrderPage orderPageObj = new OrderPage(driver);
        assertEquals(true, orderPageObj.isOrderFormAvailable());

        driver.quit();
    }
    @Test
    public void testLowerOrderButtonInFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.clickLowerOrderButton();

        OrderPage orderPageObj = new OrderPage(driver);
        assertEquals(true, orderPageObj.isOrderFormAvailable());

        driver.quit();
    }
}
