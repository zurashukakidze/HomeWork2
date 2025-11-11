
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {

    @Test
    public void testAlertWithTextbox() {

        driver.get("https://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'demo')]")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Name Surname");
        alert.accept();

        String result = driver.findElement(By.id("demo1")).getText();
        Assert.assertTrue(result.contains("Name Surname"));
    }
}
