package firstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static WebDriver driver;

    @BeforeClass
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Лилия\\Desktop\\Test\\chromedriver_win32");
        WebDriver driver = new Chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement (By.xpath("//input[@id='mailbox:login']"));
        loginField.sendKeys("lilyayusupova5");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='mailbox:password']"));
        passwordField.sendKeys("Lya5588");
        WebElement loginButton = driver.findElement(By.xpath(".//*[@id='mailbox__auth__button']"));
        loginButton.click();
    }
    @AfterClass
    public static void tearDown()  {
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id='PH_logoutLink']"));
        logoutButton.click();
        driver.quit();
    }
}
