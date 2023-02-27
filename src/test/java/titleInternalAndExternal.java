import Utilities.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class titleInternalAndExternal extends BaseDriver {

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
}

