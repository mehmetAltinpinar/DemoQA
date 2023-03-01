import Utilities.BaseDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class titleInternalAndExternal extends BaseDriver {

    //As a user, I want to see the title of the webpage
    //so that I can be sure that I am in the right webpage.
    //Test Steps:
    //Go to the website DEMOQA ;
    //Get the title of the website;
    @Test(priority = 1)
    public void validateTitle() {

        driver.get("https://demoqa.com/");
        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.quit();

    }

    @Test(priority = 2)
    public void validateInteractionButton() throws InterruptedException {
//Validate the working of interaction button functionality
        // 1. Go to the website demoqa.com;
        //2. Click the “interaction” button on top menu list;	url: https://demoqa.com/
        // You should be able to get current url “ https://demoqa.com/interaction/ “

        driver.get("https://demoqa.com/");
        WebElement interactionButton = driver.findElement(By.xpath("//h5[text()='Interactions']/../.."));
        Thread.sleep(3000);
        interactionButton.click();
        String expectedTitle = "https://demoqa.com/interaction";
        String actualTitle = driver.getCurrentUrl();
        Assert.assertEquals(expectedTitle, actualTitle);

        driver.quit();
    }


    @Test(priority = 3)
    public void validateSideBarInteraction() {
        //As a user, I want to validate the functionalities on the sidebar in the Interactions Section of the website
        //so that I can ensure that the Interactions Section is fucntioning correctly
        //Test Steps:
        //1. Go to the website DEMOQA ;
        //2. Click on the “interaction” button on top menu list;
        //3. Click on the “Resizable“ link on left sidebar;
        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        WebElement interactionButton = driver.findElement(By.xpath("//h5[text()='Interactions']/../.."));
        interactionButton.click();

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        WebElement resizable = driver.findElement(By.xpath("(//div/ul/li[@id='item-2'])[4]"));
        resizable.click();
        String expectedUrl = "https://demoqa.com/resizable";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Failed");
        driver.quit();


    }


    @Test(priority =4)
    public void validateSideBarWidgets() {
        /*Validate the functionalities on sidebar in Widgets section
         1. Go to the website demoqa.com;
         2. Click on the “Widgets” button on top menu list;
         3. Click on the “Tool Tips“ link on left sidebar;
* You should be able to get current url  “ https://demoqa.com/tooltip/ ”*/

        driver.get("https://demoqa.com/");
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0, 500)");

        WebElement widgets = driver.findElement(By.xpath("//div/h5[text()='Widgets']"));
        widgets.click();

        js2.executeScript("window.scrollBy(0, 500)");
        WebElement toolTips = driver.findElement(By.xpath("//span[text()='Tool Tips']"));
        toolTips.click();

        String expectedTitle = "https://demoqa.com/tool-tips";
        String actualTitle = driver.getCurrentUrl();
        Assert.assertEquals(actualTitle, expectedTitle, "Failed");
        driver.quit();
    }


}
