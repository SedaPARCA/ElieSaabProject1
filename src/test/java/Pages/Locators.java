package Pages;

import StepDefinitions.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators extends Events {
    public Locators() {
        PageFactory.initElements(GWD.getDriver(), this); // Kullanacağım zaman driver üzerinden bulur ve getirir.
    }
        @FindBy(xpath = "//*[@class='rez_logoContainer__Ng6LK']")
        public WebElement ElieSaabLogo;

    @FindBy(css = "[id='fullname']")
    public WebElement NameSurname;

    @FindBy(xpath = "//*[@placeholder='Phone Number']")
    public WebElement PhoneNumber;

    @FindBy(css = "[name='email']")
    public WebElement Email;

    @FindBy(xpath = "(//*[@class='rez_customBtn__DWbKh'])[2]")
    public WebElement RegisterInterestbutton;

    @FindBy(xpath = "//h1[text()='THANK YOU']")
    public WebElement ThankYouText;


}