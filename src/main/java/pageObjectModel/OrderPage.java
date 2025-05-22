package pageObjectModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    private By orderFormHeader = By.className("Order_Header__BZXOb");
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationField = By.className("select-search__input");
    private By metroOption = By.xpath(".//button[@class='Order_SelectOption__82bhS select-search__option']");
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By furtherButton = By.xpath(".//button[text()='Далее']");
    private By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.className("Dropdown-placeholder");
    private By oneDayRent = By.xpath(".//div[text()='сутки']");
    private By twoDaysRent = By.xpath(".//div[text()='двое суток']");
    private By blackColorCheckbox = By.id("black");
    private By greyColorCheckbox = By.id("grey");
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By makeOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By yesButton = By.xpath(".//button[text()='Да']");
    private By orderInfoWindow = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderFormAvailable() {
        return driver.findElement(orderFormHeader).isDisplayed();
    }
    public void fillName (String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void fillSurname (String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void fillAddress (String address) {

        driver.findElement(addressField).sendKeys(address);
    }
    public void fillMetro (String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation);
        driver.findElement(metroOption).click();
    }
    public void fillPhone (String phoneNumber) {

        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    public void clickFurther () {

        driver.findElement(furtherButton).click();
    }
    public void fillDate (String date) {

        driver.findElement(deliveryDateField).sendKeys(date);
        driver.findElement(deliveryDateField).sendKeys(Keys.RETURN);

    }
    public void chooseRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        if (rentalPeriod=="сутки") {
            driver.findElement(oneDayRent).click();
        } else {
            driver.findElement(twoDaysRent).click();
        }
    }
    public void chooseColor (String color) {
        if (color == "серый") {
            driver.findElement(greyColorCheckbox).click();
        } else {
            driver.findElement(blackColorCheckbox).click();
        }
    }
    public void fillComment (String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickMakeOrder () {
        driver.findElement(makeOrderButton).click();
    }
    public void waitForYesButtonToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(yesButton));
        }
    public void clickYes () {
        driver.findElement(yesButton).click();
    }
    public void waitForOrderInfoToBeVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderInfoWindow));
    }
    public boolean checkOrderInfoAppearance () {
        return driver.findElement(orderInfoWindow).isDisplayed();
    }
    public void submitOrder (String name, String surname, String address, String metroStation, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        fillName(name);
        fillSurname(surname);
        fillAddress(address);
        fillMetro(metroStation);
        fillPhone(phoneNumber);
        clickFurther();
        fillDate(date);
        chooseRentalPeriod(rentalPeriod);
        chooseColor(color);
        fillComment(comment);
        clickMakeOrder();
        waitForYesButtonToBeClickable();
        clickYes();
        waitForOrderInfoToBeVisible();
    }

}


