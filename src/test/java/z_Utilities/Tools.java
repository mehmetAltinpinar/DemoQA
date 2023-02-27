package z_Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tools {
    WebDriverWait wait=BaseDriver.wait;

    public void elementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
