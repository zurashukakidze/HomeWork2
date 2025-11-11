import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTests extends BaseTest {

    private final String FIRST_NAME = "Zura";
    private final String LAST_NAME = "Shukakidze";
    private final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;
    private final String EMAIL = "zura@example.com";
    private final String GENDER = "Male";
    private final String MOBILE = "5595424567";
    private final String SUBJECT = "Maths";
    private final String HOBBY = "Sports";
    private final String ADDRESS = "Tbilisi, Georgia";

    private final By GENDER_LOCATOR = By.xpath("//label[text()='" + GENDER + "']");
    private final By HOBBY_LOCATOR = By.xpath("//label[text()='" + HOBBY + "']");
    private final By SUBMIT_BUTTON_LOCATOR = By.id("submit");
    private final By MODAL_LOCATOR = By.className("modal-content");
    private final By MODAL_CLOSE_LOCATOR = By.id("closeLargeModal");

    @Test
    public void formSubmissionAndAssertionTest() {
        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("firstName")).sendKeys(FIRST_NAME);
        driver.findElement(By.id("lastName")).sendKeys(LAST_NAME);
        driver.findElement(By.id("userEmail")).sendKeys(EMAIL);


        waitForElementToBeClickable(GENDER_LOCATOR).click();

        driver.findElement(By.id("userNumber")).sendKeys(MOBILE);

        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
        subjectInput.sendKeys(SUBJECT);
        subjectInput.sendKeys("\n");

        waitForElementToBeClickable(HOBBY_LOCATOR).click();

        driver.findElement(By.id("currentAddress")).sendKeys(ADDRESS);

        WebElement submitButton = driver.findElement(SUBMIT_BUTTON_LOCATOR);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100)");

        submitButton.click();

        WebElement modal = waitForElementToBeVisible(MODAL_LOCATOR);
        String modalText = modal.getText();

        Assert.assertTrue(modal.isDisplayed(), "The submission confirmation modal is not displayed.");

        Assert.assertTrue(modalText.contains(FULL_NAME), "Assertion Failed: Name (" + FULL_NAME + ") not found.");
        Assert.assertTrue(modalText.contains(EMAIL), "Assertion Failed: Email (" + EMAIL + ") not found.");
        Assert.assertTrue(modalText.contains(GENDER), "Assertion Failed: Gender (" + GENDER + ") not found.");
        Assert.assertTrue(modalText.contains(MOBILE), "Assertion Failed: Mobile (" + MOBILE + ") not found.");
        Assert.assertTrue(modalText.contains(SUBJECT), "Assertion Failed: Subject (" + SUBJECT + ") not found.");
        Assert.assertTrue(modalText.contains(ADDRESS), "Assertion Failed: Address (" + ADDRESS + ") not found.");
        Assert.assertTrue(modalText.contains(HOBBY), "Assertion Failed: Hobby (" + HOBBY + ") not found.");


        waitForElementToBeClickable(MODAL_CLOSE_LOCATOR).click();
    }
}