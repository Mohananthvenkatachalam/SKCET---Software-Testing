package com.q1.q1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Q1Application {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		// geting to the demoblaze website
		driver.get("https://www.demoblaze.com/");

		// clicking the laptop items
		driver.findElement(By.xpath("//*[@id=\"itemc\"]")).click();

		Thread.sleep(30000);
		// click the mackbook air
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[3]/div")).click();

		// give add to cart
		driver.findElement(By.linkText("Add to cart")).click();

		// click the ok buttorn in the alert
		driver.switchTo().alert().accept();
		driver.navigate().back();

		// go to cart
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]")).click();

		// get text
		System.out.print(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[2]")).getText());

		// close the driver
		driver.close();

		SpringApplication.run(Q1Application.class, args);
	}
}
