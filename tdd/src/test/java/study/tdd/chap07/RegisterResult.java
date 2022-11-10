package study.tdd.chap07;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterResult {
    private CardValidity validity;


    public static RegisterResult success() {
        return new RegisterResult(CardValidity.VALID);
    }

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult(validity);
    }
}
