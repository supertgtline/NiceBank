import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(plugin={"pretty", "html:out"}, snippets= CucumberOptions.SnippetType.CAMELCASE)
    public class RunCukesTest {
    }

