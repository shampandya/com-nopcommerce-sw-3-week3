package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class TopMenuTest extends Utility {

    String BaseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'" + menu + "')]"));
    }
    //1.2 This method should click on the menu whatever name is passed as parameter.
    //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation() {
        List<String> topMenus = new ArrayList<>();
        topMenus.add("Computers");
        topMenus.add("Electronics");
        topMenus.add("Apparel");
        topMenus.add("Digital downloads");
        topMenus.add("Books");
        topMenus.add("Jewelry");
        topMenus.add("Gift Cards");

        for (String topMenu : topMenus) {
            selectMenu(topMenu);
            String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'" + topMenu + "')]"));
            Assert.assertEquals("Menu not found", topMenu, actualMessage);
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
