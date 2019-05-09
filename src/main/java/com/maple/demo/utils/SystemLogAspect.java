package com.maple.demo.utils;

import com.maple.demo.bean.SystemLog;
import com.maple.demo.service.SystemLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * @Aspect 配置切面类，@Component 注解把切面类放入Ioc容器中
 */
@Aspect
@Component
public class SystemLogAspect {

    /**
     * 定义执行开始时间
     */
    private Long startTime;

    /**
     * 定义执行结束时间
     */
    private Long endTime;

    @Autowired
    private SystemLogService systemLogService;

    //定义切点，拦截com.maple.demo.controller下的所有方法
//    @Pointcut("execution(public * com.maple.demo.controller..*.*(..))")
//    public void systemLog (){}

    @Pointcut("@annotation(LogHelper)")
    public void systemLog(){}

    @Around(value = "systemLog()&&@annotation(LogHelper)")
    public Object doAround(ProceedingJoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SystemLog log = new SystemLog();
        startTime = new Date().getTime();
        Object obj;
        try {
            obj = joinPoint.proceed();

            endTime = new Date().getTime();
            log.setRespTime((endTime - startTime) + "");
            log.setSuccess("SUCCESS");
            log.setResults(obj.toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            obj = throwable;

            endTime = new Date().getTime();
            log.setRespTime((endTime - startTime) + "");
            log.setSuccess("FALSE");
            log.setErrorMsg(throwable.toString());
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                log.setAllMethodName(String.valueOf(joinPoint.getSignature()));
                log.setMethodName(joinPoint.getSignature().getName());
                log.setCreateDate(new Date());
                log.setRequestIp(request.getRemoteAddr());
                Map<String, String[]> paramMap = request.getParameterMap();

                //保存参数
                String param = "";
                for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                    String [] flag = entry.getValue();
                    String valueFlag = "";
                    for (String value: flag) {
                        valueFlag = valueFlag + value;
                    }
                    param = String.format("%s%s=%s&", param, entry.getKey(), valueFlag);
                }

                MethodSignature signature=(MethodSignature) joinPoint.getSignature();
                Method method=signature.getMethod();
                LogHelper logHelper = method.getAnnotation(LogHelper.class);
                log.setLogDesc(logHelper.logDesc() + "");
                log.setLogType(logHelper.logType() + "");
                log.setOperationType(logHelper.operType() + "");
                log.setParams(param);

                systemLogService.save(log);
            }
        }).start();
        return obj;
    }
}
