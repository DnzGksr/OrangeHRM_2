import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class O2_06 extends BaseDriver {

    @Test
    void O2_06(){
        adminLoginNavigateToAddUser();

        WebElement username = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
        username.sendKeys("Nick");

        WebElement redMessage = driver.findElement(By.xpath("//span[text()=\"Should be at least 5 characters\"]"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(redMessage));
        System.out.println(redMessage.getText());
        Assert.assertTrue(redMessage.isDisplayed());
        Assert.assertEquals(redMessage.getText(), "Should be at least 5 characters");

        waitAndQuit();

    }

}
