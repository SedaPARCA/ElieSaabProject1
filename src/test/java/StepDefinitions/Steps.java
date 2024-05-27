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
     apiResponse = RestAssured.get("https://terminal.tremglobal.com/form/save.php?q=basvuru&name=Seda Parça&phone=905350356773&email=seda.parca@tremglobal.com&medium=99");  // Api ye istek.

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

        // Değerleri yazdır, bunu daha sonra kaldırabilirsin.
        //   System.out.println("message: " + message);
        //  System.out.println("basvuru_id: " + basvuruId);

    }

    }




