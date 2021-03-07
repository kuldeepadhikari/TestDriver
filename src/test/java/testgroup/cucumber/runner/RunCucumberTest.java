
package testgroup.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features ="classpath:featurefiles",
        glue="testgroup.cucumber.steps"
)
public class RunCucumberTest {
}