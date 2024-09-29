import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ReopenJobOffer {
	int currentTest= 0;
	WebDriver driver ;
	@BeforeClass
	public void start() throws InterruptedException {
		String baseUrl = "https://www.linkedin.com/feed/";
		System.out.println("Launching Google Chrome browser");
		
		driver = new ChromeDriver();
		driver.get(baseUrl);
		
		String testTitle = "LinkedIn Login, Sign in | LinkedIn";
		
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, testTitle);
		System.out.println(originalTitle);
		
		// Sign in
		driver.findElement(By.id("username")).sendKeys("mohamed214991@bue.edu.eg");
        driver.findElement(By.id("password")).sendKeys("H_%$_5z%?mYK5_7");
        driver.findElement(By.className("login__form_action_container")).submit();
        Thread.sleep(15000);
	}
	
	@Test
    public void testReopenJobOffer() throws InterruptedException {
    
        // Navigate to Jobs section
		driver.findElement(By.xpath("/html/body/div[5]/header/div/nav/ul/li[3]")).click();
        Thread.sleep(3000);

        // Navigate to Manage Jobs
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[2]/a")).click();
        Thread.sleep(3000);

        // Filter for closed jobs
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/main/section/div/div[1]/ul/li[2]/button"));

        // Get the job title of the first job
        String jobTitle = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/main/section/div/div[2]/div/ul/li/div/div/div/div[2]/div[1]/div[1]/div/span/span/a/string")).getText();
        System.out.println(jobTitle);

        // Assert the job title
        assertEquals("Software Engineer IIIIII", jobTitle);

        if (jobTitle.equals("Software Engineer IIIIII")) {
            // Click on the option dropdown
            WebElement optionDropdown = driver.findElement(By.id("ember202"));
            optionDropdown.click();

            // Select the second option from the dropdown and has options
            Select dropdown = new Select(optionDropdown);
            dropdown.selectByIndex(1);
            System.out.println("Job Closed");
            assertTrue(dropdown.getOptions().size() > 0);

            // Assert the option is selected
            WebElement selectedOption = dropdown.getFirstSelectedOption();
            assertEquals("Second Option", selectedOption.getText());
        } else {
            System.out.println("Not chosen job offer");
        }
    }
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting The Test with number: " + (++currentTest));	
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Finished The Test with number: " + (currentTest));
	}
	
	@AfterClass
	public void shutDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
