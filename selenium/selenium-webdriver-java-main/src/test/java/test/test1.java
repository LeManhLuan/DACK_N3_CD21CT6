package test;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class test1 {
    public static void main(String[] args) {
        // Thanh Toán bằng tài khoản đã được đăng ký
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Step 1: Go to https://chiliclub.vn/
        driver.get("https://chiliclub.vn/");


        // Step 2: Vào Trang Đăng Nhập
        WebElement element = driver.findElement(By.id("account-circle"));
        element.click();


        // Step 3: Nhập thông Tin và Đăng Nhập
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


        // Step 4 : Mua sản phẩm và thanh toán
        WebElement Home = driver.findElement(By.xpath("//a[@href='https://chiliclub.vn']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(Home)).click();

        WebElement BuyProduct = driver.findElement(By.xpath("//h3[@class='pro-name']/a"));
        BuyProduct.click();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart"));

        addToCartButton.click();

        WebElement checkoutLink = driver.findElement(By.xpath("//td/a[@class='linktocheckout button dark']"));

        wait.until(ExpectedConditions.elementToBeClickable(checkoutLink)).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Quit the browser session
        driver.quit();


    }
}
