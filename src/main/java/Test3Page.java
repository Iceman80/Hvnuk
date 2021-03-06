import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Test3Page {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void test3Page() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://hvnuk.com.ua/");
        driver.findElement(By.linkText("Архів")).click();

        try {
            assertEquals("Продовжувати читання\n" + "ВИПУСК 8\n" +
                    "→", driver.findElement(By.xpath(".//*[@id='post-109']/div/p[2]/a")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        try {
            driver.findElement(By.xpath(".//*[@id='post-109']/div/p[2]/a")).click();
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        try {
            assertTrue(isElementPresent(By.cssSelector("a.wpfb-dlbtn > div")));
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
