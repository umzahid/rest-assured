package Runner;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import static io.cucumber.core.options.Constants.*;


@Suite
@RunWith(SerenityRunner.class)
@IncludeEngines("cucumber")
@SelectClasspathResource("features/example.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "test")
public class testRunner {

}