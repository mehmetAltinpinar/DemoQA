import Utilities.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;


public class TestResizable extends Tools {


    @Test(priority = 1)
         void ResizingVertically() {

        driver.get("https://demoqa.com/resizable/");
        WebElement resizeHandle = driver.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]/span"));
        Actions action = new Actions(driver);
        action.clickAndHold(resizeHandle).moveByOffset(100, 0).release().perform();

    }
         @Test(priority = 2)
         void ResizingHorizontally(){

        Actions action = new Actions(driver);
        action.clickAndHold().moveByOffset(0, 100).release().perform();
    }

        @Test(priority = 3)
        void ResizingDiagonally(){

        Actions action = new Actions(driver);
        action.clickAndHold().moveByOffset(-150,-150).release().perform(); //expected min value of offset is 150.

        driver.quit();
    }

}
