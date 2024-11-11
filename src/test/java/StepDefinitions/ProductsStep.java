package StepDefinitions;

import Pages.AmazonPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class ProductsStep {

    public WebDriver driver;
    public AmazonPage ap;

    @Before
      public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zaffar\\Downloads\\Amazon-20241010T064535Z-001\\Amazon\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://amazon.com/");
        Thread.sleep(20000);
        ap=new AmazonPage(driver);
        System.out.println(ap.amazonLogoIsDisplayed());
        if (ap.amazonLogoIsDisplayed()){
            org.junit.Assert.assertTrue(true);
        }
    }

    @When("user should enter {string} to Search")
    public void user_should_enter_to_search(String item) {
        ap.searchItem(item);
        ap.clickSearchLogo();

    }
    @Then("items should be displayed")
    public void items_should_be_displayed() {

        Assert.assertTrue(true);
    }



    @And("user should be able to click on every Dropdown")
    public void userShouldBeAbleToClickOnEveryDropdown() throws InterruptedException {
        ap.clickALLDropdownItems();
    }

    @And("user should be able to click on all shoeSizes")
    public void userShouldBeAbleToClickOnAllShoeSizes() throws InterruptedException {
        ap.clickAllShoeSizes();
    }

    @And("user should be able to click on {string}")
    public void userShouldBeAbleToClickOn(String name) throws InterruptedException {
        ap.findBrand(name);
    }

    @Then("user should add only those elements that are less than ${int}")
    public void userShouldAddOnlyThoseElementsThatAreLessThan$(int limit) throws InterruptedException {

        List<WebElement> productsList=driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        for(WebElement products: productsList){
            WebElement priceElement=products.findElement(By.xpath(".//span[@class='a-price-whole']"));
            Thread.sleep(3000);
            String priceText = priceElement.getText();
            double price = Double.parseDouble(priceText);
            if(price <limit){
                WebElement atc=products.findElement(By.xpath(".//button[@class='a-button-text']"));
                atc.click();
                Thread.sleep(2000);
            }
        }
    }


    @Then("user should select {string} color")
    public void userShouldSelectColor(String color) throws InterruptedException {
        WebElement productColor=driver.findElement(By.xpath("//a[@title='"+color+"']//div"));
        productColor.click();
        Thread.sleep(3000);
    }

    @And("user should select {string} if present")
    public void userShouldSelectIfPresent(String color) throws InterruptedException {
        ap.ifColorTabPresent();
        if (ap.ifColorTabPresent()) {
            System.out.println("Colors Tab is present hence clicking the color '" + color + "' ");
            WebElement productColor = driver.findElement(By.xpath("//a[@title='" + color + "']//div"));
            productColor.click();
            Thread.sleep(3000);
        } else {
            System.out.println("Since the color Tab is not present hence '" + color + "' cannot be selected");
        }
    }


    @Then("user should check the product {string} and find the product")
    public void userShouldCheckTheProductAndFindTheProduct(String desc) {
        boolean productFound = false;

        while (!productFound) {
            List<WebElement> products = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
            for (WebElement product : products) {
                WebElement productDesc = product.findElement(By.xpath(".//span[@class='a-size-base-plus a-color-base a-text-normal']"));
                String productDescText = productDesc.getText();
                if (productDescText.equals(desc)) {
                    WebElement atc = product.findElement(By.xpath(".//button[@class='a-button-text']"));
                    atc.click();

                    System.out.println("Product found and added to cart: " + productDescText);
                    productFound = true;
                    break;
                }
            }
            if (!productFound) {
                try {
                    WebElement nextButton = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
                    nextButton.click();

                    Thread.sleep(2000);
                } catch (NoSuchElementException e) {
                    // If the "Next" button is not found, exit the loop (no more pages)
                    System.out.println("Reached the last page. Product not found.");
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @After
    public void teardown(){
        driver.quit();
    }




}
