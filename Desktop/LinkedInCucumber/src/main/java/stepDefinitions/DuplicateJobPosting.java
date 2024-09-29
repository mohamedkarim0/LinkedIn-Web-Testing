package stepDefinitions;

import io.cucumber.java.en.*;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DuplicateJobPosting {
	WebDriver driver;

    @Given("User navigate to {string}")
    public void i_navigate_to(String url) {
        System.out.println("Launching Google Chrome browser");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @When("User sign in with username and password")
    public void i_sign_in_with_username_and_password() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("mohamed214991@bue.edu.eg");
        driver.findElement(By.id("password")).sendKeys("H_%$_5z%?mYK5_7");
        driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[3]")).submit();
        Thread.sleep(45000);
    }

    @Then("User should be on the home page")
    public void i_should_be_on_the_home_page() {
        
    }

    @When("User navigates to job postings")
    public void i_navigate_to_job_postings() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[1]")).click();
        Thread.sleep(10000);
    }

    @And("User select a job posting")
    public void i_select_a_job_posting() {
        driver.findElement(By.xpath("//*[@id=\"ember28\"]")).click();
    }

    @Then("User should see the feedback option")
    public void i_should_see_the_feedback_option() {
        assertTrue(driver.findElement(By.id("artdeco-hoverable-artdeco-gen-42")).isDisplayed());
    }

    @When("User provides job title {string}")
    public void i_provide_job_details(String jobTitle) {
        driver.findElement(By.xpath("//*[@id=\"job-title-typeahead-input-ember26\"]"))
                .sendKeys(jobTitle);
        
    }
    
    @And("User provides company name {string}")
    public void user_provied_company_name(String companyName){

        WebElement companyNameField = driver.findElement(By.xpath("//*[@id=\"job-title-typeahead-input-ember26\"]"));
        String companyyName = companyNameField.getAttribute("value");
        if (!companyyName.equals("Egyineer")) {
            companyNameField.clear();
            companyNameField.sendKeys("Egyineer");
        }
    }
    
    @And("User chooses workplace type")
    public void user_provied_wrokplace(){
    	 driver.findElement(By.id("ember40")).click();
         driver.findElement(By.id("ember42")).click();
    }
    
    
    @And("User types job location {string}")
    public void user_provied_job_location(String jobLocation){
    	 driver.findElement(By.id("location-typeahead-input-ember43"))
         .sendKeys(jobLocation);
    }
    

    @Then("User should not be able to submit the job posting")
    public void i_should_not_be_able_to_submit_the_job_posting() {
        driver.findElement(By.xpath("//*[@id=\"ember55\"]")).click();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.linkedin.com/job-posting/?jobId=3883489407&jobPostingFlowTrackingId=rvUN2tVITGq%2BVotvJ%2BJILQ%3D%3D&trk=flagship3_job_home");
        System.out.println("System didn't handle duplicate job offer");
    }

}