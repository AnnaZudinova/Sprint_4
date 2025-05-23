import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.qa.scooter.page.object.model.MainPage;
import ru.praktikum.qa.scooter.page.object.model.OrderPage;
import static org.junit.Assert.assertEquals;

public class OrderButtonsTests extends BaseTest{

    @Before
    public void startUp() {
        startChrome();
        // Метод для запуска в Firefox:
        //startFirefox();
    }
    @Test
    public void testUpperOrderButton() {
        driver.get(MainPage.URL);

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.clickUpperOrderButton();

        OrderPage orderPageObj = new OrderPage(driver);
        assertEquals(true, orderPageObj.isOrderFormAvailable());
    }
    @Test
    public void testLowerOrderButton() {
        driver.get(MainPage.URL);

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.clickLowerOrderButton();

        OrderPage orderPageObj = new OrderPage(driver);
        assertEquals(true, orderPageObj.isOrderFormAvailable());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
