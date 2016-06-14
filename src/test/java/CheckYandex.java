/**
 * Created by katya on 14.06.16.
 */
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckYandex {
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.yandex.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void checkYandex() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='text']")).sendKeys("sneakers");
        driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/table/tbody/tr/td[2]/form/div[2]/button")).click();
        int elementNumber = 0;
        for(WebElement element:driver.findElements(By.xpath(".//html/body/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[@class=\"serp-item\"]"))) {
            elementNumber++;
            System.out.println("Element: " + elementNumber);
            assertTrue(element.getText().contains("sneakers") || element.getText().contains("Sneakers") || element.getText().contains("Sneaker"));
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
