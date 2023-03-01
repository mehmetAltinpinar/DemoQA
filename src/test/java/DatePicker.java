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

//        WebElement highlightedDate = driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[7]"));
//        System.out.println(highlightedDate.getText());
//        String expected = "21/12/2019";
    }

    @Test
    void validateDateInput2(){
        driver.get("https://demoqa.com/date-picker/");

        WebElement dateInput = driver.findElement(By.xpath("//*[@id=\"datePickerMonthYearInput\"]"));
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        dateInput.sendKeys(selectAll);
        dateInput.sendKeys(Keys.DELETE);
        dateInput.sendKeys("01/14/0030");
    }
}
