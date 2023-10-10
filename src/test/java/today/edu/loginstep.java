package today.edu;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.swing.*;

public class loginstep {
    public MyAppT obj;
    public boolean f=false;
    public boolean forget = false;
    public String enteredUsername;
    public String enteredPassword;
    // Dependency injection
    public loginstep(MyAppT iobj) {
        super();
        this.obj = iobj;
    }

    @Given("I am not in system")
    public void iAmNotInSystem()
    {
        assertFalse(obj.isLogedin);
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

        if (user_name.isEmpty())
            f = false;

        assertFalse(f);
    }

    @When("set valid username {string} and empty pass {string}")
    public void setValidUsernameAndEmptyPass(String user_name, String pass) {

        if (pass.isEmpty())
            f = false;

        assertFalse(f);
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
        assertTrue(forget);
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
        assertFalse(obj.isLogedin);
    }

    @When("set new username {string} and pass {string}")
    public void setNewUsernameAndPass(String user_name, String pass) {
        int flag=0;
        char[]ma=user_name.toCharArray();
        for (char value : ma) {
            if (!( (value >= 'A' && value <= 'Z') || (value >= 'a' && value <= 'z') ))
                flag += 1;
        }
        if(flag>=1){
            JOptionPane.showMessageDialog(null,"make sure that your name only contains letters");
            System.exit(0);
        }
        int cc=0;
        int cs=0;
        int cn=0;
        char[]ma2=pass.toCharArray();
        if(ma2.length<12){
            JOptionPane.showMessageDialog(null,"Make sure that your password is at least 12 latters");
            System.exit(0);
        }
        else {
            for (char c : ma2) {
                if (!((ma2[0] >= 'A' && ma2[0] <= 'Z') || (ma2[0] >= 'a' && ma2[0] <= 'z'))) {
                    JOptionPane.showMessageDialog(null, "your password should start with letter ");
                    System.exit(0);
                }
                else {
                    if (c >= 'A' && c <= 'Z')
                        cc++;
                    if (c >= 'a' && c <= 'z')
                        cs++;
                    if (c >= '0' && c <= '9')
                        cn++;
                }
            }
        }
            if (cc < 3 || cs < 3 || cn < 4) {
                JOptionPane.showMessageDialog(null, "your password is too weak it must contain at least 3 capital letters,3 small letters, and 4 numbers");
                System.exit(0);
            }
        obj.up.add(new User(user_name, pass) );
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

