package com.jw.device.exception;



import com.jw.device.constant.ResCode;
import com.jw.device.units.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  异常统一处理
 */
@ControllerAdvice
public class ExceptionUnityHandler {

    private  final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * CredentitalsException 凭证异常
     *        IncorrectCredentialsException 不正确的凭证
     *        ExpiredCredentialsException 凭证过期
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler({MyException.class})
    public BaseResponse MyExceptionHandler(MyException ex) {
        return new BaseResponse(ResCode.FAIL.getCode(), ex.getMessage());
    }

}
