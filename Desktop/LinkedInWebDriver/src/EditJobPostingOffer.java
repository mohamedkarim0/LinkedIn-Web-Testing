import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditJobPostingOffer {

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
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[3]/a/div/div/li-icon")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[3]/div/div/div/div/div/div[1]/nav/div[2]/ul/li[2]/a")).click();

        // Get job title name
        String jobname = driver.findElement(By.className("display-flex")).getText();

        // Check if the element title matches the expected value
        if (jobname.equals("Software Engineer")) {
        	driver.findElement(By.className("display-flex")).click();
            driver.findElement(By.xpath("//*[@id=\"hiring-screening-questions-ember361\"]/div/at")).click();

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

            // Click continue and save
            driver.findElement(By.id("ember479")).click();
            driver.findElement(By.id("ember513")).click();
            
            System.out.println("Job is Updated");
        } else {
            System.out.println("No job found with the name 'Software Engineer'.");
        }
        
        
        
        driver.quit();
	}

}
