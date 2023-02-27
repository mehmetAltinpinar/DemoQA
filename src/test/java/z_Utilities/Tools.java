package z_Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tools {
    WebDriverWait wait= B_BaseDriver.wait;

    public void elementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
