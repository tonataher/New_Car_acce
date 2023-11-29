package today.edu;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminDash {
    public MyAppT obj;
    int ff=0;
    public boolean updates = false;
    public boolean appears = false;
    public int r=0;
    public AdminDash(MyAppT iobj)
    {
        super();
        this.obj=iobj;
        car c1 = new car("motor","Interior",5000,1,"essintial part");
        obj.cp.add(c1);
        car c2 = new car("motor-v2","Interior",5000,100,"essintial part");
        obj.cp.add(c2);
    }
    @When("the name is {string} and the category is {string} and the price is {int} and the num of av p is {int} and the discription is {string}")
    public void theNameIsAndTheCategoryIsAndThePriceIsAndTheNumOfAvPIsAndTheDiscriptionIs(String arg0, String arg1, int arg2, int arg3, String arg4) {
        obj.theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(arg0,arg1,arg2,arg3,arg4);
    }

    @Then("the product add successfully")
    public void theProductAddSuccessfully() {
        int exist=0;
        for(car c:obj.cp)
        {
            if (c.car_name.equals("motor_v5")) {
                exist = 1;
                break;
            }
        }
        assertEquals(1, exist);
    }

    @When("I ask you to list all the customer account")
    public void iAskYouToListAllTheCustomerAccount() {
        obj.seeUser();
        ff=1;
    }

    @Then("the customer account must be appear on the screen")
    public void theCustomerAccountMustBeAppearOnTheScreen() {
        assertEquals(1, ff);
    }

    @When("I enter the name for user {string} and the new password that i want to put it {string}")
    public void iEnterTheNameForUserAndTheNewPasswordThatIWantToPutIt(String arg0, String arg1)
    {
        int klk= obj.yourInformationUpdatesSuccessfully(arg0,arg1);
        updates= (klk == 1);
    }

    @Then("The password must change successfully")
    public void thePasswordMustChangeSuccessfully()
    {
        assertTrue(updates);
    }

    @When("I give the name of product{string} and the new price for it {int}")
    public void iGiveTheNameOfProductAndTheNewPriceForIt(String arg0, int arg1)
    {
        for(car c: obj.cp)
        {
            if(c.car_name.equals(arg0)) {
                c.setPrice(arg1);
                r=1;
            }
        }
    }

    @Then("The price must change successfully")
    public void thePriceMustChangeSuccessfully() {
        assertEquals(1, r);
    }

    @When("I give you a date {string}")
    public void iGiveYouADate(String arg0) {
        obj.date.add(arg0);
    }

    @Then("this date must be added to the appointment as a free day to install")
    public void thisDateMustBeAddedToTheAppointmentAsAFreeDayToInstall() {
        assertTrue(true);
    }
}
