package lt.twoday.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductFromSuggestedProductsToCart extends BasePage{

    @FindBy(css = ".product-item:nth-of-type(3) .product-item-info")
    WebElement productFromSuggestionList;

    @FindBy (css = ".size.swatch-attribute > div[role='listbox'] > div:nth-of-type(2)")
    WebElement selectSizeButton;

    @FindBy (css = "div[role='listbox'] > div:nth-of-type(3)")
    WebElement selectColorButton;

    @FindBy (css = "#product-addtocart-button span")
    WebElement addToCartButtonOnProductPage;

    @FindBy (css = "div[role='alert'] > div > div")
    WebElement infoTextWithProductName;

    @FindBy (css = "[data-ui-id]")
    WebElement productNameText;

    public AddProductFromSuggestedProductsToCart(WebDriver driver) {
        super(driver);
    }

    public void addProductFromSuggestionList() {
        wait.until(ExpectedConditions.elementToBeClickable(productFromSuggestionList));
        productFromSuggestionList.click();
    }

    public void selectSize() {
        wait.until(ExpectedConditions.elementToBeClickable(selectSizeButton));
        selectSizeButton.click();
    }

    public void selectColor() {
        wait.until(ExpectedConditions.elementToBeClickable(selectColorButton));
        selectColorButton.click();
    }

    public void pressAddToCartOnProductPage() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonOnProductPage));
        addToCartButtonOnProductPage.click();
    }

    public String checkIsSameProductAddedToTheCart() {
        wait.until(ExpectedConditions.visibilityOf(infoTextWithProductName));
        return infoTextWithProductName.getText();
    }

}
