package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static final String BASE_URL = "https://github.com";
    protected static final String REPOSITORY = "eroshenkoam/allure-example";
    protected static final int ISSUE_NUMBER = 68;

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
}
