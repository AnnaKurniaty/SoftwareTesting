
/**
 * 
 * Nama : Dhiya Fakhar Nafi
 * Kelas : D4 IT-3A
 * NIM : 201524002
 * 
 * SKENARIO UNTUK FIND SECTION
 * 
 * SKENARIO YANG TERSEDIA:
 * 1. Mencari section yang tersedia pada database
 * 2. Mencari section yang tidak ada pada database
 * 
 * Total TC : 2
 */

package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FindSection {

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
	
	// TC 1 : Mendapatkan daftar section yang dicari
	@When("user find section")
	public void user_find_section() {
		driver.findElement(By.xpath("//*[@id="search-bar"]")).sendKeys("Download");
	}

/**
 * SKENARIO KEDUA : TC2 : Mendapatkan daftar section yang kosong
 * @When("user find no one section")
	public void user_find_no_one_section() 
		driver.findElement(By.xpath("//*[@id="search-bar"]")).sendKeys("Halaman");
	}
 * 
 */
	
}
