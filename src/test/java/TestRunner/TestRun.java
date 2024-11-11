package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "C:\\Users\\zaffar\\Downloads\\Amazon-20241010T064535Z-001\\Amazon\\Features\\",
        glue="StepDefinitions",
        tags="@zfr",
        dryRun = true,
        plugin= {"pretty", "html:C:/CucumberProject/Amazon/Reports/test-output.html"},
        monochrome = true
        //headed  = true
)

 public class TestRun {


}
