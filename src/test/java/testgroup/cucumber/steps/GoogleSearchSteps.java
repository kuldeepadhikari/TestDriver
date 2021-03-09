package testgroup.cucumber.steps;


import browserPages.GoogleHomePage;
import common.WebDriverFactory;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class GoogleSearchSteps implements En {
    WebDriver webDriver;
    GoogleHomePage googleHomePage;
    public GoogleSearchSteps() {
        Given("^I am on the Google search page$", () -> {
            webDriver=WebDriverFactory.createWebDriver();
            googleHomePage =new GoogleHomePage(webDriver);
        });

        When("^I search for \"([^\"]*)\"$", (String searchString) -> {
            googleHomePage.search(searchString);
        });

        Then("^the page title should start with \"([^\"]*)\"$", (String searchString) -> {
            assertEquals(true, googleHomePage.getHeader().toLowerCase().startsWith(searchString));
        });

    }


}
