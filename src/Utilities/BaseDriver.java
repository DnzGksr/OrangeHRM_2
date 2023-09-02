package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;

    static {
        //closePreviousDriver();
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        driver = new ChromeDriver();

        driver.manage().window().maximize(); // Expands the driver until the edges of the screen.

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    public static void waitAndQuit() {
        MyMethods.waiting_Time(3);
        driver.quit();
    }
    public static void closePreviousDriver(){  // works just for chrome
        try {
            Runtime.getRuntime().exec("taskkill /F /IM Chromeriver.exe /T");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
