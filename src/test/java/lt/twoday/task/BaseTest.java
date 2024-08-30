package lt.twoday.task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
