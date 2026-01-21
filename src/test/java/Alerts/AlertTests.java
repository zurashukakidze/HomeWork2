package Alerts;

import Base.BaseTest;
import Step.AlertsSteps;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {

    @Test
    public void testAlertWithTextbox() {

        new AlertsSteps(driver)
                .openAlertsPage()
                .openAlertWithTextboxTab()
                .triggerTextboxAlert()
                .enterTextAndAcceptAlert("Name Surname")
                .assertResultContains("Name Surname");
    }
}
