package com.q1.q1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Q1Application {

	public static void main(String[] args) throws InterruptedException {

		WebDriver chromeWebDriver = new ChromeDriver();
		WebDriver edgeDriver = new EdgeDriver();
		WebDriver internetDriver = new InternetExplorerDriver();
		WebDriver fireFoxDriver = new FirefoxDriver();

		// creating a chrome, firefox, edge, internet Explorer driver and getting the
		// google.com page
		chromeWebDriver.get("https://google.com/");
		chromeWebDriver.close();
		internetDriver.get("https://google.com/");
		internetDriver.close();
		edgeDriver.get("https://google.com/");
		edgeDriver.close();
		fireFoxDriver.get("https://google.com/");
		fireFoxDriver.close();

		// getting the shoppers page and clicking the profile image
		internetDriver.get("https://www.shoppersstop.com/");
		internetDriver.findElement(By.id("user-icon")).click();
		Thread.sleep(5000);
		internetDriver.close();

		SpringApplication.run(Q1Application.class, args);
	}

}
