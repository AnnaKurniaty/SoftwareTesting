package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LogoutSteps {
	
	WebDriver driver = null;
	
	@Given("user in homepage")
	public void user_in_homepage() {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse workspace\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));	
		
		driver.navigate().to("http://103.172.204.236:8080/login");
		
		driver.findElement(By.xpath("//*[@id=\"input-9\"]")).sendKeys("victornat"); 
		driver.findElement(By.xpath("//*[@id=\"input-12\"]")).sendKeys("Victor123");
		
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]")).isDisplayed();
	}
	
	@And("clicks on profile")
	public void clicks_on_profile(){
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/header/div/div[2]/button/span")).click();
	}
	
	
	@And("clicks on logout")
	public void clicks_on_logout() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/button/span")).click();
	}
	
	@Then("navigate login page")
	public void navigate_login_page() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div")).isDisplayed();
	}
	
}
