package com.wjh.demo.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回数据
 *
 * @author sk
 */
@ApiModel
@Data
public class R<T> {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "结果码", example = "200=成功，500=失败")
    private Integer code;
    @ApiModelProperty(value = "结果标题", example = "success / fail")
    private String title;
    @ApiModelProperty(value = "说明")
    private String msg;
    @ApiModelProperty(value = "返回结果对象")
    private T data;

    public R() {
        //执行结果。200=成功，500=失败
        this(200, "success", "success", null);
    }

    public R(Integer code, String title, String msg) {
        this(code, title, msg, null);
    }

    public R(Integer code, String title, String msg, T retValue) {
        this.code = code;
        this.title = title;
        this.msg = msg;
        this.data = retValue;
    }

    /**
     * @return R
     */
    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    /**
     * @param msg msg
     * @return R
     */
    public static R error(String msg) {
        return error(500, msg);
    }

    /**
     * @param code code
     * @param msg  msg
     * @return R
     */
    public static R error(int code, String msg) {
        R r = new R(code, "fail", msg);
        return r;
    }

    /**
     * @param code code
     * @param
     * @return R
     */
    public static R titleError(int code, String titleMsg) {
        R r = new R(code, titleMsg, "未知异常，请联系管理员");
        return r;
    }

    /**
     * @param msg msg
     * @param map map
     * @return R
     */
    public static R error(String msg, Object map) {
        R r = new R(500, "fail", msg, map);
        return r;
    }

    /**
     * @param msg msg
     * @return R
     */
    public static R ok(String msg) {
        R r = new R();
        r.setData(msg);
        return r;
    }

    /**
     * @param map map
     * @return R
     */
    public static R ok(Object map) {
        R r = new R();
        r.setData(map);
        return r;
    }

    /**
     * @return R
     */
    public static R ok() {
        return new R();
    }
}
