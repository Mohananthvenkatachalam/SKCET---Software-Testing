package q1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import freemarker.log.Logger;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;
    XSSFWorkbook workbook;
    WebDriverWait wait;
    String city;
    Logger logger;

    @BeforeTest
    public void AtBefore() throws IOException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        FileInputStream file = new FileInputStream(
                "D:\\programming\\vs code programs\\vs code\\Software Testing\\SKCET - Software Testing\\Model Lab\\q1\\src\\Excel\\city.xlsx");

        workbook = new XSSFWorkbook(file);

        city = workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        logger = (Logger) LogManager.getLogger(getClass());

    }

    @Test
    public void shouldAnswerWithTrue() throws IOException {
        System.out.println(city);
        // get the website
        driver.get("https://www.opentable.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // input the city bangalore and click lets got
        driver.findElement(By.xpath("//*[@id=\"home-page-autocomplete-input\"]")).sendKeys(city);
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/header/div/span/div/div/div[2]/div[2]/button")).click();

        // filter asian
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"mainContent\"]/div/section/div[6]/div/label[4]/span[2]")));
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section/div[6]/div/label[4]/span[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // click fare east hotel
        // wait.until(ExpectedConditions.visibilityOfElementLocated(
        // By.xpath("//*[@id=\"mainContent\"]/div/div/div[2]/div/div[2]/div[1]/div[1]/a")));
        // driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[2]/div/div[2]/div[1]/div[1]/a")).click();
        driver.get(
                "https://www.opentable.com/r/far-and-east-four-seasons-hotel-bengaluru?corrid=3baca308-2fc4-4503-8a0a-0d57ed3a0205&avt=eyJ2IjoyLCJtIjoxLCJwIjowLCJzIjowLCJuIjowfQ&p=2&sd=2024-05-02T19%3A00%3A00");

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "D:\\programming\\vs code programs\\vs code\\Software Testing\\SKCET - Software Testing\\Model Lab\\q1\\output.png";
        FileUtils.copyFile(file, new File(path));

        // giving the file input
        Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"restProfileMainContentDtpPartySizePicker\"]")));
        sel.selectByIndex(3);

        String tile = driver
                .findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[1]/section[2]/div[1]/div[1]/h1"))
                .getText();
        if (tile.contains("East")) {
            logger.info("In the Right Page");
        } else {
            logger.error("No in the Right page");
        }

        Select time = new Select(
                driver.findElement(By.xpath("//*[@id=\"restProfileMainContenttimePickerDtpPicker\"]")));
        time.selectByVisibleText("6:30 PM");

        // click the sign in button
        driver.findElement(By.xpath("//*[@id=\"baseApp\"]/div/header/div[2]/div[2]/div[1]/button")).click();

    }

    @AfterTest
    public void AfterTheTest() throws IOException, InterruptedException {
        Thread.sleep(10000);
        workbook.close();
        driver.quit();
    }
}
