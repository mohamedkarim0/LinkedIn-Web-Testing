import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApplyforJobOffer {
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
        
        // Job button
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]/a/div")).click();

        //click "Show All" button
        driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[2]")).click();

        //click "Treasury Intern" job
        driver.findElement(By.id("ember569")).click();

        // Get the "Treasury Intern" title 
        String jobtitle = driver.findElement(By.id("ember575")).getText();
        assert jobtitle.equals("Software Engineer IIIIII");

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
        driver.quit();
	}
}
        