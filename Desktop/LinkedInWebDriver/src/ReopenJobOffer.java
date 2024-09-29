import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReopenJobOffer {

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

        Thread.sleep(1000);
        
        // Find and click the "Job" button
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]")).click();

        // Find and click the "Manage Job" button
        driver.findElement(By.className("t-black t-bold t-14")).click();
        Thread.sleep(1000);
        
        // Find and click the "Closed" button
        driver.findElement(By.xpath("//*[@id=\"search-reusables__filters-bar\"]/ul/li[3]/button")).click();

        String jobTitle = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/main/section/div/div[2]/div/ul/li/div/div/div/div[2]/div[1]/div[1]/div/span/span/a/string")).getText();

        System.out.println(jobTitle);
        if (jobTitle.equals("Software Engineer IIIIII")) {
            assert jobTitle.equals("Software Engineer IIIIII");

            // Click on the option dropdown
            WebElement optionDropdown = driver.findElement(By.id("ember202"));
            optionDropdown.click();

            // Select the second option from the dropdown
            Select dropdown = new Select(optionDropdown);
            dropdown.selectByIndex(1);
            System.out.println("Job Closed");
        } else {
            System.out.println("Not chosen job offer");
        }
        
        driver.quit();

	}

}
