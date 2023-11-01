package today.edu;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import javax.swing.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import today.edu.MyAppT;
import today.edu.User;

import javax.swing.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class loginstep {
    public MyAppT obj;
    public boolean forget = false;

    public String enteredUsername;
    public String enteredPassword;
    // Dependency injection
    public loginstep(MyAppT iobj) {
        super();
        this.obj = iobj;
        User u1= new User("haya","123","7\3\2004");
        obj.up.add(u1);
        User u2= new User("Asma@gmail.com","1234","7\3\2004");
        obj.up.add(u2);
    }

    @Given("I am not in system")
    public void mmm()
    {
        //  obj.isLogged=false;
        obj.iAmNotInSystem(obj);
    }
    @When("set username {string} and pass {string}")
    public void setUsernameAndPassAndPassFromSystem(String user_name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        obj.setUsernameAndPassAndPassFromSystem(user_name,pass);
    }
    @Then("login succeed")
    public void loginSucceed() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertTrue("Login should succeed", obj.f);
    }
    @When("set invalid username {string} and pass {string}")
    public void setInvalidUsernameAndPass(String user_name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        obj.setInvalidUsernameAndPass(user_name,pass);
    }
    @Then("login failed")
    public void loginFailed() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertFalse("Login should fail", obj.f);
    }

    @When("set valid username {string} and invalid pass {string}")
    public void setValidUsernameAndInvalidPass(String user_name, String pass) {
        obj.setValidUsernameAndInvalidPass(user_name,pass);
    }

    @When("set empty username {string} and pass {string}")
    public void setEmptyUsernameAndPass(String user_name, String pass) {

        obj.setEmptyUsernameAndPass(user_name,pass);
    }

    @When("set valid username {string} and empty pass {string}")
    public void setValidUsernameAndEmptyPass(String user_name, String pass) {

        obj.setValidUsernameAndEmptyPass(user_name,pass);

    }

    @When("set valid username {string} and  pass {string}")
    public void setValidUsernameAndPass(String user_name, String pass) {
        forget = false;
        for (User u: obj.up) {
            if (user_name.equals(u.getUser_name()) && pass.equals("Forget")) {
                forget = true;
                enteredUsername = user_name;
                break;
            }
        }
    }

    @Then("take new pass {string}")
    public void takeNewPass(String newPass) {
        for (User user : obj.up) {
            if (user.getUser_name().equals(enteredUsername)) {
                user.setPass(newPass);
            }
        }
        boolean passwordUpdated = false;
        for (User user : obj.up) {
            if (user.getUser_name().equals(enteredUsername) && user.getPass().equals(newPass)) {
                passwordUpdated = true;
                break;
            }
        }

        assertTrue("New password should be updated", passwordUpdated);
    }

    @And("i don't have an account")
    public void iDonTHaveAnAccount() {
        obj.isLogged=false;
    }

    @When("set new username {string} and pass {string} and bd={string}")
    public void setNewUsernameAndPass(String user_name, String pass,String bd) {
        obj.up.add(new User(user_name, pass,bd));
        enteredUsername = user_name;
        enteredPassword = pass;
    }

    @Then("create succeed")
    public void createSucceed() {
        boolean userCreated = false;
        for (User user : obj.up) {
            if (user.getUser_name().equals(enteredUsername) && user.getPass().equals(enteredPassword)) {
                userCreated = true;
                break;
            }
        }

        assertTrue("User creation should succeed", userCreated);
    }
}

