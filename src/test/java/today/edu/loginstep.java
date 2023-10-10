package today.edu;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginstep {
    public MyAppT obj;
    public boolean f;

    // Dpendency injection
    public loginstep(MyAppT iobj) {
        super();
        this.obj = iobj;
    }

    @Given("I am not in system")
    public void iAmNotInSystem()
    {

        assertTrue(!obj.isLogedin);
    }

    @When("set username {string} and pass {string} and pass from system")
    public void setUsernameAndPassAndPassFromSystem(String user_name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        f=false;
        for (User u: obj.up) {

            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                f = true;
                break;
            }
        }

        assertTrue(f);
    }
    @Then("login succeed")
    public void loginSucceed() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertTrue("Login should succeed", f);
    }

    @Then("login failed")
    public void loginFailed() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertFalse("Login should fail", f);
    }

    @When("set invalid username {string} and pass {string}")
    public void setInvalidUsernameAndPass(String user_name, String pass) {
        // Write code here that turns the phrase above into concrete actions
         f=false;
        for (User u: obj.up) {

            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                f = true;
                break;
            }
        }

        assertFalse(f);
    }


    @When("set valid username {string} and invalid pass {string}")
    public void setValidUsernameAndInvalidPass(String user_name, String pass) {
        f=false;
        for (User u: obj.up) {

            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                f = true;
                break;
            }
        }

        assertFalse(f);
    }

    @When("set empty username {string} and pass {string}")
    public void setEmptyUsernameAndPass(String user_name, String pass) {
        f=false;

        if (user_name.isEmpty())
            f = true;

        assertTrue(f);
    }


    @When("set valid username {string} and empty pass {string}")
    public void setValidUsernameAndEmptyPass(String user_name, String pass) {
        f=false;

        if (pass.isEmpty())
            f = true;

        assertTrue(f);
    }
}

