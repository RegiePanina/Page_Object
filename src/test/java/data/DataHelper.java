package data;

import lombok.Value;
import org.checkerframework.checker.units.qual.C;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardsInfo {
        private String cardInfo;

    }

    public static CardsInfo getFirstCard() {
        return new CardsInfo("5559 0000 0000 0001");
    }

    public static CardsInfo getSecondCard() {
        return new CardsInfo("5559 0000 0000 0002");
    }
}
