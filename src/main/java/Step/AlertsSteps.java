package Step;

import Pages.AlertsPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AlertsSteps {

    private final WebDriver driver;
    private final AlertsPage page;

    public AlertsSteps(WebDriver driver) {
        this.driver = driver;
        this.page = new AlertsPage();
    }

    public AlertsSteps openAlertsPage() {
        driver.get("https://demo.automationtesting.in/Alerts.html");
        return this;
    }

    public AlertsSteps openAlertWithTextboxTab() {
        driver.findElement(page.ALERT_WITH_TEXTBOX_TAB).click();
        return this;
    }

    public AlertsSteps triggerTextboxAlert() {
        driver.findElement(page.ALERT_BUTTON).click();
        return this;
    }

    public AlertsSteps enterTextAndAcceptAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        return this;
    }

    public AlertsSteps assertResultContains(String expectedText) {
        String result = driver.findElement(page.RESULT_TEXT).getText();
        Assert.assertTrue(
                result.contains(expectedText),
                "Result does not contain expected text: " + expectedText
        );
        return this;
    }
}
