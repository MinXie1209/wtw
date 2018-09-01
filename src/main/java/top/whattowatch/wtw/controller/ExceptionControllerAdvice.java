package top.whattowatch.wtw.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.whattowatch.wtw.exception.ResultException;
import top.whattowatch.wtw.po.Result;
import top.whattowatch.wtw.utils.ResultUtils;


/**
 * @author 江南小俊
 * @create 2018-06-17 17:37
 * @desc 控制器增强类-异常统一处理
 **/
@ControllerAdvice
public class ExceptionControllerAdvice {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e) {

        if (e instanceof ResultException) {
            return ResultUtils.error(((ResultException) e).getCode(),e.getMessage());
        } else {
            System.out.println(e.getClass().getName());
            logger.info("系统错误",e);

            return ResultUtils.error(e.getMessage());
        }

    }
}
