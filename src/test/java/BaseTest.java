import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    // Protected WebDriverWait object for explicit waits in derived classes
    protected WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Setup implicit and explicit waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // 15 seconds explicit timeout

        driver.manage().window().maximize();
    }

    // Utility method: Waits for an element to be clickable
    protected WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Utility method: Waits for an element to be visible
    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}