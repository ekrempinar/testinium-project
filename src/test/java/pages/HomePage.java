package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="onetrust-accept-btn-handler")
    public WebElement acceptCookiesButton;

    @FindBy(xpath="//button[@class='o-modal__closeButton bwi-close']//*[name()='svg']")
    public WebElement closeCategoryButton;

    @FindBy(xpath = "//img[@alt='Beymen']")
    public WebElement homepageLogo;

	@FindBy(css="input[placeholder='Ürün, Marka Arayın']")
	public WebElement searchBar;

	@FindBy(css="div[id='productList'] div:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2) a:nth-child(1) span:nth-child(1)")
    public WebElement productTitle;
    //div:nth-child(2) >.o-productList__item >.m-productCard > .m-productCard__detail > a > .m-productCard__title

    @FindBy(css="body > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(2) > h3:nth-child(1)")
    public WebElement productDescription;

    @FindBy(css="body > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > span:nth-child(1) > span:nth-child(1)")
    public WebElement productPrice;

    @FindBy(css="div[id='sizes'] span:nth-child(2)")
    public WebElement variation;

    @FindBy(css="#addBasket")
    public WebElement addBasket;

    @FindBy(css="button[class='m-notification__button btn']")
    public WebElement goToBasket;

    @FindBy(css=".m-productPrice__salePrice")
    public WebElement priceInBasket;

    @FindBy(css="#quantitySelect0-key-0")
    public WebElement productNumber;

    @FindBy(css="#removeCartItemBtn0-key-0")
    public WebElement removeProductsFromBasket;

    @FindBy(xpath="//strong[contains(text(),'Sepetinizde Ürün Bulunmamaktadır')]")
    public WebElement checkBasket;
}
