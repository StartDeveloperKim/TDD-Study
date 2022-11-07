package study.tdd.chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayDate payDate) {
        int monthsToAdd = payDate.getPayAmount() == 100_000 ? 12 : payDate.getPayAmount() / 10_000;

        if (payDate.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payDate, monthsToAdd);
        } else {
            return payDate.getBillingDate().plusMonths(monthsToAdd);
        }
    }

    private static LocalDate expiryDateUsingFirstBillingDate(PayDate payDate, int monthsToAdd) {
        LocalDate candidateExp = payDate.getBillingDate().plusMonths(monthsToAdd);
        final int dayOfFirstBilling = payDate.getFirstBillingDate().getDayOfMonth();

        if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);

            if (dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(payDate.getFirstBillingDate().getDayOfMonth());
        } else {
            return candidateExp;
        }
    }

    private static int lastDayOfMonth(LocalDate candidateExp) {
        final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
        return dayLenOfCandiMon;
    }
}
