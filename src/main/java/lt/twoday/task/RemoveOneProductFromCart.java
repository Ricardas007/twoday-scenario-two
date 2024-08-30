package lt.twoday.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RemoveOneProductFromCart extends BasePage{

    @FindBy(css = ".minicart-wrapper > .action.showcart")
    WebElement cartIconButton;

    @FindBy (css = ".actions [data-cart-item]")
    WebElement trashCanIcon;

    @FindBy (css = ".action-accept.action-primary > span")
    WebElement okButtonOnPopUp;

    public RemoveOneProductFromCart(WebDriver driver) {
        super(driver);
    }

    public void clickOnCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIconButton));
        cartIconButton.click();
    }

    public void pressTrashCanIcon() {
        cartIconButton.click();
        wait.until(ExpectedConditions.visibilityOf(trashCanIcon));
        trashCanIcon.click();
    }

    public void confirmProductRemoval() {
        wait.until(ExpectedConditions.elementToBeClickable(okButtonOnPopUp));
        okButtonOnPopUp.click();
    }
}
