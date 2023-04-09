package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.Keys;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.RetryRule;
import utilities.ReusableMethods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePageTest extends HomePage {
    public static Logger log = LogManager.getLogger();
    HomePage homePage = new HomePage();
    ReusableMethods methods = new ReusableMethods();

    @Before
    public void setup() {
        log.info("Home Page Test Started");
        Driver.getDriver().get(ConfigReader.getProperty("beymenUrl"));
        log.info("Navigated to beymen home page");

        homePage.acceptCookiesButton.click();
        log.info("Cookies accepted");

        homePage.closeCategoryButton.click();
        log.info("Gender selection closed");
    }

    @Rule
    public RetryRule retryRule = new RetryRule(3);

    @Order(1)
    @Test
    public void navigateToHomepage() {
        homePage.homepageLogo.isDisplayed();
        log.info("Home page-logo checked successfully");
        homePage.searchBar.isDisplayed();
        log.info("Home page-search bar checked successfully");
    }

    @Order(3)
    @Test
    public void writeAndDeleteProductTextFromExcelFile() throws IOException {
        String text = String.valueOf(methods.getDataFromExcelFile("beymen-test-data.xlsx", 0, 0));
        homePage.searchBar.sendKeys(text);
        log.info("Home page- the product coming from excel file entered successfully");
        homePage.searchBar.clear();
        log.info("Home page- searched product deleted from search bar successfully");
    }

    @Order(2)
    @Test
    public void searchNewProductFromExcelFile() throws IOException {
        String text = String.valueOf(methods.getDataFromExcelFile("beymen-test-data.xlsx", 1, 0));
        homePage.searchBar.sendKeys(text, Keys.ENTER);
        log.info("Home page- the product coming from excel files second row entered successfully");

        String TestFile = "src\\products.txt";
        File FC = new File(TestFile);
        FC.createNewFile();
        log.info(".txt file created successfully");

        String title = homePage.productTitle.getText();
        String description = homePage.productDescription.getText();
        String price = homePage.productPrice.getText();

        FileWriter FW = new FileWriter(TestFile);
        BufferedWriter BW = new BufferedWriter(FW);
        BW.write("Product Title: " + title);
        log.info("Product title written into the .txt file successfully");
        BW.newLine();
        BW.write("Product Description: " + description);
        log.info("Product description written into the .txt file successfully");
        BW.newLine();
        BW.write("Product Price: " + price);
        log.info("Product price written into the .txt file successfully");
        BW.close();

        methods.waitUntil(5);
        homePage.productDescription.click();
        log.info("Add basket button clicked successfully");

        homePage.variation.click();
        log.info("Variation selected successfully");

        homePage.addBasket.click();
        log.info("Product added into to the basket successfully");

        homePage.goToBasket.click();
        log.info("Gone to the basket successfully");

        String priceInBasket = homePage.priceInBasket.getText();
        Assert.assertEquals(price, priceInBasket);
        log.info("Products price and priceInBasket is equal");

        methods.waitUntil(2);
        methods.selectDropdown("quantitySelect0-key-0", "2");
        String productNumber = homePage.productNumber.getText();
        assertTrue(productNumber.contains("2 adet"));
        log.info("Products number increased to number 2 successfully");

        methods.waitUntil(2);
        homePage.removeProductsFromBasket.click();
        log.info("Products removed from basket successfully");
        String isBasketEmpty = homePage.checkBasket.getText();
        Assert.assertEquals(isBasketEmpty, "SEPETINIZDE ÜRÜN BULUNMAMAKTADIR");
        log.info("Checked products removed from basket successfully");
    }


    @After
    public void closeDriver() {
        Driver.closeDriver();
        log.info("Driver closed");
    }
}
