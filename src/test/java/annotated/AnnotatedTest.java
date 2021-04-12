package annotated;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedTest {
    private final static String REPOSITORY = "JMadam/qa_5_5";
    private WebSteps steps = new WebSteps();
    @Test
    @Owner("JMadam")
    @Feature("Main menu")
    @Story("Menu Issue")
    @DisplayName("AnnotatedTest. Menu 'Issue' in repository")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "BaseURL", url = "https://github.com")
    public void testSearch() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.clickOnIssueTab();
        steps.shouldSeeIssueWithWelcome();
    }
}
