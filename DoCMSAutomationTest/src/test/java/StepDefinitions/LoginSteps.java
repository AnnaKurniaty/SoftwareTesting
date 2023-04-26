package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	
	WebDriver driver = null;
	
	
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse workspace\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));	
	}
	
	@And("user is on login page")
	public void user_is_on_login_page() {
	driver.navigate().to("http://103.172.204.236:8080/login");
	}
	
	@When ("user enters {string} and {string}")
	public void user_enters_username_and_password(String username, String password) {
	if (username.equals("[blank]") ) {
		username = "";
	}
	if (password.equals("[blank]") ) {
		password = "";
	}
		driver.findElement(By.xpath("//*[@id=\"input-9\"]")).sendKeys(username); 
		driver.findElement(By.xpath("//*[@id=\"input-12\"]")).sendKeys(password);
	}
	
	@And("clicks on login button")
	public void user_clicks_on_login_button() {
	driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button")).click();
	}
	
	@Then ("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
	driver.findElement(By.xpath("//*[@id=\"app\"]")).isDisplayed();
//	driver.close(); 
//	driver.close();
	}
	
	@Then ("user got error message")
	public void user_got_error_message() {
	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div")).isDisplayed();
	
	}
	
	@Then ("username blank")
	public void username_blank() {
	driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/div[1]/div/div[2]/div/div/div")).isDisplayed();
	
	}
	
	@Then ("password blank")
	public void password_blank() {
	driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/div[2]/div/div[2]/div/div")).isDisplayed();
	}
}
