package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddRecordPage {

    /* ===================== ELEMENTS ===================== */

    private final SelenideElement buttonAdd = $("#addNewRecordButton");
    private final SelenideElement boxFirstName = $("#firstName");
    private final SelenideElement boxLastName = $("#lastName");
    private final SelenideElement boxEmail = $("#userEmail");
    private final SelenideElement boxAge = $("#age");
    private final SelenideElement boxSalary = $("#salary");
    private final SelenideElement boxDepartment = $("#department");
    private final SelenideElement buttonSubmit = $("#submit");
    private final SelenideElement buttonEditRecord4 = $("span[id='edit-record-4'] svg path");

    private final ElementsCollection tableRows = $$("div.rt-tr-group");

    /* ===================== STATE ===================== */

    private final Map<Field, String> lastEdits = new HashMap<>();

    private final Map<Field, SelenideElement> fieldMap = Map.of(
            Field.FIRST_NAME, boxFirstName,
            Field.LAST_NAME, boxLastName,
            Field.EMAIL, boxEmail,
            Field.AGE, boxAge,
            Field.SALARY, boxSalary,
            Field.DEPARTMENT, boxDepartment
    );

    /* ===================== ACTIONS ===================== */

    public void clickAddButton() {
        buttonAdd.click();
    }

    public void addNewRecord(String firstName,
                             String lastName,
                             String email,
                             String age,
                             String salary,
                             String department) {

        boxFirstName.setValue(firstName);
        boxLastName.setValue(lastName);
        boxEmail.setValue(email);
        boxAge.setValue(age);
        boxSalary.setValue(salary);
        boxDepartment.setValue(department);
    }

    public void clickSubmit() {
        buttonSubmit.click();
    }

    public void clickEditRecord4() {
        buttonEditRecord4.scrollIntoView(true).click();
    }

    /* ===================== EDIT ===================== */

    public void editRecord(Object... fieldValuePairs) {

        if (fieldValuePairs.length % 2 != 0) {
            throw new IllegalArgumentException("Alan-değer çiftleri eksik");
        }

        Map<Field, String> updates = new HashMap<>();

        for (int i = 0; i < fieldValuePairs.length; i += 2) {
            updates.put(
                    (Field) fieldValuePairs[i],
                    (String) fieldValuePairs[i + 1]
            );
        }

        applyEdits(updates);
    }

    private void applyEdits(Map<Field, String> updates) {

        lastEdits.clear();

        for (Map.Entry<Field, String> entry : updates.entrySet()) {
            Field field = entry.getKey();
            String value = entry.getValue();

            SelenideElement input = fieldMap.get(field);
            if (input == null) {
                throw new IllegalArgumentException("Desteklenmeyen alan: " + field);
            }

            input.shouldBe(visible).setValue(value);
            lastEdits.put(field, value);
        }
    }

    /* ===================== ASSERTION ===================== */

    public void shouldReflectLastEdits() {

        for (String expectedValue : lastEdits.values()) {
            tableRows.findBy(text(expectedValue))
                    .shouldBe(visible);
        }
    }
}
