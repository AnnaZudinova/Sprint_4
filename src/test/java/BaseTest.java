import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public class BaseTest {
        protected WebDriver driver;

        public void startChrome () {
            driver = new ChromeDriver();
    }
        public void startFirefox () {
            driver = new FirefoxDriver();
        }
}
