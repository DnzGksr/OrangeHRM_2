import Utilities.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class O2_12 extends BaseDriver {
@Test
public void upperCasePwTest() throws IOException {
    String expectedText = "Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password";
    adminLoginNavigateToAddUser();
    driver.findElement(By.cssSelector("input[type='password']")).sendKeys("TESTPASSWORD");
    WebElement errorElement = driver.findElement(By.cssSelector("span[class$='group__message']"));

    try {
        Assert.assertEquals("rgba(235, 9, 16, 1)", errorElement.getCssValue("color"));
        Assert.assertEquals(errorElement.getText(), expectedText);
    }
    catch (ComparisonFailure ex){

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM_dd_yyyy_hh_mm_ss");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshotInTemporaryFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotInTemporaryFile,new File("screenShots/screenshot"+localDateTime.format(formatter)+".png"));
        throw  new AssertionError(ex);

    }
    finally {
        waitAndQuit();
    }


}


}
