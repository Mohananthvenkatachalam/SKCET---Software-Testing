package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     * 
     */

    WebDriver driver;

    @BeforeTest
    public void Before() {
        driver = new ChromeDriver();
    }

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {

        driver.get("https://www.moneycontrol.com/");

        Thread.sleep(3000);
        driver.navigate().refresh();
        WebElement search = driver.findElement(By.id("search_str"));

        search.sendKeys("Reliance Industries\n");

        // click the reliance industry ltd
        driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/p/a"))
                .click();

        // click on the money fund
        driver.findElement(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]/a")).click();

        // click on the sip
        driver.findElement(By.xpath("//*[@id=\"mc3_return\"]/div[1]/ul/li[2]")).click();

        Thread.sleep(3000);
    }

    @AfterTest
    public void After() {
        driver.close();
    }
}
