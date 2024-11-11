package StepDefinitions;

import Pages.PytmFlightTicket;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class PytmFlightBookingSteps {
  public   WebDriver driver;
   public PytmFlightTicket ticket;

    @Given("the user is on the Paytm flight booking page")
    public void theUserIsOnThePaytmFlightBookingPage() {
        System.setProperty("webDriver.chrome.driver","C:\\Users\\zaffar\\Downloads\\Amazon-20241010T064535Z-001\\Amazon\\Drivers\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver=new ChromeDriver();
        ticket=new PytmFlightTicket(driver);
        ticket.navigateToPaytm();
    }

    @When("the user selects a departure city as {string}")
    public void theUserSelectsADepartureCityAs(String city) {
        ticket.selectDepartureCity();
        ticket.enterCityName(city);
    }

    @And("the user selects a destination city as {string}")
    public void theUserSelectsADestinationCityAs(String arg0) {
        ticket.selectDestinationCity();
    }

    @And("the user selects the departure date as {string}")
    public void theUserSelectsTheDepartureDateAs(String arg0) {
        ticket.selectDate();
    }

    @And("the user selects {int} adult traveler")
    public void theUserSelectsAdultTraveler(int arg0) {
        ticket.selectPassengers();
    }

    @And("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String arg0) {
        ticket.clickSearchFlightButton();
    }

    @Then("the user should see a list of available flights")
    public void theUserShouldSeeAListOfAvailableFlights() {
       // String actualTitle="Flight Tickets, Flight Booking Online, Book Cheap Flights, Air Tickets @ Paytm";
      //  expectedTitle=driver.getTitle();
      //  Assert.assertEquals(actualTitle,expectedTitle);
    }

    @When("the user selects a flight from the list")
    public void theUserSelectsAFlightFromTheList() {
        ticket.clickOnflight();

    }

    @And("the user enters passenger details")
    public void theUserEntersPassengerDetails() {
    }

    @And("the user selects {string} as the payment method")
    public void theUserSelectsAsThePaymentMethod(String arg0) {
    }

    @And("the user confirms the payment")
    public void theUserConfirmsThePayment() {
    }

    @Then("the user should see a confirmation message for the flight booking")
    public void theUserShouldSeeAConfirmationMessageForTheFlightBooking() {
    }
    @And("quit the browser")
    public void quitTheBrowser() {
        driver.quit();
    }

    @Given("user launch browser and enter url")
    public void userLaunchBrowserAndEnterUrl() {
        System.setProperty("webDriver.chrome.driver","C:\\Users\\zaffar\\Downloads\\Amazon-20241010T064535Z-001\\Amazon\\Drivers\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver=new ChromeDriver();
        ticket=new PytmFlightTicket(driver);
        ticket.navigateToPaytm();

    }
}

