import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DemoQAFormSubmission {
    @Test
    void demoQACheckRequiredFields() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        for (int i=10;i>0;i--){
            actions.keyDown(Keys.COMMAND).sendKeys("-").build().perform();
        }
        driver.get("https://demoqa.com/automation-practice-form");
//          WebElement submitButton = driver.findElement(By.id("submit"));
        List<WebElement> requirdField = driver.findElements(By.cssSelector("imput[requird]"));
        Thread.sleep(5000);
        for (WebElement field: requirdField){
            if(field.getAttribute("type").equals("radio")){
                Assert.assertEquals("rgb(220, 53,690)",field.getCssValue("color"));
            }else {
                Assert.assertEquals("rgb(220, 53,690)",field.getCssValue("border-color"));
            }
        }

    }
}
