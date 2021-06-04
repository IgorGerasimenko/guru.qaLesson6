package test;

import org.junit.jupiter.api.Test;

public class TestWithStepsAnnotations extends BaseTest {

    Steps step = new Steps();

    @Test
    void testIssueSearchWithStepsAnnotations() {
        step.openMainPage();
        step.searchForRepository();
        step.goToRepository();
        step.openIssue();
        step.shouldSeeIssueWithNumber();
    }
}
