package study.tdd.chap07;

import lombok.Setter;

@Setter
public class StubCardNumberValidator extends CardNumberValidator{
    // 진짜 객체를 상속받은 대역을 만들었다.
    private String invalidNo;
    private String theftNo;

    @Override
    public CardValidity validate(String cardNumber) {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }
        if (theftNo != null && theftNo.equals(cardNumber)) {
            return CardValidity.THEFT;
        }
        return CardValidity.VALID;
    }
}
