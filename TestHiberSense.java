import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestHiberSense {

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp()
    {
        driver.get("https://hibersense.com/access/login");
    }



    @After
    public void tearDown()
    {
        driver.quit();
    }

}
