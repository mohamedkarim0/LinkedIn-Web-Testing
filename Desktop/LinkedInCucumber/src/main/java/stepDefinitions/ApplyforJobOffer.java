package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ApplyforJobOffer {
	
	  WebDriver driver;

    @Given("User is in the LinkedIn homepage {string}")
    public void userIsOnLinkedInHomepage1(String baseUrl) {
    	System.out.println("Launching Google Chrome browser");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String testTitle = "LinkedIn Login, Sign in | LinkedIn";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, testTitle);
    }

    @When("User types email and password")
    public void userEntersEmailAndPassword1() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("mohamed214991@bue.edu.eg");
        driver.findElement(By.id("password")).sendKeys("H_%$_5z%?mYK5_7");
        driver.findElement(By.className("login__form_action_container")).submit();
        Thread.sleep(30000);
    }

    @And("User clicks on Jobs icon")
    public void userClicksOnJobsIcons() {
    	WebElement jobsIcon = driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]/a/div"));
        jobsIcon.click();
        Assert.assertNull(jobsIcon);
    }

    @And("User clicks on Show All")
    public void userClicksOnShowAll1() {
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[2]")).click();
    }

    @And("User chooses the job {string}")
    public void userChoosesTheJob1(String jobtitle) {
        driver.findElement(By.id("ember569")).click();
    }

    @And("User clicks on the Easy Apply button")
    public void userClicksOnEasyApply1() {
        driver.findElement(By.id("ember606")).click();
    }

    @And("User types the address {string}")
    public void userTypesTheAddress1(String address) {
        driver.findElement(By.id("ember574")).sendKeys(address);
    }

    @And("User clicks on submit")
    public void userClicksOnSubmit1() {
        driver.findElement(By.id("ember1626")).click();
        driver.findElement(By.xpath("//*[@id=\"ember1626\"]")).click();
        driver.findElement(By.id("ember1637")).click();
    }

    @Then("Verify the job is applied successfully")
    public void verifyTheJobIsAppliedSuccessfully1() {
    	// Verify the URL after applying for the job
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/jobs/search/post-apply/"));

        // Verify the presence of the job title on the applied jobs page
        WebElement jobTitleElement = driver.findElement(By.xpath("//h1[contains(@class, 'jobs-applied-page__title')]"));
        String jobTitleText = jobTitleElement.getText();
        Assert.assertTrue(jobTitleText.contains("Treasury Intern"));

        // Verify the Application message
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class, 'jobs-applied-page__description')]"));
        String successMessageText = successMessage.getText();
        Assert.assertTrue(successMessageText.contains("You application was sent"));

        if (driver != null) {
            driver.quit();
        }
    }

    
}
