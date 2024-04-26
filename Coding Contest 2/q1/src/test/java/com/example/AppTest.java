package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    public WebDriver driver;
    public String xpath = "D:\\programming\\vs code programs\\vs code\\Software Testing\\SKCET - Software Testing\\Coding Contest 2\\q1\\src\\Excel\\ExSheet.xlsx";
    public XSSFWorkbook workbook;
    public WebDriverWait wait;

    @BeforeTest
    public void Initialization() throws IOException {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        FileInputStream file = new FileInputStream(xpath);
        workbook = new XSSFWorkbook(file);
    }

    @Test
    public void verifyChetan() {
        // get the url
        driver.get("https://www.barnesandnoble.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // click all and select book
        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();

        // take the author name from the excel and place it and search
        XSSFSheet s1 = workbook.getSheetAt(0);
        String author = s1.getRow(1).getCell(0).getStringCellValue();
        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[2]/div/input[1]"))
                .sendKeys(author);
        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/span/button")).click();

        // Verify that it contains Chetan Bhagat
        String res = driver
                .findElement(By.xpath("//*[@id=\"searchGrid\"]/div/section[1]/section[1]/div/div[1]/div[1]/h1/span"))
                .getText();
        if (res.equals("Chetan Bhagat")) {
            System.out.println("Yes is Contains Chetan Bhagat");
        } else {
            System.out.println("No it does not contain Chetan Bhagat");
        }
        driver.close();
    }

    @Test
    public void AudioBooks() {

        // get the url
        driver.get("https://www.barnesandnoble.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div/ul/li[5]"))).build()
                .perform();
        driver.findElement(
                By.xpath("//*[@id=\"navbarSupportedContent\"]/div/ul/li[5]/div/div/div[1]/div/div[2]/div[1]/dd/a[1]"))
                .click();

        // Add to Cart
        driver.findElement(By.xpath("//*[@id=\"addToBagForm_2940159543998\"]/input[11]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"plpErrors\"]/em")));

        String txt = driver.findElement(By.xpath("//*[@id=\"plpErrors\"]/em")).getText();

        System.out.println(txt);

        driver.close();
    }

    @Test
    public void BandN() {
        // get the url
        driver.get("https://www.barnesandnoble.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // navigate to n and b
        driver.findElement(By.linkText("B&N MEMBERSHIP")).click();

        // click the rewards
        driver.findElement(By.id("rewards-model-link")).click();

        WebElement ele = driver.findElement(By.xpath("/html/body/div[7]/div/iframe"));
        driver.switchTo().frame(ele);
    }
}
