package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class test4 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // kiểm tra xóa sản phẩm ở giỏ hàng
        // Step 1: https://chiliclub.vn/
        driver.get("https://chiliclub.vn/");

        WebElement element = driver.findElement(By.id("account-circle"));
        element.click();


        // step 2 : Đăng Nhập
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


        // Step 3: Vào giỏ Hàng
        WebElement Home = driver.findElement(By.xpath("//a[@href='https://chiliclub.vn']"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement countElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.count-holder > span.count")));
        countElement.click();

        WebElement linkToCart = driver.findElement(By.cssSelector("a.linktocart"));
        linkToCart.click();

        // step 4 : Xóa sản phẩm trong giỏ hàng
        WebElement remove = driver.findElement(By.xpath("//td[@class='remove']/a"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        remove.click();
        driver.quit();

    }
}
