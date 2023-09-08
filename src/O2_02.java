import Utilities.BaseDriver;

import Utilities.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import java.time.Duration;


public class O2_02 extends BaseDriver {
    @Test
    public void O2_02() {
        adminLoginNavigateToAddUser();
        String NickName = "Lisaaa3a3";
        String Name = "Lisa Andrews";
        String Password = "Andrews123";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement userRoll = driver.findElement(By.cssSelector("div[class=\"oxd-select-text oxd-select-text--active\"]"));
        userRoll.click();
        WebElement ESS = driver.findElement(By.xpath("(//div[@role='option'])[3]"));
        wait.until(ExpectedConditions.visibilityOf(ESS));
        ESS.click();


        WebElement status = driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]"));
        status.click();
        WebElement enabled = driver.findElement(By.xpath("(//div[@role=\"option\"])[2]"));
        wait.until(ExpectedConditions.visibilityOf(enabled));
        enabled.click();
        WebElement startName = driver.findElement(By.cssSelector("input[placeholder=\"Type for hints...\"]"));
        startName.sendKeys("Lis ");


        WebElement fullName = driver.findElement(By.xpath("//span[text()=\"Lisa  Andrews\"]"));
        wait.until(ExpectedConditions.visibilityOf(fullName));
        fullName.click();


        WebElement username = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
        username.sendKeys(NickName);


        WebElement password = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
        password.sendKeys(Password);


        WebElement passwordConfirm = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]"));
        passwordConfirm.sendKeys(Password);


        WebElement submit = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        submit.click();

        WebElement successful = driver.findElement(By.cssSelector("div[class=\"oxd-toast-start\"]"));
        wait.until(ExpectedConditions.visibilityOf(successful));
        Assert.assertTrue(successful.getText().contains("Success"));



            WebElement Admin = driver.findElement(By.cssSelector("span[class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]"));
            Admin.click();


            WebElement name2 = driver.findElement(By.cssSelector("input[placeholder=\"Type for hints...\"]"));
            name2.sendKeys("Lis");

            MyMethods.waiting_Time(2);
            WebElement fName = driver.findElement(By.xpath("//span[text() = \"Lisa  Andrews\"]"));
            fName.click();

            WebElement Roll = driver.findElement(By.cssSelector("div[class=\"oxd-select-text-input\"]"));
            Roll.click();
            WebElement Ess = driver.findElement(By.xpath("(//div[@role=\"option\"])[3]"));
            wait.until(ExpectedConditions.visibilityOf(Ess));
            Ess.click();

            WebElement st = driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]"));
            st.click();
            WebElement En = driver.findElement(By.xpath("(//div[@role=\"option\"])[2]"));
            wait.until(ExpectedConditions.visibilityOf(En));
            En.click();

            WebElement search = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
            search.click();

            WebElement found = driver.findElement(By.xpath("(//div[@class=\"oxd-table-row oxd-table-row--with-border\"])[2]"));
            wait.until(ExpectedConditions.visibilityOf(found));
            Assert.assertTrue(found.getText().contains(Name));


            waitAndQuit();


        }
    }

