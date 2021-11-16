package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import java.util.Locale;

public class StudRegFormWithPagesAndFaker extends TestBase {
    Faker faker = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String streetAddress = faker.address().streetAddress();
    String email = faker.internet().emailAddress();
    String phone = faker.number().digits(10);


    @Test
    void fillFormTest() {
        RegistrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.chooseGender();
        registrationPage.setNumber(phone);
        registrationPage.calendarComponent.setDateOfBirth("10", "1995", "11");
        registrationPage.setSubjects("Maths");
        registrationPage.clickHobbiesCheckBox();
        registrationPage.downloadPicture();
        registrationPage.setAddress(streetAddress);
        registrationPage.setState("NCR");
        registrationPage.setCity("Delhi");
        registrationPage.pressSubmitButton();
        registrationPage.checkResultTable("Student Name", firstName + " " + lastName )
                .checkResultTable("Student Email", email)
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", phone)
                .checkResultTable("Date of Birth", "11 November,1995")
                .checkResultTable("Subjects", "Maths")
                .checkResultTable("Hobbies", "Sports")
                .checkResultTable("Picture", "1.jpg")
                .checkResultTable("Address", streetAddress)
                .checkResultTable("State and City", "NCR Delhi");
    }
}