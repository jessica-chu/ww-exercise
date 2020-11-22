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

public class FindWorkshopTest {
    // WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    
    @BeforeClass
    public void init(){
        // driver.manage().window().maximize();
        driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

        Logger logger = LoggerFactory.getLogger(FindWorkshopTest.class);
        logger.info("Starting...");
    }

    @Test (priority = 0)
    public void isTitle() throws InterruptedException {

        Thread.sleep(2000);

        String actualTitle = driver.getTitle();
        char nbsp = '\u00A0';   // ASCII &nbsp
        String expectedTitle = "Find WW" + nbsp + "Studios & Meetings Near You | WW USA";
        assertEquals(expectedTitle, actualTitle);
    }

    @Test (priority = 1)
    public void searchMeetings() throws InterruptedException {
        
        driver.findElement(By.id("location-search")).sendKeys("10011");
        driver.findElement(By.id("location-search-cta")).click();

        Thread.sleep(1500);

        String searchResult = driver.findElement(By.cssSelector("div#search-results div:nth-of-type(1) div[class*=heading-]")).getText();
        System.out.println("Search results outputting title and distance:\n" + searchResult);
    }
}

