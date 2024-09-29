import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplyforJobOffer {
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
    public void testApplyforJobOffer() throws InterruptedException {
        // Click on Job button
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]/a/div")).click();
        Thread.sleep(1000);

        // Click "Show All" button
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[2]")).click();
        Thread.sleep(1000);

        // Click "Treasury Intern" job
        driver.findElement(By.id("ember569")).click();
        Thread.sleep(1000);

        // Get the "Treasury Intern" title 
        String jobtitle = driver.findElement(By.id("ember575")).getText();
        
        // Assert job title using assertTrue
        assertTrue(jobtitle.contains("Software Engineer"));

        // Get the apply type
        String applyType = driver.findElement(By.id("ember606")).getText();
        
        if (applyType.equals("Easy Apply")) {
            driver.findElement(By.id("ember606")).click();
            driver.findElement(By.id("ember574")).sendKeys("Cairo");

            // Assert error element is not present 
            if (!driver.findElements(By.className("artdeco-inline-feedback__message")).isEmpty())
            {
                System.out.println("Error element is present.");
            } else {
                driver.findElement(By.id("ember1626")).click();
                driver.findElement(By.xpath("//*[@id=\"ember1626\"]")).click();
                driver.findElement(By.id("ember1637")).click();
                System.out.println("Job Applied");
            }
        } else {
            System.out.println("Can't apply for this job outside our scope.");
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
