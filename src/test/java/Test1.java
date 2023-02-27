import Utilities.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 extends UtilityClass {
    //As a user, I want to see the title of the webpage
    //so that I can be sure that I am in the right webpage.
    //Test Steps:
    //Go to the website DEMOQA ;
    //Get the title of the website;
    @Test
    public void verifyTitle() {
        driver.get("https://demoqa.com/");
        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.quit();

    }

    @Test
    //Validate the working of interaction button functionality
    // 1. Go to the website demoqa.com;
    //2. Click the “interaction” button on top menu list;	url: https://demoqa.com/	You should be able to get current url “ https://demoqa.com/interaction/ “
    public void validateInteractionButton() {
        driver.get("https://demoqa.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        WebElement interactionButton = driver.findElement(By.cssSelector("//h5[contains(text()='Interactions')]/.."));
        wait.until(ExpectedConditions.visibilityOf(interactionButton));
        interactionButton.click();
    }

}

