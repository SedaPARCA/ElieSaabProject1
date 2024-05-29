package StepDefinitions;

import Pages.Locators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class StepsMobileTest {


   Locators lc = new Locators();

    @Given("Navigate to Url and fill the form in the Mobile")
    public void navigateToUrlAndFillTheFormInTheMobile() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("browserName", "Chrome");

        WebDriver driver = new ChromeDriver(new ChromeOptions().merge(capabilities));

        driver.get("https://eliesaabbosphorus.com/");




    }
}