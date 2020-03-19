package com.paradise.all4me.restful;

/**
 * @author Paradise
 */
public class Rx {

    private static final String SUCCESS_CODE = "200";
    private static final String FAIL_CODE = "500";
    private static final String FORBIDDEN_CODE = "500";
    private static final String FORBIDDEN_MSG = "权限不允许操作";
    private static final String UNAUTHORIZED_CODE = "UNAUTHORIZED_";
    private static final String PERMISSION_DENIED_CODE = "500";
    private static final String UNAUTHORIZED_MSG = "未登录或登录过期，请重新登录";
    private static final String SUCCESS_MSG = "操作成功！";
    private static final String FAIL_MSG = "操作失败！";
    private static final String API_SUCCESS_CODE = "1";
    private static final String API_FAIL_CODE = "0";
    private static final String API_ERROR_CODE = "-1";
    private static final String API_FAIL_MSG = "操作失败！";

    public static <T> R<T> success(T data) {
        return new R<>(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T> R<T> success() {
        return new R<>(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <T> R<T> success(String msg, T data) {
        return new R<>(SUCCESS_CODE, msg, data);
    }

    public static <T> R<T> apiSuccess(String msg, T data) {
        return new R<>(API_SUCCESS_CODE, msg, data);
    }

    public static <T> R<T> apiFail(String msg, T data) {
        return new R<>(API_FAIL_CODE, msg, data);
    }

    public static <T> R<T> apiFail(String msg) {
        return new R<>(API_FAIL_CODE, msg, null);
    }

    public static <T> R<T> permissionDenied() {
        return new R<>(PERMISSION_DENIED_CODE, "没有访问权限", null);
    }

    public static <T> R<T> apiError(String msg, T data) {
        return new R<>(API_ERROR_CODE, msg, data);
    }

    public static <T> R<T> error(String code, String msg) {
        return new R<>(code, msg, null);
    }

    public static <T> R<T> error(String msg) {
        return new R<>(FAIL_CODE, msg, null);
    }

    public static <T> R<T> error(String msg, T data) {
        return new R<>(FAIL_CODE, msg, data);
    }

    public static <T> R<T> error(String code, String msg, T data) {
        return new R<>(code, msg, data);
    }

    public static <T> R<T> fail() {
        return fail(FAIL_MSG);
    }

    public static <T> R<T> forbidden(T data) {
        return new R<>(FORBIDDEN_CODE, FORBIDDEN_MSG, data);
    }

    public static <T> R<T> unauthorized(T data) {
        return new R<>(UNAUTHORIZED_CODE, UNAUTHORIZED_MSG, data);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(FAIL_CODE, msg, null);
    }

    public static boolean isSuccess(R<Object> r) {
        return SUCCESS_CODE.equals(r.getCode());
    }

    public static boolean isApiSuccess(R<Object> r) {
        return API_SUCCESS_CODE.equals(r.getCode());
    }
}
