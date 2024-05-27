package Runner;
import com.aventstack.extentreports.service.ExtentService; //bunu neden aktive edemiyorum?
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // aşağıdaki bütün testlerden @SmokeTest tag i olanları çalıştır
        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue={"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html",
     "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class SmokeTest extends AbstractTestNGCucumberTests{




}
