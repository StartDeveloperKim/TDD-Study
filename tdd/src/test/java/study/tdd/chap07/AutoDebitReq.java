package study.tdd.chap07;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AutoDebitReq {

    private String userId;
    private String cardNumber;


}
