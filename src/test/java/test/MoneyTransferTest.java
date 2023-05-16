package test;

import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPageV2;
import page.TransferPage;
import page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {

    @BeforeEach
    void setUp() {
       var loginPage = open("http://localhost:9999/", LoginPageV2.class);
       var authInfo = getAuthInfo();
       var verificationPage = loginPage.validLogin(authInfo);
       var verificationCode = getVerificationCodeFor(authInfo);
       verificationPage.validVerify(verificationCode);

    }

    @Test
    void shouldTransferMoneyBetweenOwnCards1() {
        var dashboardPage = new DashboardPage();
        var cardsInfo = DataHelper.getCardsInfo();
        int firstBalanceBefore = dashboardPage.getFirstCardBalance();
        int secondBalanceBefore = dashboardPage.getSecondCardBalance();
        int sum = 100;

        var transferPage = dashboardPage.firstCardButton();
        transferPage.makeTransfer(Integer.toString(sum), cardsInfo);

        assertEquals(firstBalanceBefore + sum, dashboardPage.getFirstCardBalance());
        assertEquals(secondBalanceBefore - sum, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldTransferMoneyBetweenOwnCards2() {
        var dashboardPage = new DashboardPage();
        var cardsInfo = DataHelper.getCardsInfo();
        int firstBalanceBefore = dashboardPage.getFirstCardBalance();
        int secondBalanceBefore = dashboardPage.getSecondCardBalance();
        int sum = 5000;

        var transferPage = dashboardPage.secondCardButton();
        transferPage.makeTransfer(Integer.toString(sum), cardsInfo);

        assertEquals(firstBalanceBefore - sum, dashboardPage.getFirstCardBalance());
        assertEquals(secondBalanceBefore + sum, dashboardPage.getSecondCardBalance());
    }
}

//    @Test
//    void shouldTransferMoneyBetweenOwnCards1() {
//        var cards = new DashboardPage();
//        var cardsInfo = DataHelper.getCardsInfo();
//        int firstBalanceBefore = cards.getFirstCardBalance();
//        int secondBalanceBefore = cards.getSecondCardBalance();
//        int sum = 100;
//
//        var transferPage = cards.firstCardButton();
//        transferPage.makeTransfer(Integer.toString(sum), cardsInfo);
//
//        assertEquals(firstBalanceBefore + sum, cards.getFirstCardBalance());
//        assertEquals(secondBalanceBefore - sum, cards.getSecondCardBalance());
//    }
//
//
//    @Test
//    void shouldTransferMoneyBetweenOwnCards2() {
//        var cards = new DashboardPage();
//        var cardsInfo = DataHelper.getCardsInfo();
//        int firstBalanceBefore = cards.getFirstCardBalance();
//        int secondBalanceBefore = cards.getSecondCardBalance();
//        int sum = 5000;
//
//        var transferPage = cards.secondCardButton();
//        transferPage.makeTransfer(Integer.toString(sum), cardsInfo);
//
//        assertEquals(firstBalanceBefore - sum, cards.getFirstCardBalance());
//        assertEquals(secondBalanceBefore + sum, cards.getSecondCardBalance());
//
//    }
//
//
//}
//
//




