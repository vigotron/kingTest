import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},
        plugin = { "pretty", "pretty:target/testResults/report.txt ",
                "json:target/testResults/report.json",
                "html:target/testResults/resultsHtml",
                "junit:target/testResults/report.xml"},
        tags = {"@Kingtest"},
        monochrome = true
)
public class TestRunner {
}