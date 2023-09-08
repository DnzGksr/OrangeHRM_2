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
        WebElement username1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        username1.sendKeys("Cheeku");
        WebElement readErrorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/span"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isAlreadyExistsMessageDisplayed = wait.until(ExpectedConditions.textToBePresentInElement(readErrorMsg, "Already exists"));
        if (isAlreadyExistsMessageDisplayed) {
            String actualErrorMessage = readErrorMsg.getText();
            System.out.println("Actual Error Message: " + actualErrorMessage);
            Assert.assertEquals(actualErrorMessage, "Already exists");
        } else {
            System.out.println("The 'Already exists' message is not displayed.");
        }
        waitAndQuit();

    }
}
