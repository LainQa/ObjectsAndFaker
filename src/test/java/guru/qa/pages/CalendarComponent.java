package guru.qa.pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private SelenideElement
            dateOfBirthButton = $("#dateOfBirthInput"),
            monthOfBirth = $(".react-datepicker__month-select"),
            yearOfBirth = $(".react-datepicker__year-select");

    public void setDateOfBirth (String month, String year, String day) {
        dateOfBirthButton.click();
        monthOfBirth.selectOptionByValue(month);
        yearOfBirth.selectOptionByValue(year);
        $$(".react-datepicker__day").find(text(day)).click();
    }
}