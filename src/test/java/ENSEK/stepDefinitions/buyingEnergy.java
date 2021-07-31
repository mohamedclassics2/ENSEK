package ENSEK.stepDefinitions;

import ENSEK.pages.BasePage;
import ENSEK.utilities.ConfigurationReader;
import ENSEK.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class buyingEnergy {
    String buyEnergyPageTitle;
    BasePage basePage = new BasePage();
    Driver driver= new Driver();

    @Given("I am on ENSEK site")
    public void i_am_on_ENSEK_site() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());

    }

    @When("I click on Buy Energy")
    public void i_click_on_Buy_Energy() {
       basePage.BuyEnergy.click();
       buyEnergyPageTitle = Driver.get().getTitle();
        System.out.println("buyEnergyPageTitle = " + buyEnergyPageTitle);
    }

    @Then("The page title must be Buy - Candidate Test")
    public void the_page_title_must_be_Buy_Candidate_Test() {
        String expectedTitle = "Buy - Candidate Test";

        System.out.println("buyEnergyPageTitle = " + buyEnergyPageTitle);
        System.out.println("expectedTitle = " + expectedTitle);

        Assert.assertEquals(expectedTitle, buyEnergyPageTitle);
    }

}
