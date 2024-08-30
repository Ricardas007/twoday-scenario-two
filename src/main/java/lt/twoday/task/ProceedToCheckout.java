package lt.twoday.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProceedToCheckout extends BasePage{

    @FindBy(css = "button#top-cart-btn-checkout")
    WebElement checkoutButton;

    @FindBy (css = "li#shipping > .step-title")
    WebElement sectionTitle;

    public ProceedToCheckout(WebDriver driver) {
        super(driver);
    }

    public void pressProseedToCheckoutButtonInCart() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

    public String proceedToFinalPageGetConfirmationText() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("li#shipping > .step-title"),"Shipping Address"));
        return sectionTitle.getText();
    }
}


