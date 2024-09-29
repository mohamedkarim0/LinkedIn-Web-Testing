package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReopenJobOffer {

	WebDriver driver;
    

    @Given("User is on the LinkedIn homepage {string}")
    public void userIsOnLinkedInHomepage(String baseUrl) {
    	System.out.println("Launching Google Chrome browser");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @When("User enters email and password")
    public void userEntersEmailAndPassword() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("mohamed214991@bue.edu.eg");
        driver.findElement(By.id("password")).sendKeys("H_%$_5z%?mYK5_7");
        driver.findElement(By.className("login__form_action_container")).submit();
        Thread.sleep(40000);
    }

    @And("User clicks on the Jobs icon")
    public void userClicksOnJobsIcon() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]/a")).click();
        Thread.sleep(3000);
    }

    @And("User clicks on Manage job posts")
    public void userClicksOnManageJobPosts() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[2]/a")).click();
        Thread.sleep(3000);
    }

    @And("User selects Closed")
    public void userSelectsClosed() {
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/main/section/div/div[1]/ul/li[2]/button")).click();
    }

    @And("User selects the requested job offer {string}")
    public void userSelectsTheRequestedJobOffer(String jobTitle) {
        String jobTitle2 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/main/section/div/div[2]/div/ul/li/div/div/div/div[2]/div[1]/div[1]/div/span/span/a/string")).getText();
        assertEquals(jobTitle2, jobTitle);
    }

    @And("User clicks ...")
    public void userClicks() {
        WebElement optionDropdown = driver.findElement(By.id("ember202"));
        optionDropdown.click();
    }


    @Then("Verify the job offer is reopened successfully")
    public void verifyTheJobOfferIsReopenedSuccessfully() {
    	Select dropdown = new Select(driver.findElement(By.id("ember202")));
        dropdown.selectByIndex(1);
        assertTrue(dropdown.getOptions().size() > 0);
    	WebElement selectedOption = dropdown.getFirstSelectedOption();
        assertEquals("Second Option", selectedOption.getText());
        
        if (driver != null) {
            driver.quit();
        }
    }

   
}
