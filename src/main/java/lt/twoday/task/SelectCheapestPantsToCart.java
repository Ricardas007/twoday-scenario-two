package lt.twoday.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectCheapestPantsToCart extends BasePage{

    @FindBy (css = "select#sorter")
    WebElement selectSortByPrice;

    @FindBy(css = ".product-items .product-item:nth-of-type(1)")
    WebElement cheapestProductFromCategory;

    @FindBy (css = ".size.swatch-attribute > div[role='listbox'] > div:nth-of-type(1)")
    WebElement selectProductSize;

    @FindBy (css = ".color.swatch-attribute > div[role='listbox'] > div:nth-of-type(2)")
    WebElement selectProductColour;

    @FindBy (css = "#product-addtocart-button span")
    WebElement addToCartBtn;

    @FindBy (css = "div[role='alert'] > div > div")
    WebElement informationTextAppearsPantsAddedToCart;

    @FindBy (css = ".price-box.price-final_price .price-wrapper > .price")
    List<WebElement> allProductPrices;

    @FindBy (css = ".counter-number")
    WebElement counterNumberCartBtn;

    @FindBy (css = ".amount.price-container > .price-wrapper > .price")
    WebElement productPriceInCart;

    public SelectCheapestPantsToCart(WebDriver driver) {
        super(driver);
    }

    public void selectSortByPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(selectSortByPrice));
        Select objSelect = new Select(driver.findElement(By.cssSelector("select#sorter")));
        objSelect.selectByVisibleText("Price");
        selectSortByPrice.click();
    }

    public void selectCheapestProductAndPressIt() {
        cheapestProductFromCategory.click();
    }

    public void selectSize() {
        wait.until(ExpectedConditions.elementToBeClickable(selectProductSize));
        selectProductSize.click();
    }

    public void selectColour() {
        wait.until(ExpectedConditions.elementToBeClickable(selectProductColour));
        selectProductColour.click();
    }

    public void addToCartCheapestProduct() {
        addToCartBtn.click();
    }

    public String conformationPatsAreAddedToCart() {
        wait.until(ExpectedConditions.visibilityOf(informationTextAppearsPantsAddedToCart));
        return informationTextAppearsPantsAddedToCart.getText();
    }

    public double countSmallestPrice() {
        List<Double> prices = new ArrayList<>();
        for (WebElement product : allProductPrices) {
            String priceText = product.getText().replace("$", "").trim();
            try {
                double price = Double.parseDouble(priceText);
                prices.add(price);
            } catch (NumberFormatException e) {
                System.out.println("Could not get price: " +priceText);
            }
        }
        Collections.sort(prices);
        double smallestPrice = prices.getFirst();
        System.out.println("The smallest price is: " + smallestPrice);
        return smallestPrice;
    }

    public double productPriceInCart() {
        counterNumberCartBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(productPriceInCart)).click();
        String priceInCart = productPriceInCart.getText().replace("$", "").trim();
        return Double.parseDouble(priceInCart);
    }
}
