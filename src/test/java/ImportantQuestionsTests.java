import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjectModel.MainPage;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ImportantQuestionsTests {
    private By question;
    private By answer;
    private String expectedAnswer;

    public ImportantQuestionsTests(By question, By answer, String expectedAnswer) {
        this.question = question;
        this.answer = answer;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {MainPage.getFirstQuestion(), MainPage.getFirstAnswer(), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.getSecondQuestion(), MainPage.getSecondAnswer(), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPage.getThirdQuestion(), MainPage.getThirdAnswer(), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPage.getFourthQuestion(), MainPage.getFourthAnswer(), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPage.getFifthQuestion(), MainPage.getFifthAnswer(), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPage.getSixthQuestion(), MainPage.getSixthAnswer(), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPage.getSeventhQuestion(), MainPage.getSeventhAnswer(), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPage.getEighthQuestion(), MainPage.getEighthAnswer(), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkImportantQuestionsInFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.goToAccordionPanel();
        mainPageObj.clickOnQuestion(question);
        assertEquals(expectedAnswer, mainPageObj.getAnswerText(answer));

        driver.quit();
    }

    @Test
    public void checkImportantQuestionsInChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPageObj = new MainPage(driver);
        mainPageObj.clickCookiesButton();
        mainPageObj.goToAccordionPanel();
        mainPageObj.clickOnQuestion(question);
        assertEquals(expectedAnswer, mainPageObj.getAnswerText(answer));

        driver.quit();
    }

}
