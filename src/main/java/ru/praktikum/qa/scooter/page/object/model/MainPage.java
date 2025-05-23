package ru.praktikum.qa.scooter.page.object.model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private static By acceptCookiesButton = By.className("App_CookieButton__3cvqF");
    private static By upperOrderButton = By.className("Button_Button__ra12g");
    private static By lowerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    private static By importantQuestionsPanel = By.className("accordion");
    private static By priceQuestion = By.id("accordion__heading-0");
    private static By quantityQuestion = By.id("accordion__heading-1");
    private static By timeQuestion = By.id("accordion__heading-2");
    private static By deliveryDayQuestion = By.id("accordion__heading-3");
    private static By prolongationQuestion = By.id("accordion__heading-4");
    private static By chargerQuestion = By.id("accordion__heading-5");
    private static By orderCancellingQuestion = By.id("accordion__heading-6");
    private static By distanceQuestion = By.id("accordion__heading-7");
    private static By priceAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");
    private static By quantityAnswer = By.xpath(".//div[@id='accordion__panel-1']/p");
    private static By timeAnswer = By.xpath(".//div[@id='accordion__panel-2']/p");
    private static By deliveryDayAnswer = By.xpath(".//div[@id='accordion__panel-3']/p");
    private static By prolongationAnswer = By.xpath(".//div[@id='accordion__panel-4']/p");
    private static By chargerAnswer = By.xpath(".//div[@id='accordion__panel-5']/p");
    private static By orderCancellingAnswer = By.xpath(".//div[@id='accordion__panel-6']/p");
    private static By distanceAnswer = By.xpath(".//div[@id='accordion__panel-7']/p");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookiesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        driver.findElement(acceptCookiesButton).click();
    }

    public void goToAccordionPanel() {
        WebElement element = driver.findElement(importantQuestionsPanel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickUpperOrderButton() {

        driver.findElement(upperOrderButton).click();
    }

    public void clickLowerOrderButton() {

        driver.findElement(lowerOrderButton).click();
    }

    public void clickQuestion(int i) {
        if (i == 0) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(priceQuestion));
            driver.findElement(priceQuestion).click();
        } else if (i == 1) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(quantityQuestion));
            driver.findElement(quantityQuestion).click();
        } else if (i == 2) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(timeQuestion));
            driver.findElement(timeQuestion).click();
        } else if (i == 3) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(deliveryDayQuestion));
            driver.findElement(deliveryDayQuestion).click();
        } else if (i == 4) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(prolongationQuestion));
            driver.findElement(prolongationQuestion).click();
        } else if (i == 5) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(chargerQuestion));
            driver.findElement(chargerQuestion).click();
        } else if (i == 6) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(orderCancellingQuestion));
            driver.findElement(orderCancellingQuestion).click();
        } else if (i == 7) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(distanceQuestion));
            driver.findElement(distanceQuestion).click();
        }
    }

    public String getAnswerText(int i) {
        if (i == 0) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(priceAnswer));
            return driver.findElement(priceAnswer).getText();
        } else if (i == 1) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(quantityAnswer));
            return driver.findElement(quantityAnswer).getText();
        } else if (i == 2) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(timeAnswer));
            return driver.findElement(timeAnswer).getText();
        } else if (i == 3) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(deliveryDayAnswer));
            return driver.findElement(deliveryDayAnswer).getText();
        } else if (i == 4) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(prolongationAnswer));
            return driver.findElement(prolongationAnswer).getText();
        } else if (i == 5) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(chargerAnswer));
            return driver.findElement(chargerAnswer).getText();
        } else if (i == 6) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(orderCancellingAnswer));
            return driver.findElement(orderCancellingAnswer).getText();
        } else if (i == 7) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(distanceAnswer));
            return driver.findElement(distanceAnswer).getText();
        } else return "0";
    }
}
