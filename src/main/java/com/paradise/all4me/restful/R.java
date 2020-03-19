package com.paradise.all4me.restful;

import lombok.Data;

/**
 * 封装的返回结果对象
 *
 * @author Paradise
 */
@Data
public class R<T> {
    private String code;
    private String msg;
    private T data;

    private R() {
    }

    R(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
