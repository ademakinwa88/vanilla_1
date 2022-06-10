package AmazonPage;

import amazon.factories.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class AmazonPageTest {

        public static WebDriver driver= DriverFactory.getDriver();
        By hamburger = By.xpath("//*[@id ='nav-hamburger-menu']");
        By tvAppliances = By.xpath("//div[normalize-space()='TV, Appliances, Electronics']");
        By televisions = By.linkText("Televisions");
        By itemCheckbox =By.xpath(" //span[@class='a-size-base a-color-base'][normalize-space()='Samsung'] ");
        By dropdownmenu = By.cssSelector("#a-autoid-0-announce");
        By highlowmenu = By.xpath("//a[@id='s-result-sort-select_2']");
        By itemsecondhighest = By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']");
        By aboutitem = By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']");

        public  AmazonPageTest(WebDriver driver)
    {
        this.driver = driver ;
    }




    public void selectHamburger(){
            driver.findElement(hamburger).click();
            System.out.println("Yippee! Hamburger clicked sucessfully");


        }
        public void selectTvAppliances()
        {
            driver.findElement(tvAppliances).click();
            System.out.println(" TvAppliancesElectronics Link  clicked successfully");
        }
        public void selectTelevisions()
        {

            driver.findElement(televisions).click();
            System.out.println("Televisions Link clicked successfully");
        }
        public void checkItem()
        {
            driver.findElement(itemCheckbox).click();
            System.out.println("Item checked successfully");
        }
        public void clickDropdownmenu()
        {
            driver.findElement(dropdownmenu).click();
            System.out.println("drop down clicked successfully");
        }

        public void selectHighlow()
        {
            driver.findElement(highlowmenu).click();
            System.out.println("High low down selected successfully");
        }

        public void switchWindow(){

            driver.findElement(itemsecondhighest).click();
            //Specify handles of the displayed windows
            String winhandle = driver.getWindowHandle();

            Set<String> tabs = driver.getWindowHandles();
            Iterator<String> iterator = tabs.iterator();
            // To continue on the new window

            while (iterator.hasNext())

            { String ChildWindow = iterator.next();

                if (!winhandle.equalsIgnoreCase(ChildWindow))
                { driver.switchTo().window(ChildWindow);

                    System.out.println(driver.getCurrentUrl());


                    System.out.println("Switch to a new window successful");
                    break;

                }
            }
        }
        public void printAboutitem()
        {
            System.out.println(driver.findElement(aboutitem).getText());

        }
    }



