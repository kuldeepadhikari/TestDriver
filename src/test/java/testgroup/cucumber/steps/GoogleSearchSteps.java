package testgroup.cucumber.steps;


import browserPages.GoogleHomePage;
import common.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class GoogleSearchSteps {
    WebDriver webDriver;
    GoogleHomePage googleHomePage;

    @Given("^I am on the Google search page$")
    public void ImOnGoogleSearchPage()
    {
        webDriver=WebDriverFactory.createWebDriver();
        googleHomePage =new GoogleHomePage(webDriver);
    };

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String searchString)
    {
        googleHomePage.search(searchString);
    };

    @Then("^the page title should start with \"([^\"]*)\"$")
    public void thePageTitleShouldStartsWith(String searchString)
    {
        assertEquals(true, googleHomePage.getHeader().toLowerCase().startsWith(searchString));
    }

}
