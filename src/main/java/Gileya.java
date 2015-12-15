
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Gileya {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    public void testWw() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://gileya.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/index.php");
        try {
            assertEquals("© 2008-2015, gileya.org. Усі права захищені.", driver.findElement(By.xpath("html/body/table/tbody/tr[4]/td/div")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//map[@id='Map']/area[2]")).click();
        try {
            assertEquals("Збірник наукових праць ”Гілея: науковий вісник”", driver.findElement(By.cssSelector(".tbor>tbody>tr>td>h2>strong")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//map[@id='Map']/area[3]")).click();
        try {
            assertEquals("Детальніше »", driver.findElement(By.xpath("//a[contains(text(),'Детальніше »')]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//map[@id='Map']/area[4]")).click();
        driver.findElement(By.xpath("//map[@id='Map']/area[5]")).click();
        driver.findElement(By.xpath("//map[@id='Map']/area[6]")).click();
        try {
            assertEquals("(044) 424 – 51 – 81", driver.findElement(By.xpath("//tr[2]/td[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//map[@id='Map']/area[3]")).click();
        driver.findElement(By.linkText("ввійти")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("ysa.serg@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("submit")).click();
        try {
            assertEquals("Завантажити", driver.findElement(By.xpath("//a[contains(text(),'Завантажити')]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Вашкевич");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        try {
            assertEquals("Знайдено результатiв: 37", driver.findElement(By.cssSelector(".tbor>tbody>tr>td>h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.close();
        driver.quit();
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
