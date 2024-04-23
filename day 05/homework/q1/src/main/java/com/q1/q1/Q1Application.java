package com.q1.q1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Q1Application {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		// get the page
		driver.get("https://magento.softwaretestingboard.com/");

		// search shores
		driver.findElement(By.id("search")).sendKeys("shoes");
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[1]/label")).click();

		// hover on the mens
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"))).build().perform();

		// selects tops
		driver.findElement(By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div[2]/div/ul[1]/li[1]/a")).click();

		// navigate back to the page
		Thread.sleep(3000);
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol/li[1]/div/div/strong/a"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-56\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("4");

		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).submit();

		Thread.sleep(3000);
		driver.close();

		SpringApplication.run(Q1Application.class, args);
	}

}
