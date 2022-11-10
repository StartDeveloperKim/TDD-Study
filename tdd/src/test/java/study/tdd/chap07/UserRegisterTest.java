package study.tdd.chap07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterTest {
    private UserRegister userRegister;
    private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubPasswordChecker, fakeRepository, spyEmailNotifier);
    }

    @Test
    void 약한_암호면_가입_실패() {
        stubPasswordChecker.setWeak(true);

        assertThrows(WeakPasswordException.class, () ->{
            userRegister.register("id", "pw", "email");
        });
    }

    @Test
    void 이미_같은_ID가_존재하면_가입_실패() {
        fakeRepository.save(new User("id", "pw", "email@email.com"));
        assertThrows(DupliException.class, () ->{
            userRegister.register("id", "pw", "email");
        });
    }

    @Test
    void 같은_ID가_없으면_가입_성공() {
        userRegister.register("id", "pw", "email");

        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEamil());
    }

    @Test
    void 가입하면_메일을_발송함() {
        userRegister.register("id", "pw", "email@email.com");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email@email.com", spyEmailNotifier.getEmail());
    }
}

