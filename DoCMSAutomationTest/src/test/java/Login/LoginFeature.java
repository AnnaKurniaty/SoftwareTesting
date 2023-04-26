package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeature {
	@Given("browser terbuka")
	public void browser_terbuka() {
		Driver.getInstance();
	}
	
	@Given("user berada di login page")
	public void user_berada_di_login_page() {
		Driver.getInstance().navigate().to("http://103.172.204.236:8080/login");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getInstance();
        jsExecutor.executeScript("window.localStorage.setItem('tour', '{\"chapter\":true,\"section\":true,\"manage\":true,\"profile\":true,\"cms\":true,\"metadata\":true}');");
	}
	
	@When("user memasukkan {word} dan {word}")
	public void user_memasukkan_username_dan_password(String username, String password) {
		if(username.equals("[blank]")) {
			username = "";
		}
		if(password.equals("[blank]")) {
			password = "";
		}
		
		Driver.getInstance().findElement(By.id("input-9")).sendKeys(username);
		Driver.getInstance().findElement(By.id("input-12")).sendKeys(password);
	}
	
	@When("klik tombol login")
	public void klik_tombol_login() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"inspire\"]/div/div/div/div[1]/div/form/button")).click();
	}
	
	@Then("user diarahkan ke home page")
	public void user_diarahkan_ke_home_page() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/header/div/div[1]/img")).isDisplayed();
	}
	
	/*
	 * Usage: Given user berada di home page dengan username <username> dan password <password>
	 * Example: Given user berada di home page dengan username mfauzirh dan password fauzicakepgituloh
	 */
	@Given("user berada di home page dengan username {word} dan password {word}")
	public void user_berada_di_home_page(String username, String password) {
	    this.user_berada_di_login_page();
	    this.user_memasukkan_username_dan_password(username, password);
	    this.klik_tombol_login();
	    this.user_diarahkan_ke_home_page();
	}
}
