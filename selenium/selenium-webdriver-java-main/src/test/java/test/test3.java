package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class test3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Kiểm ta Giá tiền có được thây đổi khi thay đổi số lượng thay đổi
        // Step 1: Go to https://chiliclub.vn/
        driver.get("https://chiliclub.vn/");

        //Step 2 : Đăng nhâp
        WebElement element = driver.findElement(By.id("account-circle"));
        element.click();
        WebElement emailInput = driver.findElement(By.name("customer[email]"));
        emailInput.sendKeys("burnhao@gmail.com");
        WebElement passwordInput = driver.findElement(By.name("customer[password]"));
        passwordInput.sendKeys("512003");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement submitButton = driver.findElement(By.id("form_submit-login"));
        submitButton.click();
        WebElement Home = driver.findElement(By.xpath("//a[@href='https://chiliclub.vn']"));

        // Step 3: Vào trang giỏ hàng
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement countElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.count-holder > span.count")));
        countElement.click();
        WebElement linkToCart = driver.findElement(By.cssSelector("a.linktocart"));
        linkToCart.click();

        // Step 4: Lấy tổng tiền hiện tại
        WebElement totalPriceElement = driver.findElement(By.cssSelector("span.total-price"));
        String totalPrice = totalPriceElement.getText();
        System.out.println("Tổng tiền: " + totalPrice);
        // Step 5: Thêm số lượng
        WebElement plusButton = driver.findElement(By.cssSelector(".qtyplus"));
        plusButton.click();
        // Step 6: Lấy tổng tiền mới
        WebElement NewtotalPriceElement = driver.findElement(By.cssSelector("span.total-price"));
        String NewtotalPrice = NewtotalPriceElement.getText();
        System.out.println("Tổng tiền mới: " + NewtotalPrice);

        // Step 7: Kiểm tra xem tổng tiền đã được thay đổi chưa
        if (!NewtotalPrice.equals(totalPrice)) {
            System.out.println("Pass: Tổng tiền đã được thay đổi");
        } else {
            System.out.println("Fail: Tổng tiền vẫn được giử nguyên");
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
