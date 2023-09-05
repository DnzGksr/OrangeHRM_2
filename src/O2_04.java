import Utilities.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class O2_04 extends BaseDriver {

    @Test
    public void passwordNotMatchTest(){
        adminLoginNavigateToAddUser();



        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Test123!");
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Test444!");
        String message = "Passwords do not match";

        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Passwords do not match']"));

        Assert.assertEquals("rgb(235, 9, 16)", errorMessage.getCssValue("color"));
        Assert.assertEquals(message, errorMessage.getText());

        waitAndQuit();

    }

}
