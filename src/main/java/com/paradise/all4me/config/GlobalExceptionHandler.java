package com.paradise.all4me.config;

import com.paradise.all4me.restful.R;
import com.paradise.all4me.restful.Rx;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * @author Paradise
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public R<Object> constraintViolationException(ConstraintViolationException e) {
        return Rx.error("400", e.getConstraintViolations().iterator().next().getMessage());
    }

    /**
     * 对方法上@RequestBody的Bean参数校验的处理
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        return ResponseEntity.ok(Rx.error("400", ex.getBindingResult().getAllErrors().get(0).getDefaultMessage()));
    }

    /**
     * 对方法的Form提交参数绑定校验的处理
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex,
                                                         HttpHeaders headers,
                                                         HttpStatus status,
                                                         WebRequest request) {
        return ResponseEntity.ok(Rx.error("400",
                ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                ex.getAllErrors().get(0).toString()));
    }

    /**
     * 全局异常处理
     *
     * @return {@linkplain R}
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R<String> handleException(Exception e) {
        logger.error(e.getLocalizedMessage(), e);
        String detailMessage = resolveException(e);
        return Rx.error("500", e.toString(), detailMessage);
    }

    /**
     * 全局异常处理
     *
     * @return {@linkplain R}
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public R<Object> handleAccessDeniedException(AccessDeniedException e) {
        logger.error(e.getLocalizedMessage());
        return Rx.forbidden(null);
    }


    /**
     * 处理 spring assert 判断 异常
     *
     * @param e IllegalArgumentException
     * @return R
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public R<String> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.error(e.getMessage());
        return Rx.error("400", e.getLocalizedMessage(), e.getMessage());
    }

    private String resolveException(Exception e) {
        if (e.getMessage() == null) {
            StringBuilder builder = new StringBuilder();
            StackTraceElement[] elements = e.getStackTrace();
            if (elements.length > 0) {
                for (int x = 0; x < 3; x++) {
                    StackTraceElement element = elements[x];
                    builder.append(element.getFileName()).append("  ")
                            .append(element.getMethodName()).append("  ")
                            .append(element.getLineNumber());
                }
            }
            return builder.toString();
        }
        return e.getMessage();
    }

}
