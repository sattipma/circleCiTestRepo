package com;

import org.testng.annotations.Test;
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
	public void testEasy() {
		driver.get("http://assuredev.dequelabs.com/");
		String title = driver.getTitle();
		System.out.println(title);
		
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		//System.out.println("property set...");
		//System.setProperty("webdriver.driver.chrome", "./linuxchrome/chromedriver");
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
