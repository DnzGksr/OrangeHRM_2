package Utilities;

import org.openqa.selenium.By;
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
       closePreviousDriver();
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
            if (System.getProperty("os.name").toLowerCase().contains("win"))
                Runtime.getRuntime().exec("taskkill /F /IM Chromedriver.exe /T");
            else
                Runtime.getRuntime().exec("killall chromedriver");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void adminLoginNavigateToAddUser(){
        try {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
            driver.findElement(By.cssSelector("ul[class=\"oxd-main-menu\"]>:nth-child(1)")).click();
            driver.findElement(By.cssSelector("button[class$='secondary']")).click();
        }
        catch (Exception ex ){
            System.out.println("Navigate Error ---> " +ex);
        }


    }
}
