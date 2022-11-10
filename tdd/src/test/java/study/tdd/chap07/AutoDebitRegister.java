package study.tdd.chap07;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class AutoDebitRegister {

    private final CardNumberValidator validator;
    private final AutoDebitInfoRepository repository;

    public RegisterResult register(AutoDebitReq req) {
        CardValidity validity = validator.validate(req.getCardNumber()); // 카드 검사
        if (validity != CardValidity.VALID) {
            // 검사결과가 유효하지 않다면 아래에서 해당 error를 반환
            return RegisterResult.error(validity);
        }

        AutoDebitInfo info = repository.findOne(req.getUserId());
        if (info != null) {
            info.changeCardNumber(req.getCardNumber());
        } else {
            AutoDebitInfo newInfo = new AutoDebitInfo(req.getUserId(), req.getCardNumber(), LocalDateTime.now());
            repository.save(newInfo);
        }

        return RegisterResult.success();
    }
}
