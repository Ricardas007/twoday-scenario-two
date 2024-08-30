package lt.twoday.task;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProceedToCheckoutTest extends BaseTest {

    @Description("Proceed to checkout.")
    @Test
    public void ProceedToCheckOut() {

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

        ProceedToCheckout checkout = new ProceedToCheckout(driver);

        checkout.pressProseedToCheckoutButtonInCart();
        String sectionText = checkout.proceedToFinalPageGetConfirmationText();
        Assertions.assertEquals("Shipping Address", sectionText, "Did not get message : Thank you for your purchase!");

    }
}
