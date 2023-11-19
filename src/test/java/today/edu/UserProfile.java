package today.edu;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProfile {
    public MyAppT obj;
    public String name;
    public  String pass;
    public boolean updates = false;
    public boolean appear = false;

    public UserProfile(MyAppT iobj){
        super();
        this.obj = iobj;
    }

    @And("my name is {string}")
    public void myNameIs(String name1) {
        name = name1;
    }

    @When("I entered new password {string}")
    public void iEnteredNewPassword(String pass1) {
        pass = pass1;
    }

    @Then("Your information Updates successfully")
    public void yourInformationUpdatesSuccessfully() {
        for(User u: obj.up){
            if(name.equals(u.getUser_name())){
                u.setPass(pass);
                updates = true;
                break;
            }
        }
        assertTrue("Your information Updates successfully", updates);
    }

    @Then("The information should appear")
    public void theInformationShouldAppear() {
        for(order o : obj.op){
            if(name.equals(o.Uname)){
                System.out.println(o.Cname);
                System.out.println(o.date);
                appear = true;
            }
        }
        assertTrue("Your information appear successfully", appear);
    }
}
