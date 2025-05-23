import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.qa.scooter.page.object.model.MainPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImportantQuestionsTests extends BaseTest{
    private int locatorId;
    private String expectedAnswer;
    private static final String EXPECTED_PRICE_ANSWER="Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String EXPECTED_QUANTITY_ANSWER="Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String EXPECTED_TIME_ANSWER="Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String EXPECTED_DELIVERY_ANSWER="Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String EXPECTED_PROLONGATION_ANSWER="Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String EXPECTED_CHARGER_ANSWER="Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String EXPECTED_ORDER_CANCELLING_ANSWER="Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String EXPECTED_DISTANCE_ANSWER="Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public ImportantQuestionsTests(int locatorId, String expectedAnswer) {
        this.locatorId = locatorId;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters(name="Тестовые данные:{0},{1},{2},{3},{4},{5},{6},{7}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {0, EXPECTED_PRICE_ANSWER},
                {1, EXPECTED_QUANTITY_ANSWER},
                {2, EXPECTED_TIME_ANSWER},
                {3, EXPECTED_DELIVERY_ANSWER},
                {4, EXPECTED_PROLONGATION_ANSWER},
                {5, EXPECTED_CHARGER_ANSWER},
                {6, EXPECTED_ORDER_CANCELLING_ANSWER},
                {7, EXPECTED_DISTANCE_ANSWER},
        };
    }

    @Before
    public void startUp() {
        startChrome();
        // Метод для запуска в Firefox:
        //startFirefox();
    }

    @Test
    public void testImportantQuestions() {
        driver.get(MainPage.URL);

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.goToAccordionPanel();
        mainPageObj.clickQuestion(locatorId);
        assertEquals(expectedAnswer, mainPageObj.getAnswerText(locatorId));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
