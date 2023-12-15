package Lesson13;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage {
    @FindBy(id="occupation")
    private WebElement occupationField;

    @FindBy(id ="age")
    private WebElement ageField;

    @FindBy(id="location")
    private WebElement locationField;

    @FindBy(css="input[type='button']")
    private WebElement submitButton;

    public void fillForm(String occupation,String age,String location){
        occupationField.sendKeys(occupation);
        ageField.sendKeys(age);
        locationField.sendKeys(location);



    }
}
