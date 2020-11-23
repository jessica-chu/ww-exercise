package maven;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkshopTest {
    // WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    LocalDate date = LocalDate.now();
    DayOfWeek day = date.getDayOfWeek();

    @BeforeClass
    public void init() {
        // driver.manage().window().maximize();
        driver.navigate()
                .to("https://www.weightwatchers.com/us/find-a-workshop/1180510/ww-studio-flatiron-new-york-ny");

        Logger logger = LoggerFactory.getLogger(WorkshopTest.class);
        logger.info("Starting...\n");
    }

    @Test(priority = 0)
    public void showTodaysHours() throws InterruptedException {

        String today = day.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
        // System.out.println(today);

        Thread.sleep(1500);

        WebElement element = driver.findElement(By.tagName("div"));
        List<WebElement> days = element.findElements(By.className("dayName-CTNC6"));

        for (WebElement e : days) {
            // System.out.println(e.getAttribute("innerText"));

            if (e.getAttribute("innerText").equals(today)) {
                String hours = e.findElement(By.xpath("following-sibling::div")).getAttribute("innerText");
                System.out.println(today + "'s Studio Workshop hours of operation: " + hours + "\n");
            }
        }

    }

    @Test(priority = 1)
    @Parameters("dayOfWeek")
    public void printMeetings(@Optional("Thu") String s) throws InterruptedException {

        // String today = day.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.ENGLISH);
        s = s.toUpperCase();
        System.out.println("DAY: " + s + "\n");

        String myPath = "(//span[contains(text(), '" + s + "')])//following-sibling::*//span[2]";

        List<WebElement> persons = driver.findElements(By.xpath(myPath));

        ArrayList<String> list = new ArrayList<String>();

        for (WebElement el : persons)
            list.add(el.getText());

        // System.out.println(list);

        Map<String, Integer> hm = new HashMap<String, Integer>();

        for (String i : list) { 
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        for (Map.Entry<String, Integer> val : hm.entrySet())
            System.out.println(val.getKey() + "  " + val.getValue());
    }

}

