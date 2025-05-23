import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.qa.scooter.page.object.model.MainPage;
import ru.praktikum.qa.scooter.page.object.model.OrderPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderFormTests extends BaseTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderFormTests(String name, String surname, String address, String metroStation, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters(name="Тестовые данные: {0},{1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Олег", "Вещий", "Москва, Красная площадь, дом 4", "Сокол", "89997776655", "11.12.2025", "сутки", "серый", "К 12 часам"},
                {"Александра", "Николевич", "Москва, Литейная улица, д.25, кв.15","Владыкино", "+73335557744", "19.08.25", "двое суток", "черный", ""}
        };
    }

    @Before
    public void startUp() {
        startChrome();
        //Метод для запуска в Firefox:
        //startFirefox();
    }
    @Test
    public void testOrder() {
        driver.get(MainPage.URL);

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.clickUpperOrderButton();

        OrderPage orderPageObj = new OrderPage(driver);
        orderPageObj.submitOrder(name,surname,address,metroStation,phoneNumber,date,rentalPeriod,color,comment);

        assertEquals(true, orderPageObj.checkOrderInfoAppearance());

    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
