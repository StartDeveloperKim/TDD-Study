package study.tdd.chap07;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AutoDebitInfo {

    private String userId;
    private String cardNumber;
    private LocalDateTime createDate;

    public void changeCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
