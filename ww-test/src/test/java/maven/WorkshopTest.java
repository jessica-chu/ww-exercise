package maven;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkshopTest {
    // WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void init() {
        // driver.manage().window().maximize();
        driver.navigate()
                .to("https://www.weightwatchers.com/us/find-a-workshop/1180510/ww-studio-flatiron-new-york-ny");

        Logger logger = LoggerFactory.getLogger(WorkshopTest.class);
        logger.info("Starting...");
    }

    @Test(priority = 0)
    public void showTodaysHours() throws InterruptedException {

        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();

        String today = day.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
        // System.out.println(today);

        Thread.sleep(1500);

        WebElement element = driver.findElement(By.tagName("div"));
        List<WebElement> days = element.findElements(By.className("dayName-CTNC6"));
        
        for (WebElement e : days) {
            // System.out.println(e.getAttribute("innerText"));

            if (e.getAttribute("innerText").equals(today)) {
                String hours = e.findElement(By.xpath("following-sibling::div")).getAttribute("innerText");
                System.out.println("\nTODAY's hours of operation: " + e.getAttribute("innerText") + " - " + hours + "\n");   
            }    
        }
            
    }

    // @Test (priority = 1)
    // public void searchMeetings() throws InterruptedException {
        
    //     // Search for meetings at zip code: 10011
    //     driver.findElement(By.id("location-search")).sendKeys("10011");
    //     driver.findElement(By.id("location-search-cta")).click();

    //     Thread.sleep(1500);

    //     // Output the first search result's title and distance
    //     String searchResult = driver.findElement(By.cssSelector("div#search-results div:nth-of-type(1) div[class*=heading-]")).getText();
    //     System.out.println("\nSearch results outputting title and distance:\n" + searchResult + "\n");
    // }

    // @Test (priority = 2)
    // public void clickSearchResult() throws InterruptedException {

    //     // Gets the location name of the first search result
    //     String actualTitle = driver.findElement(By.cssSelector("div#search-results div:nth-of-type(1) > div:nth-child(1)")).getText();
        
    //     // Click on first search result
    //     driver.findElement(By.cssSelector("div#search-results div:nth-of-type(1) a")).click();

    //     Thread.sleep(1000);

    //     // Asserts that the search result location name is the same as its search result
    //     String expectedTitle = driver.findElement(By.cssSelector("h1")).getText();
    //     assertEquals(expectedTitle, actualTitle);
    // }
}

