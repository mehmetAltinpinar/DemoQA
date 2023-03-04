import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropDownMenu {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu/");
        WebElement selectValue = driver.findElement(By.id("withOptGroup"));
        selectValue.click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();

        WebElement selectOne = driver.findElement(By.id("selectOne"));
        selectOne.click();
        keyDown.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();

        WebElement oldStyleSelectMenu = driver.findElement(By.id("oldSelectMenu"));
        List<WebElement> colorList = driver.findElements(By.cssSelector("[id='oldSelectMenu']>option"));
        int colorRandom = (int)(Math.random()*colorList.size());
        Select oldSelectMenu = new Select(oldStyleSelectMenu);
        oldSelectMenu.selectByIndex(colorRandom);

        WebElement multiSelectDropDown = driver.findElement(By.xpath("(//div[@class=\" css-2b097c-container\"])[3]"));
        multiSelectDropDown.click();
        keyDown.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        keyDown.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();

        WebElement standardMultiSelect = driver.findElement(By.id("cars"));
        List<WebElement> carList = driver.findElements(By.cssSelector("[id='cars']>option"));
        int carRandom = (int)(Math.random()* carList.size());
        Select multiSelect = new Select(standardMultiSelect);
        multiSelect.selectByIndex(carRandom);
    }
}
