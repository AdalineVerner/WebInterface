package ru.netology.javaqa;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {

    @Test
    void shouldTestWebBySelenide() throws InterruptedException {
        open("http://localhost:9999/");
        Thread.sleep(50000);
        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Ксения Линн");
        form.$("[data-test-id=phone] input").setValue("+79819170750");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success").shouldHave(exactText("  Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));
    }
}
