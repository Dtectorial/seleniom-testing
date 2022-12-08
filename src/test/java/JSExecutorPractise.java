import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutorPractise {
    WebDriver driver;
    @BeforeMethod
    void setDriver(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    void jsNovigateTo(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://tutorialshut.com/demo-website-for-selenium-automation-practice/'");
        JSUtils.jsSendKeys(driver,driver.findElement(By.id("comment")),"Hi everyone!");
        JSUtils.jsSendKeys(driver, driver.findElement(By.id("author")),"dow" );
        JSUtils.jsSendKeys(driver, driver.findElement(By.id("email")),"drty@gmail.com" );
        JSUtils.jsSendKeys(driver, driver.findElement(By.id("url")),"gmail.com" );
        JSUtils.jsClick(driver,driver.findElement(By.id("wp-comment-cookies-consent")));
        JSUtils.jsClick(driver,driver.findElement(By.id("submit")));





    }
}
