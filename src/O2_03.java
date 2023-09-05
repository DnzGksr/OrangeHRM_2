import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class O2_03 extends BaseDriver {

    @Test
    public void U3() {

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
            username.sendKeys("Admin");

            WebElement pass = driver.findElement(By.xpath("//input[@name=\"password\"]"));
            pass.sendKeys("admin123");

            WebElement button = driver.findElement(By.xpath("//button[@type=\"submit\"] "));
            button.click();

            WebElement admin = driver.findElement(By.xpath("//a[@href=\"/web/index.php/admin/viewAdminModule\"]"));
            admin.click();

//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//            wait.until(d -> admin.isDisplayed());

            WebElement userInterface = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span"));
            userInterface.click();

            MyMethods.waiting_Time(1);

            WebElement usr = driver.findElement(By.xpath("//a[text()='Users']"));
            usr.click();


            WebElement add = driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(add));

            add.click();

            WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
            saveButton.click();

            List<WebElement> errorMessage = driver.findElements(By.xpath("//span[text()='Required']"));
            for (WebElement error : errorMessage) {

                    Assert.assertTrue(error.isDisplayed());
                    Assert.assertEquals("Required", error.getText());
                    Assert.assertEquals("rgb(235, 9, 16)",error.getCssValue("Color"));

            }

            waitAndQuit();
        }
    }

