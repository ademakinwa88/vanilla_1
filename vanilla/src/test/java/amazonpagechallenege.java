import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class amazonpagechallenege {

    //public static WebDriver driver= null;


    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();


     @Tag("smokeTest")
     @DisplayName("This test is for demo purpose only to show that the basic code works." +
             "You have to use the best practices that you normally use to design your tests")
    @BeforeTest
    void assertThatHomePageTitleIsCorrect() {
       // driver.get(HOME_PAGE_URL);
         driver.get("http://www.amazon.in");
        driver.manage().window().maximize();
        //assertEquals("Amazon.in. Spend less. Smile more.", driver.getTitle());

    }

   @Test
   public void assertInformation() throws InterruptedException {




    driver.findElement(By.className("hm-icon-label")).click();
    driver.findElement(By.xpath("//div[text()='TV, Appliances, Electronics']")).click();
    driver.findElement(By.xpath("//a[text()='Televisions']")).click();
    Thread.sleep(2000);
    WebElement Element = driver.findElement(By.xpath("//span[text()='Samsung']"));
    Element.click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//span[text()='Sort by:']")).click();

    //Select dropdown1 = new Select(driver.findElement(By.cssSelector("a[id*='s-result-sort-select_2']")));
    //dropdown1.selectByIndex(2);
    Thread.sleep(3000);
    WebElement dropdown2 = driver.findElement(By.cssSelector("a[id*='s-result-sort-select_2']"));
    dropdown2.click();


    String parentHandle = driver.getWindowHandle();

    driver.findElement(By.xpath("//span[text()='Samsung 163 cm (65 inches) 4K Ultra HD Smart QLED TV QA65QN90AAKLXL (Black) (2021 Model)']")).click();

    Set<String> handles = driver.getWindowHandles();

    for (String handle:handles) {
        if(!handle.equals(parentHandle)) {
            driver.switchTo().window(handle);

            String text1 = driver.findElement(By.xpath("//*[@id=\"featurebullets_feature_div\"]")).getText();

            System.out.println(text1);
        }
    }
}


}
