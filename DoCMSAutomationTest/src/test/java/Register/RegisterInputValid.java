package Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RegisterInputValid {
WebDriver driver = null;
	
	@Given("browser is opened")
	public void browser_is_open() {
		System.setProperty("webdriver.edge.driver", "G:\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@Given("user is on register page")
	public void user_is_on_register_page() {
		driver.navigate().to("http://103.172.204.236:8080/register/");
	}
	
//	@When("user enters username and password")
//	public void user_enters_username_and_password() {
//		driver.findElement(By.name("username")).sendKeys("emil");
//		driver.findElement(By.name("password")).sendKeys("anything");
//	}
	
	@When("user enters {word}, {word}, {word}, {word} and {word}")
	public void user_enters_register_data(String firstname, String lastname, String email, String username, String password) {
		if(firstname.equals("<blank>") ) {
			firstname = "";
		}
		if(lastname.equals("<blank>") ) {
			lastname = "";
		}
		if(email.equals("<blank>") ) {
			lastname = "";
		}
		if(username.equals("<blank>") ) {
			lastname = "";
		}
		if(password.equals("<blank>") ) {
			lastname = "";
		}
		driver.findElement(By.xpath("//*[@id=\"input-9\"]")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id=\"input-12\"]")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id=\"input-15\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"input-18\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"input-21\"]")).sendKeys(password);
	}
	
	@And("user clicks on register button")
	public void user_clicks_on_register_button() {
		driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
	}
	
}