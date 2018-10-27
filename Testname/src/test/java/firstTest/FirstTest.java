package firstTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static WebDriver driver;

    @BeforeClass
    public void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Лилия\\Desktop\\Test\\chromedriver_win32");
        WebDriver driver = new Chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
    }
    @BeforeTest
    public void userLogin() {
        WebElement loginField = driver.findElement (By.xpath("//input[@id='mailbox:login']"));
        loginField.sendKeys("lilyayusupova5");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='mailbox:password']"));
        passwordField.sendKeys("Lya5588");
        WebElement loginButton = driver.findElement(By.xpath(".//*[@id='mailbox__auth__button']"));
        loginButton.click();
    }
    @Test (groups={"Y"})
    public void Send(){
        WebElement letterButton = driver.findElement(By.xpath("//*[@id='b-toolbar__left']"));
        letterButton.click();
        WebElement emailField = driver.findElement(By.xpath("//*[@id='toolkit-154063174678341composeForm']"));
        emailField.sendKeys("lilyayusupova5@mail.ru");
        WebElement textField = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textField.sendKeys("Hello,World!");
        WebElement sendButton = driver.findElement(By.xpath("//*[@id='b-toolbar__right']"));
        sendButton.click();
        WebElement mailpage= driver.findElement(By.xpath("//*[@id='b-nav_folders'"));
        mailpage.click();
    }
    public void Delete(){}
    public void Language(){

    }
    @AfterGroups
    public void userLogout (){
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id='PH_logoutLink']"));
        logoutButton.click();
    }
    @AfterClass
    public static void tearDown()  {
        driver.quit();
    }
}

