package test;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps extends BaseTest {

    @Step("Открываем страницу " + BASE_URL)
    void openMainPage() {
        open(BASE_URL);
    }

    @Step("Ищем репозиторий " + REPOSITORY)
    void searchForRepository() {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий " + REPOSITORY)
    void goToRepository() {
        $(By.linkText(REPOSITORY)).click();
    }

    @Step("Открываем Issues")
    void openIssue() {
        $(withText("Issues")).click();
    }

    @Step("Проверяем, что существует Issues с номером " + ISSUE_NUMBER)
    void shouldSeeIssueWithNumber() {
        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    }


}
