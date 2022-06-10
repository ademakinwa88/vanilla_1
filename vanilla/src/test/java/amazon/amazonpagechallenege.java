package amazon;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class amazonpagechallenege {

    //public static WebDriver driver= null;


    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    public WebDriver driver = DriverFactory.getDriver();



    public void amazonpagechallenege(WebDriver driver) {
         this.driver = driver ;
    }

     @Tag("smokeTest")
     @DisplayName("This test is for demo purpose only to show that the basic code works." +
             "You have to use the best practices that you normally use to design your tests")
    @BeforeTest
    void assertThatHomePageTitleIsCorrect() {
          driver.get(HOME_PAGE_URL);
         //driver.get("http://www.amazon.in");
        driver.manage().window().maximize();
       // assertEquals("Amazon.in. Spend less. Smile more.", driver.getTitle());
         assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());


    }



}
