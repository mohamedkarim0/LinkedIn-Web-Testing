import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DuplicateJobPosting {
	// -------------------------------NEGATIVE TEST CASE-------------------------
	WebDriver driver ;
	@BeforeClass
	public void start() {
		String baseUrl = "https://www.linkedin.com/feed/";
		System.out.println("Launching Google Chrome browser");
		
		driver = new ChromeDriver();
		driver.get(baseUrl);
		
		String testTitle = "LinkedIn Login, Sign in | LinkedIn";
		
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, testTitle);
		System.out.println(originalTitle);
	}
	
	@Test
    public void testDuplicateJobPosting() throws InterruptedException {
        // Sign in
        driver.findElement(By.id("username")).sendKeys("mohamed214991@bue.edu.eg");
        driver.findElement(By.id("password")).sendKeys("H_%$_5z%?mYK5_7");
        driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[3]")).submit();

        Thread.sleep(15000);

        // Navigate to job postings
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]/a/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[1]")).click();
        Thread.sleep(10000);

        // Click on feedback
         driver.findElement(By.xpath("//*[@id=\"ember28\"]")).click();

        // Verify feedback element is displayed
        assertTrue(driver.findElement(By.id("artdeco-hoverable-artdeco-gen-42")).isDisplayed());

        // Type job title
        driver.findElement(By.xpath("//*[@id=\"job-title-typeahead-input-ember26\"]")).sendKeys("Software Engineer IIIIII");

        // Check and correct company name
        WebElement companyNameField = driver.findElement(By.xpath("//*[@id=\"job-title-typeahead-input-ember26\"]"));
        String companyName = companyNameField.getAttribute("value");
        if (!companyName.equals("Egyineer")) {
            companyNameField.clear();
            companyNameField.sendKeys("Egyineer");
        }
        // Assert company name
        //assert(companyName.equals("Egyineer"));

        // Select workplace from dropdown menu option
        driver.findElement(By.id("ember40")).click();
        driver.findElement(By.id("ember42")).click();

        // Type in job location
        driver.findElement(By.id("location-typeahead-input-ember43")).sendKeys("H91 HDF8, Galway, County Galway, Ireland");

        // Click on "get started" and assert an element not present
        driver.findElement(By.xpath("//*[@id=\"ember55\"]")).click();
        assertTrue(!driver.getCurrentUrl().equals("https://www.linkedin.com/job-posting/?jobId=3883489407&jobPostingFlowTrackingId=rvUN2tVITGq%2BVotvJ%2BJILQ%3D%3D&trk=flagship3_job_home"));
        System.out.println("System didn't handle duplicate job offer");
     
    }
	
		

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting Test On Chrome Browser");	
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Finished Test On Chrome Browser");
	}
	
	@AfterClass
	public void shutDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
	
}