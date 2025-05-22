import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObjectModel.MainPage;
import pageObjectModel.OrderPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderFormTests {
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

    @Parameterized.Parameters
    public static Object[][] getUserData() {
        return new Object[][]{
                {"Олег", "Вещий", "Москва, Красная площадь, дом 4", "Сокол", "89997776655", "11.12.2025", "сутки", "серый", "К 12 часам"},
                {"Александра", "Николевич", "Москва, Литейная улица, д.25, кв.15","Владыкино", "+73335557744", "19.08.25", "двое суток", "черный", ""},
        };
    }

    @Test
    public void testOrderInFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.clickUpperOrderButton();

        OrderPage orderPageObj = new OrderPage(driver);
        orderPageObj.submitOrder(name,surname,address,metroStation,phoneNumber,date,rentalPeriod,color,comment);

        assertEquals(true, orderPageObj.checkOrderInfoAppearance());


        driver.quit();

    }

    @Test
    public void testOrderInChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.clickUpperOrderButton();

        OrderPage orderPageObj = new OrderPage(driver);
        orderPageObj.submitOrder(name,surname,address,metroStation,phoneNumber,date,rentalPeriod,color,comment);

        assertEquals(true, orderPageObj.checkOrderInfoAppearance());

        driver.quit();
    }


}
