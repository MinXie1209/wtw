package top.whattowatch.wtw.po;

public class ViewTypeStatistics {
    private Integer vtsId;

    private Integer userId;

    private Integer times;

    private String mType;

    public Integer getVtsId() {
        return vtsId;
    }

    public void setVtsId(Integer vtsId) {
        this.vtsId = vtsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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