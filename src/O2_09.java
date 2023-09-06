import Utilities.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.text;

public class O2_09 extends BaseDriver {

    @Test
    public void displayElementsTest() {

        adminLoginNavigateToAddUser();

        List<WebElement> requiredElements = driver.findElements(By.cssSelector("label[class$='field-required']"));
        List<WebElement> requiredElements2 = driver.findElements(By.cssSelector("button[class^='oxd-button']"));

        for (WebElement element : requiredElements) {
            Assert.assertTrue(element.isDisplayed());
            for (WebElement element2 : requiredElements2)
                Assert.assertTrue(element.isDisplayed());
        }

        List<String> expectedElements = new ArrayList<>(List.of("User Role", "Employee Name", "Status", "Username", "Password", "Confirm Password"));
        List<String> expectedElements2 = new ArrayList<>(List.of("Cancel", "Save"));

        for (WebElement element : requiredElements) {
            Assert.assertTrue(expectedElements.contains(element.getText()));
            for (WebElement element2 : requiredElements2)
                Assert.assertTrue(expectedElements2.contains(element2.getText()));
        }


        waitAndQuit();
    }
    }





