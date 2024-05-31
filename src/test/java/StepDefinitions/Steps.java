package StepDefinitions;

import Pages.Events;
import Pages.Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;

public class Steps {

    private Response apiResponse;
    Locators lc = new Locators();

    @Given("Navigate to Url")
    public void navigateToUrl() {
        GWD.getDriver().get("https://eliesaabbosphorus.com");
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    @And("Fill the Form")
    public void fillTheForm() {
    lc.mySendKeys(lc.NameSurname,"Seda Parça");
    lc.mySendKeys(lc.PhoneNumber,"5350356773");
    lc.mySendKeys(lc.Email,"seda.parca@tremglobal.com");

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
   //Burası mantıklı mı? yani aşağıdaki url i girdikten sonras hep bu cavbı verir zaten, bunun bir önceki form kaydıyla ne alakası var.
     apiResponse = RestAssured.get("https://terminal.tremglobal.com/form/save.php?q=basvuru&name=Seda%20Par%C3%A7a&phone=905350356773&email=seda.parca%40tremglobal.com&medium=99");  // Api ye istek.

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
}




