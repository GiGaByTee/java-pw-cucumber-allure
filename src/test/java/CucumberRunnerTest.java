
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(plugin = { "pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm" }, tags = "", features = "src/test/resources/feature")
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}