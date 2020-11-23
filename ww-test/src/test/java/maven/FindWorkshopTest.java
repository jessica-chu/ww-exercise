package maven;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class FindWorkshopTest {
    // WebDriverManager.chromedriver().setup();
    static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void init() {
        // driver.manage().window().maximize();
        driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

        Logger logger = LoggerFactory.getLogger(FindWorkshopTest.class);
        logger.info("Starting...\n");
    }

    @Test (priority = 0)
    public void isTitle() throws InterruptedException {

        Thread.sleep(1500);

        // Asserts that title page is the expected title
        String actualTitle = driver.getTitle();
        char nbsp = '\u00A0';   // ASCII &nbsp
        String expectedTitle = "Find WW" + nbsp + "Studios & Meetings Near You | WW USA";
        assertEquals(expectedTitle, actualTitle);
    }

    @Test (priority = 1)
    public void searchMeetings() throws InterruptedException {
        
        // Search for meetings at zip code: 10011
        driver.findElement(By.id("location-search")).sendKeys("10011");
        driver.findElement(By.id("location-search-cta")).click();

        Thread.sleep(1500);

        // Output the first search result's title and distance
        String searchResult = driver.findElement(By.cssSelector("div#search-results div:nth-of-type(1) div[class*=heading-]")).getText();
        System.out.println("Search results outputting title and distance:\n" + searchResult + "\n");
    }

    @Test (priority = 2)
    public void clickSearchResult() throws InterruptedException {

        // Gets the location name of the first search result
        String actualTitle = driver.findElement(By.cssSelector("div#search-results div:nth-of-type(1) > div:nth-child(1)")).getText();
        
        // Click on first search result
        driver.findElement(By.cssSelector("div#search-results div:nth-of-type(1) a")).click();

        Thread.sleep(1000);

        // Asserts that the search result location name is the same as its search result
        String expectedTitle = driver.findElement(By.cssSelector("h1")).getText();
        assertEquals(expectedTitle, actualTitle);
    }

    @AfterClass
    public static void tearDown() {

        // Close browser window
        driver.quit();
    }
}

