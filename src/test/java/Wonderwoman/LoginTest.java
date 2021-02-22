package Wonderwoman;
import org.junit.Test;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	@Test
	public void loginTest() throws InterruptedException, ElementClickInterceptedException {
	try {
	System.setProperty("webdriver.chrome.driver",
	"C:\\Users\\training\\eclipse-workspace\\Batman\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.openmrs.org/openmrs/login.htm");
	String actualUrl="https://demo.openmrs.org/openmrs/login.htm"; String
	expectedUrl= driver.getCurrentUrl(); Assert.assertEquals(actualUrl,
	expectedUrl);
	if(actualUrl.equalsIgnoreCase(expectedUrl)) {
	System.out.println("Test passed"); } else {
	System.out.println("Test failed"); }
	driver.findElement(By.id("username"));
	WebElement username = driver.findElement(By.id("username"));
	driver.findElement(By.id("password"));
	WebElement password = driver.findElement(By.id("password"));
	username.sendKeys("Admin");
	password.sendKeys("Admin123");

	 driver.findElement(By.id("Inpatient Ward")).click();

	 List<WebElement> options = driver.findElements(By.cssSelector("selected"));

	 for (WebElement opt : options) {

	 if (opt.getText().equals("Inpatient Ward")) {

	 opt.click();

	 }

	 }
	driver.findElement(By.id("loginButton"));
	WebElement login = driver.findElement(By.id("loginButton"));
	login.click();
	Thread.sleep(3000);
	driver.findElement(By.id("org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension")).click();

	 List<WebElement> options1 = driver.findElements(By.cssSelector("btn btn-default btn-lg button app big align-self-center"));

	 for (WebElement opt1 : options1) {

	 if (opt1.getText().equals("Active Visits")) {

	 opt1.click();

	 }

	 }

	Thread.sleep(3000);

	 driver.quit();
	}catch(WebDriverException e) {
	System.out.println(e);}
	}
}