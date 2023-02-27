package z_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void startingProcesses(){
        System.out.println("The Test Has Been Started");

        Logger logger = Logger.getLogger("");  // Sistem ait buyun loglari ureten objeye/servise e ulastim "" sayesinde
        logger.setLevel(Level.SEVERE);               // Sadece errorlari gosterir SERVE sayesinde
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // Chrome Driver Output Proerty leri susturdu sadece Error verirse bir sey yazacak

        ChromeOptions opt = new ChromeOptions();      // web sayfasini kontrol eden gorevli
        opt.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();  // Ekranı max yapıyor.

        wait = new WebDriverWait(BaseDriver.driver, Duration.ofSeconds(10));

    }

    @AfterClass
    public void finalizationProcesses(){
        //driver.quit();
    }
}
