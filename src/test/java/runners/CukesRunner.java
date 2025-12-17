package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "",
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Raporlama ayarı
)
public class CukesRunner extends AbstractTestNGCucumberTests {
}


