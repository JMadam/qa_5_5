package annotated;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WebSteps {
    private final String BASE_URL = "https://github.com";


    @Step("Open Main Page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step ("Search Repository {repository}")

    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Go to Repository {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Click on Issue Tab")
    public void clickOnIssueTab() {
        $(withText("Issues")).click();
    }


    @Step("Check text welcome")
    public void shouldSeeIssueWithWelcome() {
        $(".blankslate h3").shouldHave(text("Welcome to issues!"));

    }
}


