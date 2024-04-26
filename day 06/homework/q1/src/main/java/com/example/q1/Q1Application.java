package com.example.q1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Q1Application {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions()
				.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.moneycontrol.com/");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_str")));

		driver.findElement(By.id("search_str")).sendKeys("Reliance Industries");

		SpringApplication.run(Q1Application.class, args);
	}

}
