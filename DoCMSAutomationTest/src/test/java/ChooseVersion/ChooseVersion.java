
/**
 * 
 * Nama : Dhiya Fakhar Nafi
 * Kelas : D4 IT-3A
 * NIM : 201524002
 * 
 * SKENARIO UNTUK CHANGE VERSION
 * 
 * SKENARIO YANG TERSEDIA:
 * 1. Memilih versi yang berbeda
 * 2. Memilih versi yang sama
 * 
 * Total TC : 2
 */

package ChooseVersion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ChooseVersion {

	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhiya\\eclipse-workspace-2023\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@Given("user is on portal page")
	public void user_is_on_portal_page() {
		driver.navigate().to("http://103.172.204.236:8080");
	}
	
	// TC 3 : Memilih versi yang berbeda
	@When("user click version")
	public void user_click_version() {
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/div[1]/header/div/div[1]/div/div/div[1]/div[1]/div[1]/div")).click();
	}

	@And("user choose another version")
	public void user_choose_another_version() {
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div")).click();
	}	

/**
 * SKENARIO KEDUA : TC4 : Memilih versi yang sama
 * @And("user choose same version")
	public void user_choose_same_version() {
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/div[1]/header/div/div[1]/div/div/div[1]/div[1]/div[1]/div")).click();
	}

 * 
 */

	
}
