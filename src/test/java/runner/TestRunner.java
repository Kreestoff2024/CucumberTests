package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/home/christophe/IdeaProjects/CucumberTests/src/test/resources/features/sendMessageEmptyFields.feature"},
        glue = {"StepDefinition"},
        plugin = {"pretty"},
        monochrome = true
)
public class TestRunner {
}
