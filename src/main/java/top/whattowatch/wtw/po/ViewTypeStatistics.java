package top.whattowatch.wtw.po;

public class ViewTypeStatistics {
    private Integer vtsid;

    private Integer userid;

    private Integer times;

    private String mtype;

    public Integer getVtsid() {
        return vtsid;
    }

    public void setVtsid(Integer vtsid) {
        this.vtsid = vtsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype == null ? null : mtype.trim();
    }
}