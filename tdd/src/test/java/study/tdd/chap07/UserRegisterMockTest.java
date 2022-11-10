package study.tdd.chap07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserRegisterMockTest {
    private UserRegister userRegister;

    @Mock
    private WeakPasswordChecker mockPasswordChecker;

    private final MemoryUserRepository fakeRepository = new MemoryUserRepository();

    @Mock
    private EmailNotifier mockEmailNotifier;

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
    }

    @Test
    void 약한_암호면_가입_실패() {
        BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true);

        Assertions.assertThrows(WeakPasswordException.class, () ->{
            userRegister.register("id", "pw", "email");
        });
    }

    @Test
    void 회원_가잆비_암호_검사_수행함() {
        userRegister.register("id", "pw", "email");

        BDDMockito.then(mockPasswordChecker)
                .should()
                .checkPasswordWeak(BDDMockito.anyString());

    }

}
