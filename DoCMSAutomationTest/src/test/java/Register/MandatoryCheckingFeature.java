package Register;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MandatoryCheckingFeature {
	
	@Given("user berada di register page")
	public void user_berada_di_login_page() {
		Driver.getInstance().navigate().to("http://103.172.204.236:8080/register");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getInstance();
        jsExecutor.executeScript("window.localStorage.setItem('tour', '{\"chapter\":true,\"section\":true,\"manage\":true,\"profile\":true,\"cms\":true,\"metadata\":true}');");
	}
	
	@When("user memasukkan {word}, {word}, {word}, {word}, dan {word}")
	public void user_memasukkan_data_register(String firstName, String lastName, String email, String username, String password) {
		if(firstName.equals("[blank]")) {
			firstName = "";
		}
		if(lastName.equals("[blank]")) {
			lastName = "";
		}
		if(email.equals("[blank]")) {
			email = "";
		}
		if(username.equals("[blank]")) {
			username = "";
		}
		if(password.equals("[blank]")) {
			password = "";
		}
		
		Driver.getInstance().findElement(By.id("input-9")).sendKeys(firstName);
		Driver.getInstance().findElement(By.id("input-12")).sendKeys(lastName);
		Driver.getInstance().findElement(By.id("input-15")).sendKeys(email);
		Driver.getInstance().findElement(By.id("input-18")).sendKeys(username);
		Driver.getInstance().findElement(By.id("input-21")).sendKeys(password);
	}
	
	@When("klik tombol register")
	public void klik_tombol_login() {
		Driver.getInstance().findElement(By.id("register-button")).click();
	}
	
	@Then("sistem menampilkan error pada lokasi {string}")
	public void sistem_menampilkan_error_pada_lokasi(String location) {
		Driver.getInstance().findElement(By.xpath(location)).isDisplayed();
	}
}
