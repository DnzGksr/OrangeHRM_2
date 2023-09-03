import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class O2_08 extends BaseDriver {

    @Test
    public void U8(){
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

        Assert.assertTrue(add.isDisplayed());

        waitAndQuit();

    }
}
