package posters.cucumber.support;

import com.xceptance.neodymium.util.WebDriverUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class DriverHooks
{
    @Given("^\"([^\"]*)\" is open$")
    public static void setUp(final String browserProfileName)
    {
        WebDriverUtils.setUp(browserProfileName);
    }

    @Before("@WebDriverSetUpViaBrowserProfileName")
    public static void setUp(Scenario scenario)
    {
        WebDriverUtils.setUpWithBrowserTag(scenario);
    }

    // have a lower order number than default in order to shut down the driver after
    // the test case specific after hooks
    @After(order = 100)
    public void tearDown(Scenario scenario)
    {
        WebDriverUtils.tearDown(scenario);
    }
}
