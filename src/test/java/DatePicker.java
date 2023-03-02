import Utilities.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePicker extends Tools {
    @Test
    void validateTodayDate(){
        driver.get("https://demoqa.com/date-picker/");

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        WebElement dateInput = driver.findElement(By.xpath("//*[@id=\"datePickerMonthYearInput\"]"));
        String actualDate = dateInput.getAttribute("value");
        String expectedDate = localDateTime.format(formatter);
        Assert.assertEquals(actualDate,expectedDate,"Test is not successful");
    }

    @Test
    void validateDateInput1(){
        driver.get("https://demoqa.com/date-picker/");

        WebElement dateInput = driver.findElement(By.xpath("//*[@id=\"datePickerMonthYearInput\"]"));
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        dateInput.sendKeys(selectAll);
        dateInput.sendKeys(Keys.DELETE);
        dateInput.sendKeys("12/21/2019");


        WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
        String actual = date.getAttribute("value");
        String expected = "21/12/2019";
        Assert.assertEquals(actual,expected, "Test validate 12/21/2019 fails");
    }

    @Test
    void validateDateInput2(){
        driver.get("https://demoqa.com/date-picker/");

        WebElement dateInput = driver.findElement(By.xpath("//*[@id=\"datePickerMonthYearInput\"]"));
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        dateInput.sendKeys(selectAll);
        dateInput.sendKeys(Keys.DELETE);
        dateInput.sendKeys("01/14/0030");

        WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
        String actual = date.getAttribute("value");
        String expected = "21/12/2030";
        Assert.assertEquals(actual,expected, "Test validate 01/14/0030 fails");
    }
}
