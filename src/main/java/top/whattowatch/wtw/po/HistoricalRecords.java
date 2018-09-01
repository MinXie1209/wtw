package top.whattowatch.wtw.po;

import java.io.Serializable;
import java.util.Date;

public class HistoricalRecords implements Serializable {
    private Integer hrId;

    private String userId;

    private String mTitle;

    private Date time;

    public HistoricalRecords(String userId, String mTitle) {
        this.userId = userId;
        this.mTitle = mTitle;
    }

    public HistoricalRecords(Integer hrId, String userId, String mTitle, Date time) {
        this.hrId = hrId;
        this.userId = userId;
        this.mTitle = mTitle;
        this.time = time;
    }

    public HistoricalRecords() {
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle == null ? null : mTitle.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}