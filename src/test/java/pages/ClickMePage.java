package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ClickMePage {

    private SelenideElement buttonMenu =$("#item-4");
    private SelenideElement ButtonClickMe =$(byText("Click Me")) ;
    private SelenideElement clickMeMessage = $("#dynamicClickMessage") ;

    public void ButtonButtonClick () {
        buttonMenu.click();
    }

    public void ButtonClickMeClick(){
        ButtonClickMe.scrollIntoView(true).click();
    }

    public void checkMessage() {
        $(clickMeMessage).shouldHave(exactText("You have done a dynamic click"));
    }


}

