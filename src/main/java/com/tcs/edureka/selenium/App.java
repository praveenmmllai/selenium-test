package com.tcs.edureka.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
	@Test
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new ChromeDriver(chromeOptions);

		System.out.println("Hi, Welcome to testing Edureka bootcamp sample website");

		driver.get("http://192.168.99.100:3001/");

		WebElement username = driver.findElement(By.name("login"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("click"));

		username.sendKeys("devops");
		password.sendKeys("test");
		login.click();

		String loginsucceeded = driver.findElement(By.cssSelector(".alert-link")).getText();
		
		Assert.assertEquals(loginsucceeded, "Login Succeeded");
		
		System.out.println("Test successful");
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.quit();
	}

}
