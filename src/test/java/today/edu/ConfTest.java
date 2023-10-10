package today.edu;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)

@CucumberOptions(features = "features",
        plugin = { "summary", "html:target/cucumber"},
        monochrome=true,
        snippets = SnippetType.CAMELCASE,
        glue = "today.edu")


public class ConfTest {

}