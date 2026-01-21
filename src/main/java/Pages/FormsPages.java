package Pages;

import org.openqa.selenium.By;

public class FormsPages {

    public final By FIRST_NAME = By.id("firstName");
    public final By LAST_NAME = By.id("lastName");
    public final By EMAIL = By.id("userEmail");
    public final By MOBILE = By.id("userNumber");
    public final By SUBJECT = By.id("subjectsInput");
    public final By ADDRESS = By.id("currentAddress");

    public By gender(String gender) {
        return By.xpath("//label[text()='" + gender + "']");
    }

    public By hobby(String hobby) {
        return By.xpath("//label[text()='" + hobby + "']");
    }

    public final By SUBMIT = By.id("submit");
    public final By MODAL = By.className("modal-content");
    public final By MODAL_CLOSE = By.id("closeLargeModal");
}
