package Section;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchSectionSteps {
	
	WebDriver driver = null;
	
	
	@Given("user is in homepage")
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
	
	@And("click on section button")
	public void click_on_section_button(){
		driver.findElement(By.xpath("//*[@id=\"v-step-2\"]")).click();
	}
	@When("user enters {string}")
	public void user_enters_keyword(String keyword){
		driver.findElement(By.xpath("//*[@id=\"v-step-chapter-1\"]")).sendKeys(keyword);
	}
//	@Then("search results is displayed")
//	public void search_results_is_displayed(){
//		driver.findElement(By.xpath("//*[@id=\"app\"]")).click();
//	}
}
