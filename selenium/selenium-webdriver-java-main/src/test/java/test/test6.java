package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class test6 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Step 1: Go to ("https://chiliclub.vn/");
        driver.get("https://chiliclub.vn/");

        // Step 2: Click on ""
        WebElement allProducts = driver.findElement(By.xpath("//a[@title='Tất Cả Sản Phẩm']"));
        allProducts.click();

        // Step 3: Read the cost of "product(460 cành)"
        WebElement ab = driver.findElement(By.xpath("//div[@class='content-product-list product-list " +
                "filter clearfix']//div[1]//div[1]//div[2]//div[1]//div[1]//p[1]//span[1]"));
        String cd = ab.getText();
        System.out.println("The cost of the product: " + cd);

        // Step 4: Click on "Luôn Bên Em"
        WebElement go = driver.findElement(By.xpath("//a[normalize-space()=" +
                "'Áo thun Needed CHILICLUB(5 màu)']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", go);

        // Step 5: Read the price of "Luôn Bên Em"
        WebElement sonyXperiaMobileDetail = driver.findElement(By.cssSelector("div[id='price-preview'] span[class='pro-price']"));
        String sonyXperiaMobileDetailText = sonyXperiaMobileDetail.getText();
        System.out.println("The price of product in detail page is: " + sonyXperiaMobileDetailText);

        // Step 6: Compare the price in the list and detail pages
        WebElement ef = driver.findElement(By.cssSelector("div[id='price-preview'] span[class='pro-price']"));
        String sonyXperiaDetailPriceText = ef.getText();
        if (cd.equals(sonyXperiaDetailPriceText)) {
            System.out.println("The product price in the list and detail pages is equal.");
        } else {
            System.out.println("The product price in the list and detail pages is not equal.");
        }

        // Take a screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile,
                    new File(".\\img\\test3.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Close the browser
        driver.quit();
    }
}
