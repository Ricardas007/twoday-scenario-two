package lt.twoday.task;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AddProductFromSuggestedProductsToCartTest extends BaseTest {

    @Description("Add product to the cart from suggested products.")
    @ParameterizedTest()
    @ValueSource(strings = {"3"})
    public void AddProductFromSuggestedProductsToCart() {
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
        AddProductFromSuggestedProductsToCart addFromSuggested = new AddProductFromSuggestedProductsToCart(driver);
        addFromSuggested.addProductFromSuggestionList();
        addFromSuggested.selectSize();
        addFromSuggested.selectColor();
        addFromSuggested.pressAddToCartOnProductPage();
        addProducts.clickOnCartWhenProductInCartIs3();
        String messageTextContains = addFromSuggested.checkIsSameProductAddedToTheCart();
        Assertions.assertEquals(messageTextContains, "You added Diana Tights to your shopping cart.", "The confirmation message does not contains the expected text");
    }

}
