import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployee {
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "middleName")
    private WebElement middleName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "employeeId")
    private WebElement employeeId;
    @FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
    private WebElement location;
    @FindBy (id = "btnSave")
    private WebElement saveButton;

    public void enterfirstName(String fName){
        firstName.sendKeys(fName);
    }

    public void enterlastName(String lName){
        lastName.sendKeys (lName);
    }
    public void clickSave(){
        saveButton.click();
    }
}
