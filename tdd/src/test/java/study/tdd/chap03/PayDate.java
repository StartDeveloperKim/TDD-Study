package study.tdd.chap03;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PayDate {
    private LocalDate firstBillingDate;
    private LocalDate billingDate;
    private int payAmount;

    private PayDate() {
    }

    @Builder
    public PayDate(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
        this.firstBillingDate = firstBillingDate;
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }
}
