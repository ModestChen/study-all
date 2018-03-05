package com.hfut.study.common.exception;

/**
 * @Author:chenjia
 * @Description:
 * @Date: Create in 10:59 2017/6/27
 * 定义异常时，需要先确定异常所属模块。例如：添加商户报错 可以定义为 [10020001] 前四位数为账务模块编号，后4位为错误代码 ,唯一
 * acct-账务模块1002
 * abs-基础模块1003
 * netrecv-网上收单模块1004
 * netpay-网上绶收单通道1005
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -5875371379845226068L;


    protected String msg;
    protected int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public BizException(int code, String msgFormat, Object... args){
        super(String.format(msgFormat,args));
        this.code = code;
        this.msg = String.format(msgFormat,args);
    }

    public BizException newInstance(String msgFormate, Object... args){
        return new BizException(this.code,msgFormate,args);
    }

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }


}
