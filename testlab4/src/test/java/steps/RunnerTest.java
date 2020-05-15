package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
         features = "src/test/resources/"
        // glue = "src/test/java/steps"
)
public class RunnerTest {
}

