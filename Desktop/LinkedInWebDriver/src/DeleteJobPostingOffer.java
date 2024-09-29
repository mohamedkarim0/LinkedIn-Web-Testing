import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteJobPostingOffer {

	public static void main(String[] args) {
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
        
    
        
        // Job and manage job Button clicks
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]/a/div/div/li-icon/svg/path")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[2]/a")).click();

        // Get job title name
        String jobname = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/main/section/div/div[2]/div/ul/li/div/div/div/div[2]/div[1]/div[1]/div/span/span/a/strong")).getText();

        // Check if the element title matches the expected value
        if (jobname.equals("Software Engineer")) {
        	driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/main/section/div/div[2]/div/ul/li/div/div/div/div[2]/div[1]/div[1]/div/span/span/a/strong")).click();
        	driver.findElement(By.id("ember172")).getText();
        	System.out.println("job is closed");
        }
        else
        	System.out.print("Job is not closed");
        
        driver.quit();
	}

}
