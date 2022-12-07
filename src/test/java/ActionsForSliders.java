import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ActionsForSliders {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @Test
    void testHerokuAppSlider1() throws MalformedURLException {
        URL url = new URL("https://the-internet.herokuapp.com/horizontal_slider");
        driver.get(String.valueOf(url));
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.id("range"));
        Assert.assertEquals(range.getText(), "0");
        //actions.clickAndHold(slider).moveByOffset(55,0).release().perform();
        //actions.dragAndDropBy(slider,55,0).perform();
        //  actions.click(slider).sendKeys(Keys.ARROW_RIGHT).perform();
        actions.dragAndDrop(slider, range).perform();

        Assert.assertEquals(range.getText(), "5");
    }

    @Test
    void test2HerokuAppSlider1() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.id("range"));
        Assert.assertEquals(range.getText(), "0");
        actions.dragAndDropBy(slider, -45, 0).perform();
    }

    @Test
    void tes3HerokuAppSlider1() {
        driver.get("https://demos.telerik.com/kendo-ui/slider/angular");
        WebElement slider = driver.findElement(By.xpath("//div[@class='k-widget k-slider k-slider-vertical ng-pristine ng-untouched ng-valid ng-not-empty']"));
        WebElement range = driver.findElement(By.xpath("//div[@class='k-widget k-slider k-slider-horizontal ng-pristine ng-untouched ng-valid ng-not-empty']"));
        actions.click(slider).sendKeys(Keys.UP).sendKeys(Keys.UP).perform();

//        Assert.assertEquals(range.getText(),"0");
//        actions.dragAndDropBy(slider,-45,0).perform();
    }
}
