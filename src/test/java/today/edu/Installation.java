package today.edu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class Installation {
    public MyAppT obj;
    public  boolean isInstallation=false;
    public boolean submit = false;
    public boolean available1 = false;
    public boolean available2 = false;
    public String []date = {"20-10-2023","22-10-2023","5-11-2023"};
    String uname, dateee , cname;
    public Installation(MyAppT iobj){
        super();
        this.obj = iobj;
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
         for(String d: date){
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
