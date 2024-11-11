package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PytmFlightTicket {

    public WebDriver driver;

    public PytmFlightTicket(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        By departureCity=By.id("srcCode");
        By destinationCity=By.id("destCode");
        By date=By.id("departureDate");
        By qunatityOfticktes=By.id("numPax");
        By searchFlightBtn=By.id("flightSearch");
        By selectFlight=By.xpath("(//button[@class='zHp8j'])[1]");

        public void navigateToPaytm(){
            driver.get("https://paytm.com/");

        }
         public void selectDepartureCity(){
            driver.findElement(departureCity).click();
        }

        public void enterCityName(String city){
            driver.findElement(departureCity).sendKeys(city);
        }

         public void selectDestinationCity(){
            driver.findElement(destinationCity).click();




        }
        public void selectDate(){
            driver.findElement(date).click();

        }
        public void selectPassengers(){
            driver.findElement(qunatityOfticktes).click();



        }
        public void clickSearchFlightButton(){
        driver.findElement(searchFlightBtn).click();


    }
    public void clickOnflight(){
            driver.findElement(selectFlight);

    }
    }








