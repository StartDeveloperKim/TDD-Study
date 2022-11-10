package study.tdd.chap07;

import lombok.Setter;

@Setter
public class StubWeakPasswordChecker implements WeakPasswordChecker {
    private boolean weak;

    @Override
    public boolean checkPasswordWeak(String pw) {
        return weak;
    }
}
