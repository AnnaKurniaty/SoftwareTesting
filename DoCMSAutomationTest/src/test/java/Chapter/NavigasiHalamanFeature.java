package Chapter;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Driver.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigasiHalamanFeature {

	@When("membuka sidebar")
	public void membuka_sidebar() {
		String classList = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/aside")).getAttribute("class");
		Boolean isClosed = classList.contains("v-navigation-drawer--close");
		if(isClosed) {
			Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/header/div/button")).click();
			WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-navigation-drawer--open")));
		}
	}
	@Then("sidebar terbuka")
	public void sidebar_terbuka() throws InterruptedException {
		String classList = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/aside")).getAttribute("class");
		Boolean isOpened = classList.contains("v-navigation-drawer--open");
		if(!isOpened) {
			Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/header/div/button")).click();
			WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-navigation-drawer--open")));
		}
		isOpened = Driver.getInstance().findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/aside")).getAttribute("class").contains("v-navigation-drawer--open");
		Assert.assertTrue(isOpened);
	}
	
	// next navigation page
	
	@When("klik tombol chapter")
	public void klik_tombol_chapter() {
		Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-1\"]")).click();
	}

	@When("klik tombol next page")
	public void klik_tombol_next_page() {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
		WebElement element = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li[last()]/button"));

		js.executeScript("arguments[0].click();", element);
	}
	
	@When("klik tombol previous page")
	public void klik_tombol_previous_page() {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
		WebElement element = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li[1]/button"));

		js.executeScript("arguments[0].click();", element);
	}
	
	@When("klik tombol page 2")
	public void klik_tombol_page_2() {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
		List<WebElement> list = Driver.getInstance().findElements(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li"));
		for(WebElement el: list) {
			el = el.findElement(By.xpath("./button"));
			if(el.getText().equals("2")) {
				js.executeScript("arguments[0].click();", el);
				return;
			}
		}
	}
	
	@When("klik tombol page terakhir")
	public void klik_tombol_page_terakhir() {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
		WebElement element = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li[last()-1]/button"));

		js.executeScript("arguments[0].click();", element);
	}

	@Then("sistem menampilkan halaman dua dari chapter")
	public void sistem_menampilkan_halaman_dua_dari_chapter() {
		List<WebElement> list = Driver.getInstance().findElements(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li"));
		for(WebElement el: list) {
			el = el.findElement(By.xpath("./button"));
			if(el.getText().equals("2")) {
				Assert.assertEquals("true", el.getAttribute("aria-current"));
				return;
			}
		}
		Assert.fail("Element not found");
	}
	
	@Then("sistem menampilkan halaman satu dari chapter")
	public void sistem_menampilkan_halaman_satu_dari_chapter() {
		List<WebElement> list = Driver.getInstance().findElements(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li"));
		for(WebElement el: list) {
			el = el.findElement(By.xpath("./button"));
			if(el.getText().equals("1")) {
				Assert.assertEquals("true", el.getAttribute("aria-current"));
				return;
			}
		}
		Assert.fail("Element not found");
	}
	
	@Then("sistem menampilkan halaman terakhir dari chapter")
	public void sistem_menampilkan_halaman_terakhir_dari_chapter() {
		WebElement element = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li[last()-1]/button"));
		Assert.assertEquals("true", element.getAttribute("aria-current"));
	}
	
	@Then("tombol next page tidak dapat ditekan")
	public void tombol_next_page_tidak_dapat_ditekan() {
		WebElement element = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li[last()]/button"));
		Assert.assertTrue(!element.isEnabled());
	}
	@Then("tombol previous page tidak dapat ditekan")
	public void tombol_previous_page_tidak_dapat_ditekan() {
		WebElement element = Driver.getInstance().findElement(By.xpath("//*[@id=\"v-step-chapter-3\"]/ul/li[1]/button"));
		Assert.assertTrue(!element.isEnabled());
	}
}
