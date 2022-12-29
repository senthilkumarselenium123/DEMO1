package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {				
		

    @Given("^Open the Firefox and launch the application$")
    public void open_the_Firefox_and_launch_the_application() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	System.out.println("PSKKKK");
    }

    @When("^Enter the Username and Password$")
    public void enter_the_Username_and_Password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Reset the credential$")
    public void reset_the_credential() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }


}