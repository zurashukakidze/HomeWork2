package Form;

import Base.BaseTest;
import Step.FormPagesSteps;
import org.testng.annotations.Test;

public class FormTests extends BaseTest {

    private final String FIRST_NAME = "Zura";
    private final String LAST_NAME = "Shukakidze";
    private final String EMAIL = "zura@example.com";
    private final String GENDER = "Male";
    private final String MOBILE = "5595424567";
    private final String SUBJECT = "Maths";
    private final String HOBBY = "Sports";
    private final String ADDRESS = "Tbilisi, Georgia";

    @Test
    public void formSubmissionAndAssertionTest() {

        new FormPagesSteps(driver)
                .openForm()
                .fillName(FIRST_NAME, LAST_NAME)
                .fillEmail(EMAIL)
                .selectGender(GENDER)
                .fillMobile(MOBILE)
                .addSubject(SUBJECT)
                .selectHobby(HOBBY)
                .fillAddress(ADDRESS)
                .submitForm()
                .assertModalData(
                        FIRST_NAME + " " + LAST_NAME,
                        EMAIL,
                        GENDER,
                        MOBILE,
                        SUBJECT,
                        HOBBY,
                        ADDRESS
                )
                .closeModal();
    }
}
