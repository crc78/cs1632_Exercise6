import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestHiberSense {

    Logger quietSel = Logger.getLogger("com.gargoylesoftware.htmlunit");

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp()
    {
        quietSel.setLevel(java.util.logging.Level.SEVERE);
        driver.get("https://hibersense.com/access/login");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void testValidLogin()
    {
        WebElement usernameField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement button = driver.findElement(By.cssSelector("a[class='btn-login']"));
        usernameField.sendKeys("student9@test.com");
        passwordField.sendKeys("student9");
        button.click();

        String notExpected = "https://hibersense.com/access/login";
        String actual = driver.getCurrentUrl();
        assertNotEquals(notExpected, actual);
    }

    @Test
    public void testMenuButtonHome()
    {
        driver.get("https://hibersense.com/access/view");
        WebElement homeButton = driver.findElement(By.cssSelector("a[class='home']"));
        homeButton.submit();
        String expected = "https://hibersense.com/access/temperature";
        String actual = driver.getCurrentUrl();
        assertNotEquals(expected, actual);
    }

    @After
    public void tearDown()
    {
        //driver.quit();
    }

}
