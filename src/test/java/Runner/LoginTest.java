package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@LoginTest",
        features = {"src/test/java/FeatureFiles"},
        glue={"StepDefinitions"},
        plugin = {"json:target/cucumber/cucumber.json" }

)

public class LoginTest extends AbstractTestNGCucumberTests{


    }
