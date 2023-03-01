import Utilities.Tools;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Slider extends Tools {

    /**
     * Go to the url: https://demoqa.com/slider/
     * Move the slider by clicking on a slide bar;
     * */
    @Test
    void validateSlidingTheSliderByClickingOnABar(){
        driver.get("https://demoqa.com/slider/");

        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        Assert.assertTrue(slider.isDisplayed());
        String beforeValue = slider.getAttribute("value");

        Actions actions = new Actions(driver);

        Action clickPoint = actions.moveToElement(slider, 50, 0).click().build();
        clickPoint.perform();

        String afterValue = slider.getAttribute("value");

        Assert.assertNotEquals(afterValue, beforeValue);
    }

    /**
     * Go to the url: https://demoqa.com/slider/
     * Move the slider by dragging a mouse to the release point
     * */
    @Test
    void validateSlidingTheSliderByDraggingAMouse(){
        driver.get("https://demoqa.com/slider/");

        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        Assert.assertTrue(slider.isDisplayed());
        String beforeValue = slider.getAttribute("value");

        Actions actions = new Actions(driver);

        Action draggingMouse = actions.clickAndHold(slider).moveByOffset(40, 0).build();
        draggingMouse.perform();

        String afterValue = slider.getAttribute("value");

        Assert.assertNotEquals(afterValue, beforeValue);

        Wait(2);

        quitDriver(2);
    }
}
