package com.q1.q1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Q1Application {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		// go to the page
		driver.get("https://demowebshop.tricentis.com/");

		// click the jelery
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a")).click();

		// verifying that we are in the jwelery url or not
		if (driver.getCurrentUrl().contains("jwelery")) {
			System.out.print("Presents");
		} else {
			System.out.print("Not Present");
		}
		// back to the home page
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[1]/ul/li[1]/a")).click();

		// verifying that we are in the home page or not
		if (driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/")) {
			System.out.print("Url Matches");
		} else {
			System.out.print("Url does Not Matches");
		}

		// print the title of the page
		System.out.print(driver.getTitle());

		driver.close();

		// getting the next page
		WebDriver driver2 = new ChromeDriver();
		driver2.get("https://www.demoblaze.com/");

		// clicking the phone chategory
		driver2.findElement(By.xpath("//*[@id=\"itemc\"]")).click();

		// clicking the ist phone
		driver2.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")).click();

		// verify it having the required title
		if (driver2.getTitle() == "Samsung Galazy s6") {
			System.out.print("Satsified");
		} else {
			System.out.print("Not Satsified");
		}
		// navigate to the previous page
		driver2.navigate().back();

		// refresh the page
		driver2.navigate().refresh();

		// making it as full page
		driver2.manage().window().fullscreen();

		// page title
		System.out.println(driver2.getTitle());

		// length of the page
		JavascriptExecutor js = (JavascriptExecutor) driver2;
		System.out.print(js.executeScript("return document.body.scrollHeight;"));

		driver2.close();

		SpringApplication.run(Q1Application.class, args);
	}

}
