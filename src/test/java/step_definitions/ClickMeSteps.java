package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClickMePage;

import static com.codeborne.selenide.Selenide.open;

public class ClickMeSteps {

    ClickMePage page=new ClickMePage();

    @Given("Kullanıcı elements sayfasındadır")
    public void elemetsSayfası (){
        open("https://demoqa.com/elements");
    }

    @When("Kullanıcı button sekmesine gider")
    public void buttonSekmesineGider(){
        page.ButtonButtonClick();
    }

    @And("Kullanıcı Click Me butonuna tıklar")
    public void clickMeButonuna(){
        page.ButtonClickMeClick();
    }

    @Then("Mesajın doğruluğu kontrol edilir")
    public void mesajKontrolEdilir(){
        page.checkMessage();
    }
}
