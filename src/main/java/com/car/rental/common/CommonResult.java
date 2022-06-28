package com.car.rental.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResult {

    /** 状态码 */
    private int code;

    private String msg;

    private Object data;


    public CommonResult(Type type, String msg) {
        this.code = type.value;
        this.msg = msg;
    }


    public CommonResult(Type type, String msg, Object data) {
        this.code = type.value;
        this.msg = msg;
        if (data != null) {
            this.data = data;
        }
    }


    public static CommonResult success() {
        return CommonResult.success("success");
    }


    public static CommonResult success(Object data) {
        return CommonResult.success("success", data);
    }


    public static CommonResult success(String msg) {
        return CommonResult.success(msg, null);
    }

    public static CommonResult success(String msg, Object data) {
        return new CommonResult(Type.SUCCESS, msg, data);
    }


    public static CommonResult error() {
        return CommonResult.error("fail");
    }


    public static CommonResult error(String msg) {
        return CommonResult.error(msg, null);
    }

    /**
     * 返回错误消息
     * @param msg 返回内容
     * @param data 数据对象
     * @return 错误消息
     */
    public static CommonResult error(String msg, Object data) {
        return new CommonResult(Type.ERROR, msg, data);
    }

    /**
     * 状态类型
     */
    public enum Type {
        /** success */
        SUCCESS(200),
        /** error */
        ERROR(500);
        private final int value;

        Type(int value){
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
}
