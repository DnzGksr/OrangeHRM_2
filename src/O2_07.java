import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class O2_07 extends BaseDriver {
    @Test
    void O2_O7() {
        adminLoginNavigateToAddUser();
        WebElement username = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        username.sendKeys("Aaliyah.Haq");
        WebElement redMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(redMessage));
        System.out.println(redMessage.getText());
        Assert.assertTrue(redMessage.isDisplayed());
        Assert.assertEquals(redMessage.getText(), "Already exists");

        waitAndQuit();

    }
}
