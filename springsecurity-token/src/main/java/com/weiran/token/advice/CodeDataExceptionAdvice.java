package com.weiran.token.advice;

import com.weiran.token.exception.CodeMsgException;
import com.weiran.token.response.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CodeDataExceptionAdvice {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(CodeMsgException.class)
    public ResultVO nonceExpiredException(CodeMsgException exception) {
        return ResultVO.fail(exception.getCode(),exception.getMsg());
    }

}
