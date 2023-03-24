package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import java.util.List;

public class test8 {
    public static void main(String[] args) {
        // Khởi tạo WebDriver

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Step 1: Mở trang web chiliclub.vn
        driver.get("https://chiliclub.vn/");

        // Step 2: Click vào liên kết Tài khoản của tôi
        WebElement allProducts = driver.findElement(By.xpath("//a[@id='site-account-handle']//span[@class='box-icon']//*[name()='svg']"));
        allProducts.click();



        // Step 3: Nhấp vào liên kết Tạo tài khoản và điền thông tin mới người dùng
        // liên kết Tạo tài khoản
        WebElement createAccountLink = driver.findElement(By.cssSelector("a[class='link']"));
        createAccountLink.click();
        //điền thông tin mới người dùng
        //họ
        WebElement firstname = driver.findElement(By.xpath("//input[@id='last_name']"));
        firstname.sendKeys("Lê Mạnh");
        // ten
        WebElement middlename = driver.findElement(By.xpath("//input[@id='first_name']"));
        middlename.sendKeys("Luân");
        //check nam/nu
//        WebElement checkname = driver.findElement(By.cssSelector("label[for='radio2']"));
//        checkname.sendKeys("nhat");
        //ngay thang
        WebElement day = driver.findElement(By.xpath("//input[@id='birthday']"));
        day.sendKeys("02/01/2022");
        //điền email
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("lemanhluan@gmail.com");
        //pass
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys("123456789");


        // Step 4: Nhấp vào nút Đăng ký
        WebElement check = driver.findElement(By.xpath("//input[@value='Đăng ký']"));
//        try {
//            Thread.sleep(5000); // 5 seconds in milliseconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        check.click();

        // Step 9: Đóng trình duyệt
        driver.quit();
    }
}