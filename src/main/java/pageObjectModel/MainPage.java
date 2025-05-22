package pageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    private static By acceptCookiesButton = By.className("App_CookieButton__3cvqF");
    private static By upperOrderButton = By.className("Button_Button__ra12g");
    private static By lowerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    private static By importantQuestionsPanel = By.className("accordion");
    private static By firstQuestion = By.id("accordion__heading-0");
    private static By secondQuestion = By.id("accordion__heading-1");
    private static By thirdQuestion = By.id("accordion__heading-2");
    private static By fourthQuestion = By.id("accordion__heading-3");
    private static By fifthQuestion = By.id("accordion__heading-4");
    private static By sixthQuestion = By.id("accordion__heading-5");
    private static By seventhQuestion = By.id("accordion__heading-6");
    private static By eighthQuestion = By.id("accordion__heading-7");
    private static By firstAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");
    private static By secondAnswer = By.xpath(".//div[@id='accordion__panel-1']/p");
    private static By thirdAnswer = By.xpath(".//div[@id='accordion__panel-2']/p");
    private static By fourthAnswer = By.xpath(".//div[@id='accordion__panel-3']/p");
    private static By fifthAnswer = By.xpath(".//div[@id='accordion__panel-4']/p");
    private static By sixthAnswer = By.xpath(".//div[@id='accordion__panel-5']/p");
    private static By seventhAnswer = By.xpath(".//div[@id='accordion__panel-6']/p");
    private static By eighthAnswer = By.xpath(".//div[@id='accordion__panel-7']/p");

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookiesButton () {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        driver.findElement(acceptCookiesButton).click();
    }
    public void goToAccordionPanel() {
        WebElement element = driver.findElement(importantQuestionsPanel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickUpperOrderButton() {

        driver.findElement(upperOrderButton).click();
    }
    public void clickLowerOrderButton() {

        driver.findElement(lowerOrderButton).click();
    }
    public static By getFirstQuestion () {
        return firstQuestion;
    }
    public static By getSecondQuestion () {
        return secondQuestion;
    }
    public static By getThirdQuestion () {
        return thirdQuestion;
    }
    public static By getFourthQuestion () {
        return fourthQuestion;
    }
    public static By getFifthQuestion () {
        return fifthQuestion;
    }
    public static By getSixthQuestion () {
        return sixthQuestion;
    }
    public static By getSeventhQuestion () {
        return seventhQuestion;
    }
    public static By getEighthQuestion () {
        return eighthQuestion;
    }
    public static By getFirstAnswer() {
        return firstAnswer;
    }
    public static By getSecondAnswer() {
        return secondAnswer;
    }
    public static By getThirdAnswer() {
        return thirdAnswer;
    }
    public static By getFourthAnswer() {
        return fourthAnswer;
    }
    public static By getFifthAnswer() {
        return fifthAnswer;
    }
    public static By getSixthAnswer() {
        return sixthAnswer;
    }
    public static By getSeventhAnswer() {
        return seventhAnswer;
    }
    public static By getEighthAnswer() {
        return eighthAnswer;
    }
    public void clickOnQuestion (By question) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(question));
        driver.findElement(question).click();
    }
    public String getAnswerText (By answer) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(answer));
       return driver.findElement(answer).getText();
    }
    }
