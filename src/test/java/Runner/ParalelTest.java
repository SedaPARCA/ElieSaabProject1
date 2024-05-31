package Runner;
import StepDefinitions.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        // aşağıdaki bütün testlerden @SmokeTest tag i olanları çalıştır
        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue={"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" } // cucumber report
        //
        // html:target/site/cucumber-pretty.html
       //pretty","json:target/cucumber/cucumber.json jenkins için
       // "html:target/cucumber-reports.html" // basit rapor.
      //  "",
)

public class ParalelTest extends AbstractTestNGCucumberTests{





}
