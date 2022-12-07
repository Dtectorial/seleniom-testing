import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
public class WindowHandleIntro {
    WebDriver driver;

    @BeforeMethod
    void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    void windowHandleHerokuAppTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHereHyperlink = driver.findElement(By.xpath("//a[text() = 'Click Here']"));
        System.out.println("Page info before switching:");
        System.out.println("URL: "+driver.getCurrentUrl());
        System.out.println("Title: "+driver.getTitle());
        clickHereHyperlink.click();

        String parentPageID = driver.getWindowHandle();//current(parent) window's ID:CDwindow-FDFBA117C0866027087EDAE4EA587935
        System.out.println("Parent Tab/Window/Page ID: "+parentPageID);
        Set<String> allTabIDs = driver.getWindowHandles();
        System.out.println("All Tab/Window/Page IDs: "+allTabIDs);
        Iterator<String> iteratorIDs = allTabIDs.iterator();
        while (iteratorIDs.hasNext()){
            String id = iteratorIDs.next();
            if (!id.equals(parentPageID)){
                driver.switchTo().window(id);
            }
        }
        System.out.println("Page info after switching:");
        System.out.println("URL: "+driver.getCurrentUrl());
        System.out.println("Title: "+driver.getTitle());
        WebElement header = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(header.getText(),"New Window");
        System.out.println("Switch back to parent");
        driver.close();

        driver.switchTo().window(parentPageID);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        clickHereHyperlink.click();
    }

}
