package today.edu;

import today.edu.MyAppT;
import today.edu.User;
import today.edu.car;
import today.edu.order;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class Installation {
    public MyAppT obj;
    public  boolean isInstallation=false;
    public boolean submit = false;
    public boolean available1 = false;
    public boolean available2 = false;
    //public String []date = {"20-10-2023","22-10-2023","5-11-2023"};
    String uname, dateee , cname;
    public Installation(MyAppT iobj){
        super();
        this.obj = iobj;
        User u1= new User("haya","123","7\3\2004");
        obj.up.add(u1);
        User u2= new User("Asma@gmail.com","1234","7\3\2004");
        obj.up.add(u2);
        car c1 = new car("motor","Interior",5000,1,"essintial part");
        obj.cp.add(c1);
        car c2 = new car("motor-v2","Interior",5000,100,"essintial part");
        obj.cp.add(c2);
    }

    @And("My name is {string}")
    public void myNameIs(String name) {
        uname = name;

    }
    @And("I'm on the installation request page")
    public void iMOnTheInstallationRequestPage() {
        isInstallation=true;
    }

    @When("the customer fills in the following details: model is {string} and date {string}")
    public void theCustomerFillsInTheFollowingDetailsModelIsAndDate(String model, String datee) {
        for(String d: obj.date){
            if (d.equals(datee)) {
                available1 = true;
                dateee = datee;
                break;
            }
        }
        for(car c : obj.cp){
            if (model.equals(c.car_name)){
                available2 = true;
                cname = model;
                break;
            }
        }
    }

    @And("submits the form")
    public void submitsTheForm() {
        submit=true;
        obj.op.add(new order(uname, cname,dateee));
    }

    @Then("the request should be successfully submitted if the date available")
    public void theRequestShouldBeSuccessfullySubmittedIfTheDateAvailable() {
        assertTrue("The Installation request submitted", isInstallation && available1 && available2 && submit);
    }


    @Then("the request should not be submitted if the date is not available")
    public void theRequestShouldNotBeSubmittedIfTheDateIsNotAvailable() {
        assertTrue("The Installation request didn't submit", isInstallation && (!available1 || !available2) && submit);
    }
}
