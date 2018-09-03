package com;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TestTitle {
	private WebDriver driver = null;

	@Test
	public void testAssure() {
		driver.get("http://qaassure.dequecloud.com");
		//driver.get("http://localhost:8080");
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		Assert.assertTrue(title.contains("Sign in to Deque"));
		driver.findElement(By.id("email")).sendKeys("harish");
		driver.findElement(By.xpath("//*[@id='login-email-section']/form/button")).click();
		driver.findElement(By.id("password-field")).sendKeys("Deque2013");
		driver.findElement(By.xpath("//*[@id='login-password-section']/form/button")).click();
		title = driver.getTitle();
		System.out.println("Title: "+title);
		Assert.assertTrue(title.contains("Home - WorldSpace Assure"));		
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		System.out.println("starting chrome driver...");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("platform", "LINUX");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		System.out.println("chrome driver started...");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
