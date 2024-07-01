package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue={"StepDefinitions"},
        plugin = {"json:target/cucumber/cucumber.json" } //ssssssss
        

)

public class SmokeTest extends AbstractTestNGCucumberTests{


    }
