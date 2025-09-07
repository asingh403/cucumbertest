package runner;

import io.cucumber.testng.CucumberOptions.SnippetType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.opencart.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "junit:target/cucumber-junit.xml",
                "rerun:target/rerun.txt",
                "timeline:target/timeline"
        },
        tags = "@regression",
        monochrome = true,
        publish = true,
        dryRun = false,
        snippets = SnippetType.CAMELCASE
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){

        return super.scenarios();
    }
}
