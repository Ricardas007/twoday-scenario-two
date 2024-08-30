package lt.twoday.task;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectCheapestPantsToCartTest extends BaseTest{

    @Description("Select the cheapest pants and add them to the cart.")
    @Test
    public void SelectCheapestPantsToCart() {
        NavigateToWomenPants navigate = new NavigateToWomenPants(driver);
        navigate.selectWomenPants();
        FilterToShowCheapestProduct filter = new FilterToShowCheapestProduct(driver);
        filter.clickOnFilterSelection();
        filter.selectLowestFilter();
        SelectCheapestPantsToCart cheapestProduct = new SelectCheapestPantsToCart(driver);
        cheapestProduct.selectSortByPrice();
        double cheapestPrice = cheapestProduct.countSmallestPrice();
        cheapestProduct.selectCheapestProductAndPressIt();
        cheapestProduct.selectSize();
        cheapestProduct.selectColour();
        cheapestProduct.addToCartCheapestProduct();
        String conformationAlert = cheapestProduct.conformationPatsAreAddedToCart();
        double priceInCart = cheapestProduct.productPriceInCart();
        Assertions.assertEquals(cheapestPrice, priceInCart, "Cheapest price should match with cheapest product price in cart");
        Assertions.assertEquals("You added Karmen Yoga Pant to your shopping cart.", conformationAlert, "When product added to cart conformation messages should appear");
    }
}
