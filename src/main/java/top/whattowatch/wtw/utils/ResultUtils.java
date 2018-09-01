package top.whattowatch.wtw.utils;


import top.whattowatch.wtw.enums.ResultEnum;
import top.whattowatch.wtw.po.Result;

/**
 * @author 江南小俊
 * @create 2018-06-17 17:15
 * @desc 封装返回数据
 **/
public class ResultUtils {
    public static Result success(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static Result success(Object data) {
        return new Result(data);
    }

    public static Result success(Integer code, String msg, Object data) {
        return new Result(code, msg, data);

    }

    public static Result success(ResultEnum resultEnum) {
        return success(resultEnum.getCode(), resultEnum.getMsg());
    }
    public static Result success(ResultEnum resultEnum, Object obj) {
        return success(resultEnum.getCode(), resultEnum.getMsg(),obj);
    }
    public static Result error(Integer code, String msg) {
        return new Result(code, msg);
    }


    public static Result success() {
        return new Result();
    }

    public static Result error(String message) {
        return new Result(-1, message, null);
    }

    public static Result error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMsg());
    }


}
