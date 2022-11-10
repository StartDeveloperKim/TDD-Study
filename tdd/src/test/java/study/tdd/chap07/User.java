package study.tdd.chap07;

import lombok.Getter;

@Getter
public class User {
    private String id;
    private String password;
    private String eamil;

    public User(String id, String password, String eamil) {
        this.id = id;
        this.password = password;
        this.eamil = eamil;
    }
}
