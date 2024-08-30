package lt.twoday.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FilterToShowCheapestProduct extends BasePage{

    @FindBy(css = "div:nth-of-type(11) > div[role='tab']")
    WebElement priceFilter;

    @FindBy (css = "div:nth-of-type(11) > div[role='tabpanel'] > ol > li:nth-of-type(1) > a")
    WebElement cheapestFilterOption;

    public FilterToShowCheapestProduct(WebDriver driver) {
        super(driver);

    }

    public void clickOnFilterSelection() {
        wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
        priceFilter.click();
    }

    public void selectLowestFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(cheapestFilterOption));
        cheapestFilterOption.click();
    }

    public boolean filterAllProductsPrices() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-of-type(1) > .product-item-info")));

        List<WebElement> productPrices = driver.findElements(By.cssSelector("li:nth-of-type(1) > .product-item-info  .price-box.price-final_price .price-wrapper > .price"));

        boolean allPricesValid = true;

        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", "").trim();  // Assuming prices have a $ sign
            double price = Double.parseDouble(priceText);

            if (price < 30 || price > 39.99) {
                allPricesValid = false;
                break;
            }
        }

        if (allPricesValid) {
            System.out.println("All products are within the 30 - 39.99 price range.");
        } else {
             System.out.println("Some products are outside the 30 - 39.99 price range.");
        }
        return allPricesValid;
    }
}
