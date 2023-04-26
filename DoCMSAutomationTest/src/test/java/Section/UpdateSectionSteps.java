package Section;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class UpdateSectionSteps {
		WebDriver driver = null;
		
		@Given("browser is open")
		public void browser_is_open() {
			System.setProperty("webdriver.edge.driver", "G:\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
		
		@Given("user is on login page")
		public void user_is_on_login_page() {
			driver.navigate().to("http://103.172.204.236:8080/login/");
		}
		
		@When("user enters {word} and {word}")
		public void user_enters_username_and_password(String username, String password) {
			if(username.equals("<blank>") ) {
				username = "";
			}
			if(password.equals("<blank>") ) {
				password = "";
			}
			driver.findElement(By.xpath("//*[@id=\"input-9\"]")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id=\"input-12\"]")).sendKeys(password);
		}
		
		@And("user clicks on login button")
		public void user_clicks_on_login_button() {
			driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button")).click();
		}
		
		@And("user is on section page")
		public void user_is_on_section_page() {
			driver.findElement(By.xpath("//*[@id=\"v-step-2\"]")).click();
		}
		
		@And("user clicks on first edit section button")
		public void user_clicks_on_first_edit_section_button() {
			driver.findElement(By.xpath("//*[@id=\"v-step-chapter-2\"]/div[1]/table/tr/td[4]/div/a")).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("document.body.style.zoom='50%'");
		}
		
		@When("user fills section title {word}")
		public void user_fills_section_title(String sectionTitle) {
			if(sectionTitle.equals("<blank>") ) {
				sectionTitle = "";
			}
			driver.findElement(By.xpath("//*[@id=\"input-title\"]")).sendKeys(sectionTitle);
		}
		
		@When("user fills section alias {word}")
		public void user_fills_section_alias(String sectionAlias) {
			if(sectionAlias.equals("<blank>") ) {
				sectionAlias = "";
			}
			driver.findElement(By.xpath("//*[@id=\"input-alias\"]")).sendKeys(sectionAlias);
		}
		
		
		@When("user fills section content {word}")
		public void user_fills_section_content(String sectionContent) {
			if(sectionContent.equals("<blank>") ) {
				sectionContent = "";
			}
			driver.findElement(By.xpath("//*[@id=\"v-step-editor-5\"]/div[1]")).sendKeys(sectionContent);
			driver.close();
		}
}