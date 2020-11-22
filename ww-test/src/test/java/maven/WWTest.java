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

public class WWTest {
    // WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    
    @BeforeClass
    public void init(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.weightwatchers.com/us/");
    }
     
    @Test (priority = 0)
    public void isTitle() throws InterruptedException {
        
        Logger logger = LoggerFactory.getLogger(WWTest.class);
        logger.info("Starting...");
        
        Thread.sleep(2500);

        // Test: Is the head <title> expectedTitle?
        String actualTitle = driver.getTitle();
        String expectedTitle = "WW (Weight Watchers): Weight Loss Program & Wellness Help | WW USA";
        // String expectedTitle = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
        assertEquals(expectedTitle, actualTitle);

        Thread.sleep(2000);
    }

    @Test (priority = 1)
    public void findWorkshopClick() throws InterruptedException {
        
        // Button click "Find a Workshop"
        driver.findElement(By.linkText("Find a Workshop")).click();

        Thread.sleep(2000);

        String actualTitle = driver.getTitle();
        char nbsp = '\u00A0';
        String expectedTitle = "Find WW" + nbsp + "Studios & Meetings Near You | WW USA";
        assertEquals(expectedTitle, actualTitle);
    }
}
