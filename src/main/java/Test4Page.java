import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Test4Page {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test4Page() throws Exception {
        driver.get("http://hvnuk.com.ua/");
        driver.findElement(By.linkText("Контакти")).click();

        try {
            assertEquals("063  294  95  85", driver.findElement(By.xpath(".//*[@id='post-99']/div/p[2]/em[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        try {
            driver.findElement(By.name("s")).clear();
            driver.findElement(By.name("s")).sendKeys("Вашкевич\n");
            assertEquals("Результати пошуку для фрази: Вашкевич", driver.findElement(By.cssSelector("h1.page-title")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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
