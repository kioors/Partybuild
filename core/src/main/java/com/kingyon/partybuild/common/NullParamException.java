package com.kingyon.partybuild.common;

/**
 * 参数为NULL或不参数不齐全,自定义异常
 */
public class NullParamException extends Exception {

    public NullParamException() {
    }

    public NullParamException(String s) {
        super(s);
    }
}
