package fortrainingapp.stepdefinitions;

import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fortrainingapp.pageobjects.LoginPageObjects;
import fortrainingapp.pageobjects.AllProjectsPageObjects;

public class LoginStepDefinitions extends LoginPageObjects{

	AllProjectsPageObjects allprojects = new AllProjectsPageObjects();
	SoftAssert sa = new SoftAssert();
	
	@Given("^User is in login page$")
    public void user_is_in_login_page() {
		launchApplication();
    }

    @When("^User enters email id \"([^\"]*)\"$")
    public void user_enters_email_id(String strArg1) {
    	enterEmailId(strArg1);
    	
    }

    @Then("^User should be logged in successfully$")
    public void user_should_be_logged_in_successfully() {
        
    	String actual = allprojects.captureMyProjectsText().toUpperCase().trim();
    	String expected = "MY PROJECTS";
    	
    	
    	sa.assertEquals(actual, expected);
    	sa.assertAll();
    	
    	
    	
    }

    @And("^User enters password \"([^\"]*)\"$")
    public void user_enters_password(String strArg1) {
        enterPassword(strArg1);
    }

    @And("^User clicks the signin button$")
    public void user_clicks_the_signin_button() {
        clickSigninButton();
    }
    
    @When("^User clicks the profile button$")
    public void user_clicks_the_profile_button() throws InterruptedException  {
    	Thread.sleep(3000);
    	allprojects.clickProfileButton();
    }

    @Then("^User should be logged out successfully$")
    public void user_should_be_logged_out_successfully()  {
    	
    	boolean actual = allprojects.welcomeBackPresence();
    	boolean expected = true;
    	
    	sa.assertEquals(actual, expected);
        sa.assertAll();
    }

    @And("^User clicks the signout button$")
    public void user_clicks_the_signout_button()  {
    	allprojects.clickSignOutButton();
    }
    
    @Then("^User should see error message on the screen$")
    public void user_should_see_error_message_on_the_screen()  {
        
    	String actual = captureErrorMessage().trim();
    	String expected = "Invalid email or password.";
    	
    	
    	sa.assertEquals(actual, expected);
    	sa.assertAll();
    	
    	
    	
    }

	
}
