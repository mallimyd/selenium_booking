package TestSteps;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = {"src/main/resources/Features"},
 glue={"TestSteps"},
 monochrome = true,
 dryRun = false,
// strict = true,
 plugin = {"pretty", "json:target/cucumer.json"}
 )
 
public class TestRunner {
 
}