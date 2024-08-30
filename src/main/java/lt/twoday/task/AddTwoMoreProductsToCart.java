package lt.twoday.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddTwoMoreProductsToCart extends BasePage{

    @FindBy (css = ".items > li:nth-of-type(4) > a")
    WebElement clickOnPantsLink;

    @FindBy(css = ".items.list.product-items.products > li:nth-of-type(1)")
    WebElement productOneToCart;

    @FindBy (css = ".items.list.product-items.products > li:nth-of-type(5)")
    WebElement productTwoToCart;

    @FindBy (css = "[attribute-code='size'] [index='0']")
    WebElement producrSize;

    @FindBy (css = "[index='2']")
    WebElement productColor;

    @FindBy (css = ".minicart-wrapper > .action.showcart")
    WebElement cartIconButton;

    @FindBy (css = "button#product-addtocart-button")
    WebElement productAddToCartButton;

    @FindBy (css = ".counter-number")
    WebElement numberOfProductsInCart;
    
    public AddTwoMoreProductsToCart(WebDriver driver) {
        super(driver);
    }

    public void navigateToPantsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnPantsLink));
        clickOnPantsLink.click();
    }

    public void addFirstProduct() {
        wait.until(ExpectedConditions.visibilityOf(productOneToCart));
        productOneToCart.click();

    }

    public void selectSize() {
        producrSize.click();
    }

    public void selectColour() {
        productColor.click();
    }

    public void pressAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(productAddToCartButton));
        productAddToCartButton.click();
    }

    public void clickOnCartWhenProductInCartIs2() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIconButton));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".counter-number"),"2"));
        cartIconButton.click();
    }

    public void addSecondProduct() {
        wait.until(ExpectedConditions.visibilityOf(productTwoToCart));
        productTwoToCart.click();
    }

    public void clickOnCartWhenProductInCartIs3() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIconButton));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".counter-number"),"3"));
        cartIconButton.click();
    }

    public String checkCartIconNumber() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIconButton));
        return numberOfProductsInCart.getText();
    }

}
