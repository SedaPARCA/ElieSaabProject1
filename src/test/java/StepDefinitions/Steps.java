package StepDefinitions;

import Pages.Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.json.JSONObject;

public class Steps {

    private Response apiResponse;
    Locators lc = new Locators();

    @Given("Navigate to Url")
    public void navigateToUrl() {
        GWD.getDriver().get("https://eliesaabbosphorus.com");


    }

    @And("Fill the Form")
    public void fillTheForm() {
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    lc.mySendKeys(lc.NameSurname,"TestAutomation");
    lc.mySendKeys(lc.PhoneNumber,"5520000000");
    lc.mySendKeys(lc.Email,"testautomation@tremglobal.com");

    }

    @Then("Click Registered Interested Button")
    public void clickRegisteredInterestedButton() {

      lc.myJsClick(lc.RegisterInterestbutton);
    }

    @Then("Verify Success message")
    public void verifySuccessMessage() {

        lc.verifyContainsText(lc.ThankYouText, "THANK YOU");
    }


    @Given("Get Request Data From Backend")
    public void getRequestDataFromBackend() {
     apiResponse = RestAssured.get("https://terminal.tremglobal.com/form/save.php?q=basvuru&name=TestAutomation&phone=905520000000&medium=99");  // Api ye istek.

    }

    @When("Check the Response Code")
    public void checkTheResponseCode() {

        int statusCode = apiResponse.getStatusCode();
        Assert.assertEquals(200, statusCode);  //yanıt kontrolü

        String responseBody = apiResponse.getBody().asString();
        System.out.println("API Yanıtı: " + responseBody);
        Assert.assertFalse(responseBody.isEmpty(), "Apı yanıtı boş olmamalıdır.");

        JSONObject jsonObject = new JSONObject(responseBody.substring(1, responseBody.length() - 1));
        String message = jsonObject.getString("message");
        String basvuruId = jsonObject.getString("basvuru_id");

        Assert.assertEquals("true", message);

    }

    @And("Check the Fields on the Form")
    public void checkTheFieldsOnTheForm() {

    Assert.assertTrue(lc.NameSurname.isDisplayed());
    Assert.assertTrue(lc.Email.isDisplayed());
    Assert.assertTrue(lc.PhoneNumber.isDisplayed());

    }

    @Then("Check the Registered Interested Button")
    public void checkTheRegisteredInterestedButton() {

    Assert.assertTrue(lc.RegisterInterestbutton.isDisplayed());

    }


    @And("Leave the Phone Number Field on the Form Blank")
    public void leaveThePhoneNumberFieldOnTheFormBlank() {

        lc.mySendKeys(lc.NameSurname,"Seda Parça");
        lc.mySendKeys(lc.Email,"sedaparca.93@gmail.com");
        lc.mySendKeys(lc.PhoneNumber," ");
        lc.verifyContainsText(lc.InvalidPhoneNumber, "Invalid Phone Number");
    }

    @And("Enter an invalid number in the Phone Number field on the form.")
    public void enterAnInvalidNumberInThePhoneNumberFieldOnTheForm() {

        lc.mySendKeys(lc.PhoneNumber,"222");
        lc.verifyContainsText(lc.InvalidPhoneNumber, "Invalid Phone Number");
    }

    @Given("Verification of Access to the Page")
    public void verificationOfAccessToThePage() {
    lc.verifyContainsText(lc.BOSPHORUSsPLENDORtEXT,"BOSPHORUS SPLENDOR");
    }
}




