import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Test2Page {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void test2Page() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://hvnuk.com.ua/");
        driver.findElement(By.linkText("Вимоги")).click();

        try {
            assertEquals("Вимоги до структури та оформлення наукових статей: ", driver.findElement(By.xpath(".//*[@id='post-26']/div/h3/b")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        try {
            assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Яндекс.Метрика\"]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        try {
            assertEquals("", driver.findElement(By.xpath("//img[@alt='2222']")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        try {
            assertEquals("", driver.findElement(By.name("s")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        try {
            assertTrue(isElementPresent(By.cssSelector("div.site-info")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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
