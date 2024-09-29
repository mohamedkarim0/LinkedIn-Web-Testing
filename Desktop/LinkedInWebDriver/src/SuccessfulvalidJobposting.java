
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SuccessfulvalidJobposting {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","E:\\[Downloads]\\All Libraries\\chromedriver-win64\\chromedriver.exe"); 

		// Create a new instance of the Chrome driver
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("--remote-allow-origins=*");
	    ChromeDriver driver = new ChromeDriver(option);

	    //Launch the Website
	    driver.get("https://www.linkedin.com/feed/");

	    //Sign in
        driver.findElement(By.id("username")).sendKeys("mohamed214991@bue.edu.eg");
        driver.findElement(By.id("password")).sendKeys("H_%$_5z%?mYK5_7"); 
        driver.findElement(By.className("login__form_action_container")).submit();
        
        Thread.sleep(25000);
        
        driver.findElement(By.xpath("/html/body/div[5]/header/div/nav/ul/li[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[1]")).click();
        Thread.sleep(5000);
        
        
        //------------FIRST PAGE----------------------
     // Click on feedback
        driver.findElement(By.id("ember28")).click();
        // Verify feedback element is displayed
        assert driver.findElement(By.id("artdeco-hoverable-artdeco-gen-42")).isDisplayed();
             

        // Click on job title field and type "Software Engineer IIIIII"
        driver.findElement(By.id("company-typeahead-input-ember34")).sendKeys("Software Engineer IIIIII");

        // Get value in the company name field and save it in a variable
        WebElement companyNameField = driver.findElement(By.id("company-typeahead-input-ember34"));
        String companyName = companyNameField.getAttribute("value");

        if (companyName.equals("Egyineer")) {
            System.out.println("Egyineer");
        } else {
            companyNameField.clear();
            companyNameField.sendKeys("Egyineer");
        }

        // Assert value in the company name field
        assert companyNameField.getAttribute("value").equals("Egyineer");
        

        // Open workplace dropdown menu and choose "Remote"
        driver.findElement(By.id("ember40")).click();
        driver.findElement(By.id("ember42")).click();

        // Type in job location field "H91 HDF8, Galway, County Galway, Ireland"
        driver.findElement(By.id("location-typeahead-input-ember42")).sendKeys("H91 HDF8, Galway, County Galway, Ireland");
        Thread.sleep(10000);
        // Click on "get started" and assert an element not present
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/section/div/form/button")).click();

        assert driver.findElements(By.className("application-outlet")).isEmpty();
        System.out.println("First Page Succeeded");

        
        //------------SECOND PAGE----------------------
        // Find and fill the description field
        WebElement descriptionField = driver.findElement(By.className("ql-editor"));
        descriptionField.sendKeys("The ideal candidate will be responsible for developing high-quality applications. They will also be responsible for designing and implementing testable and scalable code. \n\n \n\nResponsibilities\n\nDevelop quality software and web applications\n");

        // Click on the next button
        WebElement nextButton = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[3]/div/div/main/section/form/footer/div[2]/div/button[2]"));
        nextButton.click();
        //--Assert no feedback
        assert driver.findElements(By.className("application-outlet")).isEmpty();
        System.out.println("Second Page Succeeded");
        
        
         //------------THIRD PAGE----------------------
        
         // From "Receive applicants" dropdown choose "By email"
        WebElement receiveApplicantsDropdown = driver.findElement(By.id("receiveApplicantsDropdownId"));
        receiveApplicantsDropdown.click();
        WebElement byEmailOption = driver.findElement(By.xpath("//option[contains(text(), 'By email')]"));
        byEmailOption.click();

        // Fill "mohamed214991@bue.edu.eg" in Email Field
        WebElement emailField = driver.findElement(By.id("emailFieldId"));
        emailField.sendKeys("mohamed214991@bue.edu.eg");
        
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
        assert selectedResponseType.equals("YES / NO");

        // Assert the chosen item from ideal Answer dropdown is "YES"
        String selectedIdealAnswer = idealAnswerDropdown.getFirstSelectedOption().getText();
        assert selectedIdealAnswer.equals("YES");
      	System.out.println("Third Page Succeeded");

        //------------FOURTH PAGE--------------
        
      	//Press on edit button
      	driver.findElement(By.id("ember259")).click();

      	// Type 400 in the budget field
        driver.findElement(By.id("budget-setter-input")).clear();
        driver.findElement(By.id("budget-setter-input")).sendKeys("400");

        // Click on the promote button
        WebElement promoteButton = driver.findElement(By.id("ember283"));
        promoteButton.click();

        // Assert message is not displayed
        assert driver.findElements(By.className("job-posting-shared-budget-setter__budget-text")).isEmpty();
        System.out.println("Fourth Page Succeeded");
        System.out.println("Job Posted Successfully");
        // Close the WebDriver instance
        driver.quit();

	}

}
