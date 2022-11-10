package study.tdd.mockito;

public class Game {
    private GameNumGen gameNumGen;

    public Game(GameNumGen genMock) {
        this.gameNumGen = genMock;
    }

    public void init(GameLevel easy) {
        this.gameNumGen.generate(easy);
    }
}
