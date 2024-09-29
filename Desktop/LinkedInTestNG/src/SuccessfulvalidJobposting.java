import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SuccessfulvalidJobposting {
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
    public void testFirstPage() throws InterruptedException {
		// Navigate to job postings
        driver.findElement(By.xpath("/html/body/div[5]/header/div/nav/ul/li[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[1]")).click();
        Thread.sleep(10000);
        
        // Click on feedback
         driver.findElement(By.id("ember226")).click();

        // Verify feedback element is displayed
        assertFalse(driver.findElement(By.id("artdeco-hoverable-artdeco-gen-42")).isDisplayed());

        // Type job title
        WebElement companyNameField = driver.findElement(By.id("company-typeahead-input-ember34"));
        companyNameField.sendKeys("Software Engineer IIIIII");

        // Check and correct company name
        String companyName = companyNameField.getAttribute("value");
        if (!companyName.equals("Egyineer")) {
            companyNameField.clear();
            companyNameField.sendKeys("Engyineer");
        }
        
        // Assert company name
        assert(companyName.equals("Egyineer"));

        // Select workplace from dropdown menu option
        driver.findElement(By.id("ember40")).click();
        driver.findElement(By.id("ember42")).click();

        // Type in job location
        driver.findElement(By.id("location-typeahead-input-ember43")).sendKeys("H91 HDF8, Galway, County Galway, Ireland");

        // Click on "get started"
        driver.findElement(By.xpath("//*[@id=\"ember55\"]")).click();
    }

    @Test
    public void testSecondPage() throws InterruptedException {
        // Find and fill the description field
        driver.findElement(By.className("ql-editor")).sendKeys("The ideal candidate will be responsible for developing high-quality applications. They will also be responsible for designing and implementing testable and scalable code. \n\n \n\nResponsibilities\n\nDevelop quality software and web applications\n");
        // Click on the next button
        WebElement nextButton = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[3]/div/div/main/section/form/footer/div[2]/div/button[2]"));
        nextButton.click();

        // Assert no feedback
        assertTrue(driver.findElements(By.className("application-outlet")).isEmpty());
    }

    @Test
    public void testThirdPage() {
        // From "Receive applicants" dropdown choose "By email"
        driver.findElement(By.id("receiveApplicantsDropdownId")).click();
        driver.findElement(By.xpath("//option[contains(text(), 'By email')]")).click();

        // Fill "mohamed214991@bue.edu.eg" in Email Field
        driver.findElement(By.id("emailFieldId")).sendKeys("mohamed214991@bue.edu.eg");

        // Click on Add Custom Question
        driver.findElement(By.id("ember469")).click();

        // Input Field
        driver.findElement(By.id("input-uid-ember489")).sendKeys("Do you live in Egypt?");

        // Choose "YES / NO" from Response type dropdown menu
        Select responseTypeDropdown = new Select(driver.findElement(By.id("ember491")));
        responseTypeDropdown.selectByVisibleText("YES / NO");

        // Choose "YES" from ideal Answer Dropdown menu
        Select idealAnswerDropdown = new Select(driver.findElement(By.id("ember492")));
        idealAnswerDropdown.selectByVisibleText("YES");

        // Assert the chosen item from Response type dropdown is "YES / NO"
        String selectedResponseType = responseTypeDropdown.getFirstSelectedOption().getText();
        assertEquals("YES / NO", selectedResponseType);

        // Assert the chosen item from ideal Answer dropdown is "YES"
        String selectedIdealAnswer = idealAnswerDropdown.getFirstSelectedOption().getText();
        assertEquals("YES", selectedIdealAnswer);
    }

    @Test
    public void testFourthPage() {
        // Press on edit button
        driver.findElement(By.id("ember259")).click();

        // Type 400 in the budget field
        driver.findElement(By.id("budget-setter-input")).clear();
        driver.findElement(By.id("budget-setter-input")).sendKeys("400");

        // Click on the promote button
        driver.findElement(By.id("ember283")).click();

        // Assert message is not displayed
        assertTrue(driver.findElements(By.className("job-posting-shared-budget-setter__budget-text")).isEmpty());

    }
	
		
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting The Test with number: " + (++currentTest));	
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Finished The Test with number: " + (currentTest)+"\n");
	}
	
	@AfterClass
	public void shutDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
