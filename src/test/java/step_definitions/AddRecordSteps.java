package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddRecordPage;

import static com.codeborne.selenide.Selenide.open;
import static pages.Field.*;

public class AddRecordSteps {

    private final AddRecordPage addRecordPage = new AddRecordPage();

    /* ===================== GIVEN ===================== */

    @Given("Kullanıcı Web Tables sayfasına gider")
    public void goToWebTablesPage() {
        open("https://demoqa.com/webtables");
    }

    /* ===================== WHEN ===================== */

    @When("Kullanıcı ADD düğmesine tıklar")
    public void clickAddButton() {
        addRecordPage.clickAddButton();
    }

    @When("Kullanıcı yeni kayıt bilgilerini girer")
    public void fillNewRecordForm() {
        addRecordPage.addNewRecord(
                "Ali",
                "Yılmaz",
                "ali@test.com",
                "30",
                "10000",
                "IT"
        );
    }

    @When("Kullanıcı Submit düğmesine tıklar")
    public void submitForm() {
        addRecordPage.clickSubmit();
    }

    @When("Kullanıcı eklenen kaydı düzenler")
    public void editAddedRecord() {
        addRecordPage.clickEditRecord4();
        addRecordPage.editRecord(
                FIRST_NAME, "Hasan",
                AGE, "27",
                EMAIL, "hasan@hotmail.com",
                DEPARTMENT, "HR"
        );
    }

    @When("Kullanıcı düzenlenen bilgileri kaydeder")
    public void saveEditedRecord() {
        addRecordPage.clickSubmit();
    }

    /* ===================== THEN ===================== */

    @Then("Kaydın değiştiği kontrol edilir")
    public void verifyRecordUpdated() {
        addRecordPage.shouldReflectLastEdits();
    }
}
