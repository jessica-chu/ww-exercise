package maven;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class AboutUsTest {
    // WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    
    @BeforeClass
    public void init(){
        // driver.manage().window().maximize();
        driver.navigate().to("https://www.weightwatchers.com/us/");

        Logger logger = LoggerFactory.getLogger(AboutUsTest.class);
        logger.info("Starting...");
    }
     
    @Test (priority = 0)
    public void isTitle() throws InterruptedException {
           
        Thread.sleep(1500);

        // Is the head <title> expectedTitle?
        String actualTitle = driver.getTitle();
        String expectedTitle = "WW (Weight Watchers): Weight Loss Program & Wellness Help | WW USA";
        // String expectedTitle = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
        assertEquals(expectedTitle, actualTitle);
    }

    @Test (priority = 1)
    public void findWorkshopButton() {

        // Click on button 'Find a Workshop'
        driver.findElement(By.cssSelector("a[da-label='Find a Workshop']")).click();
    }

}
