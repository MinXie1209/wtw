package top.whattowatch.wtw.enums;

/**
 * 返回数据
 */
public enum ResultEnum {
    UN_ERROR(-1, "未知错误"),
    SUCCESS(1, "成功"),
    ERROR(10000, "没有找到api"),
    NULL_USER(10001, "没有此用户"),
    ERROR_CODE(10002, "錯誤的code"),
    LOGIN_PLEASE(10003, "请登录"),
    NOT_VIEWMOVIES(10004, "你没有观影记录"),
    NOT_MOVIE(10005, "没有此电影信息"), NOT_MOVIEBYTITLE(10006,"没有你要查找的电影" );


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
