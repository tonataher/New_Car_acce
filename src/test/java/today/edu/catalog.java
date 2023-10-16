package today.edu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class catalog {
    public MyAppT obj;
    public boolean added = false;
    public car cc;
    public ArrayList<car> carArrayList = new ArrayList<car>();
    public String Categorie;

    public catalog(MyAppT iobj){
        super();
        this.obj = iobj;
    }

    @When("the name is {string} and categorie is {string} and price is {int} and availability is {int} and descriptions is {string}")
    public void theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(String name, String categorie, int price, int ava, String desc) {
        obj.cp.add(new car(name,categorie,price,ava,desc));
        added=true;
    }

    @Then("the product is added to the Interior section")
    public void theProductIsAddedToTheInteriorSection() {
        assertTrue("The product is added",added);
    }

    @When("I request information about specific product by entering its name {string}")
    public void iRequestInformationAboutSpecificProductByEnteringItsName(String name) {
        for(car c: obj.cp ){
            if(name.equals(c.car_name)){
              cc.setDescr(c.getDescr());
              cc.setPrice(c.getPrice());
              cc.setAvailab(c.getAvailab());
              cc.setCar_name(c.getCar_name());
              cc.setCategorie(c.getCategorie());
            }
        }
    }

    @Then("Make the product descriptions, prices, and availability appear")
    public void makeTheProductDescriptionsPricesAndAvailabilityAppear() {
        assertNotNull(cc);
        System.out.println(cc.getDescr());
        System.out.println(cc.getPrice());
        System.out.println(cc.getAvailab());
    }

    @When("I request information about products by entering there categories {string}")
    public void iRequestInformationAboutProductsByEnteringThereCategories(String categ) {
        for(car c: obj.cp ){
            if(categ.equals(c.categorie)){
                carArrayList.add(new car(c.getCar_name(),c.getCategorie(),c.getPrice(),c.getAvailab(),c.getDescr()));
            }
        }
    }

    @Then("List all the products name, prices, availability and descriptions")
    public void listAllTheProductsNamePricesAvailabilityAndDescriptions() {
        assertNotNull(carArrayList);
        for(car c:carArrayList){
            System.out.println(c.getCar_name());
            System.out.println(c.getPrice());
            System.out.println(c.getAvailab());
            System.out.println(c.getDescr());
        }
    }

    @When("I request information about products by entering there price {int}")
    public void iRequestInformationAboutProductsByEnteringTherePrice(int price) {
        for(car c: obj.cp ){
            if(price==c.price){
                carArrayList.add(new car(c.getCar_name(),c.getCategorie(),c.getPrice(),c.getAvailab(),c.getDescr()));
            }
        }
    }

    @Then("List all the products name, categories, availability and descriptions")
    public void listAllTheProductsNameCategoriesAvailabilityAndDescriptions() {
        assertNotNull(carArrayList);
        for(car c:carArrayList){
            System.out.println(c.getCar_name());
            System.out.println(c.getCategorie());
            System.out.println(c.getAvailab());
            System.out.println(c.getDescr());
        }
    }

    @And("the product categories is loaded {string}")
    public void theProductCategoriesIsLoaded(String categorie) {
        Categorie=categorie;
    }

    @When("I filter products by a price range of {int} to {int}")
    public void iFilterProductsByAPriceRangeOfTo(int price1, int price2) {
        for(car c: obj.cp){
            if(c.price>=price1 && c.price<=price2 && Categorie.equals(c.categorie)){
                carArrayList.add(new car(c.getCar_name(),c.getCategorie(),c.getPrice(),c.getAvailab(),c.getDescr()));
            }
        }
    }

}
