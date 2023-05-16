package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item");
    private SelenideElement firstCardButton = $("[data-test-id=action-deposit]");
    private SelenideElement secondCardButton = $$("[data-test-id=action-deposit]").get(1);

    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    //private SelenideElement reload = $("[data-test-id=action-reload]");


    public DashboardPage() {
        heading.shouldBe(visible);
    }
    public TransferPage firstCardButton() {
        firstCardButton.click();
        return new TransferPage();
    }

    public TransferPage secondCardButton() {
        secondCardButton.click();
        return new TransferPage();
    }
    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);

    }
    public int getSecondCardBalance() {
        val text = cards.last().text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}