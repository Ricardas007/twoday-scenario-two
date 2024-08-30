package lt.twoday.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CompleteTheOrder extends BasePage{

    @FindBy(xpath = "//input[@id='customer-email']")
    WebElement userEmailField;

    @FindBy (xpath = "//input[@name='firstname']")
    WebElement userFirstNameField;

    @FindBy (css = "input[name='lastname']")
    WebElement userLastNameField;

    @FindBy (css = "input[name='street[0]']")
    WebElement userAddressField;

    @FindBy (css = "input[name='city']")
    WebElement userCityField;

    @FindBy (xpath = "//input[@name='postcode']")
    WebElement userZipPostalField;

    @FindBy (css = "select[name='country_id']")
    WebElement userCountryField;

    @FindBy (css = "div[name='shippingAddress.region_id'] > .control select")
    WebElement userStateField;

    @FindBy (css = "input[name='telephone']")
    WebElement userPhoneField;

    @FindBy (css = ".base")
    WebElement confirmationText;

    @FindBy (xpath = "//div[@id='shipping-method-buttons-container']//button[@type='submit']")
    WebElement nextButton;

    @FindBy (css = "button[title='Place Order']")
    WebElement placeTheOrderButton;

    public CompleteTheOrder(WebDriver driver) {
        super(driver);
    }

    public void enterUserEmail(String userEmail) {
        wait.until(ExpectedConditions.visibilityOf(userEmailField)).sendKeys(userEmail);
    }

    public void enterUserFirstName(String userFirsName) {
        wait.until(ExpectedConditions.visibilityOf(userFirstNameField));
        userFirstNameField.sendKeys(userFirsName);
        driver.switchTo().defaultContent();
    }

    public void enterUserLastName(String customerLastName) {
        wait.until(ExpectedConditions.visibilityOf(userLastNameField)).sendKeys(customerLastName);
    }

    public void enterUserAddress(String customerAddress) {
        wait.until(ExpectedConditions.visibilityOf(userAddressField)).sendKeys(customerAddress);
    }

    public void enterUserCity(String customerCity) {
        wait.until(ExpectedConditions.visibilityOf(userCityField)).sendKeys(customerCity);
    }

    public void selectCountry(String customerCountry) {
        wait.until(ExpectedConditions.visibilityOf(userCountryField));
        Select objSelect = new Select(driver.findElement(By.cssSelector("select[name='country_id']")));
        objSelect.selectByVisibleText(customerCountry);
    }

    public void selectState(String customerState) {
        wait.until(ExpectedConditions.visibilityOf(userStateField));
        Select objSelect = new Select(driver.findElement(By.cssSelector("div[name='shippingAddress.region_id'] > .control select")));
        objSelect.selectByVisibleText(customerState);
    }

    public void enterUserStateZip(String customerZip) {
        wait.until(ExpectedConditions.visibilityOf(userZipPostalField)).sendKeys(customerZip);
    }

    public void enterUserPhone(String customerPhone) {
        wait.until(ExpectedConditions.visibilityOf(userPhoneField)).sendKeys(customerPhone);
    }

    public void clickNextButtonAfterShippingMethodLoads() {
        By spinner = By.cssSelector("div.loading-mask");
        wait.until(ExpectedConditions.visibilityOfElementLocated(spinner));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }


    public void placeTheOrderAndFinish() {
        By spinner = By.cssSelector("div.loading-mask");
        wait.until(ExpectedConditions.visibilityOfElementLocated(spinner));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
        wait.until(ExpectedConditions.elementToBeClickable(placeTheOrderButton));
        placeTheOrderButton.click();
    }

    public String proceedToFinalPageGetConfirmationText() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".base"),"Thank you for your purchase!"));
        return confirmationText.getText();
    }

}
