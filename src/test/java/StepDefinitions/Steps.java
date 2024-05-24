package StepDefinitions;

import Pages.Events;
import Pages.Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class Steps {

    private Response response;

    Locators lc = new Locators();

    @Given("Navigate to Url")
    public void navigateToUrl() {
        GWD.getDriver().get("https://eliesaabbosphorus.com");
    }


    @And("Fill the Form")
    public void fillTheForm() {
        // cookie kapatılacak.
    lc.mySendKeys(lc.NameSurname,"Seda Parça");
    lc.mySendKeys(lc.PhoneNumber,"5350356773");
    lc.mySendKeys(lc.Email,"sedaparca.93@gmail.com");




    }

    @Then("Click Registered Interested Button")
    public void clickRegisteredInterestedButton() {

    }

    @Then("Verify Success message")
    public void verifySuccessMessage() {
    }


    @Given("Get Request Data From Backend")
    public void getRequestDataFromBackend() {

        String requestBody = getRequestDataFrommBackend();

        given()
                .body(requestBody)
                .when()
                .post("/api/form-submit");

    }

    @When("Check the Response Code")
    public void checkTheResponseCode() {
    }

    private String getRequestDataFrommBackend(){


        return "name=AD SOYAD&phone=TELEFON"; // knedi bilgilerinin olduğu pointi gircen.
}
    }




