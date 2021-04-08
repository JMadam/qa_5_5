package lambda;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "JMadam/qa_5_5";

    @Test
    @Owner("JMadam")
    @Feature("Main menu")
    @Story("Menu Issue")
    @DisplayName("Lambda test.Menu 'Issue' in repository")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "BaseURL", url = "https://github.com")


    public void searchForIssue() {
        step("Open Main Page", (step) -> {
            step.parameter("url", BASE_URL);
            open(BASE_URL);
        });

        step("Search Repository", (step) -> {
            step.parameter("repository", REPOSITORY);
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Go to Repository", () -> $(By.linkText(REPOSITORY)).click());

        step("Click on Issue Tab", () -> $(withText("Issues")).click());

        step("Check text welcome", (step) -> {
            step.parameter("Expected result", "Welcome to issues!");

            $(".blankslate h3").shouldHave(text("Welcome to issues!"));
        });
    }
}
