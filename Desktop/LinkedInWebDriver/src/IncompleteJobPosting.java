import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

public class IncompleteJobPosting {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
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
            companyNameField.sendKeys("Engyineer");
        }

        // Assert value in the company name field
        assert companyNameField.getAttribute("value").equals("Egyineer");
        
        // Open workplace dropdown menu and choose "Remote"
        driver.findElement(By.id("ember40")).click();
        driver.findElement(By.id("ember42")).click();

        // Type in job location field ""
        driver.findElement(By.id("location-typeahead-input-ember43")).sendKeys("");

        // Click on "get started" and assert an element not present
        driver.findElement(By.id("location-typeahead-input-ember43")).click();

        assert driver.findElement(By.className("ember166")).isDisplayed();
        System.out.println("System handled empty field in posting job offer");

        // Close the WebDriver instance
        driver.quit();
        
	}
}

        
    