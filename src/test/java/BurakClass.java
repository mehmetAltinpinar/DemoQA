import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import z_Utilities.BaseDriver;
import z_Utilities.Tools;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class BurakClass extends BaseDriver {

    SoftAssert softAssert;

    Tools ts = new Tools();
    Robot rbt;
    List<WebElement> items;
    @Test(priority = 0)
    void validateTheWorkingOfSelectableFunctionality(){
        driver.get("https://demoqa.com/selectable/");

        WebElement itemOne = driver.findElement(By.xpath("//li[text()='Cras justo odio']"));
        itemOne.click();
        Assert.assertEquals(itemOne.getCssValue("background-color"),"rgba(0, 123, 255, 1)");
    }

    @Test(priority = 1)
    void validateSelectingMultipleItemsWithCtrlButton() throws AWTException {
        driver.get("https://demoqa.com/selectable/");
        items = driver.findElements(By.cssSelector("#verticalListContainer > li"));

        rbt = new Robot();

        rbt.keyPress(KeyEvent.VK_CONTROL);
        for (int i = 0; i < items.size()-1; i++){
            items.get(i).click();
            ts.elementToBeVisible(items.get(i));
            Assert.assertEquals(items.get(i).getCssValue("background-color"),"rgba(0, 123, 255, 1)");
        }
        rbt.keyRelease(KeyEvent.VK_CONTROL);
    }

    @Test(priority = 2)
    void validateSelectingMultipleItemsWithCtrlButtonAndSelectingTheSelectedItem() throws AWTException {
        driver.get("https://demoqa.com/selectable/");
        items = driver.findElements(By.cssSelector("#verticalListContainer > li"));

        rbt = new Robot();

        rbt.keyPress(KeyEvent.VK_CONTROL);
        items.get(0).click();
        items.get(1).click();
        items.get(2).click();
        items.get(1).click();
        rbt.keyRelease(KeyEvent.VK_CONTROL);

        for (int i = 0; i < 3; i++) {
            softAssert = new SoftAssert();
            if (i==1){
                softAssert.assertEquals(items.get(i).getCssValue("background-color"),"rgba(0, 123, 255, 1)");
            }
            else{
                softAssert.assertEquals(items.get(i).getCssValue("background-color"),null);
            }
        }
        softAssert.assertAll();

    }

}
