package Step;

import Pages.FormsPages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FormPagesSteps {

    private final WebDriver driver;
    private final FormsPages page;

    public FormPagesSteps(WebDriver driver) {
        this.driver = driver;
        this.page = new FormsPages();
    }

    public FormPagesSteps openForm() {
        driver.get("https://demoqa.com/automation-practice-form");
        return this;
    }

    public FormPagesSteps fillName(String firstName, String lastName) {
        driver.findElement(page.FIRST_NAME).sendKeys(firstName);
        driver.findElement(page.LAST_NAME).sendKeys(lastName);
        return this;
    }

    public FormPagesSteps fillEmail(String email) {
        driver.findElement(page.EMAIL).sendKeys(email);
        return this;
    }

    public FormPagesSteps selectGender(String gender) {
        driver.findElement(page.gender(gender)).click();
        return this;
    }

    public FormPagesSteps fillMobile(String mobile) {
        driver.findElement(page.MOBILE).sendKeys(mobile);
        return this;
    }

    public FormPagesSteps addSubject(String subject) {
        WebElement input = driver.findElement(page.SUBJECT);
        input.sendKeys(subject);
        input.sendKeys("\n");
        return this;
    }

    public FormPagesSteps selectHobby(String hobby) {
        driver.findElement(page.hobby(hobby)).click();
        return this;
    }

    public FormPagesSteps fillAddress(String address) {
        driver.findElement(page.ADDRESS).sendKeys(address);
        return this;
    }

    public FormPagesSteps submitForm() {
        WebElement submit = driver.findElement(page.SUBMIT);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();
        return this;
    }

    public FormPagesSteps assertModalData(
            String fullName,
            String email,
            String gender,
            String mobile,
            String subject,
            String hobby,
            String address
    ) {
        WebElement modal = driver.findElement(page.MODAL);
        String text = modal.getText();

        Assert.assertTrue(modal.isDisplayed());
        Assert.assertTrue(text.contains(fullName));
        Assert.assertTrue(text.contains(email));
        Assert.assertTrue(text.contains(gender));
        Assert.assertTrue(text.contains(mobile));
        Assert.assertTrue(text.contains(subject));
        Assert.assertTrue(text.contains(hobby));
        Assert.assertTrue(text.contains(address));

        return this;
    }

    public FormPagesSteps closeModal() {
        driver.findElement(page.MODAL_CLOSE).click();
        return this;
    }
}
