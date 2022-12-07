import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork {
    @Test
    void test1FindXpathForHome(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
        WebElement home = driver.findElement(By.className("fa-home"));
        home.click();
        driver.quit();

    }
    @Test
    void test1FindXpathForProducts(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
        WebElement home = driver.findElement(By.xpath("//a[@href='/products']"));
        home.click();
        driver.quit();

    }
//    @Test
//    void test1FindXpathForCart(){
//        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.automationexercise.com/");
//        WebElement home = driver.findElement(By.xpath("//a[@href='/products']"));
//        home.click();
//        driver.quit();

    }
