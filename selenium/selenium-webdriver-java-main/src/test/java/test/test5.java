package test;
// Import required packages

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class test5 {
    public static void main(String[] args) throws InterruptedException {
        // Set the path of ChromeDriver executable

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Step 1. Go to https://chiliclub.vn/
        driver.get("https://chiliclub.vn/");



        // Step 3: Click on -> TẤT CẢ SẢN PHẨM
        WebElement allProducts = driver.findElement(By.xpath("//a[@title='Tất Cả Sản Phẩm']"));
        allProducts.click();
//        Thread.sleep(1000);


        // Step 4: In the list of TẤT CẢ SẢN PHẨM, select MỚI NHẤT -> select TÊN: A->Z
//
        // wait for the "Tên: A-Z" dropdown to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sort-by")));

        // select the "Tên: Z-A" option
        WebElement option = dropdown.findElement(By.cssSelector("option[value='title-descending']"));
        option.click();

        // wait for the products to be sorted by name
//        wait.until(ExpectedConditions.urlContains("sortby=(title:product=desc)"));

        // close the webdriver

        // Step 4: Click on "Dưới 200,000đ"
//        WebElement newestFirst = driver.findElement(By.xpath("newestFirst"));
//       newestFirst.click();


        // Step 5: Verify all products are sorted by name
//        h3[class='pro-name'] a[title='Tee Basic Line (màu trắng)']
        String[] productPrice = driver.findElements(By.cssSelector("h3[class='pro-name'] a[title='Tee Basic Line (màu trắng)']"))
                .stream()
                .map(WebElement::getText)
                .toArray(String[]::new);

        boolean isSorted = true;
        for (int i = 0; i < productPrice.length - 1; i++) {
            if (productPrice[i].compareTo(productPrice[i + 1]) > 0) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            System.out.println("Product sorting price successful!");
        } else {
            System.out.println("Product sorting price failed!");
        }        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//        WebElement productGrid = driver.findElement(By.className("products"));
//        String productsText = productGrid.getText();
//        if (productsText.contains("Áo khoác") && productsText.contains("Bộ đồ mặc nhà") && productsText.contains("Giày")) {
//            System.out.println("Step 5 Passed: All products are sorted by name");
//        } else {
//            System.out.println("Step 5 Failed: Products are not sorted by name");
//        }

        // Close the browser
        driver.quit();
    }
}
