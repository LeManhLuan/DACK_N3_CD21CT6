package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test7 {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the Chiliclub website
        driver.get("https://chiliclub.vn/");

        // Vào Trang Đăng Nhập
        WebElement login = driver.findElement(By.id("account-circle"));
        login.click();


        // Nhập thông Tin và Đăng Nhập
        WebElement emailInput = driver.findElement(By.name("customer[email]"));
        emailInput.sendKeys("manhluanle@gmail.com");
        WebElement passwordInput = driver.findElement(By.name("customer[password]"));
        passwordInput.sendKeys("241203");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement submitButton = driver.findElement(By.id("form_submit-login"));
        submitButton.click();

        // Tìm kiếm sản phẩm "Áo"
        WebElement link = driver.findElement(By.id("site-search-handle"));

        link.click();

        WebElement input = driver.findElement(By.id("inputSearchAuto"));

        input.sendKeys("alskdjál");
                WebElement searchkey = driver.findElement(By.cssSelector("svg.svg.search"));
                searchkey.click();

                // Step 5: Verify all products are sorted by popularity
                List<WebElement> EmptyProduct = driver.findElements(By.xpath("//h2[contains(text(),'Không tìm thấy nội dung bạn yêu cầu')]"));
                if (EmptyProduct.size() == 1) {
                    System.out.println("không có sản phẩm nào");
                } else {
                    System.out.println("đã hiển thị sản phẩm");
                }

//                TakesScreenshot screenshot =((TakesScreenshot)driver);
//                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(scrFile,
//                        new File(".\\img\\test1.png"));

                // Step 6: Quit browser session
                driver.quit();
            }
        }

