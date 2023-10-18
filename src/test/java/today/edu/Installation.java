package today.edu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class Installation {
    public MyAppT obj;
    public  boolean isInstallation=false;
    public boolean submit = false;
    public boolean available = false;
    public String []date = {"20-10-2023","22-10-2023","5-11-2023"};

    public Installation(MyAppT iobj){
        super();
        this.obj = iobj;
    }

    @And("I'm on the installation request page")
    public void iMOnTheInstallationRequestPage() {
       isInstallation=true;
    }

    @When("the customer fills in the following details: model is {string} and date {string}")
    public void theCustomerFillsInTheFollowingDetailsModelIsAndDate(String model, String datee) {
         for(String d: date){
             if (d.equals(datee)) {
                 available = true;
                 break;
             }
         }
    }

    @And("submits the form")
    public void submitsTheForm() {
        submit=true;
    }

    @Then("the request should be successfully submitted if the date available")
    public void theRequestShouldBeSuccessfullySubmittedIfTheDateAvailable() {
        assertTrue("The Installation request submitted", isInstallation && available && submit);
    }


    @Then("the request should not be submitted if the date is not available")
    public void theRequestShouldNotBeSubmittedIfTheDateIsNotAvailable() {
        assertTrue("The Installation request didn't submit", isInstallation && !available && submit);
    }
}
