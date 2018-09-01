package top.whattowatch.wtw.po;

import java.io.Serializable;

/**
 * @Auther: JNXJ
 * @Date: 2018/8/30 20:33
 * @Description:
 */
public class WeChatApplet implements Serializable {
    private String sessionKey;//会话秘钥
    private Integer expiresIn;//生存时间
    private String openid;//唯一标识
    private Integer errcode;//錯誤碼
    private String errmsg;//錯誤信息
    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "WeChatApplet{" +
                "sessionKey='" + sessionKey + '\'' +
                ", expiresIn=" + expiresIn +
                ", openid='" + openid + '\'' +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
