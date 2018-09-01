package top.whattowatch.wtw.token;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.whattowatch.wtw.enums.ResultEnum;
import top.whattowatch.wtw.exception.ResultException;
import top.whattowatch.wtw.po.Result;
import top.whattowatch.wtw.utils.TokenManager;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title: CheckToken.java
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 *
 * @author 江南小俊
 * @version 1.0
 * @date 2018年4月8日
 */
@Component
@Aspect
@Configuration
public class CheckToken {
    @Autowired
    TokenManager tokenManager;


    /**
     * 用户登录切点
     */
    @Pointcut("execution (* top.whattowatch.wtw.controller.UserController.login(..))&&"
            + "@annotation(top.whattowatch.wtw.utils.TokenCreated)")
    public void addUserToken() {

    }

    /**
     * 用户登录身份的验证切点
     */

    @Pointcut("execution (* top.whattowatch.wtw.controller.*.*(..))&&" + "@annotation(top.whattowatch.wtw.utils.TokenValid)")
    public void verifyUserToken() {

    }

    /**
     * 用户登录身份的验证
     */
    @Around(value = "verifyUserToken()")
    public Object verifyUser(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = new Object[0];
        args = joinPoint.getArgs();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        if (token == null || userId == null) {
            throw new ResultException(ResultEnum.LOGIN_PLEASE);
        } else {
            Object obj = tokenManager.verifyToken(token, userId);
            if (obj == null) {
                throw new ResultException(ResultEnum.LOGIN_PLEASE);
            }
        }

        return joinPoint.proceed(args);
    }

    /**
     * 对登录方法返回的状态做相关的处理 1.登录成功就生成令牌token，用于调用api的身份验证
     *
     * @param result
     * @return
     */
    @AfterReturning(returning = "result", pointcut = "addUserToken()")
    public @ResponseBody
    Result createUserToken(Result result) {
        if(result.getCode()==1){
            String token=tokenManager.createToken(result.getData().toString());
            Map<String,String> tokenMap=new HashMap<>();
            tokenMap.put("token",token);
            tokenMap.put("userId",result.getData().toString());
            result.setData(tokenMap);
        }
        return result;
    }


}
