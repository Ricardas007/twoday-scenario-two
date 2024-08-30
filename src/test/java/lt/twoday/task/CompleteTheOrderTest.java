package lt.twoday.task;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CompleteTheOrderTest extends BaseTest{

    @Description("Complete the order.")
    @ParameterizedTest(name = "Complete the order {index} => e-mail {0}, First name {1}, Last Name {2}, Address {3}, City {4}, Country {5}, State {6}, Zip Code {7}, Phone Number {8}")
    @CsvFileSource(files = "src/main/resources/shipping_details.csv", numLinesToSkip = 1)
    public void CompleteTheOrder(ArgumentsAccessor arguments) {

        String customerEmail = arguments.getString(0);
        String customerFirstName = arguments.getString(1);
        String customerLastName = arguments.getString(2);
        String customerAddress = arguments.getString(3);
        String customerCity = arguments.getString(4);
        String customerCountry = arguments.getString(5);
        String customerState = arguments.getString(6);
        String customerZip = arguments.getString(7);
        String customerPhone = arguments.getString(8);

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

        CompleteTheOrder completeOrder = new CompleteTheOrder(driver);

        completeOrder.selectCountry(customerCountry);
        completeOrder.selectState(customerState);
        completeOrder.enterUserEmail(customerEmail);
        completeOrder.enterUserFirstName(customerFirstName);
        completeOrder.enterUserLastName(customerLastName);
        completeOrder.enterUserAddress(customerAddress);
        completeOrder.enterUserCity(customerCity);
        completeOrder.enterUserStateZip(customerZip);
        completeOrder.enterUserPhone(customerPhone);
        completeOrder.clickNextButtonAfterShippingMethodLoads();
        completeOrder.placeTheOrderAndFinish();
        String confirmationText = completeOrder.proceedToFinalPageGetConfirmationText();
        Assertions.assertEquals("Thank you for your purchase!", confirmationText, "Did not get message : Thank you for your purchase!");
        }

    }
