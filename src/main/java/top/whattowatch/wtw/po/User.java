package top.whattowatch.wtw.po;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;

    private String nickname;

    public User(String openid) {
        this.userId=openid;
    }

    public User(String userId, String nickname) {
        this.userId = userId;
        this.nickname = nickname;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
}