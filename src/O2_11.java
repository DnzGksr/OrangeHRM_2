import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class O2_11 extends BaseDriver {
    @Test
    public void Us11(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        username.sendKeys("Admin");

        WebElement pass = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        pass.sendKeys("admin123");

        WebElement button = driver.findElement(By.xpath("//button[@type=\"submit\"] "));
        button.click();

        WebElement admin = driver.findElement(By.xpath("//a[@href=\"/web/index.php/admin/viewAdminModule\"]"));
        admin.click();

        MyMethods.waiting_Time(2);

        WebElement add = driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"));

        add.click();

        MyMethods.waiting_Time(2);



        WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        password.sendKeys("abcde");



        WebElement RedMessage = driver.findElement(By.xpath("//span[text()='Should have at least 7 characters']"));

        Assert.assertTrue(RedMessage.isDisplayed());

        waitAndQuit();



    }

}


