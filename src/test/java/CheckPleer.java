/**
 * Created by katya on 17.06.16.
 */
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckPleer { 
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://pleer.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void checkPleer() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='search-input']")).sendKeys("worry");
        driver.findElement(By.xpath(".//*[@id='search-btn']/input")).click();
        int elementNumber = 0;
        for(WebElement element:driver.findElements(By.xpath(".//*[@id='content']/div[3]/div[1]/div/div/div[2]/ol/li"))) {
            elementNumber++;
            System.out.println("Element: " + elementNumber);
            assertTrue(element.getText().contains("Worry") || element.getText().contains("worry"));
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
