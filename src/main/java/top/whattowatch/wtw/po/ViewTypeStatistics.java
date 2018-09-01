package top.whattowatch.wtw.po;

import java.io.Serializable;

public class ViewTypeStatistics implements Serializable {
    private Integer vtsId;

    private String userId;

    private String mType;

    private Integer times;

    public ViewTypeStatistics(String userId, String type) {
        this.userId = userId;
        this.mType = type;
    }

    public ViewTypeStatistics(Integer vtsId, String userId, String mType, Integer times) {
        this.vtsId = vtsId;
        this.userId = userId;
        this.mType = mType;
        this.times = times;
    }

    public ViewTypeStatistics() {
    }

    public Integer getVtsId() {
        return vtsId;
    }

    public void setVtsId(Integer vtsId) {
        this.vtsId = vtsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType == null ? null : mType.trim();
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}