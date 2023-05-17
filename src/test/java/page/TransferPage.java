package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement amount = $("[data-test-id=amount] input");
    private final SelenideElement from = $("[data-test-id=from] input");
    private final SelenideElement transferButton = $("[data-test-id=action-transfer]");
    private final SelenideElement transferHead = $(withText("Пополнение карты"));
    private final SelenideElement errorButton = $("[data-test-id=error-notification] button");
    private final SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public TransferPage() {
        transferHead.shouldBe(visible);
    }

    public DashboardPage makeTransfer(String sum, DataHelper.CardsInfo cardsInfo) {
        amount.setValue(sum);
        from.setValue(String.valueOf(cardsInfo));
        transferButton.click();
        return new DashboardPage();
    }
//    public DashboardPage makeSuccessTransfer(String sum, DataHelper.CardsInfo cardsInfo) {
//        makeTransfer(sum, cardsInfo);
//        return new DashboardPage();
//    }
    public void getError() {
        $(withText("Ошибка! ")).shouldBe(visible, Duration.ofSeconds(10));
    }
    //

    public void clearFields() {
        amount.clear();
        from.clear();
    }
    public String getErrorNotificationMessage() {
        return errorNotification.getText();
    }
    public void dismissErrorNotification() {
        errorButton.click();
    }
}
