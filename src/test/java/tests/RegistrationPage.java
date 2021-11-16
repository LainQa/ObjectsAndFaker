package tests;


import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPage {

    public static void openPage(){
        open("https://demoqa.com/automation-practice-form");
    }
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioButton = $("[for=gender-radio-1]"),
            userNumberInput = $("#userNumber"),
            subjectsInput =   $("#subjectsInput"),
            hobbiesCheckbox = $("[for=hobbies-checkbox-1"),
            uploadPicture = $("#uploadPicture"),
            addressInput =  $("#currentAddress"),
            stateInput =  $("#react-select-3-input"),
            cityInput =  $("#react-select-4-input"),
            submitButton = $(".btn.btn-primary"),
            submitMessage = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");


    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseGender () {
        genderRadioButton.click();
        return this;
    }

    public RegistrationPage setNumber (String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage setSubjects (String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage clickHobbiesCheckBox () {
        hobbiesCheckbox.click();
        return this;
    }

    public RegistrationPage downloadPicture () {
        uploadPicture.uploadFromClasspath("1.jpg");
        return this;
    }

    public RegistrationPage setAddress (String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState (String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity (String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage pressSubmitButton () {
        submitButton.pressEnter();
        return this;
    }
    public RegistrationPage checkResultTable(String key, String value) {
        submitMessage.shouldHave(text("Thanks for submitting the form"));
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
