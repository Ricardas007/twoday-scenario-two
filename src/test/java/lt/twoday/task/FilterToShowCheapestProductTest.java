package lt.twoday.task;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilterToShowCheapestProductTest extends BaseTest{

    @Description("Filter section to show the cheapest products available.")
    @Test
    public void FilterToShowCheapestProduct()  {
        NavigateToWomenPants navigate = new NavigateToWomenPants(driver);
        navigate.selectWomenPants();
        FilterToShowCheapestProduct filter = new FilterToShowCheapestProduct(driver);
        filter.clickOnFilterSelection();
        filter.selectLowestFilter();
        filter.filterAllProductsPrices();
        boolean returnState = filter.filterAllProductsPrices();
        Assertions.assertTrue(returnState,"Your return state is False, some products are outside the 30 - 39.99 price range.");
    }
}
