package lt.twoday.task;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AddTwoMoreProductsToCartTest extends BaseTest{

    @Description("Add 2 more products to the cart. Check that cart icon is updated with each product.")
    @ParameterizedTest()
    @ValueSource(strings = {"3"})
    public void AddTwoMoreProductsToCart(String expectedNumberOfProductsInCart) {
        NavigateToWomenPants navigate = new NavigateToWomenPants(driver);
        navigate.selectWomenPants();
        FilterToShowCheapestProduct filter = new FilterToShowCheapestProduct(driver);
        filter.clickOnFilterSelection();
        filter.selectLowestFilter();
        SelectCheapestPantsToCart cheapestProduct = new SelectCheapestPantsToCart(driver);
        cheapestProduct.selectSortByPrice();
        cheapestProduct.selectCheapestProductAndPressIt();
        cheapestProduct.selectSize();
        cheapestProduct.selectColour();
        cheapestProduct.addToCartCheapestProduct();
        AddTwoMoreProductsToCart addProducts = new AddTwoMoreProductsToCart(driver);
        addProducts.navigateToPantsPage();
        addProducts.addFirstProduct();
        addProducts.selectSize();
        addProducts.selectColour();
        addProducts.pressAddToCart();
        addProducts.clickOnCartWhenProductInCartIs2();
        addProducts.navigateToPantsPage();
        addProducts.addSecondProduct();
        addProducts.selectSize();
        addProducts.selectColour();
        addProducts.pressAddToCart();
        addProducts.clickOnCartWhenProductInCartIs3();
        addProducts.checkCartIconNumber();
        String numberOfProductsInCart = addProducts.checkCartIconNumber();
        Assertions.assertEquals(expectedNumberOfProductsInCart, numberOfProductsInCart, "There should be 3 products in the shopping cart");
    }
}
