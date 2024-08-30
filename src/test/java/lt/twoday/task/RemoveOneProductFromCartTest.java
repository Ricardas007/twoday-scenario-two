package lt.twoday.task;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RemoveOneProductFromCartTest extends BaseTest{

    @Description("Remove product from the cart.")
    @ParameterizedTest()
    @ValueSource(strings = {"2"})
    public void RemoveOneProductFromCart(String expectedNumberOfProductsInCart)  {
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
        RemoveOneProductFromCart removeProduct = new RemoveOneProductFromCart(driver);
        removeProduct.clickOnCartButton();
        removeProduct.pressTrashCanIcon();
        removeProduct.confirmProductRemoval();
        addProducts.clickOnCartWhenProductInCartIs2();
        String numberOfProductsInCart = addProducts.checkCartIconNumber();
        Assertions.assertEquals(expectedNumberOfProductsInCart, numberOfProductsInCart, "After removal there should be two products in the cart");
    }
}
