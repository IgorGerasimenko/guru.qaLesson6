package Tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestWithStepsAnnotations extends BaseTest {
    @Test
    void testIssueSearchWithLambdaStepsNoHardCode() {
        step("Открываем страницу" + BASE_URL, () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий" + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(By.linkText(REPOSITORY)).click();
        });
        step("Открываем Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Проверяем, что существует Issues с номером" + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}
