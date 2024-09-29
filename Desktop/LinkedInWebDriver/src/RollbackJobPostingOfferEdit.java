import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RollbackJobPostingOfferEdit {

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
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]")).click();
        driver.findElement(By.className("t-black t-bold t-14")).click();

        // Get job title name
        String jobname = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/main/section/div/div[2]/div/ul/li/div/div/div/div[2]/div[1]/div[1]/div/span/span/a/strong")).getText();

        // Check if the element title matches the expected value
        if (jobname.equals("Software Engineer")) {
        	driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/main/section/div/div[2]/div/ul/li/div/div/div/div[2]/div[1]/div[1]/div/span/span/a/strong")).click();
            driver.findElement(By.className("hiring-edit-action hiring-edit-action__top-right")).click();

            // Click on remove button
            driver.findElement(By.xpath("//*[@id=\"hiring-screening-questions-ember112\"]/div/a/svg")).click();

            // Assert screen question element not found
            assert driver.findElements(By.xpath("//*[@id=\"hiring-screening-questions-ember112\"]/div/a/svg")).isEmpty();

            // Click save
            driver.findElement(By.id("ember143")).click();
            System.out.println("Job Updated");
        } else {
            System.out.println("No job found with the name 'Software Engineer'.");
        }
        
        driver.quit();
	}

}
