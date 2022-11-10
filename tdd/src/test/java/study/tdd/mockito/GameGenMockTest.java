package study.tdd.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {

    @Test
    void mockTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(GameLevel.EASY)).willReturn("123");
        // generate 인자로 EASY를 넘겨준다면 123을 반환할 것이다. 라는 행위를 설정하였다.

        String num = genMock.generate(GameLevel.EASY); // 123반환
        assertEquals("123", num);  // 동일한지 확인
    }

    @Test
    void mockThrowTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(null)).willThrow(IllegalArgumentException.class);

        assertThrows(
                IllegalArgumentException.class,
                () -> genMock.generate(null)
        );
    }
}
