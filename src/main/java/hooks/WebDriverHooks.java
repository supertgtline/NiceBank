package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import support.KnowsTheDomain;

public class WebDriverHooks {
    private KnowsTheDomain helper;

    public WebDriverHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @After
    public void finish(Scenario scenario) {
        try {
            byte[] screenshot =
                    helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            helper.getWebDriver().close();
        }
    }
}
