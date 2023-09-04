import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class O2_05 extends BaseDriver {

    @Test

    public void Us05() {
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

        WebElement EmployeeName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));

        EmployeeName.sendKeys("Salah");

        WebElement noRecord = driver.findElement(By.xpath("//div[@class=\"oxd-autocomplete-option\"]"));

        Assert.assertTrue(noRecord.isDisplayed());
        noRecord.click();

        WebElement invalid = driver.findElement(By.cssSelector("span[class$='group__message']"));

        Assert.assertTrue(invalid.isDisplayed());

        waitAndQuit();



    }

}
