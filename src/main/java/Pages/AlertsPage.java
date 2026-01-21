package Pages;

import org.openqa.selenium.By;

public class AlertsPage {


    public final By ALERT_WITH_TEXTBOX_TAB =
            By.xpath("//a[text()='Alert with Textbox ']");


    public final By ALERT_BUTTON =
            By.xpath("//button[contains(text(),'demo')]");


    public final By RESULT_TEXT =
            By.id("demo1");
}
