package test;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        // Kiểm ta tiều đề và giá sản phẩm, trang sản phẩm và Chi thiết sản phẩm có được trùng hay không
        // Step 1: https://chiliclub.vn/collections/tat-ca-san-pham
        WebDriver driver = new ChromeDriver();
        driver.get("https://chiliclub.vn/collections/tat-ca-san-pham");

        // Step 2: Lấy tất Cả sản phẩm
        List<WebElement> productElements = driver.findElements(By.className("pro-loop"));

        for (int i = 0; i < productElements.size(); i++) {
            WebElement productElement = productElements.get(i);
            // Step 3 Lấy Tên và Giá
            String productName = productElement.findElement(By.className("pro-name")).getText();
            String productPrice = productElement.findElement(By.cssSelector("p.pro-price span")).getText();
            // Vào Sản Phẩm chi tiết của sản phẩn hiện tại
            productElement.click();

            // Step 4:Lấy tên và giá của sản phẩm chi tiết hiện tại
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-title h1")));
            String productNameDetail = nameElement.getText();
            WebElement priceElementDetail = driver.findElement(By.cssSelector("div.product-price span.pro-price"));
            String priceTextDetail = priceElementDetail.getText();

            // Step 5: Kiểm tra tên và giá của sản phẩm có trùng nhau hay không
            if (productName.equals(productNameDetail) && productPrice.equals(priceTextDetail)) {
                System.out.println("Sản Phẩm thứ "+i+": pass");
            } else {
                System.out.println("Sản Phẩm thứ "+i+"fail");
            }

            driver.navigate().back();
            productElements = driver.findElements(By.className("pro-loop"));
        }
        driver.quit();
    }
}
