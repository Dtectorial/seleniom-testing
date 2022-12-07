import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class WindowHandlePractice {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void windowHandleHerokuAppTest() {
        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement newTabButtom = driver.findElement(By.id("new-tab-button"));
        System.out.println("URL: "+driver.getCurrentUrl());
        newTabButtom.click();

        String parentPageID = driver.getWindowHandle();
        Set<String> allTabIDs = driver.getWindowHandles();
        Iterator<String> iteratorIDs = allTabIDs.iterator();
        while (iteratorIDs.hasNext()){
            String id = iteratorIDs.next();
            if (!id.equals(parentPageID)){
                driver.switchTo().window(id);
            }
        }
    }
    @Test
    void windowHandleFormyHerokuAppTest(){
        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();
        switchToChildByID(driver);
        WebElement headerOfChild = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(headerOfChild.getText(),"Welcome to Formy");
        List<WebElement> components =driver.findElements(By.cssSelector(".btn.btn-lg"));
        List<String> actualComponents = new ArrayList<>();
        for (int i=0; i<components.size();i++){
            actualComponents.add(components.get(i).getText());
        }
        List<String> expectedComponents = Arrays.asList("Autocomplete", "Buttons", "Checkbox", "Datepicker", "Drag and Drop", "Dropdown", "Enabled and disabled elements", "File Upload", "Key and Mouse Press", "Modal", "Page Scroll", "Radio Button", "Switch Window", "Complete Web Form");
        Assert.assertEquals(expectedComponents,actualComponents);
        driver.close();
        driver.switchTo().window(driver.getWindowHandle());
        List<WebElement> buttons = driver.findElements(By.xpath("//button[@class='btn btn-primary']"));
        int i=0;
        do {
            Assert.assertTrue(buttons.get(i).isEnabled());
            Assert.assertTrue(buttons.get(i).isDisplayed());
            i++;
        }while (i<buttons.size());

    }
    @Test
    void windowHandleDemoQATest(){
        driver.get("https://demoqa.com/browser-windows");
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        newWindow.click();
        String parentWindow = driver.getWindowHandle();
        switchToChildByID(driver);
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"This is a sample page");

    }

    void switchWindowByTitle(WebDriver webDriver, String title){
        Set<String> allIDs = webDriver.getWindowHandles();
        for (String id:allIDs){
            if (webDriver.switchTo().window(id).getTitle().equalsIgnoreCase(title)){
                System.out.println("Switched to: "+webDriver.getCurrentUrl());
                System.out.println("Switched to: "+webDriver.getTitle());
                break;
            }
        }
    }

    void switchWindowByURLKeyword(WebDriver webDriver, String urlKeyword){
        Set<String> allIDs = webDriver.getWindowHandles();
        for (String id:allIDs){
            if (webDriver.switchTo().window(id).getCurrentUrl().equalsIgnoreCase(urlKeyword)){
                System.out.println("Switched to: "+webDriver.getCurrentUrl());
                System.out.println("Switched to: "+webDriver.getTitle());
                break;
            }
        }
    }

    void switchToChildByID(WebDriver driver){
        String parent = driver.getWindowHandle();
        Set<String> allIDs = driver.getWindowHandles();
        for (String id:allIDs){
            if (!parent.equals(id)){
                driver.switchTo().window(id);
                System.out.println("Switched to: "+driver.getCurrentUrl());
                System.out.println("Switched to: "+driver.getTitle());
            }
        }
    }

    void switchToParentByID(WebDriver driver,String parent){
        driver.close();
        System.out.println(parent);
        driver.switchTo().window(parent);
    }
}
