package com.example.q2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Q2Application {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://economictimes.indiatimes.com/et-now/results");

		driver.findElement(By.xpath("//*[@id=\"topnav\"]/div[10]")).click();

		// Select sel = new
		// Select(driver.findElement(By.xpath("//*[@id=\"amcSelection\"]")));

		// sel.selectByVisibleText("Canara Robeco");

		// Select st = new
		// Select(driver.findElement(By.xpath("//*[@id=\"schemenm\"]")));

		// st.selectByIndex(4);

		SpringApplication.run(Q2Application.class, args);
	}

}
