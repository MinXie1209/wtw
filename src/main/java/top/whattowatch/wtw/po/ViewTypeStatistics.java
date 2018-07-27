package top.whattowatch.wtw.po;

public class ViewTypeStatistics {
    private Integer vtsId;

    private String userId;

    private Integer times;

    private String mType;

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

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType == null ? null : mType.trim();
    }
}