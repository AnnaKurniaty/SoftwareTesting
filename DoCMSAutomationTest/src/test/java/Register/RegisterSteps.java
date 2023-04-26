package Register;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegisterSteps {
	
	WebDriver driver = null;
	
	
	@Given("browser is openn")
	public void browser_is_openn() {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse workspace\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));	
	}
	
	@And("user is on login pagee")
	public void user_is_on_login_page() {
	driver.navigate().to("http://103.172.204.236:8080/login");
	}
	
	@And("click create account")
	public void click_create_account() {
	driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/div[3]/h5/a")).click();
	}
	
	@When ("user enters {string} and {string} and {string} and {string} and {string}")
	public void user_enters_firstname_and_lastname_and_email_and_username_and_password(String firstname, String lastname, String email, String username, String password) {
	if (firstname.equals("[blank]") ) {
		firstname = "";
	}
	if (lastname.equals("[blank]") ) {
	lastname = "";
	}
	if (email.equals("[blank]") ) {
		email = "";
	}
	if (username.equals("[blank]") ) {
		username = "";
	}
	if (password.equals("[blank]") ) {
		password = "";
		}
		driver.findElement(By.xpath("//*[@id=\"input-21\"]")).sendKeys(firstname); 
		driver.findElement(By.xpath("//*[@id=\"input-24\"]")).sendKeys(lastname); 
		driver.findElement(By.xpath("//*[@id=\"input-27\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"input-30\"]")).sendKeys(username); 
		driver.findElement(By.xpath("//*[@id=\"input-33\"]")).sendKeys(password);
	}
	
	@And("clicks on create button")
	public void user_clicks_on_create_button() {
	driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button")).click();
	}
	
	@Then ("message required firstname")
	public void message_required_firstname() {
	String message = driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[1]/div[1]/div/div/div[2]/div/div/div")).getText();
	assertEquals("Firstname is required", message);
	}
	
	@Then ("message required lastname")
	public void message_required_lastname() {
	String message = driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[1]/div[2]/div/div/div[2]/div/div/div")).getText();
	assertEquals("Lastname is required", message);
	}
	
	@Then ("message required email")
	public void message_required_email() {
	String message = driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[2]/div/div[2]/div/div/div")).getText();
	assertEquals("Email is required", message);
	}
	
	@Then ("message required username")
	public void message_required_username() {
	String message = driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[3]/div/div[2]/div/div/div")).getText();
	assertEquals("Username is required", message);
	}
	
	@Then ("message required password")
	public void message_required_password() {
	String message = driver.findElement(By.xpath("//*[@id=\"register-form\"]/div[4]/div/div[2]/div/div/div")).getText();
	assertEquals("Password is required", message);
	}
}
	