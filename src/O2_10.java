import Utilities.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class O2_10 extends BaseDriver {

    @Test
    public void addUserDisplayedTest(){
        adminLoginNavigateToAddUser();

        Assert.assertTrue(driver.findElement(By.cssSelector("h6[class*='main-title']")).getText().equals("Add User"));

        waitAndQuit();

    }



}
