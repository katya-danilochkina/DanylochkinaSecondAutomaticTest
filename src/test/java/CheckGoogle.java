/**
 * Created by katya on 12.06.16.
 */
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CheckGoogle {
    private WebDriver driver;
    private String baseUrl;
    WebDriver driver1;

    @BeforeClass
    public static void setupClass() {
        MarionetteDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://google.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void checkGoogle() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("shoes");
        driver.findElement(By.xpath(".//*[@id='sblsbb']/button")).click();
        int elementNumber = 0;
        for(WebElement element:driver.findElements(By.xpath(".//*[@id='rso']/div[2]/div/div"))) {
            elementNumber++;
            System.out.println("Element: " + elementNumber);
            assertTrue(element.getText().contains("shoes"));
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}