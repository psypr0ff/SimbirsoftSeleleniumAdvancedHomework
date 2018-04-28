import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.way2autoJqueryDroppablePage;
import pages.way2autoJqueryLoginPage;
import pages.way2autoJqueryMainPage;

/**
 * Created by Александр on 27.04.2018.
 */
public class seleniumAdvancedTest {
    WebDriver driver;
    pages.way2autoJqueryLoginPage loginPage;
    pages.way2autoJqueryMainPage mainPage;
    pages.way2autoJqueryDroppablePage droppablePage;
    String user = "simtest";
    String pass = "12345678";

    @BeforeTest
    public void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumgrid\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://way2automation.com/way2auto_jquery");
        Thread.sleep(1000);
    }

    @AfterTest
    public void totalDestroy() throws InterruptedException{
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void DroppableElemTest() throws InterruptedException{
        loginPage = new way2autoJqueryLoginPage(driver);
        mainPage = new way2autoJqueryMainPage(driver);
        droppablePage = new way2autoJqueryDroppablePage(driver);
        loginPage.loginHere(user, pass);
        Thread.sleep(2000);
        mainPage.goToDroppable();
        Thread.sleep(2000);
        droppablePage.dragAndDrop();
        Thread.sleep(2000);
    }
}
