package today.edu;

import today.edu.User;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue ="today.edu" )
public class testing {
    User u1= new User("haya","123","7\3\2004");
}