package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    WebDriver driver;

    @BeforeTest
    public void beforeTheTest() {
        driver = new ChromeDriver();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {

        // getting into the page
        driver.get("https://economictimes.indiatimes.com/et-now/results");

        // creating xplicit wait
        @SuppressWarnings("rawtypes")
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(60000));

        // click the mutual funds
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mutual Funds")));
        driver.findElement(By.xpath("//*[@id=\"topnav\"]/div[10]")).click();

        // scrolling down for the form
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");

        // select Canare Robeco
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"amcSelection\"]")));
        select.selectByVisibleText("Canara Robeco");

        // select the next option
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("schemenm"))));
        Select st = new Select(driver.findElement(By.id("schemenm")));
        st.selectByValue(null);

        // summiting it
        driver.findElement(By.xpath("//*[@id=\"anchor3\"]")).click();

        // this will navigate to another page and the we want to handle on that
        // editing the inverstment growth
        driver.findElement(By.xpath("//*[@id=\"installment_type\"]/li/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_amt\"]/li/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li/ul/li[4]")).click();

        // navigate to the return session
        driver.findElement(By.xpath("//*[@id=\"mfNav\"]/div/ul/li[2]")).click();

        // get the text of the first row
        String str = driver.findElement(By.xpath("//*[@id=\"mfReturns\"]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"))
                .getText();
        System.out.print(str);
    }

    @AfterTest
    public void AfterTheTest() {
        driver.quit();
    }
}
